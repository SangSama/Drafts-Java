package buoi7;

import java.util.Scanner;

public class Buoi7 {

    /*
    * ***CONTENT***
    *
    * Mảng 2 chiều
    * ==> nhiều mảng 1 chiều gộp lại
    * a[0] -> quản lý 1 danh sách các thằng khác
    * 1  2  3  4  5
    * 1  2  3  4  5
    * => a[i][j]
    *-----------------------------------------------
    * Cách khai báo mảng 2 chiều
    * int[][] a = new int[2][5] => hiểu là: 2 dòng - 5 cột
    * for ( int i = 0 ; i < dong ; i++ ) {
    *   for ( int j = 0 ; j < cot ; j++ ) {
    *       // chạy đến từng giá trị của mảng 2 chiều
    *   }
    * }
    *----------------------------------------------------------------------------------------------
    * Ma trận vuông
    * => mảng có số dòng = số cột
    * VD: 1  2  3
    *     1  2  3
    *     1  2  3
    * => dòng = cột = 3
    * xuất tất cả các phần tử trên đường chéo chính của ma trận vuông
                                 0  5  2  1
                                 1  4  1  3
                                 9  5  2  1
                                 3  5  7  0
         => đường chéo chính: a[0][0] , a[1][1] , ... => i = j;
         => với đường chép phụ: a[0][3] , a[1][2] , a[2][1] , a[3][0] => j = a.length - i - 1;
         => Tam giác trên đường chéo chính nằm bên trên đường chéo chính => i < j;
             =====> a[0][1] , a[0][2] , a[0][3]
             =====> a[1][2] , a[1][3]
             =====> a[2][3]
         => Tam giác dưới đường chéo chính nằm bên dưới đường chéo chính => j < i;
         => Tam giác trên đường chéo phụ nằm bên trên đường chéo phụ => j < a.length - i - 1
             =====> a[0][0] , a[0][1] , a[0][2]
             =====> a[1][0] , a[1][1]
             =====> a[2][0]
         => Tam giác dưới đường chéo phụ nằm bên dưới đường chéo phụ => j > a.length - i - 1
    *
    *
    * */



