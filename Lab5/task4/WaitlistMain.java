package Lab3.task4;

import java.util.ArrayDeque;
import java.util.NoSuchElementException;
import java.util.Queue;

public class WaitlistMain {
    public static void main(String[] args) {
        Queue<String> waitlist = new ArrayDeque<>();
        waitlist.add("Java");
        waitlist.offer("Python");
        waitlist.offer("Go");

        System.out.println("peek: " + waitlist.peek());
        System.out.println("element: " + waitlist.element());

        System.out.println("poll: " + waitlist.poll());
        System.out.println("remove: " + waitlist.remove());

        System.out.println("peek after: " + waitlist.peek());

        waitlist.clear();
        System.out.println("peek empty: " + waitlist.peek());
        try {
            waitlist.element();
        } catch (NoSuchElementException e) {
            System.out.println("element threw NoSuchElementException");
        }
        System.out.println("poll empty: " + waitlist.poll());
        try {
            waitlist.remove();
        } catch (NoSuchElementException e) {
            System.out.println("remove threw NoSuchElementException");
        }
    }
}