package buoi19;

public class Demo1 {
    private String name;
    private String reason;

    public Demo1(String name, String reason) {
        this.name = name;
        this.reason = reason;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    @Override
    public String toString() {
        return "Demo1{" +
                "name='" + name + '\'' +
                ", reason='" + reason + '\'' +
                '}';
    }
}
