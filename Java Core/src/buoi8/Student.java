package buoi8;

import java.sql.SQLOutput;

public class Student {
    private int mssv;
    private String hoTen;
    private String diaChi;
    private String sDT;

    public Student() {
    }

    public Student(int mssv, String hoTen, String diaChi, String sDT) {
        this.mssv = mssv;
        this.hoTen = hoTen;
        this.diaChi = diaChi;
        this.sDT = sDT;
    }

    public int getMssv() {
        return mssv;
    }

    public void setMssv(int mssv) {
        this.mssv = mssv;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getsDT() {
        return sDT;
    }

    public void setsDT(String sDT) {
        this.sDT = sDT;
    }

    @Override
    public String toString() {
        return "Student{" +
                "mssv=" + mssv +
                ", hoTen='" + hoTen + '\'' +
                ", diaChi='" + diaChi + '\'' +
                ", sDT='" + sDT + '\'' +
                '}';
    }

    // khởi tạo phương thức hiện thị theo format
    public void hienThiTT() {
        System.out.printf("%-5d %-20s %-15s %-15s \n", mssv, hoTen, diaChi, sDT);
    }
}
