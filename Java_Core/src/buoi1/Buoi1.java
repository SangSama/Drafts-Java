package buoi1;

import java.util.Scanner;

public class Buoi1 {
    /*
    * *** CONTENT ***
    * Các kiểu dữ liệu nguyên thủy trong java:
    * - Kiểu số nguyên:
    *  + byte: 1 byte = 8 bit ==> -2^7...0...2^7-1 (miền giá trị)
    *  + short: 2 byte = 16 bit ==> -2^15...0...2^15-1
    *  + int: 4 byte = 32 bit ==> -2^31...0...2^31-1
    *  + long: 8 byte = 64 bit ==> -2^63...0...2^63-1
    * ==> giá trị vòng: quy luật vòng của mình giá trị (dịch bit)
    * VD: byte a = -128;
    *     a = a - 1; //-128 - 1 = 127
    * - Kiểu số thực:
    *  + float: 4 byte (làm tròn sau dấu ',' 7 chữ số)
    *  + double: 8 byte (làm tròn sau dấu ',' 19 chữ số)
    * ===> độ chính xác của double cao hơn độ chính xác của float
    * - Kiểu ký tự:
    *  + char: 1 byte = 8 bit ==> -2^7...0...2^7-1 = -128...0...127 = 255 ký tự
    * ===> tuân theo bảng mã ASCII. với ký tự có dấu tương đương với 2 byte, 1 byte dấu, 1 byte ký tự.
    * - Kiểu luận lý:
    *  + boolean: true, false
    * - Kiểu chuỗi:
    *  + String:
    * ## Ép kiểu:
    * - khi gán giá trị từ kiểu lớn hơn sang kiểu bé hơn
    * VD: int x = 190;
    *     byte y = (byte) x;// 190 = 127 + 63 = 127 + 1 + 62 = -128 + 62 = -66
    * VD: int x = 5;
    *     int y = 10;
    *     float z = (float) x / y; // 0.5 - nếu không ép kiểu sẽ ra 0
    *------------------------------------------------------------------------------------
    * Quy tắc đặt tên biến cơ bản: (bắt buộc) => syntax của đặt tên
    * - Tên biến không được trùng với từ khóa của ngôn ngữ (java)
    * - Tên biến không được bắt đầu bằng số: 1a, 2vfg,... ==> được: a1, sfg2, fg2fg,...
    * - Tên biến không được có khoảng trắng: a v, c bnm,... ==> được: a_v,...
    * - Tên biến không được chứa giá trị đặc biệt: xu@n
    *------------------------------------------------------------------------------------
    * Các loại toán tử trong java:
    * - Toán tử 1 ngôi: chỉ cần 1 tham trị
    *  + Tiến tố: ++a, --b
    * ==> Tại thời điểm xuất hiện toán tử 1 ngôi thì giá trị của biến được tăng/giảm
    * VD: int a = 1; hoặc giảm xuống
    *     ++a; //2
    *  + Hậu tố: a++, b--
    * ==> Tại thời điểm xuất hiện hậu tố thì giá trị của biến chưa được tăng/giảm, khi đi qua đó giá trị
của biến mới được tăng/giảm
    * VD: int a = 1;
    *     a++; //1
    *     sout(a); //2
    * - Toán tử 2 ngôi: cần 2 trở lên : +, -, *, /, %
    * - Toán tử 3 ngôi: bt1 ? bt2 : bt3 ==> bt1 == true => bt1 = bt2; bt1 == false => bt1 = bt3
    * */

    /*
    * HOMEWORK
    * Bài 1: Tính tổng các chữ số của số n (n nhập từ bàn phím)
VD: n=12345 => tong=15
    * Bài 2: Tìm min, max của 3 số a,b,c (a,b,c nhập từ bàn phím)
VD: a=3,b=6,c=1 => max = 6 và min=1
    * */

    /*
    * Nguyên tắc khi làm lập trình
    * => Xác định được input đầu vào
    * => Xác định được output đầu ra của bài toán
    * */

    public static void main(String[] args) {
    // Bài 1:
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập n: ");
        int n = sc.nextInt();
        int sum = 0;
        while ( n > 0 ) {
            sum += n%10;
            n /= 10;
        }
        System.out.println("Tổng: "+sum);
        System.out.println("----------------------");
    // Bài 2
        System.out.print("Nhập a: ");
        int a = sc.nextInt();
        System.out.print("Nhập b: ");
        int b = sc.nextInt();
        System.out.print("Nhập c: ");
        int c = sc.nextInt();
        int max = a>b ? a : b;
        max = max>c ? max : c;
        System.out.println("Max: "+max);
        int min = c<b ? c : b;
        min = min<a ? min : a;
        System.out.println("Min: "+min);
    }



}
