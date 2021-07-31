package buoi10;

public class Buoi10 {
    /*
    * static và từ khóa final, this
    *
    *** this ***
    * => là con trỏ nó trỏ đến object đang gọi method
    * => là đại diện cho cái đối tượng gọi đến hàm
    * VD: public abc(int ma){ this.ma = ma }
    *     => constructor đại diện cho đối tượng tạo ra, đối tượng tạo ra có ma = ma truyền vào.
    *
    *** static ***
    *   => thuộc tính static => biến của class, phương thức static => phương thức của class.
    *   => thuộc tính non static => biến của đối tượng, phương thức non static => phương thức của đối tượng.
    * ==> các biến static chỉ được tạo ra duy nhất 1 vùng nhớ để lưu trữ.
    * ==> các biến và phương thức static thì thuộc về class và được các object dùng chung.
    * ==> chúng ta muốn gọi phương thức static và thuộc tính static thì chỉ cần gọi thông qua class
    * và không cần khởi tạo đối tượng
    *   - trong các phương thức static không thể sử dụng các biến non static
    *   - trong các phương thức static không thể dùng từ khóa this
    *  => vì sao?
    * - Có 2 thời điểm:
    * Qúa trình compile time:
    * => biến và phương thức static được khởi tạo trong quá trình compile time
    * Qúa trình run time:
    * => các thuộc tính và phương thức thì nó sẽ được tạo trong quá trình run time
    * - khi chạy thì mới biết biến this thuộc object nào, và đang trỏ đến vùng nhớ nào
    * => vì khi chạy từ khóa new mới tạo ra 1 vùng nhớ để lưu biến đó trên vùng nhớ heap
    * - tại thời điểm compile time thì this chưa được xác định (chưa biết biến gì và chưa biết trỏ đến vùng nhớ nào)
    * => thuộc tính non static cũng vậy, khi có vùng nhớ để lưu trữ nó nó mới có thể mang được giá trị
    * => trong quá trình compile time, nó chưa trỏ đến vùng nhớ nào nên chưa có giá trị => static không hiểu được
    *
    *** final ***
    * => final sinh ra để khai báo một hằng số
    * => khởi tạo biến final thường đi kèm với static vì static chỉ khởi tạo một lần
    * - khi khai báo final thì bắt buộc phải khởi tạo giá trị khi đi cùng với static
    * - nếu không thì, bỏ static đi vì static chạy trong quá trình compile, vậy PI gán trị tại các phương thức được
    *   => chú ý: Tại 1 thời điểm chỉ gọi được 1 constructor, nên constructor nào gọi trước thì PI sẽ gán theo
    *           giá trị đó. Như vậy, nếu với TH non static thì đó là biến object, cho nên có thể khởi tạo PI ở
    *           2 constructor khác nhau vì không cạnh trang vùng nhớ.
    *
    * */

    public static void main(String[] args) {
        System.out.println(SinhVien.schoolName);
        // biến static là biến chung của class, mọi object đều có thể sử dụng
        SinhVien s1 = new SinhVien();
        s1.schoolName = "Đại học Bách Khoa Hà Nội";
        System.out.println(s1.getSchoolName());
        // khi 1 object thay đổi biến static thì mọi objectd dều thay đổi theo
        // => biến staic chỉ có 1 vùng nhớ và tất cả đều tham chiếu đến vùng nhớ đó
        // dùng tên class gọi cũng được, dùng object gọi cũng được
        SinhVien s2 = new SinhVien("sang", 21);
        System.out.println(s2);
        SinhVien s3 = new SinhVien("nam", 23);
        System.out.println(s3);
        // static không nằm trong vùng nhớ heap

        System.out.println("-----------------------------------------------------------------------------------------");

        // Singleton design pattern: trong 1 class chỉ có thể khởi tạo duy nhất 1 đối tượng
        // Khi nào dùng Singleton ???
        // ===>
        // chạy trên môi trường Single Thread
        SinhVien sinhvien1 = SinhVien.of("namdg97", 23);
        SinhVien sinhvien2 = SinhVien.of("nambeooo", 22);
        System.out.println(sinhvien1);
        System.out.println(sinhvien2);
        // Singleton trên không bảo đảm được Multi Thread
        // sửa lại thì chạy được trên môi trường Multi Thread
//        for (int i = 0 ; i < 2000 ; i++) {
//            new Thread(() -> {
//                SinhVien sinhvien = SinhVien.of("namdg97", 23);
//                System.out.println(sinhvien);
//            }).start();
//        }
    }

}
