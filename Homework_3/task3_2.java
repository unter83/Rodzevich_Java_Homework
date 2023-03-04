package Homework_3;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Collections;

public class task3_2 {
    public static void main(String[] args) {
        System.out.println("\nПрограмма находит минимальное, максимальное и среднее арифметическое в списке\n");

        List<Integer> lst = new ArrayList<Integer>();
        Random rnd = new Random();

        for (int index = 0; index < 10; index++) {
            lst.add(rnd.nextInt(100));
        }
        System.out.println(lst);

        int min = lst.get(0);
        int max = lst.get(0);
        int sum = 0;

        for (Integer index : lst) {
            if (index < min)
                min = index;
            if (index > max)
                max = index;
            sum += index;
        }

        System.out.println("Минимальное значение " + min);
        System.out.println("Максимальное значение " + max);
        System.out.println("Среднее значение " + (double) sum /lst.size());
        
    }
}
