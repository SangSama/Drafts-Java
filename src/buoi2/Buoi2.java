package buoi2;

import com.sun.security.jgss.GSSUtil;

import java.util.Scanner;

public class Buoi2 {
    /*
    * ***CONTENT***
    * Câu lệnh điều kiện rẽ nhánh
    * - chỉ sử dụng if:
    *   if (đk) {
    *   }
    *   ....
    *   if (đk) {
    *   }
    * - if else:
    *   if (đk) {
    *   } else {}
    * ===> điều kiện có khả năng xảy ra giống nhau
    * ===> cùng nằm trong 1 tập hợp
    * VD: {a,b,c,d} => khả năng giống nhau => tìm max dùng if, if else, không sử dụng else if
    * - sử dụng else if:
    *   if (đk) {
    *   } else if (dk) {
    *   } else {}
    * ===> không năm cùng 1 tập hợp
    * VD: 1-10 => A; 11-20 => B
    * ===> if else thì điều kiện dùng được nhiều kiểu dữ liệu, nhiều toán tử so sánh.
    * - dùng switch case:
    *   int thang = 2;
    *   switch (thang) {
    *       case 1:
    *           System.out.println("Có 31 ngày");
    *           break;
    *       case 2:
    *           System.out.println("Có 28 ngày");
    *       case 3:
    *           System.out.println("Có 30 ngày");
    *           break;
    *       default;
    *   }
    * ===> điều kiện chỉ làm việc với: số nguyên (byte, char, short, int, long); string; enum.
    * ===> với các case thì chỉ làm việc với: so sánh bằng
    * ===> break để khi gặp case đúng sẽ thoát khỏi vòng lặp.
    * Khi case đúng mà không break thì sẽ mặc đi các case sau sẽ không so sánh.
    * ===> default được thực thi nếu tất cả các case không thỏa mãn
    *------------------------------------------------------------------------------------
    * Các toán tử điều kiện
    * ==: toán tử so sánh bằng => chỉ đúng khi hai giá trị so sánh với nhau mà bằng nhau.
    * !=: toán tử so sánh khác => chỉ đúng khi hai giá trị so sánh với nhau mà không bằng nhau.
    * && (mệnh đề dài đuôi): phép (A và B) => chỉ đúng khi mệnh đề A và B đều đúng.
    * & (mệnh đề ngắn đuôi): phép (A và B) => chỉ đúng khi mệnh đề A và B đều đúng.
    * ==> khác nhau. với A && B, A sai thì không xét B nữa. còn A & B, A sai vẫn xét B.
    * VD:
    *   int a=5, b=10;
    *   if ( 1<0 && a++>4 ) {
    *       System.out.println("nhận");
    *   }
    *   System.out.println(a);  // a không nhận => a=5
    *   if ( 1<0 & a++>4 ) {
    *       System.out.println("nhận");
    *   }
    *   System.out.println(a);  // a nhận => a=6
    * || (mệnh đề dài đuôi): phép (A hoặc B) => chỉ sai khi mệnh đề A và B đều sai.
    * | (mệnh đề ngắn đuôi): phép (A hoặc B) => chỉ sai khi mệnh đề A và B đều sai.
    * ==> khác nhau. với A || B, A đúng thì không xét B nữa. còn A & B, A đúng vẫn xét B.
    * VD:
    *   int a=5, b=10;
    *   if ( 1>0 || a++<4 ) {
    *       System.out.println("nhận");
    *   }
    *   System.out.println(a);  // a không nhận => a=5
    *   if ( 1>0 | a++<4 ) {
    *       System.out.println("nhận");
    *   }
    *   System.out.println(a);  // a nhận => a=6
    * !: nó sẽ phủ định cái mệnh đề (MĐ) đó.
    * VD: !false = true;
    *     !true = false;
    * */

    /*
    * Thuật toán đặt lính canh: tìm mốc trong hệ quy chiếu
    * VD: int max = a;
    *     if ( max < b ) {
    *       max = b;
    *     }
    *     if ( max < c ) {
    *       max = c;
    *     }
    *     System.out.println(max); // in ra max trong 3 số a,b,c.
    * => Trong bài toán so sánh max: if {} nhanh hơn toán tử 3 ngôi
    * ==> Vì: if {} --> mất 2 lần so sánh
    *         toán tử 3 ngôi --> mất 4 lần so sánh
    * */

    /*
    * HOMEWORK
    * Bài 1: Nhập vào tháng cho biết tháng đó có bao nhiêu ngày?
    * Bài 2: Nhập vào 1 số cho biết số đó có phải số chính phương hay không?
    * Bài 3: Tìm min, max của 4 số a,b,c,d?
    * Bài 4: Nhập vào 3 cạnh của tam giác hãy cho biết tam giác vừa nhập là tam giác gì?
    * Bài 5: Gỉa hệ phương trình bậc nhất 2 ẩn {ax+by=c; dx+ey=f}
    * */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

//        //Bài 1:
//        System.out.print("Nhập tháng ");
//        int month = sc.nextInt();
//        while ( month < 1 || month > 12 ) {
//            month = sc.nextInt();
//        }
//        switch ( month ) {
//            case 2:
//                System.out.println("Có 28 hoặc 29 ngày");
//                break;
//            case 4:
//            case 6:
//            case 9:
//            case 11:
//                System.out.println("Có 30 ngày");
//                break;
//            default:
//                System.out.println("Có 31 ngày");
//        }


//        //Bài 2:
//        System.out.print("Nhấp số: ");
//        int num = sc.nextInt();
//        if ( num <= 0 ) System.out.println("Đây không phải số chính phương");
//        else {
//            int can = (int) Math.sqrt(num);
//            if ( can*can==num ) System.out.println(num+" là số chính phương");
//            else System.out.println(num+" không phải số chính phương");
//        }


