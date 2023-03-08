package Homework_4;

import java.util.LinkedList;

public class test {
    public static void main(String[] args) {
        LinkedList ll = new LinkedList<>();
        System.out.println(ll.getClass());
        if (ll instanceof LinkedList)
            System.out.println("Ok");

    }
    
}
