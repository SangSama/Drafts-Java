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
        int[] arrayInt = { 2, 6, 9, -8, 10, 13, 8, 58, -52, 10, 4 };

        float[] arrayFloat = { 8, -1, -10, 20, 5, -5, 20, 20 };
        float[] arrFloatPT = { 1, 2, 5, 3, 8, 7, 12, 6, 9, 4, 10, 11};


        // CÁC BÀI TẬP TÌM KIẾM VÀ LIỆT KÊ
//        bai176(arrayFloat);
//        bai177(arrayFloat);
//        bai178(arrayInt);
//        bai179(arrayInt);
//        bai180(arrayInt);
//        bai181(arrayInt);
//        bai182(arrayFloat);
//        bai183(arrayFloat);
//        bai184(arrayInt);
//        bai185(arrayInt);
//        bai186(arrayFloat);
//        bai187(arrayFloat);
//        bai188(arrayInt);
//        bai189(arrayInt);
//        bai190(arrayInt);
//        bai191(arrayFloat);
//        bai192(arrayInt);
//        bai193(arrayInt);
//        bai194(arrayInt);
//        bai195(arrFloatPT);
//        bai196(arrayFloat);
//        bai197();
//        bai198();
//        bai199();


        // KỸ THUẬT TÍNH TỔNG
//        bai200(arrayInt);
//        bai201(arrayFloat);
//        bai202(arrayInt);
//        bai203(arrayInt);
//        bai204(arrayFloat);
//        bai205(arrayFloat);
//        bai206(arrayFloat);
//        bai207(arrayFloat);
//        bai208(arrayInt);
//        bai209(arrayInt);
//        bai210(arrayInt);
//        bai211(arrayInt);
//        bai212(arrayFloat);
//        bai213(arrayFloat);
//        bai214(arrayFloat);
//        bai215(arrayInt);


        // KỸ THUẬT ĐẾM
