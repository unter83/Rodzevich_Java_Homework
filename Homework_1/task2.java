package Homework_1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class task2 {
    private static Integer[] append(Integer[] array, int element)
    {
        List<Integer> list = new ArrayList<>(Arrays.asList(array));
        list.add(element);
 
        return list.toArray(new Integer[0]);
    }
    
    public static void main(String[] args) {
        int max = 1000;
        boolean is_simp;
        System.out.println("The program shows all simple numbers from 1 to 1000\n");
        Integer[] simple_nums = {2};
        System.out.printf("%d ", simple_nums[0]);
        for (int i = 3; i < max; i+=2) {
            is_simp = false;                       
            for (int elem : simple_nums)                 
                if (i % elem == 0)  {
                    is_simp = true;              
                    break;
                }
            if (is_simp == false) {
                simple_nums = append(simple_nums, i);
                System.out.printf("%d ", i);
            }
        }

    }
}
