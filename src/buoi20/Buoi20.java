package buoi20;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Collections;
import java.util.List;

public class Buoi20 {
    /*
    * Đầu tiên trong lịch sử về phát triển phần mềm
    * => ban đầu, dữ liệu được lưu trong ổ đĩa dưới dạng byte
    * VD: 5 = 101
    * => bắt đầu người ta nghĩ ra: Cách thức lưu dưới file
    * => bản chất lưu dưới file: ghi vào file là ghi từng byte một
    * Tổ chức dưới dạng file
    *
    * IO stream là một đối tượng thể hiện sự kết nối một kênh truyền thông
    * => TCP
    * => IO stream FIFO => truyền theo dạng queue
    *
    * IO => blocking : tại 1 thời điểm chỉ cho phép 1 thằng thao tác 1 file
    * NIO => non blocking
    * NIO2 : cải tiến
    *
    * cơ sở dữ liệu
    * => dữ liệu mô hình file
    * => quan hệ trong table với nhau
    *
    * */

    public static void main(String[] args) {
        String dir = System.getProperty("user.dir");
//        System.out.println(dir);

        File file = new File("ssm0419");
        // cách 1
//        FileWriter fileWriter = null;
//        try {
//            fileWriter = new FileWriter(file);
//            fileWriter.write("sang sama 04041999");
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            if (fileWriter != null) {
//                try {
//                    fileWriter.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
        // cách 2
//        try (FileWriter fileWriter = new FileWriter(file)) {
//            fileWriter.write("sang sama 04041999");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        // ==> thành công khi in ra file ssm0419

        // đọc file từng ký tự một
//        try (FileReader fileReader = new FileReader(file)) {
//            int c = 0;
//            while ((c = fileReader.read()) != -1) {
//                System.out.println((char) c);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        // đọc file từng dòng
//        try (FileReader fileReader = new FileReader(file)) {
//            BufferedReader bufferedReader = new BufferedReader(fileReader);
//            System.out.println(bufferedReader.readLine());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        // Cách vừa Writer vừa Reader
        System.out.println(file.toURI().toString().replace("file:",""));
        Path path = Paths.get(file.toURI().toString().replace("file:/",""));
        try {
            Files.write(path, Collections.singleton("truong thi sang dtvt11k62"), new StandardOpenOption[]{StandardOpenOption.WRITE});
            List<String> line = Files.readAllLines(path);
            System.out.println(line);
        } catch (IOException e) {
            e.printStackTrace();
        }



    }


}
