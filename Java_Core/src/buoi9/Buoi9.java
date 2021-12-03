package buoi9;

public class Buoi9 {
    /*
    * ===> Cần đọc thêm về vùng nhớ heap, stack, pool
    * String pool: sẽ tạo ra 1 vùng nhớ riêng của String
    * s1 = "sondx" => nó sẽ vào kiểm tra vùng nhớ trong pool đã tồn tại vùng nhớ "sondx" nào chưa
    *   => chưa có => tạo mới
    * s2 = "sondx" => nó sẽ vào kiểm tra vùng nhớ pool xem tồn tại chưa
    *   => tồn tại rồi => s2 -> "sondx" : s2 trỏ đến vùng nhớ có giá trị là "sondx"
    *   ==> khi so sánh s1 == s2 là so sánh địa chỉ nhớ thì s1, s2 đều đang trỏ đến cùng 1 địa chỉ nhớ => true
    * s3 = new => khi dùng từ khóa new thì giá trị sẽ được lưu trên vùng nhớ heap
    *   ==> khi só sánh s1 == s3 => false
    * tên biến s1,s2,s3 đều được lưu trên vùng nhớ stack.
    *
    * ===> Học về String, StringBuilder, StringBuffer
    * Bản chất của phép cộng chuỗi
    * String s1 = "sondx";
    * s1 = s1 + " dep trai";
    * => bản chất là "sondx" + " dep trai" => sẽ kiểm tra vùng nhớ pool có giá trị "sondx dep trai" chưa
    * => nếu chưa sẽ tạo mới, cho s1 trỏ lại vùng nhớ "sondx dep trai" này
    *   ==> không còn trỏ vùng nhớ "sondx" nữa --> Nhưng vùng nhớ "sondx" không được giải phóng
    *   ===> Cứ mỗi lần cộng chuỗi, nó tạo ra vùng nhớ mới và không xóa vùng nhớ cũ đi
    * =====> bản chất cộng chuỗi là tạo ra 1 mảng mới có kích thước bằng tổng 2 mảng, sau đó copy từng phần tử của
    * mảng cũ sang mảng mới
    *   => nghĩa là String Builder
    * StringBuilder s = new StringBuilder();
    * => khi chúng ta cộng chuỗi => nó tạo ra 1 vùng nhớ đủ lớn để lưu giá trị của mảng bạn đầu
    * VD: ban đầu có 10 phần tử => cấp phát quá lên 20 phần tử
    *     => mỗi lần thêm mới vào chuỗi này, thì thêm vào cuối, thêm đến khi đạt quá 20 phần tử => tạo mới 40 phần tử
    *     => copy từ cũ sang mới và thêm vào cuối
    * ===> Tránh việc copy nhiều : đến ngưỡng mới copy
    * ===> Chỉ tạo ra 1 vùng nhớ : dùng xong thì xóa vùng nhớ cũ đi
    *   => Phép cộng String sẽ chậm hơn phép cộng StringBuilder
    *
    *   StringBuilder s = new StringBuilder();
    * // nó sẽ không tốt trong quá trình Multi Thread
    * => false safe : không an toàn
    *   StringBuffer s1 = new StringBuffer();
    * // đảm bảo trong tại 1 thời điểm chỉ cho phép duy nhất 1 thằng thêm vào vị trí đó, nó phải check, block lại vị trí đấy
    * => false fast : không nhanh
    *
    * */


    public static void main(String[] args) {
        // bản chất s1, s2, s3 là đối tượng => cho nên phép == không phải so sánh giá trị mà là so sánh vùng nhớ
        String s1 = "sondx"; // đối tượng
        String s2 = "sondx";
        String s3 = new String("sondx");
        System.out.println(s1 == s2); // so sánh vùng nhớ
        System.out.println(s1 == s3);
    }

}
