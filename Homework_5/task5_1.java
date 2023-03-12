package Homework_5;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class task5_1 {
    public static void main(String[] args) {
        boolean exit = false;
        System.out.println("\n Програма реализует структуру телефонной книги с помощью HashMap");

        while (!exit) {
            try {
                Scanner sc = new Scanner(System.in);
                System.out.println("Выберите действие:");
                System.out.println("1 - Добавить телефон");
                System.out.println("2 - Показать телефоны");
                System.out.println("3 - Выход");
                System.out.print("Выберите номер опции: ");
                int func = sc.nextInt();
                switch (func) {
                    case 1:
                        AddPhone();
                        break;
                    case 2:
                        ShowPhones();
                        break;
                    case 3:
                        exit = true;
                        System.out.println("Выходим...");
                        sc.close();
                        break;
                    default:
                        System.out.println("Нет такой опции");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Введите числовое значение");
            }
        }

    }

    public static void AddPhone() {
        System.out.println("\nВведите фамилию и номер паспорта или \"Выход\" чтобы выйти на уровень вверх: ");
        String file_name = "\\Homework_5\\phone_db.txt";
        String pathProject = System.getProperty("user.dir");
        String pathFile = pathProject.concat(file_name);
        File file = new File(pathFile);
        if (file.isFile()) {
            boolean exit = false;
            Scanner sc2 = new Scanner(System.in, "cp866");
            Map<Integer, String> db = new HashMap<Integer, String>();
            Map<Integer, String> db2 = new HashMap<Integer, String>();

            try {
                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(new FileInputStream(pathFile), "UTF-8"));
                while (reader.ready()) {
                    String[] line = reader.readLine().split(";");
                    db.put(Integer.parseInt(line[1]), line[0]);
                }
                reader.close();
                System.out.println(db);
            } catch (Exception e) {
                System.out.println("\nПроизошла ошибка! ");
                System.out.println("Поднимаемся на уровень вверх...");
                return;
            }

            while (!exit) {
                System.out.print("Введите фамилию: ");
                String s_name = sc2.nextLine();
                if (s_name.equals("Выход") ||
                        s_name.equals("выход")) {
                    exit = true;
                    System.out.println("\nПоднимаемся на уровень вверх...");
                    return;
                }

                boolean exit2 = false;
                while (!exit2) {
                    System.out.print("Введите номер телефона: ");
                    String phone = sc2.nextLine();
                    if (phone.equals("Выход") ||
                            phone.equals("выход")) {
                        System.out.println("\nПоднимаемся на уровень вверх...");
                        exit = true;
                        exit2 = true;
                        return;
                    }

                    try {
                        int phone_num = Integer.parseInt(phone);
                        if (!db.containsKey(phone_num)) {
                            exit2 = true;                            
                            db2.put(phone_num, s_name);                            
                            try {
                                FileOutputStream fileOutputStream = new FileOutputStream(pathFile, true);
                                Writer writer = new OutputStreamWriter(fileOutputStream, StandardCharsets.UTF_8);
                                for (Map.Entry item : db2.entrySet()) {
                                    writer.append("\n");
                                    writer.append(item.getValue() + ";" + item.getKey() + ";");
                                }
                                writer.close();
                            } catch (Exception e) {
                                System.out.println("Ошибка");
                            }

                        } else {
                            System.out.println("Номер телефона уже обнаружен в базе");
                            exit2 = false;
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Номер телефона должен только цифры");
                        exit2 = false;
                    }
                }
            }
        } else
            try {
                file.createNewFile();
            } catch (IOException e) {
                System.out.printf("Фаил %s создан. \n", pathFile);
            }
    }

    public static void ShowPhones() {
        System.out.println("\nВывод телефонов и их владельцев: ");

        String file_name = "\\Homework_5\\phone_db.txt";
        String pathProject = System.getProperty("user.dir");
        String pathFile = pathProject.concat(file_name);
        File file = new File(pathFile);
        if (file.isFile()) {

        } else
            System.out.println("Файл не найден");

        Map<String, String> db = new HashMap<String, String>();
        Map<String, String> db2 = new HashMap<String, String>();

        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(pathFile), "UTF-8"));
            while (reader.ready()) {
                String[] line = reader.readLine().split(";");
                db.put(line[1], line[0]);
            }
            reader.close();

            for (Map.Entry item : db.entrySet()) {
                if (db2.containsKey(item.getValue())) {
                    String s_name = String.valueOf(item.getValue());
                    String phone = String.valueOf(item.getKey());
                    String added_phone = db2.get(s_name) + "\n" + phone;
                    db2.put(String.valueOf(item.getValue()), added_phone);
                } else
                    db2.put(String.valueOf(item.getValue()), String.valueOf(item.getKey()));

            }

            for (Map.Entry item : db2.entrySet()) {
                System.out.println(item.getKey() + ":");
                System.out.println(item.getValue() + "\n");
            }

        } catch (Exception e) {
            System.out.println("\nПроизошла ошибка! ");
            System.out.println("Поднимаемся на уровень вверх...");
            return;
        }

    }

}
