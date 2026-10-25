package Lab7.task3;

public class Pipeline {
    public static void main(String[] args) {
        try(FailReader fileRead = new FailReader();
            FailWriter fileWrite = new FailWriter()){

            fileRead.readerData();
            fileWrite.writerData();

            // выброс исключения в консоль

            throw new RuntimeException("Сбой в середине pipeline");
        } catch (Exception ex) {
            System.out.println("Сбой перехвачен: " + ex.getMessage());
        }
    }
}
