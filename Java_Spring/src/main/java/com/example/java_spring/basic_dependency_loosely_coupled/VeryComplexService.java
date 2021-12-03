package com.example.java_spring.basic_dependency_loosely_coupled;

public class VeryComplexService {
    // level 1:
//    private BubbleSortAlgorithm bubbleSortAlgorithm = new BubbleSortAlgorithm();

    // level 2+3:
    private SortAlgorithm sortAlgorithm;

    // constructor
    public VeryComplexService(SortAlgorithm sortAlgorithm) {
        this.sortAlgorithm = sortAlgorithm;
    }

    // Method class
    public void complexBusiness(int array[]){
        sortAlgorithm.sort(array);
        // TODO : more logic here
    }

//    public static void main(String[] args) {
//        System.out.println("Start");
//        SortAlgorithm bubbleSortAlgorithm = new BubbleSortAlgorithm();
//        SortAlgorithm quickSortAlgorithm = new QuickSortAlgorithm();
//        VeryComplexService business1 = new VeryComplexService(bubbleSortAlgorithm);
//        VeryComplexService business2 = new VeryComplexService(quickSortAlgorithm);
//    }
}
