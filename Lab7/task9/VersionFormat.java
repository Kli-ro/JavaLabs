package Lab7.task9;

import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.CRC32;

public class VersionFormat {
    private static final int MAGIC = 0xCAFE;
    private static final int CURRENT_VERSION = 2;

    public static void main(String[] args) {
        String fileName = "versioned_catalog.bin";

        List<CatalogEntry> original = new ArrayList<>();
        original.add(new CatalogEntry("Java", 120, "Advanced"));
        original.add(new CatalogEntry("Python", 80, "Beginner"));
        original.add(new CatalogEntry("C++", 150, "Advanced"));

        writeCatalog(fileName, 1, original);
        System.out.println("Запись версии 1 завершена");

        List<CatalogEntry> fromV1 = readCatalog(fileName);
        System.out.println("Прочитано из версии 1 (после миграции):");
        for (CatalogEntry entry : fromV1) {
            System.out.println("  " + entry);
        }

        writeCatalog(fileName, 2, original);
        System.out.println("Запись версии 2 завершена.");

        List<CatalogEntry> fromV2 = readCatalog(fileName);
        System.out.println("Прочитано из версии 2:");
        for (CatalogEntry entry : fromV2) {
            System.out.println("  " + entry);
        }
    }

    public static void writeCatalog(String fileName, int version, List<CatalogEntry> entries) {
        try (FileOutputStream openFileWrite = new FileOutputStream(fileName);
             DataOutputStream pasteWrite = new DataOutputStream(openFileWrite)) {

            ByteArrayOutputStream payloadBuffer = new ByteArrayOutputStream();
            DataOutputStream payloadWrite = new DataOutputStream(payloadBuffer);

            payloadWrite.writeInt(entries.size());
            for (CatalogEntry entry : entries) {
                payloadWrite.writeUTF(entry.getName());
                payloadWrite.writeInt(entry.getHours());
                if (version >= 2) {
                    payloadWrite.writeUTF(entry.getLevel());
                }
            }
            payloadWrite.flush();

            byte[] payload = payloadBuffer.toByteArray();

            CRC32 crc = new CRC32();
            crc.update(payload);
            long checksum = crc.getValue();

            pasteWrite.writeInt(MAGIC);
            pasteWrite.writeInt(version);
            pasteWrite.writeLong(checksum);
            pasteWrite.writeInt(payload.length);
            pasteWrite.write(payload);

            System.out.println("Файл записан: version=" + version + ", checksum=" + checksum + ", payloadSize=" + payload.length);

        } catch (IOException ex) {
            System.out.println("Ошибка записи: " + ex.getMessage());
        }
    }

    public static List<CatalogEntry> readCatalog(String fileName) {
        List<CatalogEntry> result = new ArrayList<>();

        try (FileInputStream openFileRead = new FileInputStream(fileName);
             DataInputStream pasteRead = new DataInputStream(openFileRead)) {

            int magic = pasteRead.readInt();
            if (magic != MAGIC) {
                throw new RuntimeException("Неверный magic header");
            }

            int version = pasteRead.readInt();
            if (version > CURRENT_VERSION) {
                throw new RuntimeException("Неизвестная будущая версия: " + version);
            }

            long expectedChecksum = pasteRead.readLong();
            int payloadSize = pasteRead.readInt();

            byte[] payload = new byte[payloadSize];
            pasteRead.readFully(payload);

            CRC32 crc = new CRC32();
            crc.update(payload);
            long actualChecksum = crc.getValue();

            if (actualChecksum != expectedChecksum) {
                throw new RuntimeException("Checksum не совпал: данные повреждены");
            }

            DataInputStream payloadRead = new DataInputStream(new java.io.ByteArrayInputStream(payload));
            int count = payloadRead.readInt();

            for (int i = 0; i < count; i++) {
                String name = payloadRead.readUTF();
                int hours = payloadRead.readInt();
                String level;

                if (version >= 2) {
                    level = payloadRead.readUTF();
                } else {
                    level = "Unknown";
                }

                result.add(new CatalogEntry(name, hours, level));
            }

        } catch (EOFException ex) {
            throw new RuntimeException("Файл обрезан", ex);
        } catch (IOException ex) {
            throw new RuntimeException("Ошибка чтения: " + ex.getMessage(), ex);
        }

        return result;
    }
}