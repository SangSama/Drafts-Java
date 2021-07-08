package buoi6;

import java.util.Scanner;

public class Buoi6 {

    /*
    * ***CONTENT***
    *
    * Các thao tác cơ bản của mảng
    * - thao tác thêm mới phần tử
    * - thao tác xóa phần tử
    * - thuật toán tìm kiếm
    *    + tuần tự
    *    + nhị phân
    * - thuật toán sắp xếp
    * - thuật toán lùa bò vào chuồng
    * - kỹ thuật mảng đánh dấu
    * - kỹ thuật
    * */

    private static int n;

    public static void input(int[] a, int n) {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < n ; i++) {
            System.out.print("a["+i+"] = ");
            a[i] = scanner.nextInt();
        }
    }

    public static void output(int[] a, int n) {
        for (int i = 0; i < n ; i++) {
            System.out.println("a["+i+"] = "+a[i]);
        }
    }

    // thêm giá trị vào 1 vị trí
    public static void themVaoViTri(int[] a, int viTriThem, int giaTriThem) {
        for (int i = n-1 ; i >= viTriThem ; i--) {
            a[i+1] = a[i];
        }
        a[viTriThem] = giaTriThem;
        n++;
    }

    // thêm số 0 vào đằng trước số chẵn
    public static void them0VaoTruocSoChan(int a[]) {
        for (int i = 0 ; i < n ; i++) {
            if (a[i] % 2 == 0) {
                themVaoViTri(a, i, 0);
                i++; // nếu k tăng i sẽ bị vòng lặp vô tận
            }
        }
    }

    // xóa 1 phần tử
    public static void xoaPhanTu(int a[], int viTriXoa) {
        for (int i = viTriXoa ; i < n ; i++) {
            a[i] = a[i+1];
        }
//        a[n-1] = 0;  // không cần gán lại
//        System.out.println(a[n-1]);
        n--;
    }

    // xóa tất cả các số lẻ trong mảng
    public static void xoaSoLe(int a[]) {
        for (int i = 0 ; i < n ; i++) {
            if (a[i]%2==1) {
                xoaPhanTu(a, i);
                i--;
            }
        }
    }

    // thuật toán sắp xếp
    public static void sapXepTangDan(int a[]) {
        for (int i = 0 ; i < n-1 ; i++) {
            for (int j = i+1 ; j < n ; j++) {
                if ( a[i] > a[j] ) {
                    int temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
            }
        }
    }
    public static void sapXepGiamDan(int a[]) {
        for (int i = 0 ; i < n-1 ; i++) {
            for (int j = i+1 ; j < n ; j++) {
                if ( a[i] < a[j] ) {
                    int temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
            }
        }
    }

    // đếm các phần tử khác nhau trong mảng
    public static void demCacPhanTuKhacNhau(int a[]) {
        sapXepTangDan(a);
        int dem = 1;
        for (int i = 0 ; i < n-1 ; i++) {
            if (a[i] != a[i+1]) {
                dem++;
            }
        }
        System.out.println("Số lượng các phần tử khác nhau = "+dem);
    }

    // tìm số lớn thứ k trong mảng
    public static void soLonThuK(int a[], int k) {
        for (int i = 0 ; i < k; i++) {
            for (int j = i+1 ; j < n ; j++) {
                if ( a[i] < a[j] ) {
                    int temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
            }
        }
        System.out.println("Số lớn thứ "+k+" = "+a[k-1]);
    }

    // thuât toán tìm kiếm tuần tự
    // => duyệt tất cả các phần tử trong mảng nếu như có phần tử nào bằng phần tử tìm kiếm thì return vitri
    // nếu không thì return -1;
    public static void timKiemTuanTu(int a[], int phanTuTimKiem) {
        int viTri = -1;
        for (int i = 0 ; i < n ; i++) {
            if (a[i] == phanTuTimKiem) {
                viTri = i;
            }
        }
        System.out.println("Vị trí phần tử tìm kiếm = "+viTri);
    }

    // thuật toán tìm kiếm nhị phân
    // => chỉ áp dụng với mảng đã sắp xếp
    // middle = (l+r)/2
    public static int timKiemNhiPhan(int a[], int left, int right, int phanTuTimKiem) {
        int l = left;
        int r = right;
        int middle;
        int viTri = -1;
        // bài này phải sắp xếp tăng dần
//        sapXepTangDan(a);
        while ( l <= r ) {
            middle = (l+r)/2;
            if ( a[middle] > phanTuTimKiem ) r = middle-1;
            else if ( a[middle] < phanTuTimKiem ) l = middle+1;
            else {
                viTri = middle;
                break;
            }
        }
        return viTri;
    }

    // tìm trong mảng có tồn tại hai phần tử có tổng bằng k không? a[i] + a[j] = k ?
    // Cách 1:
    public static void haiPhanTuTongBangK(int a[], int k) {
        boolean check = false;
        for (int i = 0 ; i < n ; i++) {
            for (int j = i+1 ; j < n ; j++) {
                if ( a[i]+a[j]==k ) {
                    check = true;
                    break;
                }
            }
        }
        if (check) System.out.println("Có tồn tại");
        else System.out.println("Không tồn tại");
    }
    // Cách 2: a[j] = k - a[i] , điều kiện mảng đã sắp xếp
    public static void haiPhanTuTongBangKdungSXNP(int a[], int k) {
        boolean check = false;
        int test = -1;
        for (int i = 0 ; i < n ; i++) {
            test = timKiemNhiPhan(a, 0, n-1, k-a[i]);
            System.out.println(test);
            if ( test!=-1 && test!=i ) {
                check = true;
                break;
            }
        }
        if (check) System.out.println("Có tồn tại");
        else System.out.println("Không tồn tại ");
    }

    // thuật toán lùa bò vào chuồng
    // => xác định được số chuồng : k cái chuồng và n (được đánh dấu theo số chuồng) con bò
    // => những con bò nào có chung số chuồng thì sẽ xếp vào 1 chuồng
    // VD: Đếm tần xuất xuất hiện của các số trong mảng, biết rằng: 0 <= a[i] <= 1000 ===> có 1001 chuồng, đánh số từ 0 đến 1000
    public static void tanXuatXuatHien(int a[]) {
        int[] chuong = new int[1001];
        // vì các giá trị a[i] giao động từ 0 đến 1000 => nên cần mảng 1001 giá trị tù 0 đến 1000
        for (int i = 0 ; i < chuong.length ; i++) {
            chuong[i] = 0; // gán tất cả số lần lặp = 0
        }
        for (int i = 0 ; i < n ; i++) {
            chuong[a[i]]++; // xét các giá trị a[i] lặp bao nhiêu lần
        }
        for (int i = 0 ; i < chuong.length ; i++) {
            if ( chuong[i] != 0 ) {
                System.out.println( i + " xuất hiện " + chuong[i] + " lần");
            }
        }
    }

    // Cho mảng 1 chiều các số nguyên. Đếm chữ số xuất hiện nhiều nhất trong mảng.
    // VD:  12  32  1  52  46  54  72
    // => 1 xuất hiện 2 lần
    // => 2 xuất hiện 4 lần
    // => 3 xuất hiện 1 lần
    // => 4 xuất hiện 2 lần
    // => 5 xuất hiện 2 lần
    // => 6 xuất hiện 1 lần
    // => 7 xuất hiện 1 lần
    public static void chuSoXuatHienNhieuNhat(int a[]) {
        int[] demChuSo = new int[10];
        for (int i = 0 ; i < 10 ; i++) {
            demChuSo[i] = 0;
        }
        int max = demChuSo[0];
        int viTri = 0;
        int[] chuong = new int[1001];
        // vì các giá trị a[i] giao động từ 0 đến 1000 => nên cần mảng 1001 giá trị tù 0 đến 1000
        for (int i = 0 ; i < chuong.length ; i++) {
            chuong[i] = 0; // gán tất cả số lần lặp = 0
        }
        for (int i = 0 ; i < n ; i++) {
            chuong[a[i]]++; // xét các giá trị a[i] lặp bao nhiêu lần
        }
        for (int i = 0 ; i < chuong.length ; i++) {
            if ( chuong[i] != 0 ) {
                if (i==0) demChuSo[0] += chuong[0];
                int x = i;
                while ( x>0 ) {
                    demChuSo[x%10] += chuong[i];
                    x /= 10;
                }
            }
        }
        for (int i = 1 ; i < 10 ; i++) {
            if ( max < demChuSo[i] ) {
                max = demChuSo[i];
                viTri = i;
            }
        }
        System.out.println("chữ số xuất hiện nhiều nhất trong mảng là: "+viTri+" xuất hiện "+max+" lần");
    }

    // kỹ thuật mảng đánh dấu
    // => sinh ra 1 cái mảng để đánh dấu các điều kiện để tránh lặp lại
    // VD: Tần xuất xuất hiện của các số trong mảng
    public static void tanXuatXuatHiendungKTMDD(int a[]) {
        int[] danhDau = new int[n];
        for (int i = 0 ; i < n ; i++) {
            danhDau[i] = 0; // cho tất cả bằng 0
        }
        int dem;
        for (int i = 0 ; i < n ; i++) {
            if ( danhDau[i]==0 ) { // điều kiện dùng để xác định vị trí chưa đánh dấu
                dem = 1; // tính từ vị trí a[i]
                for (int j = i+1 ; j < n ; j++) {
                    if ( a[i]==a[j] ) {
                        dem++;
                        danhDau[j]=1; // để đánh dấu đã xét
                    }
                }
                System.out.println(a[i] + " xuất hiện " + dem + " lần");
            }
        }
    }

    // Đếm các chữ số khác nhau trong mảng
    public static void demChuSoKhacNhau(int a[]) {
        int[] demChuSo = new int[10];
        for (int i = 0 ; i < n ; i++) {
            demChuSo[i] = 0;
        }
        int[] danhDau = new int[n];
        for (int i = 0 ; i < n ; i++) {
            danhDau[i] = 0; // cho tất cả bằng 0
        }
        int dem;
        for (int i = 0 ; i < n ; i++) {
            if ( danhDau[i]==0 ) { // điều kiện dùng để xác định vị trí chưa đánh dấu
                dem = 1; // tính từ vị trí a[i]
                for (int j = i+1 ; j < n ; j++) {
                    if ( a[i]==a[j] ) {
                        dem++;
                        danhDau[j]=1; // để đánh dấu đã xét
                    }
                }
                if ( a[i]==0 ) demChuSo[0] += dem;
                while ( a[i]>0 ) {
                    demChuSo[a[i]%10] += dem;
                    a[i] /= 10;
                }
            }
        }
        for (int i = 0 ; i < 10 ; i++) {
            if ( demChuSo[i] != 0 ) {
                System.out.println("số "+i+" xuất hiện "+demChuSo[i]+" lần");
            }
        }
    }

    // kỹ thuật mảng con
    // xuất tất cả mảng con trong mảng 1 chiều
    // VD: 1  2  3
    // 1
    // 1  2
    // 1  2  3
    // 2
    // 2  3
    // 3
    public static void inMangCon(int a[]) {
        for (int i = 0 ; i < n ; i++) {
            for (int j = i ; j < n ; j++) {
                for (int k = i ; k <= j ; k++) {
                    System.out.print( a[k] + " ");
                }
                System.out.println();
            }
        }
    }

    // Xuất ra tổng tất cả mảng con
    public static void tongTatCaMangCon(int a[]) {
        int sum = 0;
        for (int i = 0 ; i < n ; i++) {
            for (int j = i ; j < n ; j++) {
                for (int k = i ; k <= j ; k++) {
                    sum += a[k];
                }
            }
        }
        System.out.println("Tổng tất cả mảng con = "+sum);
    }


    public static void main(String[] args) {
//        int[] a = new int[100];
//        n = 5;
//        input(a, n);
//        output(a, n);

//        themVaoViTri(a, 2, 100);
//        System.out.println("Mảng sau khi thêm: ");
//        output(a, n);

//        them0VaoTruocSoChan(a);
//        output(a, n);

//        xoaPhanTu(a, 3);
//        output(a, n);

//        xoaSoLe(a);
//        output(a, n);

//        sapXep(a);
//        output(a, n);

//        demCacPhanTuKhacNhau(a);
//        output(a, n);

//        soLonThuK(a, 3);
//        output(a, n);

//        timKiemTuanTu(a, 3);
//        timKiemNhiPhan(a, 0, n-1, 3);

//        haiPhanTuTongBangK(a, 5);
//        haiPhanTuTongBangKdungSXNP(a, 4);

//        tanXuatXuatHien(a);
//        chuSoXuatHienNhieuNhat(a);

//        tanXuatXuatHiendungKTMDD(a);
//        demChuSoKhacNhau(a);

//        inMangCon(a);
//        tongTatCaMangCon(a);

// --------------------------------------------------------------------------------------------------------------------
        int[] arrayInt = { 1, 6, 9, -3, 10, 13, 4, 3, -2 };

        float[] arrayFloat = { 8, -1, -10, 43, 5, -5, 0 };


        // CÁC BÀI TẬP TÌM KIẾM VÀ LIỆT KÊ
//        bai176(arrayFloat);
//        bai177(arrayFloat);
//        bai178(arrayInt);
//        bai179(arrayInt);


        // KỸ THUẬT TÍNH TỔNG


        // KỸ THUẬT ĐẾM


        // KỸ THUẬT ĐẶT CỜ HIỆU


        // KỸ THUẬT SẮP XẾP


        // KỸ THUẬT THÊM


        // KỸ THUẬT XÓA


        // KỸ THUẬT XỬ LÝ MẢNG


        // KỸ THUẬT XỬ LÝ MẢNG CON


        // XÂY DỰNG MẢNG




    }

    // CÁC BÀI TẬP TÌM KIẾM VÀ LIỆT KÊ
    public static void bai176(float[] a) {
        System.out.print("Bài 176: các số âm trong mảng: ");
        for (int i = 0 ; i < a.length ; i++) if ( a[i] < 0 ) System.out.print( a[i] + "  ");
    }

    public static void bai177(float[] a) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bài 177: Nhập đoạn [x,y]:");
        System.out.print("x = ");
        float x = scanner.nextFloat();
        System.out.print("y = ");
        float y = scanner.nextFloat();
        System.out.println("Các giá trị trong ["+x+","+y+"] là: ");
        lietKeSoTrongDoan(a, x, y);
    }
    public static void lietKeSoTrongDoan(float a[], float x, float y) {
        for (int i = 0 ; i < a.length ; i++) {
            if ( a[i] >= x ) {
                if ( a[i] <= y ) {
                    System.out.print( a[i] + "  ");
                }
            }
        }
    }

    public static void bai178(int a[]) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bài 178: Nhập đoạn [x,y]:");
        System.out.print("x = ");
        float x = scanner.nextFloat();
        System.out.print("y = ");
        float y = scanner.nextFloat();
        System.out.println("Các giá trị chẵn trong ["+x+","+y+"] là: ");
        for (int i = 0 ; i < a.length ; i++) {
            if ( a[i]%2!=0 ) continue;
            if ( a[i] >= x ) {
                if ( a[i] <= y ) {
                    System.out.print( a[i] + "  ");
                }
            }
        }
    }

    public static void bai179(int a[]) {
        System.out.print("Bài 179: Các giá trị thỏa mãn : ");
        for (int i = 0 ; i < a.length-1 ; i++) {
            int test = Math.abs(a[i+1]);
            if ( a[i] > test ) System.out.print(a[i]+"  ");
        }
    }

    public static void bai180() {

    }

    // KỸ THUẬT TÍNH TỔNG

    // KỸ THUẬT ĐẾM

    // KỸ THUẬT ĐẶT CỜ HIỆU

    // KỸ THUẬT SẮP XẾP

    // KỸ THUẬT THÊM

    // KỸ THUẬT XÓA

    // KỸ THUẬT XỬ LÝ MẢNG

    // KỸ THUẬT XỬ LÝ MẢNG CON

    // XÂY DỰNG MẢNG


}
