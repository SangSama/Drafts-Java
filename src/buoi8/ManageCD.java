package buoi8;

public class ManageCD {
    private CD[] cds;   // mảng CD
    private int n;      // số CD có tong mảng

    public ManageCD() {
    }

    public ManageCD(int n) {
        this.cds = new CD[100];     // khởi tạo vùng nhớ chứ 100 phần tử
        this.n = n;
    }

    // hàm kiểm tra thêm CD vào cds
    public boolean addCD(CD newCD) {
        // xem có thêm được vào mảng cds được nữa không
        if (n >= cds.length) {
            return false;
        }
        int i = 0;
        // xét xem trùng mã CD không
        for (CD cd : cds) {
            if (cd != null) {
                i++;
                if (newCD.getMaCD() == cd.getMaCD()) {
                    return false;
                }
            }

        }

        cds[i++] = newCD;
        n++;
        return true;
    }

    // số lượng CD cũng là n mà nhể?
    public int size() {
        int count = 0;
        for (CD cd : cds) {
            count++;
        }
        return count;
    }

    // tính tổng giá thành CD
    public double sumPrice() {
        double sum = 0;
        for (CD cd : cds) {
            sum += cd.getGiaThanh();
        }
        return sum;
    }

    // Sắp xếp giảm dần theo giá thành
    public void sortByPrice() {
        for (int i = 0 ; i < n ; i++) {
            for (int j = i+1 ; j < n ; j++) {
                if (cds[i].getGiaThanh() < cds[j].getGiaThanh()) {
                    swap(cds, i, j);
                }
            }
        }
    }
    // hàm hoán đổi vị trí
    private void swap(CD[] cds, int i, int j) {
        CD cd = cds[i];
        cds[i] = cds[j];
        cds[j] = cd;
    }

    // Sắp xếp tăng dần theo tựa CD
    public void sortByTuaCD() {
        // sử dụng compareTo() cho chuỗi => tuân thủ theo thứ tự từ điển
        //      Thứ tự từ điển ??? <=> ...< Z < a < b < c < d < ... z : bảng mã ASCII
        //      => Khi so sánh chuỗi thì nó sẽ ưu tiên so sánh thứ tự từ điểm
        //      => so sánh đến độ dài
        //              s1 > s2 > 0
        //              s1 = s2 = 0
        //              s1 < s2 < 0
        // VD: s1: abc; s2: z; => s1 < s2; i; vị trí tương ứng
        // s1[i] - s2[i] > 0 => s1[i] xuất hiện sau s2[i]
        // s1[i] - s2[i] < 0 => s1[i] xuất hiện trước s2[i]
        // s1[i] - s2[i] = 0 => s1[i] xuất hiện cùng với s2[i]
        // VD: s1: abc; s2: abcd; => xét đến độ dài
        // VD: str1 = "a" , str2 = "b"
        // => str1.compareTo("b") ---> -1 => < 0 : str1 đứng trước str2
        // => str1.compareTo("a") ---> 0  => = 0 : str1 chính là str2
        // => str2.compareTo("a") ---> 1  => > 0 : str1 đứng sau str2
        // Có phân biệt in hoa và in thường => không muốn phân biệt in hoa và in thường --> compareToIgnoreCase
        for (int i = 0 ; i < n ; i++) {
            for (int j = i+1 ; j < n ; j++) {
                if (cds[i].getTuaCD().compareTo(cds[j].getTuaCD()) > 0) {
                    swap(cds, i, j);
                }
            }
        }
    }


}
