package buoi3;

import java.util.Scanner;

public class Buoi3 {

    /*
    * ***CONTENT***
    * Vòng lặp : for, while, do...while, continue, break
    *
    * for ( khởi tạo; điều kiện lặp; bước lặp ) {
    *       // hành độnng lặp
    * }
    *-------------------------------------------
    * VD1: S = 1+2+3+4+5+6+7
    * int S = 0;
    * for ( int i = 1 ; i < 8 ; i++ ) {
    *   S += i;
    * }
    *-------------------------------------------
    * VD2: tính n!
    * int X = 1;
    * for ( int i = 1 ; i <= n ; i++ ) {
    *   X *= i;
    * }
    *-------------------------------------------
    * VD3: H = x^n = x + x*x + x*x*x + ...
    * int H = 0;
    * int M = 1;
    * for ( int i = 1 ; i <= n ; i++ ) {
    *   M *= M*x;
    *   H += M;
    * }
    *-------------------------------------------
    * VD4: S = 1/1 + (1+2)/(1*2) + ... + (1+2+3+...+n)/n!
    * float S = 0;
    * int S1 = 0;
    * int S2 = 1;
    * for ( int i = 1 ; i <= n ; i++ ) {
    *   S1 += i;
    *   S2 *= i;
    *   S += (float) S1/S2;
    * }
    *------------------------------------------------------------------------------------
    * Vòng lặp lồng
    * for ( khởi tạo ; điều kiện lặp ; bước lặp ) {
    *   for ( khởi tạo ; điều kiện lặp ; bước lặp ) {
    *       // với mỗi giá trị của for cha sẽ chạy n vòng lặp for con
    *   }
    * }
    *-------------------------------------------
    * VD1: nhập rộng, dài. In ra hình sao.
    * Scanner sc = new Scanner(System.in);
    * int w = sc.nextInt();
    * int h = sc.nextInt();
    * for ( int i = 1 ; i <= w ; i++ ) {
    *   for ( int j = 1 ; j <= h ; j++ ) {
    *       System.out.print("*")
    *   }
    *   System.out.println("");
    * }
    * // không nên dùng cộng chuỗi vì sẽ tăng vùng lưu trữ lên
    *-------------------------------------------
    * VD2: In hình rỗng giữa // in ra khi w = 1, w = n, h = 1, h = n
    * int w = sc.nextInt();
    * int h = sc.nextInt();
    * for ( int i = 1 ; i <= w ; i++ ) {
    *   for ( int j = 1 ; j <= h ; j++ ) {
    *       if ( i =
    *       System.out.print("*")
    *   }
    *   System.out.println("");
    * }
    *-------------------------------------------
    * VD3: In * tăng dần
    * *
    * **
    * ***
    * ****
    * for ( int i = 1 ; i <= n ; i++ ) {
    *   for ( int j = 1 ; j <= i ; j++ ) {
    *       System.out.print("*");
    *   }
    *   System.out.println();
    * }
    * // để ý sẽ thấy i luôn <= j
    *
    *
    * */

