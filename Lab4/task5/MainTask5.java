package Lab4.task5;

public class MainTask5 {
    public static void main(String[] args) {
        //success test
//        try (TestAutoCloseable fail = new TestAutoCloseable()) {
//            System.out.println("Выполняется блок try");
//        }

        // fail test
        try {
            try(TestAutoCloseable fail = new TestAutoCloseable()) {
                throw new RuntimeException("Ошибка");
            }

        } catch (Exception e) {
            System.out.println("Основная ошибка: " + e.getMessage());
            System.out.println("Подавленная ошибка: " + e.getSuppressed()[0].getMessage());
        }
    }
}
