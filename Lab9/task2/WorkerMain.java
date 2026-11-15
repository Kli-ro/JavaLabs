package Lab9.task2;

public class WorkerMain {
    public static void main(String[] args) throws InterruptedException {
        Worker worker = new Worker();
        Thread thread = new Thread(worker);
        thread.start();

        Thread.sleep(1000);
        worker.stop();
        thread.join();
        System.out.println("Main finished");
    }
}
