package Lab4.task4;

public class TryCatchFinally {
    public static void main(String[] args) {
        System.out.println(testFinally());
    }
    public static int testFinally() {
        try {
            System.out.println("Блок try");
            int res = 10 / 0;
            return 1;
        } catch(Exception ex) {
            System.out.println("Ошибка перехвачена");
            return 2;
        } finally {
            System.out.println("Выполнение блока Finally");
        }
    }
}
