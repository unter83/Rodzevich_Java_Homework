package Homework_2;

import java.util.Scanner;
import java.util.logging.*;
import java.io.IOException;

public class task2_4 {
    public static void main(String[] args) throws IOException {
        System.out.println("Простой калькулятор на 1 действие c логгированием\n");

        Logger logger = Logger.getLogger(task2_4.class.getName());
        logger.setLevel(Level.INFO);
        FileHandler fh = new FileHandler("Homework_2\\log.xml", true);
        logger.addHandler(fh);
        XMLFormatter xml = new XMLFormatter();
        fh.setFormatter(xml);

        System.out.print("Введите выражение состоящее из 1 действия: ");
        Scanner sc = new Scanner(System.in, "cp866");
            String example = sc.nextLine();
            logger.info("user entered " + example); 
        sc.close();       
        
        
       boolean isok = false;
        int sign = 0;
        example = example.replace(" ", "");        
        for (int i = 0; i < example.length(); i++) {
            switch (example.charAt(i)){
                case '+':
                    isok = true;
                    sign = 1;
                    break;
                case '-':                    
                    isok = true;
                    sign = 2;
                    break;
                case '/':                     
                    isok = true;
                    sign = 3;
                    break;
                case '*':                    
                    isok = true;
                    sign = 4;
                    break;                        
            }
        } 

        double result = 0;
        String[] example_devided = example.split("[+]|-|/|[*]");
        if (example_devided.length != 2)
            isok = false;
        if (isok) {           
            Double val_1 = Double.parseDouble(example_devided[0]), val_2 = Double.parseDouble(example_devided[1]);
            switch (sign) {
                case 1:
                    result =  val_1 + val_2;                
                    break;
                case 2:
                    result =  val_1 - val_2; 
                    break;
                case 3:
                    result =  val_1 / val_2; 
                    break;
                case 4:
                    result =  val_1 * val_2;
                    break;               
            }
            if ((result - (int) result) == 0) {
                System.out.printf("\nОтвет = %d\n", (int) result); 
                logger.info("Result = " + (int) result); 
            }               
            else {
                System.out.printf("\nОтвет = %f\n", result); 
                logger.info("Result = " + result); 
            }
        } 
        else {
            System.out.println("Проверьте правильность выражения.");
            logger.log(Level.WARNING, "User entered wrong example");
        }

    }
}