        //Bài 3:
        System.out.println("Tìm min, max của 4 số a,b,c,d:");
        System.out.print("Nhập a = ");
        int a = sc.nextInt();
        System.out.print("Nhập b = ");
        int b = sc.nextInt();
        System.out.print("Nhập c = ");
        int c = sc.nextInt();
        System.out.print("Nhập d = ");
        int d = sc.nextInt();
        int max = a;
        if ( max<b ) max=b;
        if ( max<c ) max=c;
        if ( max<d ) max=d;
        int min = a;
        if ( min>b ) min=b;
        if ( min>c ) min=c;
        if ( min>d ) min=d;
        System.out.println("max = "+max);
        System.out.println("min = "+min);


//        //Bài 4
//        System.out.println("Nhập vào 3 cạnh của 1 tam giác");
//        System.out.print("Cạnh 1: ");
//        int a = sc.nextInt();
//        System.out.print("Cạnh 2: ");
//        int b = sc.nextInt();
//        System.out.print("Cạnh 3: ");
//        int c = sc.nextInt();
//        if ( a+b>c && b+c>a && c+a>b ) {
//            if ( a==b || b==c || c==a ) System.out.println("Đây là tam giác cân");
//            else if ( a==b && b==c && c==a ) System.out.println("Đây là tam giác đều");
//            else if ( a*a+b*b==c*c || b*b+c*c==a*a || c*c+a*a==b*b ) System.out.println("Đây là tam giác vuông");
//            else if ( a*a+b*b<c*c || b*b+c*c<a*a || c*c+a*a<b*b ) System.out.println("Đây là tam giác tù");
//            else System.out.println("Đây là tam giác nhọn");
//        } else System.out.println("Đây không phải là tam giác");


//        //Bài 5
//        System.out.println("hệ pt bậc nhất 2 ẩn: {ax+by=c; dx+ey=f;}");
//        System.out.print("Nhập a: ");
//        int a = sc.nextInt();
//        System.out.print("Nhập b: ");
//        int b = sc.nextInt();
//        System.out.print("Nhập c: ");
//        int c = sc.nextInt();
//        System.out.print("Nhập d: ");
//        int d = sc.nextInt();
//        System.out.print("Nhập e: ");
//        int e = sc.nextInt();
//        System.out.print("Nhập f: ");
//        int f = sc.nextInt();
//        int N = a*e - d*b;
//        int N1 = b*f - e*c;
//        int N2 = a*f - d*c;
//        if ( N==0 ) {
//            if ( N1==0 && N2==0 ) System.out.println("vô số nghiệm");
//            else System.out.println("vô nghiệm");
//        } else {
//            float x = (float) N1 / N;
//            float y = (float) N2 / N;
//            System.out.println("có 1 nghiệm duy nhất: x="+x+" , y="+y);
//        }


//        //Bài 1: ax + b = 0
//        //Bài 2: ax^2 + bx + c = 0
//        System.out.print("Nhập a: ");
//        int a = sc.nextInt();
//        System.out.print("Nhập b: ");
//        int b = sc.nextInt();
//        System.out.print("Nhập c: ");
//        int c = sc.nextInt();
//        System.out.println("Phương trình ax + b = 0:");
//        if ( a==0 ) {
//            if ( b== 0 )
//                System.out.println("Vô số nghiệm");
//            else System.out.println("Vô nghiệm");
//        } else {
//            float x = (float) -b/a;
//            System.out.println("Nghiệm là: "+ -b/a);
//        }
//        System.out.println("Phương trình ax^2 + bx + c = 0:");
//        if ( a==0 ) {
//            if ( b==0 ) {
//                if ( c==0 )
//                    System.out.println("Vô số nghiệm");
//                else System.out.println("Vô nghiệm");
//            } else {
//                float n = (float) -c/b;
//                System.out.println("Có 1 nghiệm: "+ n);
//            }
//        } else {
//            int delta = b*b - 4*a*c;
//            if ( delta > 0 ) {
//                float x1 = (float) ((-b + Math.sqrt(delta))/2*a);
//                float x2 = (float) ((-b - Math.sqrt(delta))/2*a);
//                System.out.println("Có 2 nghiệm: x1="+x1+" , x2="+x2);
//            } else if ( delta == 0 ) {
//                System.out.println("Có nghiệm kép: x1=x2="+-b/2*a);
//            } else System.out.println("Vô nghiệm");
//        }
    }
}
