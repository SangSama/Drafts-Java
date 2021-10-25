package buoi12;

/*
* extends : kế thừa các class
* => 1 class chỉ extends được 1 class
* => 1 Interface có thể extends được nhiều Interface khác
* implements : kế thừa các interface
* => 1 class có thể impelement được nhiều class => đa kế thừa kiểu chức năng
*
* */

public class Car implements Travel, HangXe{

    @Override
    public void move() {
        System.out.println("By Car");

        Travel.getInstance().print();
    }
}
