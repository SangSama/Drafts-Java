package buoi18;

public class ExceptionDemo {

    public void demo(String xxx) throws RuntimeException {
//        try {
//            System.out.println(xxx.isEmpty());
//        } catch (NullPointerException e) {
//            e.printStackTrace();
//        }
        if (xxx == null) {
            throw new RuntimeException("Run rồi bạn ơi");
        }
        System.out.println(xxx.isEmpty());
    }
}
