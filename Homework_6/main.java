package Homework_6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class main {
    
    public static void main(String[] args) {
        System.out.println("\n Програма реализует базу ноутбуков");

        notebooks n1 = new notebooks("Cortana", "MSI", 16, 1024, 15, "Windows");
        notebooks n2 = new notebooks("Aspire", "Acer", 8, 1024, 17, "Linux");
        notebooks n3 = new notebooks("Magicbook", "Honor", 32, 2048, 17, "Linux");
        notebooks n4 = new notebooks("MateBook", "HUAWEI", 8, 2048, 15, "Linux");
        notebooks n5 = new notebooks("RedmiBook", "Xiaomi", 12, 512, 15, "Windows");
        notebooks n6 = new notebooks("Macbook", "Apple", 12, 2048, 15, "IOS");
        
        ArrayList n_list = new ArrayList<notebooks>(Arrays.asList(n1, n2, n3, n4, n5, n6));

        boolean exit = false;   
        
        while(!exit) {
            
            for (Object itemObject : n_list) {
                System.out.println(itemObject.toString());
            }

            Scanner sc = new Scanner(System.in);
            System.out.println("\n");
            System.out.println("1 - ОЗУ");
            System.out.println("2 - Объем жесткого диска");
            System.out.println("3 - Операционная систем");
            System.out.println("4 - Выход\n");               
            System.out.print("Выберите опцию для сортировки: ");
            try {
                int ch = sc.nextInt();                
                //sc.close();
                switch (ch) {
                    case 1:
                        ChooseRam(n_list);                        
                        break;
                    case 2:   
                        ChooseHDD(n_list);                      
                        break;
                    case 3:
                        ChooseOS(n_list);                        
                        break;
                    case 4:
                        exit = true;
                        System.out.println("Выходим...");                      
                        break;
                    default:
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Неправильное значение! Выберите пункты 1 - 4.");
            }
        }
    }

    public static void ChooseRam(ArrayList n_list) {
        System.out.println();
        
        System.out.println("Сортировка по операционной памяти. ");
        boolean exit = false;
        while(!exit) {
            System.out.print("Выберите объем максимальный объём ОЗУ: ");
            try {
                int ch2;
                Scanner sc2 = new Scanner(System.in);
                ch2 = sc2.nextInt();                
                if (ShowRam(n_list, ch2))
                    exit = true;                

            } catch (InputMismatchException e) {
                    System.out.println("Неправильное значение! Выберите память в числовом значении");                    
            }  
         
        }
        
    }


    public static void ChooseHDD(ArrayList n_list) {
        System.out.println();
        
        System.out.println("Сортировка по объему HDD. ");
        boolean exit = false;
        while(!exit) {
            System.out.print("Выберите объем максимальный объём HDD: ");
            try {
                int ch2;
                Scanner sc2 = new Scanner(System.in);
                ch2 = sc2.nextInt();                
                if (ShowHDD(n_list, ch2))
                    exit = true;                

            } catch (InputMismatchException e) {
                    System.out.println("Неправильное значение! Выберите память в числовом значении");                    
            }  
         
        }
        
    }

    public static void ChooseOS(ArrayList n_list) {
        System.out.println();
        
        System.out.println("Сортировка по операционной системе. ");
        boolean exit = false;
        while(!exit) {
            System.out.print("Выберите ОС: ");
            try {
                String ch2;
                Scanner sc2 = new Scanner(System.in);
                ch2 = sc2.next();                
                if (ShowOS(n_list, ch2))
                    exit = true;                

            } catch (InputMismatchException e) {
                    System.out.println("Неправильное значение!");                    
            }  
         
        }
        
    }

    public static boolean ShowOS(ArrayList n_list, String os) {
        Map<Integer, String> map_n = new TreeMap<>();
        for (Object item : n_list) {
            if (((notebooks) item).getOS().equals(os) 
                || ((notebooks) item).getOS().toLowerCase().equals(os) 
                || os.toLowerCase().equals(((notebooks) item).getOS().equals(os))) { 
                      
                System.out.println(item.toString());             
                map_n.put(((notebooks) item).getId(), ((notebooks) item).toStringwoID());
            }  
        }
        
        if (map_n.isEmpty()) {
            System.out.println("\nНоутбуки не найдены");
            return false;
        }          
          
        boolean exit = false;
        while (!exit)
        try {
            Scanner sc3 = new Scanner(System.in);
            System.out.print("Выберите ноутбук: ");
            int ch3 = sc3.nextInt();
            boolean ok = false;
            if (map_n.containsKey(ch3)) {
                if (BuyNotebook()) {
                    System.out.println("\nВы приобрели ноутук - " + map_n.get(ch3) + "\n");  
                    System.out.println("Возвращаемся к основному меню.\n");                        
                    return true;
                }
            }
            else {
                System.out.println("Ноутбук не найден."); 
            }                        
        } catch (InputMismatchException e) {
            System.out.println("Неправильное значение. Выберите один из номеров ноутбука.");
        }
        return false;
    }



    public static boolean ShowRam(ArrayList n_list, int ram) {
        Map<Integer, String> map_n = new TreeMap<>();
        for (Object item : n_list) {
            if (((notebooks) item).getRam() <= ram) {   
                System.out.println(item.toString());             
                map_n.put(((notebooks) item).getId(), ((notebooks) item).toStringwoID());
            }  
        }
        
        if (map_n.isEmpty()) {
            System.out.println("\nНоутбуки не найдены");
            return false;
        }          
          
        boolean exit = false;
        while (!exit)
        try {
            Scanner sc3 = new Scanner(System.in);
            System.out.print("Выберите ноутбук: ");
            int ch3 = sc3.nextInt();
            boolean ok = false;
            if (map_n.containsKey(ch3)) {
                if (BuyNotebook()) {
                    System.out.println("\nВы приобрели ноутук - " + map_n.get(ch3) + "\n");  
                    System.out.println("Возвращаемся к основному меню.\n");                        
                    return true;
                }
            }
            else {
                System.out.println("Ноутбук не найден."); 
            }                        
        } catch (InputMismatchException e) {
            System.out.println("Неправильное значение. Выберите один из номеров ноутбука.");
        }
        return false;
    }

    public static boolean ShowHDD(ArrayList n_list, int ram) {
        Map<Integer, String> map_n = new TreeMap<>();
        for (Object item : n_list) {
            if (((notebooks) item).getHDD() <= ram) {   
                System.out.println(item.toString());             
                map_n.put(((notebooks) item).getId(), ((notebooks) item).toStringwoID());
            }  
        }
        
        if (map_n.isEmpty()) {
            System.out.println("\nНоутбуки не найдены");
            return false;
        }          
          
        boolean exit = false;
        while (!exit)
        try {
            Scanner sc3 = new Scanner(System.in);
            System.out.print("Выберите ноутбук: ");
            int ch3 = sc3.nextInt();
            boolean ok = false;
            if (map_n.containsKey(ch3)) {
                if (BuyNotebook()) {
                    System.out.println("\nВы приобрели ноутук - " + map_n.get(ch3) + "\n");  
                    System.out.println("Возвращаемся к основному меню.\n");                        
                    return true;
                }
            }
            else {
                System.out.println("Ноутбук не найден."); 
            }                        
        } catch (InputMismatchException e) {
            System.out.println("Неправильное значение. Выберите один из номеров ноутбука.");
        }
        return false;
    }

    public static boolean BuyNotebook() {
        Scanner sc4 = new Scanner(System.in);
        System.out.print("Купить ноутбук? Y/N: ");
        String ch4 = sc4.next();
        switch (ch4) {
            case "Y":
                return true;
            case "y":
                return true;
            case "N":
                return false;
            case "n":
                return false;
            default:
                System.out.println("Неправильный ввод. Выберите Y(да) или N(нет)");
                return false;
            }
        }
    }
    