    /*Thuật toán đặt cờ hiệu
    *
    *
    * */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập n: ");
        int n = sc.nextInt();
        float S = 0;
        float T = 1;
        double A = 0;
        double B = 1;
        System.out.print("Nhập x (b10, b12-b14, b16-b19): ");
        float x = sc.nextFloat();
        System.out.print("Nhập 1 số nguyên N (b20-b32): ");
        int N = sc.nextInt();
        System.out.print("Nhập nguyên dương a = ");
        int a = sc.nextInt();
        System.out.print("Nhập nguyên dương b = ");
        int b = sc.nextInt();
        System.out.print("Nhập nguyên dương c = ");
        int c = sc.nextInt();

//        bai001(n, S);
//        bai002(n, S);
//        bai003(n, S);
//        bai004(n, S);
//        bai005(n, S);
//        bai006(n, S);
//        bai007(n, S);
//        bai008(n, S);
//        bai009(n, T);
//        bai010(n, T, x);
//        bai011(n, T, S);
//        bai012(n, x, S, T);
//        bai013(n, x, S, T);
//        bai014(n, x, S);
//        bai015(n, S);
//        bai016(n, x, S);
//        bai017(n, x, S, T);
//        bai018(n, x, S, T);
//        bai019(n, x, S, T);
//        bai020(N);
//        bai021(N, S);
//        bai022(N, T);
//        bai023(N);
//        bai024(N);
//        bai025(N, S);
//        bai026(N, T);
//        bai027(N, S);
//        bai028(N, S);
//        bai029(N);
//        bai030(N, S);
//        bai031(N);
//        bai032(N);
//        bai033(n, A);
//        bai034(n, A);
//        bai035(n, A);
//        bai036(n, A);
//        bai037(n, A);
//        bai038(n, A);
//        bai039(n, A, B);
//        bai040(n, x, A);
//        bai041(n, A, B);
//        bai042(n, S);
//        bai043(n);
//        bai044(n, S);
//        bai045(n, T);
//        bai046(n);
//        bai047(n, S);
//        bai048(n, T);
//        bai049(n);
//        bai050(n);
//        bai051(n);
//        bai052(n);
//        bai053(n);
//        bai054(n);
//        bai055(n);
//        bai056(n);
//        bai057(n);
//        bai058(n);
//        bai059(n);
//        bai060(n);
//        bai061(n);
//        bai062(a, b);
//        bai063(a, b);
//        bai064(a, b);
//        bai065(a, b, c);
//        bai066(a, b, c);
//        bai067(n, x, S);
//        bai068(n, x, S);
//        bai069(n, x, S);
//        bai070(n, S);
//        bai071(n, x, S);
    }

    static void bai001(int n, float S) {
        for ( int i = 1 ; i <= n ; i++ ) S += i;
        System.out.println("Bài 1: Tổng S(n) = 1 + 2 + ... + n = "+S);
    }

    static  void bai002(int n, float S) {
        for ( int i = 1 ; i <= n ; i++ ) S += i*i;
        System.out.println("Bài 2: Tổng S(n) = 1*1 + 2*2 + ... + n*n = "+S);
    }

    static  void bai003(int n, float S) {
        for ( int i = 1 ; i <= n ; i++ ) S += (float) 1/i;
        System.out.println("Bài 3: Tổng S(n) = 1 + 1/2 + ... + 1/n = "+S);
    }

    static void bai004(int n, float S) {
        for ( int i = 1 ; i <= n ; i++ ) S += (float) 1/(2*i);
        System.out.println("Bài 4: Tổng S(n) = 1/2 + 1/4 + ... + 1/2n = "+S);
    }

    static void bai005(int n, float S) {
        for ( int i = 0 ; i <= n ; i++ ) S += (float) 1/(2*i+1);
        System.out.println("Bài 5: Tổng S(n) = 1 + 1/3 + ... + 1/(2n+1) = "+S);
    }

    static void bai006(int n, float S) {
        for ( int i = 1 ; i <= n ; i++ ) S += (float) 1 / (i * (i + 1));
        System.out.println("Bài 6: Tổng S(n) = 1/1*2 + 1/2*3 + ... + 1/n(n+1) = "+S);
    }

    static void bai007(int n, float S) {
        for ( int i = 1 ; i <= n ; i++ ) S += (float) i/(i+1);
        System.out.println("Bài 7: Tổng S(n) = 1/2 + 2/3 + ... + n/(n+1) = "+S);
    }

    static void bai008(int n, float S) {
        for ( int i = 0 ; i <= n ; i++ ) S += (float) (2*i+1)/(2*i+2);
        System.out.println("Bài 8: Tổng S(n) = 1/2 + 3/4 + ... + (2*n+1)/(2*n+2) = "+S);
    }

    static void bai009(int n, float T) {
        for ( int i = 1 ; i <= n ; i++ ) T *= i ;
        System.out.println("Bài 9: Tích T(n) = 1*2*...*n = "+T);
    }

    static void bai010(int n, float T, float x) {
        for ( int i = 1 ; i <= n ; i++ ) T *= x ;
        System.out.println("Bài 10: Tích T(x,n) = x^n = "+T);
    }

    static void bai011(int n, float T, float S) {
        for ( int i = 1 ; i <= n ; i++ ) {
            for ( int j = 1 ; j <= i ; j++ ) T *= j;
            S += T;
            T = 1;
        }
        System.out.println("Bài 11: Tính S(n) = 1 + 1*2 + ... + 1*2*..*n = "+S);
    }

    static void bai012(int n, float x, float S, float T) {
        for ( int i = 1 ; i <= n ; i++ ) {
            T *= x;
            S += T;
        }
        System.out.println("Bài 12: Tính S(n) = x + x^2 + ... + x^n = "+S);
    }

    static void bai013(int n, float x, float S, float T) {
        for ( int i = 1 ; i <= n ; i++ ) {
//            T *= Math.pow(x, 2*i);
            T *= x*x;
            S += T;
        }
        System.out.println("Bài 13: Tính S(n) = x^2 + x^4 + ... + x^2n = "+S);
    }

    static void bai014(int n, float x, float S) {
        for ( int i = 0 ; i <= n ; i++ ) {
            S += Math.pow(x, 2*i+1);
        }
        System.out.println("Bài 14: Tính S(n) = x + x^3 + ... + x^(2n+1) = "+S);
    }

    static void bai015(int n, float S) {
        for ( int i = 1 ; i <= n ; i++ ) {
            int m = 0;
            for ( int j = 1; j <= i ; j++ ) m += j;
            S += (double) 1/m;
        }
        System.out.println("Bài 15: Tính S(n) = 1 + 1/(1+2) + ... + 1/(1+2+..+n) = "+S);
    }

    static void bai016(int n, float x, float S) {
        for ( int i = 1 ; i <= n ; i++ ) {
            int m = 0;
            for ( int j = 1; j <= i ; j++ ) m += j;
            S += (float) Math.pow(x, i)/m;
        }
        System.out.println("Bài 16: Tính S(n) = x + x^2/(1+2) + ... + x^n/(1+2+..+n) = "+S);
    }

    static void bai017(int n,float x, float S, float T) {
        for ( int i = 1 ; i <= n ; i++ ) {
            T *= x;
            float m = 1;
            for ( int j = 1 ; j <= i ; j++ ) {
                m *= j;
            }
            S += (float) T/m;
        }
        System.out.println("Bài 17: Tính S(n) = x + x^2/2! + ... + x^n/n! = "+S);
    }

    static void bai018(int n,float x, float S, float T) {
        S += 1;
        for ( int i = 1 ; i <= n ; i++ ) {
            double m = Math.pow(x,2*i);
            for ( int j = 1 ; j <= 2*i ; j++ ) {
                T *= j;
            }
            S += (float) m/T;
            T = 1;
        }
        System.out.println("Bài 18: Tính S(n) = 1 + x^2/2! + ... + x^2n/(2n)! = "+S);
    }

    static void bai019(int n,float x, float S, float T) {
        S += 1;
        for ( int i = 0 ; i <= n ; i++ ) {
            double m = Math.pow(x, 2*i+1 );
            for ( int j = 1 ; j <= 2*i+1 ; j++ ) {
                T *= j;
            }
            S += (float)  m/T;
            T = 1;
        }
        System.out.println("Bài 19: Tính S(n) = 1  + x + x^3/3! + ... + x^(2n+1)/(2n+1)! = "+S);
    }

    static void bai020(int N) {
        System.out.print("Bài 20: ước số của số "+N+" là: ");
        for ( int i = 1 ; i <= N ; i++ ) {
            if ( N%i == 0 ) System.out.print(i+", ");
        }
        System.out.println();
    }

    static void bai021(int N, float S) {
        System.out.print("Bài 21: ước số của số "+N+" là: ");
        for ( int i = 1 ; i <= N ; i++ ) {
            if ( N%i == 0 ) {
                System.out.print(i+", ");
                S += i;
            }
        }
        System.out.println(" => Tổng tất cả ước số = "+S);
    }

    static void bai022(int N, float T) {
        System.out.print("Bài 22: ước số của số "+N+" là: ");
        for ( int i = 1 ; i <= N ; i++ ) {
            if ( N%i == 0 ) {
                System.out.print(i+", ");
                T *= i;
            }
        }
        System.out.println(" => Tích tất cả ước số = "+T);
    }

    static void bai023(int N) {
        System.out.print("Bài 23: ước số của số "+N+" là: ");
        int count = 0;
        for ( int i = 1 ; i <= N ; i++ ) {
            if ( N%i == 0 ) {
                System.out.print(i+", ");
                count++;
            }
        }
        System.out.println(" => Số lượng tất cả ước số = "+count);
    }

    static void bai024(int N) {
        System.out.print("Bài 24: ước số lẻ của số "+N+" là: ");
        for ( int i = 1 ; i <= N ; i++ ) {
            if ( N%i == 0 && i%2 != 0 ) System.out.print(i+", ");
        }
        System.out.println("");
    }

    static void bai025(int N, float S) {
        System.out.print("Bài 25: ước số chẵn của số "+N+" là: ");
        for ( int i = 1 ; i <= N ; i++ ) {
            if ( N%i == 0 && i%2 == 0 ) {
                System.out.print(i+", ");
                S += i;
            }
        }
        System.out.println(" => Tổng tất cả ước số chẵn = "+S);
    }

    static void bai026(int N, float T) {
        System.out.print("Bài 26: ước số lẻ của số "+N+" là: ");
        for ( int i = 1 ; i <= N ; i++ ) {
            if ( N%i == 0 && i%2 != 0 ) {
                System.out.print(i+", ");
                T *= i;
            }
        }
        System.out.println(" => Tích tất cả ước số lẻ = "+T);
    }

    static void bai027(int N, float S) {
        System.out.print("Bài 27: ước số chẵn của số "+N+" là: ");
        int count = 0;
        for ( int i = 1 ; i <= N ; i++ ) {
            if ( N%i == 0 && i%2 == 0 ) {
                System.out.print(i+", ");
                count++;
            }
        }
        System.out.println(" => Số lượng tất cả ước số chẵn = "+count);
    }

    static void bai028(int N, float S) {
        for ( int i = 1 ; i < N ; i++ ) {
            if ( N%i == 0 ) {
                S += i;
            }
        }
        System.out.println("Bài 28: Tổng các ước số nhỏ hơn chính nó = "+S);
    }

    static void bai029(int N) {
        for ( int i = N ; i >= 1 ; i-- ) {
            if ( N%i == 0 && i%2 != 0 ) {
                System.out.println("Bài 29: ước số lẻ lớn nhất của "+N+" là: "+i);
                break;
            }
        }
    }

    static void bai030(int N, float S) {
        for ( int i = 1 ; i < N ; i++ ) {
            if ( N%i == 0 ) {
                S += i;
            }
        }
        if ( S == N ) System.out.println("Bài 30: "+N+" là số hoàn thiện");
        else System.out.println("Bài 30: "+N+" là không phải số hoàn thiện");
    }

    static void bai031(int N) {
        boolean check = true;
        if ( N < 2 ) System.out.println("Bài 31: "+N+" là số nguyên tố");
        else {
            for ( int i = 2 ; i < N ; i++ ) {
                if ( N%i==0 ){
                    check = false;
                    break;
                }
            }
        }
        if ( check ) System.out.println("Bài 31: "+N+" là số nguyên tố");
        else System.out.println("Bài 31: "+N+" không phải số nguyên tố");

    }

    static void bai032(int N) {
        boolean check = false;
        for ( int i = 1 ; i <= N ; i++ ) {
            if ( N%i == 0 && i*i == N ) check = true;
        }
        if ( check ) System.out.println("Bài 32: "+N+" là số chính phương");
        else System.out.println("Bài 32: "+N+" không phải số chính phương");
    }

    static void bai033(int n, double A) {
        for ( int i = 1 ; i <= n ; i++ ) {
            A += 2;
            A = Math.sqrt(A);
        }
        System.out.println("Bài 33: S(n)= √(2 + √(2 + ⋯ √(2 + √2)...)) với n căn = "+A);
    }

    static void bai034(int n, double A) {
        for ( int i = 1 ; i <= n ; i++ ) {
            A += i;
            A = Math.sqrt(A);
        }
        System.out.println("Bài 34: S(n)= √(n + √(n-1 + ⋯ √(2 + √1)...)) với n căn = "+A);
    }

    static void bai035(int n, double A) {
        for ( int i = n ; i >= 1 ; i-- ) {
            A += i;
            A = Math.sqrt(A);
        }
        System.out.println("Bài 35: S(n)= √(1 + √(2 + ⋯ √(n-1 + √n)...)) với n căn = "+A);
    }

    static void bai036(int n, double A) {
        for ( int i = 1 ; i <= n ; i++ ) {
            int m = 1;
            for ( int j = 1; j <= i ; j++ ) {
                m *= j;
            }
            A += m;
            A = Math.sqrt(A);
        }
        System.out.println("Bài 36: S(n)= √(n! + √( (n-1)! + ⋯ √(2! + √1!)...)) với n căn = "+A);
    }

    static void bai037(int n, double A) {
        for ( int i = 2 ; i <= n ; i++ ) {
            double m = (double) 1/i;
            A += i;
            A = Math.pow(A, m );
        }
        System.out.println("Bài 37: S(n) = CanBacN(N + CanBacN–1(N–1 + … + CanBac3(3 + CanBac2(2))) với n-1 căn = "+A);
    }

    static void bai038(int n, double A) {
        for ( int i = 1 ; i <= n ; i++ ) {
            double m = (double) 1/(i+1);
            A += i;
            A = Math.pow(A, m );
        }
        System.out.println("Bài 38: S(n) = CanBac N+1(N + CanBac N(N – 1 + … + CanBac3(2 + CanBac2(1))) với n căn = "+A);
    }

    static void bai039(int n, double A, double B) {
        for ( int i = 1 ; i <= n ; i++ ) {
            double m = (double) 1/(i+1);
            for ( int j = 1 ; j <= i ; j++ ) {
                B *= j;
            }
            A += B;
            A = Math.pow(A, m );
            B = 1.0;
        }
        System.out.println("Bài 39: S(n) = CanBac N+1(N! + CanBac N(N–1! + … + CanBac3(2! + CanBac2(1!))) với n căn = "+A);
    }

    static void bai040(int n, float x, double A) {
        for ( int i = 1 ; i <= n ; i++ ) {
            A += Math.pow(x, i);
            A = Math.sqrt(A);
        }
        System.out.println("Bài 40: S(n)= √(x^n + √(x^(n-1) + ⋯ √(x^2 + √x)...)) với n căn = "+A);
    }

    static void bai041(int n, double A, double B) {
        for ( int i = 1 ; i <= n ; i++ ) {
            A = (double) 1 + B;
            B = (double) 1/A;
        }
        System.out.println("Bài 41: S(n)= 1/(1+(1/(1+...1/(1+1) với n dấu phân số = "+B);
    }

    static void bai042(int n, float S) {
        for ( int i = 1 ; i < n ; i++ ) {
            S += i;
            if ( S >= n ) {
                System.out.println("Bài 42: số k nhỏ hơn n là: "+(i-1));
                break;
            }
        }
    }

    static void bai043(int n) {
        int count = 0;
        while ( n > 0 ) {
            n /= 10;
            count++;
        }
        System.out.println("Bài 43: Số lượng chữ số của n: "+count);
    }

    static void bai044(int n, float S) {
        while ( n > 0 ) {
            S += (int) n%10;
            n /= 10;
        }
        System.out.println("Bài 44: Tổng các chữ số của n = "+S);
    }

    static void bai045(int n, float T) {
        for ( int i = 1 ; i <= n ; i++ ) {
            T *= n%10;
            if ( n/10 == 0 ) break;
            n /= 10;
        }
        System.out.println("Bài 45: Tích các chữ số của n = "+T);
    }

    static void bai046(int n) {
        int count = 0;
        while ( n > 0 ) {
            if ( n%2 == 1 ) count++;
            n /= 10;
        }
        System.out.println("Bài 46: Số lượng chữ số lẻ của n = "+count);
    }

    static void bai047(int n, float S) {
        for ( int i = 1 ; i <= n ; i++ ) {
            if ( n%2 == 0) S += (int) n%10;
            if ( n == 0 ) break;
            n /= 10;
        }
        System.out.println("Bài 47: Tổng chữ số chẵn của n = "+S);
    }

    static void bai048(int n, float T) {
        for ( int i = 1 ; i <= n ; i++ ) {
            if ( n%2 == 1) T *= (int) n%10;
            if ( n == 0 ) break;
            n /= 10;
        }
        System.out.println("Bài 48: Tích chữ số lẻ của n = "+T);
    }

    static void bai049(int n) {
        while ( n > 0 ) {
            int m = n%10;
            if ( n/10 == 0 ) System.out.println("Bài 49: Chữ số đầu tiên của n là: "+m);
            n /= 10;
        }
    }

    static void bai050(int n) {
        System.out.print("Bài 50: chữ số đảo ngược của n là: ");
        while ( n > 0 ) {
            System.out.print(n%10);
            n /= 10;
        }
    }

    static void bai051(int n) {
        int max = n%10;
        while ( n/10 > 0 ) {
            n /= 10;
            if ( max < n%10 ) max = n%10;
        }
        System.out.println("Bài 51: chữ số lớn nhất của n: "+max);
    }

    static void bai052(int n) {
        int min = n%10;
        while ( n/10 > 0 ) {
            n /= 10;
            if ( min > n%10 ) min = n%10;
        }
        System.out.println("Bài 52: chữ số nhỏ nhất của n: "+min);
    }

    static void bai053(int n) {
        int max = n%10;
        int count = 1;
        while ( n/10 > 0 ) {
            n /= 10;
            if ( max < n%10 ) {
                max = n%10;
                count = 0;
            }
            if ( max == n%10 ) count++;
        }
        System.out.println("Bài 53: số lượng chữ số lớn nhất của n: "+count);
    }

    static void bai054(int n) {
        int min = n%10;
        int count = 1;
        while ( n/10 > 0 ) {
            n /= 10;
            if ( min > n%10 ) {
                min = n%10;
                count = 0;
            }
            if ( min == n%10 ) count++;
        }
        System.out.println("Bài 54: số lượng chữ số nhỏ nhất của n: "+count);
    }

    static void bai055(int n) {
        // không hiểu đề bài .-. : Hãy đêm số lượng chữ số đầu tiên của số nguyên dương n.
    }

    static void bai056(int n) {
        boolean check = false;
        while ( n > 0 ) {
            if ( (n%10)%2 == 0 ) {
                check = true;
                break;
            }
            n /= 10;
        }
        if ( check ) System.out.println("Bài 56: n không toàn chữ số lẻ");
        else System.out.println("Bài 56: n có toàn chữ số lẻ");
    }

    static void bai057(int n) {
        boolean check = false;
        while ( n > 0 ) {
            if ( (n%10)%2 == 1 ) {
                check = true;
                break;
            }
            n /= 10;
        }
        if ( check ) System.out.println("Bài 57: n không toàn chữ số chẵn");
        else System.out.println("Bài 57: n có toàn chữ số chẵn");
    }

    static void bai058(int n) {
        // giống bài 57: Hãy kiểm tra số nguyên dương n có toàn chữ số chẵn hay không?
    }

    static void bai059(int n) {
        int m = 0;
        int l = n;
        for ( int i = 0 ; l > 0 ; i++ ) {
            m += (l%10)*Math.pow(10,i);
            l /= 10;
        }
        System.out.println(m);
        if ( m == n ) System.out.println("Bài 59: n là số đối xứng");
        else System.out.println("Bài 59: n không là số đối xứng");
    }

    static void bai060(int n) {
        int test = n%10;
        boolean check = false;
        while ( n/10 > 0 ) {
            n /= 10;
            if ( test < n%10 ) {
                check = true;
                break;
            }
            test = n%10;
        }
        if ( check ) System.out.println("Bài 60: n không tăng dần từ trái sang phải");
        else System.out.println("Bài 60: n tăng dần từ trái sang phải");
    }

    static void bai061(int n) {
        int test = n%10;
        boolean check = false;
        while ( n/10 > 0 ) {
            n /= 10;
            if ( test > n%10 ) {
                check = true;
                break;
            }
            test = n%10;
        }
        if ( check ) System.out.println("Bài 60: n không giảm dần từ trái sang phải");
        else System.out.println("Bài 60: n giảm dần từ trái sang phải");
    }

    static void bai062(int a, int b) {
        int max = a > b ? a : b;
        int min = a < b ? a : b;
        for ( int i = min ; i >= 1; i-- ) {
            if ( min%i == 0 && max%i == 0 ) {
                System.out.println("Bài 62: ước chung lớn nhất của 2 giá trị a và b là: "+i);
                break;
            }
        }
    }

    static void bai063(int a, int b) {
        int max = a > b ? a : b;
        int min = a < b ? a : b;
        if ( a == b ) System.out.println("Bài 63: bội chung nhỏ nhất của 2 giá trị a và b là: "+a);
        else {
            for ( int i = max ; i <= a*b ; i++ ) {
                if ( i%a == 0 && i%b == 0 ) {
                    System.out.println("Bài 63: bội chung nhỏ nhất của 2 giá trị a và b là: "+i);
                    break;
                }
            }
        }

    }

    static void bai064(int a, int b) {
        System.out.println("Bài 64: giải pt ax + b = 0");
        if ( a==0 ) {
            if ( b== 0 )
                System.out.println("Vô số nghiệm");
            else System.out.println("Vô nghiệm");
        } else {
            float x = (float) -b/a;
            System.out.println("Nghiệm là: "+ -b/a);
        }
    }

    static void bai065(int a, int b, int c) {
        System.out.println("Bài 65: giải pt ax^2 + bx + c = 0");
        if ( a==0 ) {
            if ( b==0 ) {
                if ( c==0 )
                    System.out.println("Vô số nghiệm");
                else System.out.println("Vô nghiệm");
            } else {
                float n = (float) -c/b;
                System.out.println("Có 1 nghiệm: "+ n);
            }
        } else {
            int delta = b*b - 4*a*c;
            if ( delta > 0 ) {
                float x1 = (float) ((-b + Math.sqrt(delta))/2*a);
                float x2 = (float) ((-b - Math.sqrt(delta))/2*a);
                System.out.println("Có 2 nghiệm: x1="+x1+" , x2="+x2);
            } else if ( delta == 0 ) {
                System.out.println("Có nghiệm kép: x1=x2="+-b/2*a);
            } else System.out.println("Vô nghiệm");
        }
    }

    static void bai066(int a, int b, int c) {
        System.out.println("Bài 66: giải pt ax^4 + bx^2 + c = 0");
        if ( a==0 ) {
            if ( b==0 ) {
                if ( c==0 )
                    System.out.println("Vô số nghiệm");
                else System.out.println("Vô nghiệm");
            } else {
                float n = (float) -c/b;
                if ( n == 0 ) System.out.println("Có 1 nghiệm là 0");
                else if ( n > 0 ) {
                    n = (float) Math.sqrt(n);
                    System.out.println("Có 2 nghiệm: "+n+" , -"+n);
                } else System.out.println("Vô nghiệm");
            }
        } else {
            int delta = b*b - 4*a*c;
            if ( delta > 0 ) {
                float n1, n2;
                float x1 = (float) ((-b + Math.sqrt(delta))/2*a);
                n1 = (float) Math.sqrt(x1);
                float x2 = (float) ((-b - Math.sqrt(delta))/2*a);
                n2 = (float) Math.sqrt(x2);
                if ( x1 > 0 && x2 > 0 ) {
                    System.out.println("Có 4 nghiệm là: "+n1+" , -"+n1+" , "+n2+" , -"+n2);
                } else if ( x1 > 0 && x2 == 0 ) {
                    System.out.println("Có 3 nghiệm là: "+n1+" , -"+n1+" , "+n2);
                } else if ( x1 == 0 && x2 > 0 ) {
                    System.out.println("Có 3 nghiệm là: "+n1+" , "+n2+" , -"+n2);
                } else if ( x1 > 0 && x2 < 0 ) {
                    System.out.println("Có 2 nghiệm là: "+n1+" , -"+n1);
                } else if ( x1 < 0 && x2 > 0 ) {
                    System.out.println("Có 2 nghiệm là: "+n2+" , -"+n2);
                } else if ( x1 == 0 && x2 == 0 ) {
                    System.out.println("Có 1 nghiệm là 0");
                } else if ( x1 < 0 && x2 < 0 ) {
                    System.out.println("Vô nghiệm");
                }
            } else if ( delta == 0 ) {
                float x = (float) -b/2*a;
                if ( x > 0 ) {
                    x = (float) Math.sqrt(x);
                    System.out.println("Có 2 nghiệm là: "+x+" , -"+x);
                } else if ( x == 0 ) System.out.println("Có 1 nghiệm là 0");
            } else System.out.println("Vô nghiệm");
        }
    }

    static void bai067(int n, float x, float S) {
        for ( int i = 1 ; i <= n ; i++ ) {
            S += Math.pow(-1, i+1)*Math.pow(x, i);
        }
        System.out.println("Bài 67: S(x, n)= x - x^2 + ... + (-1)^(n+1)*x^n = "+S);
    }

    static void bai068(int n, float x, float S) {
        for ( int i = 1 ; i <= n ; i++ ) {
            S += Math.pow(-1, i)*Math.pow(x, 2*i);
        }
        System.out.println("Bài 68: S(x, n)= -x^2 + ... + (-1)^(n)*x^2n = "+S);
    }

    static void bai069(int n, float x, float S) {
        for ( int i = 0 ; i <= n ; i++ ) {
            S += Math.pow(-1, i)*Math.pow(x, 2*i+1);
        }
        System.out.println("Bài 69: S(x, n)= x - x^3 + ... + (-1)^(n)*x^(2n+1) = "+S);
    }

    static void bai070(int n, float S) {
        for ( int i = 1 ; i <= n ; i++ ) {
            int m = 0;
            for ( int j = 1; j <= i ; j++ ) m += j;
            S += (double) Math.pow(-1, i+1)*1/m;
        }
        System.out.println("Bài 70: Tính S(n) = 1 - 1/(1+2) + ... + (-1)^(n+1)*1/(1+2+..+n) = "+S);
    }

    static void bai071(int n, float x, float S) {
        for ( int i = 1 ; i <= n ; i++ ) {
            int m = 0;
            for ( int j = 1; j <= i ; j++ ) m += j;
            S += (float) Math.pow(-1, i)*Math.pow(x, i)/m;
        }
        System.out.println("Bài 71: Tính S(n) = -x + x^2/(1+2) + ... + (-1)^n*x^n/(1+2+..+n) = "+S);
    }

}
