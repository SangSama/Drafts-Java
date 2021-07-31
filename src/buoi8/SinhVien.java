package buoi8;

public class SinhVien {
    private String hoTen;
    private int mssv;
    private float diemLT;
    private float diemTH;

    // constructor mặc định
    public SinhVien() {
    }

    // constructor có tham số
    public SinhVien(String hoTen, int mssv, float diemLT, float diemTH) {
        this.hoTen = hoTen;
        this.mssv = mssv;
        this.diemLT = diemLT;
        this.diemTH = diemTH;
    }

    // hàm tính điểm trung bình
    public float diemTrungBinh() {
        return (diemLT+diemTH)/2;
    }

    // getter & setter
    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public int getMssv() {
        return mssv;
    }

    public void setMssv(int mssv) {
        this.mssv = mssv;
    }

    public float getDiemLT() {
        return diemLT;
    }

    public void setDiemLT(float diemLT) {
        this.diemLT = diemLT;
    }

    public float getDiemTH() {
        return diemTH;
    }

    public void setDiemTH(float diemTH) {
        this.diemTH = diemTH;
    }

    @Override
    public String toString() {
        return "SinhVien{" +
                "hoTen='" + hoTen + '\'' +
                ", mssv=" + mssv +
                ", diemLT=" + diemLT +
                ", diemTH=" + diemTH +
                ", diemTrungBinh=" + diemTrungBinh() +
                '}';
    }
}
