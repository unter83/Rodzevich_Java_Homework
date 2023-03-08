package Homework_4;

import java.lang.ProcessBuilder.Redirect.Type;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class task4_2 {
    public static void main(String[] args) {
        System.out.println("\nПрограмма реализует очередь с помощью Linkedlist и реализует 3 команды:");
        System.out.println("1. помещает элементы в конец очереди");
        System.out.println("2. denqueue - возвращает первый элемент из очереди и удаляет его");
        System.out.println("3. first - возвращает первый элемент из очереди, не удаляя");
        System.out.println("4. print - возвращает все элементы всей очереди");
        System.out.println("4. exit - выход");

        String command = "";
        Queue ll = new LinkedList<>();
        boolean exit = false; 
        while (exit == false) {
            System.out.print("Введите элементы очереди или команду: ");
            Scanner sc = new Scanner(System.in, "cp866");
            String msg = sc.nextLine();
            String[] msg_arr = msg.split(" ");
            command = msg_arr[0];
            switch (command) {
                case "first": {
                    System.out.println(ll.peek());
                    break;
                }
                case "denqueue": {
                    System.out.println(ll.remove());                
                    break;
                }
                case "print": {
                    PrintQueue(ll);               
                    break;
                }
                case "exit":
                {
                    exit = true;
                    break; 
                }
                default: {
                    ll =  AddToQueue(msg_arr, ll);            
                    break;                    
                }
            }
            sc.close();
        } 
         

    }

    public static Queue AddToQueue(String[] array, Queue ll) {   
        for (int i = 0; i < array.length; i++) {
            ll.add(array[i]);
        }
        return ll;            
    }

    public static void PrintQueue(Queue ll) {
        for (Object item : ll) {
            System.out.print(item + " ");        
        }
        System.out.println();

    }

}
