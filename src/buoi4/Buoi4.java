package buoi4;

import java.util.Scanner;

public class Buoi4 {

    /*
    * ***CONTENT***
    * continue : không chạy tại lần đó và sẽ chạy lần tiếp theo luôn. continue phải để cuối, để trên sẽ lỗi.
    * break : thoát khỏi vòng lặp
    *
    * while, do...while
    * VD:
    *
    *
    *
    * */

    /* Thuật toán đặt cờ hiệu
     * x = false ==> cần điều kiện đúng nào đó để cho x = true;
     * x = true ==> cần điều kiện đúng nào đó để cho x = false;
     *
     * */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập chiều cao a: ");
        int a = sc.nextInt();

        // Bài in ra tam giác rỗng
        System.out.println("Tam giác rỗng");
        for ( int i = 1 ; i <= a ; i++ ) {
            for ( int j = 1 ; j <= i ; j++ ) {
                if ( j == 1 || i == a || j == i ) {
                    System.out.print("*");
                } else System.out.print(" ");
            }
            System.out.println();
        }

        // Bài tam giác cân nhưng không vuông
        System.out.println("Tam giác cân nhưng không vuông");
        for ( int i = 1 ; i <= a ; i++ ) {
            for ( int j = 1 ; j <= a + i - 1 ; j++ ) {
                if ( j >= a - i + 1 ) System.out.print("*");
                else System.out.print(" ");
            }
            System.out.println();
        }

        // Bài tam giác rỗng, cân nhưng không vuông
        System.out.println("Tam giác rỗng, cân nhưng không vuông");
        for ( int i = 1 ; i <= a ; i++ ) {
            for ( int j = 1 ; j <= a + i - 1 ; j++ ) {
                if ( i == a || j == a-i+1 || j == a+i-1 ) System.out.print("*");
                else System.out.print(" ");
            }
            System.out.println();
        }

        // HOMEWORK b72-b76:
        System.out.print("Nhập n = ");
        int n = sc.nextInt();
        System.out.print("Nhập x = ");
        int x = sc.nextInt();
        bai072(n, x);
        bai073(n, x);
        bai074(n, x);

        System.out.print("Nhập y = ");
        int y = sc.nextInt();
        bai075(y);
        bai076(y);
    }

    static void bai072(int n, int x) {
        float s = 0;
        int m = 1;
        for ( int i = 1 ; i <= n ; i++ ) {
            for ( int j = 1 ; j <= i ; j++ ) m *= j;
            s += (float) Math.pow(-1,i)*Math.pow(x, i)/m;
            m = 1;
        }
        System.out.println("Bài 72: S(n,x) = "+s);
    }

    static void bai073(int n, int x) {
        float s = -1;
        int m = 1;
        for ( int i = 1 ; i <= n ; i++ ) {
            for ( int j = 1 ; j <= 2*i ; j++ ) m *= j;
            s += (float) Math.pow(-1, i+1)*Math.pow(x, 2*i)/m;
            m = 1;
        }
        System.out.println("Bài 73: S(n,x) = "+s);
    }

    static void bai074(int n, int x) {
        float s = 1;
        int m = 1;
        for ( int i = 0 ; i <= n ; i++ ) {
            for ( int j = 1 ; j <= 2*i+1 ; j++ ) m *= j;
            s += (float) Math.pow(-1, i+1)*Math.pow(x, 2*i+1 )/m;
            m = 1;
        }
        System.out.println("Bài 74: S(n,x) = "+s);
    }

    static void bai075(int y) {
        boolean check = false;
        for ( int i = 1 ; i <= y ; i++ ) {
            if ( y == Math.pow(2, i)) {
                check = true;
                break;
            }
            if ( y < Math.pow(2, i)) break;
        }
        if ( check ) System.out.println("Bài 75: có dạng 2^k");
        else System.out.println("Bài 75: không có dạng 2^k");
    }

    static void bai076(int y) {
        boolean check = false;
        for ( int i = 1 ; i <= y ; i++ ) {
            if ( y == Math.pow(3, i)) {
                check = true;
                break;
            }
            if ( y < Math.pow(3, i)) break;
        }
        if ( check ) System.out.println("Bài 76: có dạng 3^k");
        else System.out.println("Bài 76: không có dạng 3^k");
    }
}
