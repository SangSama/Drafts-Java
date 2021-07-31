package buoi8;

import java.util.Scanner;

public class Account {
    final double soLaiSuat = 0.035;

    private long soTK;
    private String tenTK;
    private double tien;


    public Account() {
    }

    public Account(long soTK, String tenTK) {
        this.soTK = soTK;
        this.tenTK = tenTK;
        this.tien = 50;
    }

    public Account(long soTK, String tenTK, double tien) {
        this.soTK = soTK;
        this.tenTK = tenTK;
        this.tien = tien;
    }

    Scanner scanner = new Scanner(System.in);
    public double napTien() {
        double nap;
        System.out.print("Nhập số tiền bạn cần nạp (>0): ");
        nap = scanner.nextDouble();
        while ( nap < 0 ) {
            System.out.print("Tiền nạp cần lớn hơn hoặc bằng 0: ");
            nap = scanner.nextDouble();
        }
        tien = tien + nap;
        System.out.println("bạn vừa nạp "+nap+" vào tài khoản.");
        System.out.println("Số tiền tỏng TK hiện tại: "+tien);
        return nap;
    }

    public double rutTien() {
        double phi = 5;
        double rut;
        System.out.println("Nhập số tiền bạn cần rút");
        rut = scanner.nextDouble();
        while ( rut < 0 || rut > tien ) {
            System.out.print("Tiền rút chưa hợp lệ, mời nhập lại: ");
            rut = scanner.nextDouble();
        }
        tien = tien - (rut+phi);
        System.out.println("Bạn vừa rút " + rut + " từ tài khoản. Phí là 5.");
        System.out.println("Số tiền tỏng TK hiện tại: "+tien);
        return rut;
    }

    public double daoHan() {
        tien = tien + tien*soLaiSuat;
        System.out.println("Bạn vừa được " + tien + " từ đáo hạn 1 tháng");
        System.out.println("Số tiền tỏng TK hiện tại: "+tien);
        return tien;
    }

    // Phương thức chuyển khoản từ tài khoản này sang tài khoản khác


    public long getSoTK() {
        return soTK;
    }

    public void setSoTK(long soTK) {
        this.soTK = soTK;
    }

    public String getTenTK() {
        return tenTK;
    }

    public void setTenTK(String tenTK) {
        this.tenTK = tenTK;
    }

    public double getTien() {
        return tien;
    }

    public void setTien(double tien) {
        this.tien = tien;
    }

    @Override
    public String toString() {
        return "Account{" +
                "soTK=" + soTK +
                ", tenTK='" + tenTK + '\'' +
                ", tien=" + tien +
                '}';
    }
}
