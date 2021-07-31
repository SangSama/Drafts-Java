package buoi5;

import java.util.Scanner;

public class Buoi5 {

    /*
    * ***CONTENT***
    *
    * FUNCTION:
    * => code mọi thứ trong hàm main sẽ khiến hàm main phức tạp không tại sử dụng code => cần chia hàm
    * => giúp cho chúng ta tái sử dụng lại các đoạn code lặp
    * => cách khai báo hàm: public static returnType functionName(Args )
    * - functionName : quy định như khi đặt tên biến
    * - returnType : void - type
    * - void => không return bất cứ giá trị gì
    * - type => cái hàm này phải được trả về giá trị
    *-----------------------------------------------
    * ===> Khi làm lập trình cần xác định Input và Output của bài toán
    * Input : Danh sách tham số đầu vào
    * Output : kết quả returnType
    *-----------------------------------------------
    * Biến toàn cục và biến cục bộ:
    * Biến toàn cục: Là biến được hiểu trên toàn bộ chương trình, sử dụng được ở mọi nơi trong class
    * Biến cục bộ: Là biến bị giới hạn trong 1 block {}
    *-----------------------------------------------
    * Tham trị và tham chiếu: => địa chỉ bộ nhớ có lưu giá trị
    * Tham trị:
    * => nó chỉ truyền giá trị vào trong hàm
    * => trong hàm thay đổi giá trị của biến cũng không ảnh hưởng đến biến truyền vào
    * => nó truyền giá trị (copy giá trị từ địa chỉ bộ nhớ này sang địa chỉ bộ nhớ khác) chứ không truyền bản thân
    * địa chỉ của biến trong bộ nhớ
    * Tham chiếu:
    * => Thay vì truyền giá trị trong địa chỉ thì chúng ta sẽ truyền địa chỉ ô nhớ
    * => tham chiếu thẳng đến vùng nhớ chính
    * => Object => biến địa chỉ
    *-------------------------------------------------------------------------------------------------
    *
    * ARRAY:
    * Tập hợp => gồm các phần tử có chugn tính chất
    * => Mảng là tập hợp các phần tử có chung với nhau về mặt tính chất
    * VD: có 1000 biến kiểu nguyên, ta không thể nào nhớ hết được
    *     ==> mảng để quản lý các biến chung kiểu
    * => Các phần tử của mảng sẽ nằm trên một vùng nhớ (không phải ô nhớ)
    * => khi chúng ta khai báo mảng thì chúng ta phải khai báo số lượng phần tử của mảng
    * => chương trình sẽ cấp phát cho em 1 vùng nhớ đủ để lưu trữ số lượng phần tử mà ta khai báo
    * ===> cách khai báo mảng:
    * Cách 1: kiểu_dữ_liệu[] tên_mảng = {1,2,3}
    * Cách 2: kiểu_dữ_liệu[] tên_mảng = new kiểu_dữ_liệu[số lượng phần tử]
    * => Mảng đánh dấu vị trí từ 0 đến n-1
    * */


    // biến toàn cục
    public static int x;
    public static int y;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // HÀM - FUNCTION
//
////        print();
////        add(1,2);
////        add(3,4);
//
//        // đếm trong đoạn a,b có bao nhiêu số nguyên tố
//        System.out.print("Nhập a = ");
//        int a = sc.nextInt();
//        System.out.print("Nhập b = ");
//        int b = sc.nextInt();
//        countSNT(a, b);
//        System.out.println("----------------------------------------------------------------------------------------");
//
//        // MẢNG - ARRAY
//        int[] m = {1,2,3,4};
//        int[] n = new int[10];
//        int z = 10;
//        input(n, z);
//        output(n, z);


        // ***** HOMEWORK *****

        // HÀM - FUNCTION
//        bai115();
//        bai116();
//        bai117();
//        bai118();
//        bai119();
//        bai120();
//        bai121();

        // MẢNG - ARRY
        int[] arrayInt = {10,6,41,25,2,3,54,4,125,30,283,13, 331};
        int[] arrInt = { 345, 1221, 132, 131, 12321, 135};
        int[] arrIntPos = { 10, 20, 15 };
        float[] arrayFloat = {30, 2006, 56, 3, 10, 7, 2400, 19, 49};
        float[] arrFloat = {-3, -7, -1, 10, 42, 0, -18, 52, -32};
        float[] arrPhanBiet = { 2, 61, 95, 43, 18, 28, 10, 21, 13 };

//        bai122(arrayFloat);
//        bai123(arrayInt);
//        bai124();
//        bai125(arrayInt);
//        bai126();
//        bai127(arrayFloat);

