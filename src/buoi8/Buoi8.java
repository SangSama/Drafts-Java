package buoi8;

import java.util.Scanner;

public class Buoi8 {

    /*
    * ***CONTENT***
    *
    *** OOP: Object Oriented Programing
    *** Lập trình hướng đối tượng => lấy đối tượng làm trung tâm.
    *
    *
    *** Class là gì?
    *   => class là khuôn mẫu để tạo ra đối tượng.
    *   => class được hình thành qua quá trình trừu tượng 1 tập các object có chung với nhau về mặt tính chất.
    *   => quá trình trừu tượng 1 tập object là tìm ra các thuộc tính và phương thức chung của các đối tượng để
    *   đóng gói chúng lại vào trong 1 class.
    *   => đóng gói nghĩa là quá trình khai báo các thuộc tính và phương thức của đối tượng vào trong cùng 1 class.
    *
    *
    *** Object là gì?
    *   => object là đối tượng được sinh ra bởi class
    *   => object mang 3 thông tin:
    *       - định danh: là duy nhất
    *       - trạng thái: thuộc tinh và giá trị của thuộc tính
    *       - hành vi: là các phương thức của object
    *   => các object được tạo ra bởi cùng 1 class:
    *       + Chung với nhau về thuộc tính nhưng khác nhau vè mặt giá trị
    *       + Hành vi thì được quyết định bởi trạng thái => hành vi các object là giống nhau nhưng kết quả sẽ khác nhau
    * (vì khác nhau ở trạng thái) ==> muốn thực hiện hành vi => thông qua đối tượng của hành vi đó
    * => Nếu không thông qua đối tượng ===> null pointer: giá trị truyền vào bị null
    *
    *
    *** Access Modifier: Phạm vi hoạt động của biến trong class
        cùng class -- khác clas cùng package -- khác class khác package nhưng có mqh cha con -- khác class khác package nhưng k có mqh cha con
public      v                   v                                   v                                               v
protected   v                   v                                   v                                               x
default     v                   v                                   x                                               x
private     v                   x                                   x                                               x

* ==> public: truy cập được ở mọi nơi
* ==> protected: không truy cập được khác class khác package không có mqh gì
* ==> default: chỉ trong cùng package mới truy cập được
* ==> private: chỉ trong cùng class mới truy cập được
*
*
    *** Đóng gói:
    * => các class nằm trong cùng 1 package => đóng gói
    * => các thuộc tính, phương thức nằm trong class => đóng gói
    * ===> Để bảo đảm tính bảo mật của đóng gói, thì các thuộc tính trong class thường để ở trạng thái private
    * để che dấu đi thông tin của cái đó đối với người dùng
    * ===> người dùng không cần biết có những thuộc tính gì, phương thức gì, hoạt động ntn
    *
    *
    *** Quy chuẩn đặt tên:
    * Tên của class: thì bao giờ cũng là danh từ hoặc cụm danh từ
    *   ==> tên class: thì viết hoa tất cả các chữ cái đầu
    * Tên thuộc tính: thì bao giờ cũng là danh từ hoặc cụm danh từ
    * Tên phương thức: thì bao giờ cũng là động từ hoặc cụm động từ
    *   ==> tên thuộc tính, tên phương thức: viết thường từ đầu tiên, từ từ thứ 2 trở đi thì viết hoa chữ cái đầu tiên
    *
    *
    *** Khái niệm constructor:
    * => để khởi tạo ra các giá trị ban đầu của thuộc tính của class
    * => khi mà class chưa có 1 constructor nào thì chương trình sẽ tự động tạo ra 1 constructor mặc định cho class với
    * các giá trị ban đầu của thuộc tính là giá trị mặc định
    * => kiểu dữ liệu nguyên thủy:
    *   - Mặc định là 0: int, long, short, byte, double, float
    *   - Mặc định là false: boolean
    * => các kiểu dữ liệu trừu tượng => mặc định : null (chưa được cấp phát đến 1 vùng nhớ)
    *
    *
    *** Từ khóa NEW: cấp phát 1 vùng nhớ có gía trị vùng nhớ bằng giá trị lưu trữ 1 object class
    *
    *-------------------------------------------------------------------------------------------------------------------
    * */

    /*
    * ĐỆ QUY
    *
    * Điều kiện dừng (điều kiện cơ bản) : để dừng lại vòng lặp
    * S = 1 + 2 + 3 + 4 + 5
    * S(1) = 1
    * S(2) = 1 + 2
    * S(3) = 1 + 2 + 3 = S(2) + 3
    * ....
    * => công thức hồi quy: S(n) = S(n-1) + n
    * ==> Trong nó gọi đến chính nó
    *
    * */

