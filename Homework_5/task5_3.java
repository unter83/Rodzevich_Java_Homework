package Homework_5;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class task5_3 {
    public static void main(String[] args) {
        System.out.println("\nПрограмма расставляет 8 ферзей на шахматной даске так чтобы они не били друг друга");
        char[][] ch = new char[8][8];
        Random rnd = new Random();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                ch[i][j] = '.';
                System.out.print(ch[i][j] + "  ");
            }  
            System.out.println();           
        }
        int f = 8;
        while(f > 0) {
            boolean find_f = false;
            int put_i = rnd.nextInt(8);
            int put_j = rnd.nextInt(8);

            for (int i = put_i; i < 8; i++) {
                if (ch[i][put_j] == '#') {
                    find_f = true;
                }
            }
            for (int i = put_i - 1; i >= 0; i--) {
                if (ch[i][put_j] == '#') {
                    find_f = true;
                }
            }
            for (int j = put_j; j < 8; j++) {
                if (ch[put_i][j] == '#') {
                    find_f = true;
                }
            }
            for (int j = put_j - 1; j >= 0; j--) {
                if (ch[put_i][j] == '#') {
                    find_f = true;
                }
            }

            for (int i = put_i + 1, j = put_j + 1; i < 8 && j < 8; i++, j++) {
                if (ch[i][j] == '#') {
                    find_f = true;
                }
            }


            for (int i = put_i - 1, j = put_j - 1; i >= 0 && j >= 0; i--, j--) {
                if (ch[i][j] == '#') {
                    find_f = true;
                }
            }

            if (find_f == false) {
                ch[put_i][put_j] = '#';
                f--;
                for (int i = 0; i < 8; i++) {
                    for (int j = 0; j < 8; j++) {
                        System.out.print(ch[i][j] + "  ");
                    }  
                    System.out.println();   
                }
                System.out.println();    
            }

        }

        System.out.println(); 

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                System.out.print(ch[i][j] + "  ");
            }  
            System.out.println();

        }
    }
}
