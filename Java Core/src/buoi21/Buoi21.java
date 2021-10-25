package buoi21;

public class Buoi21 {
    /*
    *** Thread ***
    * Thread: Luồng
    *
    * => máy tính thì cái đơn vị nhỏ nhất của máy tính là process (tiến trình), để chạy các chương trình
    * VD: gg chrome chạy trên 1 process
    *   => các chương trình trong máy tính đều chạy trên 1 process khác nhau
    * => Các process không chia sẻ dữ liệu với nhau => process nào sử dụng tài nguyên của process ấy
    * => Khởi tạo process thì rất nặng và tốn tài nguyên
    * => Thread : luồng
    *   => nó cũng là đơn vị để chạy các program (chương trình) trong máy tính
    *   => nó nhẹ hơn process
    *   => Trong 1 process thì có thể tạo ra nhiều thread
    *   => Các thread có thể chia sẻ tài nguyên với nhau (điểm lợi cũng là điểm hại)
    *       => Khi mà nhiều thread nó cùng thay đổi 1 tài nguyên => race condition
    * => Ở 1 cái máy tính, bật nhiều ứng dụng 1 lúc được, hay, khi đang nghe nhạc mà có cuộc điện thoại đến thì
    * có thể thấy tiến trình nghe nhạc và tiến trình cuộc điện thoại khác nhau
    *
    * Circle thread in java => Java Thread Life Cycle States
    * ( cần nghe lại vào đọc thêm )
    *   new : chương trình khởi tạo thread => tạo ra 1 thread mới
    *   => Thread thread = new Thread(..) => bản chất vấn đề là thread chưa chạy, vẫn đang ở trạng thái new thôi
    *   => thread.start(); => chuyển sang trạng thái runnable
    *   runnable : Trong thại thái này, thread sẽ thực thi các tác vụ của nó
    *   => có thể chuyển sang các trạng thái: waiting, timed waiting, terminated, blocked
    *   waiting :
    *   timed waiting : chờ 1 process khác
    *   terminated :
    *   blocked :
    *
    *
    * */


    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println(i);
                }
            }
        });

        // chuyển từ trạng thái new sang runnable => gọi hàm start
        thread.start();

        // Thread main chạy xong rồi nhưng Thread thread chạy ngầm bên dưới
        // Nhưng ứng dụng điện thoại dù đã tắt nhưng vẫn nhận được thông báo
        System.out.println("Kết thúc chương trình");
    }


}
