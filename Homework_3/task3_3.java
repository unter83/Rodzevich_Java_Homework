package Homework_3;

import java.util.ArrayList;


public class task3_3 {
    public static void main(String[] args) {
        System.out.println("\nПрограмма выполняет сортировку методом слияния\n");
        System.out.println("Исходный список:");
        int[] unsorted_array = new int[] {2, 4, 12, 68, 29, 6, 48, 62, 7, 8, 10};
        ArrayList<Integer> unsorted_list = new ArrayList();
        for (int index = 0; index < unsorted_array.length; index++) {
            unsorted_list.add(unsorted_array[index]);
        }
        System.out.println(unsorted_list);
        ArrayList<Integer> sorted_list = new ArrayList();
        sorted_list = SortList(unsorted_list);
        System.out.println("Список после сортировки");
        System.out.println(sorted_list);
    }    

    public static ArrayList SortList(ArrayList<Integer> list) {

        if (list == null)
            return null;
        
        if (list.size() < 2)
            return list;

        ArrayList<Integer> list_A = new ArrayList(list.size());
        for (int i = 0; i < list.size()/2; i++) {
            list_A.add(list.get(i));
        }
        // System.out.println(list_A);

        ArrayList <Integer> list_B = new ArrayList(list.size());
        for (int i = list.size()/2; i < list.size(); i++) {
            list_B.add(list.get(i));
        }
        // System.out.println(list_B);

        list_A = SortList(list_A);
        list_B = SortList(list_B);

        return MergeList(list_A, list_B);

    }

    public static ArrayList MergeList(ArrayList<Integer> listA, ArrayList<Integer> listB) {
        
        ArrayList<Integer> listM = new ArrayList<Integer>();
        int pA = 0, pB = 0;

        for (int i = 0; i < listA.size() + listB.size(); i++) {
            if (pA < listA.size() && pB < listB.size()) {
                if (listA.get(pA) < listB.get(pB)) {
                    listM.add(listA.get(pA));
                    pA++;
                }
                else {
                    listM.add(listB.get(pB));
                    pB++;
                }
            }
            else if (pA == listA.size() && pB < listB.size()) {
                listM.add(listB.get(pB));
                pB++;
            }
            else if (pA < listA.size() && pB == listB.size()) {
                listM.add(listA.get(pA));
                pA++;
            }
            else {
                listM.add(0);
            }
        }
        return listM;
    }

}
