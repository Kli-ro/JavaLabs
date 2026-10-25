package Lab7.task5;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class BinaryFormat {
    public static void main(String[] args) {
        int bin_num = 123456;
        int version = 1;
        int count = 3;
        String fileName = "binary_data.bin";

        try (FileOutputStream openFileWrite = new FileOutputStream(fileName);
             BufferedOutputStream bufferWrite = new BufferedOutputStream(openFileWrite);
             DataOutputStream pasteWrite = new DataOutputStream(bufferWrite)) {

            pasteWrite.writeInt(bin_num);
            pasteWrite.writeInt(version);
            pasteWrite.writeInt(count);

            for (int i = 1; i <= count; i++) {
                pasteWrite.writeUTF("Запись номер " + i);
                pasteWrite.writeInt(i * 100);
            }
            System.out.println("Запись в файл завершена");

        } catch (IOException ex) {
            System.out.println("Ошибка при записи: " + ex.getMessage());
        }

        try (FileInputStream openFileRead = new FileInputStream(fileName);
             BufferedInputStream bufferRead = new BufferedInputStream(openFileRead);
             DataInputStream pasteRead = new DataInputStream(bufferRead)) {

            int readBinNum = pasteRead.readInt();
            if (readBinNum != bin_num) {
                throw new RuntimeException("Неверный формат файла");
            }

            int readVersion = pasteRead.readInt();
            if (readVersion > version) {
                throw new RuntimeException("Неизвестная версия файла: " + readVersion);
            }

            int readCount = pasteRead.readInt();

            for (int i = 1; i <= readCount; i++) {
                String text = pasteRead.readUTF();
                int number = pasteRead.readInt();
                System.out.println("Прочитано: " + text + " Число: " + number);
            }
            System.out.println("Чтение завершено");

        } catch (EOFException ex) {
            System.out.println("Файл обрезан");
        } catch (IOException ex) {
            System.out.println("Ошибка ввода/вывода файла: " + ex.getMessage());
        } catch (RuntimeException ex) {
            System.out.println("Ошибка: " + ex.getMessage());
        }
    }
}