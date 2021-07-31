package buoi8;

public class Vehicle {
    private String chuXe;
    private String loaiXe;
    private int dungTich;
    private float triGia;
    private float thue;

    public Vehicle() {
    }

    public Vehicle(String chuXe, String loaiXe, int dungTich, float triGia) {
        this.chuXe = chuXe;
        this.loaiXe = loaiXe;
        this.dungTich = dungTich;
        this.triGia = triGia;
    }

    public float thue() {
        if ( dungTich < 100 ) thue = triGia*1/100 ;
        else if ( dungTich > 200 ) thue = triGia*5/100 ;
        else thue = triGia*3/100 ;
        return thue;
    }

    public String getChuXe() {
        return chuXe;
    }

    public void setChuXe(String chuXe) {
        this.chuXe = chuXe;
    }

    public String getLoaiXe() {
        return loaiXe;
    }

    public void setLoaiXe(String loaiXe) {
        this.loaiXe = loaiXe;
    }

    public int getDungTich() {
        return dungTich;
    }

    public void setDungTich(int dungTich) {
        this.dungTich = dungTich;
    }

    public float getTriGia() {
        return triGia;
    }

    public void setTriGia(float triGia) {
        this.triGia = triGia;
    }

    public float getThue() {
        return thue;
    }

    public void setThue(float thue) {
        this.thue = thue;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "chuXe='" + chuXe + '\'' +
                ", loaiXe='" + loaiXe + '\'' +
                ", dungTich=" + dungTich +
                ", triGia=" + triGia +
                ", thue=" + thue() +
                '}';
    }
}
