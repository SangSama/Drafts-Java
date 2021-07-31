package buoi8;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class HangThucPham {
    private int maHang;
    private String tenHang;
    private double donGia;
    private Date nSX, hSD;

    public HangThucPham() {
    }

    public HangThucPham(int maHang) {
        this.maHang = maHang;
    }

    public HangThucPham(int maHang, String tenHang, double donGia, Date nSX, Date hSD) {
        this.maHang = maHang;
        this.tenHang = tenHang;
        this.donGia = donGia;
        this.nSX = nSX;
        this.hSD = hSD;
    }

    public int getMaHang() {
        return maHang;
    }

    public void setMaHang(int maHang) {
        this.maHang = maHang;
    }

    public String getTenHang() {
        return tenHang;
    }

    public void setTenHang(String tenHang) {
        this.tenHang = tenHang;
    }

    public double getDonGia() {
        return donGia;
    }

    public void setDonGia(double donGia) {
        this.donGia = donGia;
    }

    public Date getnSX() {
        return nSX;
    }

    public void setnSX(Date nSX) {
        this.nSX = nSX;
    }

    public Date gethSD() {
        return hSD;
    }

    public void sethSD(Date hSD) {
        this.hSD = hSD;
    }

    @Override
    public String toString() {

        // sử dụng phương thức Locale để biến đổi theo tiền tệ Việt Nam
        Locale locale = new Locale("vi", "VN");
        NumberFormat numberFormat = NumberFormat.getCurrencyInstance(locale);
        String strDonGia = numberFormat.format(donGia);

        // sử dụng phương thức SimpleDateFormat để biến đổi ngày tháng năm theo định dạng "dd/mm/yyyy"
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String strNSX = simpleDateFormat.format(nSX);
        String strHSD = simpleDateFormat.format(hSD);

        return "HangThucPham{" +
                "maHang=" + maHang +
                ", tenHang='" + tenHang + '\'' +
                ", donGia=" + strDonGia +
                ", nSX=" + strNSX +
                ", hSD=" + strHSD +
                '}';
    }

    // khởi tạo phương thức kiểm tra tên hàng không được để trống
    public boolean kiemTraTenHang(boolean k) {
        if (this.tenHang == "" || this.tenHang.isEmpty()) {
            System.out.println("Tên hàng không được để trống : ");
        } else k = false;
        return k;
    }

    // Khởi tạo phương thức để nhập năm tháng ngày sản xuất
    public void setNSX(int year, int month, int day) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month - 1, day);
        this.nSX = calendar.getTime();
    }

    // Khởi tạo phương thức để nhập năm tháng ngày hết hạn
    public void setHSD(int year, int month, int day) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month - 1, day);
        this.hSD = calendar.getTime();
    }

    // khởi tạo phương thức kiểm tra ngày hết hạn không được nhỏ hơn ngày sản xuất
    public boolean kiemTraNgay(boolean t) {
        if (this.getnSX().compareTo(this.gethSD()) < 0) t = false;
        else System.out.println("Ngày hết hạn không được nhỏ hơn ngày sản xuất : ");
        return t;
    }

    // khởi tạo phương thức kiếm tra hạn sử dụng của sản phẩm đã hết hay còn hạn
    public void kiemTraHSD() {
        Date today = new Date();
        today.getTime();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String str = simpleDateFormat.format(today);
        if (this.gethSD().compareTo(today) < 0) System.out.println("Hôm nay là ngày "+str+", hàng hóa đã hết hạn");
        else System.out.println("Hôm nay là ngày "+str+", hàng hóa vẫn còn hết hạn");
    }
}
