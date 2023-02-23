package Homework_1;

import java.util.Scanner;

public class task1 {
    public static void main(String[] args) {
        System.out.println("The program makes sum of numbers from 1 to N, and calculates factorial of N\n");
        System.out.print("Input N:");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();
        int sum = 0;
        int f = 1;
        for (int i = 1; i <= n; i++) {
            sum += i;
            f *= i;
        }
        System.out.printf("Sum = %d\n", sum);
        System.out.printf("Factorial = %d\n", f);
    }
}
