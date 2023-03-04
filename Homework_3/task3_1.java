package Homework_3;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class task3_1 {
    public static void main(String[] args) {
        System.out.println("\nПрограмма удаляет из списка четные числа\n");
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите последовательность чисел разделяя из пробелом: ");
        String msg = sc.nextLine();
        String[] arr_str = msg.split(" ");
        ArrayList<Integer> lst = new ArrayList<Integer>();
        for (String item : arr_str) {
            try {
                lst.add(Integer.parseInt(item));          
            } catch (NumberFormatException e) {
                continue;
            }    
        }
        
        Iterator it = lst.iterator();

        while (it.hasNext()) {
            if ((int) it.next() % 2 == 0)
                it.remove();
        }

        System.out.print("Список после удаления четных чисел: ");
        System.out.print(lst);
    }
    
}