    /*

    * Printf giúp việc in ra màn hình theo một định dạng đã quy ước nào đó tiện lợi hơn.
    * => giúp việc code và xử lý trở nên đơn giản và linh hoạt hơn.
    * => Trong khi Print và Println chỉ làm một nhiệm vụ duy nhất là in ra màn hình, Printf thì lại khác,
    * vừa in được ra màn hình, vừa định dạng được những thứ mà nó đã in ra – từ chuỗi đến số, ngày giờ và cả đối tượng.
    *
        Với Print: Xuất kết quả ra màn hình nhưng con trỏ chuột không xuống dòng.
        Với Println: Xuất kết quả ra màn hình đồng thời con trỏ chuột nhảy xuống dòng tiếp theo.
        Với Printf: Xuất ra màng hình kết quả đồng thời có thể định dạng được kết quả đó nhờ vào các đối số thích hợp.

    * */


    // ĐỆ QUY
    public static int tinhTong(int n) {
        if (n==1) return 1;
        System.out.println("n: "+n);
        return tinhTong(n-1) + n;
    }

    public static int tinhGiaiThua(int n) {
        if (n==1) return 1;
        System.out.println("n: "+n);
        return tinhGiaiThua(n-1)*n;
    }

    public static void nhapMang(int a[], int n, int i, Scanner scanner) {
        if ( i>n ) return;
        System.out.printf("a[%d] = ", i);
        a[i] = scanner.nextInt();
        nhapMang(a, n, i+1, scanner);
    }

    public static void xuatMang(int a[], int n, int i) {
        if ( i>n ) return;
        System.out.print(a[i] + "  ");
        xuatMang(a, n, i+1);
    }

    static int tong2 = 0;
    public static int tinhTong(int a[], int n, int i) {
        if ( i > n ) return  tong2;
        tong2 += a[i];
        return tinhTong(a, n, i+1);
    }


