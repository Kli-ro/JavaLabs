package Lab3.task8;

import java.util.List;
public class Main {
    public static void main(String[] args) {
        System.out.println(MaxUtil.max(List.of(1, 5, 3)));
        System.out.println(MaxUtil.max(List.of("Java", "Python", "Go")));
        System.out.println(MaxUtil.max(List.of(new OwnValue(1), new OwnValue(10), new OwnValue(5))));
    }
}