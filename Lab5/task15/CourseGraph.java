package Lab3.task15;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CourseGraph {
    private final Map<String, Set<String>> adjacency = new HashMap<>();

    public void addCourse(String course) {
        adjacency.computeIfAbsent(course, c -> new LinkedHashSet<>());
    }

    public void addPrerequisite(String course, String prerequisite) {
        addCourse(course);
        addCourse(prerequisite);
        adjacency.get(course).add(prerequisite);
    }

    public List<String> topologicalOrder() {
        Map<String, Integer> indegree = new HashMap<>();
        for (String course : adjacency.keySet()) {
            indegree.put(course, 0);
        }
        for (Set<String> deps : adjacency.values()) {
            for (String dep : deps) {
                indegree.merge(dep, 1, Integer::sum);
            }
        }

        Deque<String> queue = new ArrayDeque<>();
        for (Map.Entry<String, Integer> e : indegree.entrySet()) {
            if (e.getValue() == 0) {
                queue.add(e.getKey());
            }
        }

        List<String> order = new ArrayList<>();
        while (!queue.isEmpty()) {
            String course = queue.poll();
            order.add(course);
            for (String next : adjacency.getOrDefault(course, Collections.emptySet())) {
                int newDegree = indegree.merge(next, -1, Integer::sum);
                if (newDegree == 0) {
                    queue.add(next);
                }
            }
        }

        if (order.size() != adjacency.size()) {
            throw new IllegalStateException("cycle detected: " + findCycle());
        }
        return order;
    }

    public List<String> findCycle() {
        Set<String> visited = new HashSet<>();
        Set<String> stack = new LinkedHashSet<>();
        for (String course : adjacency.keySet()) {
            List<String> cycle = dfs(course, visited, stack);
            if (cycle != null) {
                return cycle;
            }
        }
        return Collections.emptyList();
    }

    private List<String> dfs(String course, Set<String> visited, Set<String> stack) {
        if (stack.contains(course)) {
            List<String> cycle = new ArrayList<>(stack);
            cycle.add(course);
            return cycle;
        }
        if (!visited.add(course)) {
            return null;
        }
        stack.add(course);
        for (String next : adjacency.getOrDefault(course, Collections.emptySet())) {
            List<String> cycle = dfs(next, visited, stack);
            if (cycle != null) {
                return cycle;
            }
        }
        stack.remove(course);
        return null;
    }
}
