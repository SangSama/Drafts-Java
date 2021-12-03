package com.example.java_spring.basic_dependency_loosely_coupled;

public class Main {

    /*
     * DEPENDENCY INJECTION (DI)
     * - Là một Design Pattern
     * - Nguyên tắc: Các class không nên phụ thuộc vào các kế thừa cấp thấp,
     * mà nên phụ thuộc vào Abstraction (lớp trừu tượng)
     *  => Dependency Injection là việc các Object nên phụ thuộc vào các Abstract Class và thể hiện
     * chi tiết của nó sẽ được Inject vào đối tượng lúc runtime
     *
     * Các cách để Inject Dependency vào một đối tượng có thể kể đến như:
     * - Constructor Injection
     * - Setter Injection
     * - Interface Injection
     * */

    /*
    * VeryComplexService
    * => sẽ không quan tâm tới việc thuật toán sắp xép là gì nữa,
    * => mà chỉ cần tập trung vào nghiệp vụ
    *
    * SortAlgorithm
    * => sẽ được đưa vào từ bên ngoài tùy theo nhu cầu sử dụng
    * */


    public static void main(String[] args) {
        SortAlgorithm bubbleSortAlgorithm = new BubbleSortAlgorithm();
        SortAlgorithm quickSortAlgorithm = new QuickSortAlgorithm();
        VeryComplexService business1 = new VeryComplexService(bubbleSortAlgorithm);
        VeryComplexService business2 = new VeryComplexService(quickSortAlgorithm);

        Outfit bikini = new Bikini(); // Tạo ra đối tượng Bikini ở ngoài đối tượng
        Girl girl1 = new Girl(bikini); // Mặc nó vào cho cô gái khi tạo ra cô ấy
    }

}