        // KỸ THUẬT NHẬP XUẤT MẢNG
//        bai128();
//        bai129();
//        bai130(arrayFloat);
//        bai131(arrayInt);
//        bai132(arrayInt);
//        bai133(arrFloat);

        // KỸ THUẬT ĐẶT LÍNH CANH CÁC BÀI TẬP CƠ BẢN
//        bai134(arrayFloat);
//        bai135(arrFloat);
//        bai136(arrayInt);
//        bai137(arrFloat);
//        bai138(arrayInt);
//        bai139(arrayInt);
//        bai140(arrayFloat);
//        bai141(arrayFloat);

        // CÁC BÀI TẬP LUYỆN TẬP
//        bai142(arrFloat);
//        bai143(arrayInt);
//        bai144(arrayInt);
//        bai145(arrayInt);
//        bai146(arrFloat);
//        bai147(arrFloat);
//        bai148(arrayInt);
//        bai149(arrayInt);
//        bai150(arrFloat);
//        bai151(arrayInt);
//        bai152(arrayInt);
//        bai153(arrayInt);
//        bai154(arrFloat);

        // BÀI TẬP LUYỆN TẬP TƯ DUY
//        bai155();
//        bai156();
//        bai157();
//        bai158();
//        bai159(arrayFloat);
//        bai160(arrFloat);
//        bai161(arrayInt);
//        bai162(arrayFloat);
//        bai163(arrayInt);
//        bai164(arrInt);
//        bai165(arrayInt);
//        bai166(arrayInt);
//        bai167(arrInt);
//        bai168(arrayInt);
//        bai169(arrayInt);
//        bai170(arrayInt);
//        bai171(arrIntPos);
//        bai172(arrIntPos);
//        bai173(arrIntPos);
//        bai174(arrPhanBiet);
//        bai175(arrPhanBiet);

    }

    public static boolean check(int a) {
        if ( a < 2 ) return false;
        for (int i = 2 ; i<= Math.sqrt(a); i++) {
            if (a % i == 0) return false;
        }
        return true;
    }

    public static int count(int a, int b) {
        int count = 0;
        for (int i = 0 ; i <= b ; i++) {
            if (check(i)) {
                count++;
            }
        }
        return count;
    }

    public static void countSNT(int a, int b) {
//        int count = 0;
//        for ( int i = a ; i <= b ; i++ ) {
//            boolean check = true;
//            for ( int j = 2 ; j <= Math.sqrt(i) ; j++ ) {
//                if ( i % j == 0 ) {
//                    check = false;
//                    break;
//                }
//            }
//            if (check) count++;
//        }
        int count = count(a, b);
        System.out.println("số nguyên tố trong đoạn "+a+" đến "+b+" là: "+count);
    }

    public static void print() {
        System.out.println("hello world");
    }

    public static int add(int a, int b) {
        return a + b;
    }


    // MẢNG
    public static void input(int[] a) {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < a.length ; i++) {
            System.out.print("a["+i+"] = ");
            a[i] = scanner.nextInt();
        }
    }

    public static void input(float[] a) {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < a.length ; i++) {
            System.out.print("a["+i+"] = ");
            a[i] = scanner.nextFloat();
        }
    }

    public static void input(double[] a) {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < a.length ; i++) {
            System.out.print("a["+i+"] = ");
            a[i] = scanner.nextDouble();
        }
    }

    public static void output(int[] a) {
        for (int i = 0; i < a.length ; i++) {
            System.out.print(a[i]+"  ");
        }
    }

    public static void output(float[] a) {
        for (int i = 0; i < a.length ; i++) {
            System.out.println("a["+i+"] = "+a[i]);
        }
    }


    // ***** HOMEWORK *****

    // HÀM - FUNCTION
    public static void bai115() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bài 115:");
        System.out.print("Nhập họ tên: ");
        String fullName = scanner.nextLine();
        System.out.print("Nhập điểm Toán: ");
        float mathScores = scanner.nextFloat();
        System.out.print("Nhập điểm Văn: ");
        float literatureScores = scanner.nextFloat();
        System.out.println("Điểm trung bình = "+GPA(mathScores, literatureScores));
    }
    public static float GPA(float x, float y) {
        float gpa = (x+y)/2;
        return gpa;
    }

    public static void bai116() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Bài 116: Nhập n = ");
        int n = scanner.nextInt();
        System.out.println("Tổng = "+sum(n));
    }
    public static int sum(int x) {
        int S = 0;
        for (int i = 1; i <= x ; i++) S+=i;
        return S;
    }

    public static void bai117() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Bài 117: Nhập n = ");
        int n = scanner.nextInt();
        System.out.print("Nhập x = ");
        int x = scanner.nextInt();
        System.out.println("Tổng = "+sum(x, n));
    }
    public static int sum(int x, int n) {
        int S = 0;
        for (int i = 1; i <= n ; i++) S += Math.pow(x,i);
        return S;
    }

    public static void bai118() {
        // Viết lại các bài tập trong các chương trước bằng kỹ thuật lập trình hàm
        // ==> làm tại HW buoi 4 ^^ - chương 3: các cấu trúc điều khiển
    }

    public static void bai119() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Bài 119: Nhập số nguyên n = ");
        int n = scanner.nextInt();
        System.out.print("Số nguyên tố nhỏ hơn "+n+" là: ");
        for (int i = 2 ; i < n ; i++ ) if (checkSNT(i)) System.out.print(i+"   ");
    }

    public static void bai120() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Bài 120: Nhập số nguyên n = ");
        int n = scanner.nextInt();
        System.out.print("Số chính phương nhỏ hơn "+n+" là: ");
        for (int i = 1 ; i < n ; i++) if (checkSCP(i)) System.out.print(i+"   ");
    }
    public static boolean checkSCP(int x) {
        boolean check = false;
        int test = (int) Math.sqrt(x);
        if ( test*test == x ) check = true;
        return check;
    }

    public static void bai121() {
        System.out.print("Bài 121: Số Armstrong trong [1, 1.000.000] : ");
        for (int i = 1 ; i <= 1000000 ; i++) {
            int test = tinh(i, demChuSo(i));
            if (i == test) {
                System.out.print(i+", ");
            }
        }
    }
    public static int tinh(int x, int count) {
        boolean check = false;
        int S = 0;
        while ( x > 0 ) {
            S += Math.pow(x%10, count);
            x /= 10;
        }
        return S;
    }
    public static int demChuSo(int x) {
        int count = 0;
        while ( x > 0 ) {
            count++;
            x/=10;
        }
        return count;
    }


    // MẢNG - ARRAY
    public static void bai122(float[] arr) {
        float max = arr[0];
        for (int i = 1; i < arr.length ; i++) {
            if ( max < arr[i]) max = arr[i];
        }
        System.out.println("Bài 122: max = "+max);
    }

    public static void bai123(int[] arr) {
        int location = -1;
        int min = arr[0];
        for (int i = 1; i < arr.length ; i++) {
            if ( min > arr[i]) {
                min = arr[i];
                location = i;
            }
        }
        System.out.println("Bài 122: location min = "+location);
    }

    public static void bai124() {
        System.out.println("Bài 124: Nhập mảng có 5 phần tử: ");
        int[] arr = new int[5];
        input(arr);
//        for (int i = 0 ; i < arr.length ; i++) {
//            System.out.println("a["+i+"] = ");
//            arr[i] = scanner.nextInt();
//        }
//        boolean check = false;
//        for (int i = 0; i < arr.length ; i++) {
//            if ( arr[i]%2==0 && arr[i]<2004) {
//                check = true;
//                break;
//            }
//        }
        if (checkBai124(arr, 2004)) System.out.println("tồn tại giá trị chẵn nhỏ hơn 2004");
        else System.out.println("Không tồn tại giá trị chẵn nhỏ hơn 2004");
    }
    public static boolean checkBai124(int[] a, int x) {
        boolean check = false;
        for (int i = 0; i < a.length ; i++) {
            if ( a[i]%2==0 && a[i]<x) {
                check = true;
                break;
            }
        }
        return check;
    }

    public static void bai125(int[] a) {
        int count = 0;
        for (int i = 0 ; i < a.length ; i++ ) {
            if ( a[i] > 2 && a[i] < 100 && checkSNT(a[i])) count++;
        }
        System.out.println("Bài 125:  số lượng số nguyên tố nhỏ hơn 100 trong mảng: "+count);
    }
    public static boolean checkSNT(int x) {
        boolean check = true;
        for (int i = 2 ; i <= Math.sqrt(x) ; i++) {
            if ( x%i == 0 ) {
                check = false;
                break;
            }
        }
        return check;
    }

    public static void bai126() {
        System.out.println("Bài 124: Nhập mảng có 5 phần tử: ");
        float[] arr = new float[5];
        input(arr);
        System.out.println("tổng các giá trị âm = "+sumA(arr));
    }
    public static float sumA(float[] a) {
        float S = 0;
        for (int i = 0 ; i < a.length ; i++) {
            if ( a[i] < 0 ) S += a[i];
        }
        return S;
    }

    public static void bai127(float[] a) {
        System.out.println("Bài 127: sắp xếp mảng:");
        for (int i = 0 ; i < a.length ; i++) {
            for (int j = i + 1; j < a.length ; j++) {
                float stp;
                if ( a[i] > a[j]) {
                    stp = a[i];
                    a[i] = a[j];
                    a[j] = stp;
                }
            }
        }
        output(a);
    }


    // KỸ THUẬT NHẬP XUẤT MẢNG
    public static void bai128() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Bài 128: Nhập mảng có n phần tử = ");
        int n = scanner.nextInt();
        float[] a = new float[n];
        input(a);
    }

    public static void bai129() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Bài 128: Nhập mảng có n phần tử = ");
        int n = scanner.nextInt();
        int[] a = new int[n];
        input(a);
    }

    public static void bai130(float[] a) {
        System.out.println("Bài 130: xuất mảng: ");
        output(a);
    }

    public static void bai131(int[] a) {
        System.out.println("Bài 131: xuất mảng: ");
        output(a);
    }

    public static void bai132(int[] a) {
        System.out.print("Bài 132: các giá trị chẵn: ");
        for (int i = 0 ; i < a.length ; i++) if ( a[i] % 2 == 0 ) System.out.print(a[i]+"  ");
    }

    public static void bai133(float[] a) {
        System.out.print("Bài 133: các giá trị âm: ");
        for (int i = 0 ; i < a.length ; i++) if ( a[i] < 0 ) System.out.print(a[i]+"  ");
    }


    // KỸ THUẬT ĐẶT LÍNH CANH CÁC BÀI TẬP CƠ BẢN
    public static void bai134(float[] a) {
        float max = a[0];
        for (int i = 1; i < a.length ; i++) {
            if ( max < a[i] ) {
                max = a[i];
            }
        }
        System.out.println("Bài 134: Gía trị lớn nhất = "+max);
    }

    public static void bai135(float[] a) {
        float soDuong = -1;
        for (int i = 0 ; i < a.length ; i++) {
            if ( a[i] > 0 ) {
                soDuong = a[i];
                break;
            }
        }
        System.out.println("Bài 135: Gía trị dương đầu tiên? = "+soDuong);
    }

    public static void bai136(int[] a) {
        int soDuong = -1;
        for (int i = a.length-1 ; i >= 0 ; i--) {
            if ( a[i] > 0 ) {
                soDuong = a[i];
                break;
            }
        }
        System.out.println("Bài 136: Gía trị dương cuối cùng? = "+soDuong);
    }

    public static void bai137(float[] a) {
        int vitri = -1;
        float min = a[0];
        for (int i = 1 ; i < a.length ; i++ ) {
            if ( a[i] < min ) {
                min = a[i];
                vitri = i;
            }
        }
        System.out.println("Bài 137: Vị trí của giá trị nhỏ nhất = "+vitri);
    }

    public static void bai138(int[] a) {
        int vitri = -1;
        for (int i = 0 ; i < a.length ; i++) {
            if ( a[i] % 2 == 0 ) {
                vitri = i;
                break;
            }
        }
        System.out.println("Bài 138: vị trí của giá trị chẵn đầu tiên: "+vitri);
    }

    public static void bai139(int[] a) {
        int vitri = -1;
        for (int i = a.length-1 ; i >= 0 ; i--) {
            if ( soHoanThien(a[i]) ) {
                vitri = i;
                break;
            }
        }
        System.out.println("Bài 139: vị trí của số hoàn thiện cuối cùng: "+vitri);
    }
    public static boolean soHoanThien(int x) {
        boolean check = false;
        int S = 0;
        for (int i = 1 ; i <= x/2 ; i++){
            if ( x % i == 0 ) S+=i;
        }
        if (S == x) check = true;
        return check;
    }

    public static void bai140(float[] a) {
        float min = -1;
        for (int i = 0 ; i < a.length ; i++) {
            if ( a[i] > 0 && (min == -1 || min > a[i]) ) min = a[i];
        }
        System.out.println("Bài 140: giá trị dương nhỏ nhất: "+min);
    }

    public static void bai141(float[] a) {
        int vitri = -1;
        float min = -1;
        for (int i = 0 ; i < a.length ; i++) {
            if ( a[i] > 0 && (min == -1 || min > a[i]) ) {
                min = a[i];
                vitri = i;
            }
        }
        System.out.println("Bài 141: vị trí của giá trị dương nhỏ nhất: "+vitri);
    }


    // CÁC BÀI TẬP LUYỆN TẬP
    public static void bai142(float[] a) {
        float min = a[0];
        for (int i = 1 ; i < a.length ; i++) if(min > a[i]) min = a[i];
        System.out.println("Bài 142: giá trị nhỏ nhất = "+min);
    }

    public static void bai143(int[] a) {
        int test = -1;
        for (int i = 0 ; i < a.length ; i++) {
            if ( a[i]%2 == 0 ) {
                test = a[i];
                break;
            }
        }
        System.out.println("Bài 143: số chẵn đầu tiên = "+test);
    }

    public static void bai144(int[] a) {
        int test = -1;
        for (int i = 0 ; i < a.length ; i++) {
            if ( a[i] <= 1 ) continue;
            if (checkSNT(a[i])) {
                test = a[i];
                break;
            }
        }
        System.out.println("Bài 144: số nguyên tố đầu tiên = "+test);
    }

    public static void bai145(int[] a) {
        int test = -1;
        for (int i = 0 ; i < a.length ; i++) {
            if ( a[i] <= 0 ) continue;
            if (soHoanThien(a[i])) {
                test = a[i];
                break;
            }
        }
        System.out.println("Bài 145: số hoàn thiện đầu tiền = "+test);
    }

    public static void bai146(float[] a) {
        float test = 1;
        for (int i = 0 ; i < a.length ; i++) {
            if ( a[i] < 0 ) {
                test = a[i];
                break;
            }
        }
        System.out.println("Bài 146: số âm đầu tiền = "+test);
    }

    public static void bai147(float[] a) {
        float test = -1;
        for (int i = a.length-1 ; i >= 0 ; i--) {
            if ( a[i] > 0 ) {
                test = a[i];
                break;
            }
        }
        System.out.println("Bài 147: số dương cuối cùng = "+test);
    }

    public static void bai148(int[] a) {
        int test = -1;
        for (int i = a.length-1 ; i >= 0 ; i--) {
            if ( a[i] <= 1 ) continue;
            if (checkSNT(a[i])) {
                test = a[i];
                break;
            }
        }
        System.out.println("Bài 148: số nguyên tố cuối cùng = "+test);
    }

    public static void bai149(int[] a) {
        int test = -1;
        for (int i = a.length-1 ; i >= 0 ; i--) {
            if ( a[i] <= 0 ) continue;
            if (soHoanThien(a[i])) {
                test = a[i];
                break;
            }
        }
        System.out.println("Bài 149: số hoàn thiện cuối cùng = "+test);
    }

    public static void bai150(float[] a) {
        float test = 0;
        for (int i = 0 ; i < a.length ; i++) if ( a[i]<0 && (test==0 || test<a[i])) test = a[i];
        System.out.println("Bài 150: giá trị âm lớn nhất = "+test);
    }

    public static void bai151(int[] a) {
        int test = 0;
        for (int i = 0 ; i < a.length ; i++) {
            if ( a[i] <= 1 ) continue;
            if ( checkSNT(a[i]) && (test==0 || test<a[i])) test = a[i];
        }
        System.out.println("Bài 151: số nguyên tố lớn nhất = "+test);
    }

    public static void bai152(int[] a) {
        int min = 0;
        for (int i = 0 ; i < a.length ; i++) {
            if ( a[i] <= 0 ) continue;
            if ( soHoanThien(a[i]) && (min == 0 || min > a[i])) min = a[i];
        }
        System.out.println("Bài 152: số hoàn thiện nhỏ nhất = "+min);
    }

    public static void bai153(int[] a) {
        int test = -1;
        for (int i = 0 ; i < a.length ; i++) if ( a[i]%2==0 && (test==-1 || test>a[i])) test=a[i];
        System.out.println("Bài 153: giá trị chẵn nhỏ nhất = "+test);
    }

    public static void bai154(float[] a) {
        int vitri = -1;
        float test = 0;
        for (int i = 0 ; i < a.length ; i++) {
            if ( a[i]<0 && (test==0 || test<a[i]) ) {
                test = a[i];
                vitri = i;
            }
        }
        System.out.println("Bài 154: Vị trí giá trị âm lớn nhất = "+vitri);
    }


    // BÀI TẬP LUYỆN TẬP TƯ DUY
    public static void bai155() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Bài 155: Nhập số mảng có số phần tử là: ");
        int n = scanner.nextInt();
        int[] arrInt = new int[n];
        input(arrInt);
        System.out.print("Nhập x = ");
        int x = scanner.nextInt();
        int xanhat = Math.abs( arrInt[0] - x );
        int result = arrInt[0];
        for (int i = 1 ; i < arrInt.length ; i++) if (xanhat < Math.abs(arrInt[i]-x)) {
            xanhat = Math.abs(arrInt[i]-x);
            result = arrInt[i];
        }
        System.out.println("Giá trị trong mảng xa giá trị "+x+" nhất: "+result);
    }

    public static void bai156() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Bài 156: Nhập số mảng có số phần tử là: ");
        int n = scanner.nextInt();
        float[] arrF = new float[n];
        input(arrF);
        System.out.print("Nhập x = ");
        float x = scanner.nextFloat();
        float gannhat = Math.abs( arrF[0] - x );
        float result = arrF[0];
        for (int i = 1 ; i < arrF.length ; i++) if (gannhat > Math.abs(arrF[i]-x)) {
            gannhat = Math.abs(arrF[i]-x);
            result = arrF[i];
        }
        System.out.println("Giá trị trong mảng gần giá trị "+x+" nhất: "+result+" với khoảng cách "+gannhat);
    }

    public static void bai157() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Bài 157: Nhập số mảng có số phần tử là: ");
        int n = scanner.nextInt();
        int[] arrInt = new int[n];
        input(arrInt);
        int min = arrInt[0];
        int max = arrInt[0];
        for (int i = 1 ; i < arrInt.length ; i++) {
            if (max < arrInt[i]) max = arrInt[i];
            if (min > arrInt[i]) min = arrInt[i];
        }
        System.out.println("Đoạn chứa tất cả các giá trị tỏng mảng là: ["+min+","+max+"]");
    }

    public static void bai158() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Bài 158: Nhập số mảng có số phần tử là: ");
        int n = scanner.nextInt();
        double[] arrF = new double[n];
        input(arrF);
        int min = (int) Math.floor(arrF[0]);
        int max = (int) Math.ceil(arrF[0]);
        for (int i = 1 ; i < arrF.length ; i++) {
            if (max < arrF[i]) max = (int) Math.ceil(arrF[i]);
            if (min > arrF[i]) min = (int) Math.floor(arrF[i]);
        }
        max = Math.abs(max);
        min = Math.abs(min);
        if ( min > max ) max = min;
        System.out.println("Đoạn chứa tất cả các giá trị trong mảng là: [-"+max+","+max+"]");
    }

    public static void bai159(float[] a) {
        float dautien = 0;
        for (int i = 0 ; i < a.length ; i++) {
            if ( a[i] > 2003 ) {
                dautien = a[i];
                break;
            }
        }
        System.out.println("Bài 159: giá trị đầu tiên lớn hơn 2003 = "+dautien);
    }

    public static void bai160(float[] a) {
        float cuoicung = 0;
        for (int i = a.length-1 ; i >= 0 ; i--) {
            if ( a[i]<0 && a[i]>-1 ) {
                cuoicung = a[i];
                break;
            }
        }
        System.out.println("Bài 160: giá trị âm cuối cùng lớn hơn -1 = "+cuoicung);
    }

    public static void bai161(int[] a) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bài 161: Nhập khoảng (x,y) cần tìm: ");
        System.out.print("x = ");
        int x = scanner.nextInt();
        System.out.print("y = ");
        int y = scanner.nextInt();
        int result = x;
        for (int i = 0 ; i < a.length ; i++) {
            if ( a[i]>x && a[i]<y ) {
                result = a[i];
                break;
            }
        }
        System.out.println("Gía trị đầu tiên trong khoảng ("+x+","+y+") là: "+result);
    }

    public static void bai162(float[] a) {
        int vitri = -1;
        for (int i = 0 ; i < a.length ; i++) {
            for (int j = 1 ; j < a.length ; j++) {
                if (a[j-1]*a[j]==a[i]) {
                    vitri = i;
                    break;
                }
            }
        }
        System.out.println("Vị trí cần tìm là: "+vitri);
    }

    public static void bai163(int[] a) {
        int test = -1;
        for (int i = 0 ; i < a.length ; i++) {
            if (a[i] <= 0) continue;
            if (checkSCP(a[i])) {
                test = a[i];
                break;
            }
        }
        System.out.println("Bài 163: số chính phương đầu tiên trong mảng = "+test);
    }

    public static void bai164(int[] a) {
        int result = -1;
        for (int i = 0 ; i < a.length ; i++) {
            if ( checkSG(a[i])) {
                result = a[i];
                break;
            }
        }
        System.out.println("Bài 164: giá trị mang tính chất số gánh đầu tiên là: "+result);
    }
    public static boolean checkSG(int x) {
        boolean check = false;
        int m = 0;
        int l = x;
        int count = 0;
        for ( int i = 0 ; l > 0 ; i++ ) {
            m = (m*10 + l%10);
            l /= 10;
            count++;
        }
        if ( m==x && count%2==1 ) check = true;
        return check;
    }

    public static void bai165(int[] a) {
        int result = 0;
        for (int i = 0 ; i < a.length ; i++) {
            if ( a[i]%2==1 ) {
                result = a[i];
                break;
            }
        }
        System.out.println("Bài 165: chữ số lẻ đầu tiên = "+result);
    }

    public static void bai166(int[] a) {
        int result = 0;
        for (int i = 0 ; i < a.length ; i++) {
            if ( checkDang2muk(a[i])) {
                result = a[i];
                break;
            }
        }
        System.out.println("Bài 166: chữ số dạng 2^k đầu tiên = "+result);
    }
    public static boolean checkDang2muk(int x) {
        boolean check = false;
        for ( int i = 1 ; i <= x ; i++ ) {
            if ( x == Math.pow(2, i)) {
                check = true;
                break;
            }
            if ( x < Math.pow(2, i)) break;
        }
        return check;
    }

    public static void bai167(int[] a) {
        int result = 0;
        for (int i = 0 ; i < a.length ; i++) {
            if (checkToanLe(a[i]) && (result==0 || result<a[i])) {
                result = a[i];
            }
        }
        System.out.println("Bài 167: giá trị toàn chữ số lẻ lớ nhất = "+result);
    }
    public static boolean checkToanLe(int x) {
        boolean check = true;
        while (x>0) {
            int test = x%10;
            if (test%2==0) {
                check = false;
                break;
            }
            x /= 10;
        }
        return check;
    }

    public static void bai168(int[] a) {
        int result = 0;
        for (int i = 0 ; i < a.length ; i++) {
            if (checkDang5muk(a[i]) && (result==0 || result<a[i])) {
                result = a[i];
            }
        }
        System.out.println("Bài 168: giá trị dạng 5^k lớ nhất = "+result);
    }
    public static boolean checkDang5muk(int x) {
        boolean check = false;
        for ( int i = 1 ; i <= x ; i++ ) {
            if ( x == Math.pow(5, i)) {
                check = true;
                break;
            }
            if ( x < Math.pow(5, i)) break;
        }
        return check;
    }

    public static void bai169(int[] a) {
        System.out.println("Bài 169: Sắp xếp lại mảng:");
        sapXepTangDan(a);
        output(a);
        int soChan = -1;
        if ( soLeNhoNhat(a) == -1 ) soChan = a[a.length-1];
        else {
            for (int i = soLeNhoNhat(a)-1 ; i >= 0 ; i--) {
                if ( a[i]%2==0 ) {
                    soChan = a[i];
                    break;
                }
            }
        }
        System.out.println("Số cần tìm là: "+soChan);

    }
    public static void sapXepTangDan(int a[]) {
        for (int i = 0 ; i < a.length-1 ; i++) {
            for (int j = i+1 ; j < a.length ; j++) {
                if ( a[i] > a[j] ) {
                    int temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
            }
        }
    }
    public static int soLeNhoNhat(int a[]) {
        int viTri = -1;
        for (int i = 0 ; i < a.length ; i++) {
            if (a[i]%2!=0) {
                viTri = i;
                break;
            }
        }
        return viTri;
    }

    public static void bai170(int[] a) {
        System.out.println("Bài 170: Sắp xếp lại mảng:");
        sapXepGiamDan(a);
        output(a);
        if ( checkSNT(a[0])==false ) System.out.println("Không có giá trị thỏa mãn");
        else {
            for (int i = 1 ; i < a.length ; i++) {
                if ( checkSNT(a[i])==false ) {
                    System.out.println("Sô cần tìm là: "+a[i-1]);
                    break;
                }
            }
        }
    }
    public static void sapXepGiamDan(int a[]) {
        for (int i = 0 ; i < a.length-1 ; i++) {
            for (int j = i+1 ; j < a.length ; j++) {
                if ( a[i] < a[j] ) {
                    int temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
            }
        }
    }

    public static void bai171(int[] a) {
        int ucln = UCLNcua2So(a[0], a[1]);
        for (int i = 2 ; i < a.length ; i++) {
            ucln = UCLNcua2So( ucln, a[i]);
            if ( ucln==1 ) break;
        }
        System.out.println("Bài 171: UCLN = "+ucln);
    }
    public static int UCLNcua2So(int a, int b) {
        int ucln = 0;
        int max = a > b ? a : b;
        int min = a < b ? a : b;
        for ( int i = min ; i >= 1; i-- ) {
            if ( min%i == 0 && max%i == 0 ) {
                ucln = i;
                break;
            }
        }
        return ucln;
    }

    public static void bai172(int[] a) {
        int bcnn = BCNNcua2So(a[0], a[1]);
        for (int i = 2 ; i < a.length ; i++) {
            bcnn = BCNNcua2So( bcnn, a[i]);
        }
        System.out.println("Bài 172: BCNN = "+bcnn);
    }
    public static int BCNNcua2So(int a, int b) {
        int bcnn = 0;
        int max = a > b ? a : b;
        int min = a < b ? a : b;
        if ( a == b ) bcnn = a;
        else {
            for ( int i = max ; i <= a*b ; i++ ) {
                if ( i%a == 0 && i%b == 0 ) {
                    bcnn = i;
                    break;
                }
            }
        }
        return bcnn;
    }

    public static void bai173(int[] a) {
        int[] demChuSo = new int[10];
        for (int i = 0 ; i < 10 ; i++) {
            demChuSo[i] = 0;
        }
        int[] danhDau = new int[a.length];
        for (int i = 0 ; i < a.length ; i++) {
            danhDau[i] = 0; // cho tất cả bằng 0
        }
        int dem;
        for (int i = 0 ; i < a.length ; i++) {
            if ( danhDau[i]==0 ) { // điều kiện dùng để xác định vị trí chưa đánh dấu
                dem = 1; // tính từ vị trí a[i]
                for (int j = i+1 ; j < a.length ; j++) {
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
        int soLan = demChuSo[0];
        int timChuSo = -1;
        for (int i = 1 ; i < 10 ; i++) {
            if ( demChuSo[i] != 0 ) {
                if ( soLan > demChuSo[i] ) {
                    soLan = demChuSo[i];
                    timChuSo = i;
                }
            }
        }
        System.out.println("Bài 173: chữ số xuất hiện ít nhất trong mảng là "+timChuSo+" xuất hiện "+soLan+" lần");
    }

    public static void bai174(float[] a) {
        System.out.println("Bài 174: Sắp xếp lại mảng:");
        sapXepTangDan(a);
        output(a);
        System.out.println(" các cặp già trị (a,b) thảo mãn a<=b :");
        for (int i = 0 ; i < a.length ; i++) {
            for (int j = i + 1 ; j < a.length ; j++) {
                System.out.println("("+a[i]+","+a[j]+") , ");
            }
        }
    }
    public static void sapXepTangDan(float a[]) {
        for (int i = 0 ; i < a.length-1 ; i++) {
            for (int j = i+1 ; j < a.length ; j++) {
                if ( a[i] > a[j] ) {
                    float temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
            }
        }
    }

    public static void bai175(float[] a) {
        System.out.println("Bài 175: Sắp xếp lại mảng:");
        sapXepTangDan(a);
        output(a);
        float ganNhauNhat = 0;
        float so01 = -1 , so02 = -1;
        for (int i = 0 ; i < a.length-1 ; i++) {
            float test = a[i+1] - a[i];
            if ( ganNhauNhat == 0 || ganNhauNhat > test ) {
                ganNhauNhat = test;
                so01 = a[i];
                so02 = a[i+1];
            }
        }
        System.out.println("Hai số gần nhau nhất là "+so01+" và "+so02);
    }

}
