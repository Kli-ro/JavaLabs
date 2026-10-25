package Lab7.task2;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class ReaderWriter {
    public static void main(String[] args) {
        System.out.println("Чтение по строкам");
        // писать открытие файла для работы нужно внутри try() или добавть finally(конец после catch), иначе автом закроется
        try(FileInputStream openFile = new FileInputStream("course.txt");

        // translation byte to symbs
        InputStreamReader pasteFile = new InputStreamReader(openFile, StandardCharsets.UTF_8);

        // reading symbs
        BufferedReader readerFile = new BufferedReader(pasteFile)) {
            // reading file content
            String contentFile;
            while ((contentFile = readerFile.readLine()) != null) {
                System.out.println(contentFile);
            }

        } catch (IOException ex) {
            ex.printStackTrace();
            System.out.println("Ошибка чтения файла");
        }
        System.out.println("Чтение по символам");

        try(FileInputStream openFile = new FileInputStream("course.txt");
        InputStreamReader pasteFile = new InputStreamReader(openFile, StandardCharsets.UTF_8);
        BufferedReader readerFile = new BufferedReader(pasteFile)) {

            int charSymb;
            while ((charSymb = readerFile.read()) != -1) {
                char symb = (char) charSymb;
                System.out.print(symb);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
            System.out.println("Ошибка чтения файла");
        }


        //      часть writer
        try(FileOutputStream openFile = new FileOutputStream("output.txt");
        OutputStreamWriter pasteFile = new OutputStreamWriter(openFile, StandardCharsets.UTF_8);
        BufferedWriter writerFile = new BufferedWriter(pasteFile)) {
            writerFile.write("Метод записи строки в файл");
        } catch (IOException ex) {
            ex.printStackTrace();
            System.out.println("Ошибка записи содержимого в файл");
        }
        System.out.println("Текст успешно записан в файл");

    }
}
