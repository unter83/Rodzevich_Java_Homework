package Homework_2;

import java.util.Scanner;

public class task2_1 {
    
    public static void main(String[] args) {
        System.out.println("Программа производит пузырьковую сортировку для строки чисел.\n");
        System.out.print("Введите последовательность чисел: ");
        Scanner sc = new Scanner(System.in);
            String msg = sc.nextLine();
        sc.close();
        // String msg="654215743347";
        String msg2 = Sort(msg);
        System.out.println(msg2);
    }

    public static String Sort(String msg) {
        StringBuilder new_msg = new StringBuilder();
        char temp;     
        char[] array = msg.toCharArray();
        for (int i = 0; i < array.length; i++)
            for (int j = i + 1; j < array.length; j++)
                if (Character.getNumericValue(array[j]) < Character.getNumericValue(array[i])) {
                    temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }      
        for (char item : array)
            new_msg.append(item);

        return new_msg.toString();
    }
}