//        bai216(arrayInt);
//        bai217(arrayInt);
//        bai218(arrayInt);
//        bai219(arrayFloat);
//        bai220(arrayInt);
//        bai221(arrayInt);
//        bai222(arrayInt);
//        bai223(arrayInt);
//        bai224(arrayInt);
//        bai225(arrayFloat);
//        bai226(arrayInt);
//        bai227(arrayInt);
//        bai228(arrayInt);
//        bai229(arrayInt);


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

    public static void bai180(int a[]) {
        System.out.print("Bài 180: Các giá trị thỏa mãn : ");
        for (int i = 1 ; i < a.length-1 ; i++) {
            int truoc = Math.abs(a[i-1]);
            int sau = Math.abs(a[i+1]);
            if ( a[i] <= truoc || a[i] >= sau ) continue;
            System.out.print( a[i] + "  ");
        }
    }

    public static void bai181(int a[]) {
        System.out.print("Bài 181: Gía trị cần tìm: ");
        if ( checkSoChan(a[0]) && checkSoChan(a[1]) ) System.out.print( a[0] + "  ");
        for (int i = 1 ; i < a.length-1 ; i++) {
            if ( checkSoChan(a[i]) ) {
                if ( checkSoChan(a[i-1]) || checkSoChan(a[i+1]) ) {
                    System.out.print( a[i] + "  ");
                }
            }
        }
        if ( checkSoChan(a[a.length-1]) && checkSoChan(a[a.length-2]) ) System.out.print( a[a.length-1] + "  ");
    }
    public static boolean checkSoChan(int x) {
        if ( x % 2 == 0 ) return true;
        else return false;
    }

    public static void bai182(float a[]) {
        System.out.print("Bài 181: Gía trị cần tìm: ");
        if ( a[0]*a[1]<0 ) System.out.print( a[0] + "  ");
        for (int i = 1 ; i < a.length-1 ; i++) {
            if ( a[i]*a[i-1]<0 || a[i]*a[i+1]<0 ) {
                System.out.print( a[i] + "  ");
            }
        }
        if ( a[a.length-1]*a[a.length-2]<0 ) System.out.print( a[a.length-1] + "  ");
    }

    public static void bai183(float a[]) {
        System.out.print("Bài 183: các vị trí của giá trị lớn nhất:  ");
        for (int i = viTriGiaTriLonNhat(a) ; i < a.length ; i++) {
            if ( a[i] == a[viTriGiaTriLonNhat(a)] ) System.out.print(i+" ");
        }
    }
    public static int viTriGiaTriLonNhat(float a[]) {
        float max = a[0];
        int viTri = -1;
        for (int i = 1 ; i < a.length ; i++) {
            if ( max < a[i] ) {
                max = a[i];
                viTri = i;
            }
        }
        return viTri;
    }

    public static void bai184(int a[]) {
        System.out.print("Bài 184: Các vị trí số nguyên tố:  ");
        for (int i = 0 ; i < a.length ; i++) {
            if ( checkSNT(i) ) System.out.print(i + "  ");
        }
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

    public static void bai185(int a[]) {
        System.out.print("Bài 185: Các vị trí số chính phương:  ");
        for (int i = 0 ; i < a.length ; i++) {
            if ( checkSCP(i) ) System.out.print(i + "  ");
        }
    }
    public static boolean checkSCP(int x) {
        boolean check = false;
        int test = (int) Math.sqrt(x);
        if ( test*test == x ) check = true;
        return check;
    }

    public static void bai186(float a[]) {
        int viTri = viTriGiaTriAmDauTien(a);
        if ( viTri==-1 ) System.out.println("Bài 186: Không có giá trị âm");
        else {
            System.out.print("Bài 186: Vị trí giá trị cần tìm:  ");
            for (int i = viTri ; i < a.length ; i++) {
                if ( a[i] == a[viTri] ) System.out.print( i + " ");
            }
        }
    }
    public static int viTriGiaTriAmDauTien(float a[]) {
        int viTri = -1;
        for (int i = 0 ; i < a.length ; i++) {
            if ( a[i]<0 ) {
                viTri = i;
                break;
            };
        }
        return viTri;
    }

    public static void bai187(float a[]) {
        int viTri = viTriGTDNN(a);
        if ( viTri==-1 ) System.out.println("Bài 187: Không có giá trị dương");
        else {
            System.out.print("Bài 187: Vị trí giá trị cần tìm:  ");
            for (int i = viTri ; i < a.length ; i++) {
                if ( a[i] == a[viTri] ) System.out.print( i + " ");
            }
        }
    }
    public static int viTriGTDNN(float a[]) {
        int viTri = -1;
        float min = -1;
        for (int i = 0 ; i < a.length ; i++) {
            if ( a[i]>0 ) {
                if ( min==-1 || min>a[i] ) {
                    min = a[i];
                    viTri=i;
                }
            };
        }
        return viTri;
    }

    public static void bai188(int a[]) {
        int viTri = viTriChanLN(a);
        if ( viTri==-1 ) System.out.println("Bài 188: Không có giá trị chẵn");
        else {
            System.out.print("Bài 188: Vị trí giá trị cần tìm:  ");
            for (int i = viTri ; i < a.length ; i++) {
                if ( a[i] == a[viTri] ) System.out.print( i + " ");
            }
        }
    }
    public static int viTriChanLN(int a[]) {
        int viTri = -1;
        int max = -1;
        for (int i = 0 ; i < a.length ; i++) {
            if ( a[i]%2==0 ) {
                if ( max==-1 || max<a[i] ) {
                    max = a[i];
                    viTri=i;
                }
            };
        }
        return viTri;
    }

    public static void bai189(int a[]) {
        System.out.print("Bài 189: Gía trị chữ số đầu lẻ:  ");
        for (int i = 0 ; i < a.length ; i++) {
            if ( checkDauLe(a[i]) ) System.out.print( a[i] + " ");
        }
    }
    public static boolean checkDauLe(int x) {
        int test = Math.abs(x);
        boolean check = false;
        while ( test > 0 ) {
            if ( (test%10)%2!=0 ) check = true;
            else check = false;
            test /= 10;
        }
        return check;
    }

    public static void bai190(int a[]) {
        System.out.print("Bài 190: Gía trị chữ số toàn lẻ: ");
        for (int i = 0 ; i < a.length ; i++) {
            if ( checkToanLe(a[i]) ) System.out.print( a[i] + "  ");
        }
    }
    public static boolean checkToanLe(int x) {
        int test = Math.abs(x);
        boolean check = true;
        while ( test > 0 ) {
            if ( (test%10)%2==0 ) {
                check = false;
                break;
            }
            test /= 10;
        }
        return check;
    }

    public static void bai191(float a[]) {
        System.out.println("Bài 191: Các giá trị cần tìm:  ");
        if ( a[0] > a[1] ) {
            System.out.print(a[0] + "  ");
            phanTuCucDai(a, 2);
        }
        else {
            phanTuCucDai(a, 1);
        }
    }
    public static void phanTuCucDai(float a[], int x) {
        for (int i = x ; i < a.length-1 ; i++) {
            if ( a[i]<=a[i-1] || a[i]<=a[i+1] ) continue;
            System.out.print(a[i] + "  ");
            i++;
        }
        if ( a[a.length-1] > a[a.length-2] ) System.out.print(a[a.length-1] + "  ");
    }

    public static void bai192(int a[]) {
        System.out.print("Bài 192: Gía trị chữ số đầu chẵn:  ");
        for (int i = 0 ; i < a.length ; i++) {
            if ( checkDauChan(a[i]) ) System.out.print( a[i] + " ");
        }
    }
    public static boolean checkDauChan(int x) {
        int test = Math.abs(x);
        boolean check = false;
        while ( test > 0 ) {
            if ( (test%10)%2==0 ) check = true;
            else check = false;
            test /= 10;
        }
        return check;
    }

    public static void bai193(int a[]) {
        System.out.println("Bài 193: ");
        for (int i = 0 ; i < a.length ; i++) {
            if ( checkDang3muk(a[i]) ) a[i] = 0;
        }
        output(a);
    }
    public static boolean checkDang3muk(int x) {
        boolean check = false;
        for ( int i = 1 ; i <= x ; i++ ) {
            if ( x == Math.pow(3, i)) {
                check = true;
                break;
            }
            if ( x < Math.pow(3, i)) break;
        }
        return check;
    }
    public static void output(int[] a) {
        for (int i = 0; i < a.length ; i++) {
            System.out.print(a[i]+"  ");
        }
    }

    public static void bai194(int a[]) {
        System.out.print("Bài 194: cặp giá trị cần tìm:  ");
        for (int i = 0 ; i < a.length-1 ; i++) {
            if ( Math.abs(a[i]-a[i+1]) == giaTriCapGanNhat(a) ) {
                System.out.print(" ("+a[i]+","+a[i+1]+")  ");
            }
        }
    }
    public static int giaTriCapGanNhat(int a[]) {
        int min = Math.abs(a[0]-a[1]);
        for (int i = 1; i < a.length-1 ; i++) {
            if ( Math.abs(a[i]-a[i+1]) < min ) {
                min = Math.abs(a[i]-a[i+1]);
            }
        }
        return min;
    }

    public static void bai195(float a[]) {
        System.out.print("Bài 195: các bộ 3 giá trị thỏa mãn: ");
        for (int i = 0 ; i < a.length ; i++) {
            for (int j = 0 ; j < a.length ; j++) {
                if ( j == i ) continue;
                for (int k = 0 ; k < a.length ; k++) {
                    if ( k == i || k == j ) continue;
                    if ( a[i] == a[j] + a[k] ) {
                        System.out.print( " ("+a[i]+","+a[j]+","+a[k]+")  ");
                    }
                }
            }
        }
    }

    public static void bai196(float a[]) {
        System.out.print("Bài 196: Các số âm:  ");
        for (int i = 0 ; i < a.length ; i++) {
            if ( a[i] < 0 ) System.out.print( a[i] + "  ");
        }
    }

    public static void bai197() {
        // giống bài 189
    }

    public static void bai198() {
        // giống bài 187
    }

    public static void bai199() {
        // giống bài 184
    }


    // KỸ THUẬT TÍNH TỔNG
    public static void bai200(int a[]) {
        int sum = 0;
        for (int i = 0 ; i < a.length ; i++) {
            sum += a[i];
        }
        System.out.println("Bài 200: Tổng = "+sum);
    }

    public static void bai201(float a[]) {
        float sum = 0;
        for (int i = 0 ; i < a.length ; i++) {
            if ( a[i] > 0 ) sum += a[i];
        }
        System.out.println("Bài 201: Tổng giá trị dương = "+sum);
    }

    public static void bai202(int a[]) {
        int sum = 0;
        for (int i = 0 ; i < a.length ; i++) {
            if ( checkDauLe(a[i]) ) sum += a[i];
        }
        System.out.println("Bài 202: Tổng giá trị cần tìm = "+sum);
    }

    public static void bai203(int a[]) {
        int sum = 0;
        for (int i = 0 ; i < a.length ; i++) {
            if ( checkHangChuc5(a[i]) ) sum += a[i];
        }
        System.out.println("Bài 203: Tổng giá trị cần tìm = "+sum);
    }
    public static boolean checkHangChuc5(int x) {
        int test = (Math.abs(x)/10)%10;
        if ( test == 5 ) return true;
        return false;
    }

    public static void bai204(float a[]) {
        float sum = 0;
        for (int i = 1 ; i < a.length ; i++) {
            if ( a[i] > a[i-1] ) {
                sum += a[i];
            }
        }
        System.out.println("Bài 204: Tổng giá trị cần tìm = "+sum);
    }

    public static void bai205(float a[]) {
        float sum = 0;
        for (int i = 0 ; i < a.length-1 ; i++) {
            if ( a[i] > Math.abs(a[i+1]) ) {
                sum += a[i];
            }
        }
        System.out.println("Bài 205: Tổng giá trị cần tìm = "+sum);
    }

    public static void bai206(float a[]) {
        float sum = 0;
        if ( a[0] > a[1] ) {
            sum = a[0] + tongPhanTuCucDai(a, 2);
        }
        else {
            sum = tongPhanTuCucDai(a, 1);
        }
        System.out.println("Bài 206: Tổng cần tìm = "+sum);
    }
    public static float tongPhanTuCucDai(float a[], int x) {
        float sum = 0;
        for (int i = x ; i < a.length-1 ; i++) {
            if ( a[i]<=a[i-1] || a[i]<=a[i+1] ) continue;
            sum += a[i];
            i++;
        }
        if ( a[a.length-1] > a[a.length-2] ) sum += a[a.length-1];
        return sum;
    }

    public static void bai207(float a[]) {
        float sum = 0;
        if ( a[0] != a[1] ) {
            sum = a[0] + tongPhanTuCucTri(a, 1);
        } else sum = tongPhanTuCucTri(a, 1);
        if ( a[a.length-1] != a[a.length-2] ) sum += a[a.length-1];
        System.out.println("Bài 207: Tổng cần tìm = "+sum);
    }
    public static float tongPhanTuCucTri(float a[], int x) {
        float sum = 0;
        for (int i = x ; i < a.length-1 ; i++) {
            if ( a[i]>a[i-1] && a[i]>a[i+1] ) sum += a[i];
            if ( a[i]<a[i-1] && a[i]<a[i+1] ) sum += a[i];
        }
        return sum;
    }

    public static void bai208(int a[]) {
        int sum = 0;
        for (int i = 0 ; i < a.length ; i++) {
            if ( checkSCP(a[i]) ) sum += a[i];
        }
        System.out.println("Bài 208: Tổng các số chính phương = "+sum);
    }

    public static void bai209(int a[]) {
        int sum = 0;
        for (int i = 0 ; i < a.length ; i++) {
            if ( checkSĐX(a[i]) ) sum += a[i];
        }
        System.out.println("Bài 209: Tổng cần tìm = "+sum);
    }
    public static boolean checkSĐX(int n) {
        int m = 0;
        int l = n;
        for ( int i = 0 ; l > 0 ; i++ ) {
            m = (m*10 + l%10);
            l /= 10;
        }
        if ( m == n ) return true;
        return false;
    }

    public static void bai210(int a[]) {
        int sum = 0;
        for (int i = 0 ; i < a.length ; i++) {
            if ( checkDauChan(a[i]) ) sum += a[i];
        }
        System.out.println("Bài 210: Tổng cần tìm = "+sum);
    }

    public static void bai211(int a[]) {
        int dem = 0;
        int sum = 0;
        for (int i = 0 ; i < a.length ; i++) {
            if ( checkSNT(a[i]) ) {
                sum += a[i];
                dem++;
            }
        }
        float TBC = (float) sum/dem;
        System.out.println("Bài 211: Trung bình cộng = "+TBC);
    }

    public static void bai212(float a[]) {
        int dem = 0;
        float sum = 0;
        for (int i = 0 ; i < a.length ; i++) {
            if ( a[i] > 0 ) {
                sum += a[i];
                dem++;
            }
        }
        float TBC = (float) sum/dem;
        System.out.println("Bài 212: Trung bình cộng = "+TBC);
    }

    public static void bai213(float a[]) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập x = ");
        float x = scanner.nextFloat();
        int dem = 0;
        float sum = 0;
        for (int i = 0 ; i < a.length ; i++) {
            if ( a[i] > x ) {
                sum += a[i];
                dem++;
            }
        }
        float TBC = (float) sum/dem;
        System.out.println("Bài 212: Trung bình cộng = "+TBC);
    }

    public static void bai214(float a[]) {
        int dem = 0;
        float nhan = 1;
        for (int i = 0 ; i < a.length ; i++) {
            if ( a[i] > 0 ) {
                nhan *= a[i];
                dem++;
            }
        }
        double mu = (double) 1/dem;
        float TBN = (float) Math.pow(nhan, mu);
        System.out.println("Bài 214: Trung bình nhân = "+TBN);
    }

    public static void bai215(int a[]) {
        int sum = 0;
        int dem = 0;
        for (int i = 0 ; i < a.length-1 ; i++) {
            sum += Math.abs(a[i]-a[i+1]);
            dem++;
        }
        float tbc = (float) sum/dem;
        System.out.println("Bài 125: Khoảng cách trung bình = "+tbc);
    }


    // KỸ THUẬT ĐẾM
    public static void bai216(int a[]) {
        int dem = 0;
        for (int i = 0 ; i < a.length ; i++) {
            if ( a[i]%2==0 ) dem++;
        }
        System.out.println("Bài 216: Số phần tử chẵn = "+dem);
    }

    public static void bai217(int a[]) {
        int dem = 0;
        for (int i = 0 ; i < a.length ; i++) {
            if ( a[i]%7==0 ) dem++;
        }
        System.out.println("Bài 217: Số phần tử chia hết cho 7 = "+dem);
    }

    public static void bai218(int a[]) {
        int dem = 0;
        for (int i = 0 ; i < a.length ; i++) {
            if ( checkSĐX(a[i]) ) dem++;
        }
        System.out.println("Bài 218: Số phần tử đối xứng = "+dem);
    }

    public static void bai219(float a[]) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Bài 219: Nhập giá trị x = ");
        float x = scanner.nextFloat();
        int dem = 0;
        for (int i = 0 ; i < a.length ; i++) {
            if ( a[i]==x ) dem++;
        }
        System.out.println("==> Số phần tử có giá trị "+x+" = "+dem);
    }

    public static void bai220(int a[]) {
        int dem = 0;
        for (int i = 0 ; i < a.length ; i++) {
            if ( checkChuSoCuoiCung5(a[i]) ) dem++;
        }
        System.out.println("Bài 220: Số phần tử cần tìm = "+dem);
    }
    public static boolean checkChuSoCuoiCung5(int x) {
        int test = Math.abs(x);
        if ( test%10 == 5 ) return true;
        return false;
    }

    public static void bai221(int a[]) {
        int check = 0;
        int demChan = 0, demLe = 0;
        for (int i = 0 ; i < a.length ; i++) {
            if ( a[i]%2!=0 ) demLe++;
            else demChan++;
        }
        if ( demChan > demLe ) check = -1;
        else if ( demChan < demLe ) check = 1;
        else check = 0;
        System.out.println("Bài 221: trả về "+check);
    }

    public static void bai222(int a[]) {
        int dem = 0;
        if ( a[0] != a[1] ) dem++;
        if ( a[a.length-1] != a[a.length-2] ) dem++;
        for (int i = 1 ; i < a.length-1 ; i++) {
            if ( a[i]>a[i-1] && a[i]>a[i+1] ) dem++;
            if ( a[i]<a[i-1] && a[i]<a[i+1] ) dem++;
        }
        System.out.println("Bài 222: Số cực trị = "+dem);
    }

    public static void bai223(int a[]) {
        int dem = 0;
        for (int i = 0 ; i < a.length ; i++) {
            if ( checkSNT(a[i]) ) dem++;
        }
        System.out.println("Bài 223: Tổng số nguyên tố = "+dem);
    }

    public static void bai224(int a[]) {
        int dem = 0;
        for (int i = 0 ; i < a.length ; i++) {
            if ( soHoanThien(a[i]) ) dem++;
        }
        System.out.println("Bài 224: Tổng số hoàn thiện = "+dem);
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

    public static void bai225(float a[]) {
        int dem = 0;
        for (int i = 0 ; i < a.length ; i++) {
            if ( a[i] == a[viTriGiaTriLonNhat(a)] ) dem++;
        }
        System.out.println("Bài 225: số lượng giá trị lớn nhất = "+dem);
    }

    public static void bai226(int a[]) {
        int dem = 0;
        for (int i = 1 ; i < a.length ; i++) {
            if ( checkSoChan(a[i]) ) {
                if ( checkSoChan(a[i-1])) {
                    dem++;
                }
            }
        }
        System.out.println("Bài 226: số lượng giá trị cần tìm = "+dem);
    }

    public static void bai227(int a[]) {
        int dem = 0;
        for (int i = 0 ; i < a.length-1 ; i++) {
            if ( a[i]*a[i+1]<0 ) {
                dem++;
            }
        }
        System.out.println("Bài 227: số lượng giá trị cần tìm = "+dem);
    }

    public static void bai228(int a[]) {
        int dem = 0;
        for (int i = 0 ; i < a.length-1 ; i++) {
            if ( a[i]*a[i+1]>0 ) {
                if ( Math.abs(a[i]) < Math.abs(a[i+1]) ) dem++;
            }
        }
        System.out.println("Bài 228: số lượng giá trị cần tìm = "+dem);
    }

    public static void bai229(int a[]) {
        int dem = 0;
        for (int i = 0 ; i < a.length ; i++) {
            for (int j = 0 ; j < a.length ; j++) {
                if ( i == j ) continue;
                if ( a[i]==a[j] ) break;
            }
            dem++;
        }
        System.out.println("Bài 229: số lượng các giá trị phân biệt = "+dem);
    }

    public static void bai230(int a[]) {

    }


    // KỸ THUẬT ĐẶT CỜ HIỆU

    // KỸ THUẬT SẮP XẾP

    // KỸ THUẬT THÊM

    // KỸ THUẬT XÓA

    // KỸ THUẬT XỬ LÝ MẢNG

    // KỸ THUẬT XỬ LÝ MẢNG CON

    // XÂY DỰNG MẢNG


}
