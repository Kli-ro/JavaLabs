package Lab3.task6;

public class Main {
    public static void main(String[] args) {
        Result<Integer> ok = Result.success(10);
        Result<Integer> err = Result.failure("bad");

        System.out.println(ok.map(v -> v * 2).getOrThrow());
        System.out.println(err.isSuccess());
        try {
            err.getOrThrow();
        } catch (IllegalStateException e) {
            System.out.println("threw: " + e.getMessage());
        }
    }
}
