package Homework_5;

import java.util.HashMap;
import java.util.Map;

public class task5_2 {
    public static void main(String[] args) {
        System.out.println("\nПрограма выводит повторяющея значения и сортирует их по количеству повторений\n");

        String[] workers_array = {"Иван Иванов",
            "Светлана Петрова",
            "Кристина Белова",
            "Анна Мусина",
            "Анна Крутова",
            "Иван Юрин",
            "Петр Лыков",
            "Павел Чернов",
            "Петр Чернышов",
            "Мария Федорова",
            "Марина Светлова",
            "Мария Савина",
            "Мария Рыкова",
            "Марина Лугова",
            "Анна Владимирова",
            "Иван Мечников",
            "Петр Петин",
            "Иван Ежов"
        };

        Map<String, String> workers_map = new HashMap<>();
        
        for (String item : workers_array) {
            String[] workers = item.split(" ");
            workers_map.put(workers[1], workers[0]);
        }
        Map<String, Integer> workers_map_sorted = new HashMap<>();
        
        for (Map.Entry item : workers_map.entrySet()) {
            int amount = 0;
            for (Map.Entry key : workers_map.entrySet()) {
                if(item.getValue().equals(key.getValue()))
                    amount++;
            }
            workers_map_sorted.put(String.valueOf(item.getValue()), amount);
        }

        while (!workers_map_sorted.isEmpty()) {
            Map.Entry<String, Integer> maxEntry = null;
            for (Map.Entry item : workers_map_sorted.entrySet()) {
                if (maxEntry == null || Integer.parseInt(item.getValue().toString()) > maxEntry.getValue()) {
                    maxEntry = item;
                }
            }
            if (maxEntry.getValue() <= 1) {
                break;
            }
            System.out.printf("%s - %d\n", maxEntry.getKey(), maxEntry.getValue());
            workers_map_sorted.remove(maxEntry.getKey());

        }
    }
}
