package com.czg.learn;


import com.czg.learn.list.List;

public class Main {

    public static void main(String args[]) {
        long l = System.currentTimeMillis();
        testList(10, "com.czg.learn.list.LinkedList");
        //   testList(10, "com.czg.learn.list.ArrayList");

        System.out.println(System.currentTimeMillis() - l + "ms");
    }


    private static void testList(int count, String packageName) {
        System.out.println("-------test-------" + packageName + "-------start-------");
        List<String> arrayList = null;
        try {
            arrayList = (List<String>) Class.forName(packageName).newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < count; i++) {
            arrayList.add(String.valueOf(i));
        }
        arrayList.add(1, "2222222");
        arrayList.add(1, "111111");
        for (int i = 0; i < arrayList.size(); i++) {
            System.out.println(arrayList.get(i));
        }
        System.out.println("------------ add ");
        arrayList.remove(2);

        for (int i = 0; i < arrayList.size(); i++) {
            System.out.println(arrayList.get(i));
        }

        System.out.println("111111在第" + arrayList.indexOf("111111") + "个");
        System.out.println("9在第" + arrayList.indexOf("9") + "个");
        System.out.println("-------test-------" + packageName + "-------end-------");
    }
}