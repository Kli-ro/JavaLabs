package Lab4.task1;

public class StackTrace {
    public static void main(String[] args) {
        methodA();
    }

    public static void methodA () {
        methodB();
        System.out.println("Первый метод");
    }

    public static void methodB () {
        methodC();
        System.out.println("Второй метод");
    }

    public static void methodC () {
        methodD();
        System.out.println("Третий метод");

    }

    public static void methodD () {
        System.out.println("Четвёртый метод");
        int num1 = 5, del = 0;
        // add ifelse for fixed error
        if (del == 0) {
            System.out.println("На ноль делить нельзя");
        } else {
            float res = num1 / del;
            System.out.println(res);
        }
    }
}
