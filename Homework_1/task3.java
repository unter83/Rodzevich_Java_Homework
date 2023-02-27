import java.util.Scanner;

public class task3 {
    public static void main(String[] args) {
        System.out.println("Простой калькулятор на 1 действие\n");
        System.out.print("Введите выражение состоящее из 1 действия:");
        Scanner sc = new Scanner(System.in, "cp866");
        String example = sc.nextLine();
        sc.close();        
        boolean isok = false;
        double result = 0;
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
            if ((result - (int) result) == 0)
                System.out.printf("Ответ = %d", (int) result);                 
            else
                System.out.printf("Ответ = %f", result); 
        } 
        else
            System.out.println("Проверьте правильность выражения.");

    }
}
