package buoi17;

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
