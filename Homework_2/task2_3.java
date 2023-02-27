package Homework_2;

import java.util.Scanner;

public class task2_3 {
    public static void main(String[] args) {
        System.out.println("Программа строку является ли она палиндромом\n");
        System.out.print("Введите строку: ");
        Scanner sc = new Scanner(System.in,"cp866");
            String msg = sc.nextLine();
        sc.close();  
        if (isPolindrom(msg))
            System.out.println("Строка является полиндром");
        else
            System.out.println("Строка не является полиндром");
    }
    
    public static boolean isPolindrom(String msg) {
        String msg2;
        String msg3;
        if (msg.length() % 2 == 0) {
            msg2 = msg.substring(0, msg.length()/2);
            msg3 = new StringBuilder(msg.substring(msg.length()/2, msg.length())).reverse().toString();
       }
        else {
            msg2 = msg.substring(0, msg.length()/2);
            msg3 = new StringBuilder(msg.substring(msg.length()/2 + 1, msg.length())).reverse().toString();
        }
        if (msg2.equals(msg3))
            return true;
        else
            return false;
    }

    
}