    public static void nhapMang( int[][] a ) {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0 ; i < a.length ; i++) {
            for (int j = 0 ; j < a[i].length ; j++) {
                System.out.print("a["+i+"]["+j+"] = ");
                a[i][j] = scanner.nextInt();
            }
        }
    }

    public static void xuatMang( int[][] a ) {
        for (int i = 0 ; i < a.length ; i++) {
            for (int j = 0 ; j < a[i].length ; j++) {
                System.out.print( a[i][j] + "  ");
            }
            System.out.println();
        }
    }

    // Tính tổng dòng x => a[x][cột] : i chạy từ 0 đến cột.
    public static void tinhTongDongX ( int[][] a, int x ) {
        int sum = 0;
        for (int i = 0 ; i < a[x].length ; i++) {
            sum += a[x][i];
        }
        System.out.println("Tổng dòng "+x+" = "+sum);
    }

    public static void tinhTongCotX ( int[][] a, int x ) {
        int sum = 0;
        for (int i = 0 ; i < a.length ; i++) {
            sum += a[i][x];
        }
        System.out.println("Tổng cột "+x+" = "+sum);
    }

    public static void tinhTongCacPhanTuTrongMang ( int[][] a ) {
        int sum = 0;
        for (int i = 0 ; i < a.length ; i++) {
            for (int j = 0 ; j < a[i].length ; j++) {
                sum += a[i][j];
            }
        }
        System.out.println(" Tổng các phần tử = "+sum);
    }

    public static int[] timGiaTriX ( int[][] a, int x ) {
        for (int i = 0 ; i < a.length ; i++) {
            for (int j = 0 ; j < a[i].length ; j++) {
                if ( a[i][j] == x ) {
                    return new int[]{i,j};
                }
            }
        }
        return new int[]{-1,-1};
    }

    // tìm chữ số xuất hiện nhiều nhất trong ma trận
    // 12   23   42
    // 11   45   23
    // 22   41   26
    // => chữ số 2 nhiều nhất!!!
    public static void chuSoXuatHienNhieuNhat( int[][] a ) {
        int[] chuong = new int[10];
        for (int i = 0 ; i < 10 ; i++) {
            chuong[i] = 0;
        }
        for (int i = 0 ; i < a.length ; i++) {
            for (int j = 0 ; j < a[i].length ; j++) {
                if ( a[i][j] == 0 ) chuong[0]++;
                int gan = Math.abs(a[i][j]);
                while ( gan > 0 ) {
                    chuong[gan%10]++;
                    gan /= 10;
                }
            }
        }
        int max = chuong[0];
        int chuSo = -1;
        for (int i = 1 ; i < 10 ; i++) {
            if ( chuong[i] != 0 ) {
                if ( max < chuong[i] ) {
                    max = chuong[i];
                    chuSo = i;
                }
            }
        }
        System.out.println(" chữ số xuất hiện nhiều nhất là "+chuSo+" xuất hiện "+max+" lần");
    }

    // Đếm số phần tử yên ngựa
    // phần tử yên ngựa => là phần tử nhỏ nhất trên dòng và lớn nhất trên cột
    public static void demYenNgua( int[][] a ) {
        int dem = 0;
        for (int i = 0 ; i < a.length ; i++) {
            for (int j = 0 ; j < a[i].length ; i++) {
                if ( checkYenNgua(a, i, j)) dem++;
            }
        }
        System.out.println("Số phần tử yên ngựa = "+dem);
    }
    public static boolean checkYenNgua( int[][] a, int i, int j ) {
        for (int k = 0 ; k < a.length ; k++) {
            if ( a[k][j] > a[i][j] ) return false;
        }
        for (int k = 0 ; k < a[i].length ; k++) {
            if ( a[i][k] < a[i][j] ) return false;
        }
        return true;
    }


    // Đếm số phần tử hoàng hậu
    // phần tử hoàng hậu => là phần tử lớn nhất trên dòng, lớn nhất trê cột, lớn nhất trên 2 đường chéo đi qua nó
    public static void demHoangHau( int[][] a ) {
        int dem = 0;
        for (int i = 0 ; i < a.length ; i++) {
            for (int j = 0 ; j < a[i].length ; i++) {
                if ( checkHoangHau(a, i, j)) dem++;
            }
        }
        System.out.println("Số phần tử hoàng hậu = "+dem);
    }
    public static boolean checkHoangHau( int[][] a, int i, int j ) {
        for (int k = 0 ; k < a.length ; k++) {
            if ( a[k][j] > a[i][j] ) return false;
        }
        for (int k = 0 ; k < a[i].length ; k++) {
            if ( a[i][k] < a[i][j] ) return false;
        }
        // check đường chéo như thế nào??? => xét từng TH
        // TH: top-left
        int d = i - 1;
        int c = j - 1;
        while ( d >= 0 || c >= 0 ) {
            if ( a[d][c] > a[i][j] ) return false;
            d--;
            c--;
        }
        // TH: bottom-right
        d = i + 1;
        c = j + 1;
        while ( d < a.length || c < a[i].length ) {
            if ( a[d][c] > a[i][j] ) return false;
            d++;
            c++;
        }
        // TH: top-right
        d = i - 1;
        c = j + 1;
        while ( d >= 0 || c < a[i].length ) {
            if ( a[d][c] > a[i][j] ) return false;
            d--;
            c++;
        }
        // TH: bottom-left
        d = i + 1;
        c = j - 1;
        while ( d < a.length || c >= 0 ) {
            if ( a[d][c] > a[i][j] ) return false;
            d++;
            c--;
        }
        return true;
    }



    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        System.out.print("Dòng = ");
//        int d = scanner.nextInt();
//        System.out.print("Cột = ");
//        int c = scanner.nextInt();
//        int[][] a = new int[d][c];
//        nhapMang(a);
//        xuatMang(a);
//        chuSoXuatHienNhieuNhat(a);

    }
}
