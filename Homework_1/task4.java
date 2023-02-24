import java.util.Scanner;

public class task4 {
    public static void main(String[] args) {
        System.out.println("Программа востанавливет выражение типа q + w = e, с учетом того что некоторые числа могут быть скрыты знаком вопроса.\n");
    
        System.out.print("Введите выражение типа q + w = e. Скрытые цифры замените на \"?\": ");
        Scanner sc = new Scanner(System.in, "cp866");
        String example = sc.nextLine();
        sc.close();
        example = example.replace(" ", "");
        
        System.out.println();
        boolean is_result = false;
        String[] example_devided = example.split("[+]|=");
        for (int i = 0; i < 10; i++) {
            int val_1, val_2, result;
            val_1 = Integer.parseInt(example_devided[0].replace("?", String.valueOf(i)));
            val_2 = Integer.parseInt(example_devided[1].replace("?", String.valueOf(i)));
            result = Integer.parseInt(example_devided[2].replace("?", String.valueOf(i)));
            if (val_1 + val_2 == result) {
                System.out.printf("%d + %d = %d", val_1, val_2, result);
                is_result = true;
            }
        }
        if (!is_result) {
            System.out.println("Решений не найдено!");
        }
        
    }
}
