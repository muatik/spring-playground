package com.muatik;

import java.util.*;

/**
 * Created by mustafaatik on 16/01/17.
 */
public class main {
    public static void main(String[] args) {
//        simple_asList();
        ArrayList_vs_LinkedList();
    }

    private static void simple_asList() {
        List<String> a = Arrays.asList("apple", "banana");
        a.forEach(System.out::println);
    }

    private static void ArrayList_vs_LinkedList() {
        int n = 300000;  // 1M

        System.out.print("ArrayList add: ");
        long start = System.currentTimeMillis();
        ArrayList<String> arrayList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arrayList.add(String.valueOf(i));
        }
        long end = System.currentTimeMillis();
        System.out.println((end - start));

        System.out.print("Linked list push: ");
        start = System.currentTimeMillis();
        LinkedList<String> linkedList = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            linkedList.push(String.valueOf(i));
        }
        end = System.currentTimeMillis();
        System.out.println((end - start));

        System.out.print("ArrayList get sequential: ");
        start = System.currentTimeMillis();
        for (int i = 0; i < n; i++) {
            arrayList.get(i);
        }
        end = System.currentTimeMillis();
        System.out.println((end - start));

        System.out.print("linked list get sequential: ");
        start = System.currentTimeMillis();
        for (int i = 0; i < n; i++) {
            linkedList.get(i);
        }
        end = System.currentTimeMillis();
        System.out.println((end - start));

        System.out.print("ArrayList get random: ");
        start = System.currentTimeMillis();
        Random rand = new Random();
        for (int i = 0; i < n; i++) {
            arrayList.get(rand.nextInt(n));
        }
        end = System.currentTimeMillis();
        System.out.println((end - start));

        System.out.print("linked list get random: ");
        start = System.currentTimeMillis();
        for (int i = 0; i < n; i++) {
            linkedList.get(rand.nextInt(n));
        }
        end = System.currentTimeMillis();
        System.out.println((end - start));

        System.out.print("linked list pop: ");
        start = System.currentTimeMillis();
        for (int i = 0; i < n; i++) {
            linkedList.pop();
        }
        end = System.currentTimeMillis();
        System.out.println((end - start));
//        ArrayList add: 69
//        Linked list push: 66
//        ArrayList get sequential: 9
//        linked list get sequential: 212282
//        ArrayList get random: 21
//        linked list get random: 238583
//        linked list pop: 12
    }

    private static void testMap() {
        Map<String, String> map = new HashMap<>();
        map.put("phone", "android");
        map.put("book", "the book");
        map.put("car", "your car");
    }
}
