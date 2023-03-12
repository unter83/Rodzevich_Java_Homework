package Homework_5;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class task5_3_1 {
    public static void main(String[] args) {
        System.out.println("\nПрограмма расставляет 8 ферзей на шахматной даске так чтобы они не били друг друга");
        char[][] ch = new char[8][8];
        Random rnd = new Random();
        //Map<int[][],Integer> chess_map = new HashMap<>(64);
        //chess_map.put([0][0],0);
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                ch[i][j] = '.';
                System.out.print(ch[i][j] + "  ");
            }  
            System.out.println();           
        }
        int f = 0;
        int p_i = rnd.nextInt(8);
        int p_j = rnd.nextInt(8);
        boolean turn = rnd.nextBoolean();
        if (turn)
            for(int i = p_i, j = p_j; i < 8 && j < 8; i++, j+=2) {                
                ch[i][j] = '#';
                System.out.printf("%d, %d\n", i, j);
                f++;
                System.out.println(f);
                if (i == 7) i = -1;
                if (j == 6) j = -1;
                if (j == 7) j = -2; 
                if (f == 8) break;               
            }
        else
        for(int i = p_i, j = p_j; i < 8 && j < 8; i++, j+=2) {                
            ch[j][i] = '#';
            System.out.printf("%d, %d\n", i, j);
            f++;
            System.out.println(f);
            if (i == 7) i = -1;
            if (j == 6) j = -1;
            if (j == 7) j = -2; 
            if (f == 8) break;               
        }
        // }

        System.out.println(); 

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                System.out.print(ch[i][j] + "  ");
            }  
            System.out.println();

        }
    }
}
