package buoi8;

public class Rational {
    private int numerator;
    private int denominator;

    public Rational() {
    }

    public Rational(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public void reduce() {
        int ucln = timUCLN(numerator, denominator);
        this.setNumerator(numerator/ucln);
        this.setDenominator(denominator/ucln);
    }

    public int timUCLN(int numerator, int denominator) {
        int ucln = 0;
        int max = numerator > denominator ? numerator : denominator;
        int min = numerator < denominator ? numerator : denominator;
        for ( int i = min ; i >= 1; i-- ) {
            if ( min%i == 0 && max%i == 0 ) {
                ucln = i;
                break;
            }
        }
        return ucln;
    }

    public void reciprocal() {
        int temp = numerator;
        this.setNumerator(denominator);
        this.setDenominator(temp);
    }

    public void add(Rational rat) {
        int ts = this.getNumerator()*rat.getDenominator() + this.getDenominator()*rat.getNumerator();
        int ms = this.getDenominator()*rat.getDenominator();
        Rational ratAdd = new Rational(ts, ms);
        ratAdd.reduce();
        System.out.println("Tổng hai phân số = " + ratAdd.numerator + "/" + ratAdd.denominator);
    }

    public void subtract(Rational rat) {
        int ts = this.getNumerator()*rat.getDenominator() - this.getDenominator()*rat.getNumerator();
        int ms = this.getDenominator()*rat.getDenominator();
        Rational ratAdd = new Rational(ts, ms);
        ratAdd.reduce();
        System.out.println("Hiệu hai phân số = " + ratAdd.numerator + "/" + ratAdd.denominator);
    }

    public void multiply(Rational rat) {
        int ts = this.getNumerator()*rat.getNumerator();
        int ms = this.getDenominator()*rat.getDenominator();
        Rational ratAdd = new Rational(ts, ms);
        ratAdd.reduce();
        System.out.println("Tích hai phân số = " + ratAdd.numerator + "/" + ratAdd.denominator);
    }

    public void divide(Rational rat) {
        int ts = this.getNumerator()*rat.getDenominator();
        int ms = this.getDenominator()*rat.getNumerator();
        Rational ratAdd = new Rational(ts, ms);
        ratAdd.reduce();
        System.out.println("Thương hai phân số = " + ratAdd.numerator + "/" + ratAdd.denominator);
    }

    // So sánh 2 phân số, sử dụng sai số 0.0001(tolerance) để so sánh.
    public void compare(Rational rat) {

    }

    public int getNumerator() {
        return numerator;
    }

    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    public void setDenominator(int denominator) {
        this.denominator = denominator;
    }

    @Override
    public String toString() {
        return "Rational{" +
                "numerator=" + numerator +
                ", denominator=" + denominator +
                '}';
    }
}
