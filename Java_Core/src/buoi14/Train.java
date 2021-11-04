package buoi14;

public class Train extends AdapterTravel{
    // dùng method nào override lại method ý thôi
    // tránh phải override lại những method không dùng đến
    @Override
    public void travel() {
        super.travel();
    }

    @Override
    public void method6() {
        super.method6();
    }

    @Override
    public void method11() {
        super.method11();
    }
}