    // OOP
    // bài 7:
    public static void nhapThongTin(Student st) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập mã số sinh viên: ");
        st.setMssv(scanner.nextInt());
        scanner.nextLine();
        System.out.print("Nhập họ và tên sinh viên: ");
        st.setHoTen(scanner.nextLine());
        System.out.print("Nhập địa chỉ sinh viên: ");
        st.setDiaChi(scanner.nextLine());
        do {
            System.out.print("Nhập số điện thoại gồm 7 chữ số: ");
            st.setsDT(scanner.nextLine());
        } while (st.getsDT().length() != 7);
    }


    public static void main(String[] args) {

//        int tong = tinhTong(5);
//        System.out.println("Tổng = "+tong);

//        int giaiThua = tinhGiaiThua(4);
//        System.out.println("Giai thừa = "+giaiThua);

//        int n = 4;
//        int[] a = new int[n];
//        nhapMang(a, n-1, 0, new Scanner(System.in));
//        xuatMang(a, n-1, 0);

//        tinhTong(a, n-1, 0);
//        System.out.println("tong : "+ tong2);

//----------------------------------------------------------------------------------------------------------------------

//        SinhVien sinhVien1 = new SinhVien();
////        sinhVien1.setTen("sang");
//        System.out.println(sinhVien1);

        Scanner scanner = new Scanner(System.in);

        // bài 1:
//        System.out.println("Bài 1: ");
//        HinhChuNhat hcn = new HinhChuNhat();
//        System.out.print("Nhập chiều dài: ");
//        long chieuDai = scanner.nextLong();
//        hcn.setChieuDai(chieuDai);
//        System.out.print("Nhập chiều rộng: ");
//        long chieuRong = scanner.nextLong();
//        scanner.nextLine();
//        hcn.setChieuRong(chieuRong);
//        System.out.println(hcn.toString());
////        System.out.println("Chu vi = "+hcn.chuVi()+" cm");
////        System.out.println("Diện tích = "+hcn.dienTich()+" cm^2");

        // bài 2:
//        System.out.println("Bài 2: ");
//        SinhVien sv1 = new SinhVien("Trương Thị Sáng", 20172785, 8.5f, 8 );
//        SinhVien sv2 = new SinhVien("Trương Quang Phan", 20192021, 9, 7.25f );
//        SinhVien sv3 = new SinhVien();
//        System.out.print("Họ và tên: ");
//        String name = scanner.nextLine();
//        sv3.setHoTen(name);
//        System.out.print("MSSV: ");
//        int code = scanner.nextInt();
//        sv3.setMssv(code);
//        System.out.println("Điểm LT = ");
//        float diemLT = scanner.nextFloat();
//        sv3.setDiemLT(diemLT);
//        System.out.println("Điểm TH = ");
//        float diemTH = scanner.nextFloat();
//        scanner.nextLine();
//        sv3.setDiemTH(diemTH);
//        System.out.printf("%s\t%d\t%f\t%f\t%f\n",sv1.getHoTen(),sv1.getMssv(),sv1.getDiemLT(),sv1.getDiemTH(),sv1.diemTrungBinh());
//        System.out.printf("%s\t%d\t%f\t%f\t%f\n",sv2.getHoTen(),sv2.getMssv(),sv2.getDiemLT(),sv2.getDiemTH(),sv2.diemTrungBinh());
//        System.out.printf("%s\t%d\t%f\t%f\t%f\n",sv3.getHoTen(),sv3.getMssv(),sv3.getDiemLT(),sv3.getDiemTH(),sv3.diemTrungBinh());

        // bài 3:
//        System.out.println("Bài 3: ");
//        Vehicle xe1 = new Vehicle("Sáng", "Future Neo", 75, 35000);
//        Vehicle xe2 = new Vehicle("Trang", "Landscape", 1500, 1000000000);
//        Vehicle xe3 = new Vehicle("Mai", "Ford Ranger", 150, 6500000);
//        System.out.println(xe1.toString());
//        System.out.println(xe2.toString());
//        System.out.println(xe3.toString());

        // bài 4:
//        System.out.println("Bài 4: ");
//        Account acc1 = new Account(1111, "Sáng");
//        Account acc2 = new Account(2222, "Trang", 100);
//        acc1.napTien();
//        acc1.rutTien();
//        acc1.daoHan();
//        acc1.toString();

        // bài 5:
//        System.out.println("Bài 5: ");
//        Rational rat1 = new Rational(10, 30);
//        Rational rat2 = new Rational(12, 40);
//        rat1.reduce();
//        rat2.reduce();
//        rat1.add(rat2);
//        rat1.subtract(rat2);
//        rat1.multiply(rat2);
//        rat1.divide(rat2);

        // bài 6:
//        System.out.println("Bài 6: ");
//        HangThucPham hTP1 = new HangThucPham();
//        boolean th = true;
//        boolean ktn = true;
//        System.out.print("Nhập mã hàng: ");
//        hTP1.setMaHang(scanner.nextInt());
//        scanner.nextLine();
//        do {
//            System.out.println("Nhập tên hàng: ");
//            hTP1.setTenHang(scanner.nextLine());
//        } while (hTP1.kiemTraTenHang(th));
//        do {
//            System.out.println("Nhập đơn giá");
//            hTP1.setDonGia(scanner.nextDouble());
//        } while (hTP1.getDonGia() < 0);
//        do {
//            System.out.println("Nhập năm, tháng, ngày sản xuất: ");
//            hTP1.setNSX(scanner.nextInt(), scanner.nextInt(), scanner.nextInt());
//            System.out.println("Nhập năm, tháng, ngày hết hạn: ");
//            hTP1.setHSD(scanner.nextInt(), scanner.nextInt(), scanner.nextInt());
//        } while (hTP1.kiemTraNgay(ktn));
//        System.out.println(hTP1);
//        hTP1.kiemTraHSD();

        // bài 7:
        System.out.println("Bài 7: ");
        Student[] st = null;
        int x, n=0;
        boolean check = true;
        do {
            System.out.println("Chọn làm gì?");
            System.out.println("1. Nhập thông tin sinh viên. \n"+"2. Xuất danh sách sinh viên. \n"+"Nhập số khác để thoát");
            x = scanner.nextInt();
            switch (x) {
                case 1:
                    System.out.println("Số lượng sinh viên cần nhập: ");
                    n = scanner.nextInt();
                    st = new Student[n];
                    for (int i = 0 ; i < st.length ; i++) {
                        System.out.println("Sinh viên thứ ("+(i+1)+") : ");
                        st[i] = new Student();
                        nhapThongTin(st[i]);
                    }
                    break;
                case 2:
                    System.out.println("Danh sách sinh viên: ");
                    Student temp = new Student();
                    for (int i = 0 ; i < st.length ; i++) {
                        for (int j = i + 1 ; i < st.length ; i++) {
                            if ( st[i].getMssv() > st[j].getMssv() ) {
                                temp = st[i];
                                st[i] = st[j];
                                st[j] = temp;
                            }
                        }
                    }
                    System.out.printf("%-5s %15s %15s %20s \n", "MSSV", "Họ và tên", "Địa chỉ", "Số điện thoại");
                    for (int i = 0 ; i < st.length ; i++) {
                        st[i].hienThiTT();
                    }
                    break;
                default:
                    System.out.println("Thoát!!!");
                    check = false;
                    break;
            }
        } while (check);

        // bài 8:

    }
}
