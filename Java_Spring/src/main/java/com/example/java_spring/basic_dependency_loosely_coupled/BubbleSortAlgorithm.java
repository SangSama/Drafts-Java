package com.example.java_spring.basic_dependency_loosely_coupled;

public class BubbleSortAlgorithm implements SortAlgorithm{

    @Override
    public void sort(int[] array) {
        // TODO: add your logic here
        System.out.println("Đã sắp xếp bằng thuật toán sắp xếp nổi bột");
    }

//    public void sort(int[] array) {
//        // TODO: add your logic here
//        for (int i = 0 ; i < array.length - 1 ; i++) {
//            for (int j = i + 1 ; j < array.length ; j++) {
//                if (array[i] > array[j]) {
//                    int temp = array[i];
//                    array[i] = array[j];
//                    array[j] = temp;
//                }
//            }
//        }
//        System.out.println("Đã sắp xếp bằng thuật toán sắp xếp nổi bột");
//    }



}
