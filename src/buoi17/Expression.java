package buoi17;

/*
* Khi interface được đánh dấu là functionprograming phải thỏa mãn:
* => interface chỉ chứa duy nhất 1 public abstract method
*
*
* */

@FunctionalInterface
public interface Expression {

    String operator();

    static String equal() {
        return " = ";
    }

    static String notEqual() {
        return " <> ";
    }

    static String gt() {
        return " < ";
    }

    static String gte() {
        return " <= ";
    }

    static String lt() {
        return " > ";
    }

    static String lte() {
        return " >= ";
    }
}
