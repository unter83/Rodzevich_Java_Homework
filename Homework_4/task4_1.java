package Homework_4;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class task4_1 {
    public static void main(String[] args) {
        System.out.println("\nПрограмма реализует не void метод возвращающий перевернутый список организованный Linkedlist'ом\n");
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите последовательность разделяя из пробелом: ");
        String msg = sc.nextLine();
        String[] arr_str = msg.split(" ");
        LinkedList ll = new LinkedList<>(Arrays.asList(arr_str));
        ll =  ReverseLL(ll);
        for (Object item : ll) {
            System.out.print(item + " ");
        }
        
    }

    public static LinkedList ReverseLL(LinkedList ll) {
        LinkedList rll = new LinkedList<>();
        for(Object item : ll) {
            rll.addFirst(item);
        }
        return rll;
    }

}
