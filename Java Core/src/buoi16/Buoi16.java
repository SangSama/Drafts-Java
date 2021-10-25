package buoi16;

import java.util.*;

public class Buoi16 {
    /*
    *** Collection ***
    * Chia làm 2 loại:
    *   * Collection quản lý theo dạng cấu trúc (dạng thông thường)
    *       ==> List, Set, Queue
    *   -> List: cấu trúc dữ liệu lưu trữ cho phép trùng phần tử và không quan tâm thứ tự của các element
    *       - Các phần tử mà được push vào list => nó cho phép các phần tử này được trùng nhau
    *       VD: 1 1 1 1 1 1 1 => size = 7
    *       - List : LinkedList, ArrayList, Vector
    *           -> Vector ít người dùng, hiện tại dùng LinkedList và ArrayList là chính
    *           + LinkedList: Quản lý các phần tử qua con trỏ
    *               => ưu điểm: Thêm, Xóa vì độ phức tạp O(1)
    *           + ArrayList: Quản lý các phần tử qua chỉ số vị trí index
    *               => đối với mảng, việc thêm mới vào danh sách liên tục sẽ xảy ra vấn đề System.copy() liên tục
    *               => chi phí tạo ra vùng nhớ mới và copy sang vùng nhớ mới mất 1 khoảng thời gian
    *               ====> rất chậm: thời gian tốn kém giảm thiểu hiệu suất (performan)
    *           + Vector: Quản lý các phần tử qua index
    *               => bản chất, cách thức làm việc giống ArrayList
    *               ===> Nhưng:
    *                   - ArrayList => fast - false safe
    *                   - Vector    => false fast - thread safe
    *   -> Set: cấu trúc dữ liệu lưu trữ không cho phép trùng phần tử và không quan tâm thứ tự của các element
    *       VD: 1 1 1 2 2 1 3 2 => 1 2 3 => size = 3
    *   -> Queue: cấu trúc dữ liệu lưu trữ cho phép trùng phần tử và quan tâm thứ tự các element
    *
    *   * Collection quản lý theo dạng key-value : Map<Key, Value>
    *       - Key là duy nhất
    *       - Value có thể trùng nhau
    *   VD: với TH: <1, "sang"> và <1, "sondx"> : cùng key khác value
    *       => sẽ lưu giá trị cuối cùng
    *
    *** Observer Pattern ***
    *
    * */

    public static void main(String[] args) {

        // List
        List<Integer> integers = new ArrayList<>();
        integers.add(1);
        integers.add(6);
        integers.add(1);
        integers.add(4);
        integers.add(3);
        integers.add(5);

        // Sắp xếp tăng dần
        // Cách viết 1
        integers.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });
        // Cách viết 2
//        integers.sort((o1, o2) -> o1.compareTo(o2));
        // Cách viết 3
//        integers.sort(Integer::compareTo);

         // Sắp xếp giảm dần => đảo vị trí o1 và o2

        // Tìm kiếm
        int y = Collections.binarySearch(integers, 1);
        System.out.println(y);
        int z = Collections.binarySearch(integers, 1, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });
        System.out.println(z);

        // lấy só lượng phần tử => size
        int size = integers.size();

        // Các duyệt phần tử
        // for
        for (int i = 0; i < size ; i++) {
            System.out.println(integers.get(i));
        }
        System.out.println("----------------------");
        // for x
        for (int i : integers) {
            System.out.println(i);
        }
        System.out.println("----------------------");
        // interator
        Iterator<Integer> x = integers.iterator();
        while (x.hasNext()) {
            System.out.println(x.next());
        }
        System.out.println("----------------------");
        // foreach
        integers.forEach(i -> System.out.println(i));
        System.out.println("----------------------");
        // foreach
        integers.forEach(System.out::println);


        // Set
        // HashSet() bản chất là Map<Key, Value>
        // key (giá trị key) => VD: sondx chuyển sang int => index % m (số bất kỳ nào đó) => hash
        // => hash : địa chỉ của value
        // value => trùng giá trị => cùng mã hash
        // => thuật hash => key unique (key duy nhất)
        Set<String> names = new HashSet<>();
        names.add("sondx");
        names.add("sondx");
        names.add("sang");
        names.add("kien");
        // không hề in ra 2 sondx
        System.out.println(names);


        // Stack
        // bài toán hiểu nguyên lý hoạt động
        Stack<Integer> stack = new Stack<>();
        int n = 10;
        while (n != 0) {
            stack.push(n%2);
            n /= 2;
        }
        while (!stack.isEmpty()) {
            System.out.print(stack.pop());
        }

        // Kiểm tra vòng lặp hợp lý ((()))
        Stack<Character> stackk = new Stack<>();
        String s = "((()()))";
        boolean check = true;
        char[] ss = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            if (ss[i] == '(') {
                stackk.push(ss[i]);
            } else {
                if (stackk.isEmpty()) {
                    check = false;
                    break;
                }
                char c = stackk.peek();
                if (c == '(') {
                    stackk.pop();
                } else {
                    check = false;
                    break;
                }
            }
        }
        if (!stackk.isEmpty()) check = false;
        if (check) System.out.println("biểu thức hợp lệ");
        else System.out.println("biểu thức không hợp lệ");

        // Kiểm tra vòng lặp hợp lý {[()()]}
        Stack<Character> stackkk = new Stack<>();
        String s2 = "{[()()]}";
        boolean checkk = true;
        char[] ss2 = s2.toCharArray();
        for (int i = 0; i < s2.length(); i++) {
            if (ss2[i] == '(' || ss2[i] == '[' || ss2[i] == '{') {
                stackkk.push(ss2[i]);
            } else {
                if (stackkk.isEmpty()) {
                    checkk = false;
                    break;
                }
                char c = stackkk.peek();
                if (ss2[i] == ')') {
                    if (c == '[' || c == '{') {
                        checkk = false;
                        break;
                    } else {
                        stackkk.pop();
                    }
                } else if (ss2[i] == ']') {
                    if (c == '(' || c == '{') {
                        checkk = false;
                        break;
                    } else {
                        stackkk.pop();
                    }
                } else if (ss2[i] == '}') {
                    if (c == '[' || c == '[') {
                        checkk = false;
                        break;
                    } else {
                        stackkk.pop();
                    }
                }
            }
        }
        if (!stackkk.isEmpty()) checkk = false;
        if (checkk) System.out.println("biểu thức hợp lệ");
        else System.out.println("biểu thức không hợp lệ");

        System.out.println("----------------------------------------------------------------------------------------");

        // Map <Key, Value>
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "sang");
        map.put(1, "sondx");
        System.out.println(map); // chỉ nhận <1, "sondx">


    }
}
