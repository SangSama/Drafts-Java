package buoi15;

import buoi15.collection.LinkedList;
import buoi15.collection.List;
import buoi15.generic.BaseBusiness;
import buoi15.generic.Bond;
import buoi15.generic.CKConstant;
import buoi15.generic.Fund;

public class Buoi15 {
    /*
    *** CONTENT **
    *
    * Generic
    *
    * LinkedList : danh sách liên kết đơn
    *
    * Double Linked List : danh sách liên kết đôi
    *
    * Circle Linked List : danh sách liên kết vòng
    *
    * Stack : LIFO (last in first out)
    *
    * Queue : FIFO (first in first out)
    *
    * */

    public int add(int a, int b) {
        return a + b;
    }

    public float add(float a, float b) {
        return a + b;
    }

    public String add(String a, String b) {
        return a + b;
    }
    // => về mặt cấu trức thì 3 hàm này y hệt nhau
    // => Làm thể nào viết 1 hàm và tái sử dụng được ???
    // ==> dùng generic


    public static void main(String[] args) {
        // generic
        Fund fund = new Fund();
        fund.setBalance(10);
        BaseBusiness.get(CKConstant.FUND).execute(fund);
        Bond bond = new Bond();
        bond.setName("TCB");
        BaseBusiness.get(CKConstant.BOND).execute(bond);

        // LinkedList
        List<Integer> list = new LinkedList<Integer>();
        list.addHead(1);
        list.addHead(2);
        list.addHead(3);
        list.addHead(4);
        list.addHead(5);
        list.addHead(6);

        list.print();
        System.out.println(list.find(4));




    }
}
