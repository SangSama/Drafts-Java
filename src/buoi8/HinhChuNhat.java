package buoi8;

public class HinhChuNhat {
    private long chieuDai;
    private long chieuRong;

    public long chuVi() {
        return (chieuDai+chieuRong)*2;
//        long chuVi = (chieuDai+chieuRong)*2;
//        return chuVi;
    }

    public long dienTich() {
        return chieuDai*chieuRong;
//        long dienTich = chieuDai*chieuRong;
//        return dienTich;
    }

    public long getChieuDai() {
        return chieuDai;
    }

    public void setChieuDai(long chieuDai) {
        this.chieuDai = chieuDai;
    }

    public long getChieuRong() {
        return chieuRong;
    }

    public void setChieuRong(long chieuRong) {
        this.chieuRong = chieuRong;
    }

    @Override
    public String toString() {
        return "HinhChuNhat{" +
                "chieuDai=" + chieuDai +
                ", chieuRong=" + chieuRong +
                ", chuVi=" + chuVi() +
                ", dienTich=" + dienTich() +
                '}';
    }
}
