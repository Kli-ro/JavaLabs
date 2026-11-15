package Lab9.task1;

public class SharedCounter {
    private int cnt = 0;
    public synchronized void increment() {
        cnt++;
    }
    public int getCnt() {
        return cnt;
    }
}
