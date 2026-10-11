package Lab3.task11;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class Choice {
    public static void main(String[] args) {
        Map<Integer, String> catalog = new HashMap<>();
        catalog.put(1, "Java");
        catalog.put(2, "Python");
        catalog.put(3, "Go");

        TreeSet<Integer> leaderboard = new TreeSet<>();
        leaderboard.add(100);
        leaderboard.add(250);
        leaderboard.add(75);

        Deque<String> queue = new ArrayDeque<>();
        queue.offer("Java");
        queue.offer("Python");

        Set<String> uniqueTags = new LinkedHashSet<>();
        uniqueTags.add("backend");
        uniqueTags.add("ml");
        uniqueTags.add("backend");

        TreeMap<Integer, String> rangeIndex = new TreeMap<>();
        rangeIndex.put(10, "C");
        rangeIndex.put(20, "Java");
        rangeIndex.put(30, "Python");

        Map<Integer, String> frequentAccess = new HashMap<>();
        frequentAccess.put(1, "Java");
        frequentAccess.put(2, "Python");
    }
}