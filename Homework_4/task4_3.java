package Homework_4;

import java.util.Scanner;
import java.util.Stack;
import java.util.logging.*;
import java.io.IOException;

public class task4_3 {
    public static void main(String[] args) throws IOException {
        System.out.println("Простой калькулятор на 1 действие c логированием\n");

        Logger logger = Logger.getLogger(task4_3.class.getName());
        logger.setLevel(Level.INFO);
        FileHandler fh = new FileHandler("Homework_4\\log.xml", true);
        logger.addHandler(fh);
        XMLFormatter xml = new XMLFormatter();
        fh.setFormatter(xml);

        System.out.print("Введите выражение состоящее из 1 действия: ");
        Scanner sc = new Scanner(System.in, "cp866");
        String example = sc.nextLine();
        logger.info("user entered " + example);
        // sc.close();
        Stack<Double> overall = new Stack<Double>();

        boolean isok = false;
        int sign = 0;
        example = example.replace(" ", "");

        sign = Sign(example);

        if (sign > 0 && sign < 5)
            isok = true;

        double result = 0;
        String[] example_devided = example.split("[+]|-|/|[*]");
        if (example_devided.length != 2)
            isok = false;
        if (isok) {
            Double val_1 = Double.parseDouble(example_devided[0]), val_2 = Double.parseDouble(example_devided[1]);
            switch (sign) {
                case 1:
                    result = val_1 + val_2;
                    overall.add(result);
                    System.out.println(overall.peek() + " в стеке");
                    break;
                case 2:
                    result = val_1 - val_2;
                    overall.add(result);
                    System.out.println(overall.peek() + " в стеке");
                    break;
                case 3:
                    result = val_1 / val_2;
                    overall.add(result);
                    System.out.println(overall.peek() + " в стеке");
                    break;
                case 4:
                    result = val_1 * val_2;
                    overall.add(result);
                    System.out.println(overall.peek() + " в стеке");
                    break;
            }

            if ((result - (int) result) == 0) {
                System.out.printf("\nОтвет = %d\n", (int) result);
                logger.info("Result = " + (int) result);
            } else {
                System.out.printf("\nОтвет = %f\n", result);
                logger.info("Result = " + result);
            }
        } else {
            System.out.println("Проверьте правильность выражения.");
            logger.log(Level.WARNING, "User entered wrong example");
        }

        isok = false;
        boolean exit = false;
        // Scanner sc = new Scanner(System.in, "cp866");
        while (!exit) {

            System.out.print(
                    "\nВведите дополнительную операцию в формате +1 *2 или Отмену для возврата к предыдущему значению: ");
            String new_example2 = sc.nextLine();
            System.out.println(new_example2 + " Введено");
            switch (new_example2) {
                case "Отмена":
                    overall.pop();
                    if (!overall.isEmpty()) {                        
                        System.out.println("Удаляем последнюю операцию");
                        // System.out.println(overall.peek() + " в стеке");
                        result = overall.peek();
                        if ((result - (int) result) == 0) {
                            System.out.printf("\nТекущий результат = %d\n", (int) result);
                            logger.info("Deleting last example. Current result = " + (int) result);
                        } else {
                            System.out.printf("\nТекущий результат = %f\n", result);
                            logger.info("Deleting last example. Current result = " + result);
                        }
                    }
                    else {
                        overall.add(result);
                        System.out.println("Вы достигли дна стека");
                        logger.info("Users reaches the bottom of the stack");
                    }
                    break;
                case "Выход":
                    sc.close();
                    logger.info("User exits the program");
                    exit = true;
                    break;
                default:
                    new_example2 = new_example2.replace(" ", "");
                    sign = Sign(new_example2);
                    if (sign > 0 && sign < 5)
                        isok = true;
                    String[] example_devided2 = new_example2.split("[+]|-|/|[*]");
                    if (isok) {
                        Double val_3 = Double.parseDouble(example_devided2[1]);
                        switch (sign) {
                            case 1:
                                System.out.println(val_3 + " val_3");
                                result = overall.peek() + val_3;
                                overall.add(result);
                                System.out.println(overall.peek() + " в стеке");
                                break;
                            case 2:
                                System.out.println(val_3 + " val_3");
                                result = overall.peek() - val_3;
                                overall.add(result);
                                System.out.println(overall.peek() + " в стеке");
                                break;
                            case 3:
                                System.out.println(val_3 + " val_3");
                                result = overall.peek() / val_3;
                                overall.add(result);
                                System.out.println(overall.peek() + " в стеке");
                                break;
                            case 4:
                                System.out.println(val_3 + " val_3");
                                result = overall.peek() * val_3;
                                overall.add(result);
                                System.out.println(overall.peek() + " в стеке");
                                break;
                        }
                    }

                    if ((result - (int) result) == 0) {
                        System.out.printf("\nОтвет = %d\n", (int) result);
                        logger.info("Result = " + (int) result);
                    } else {
                        System.out.printf("\nОтвет = %f\n", result);
                        logger.info("Result = " + result);
                    }
                    break;
            }

        }
        sc.close();

    }

    // public static void ShowResult(double result, Logger logger) {
    // overall.add(result);
    // if ((result - (int) result) == 0) {
    // System.out.printf("\nОтвет = %d\n", (int) result);
    // logger.info("Result = " + (int) result);
    // } else {
    // System.out.printf("\nОтвет = %f\n", result);
    // logger.info("Result = " + result);
    // }
    // }

    public static int Sign(String msg) {
        int sign = 0;
        for (int i = 0; i < msg.length(); i++) {
            switch (msg.charAt(i)) {
                case '+':
                    sign = 1;
                    break;
                case '-':
                    sign = 2;
                    break;
                case '/':
                    sign = 3;
                    break;
                case '*':
                    sign = 4;
                    break;
            }
        }
        return sign;

    }
}
