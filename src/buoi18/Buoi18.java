package buoi18;

/*
 *** Debug ***
 *  - breakpoints
 *  - F8: chạy từng dòng theo dòng lệch code => hàm nào được để breakpoint mới được gọi
 *  - F9: chuyển sang breakpoint tiếp theo, theo đúng trình tự đặt breakpoints
 *  - Để xóa tất cả các điểm dừng breakpoint
 *      + Ctrl + Shift + F8 (mở hộp thoại Breakpoint)
 *      + Ctrl + A (chọn tất cả điểm dừng breakpoint)
 *      + Delete (xóa các điểm dừng đã chọn)
 *      + Enter (xác nhận)
 *
 *** Git ***
 *
 *** Exception ***
 * - Một ngoại lệ (Exception) trong java là một vấn đề phát sinh trong quá trình thực thi chương trình.
 *   + Bao giờ cũng vậy, các class java đều được extends từ Object
 *     + Cao nhất của Exception là Throwable, Throwable có 2 kiểu:
 *       + Error : Lỗi => rất khó phỏng đoán, rất khó fix
 *       + Exceptions : Ngoại lệ --> có 2 ngoại lệ:
 *         + Checked Exceptions => Các lỗi xảy ra trong quá trình Compile-time
 *              VD: Lỗi syntax, lỗi code, FileNotFoundException, input output exception...
 *         + Unchecked Exceptions => Các lỗi xảy ra trong quá trình Run-time
 *              VD: /0, null pointer exception, index out of bound exception
 * => nên bắt exception ở điểm cuối chứ không nên bắt ở điểm đầu
 * - Thằng cha không bắn ra Checked Exceptions nào thì thằng con kho override không được bắn Checked Exceptions
 * nhưng nó có thể Throws Unchecked Exceptions
 * - Thằng cha bắn ra Checked Exceptions thì thằng con không được bắn ra Exception to hơn
 * VD: Thằng cha bắn ra Exception mà thằng con bắn ra Throwable là không được
 * - Stack Trace ?
 *
 *** Enum ***
 * - Giống class, khác ở chỗ sẽ khai báo các đối tượng trước đấy, có bao nhiêu khai báo bấy nhiêu, như thằng liệt kê
 *
 * */

import buoi17.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class Buoi18 {

    public static void main(String[] args) {
        // debug
        QueryPractice query = SqlFactory.equal("userName", "sondx");
        QueryPractice query1 = SqlFactory.equal("password", "123456");
        QueryPractice query2 = SqlFactory.lt("age1", 18);
        QueryPractice query3 = SqlFactory.gt("age", 30);
        List<QueryPractice> queryPractices = Arrays.asList(query, query1, query2, query3);
        QueryPractice query4 = SqlFactory.and(queryPractices);
        SqlBuilder sqlBuilder = new SqlBuilder(query4);
        System.out.println(sqlBuilder.queryPractice(SqlSupport.SELECT));

        // exception
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
        String date = "30/2022/14";
        // Bình thường, exception có đâu sẽ dừng chạy câu lệnh đến đó
        // try.. catch.. giúp trong việc xảy ra Exception vẫn chạy code tiếp
        try {
            Date date1 = simpleDateFormat.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println("đi đến đây không?");
        System.out.println("----------------------------------------------");
        int a = 0;
//        System.out.println(1/a);
        try {
            System.out.println(1/a);
        } catch (ArithmeticException e) {
            // cần đúng loại lỗi
            // Nếu không rõ lỗi gì có thể để Exception, hoặc to nhất là Throwable
            System.out.println(e.getMessage());
        }
        System.out.println("đi đến đây không?");
        System.out.println("----------------------------------------------");
        // Null pointer exception
        ExceptionDemo exceptionDemo = new ExceptionDemo();
//        exceptionDemo.demo(null);
        // nên bắt exception ở điểm cuối chứ không nên bắt ở điểm đầu
        try {
            exceptionDemo.demo(null);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }



    }


}
