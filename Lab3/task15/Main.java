package Lab3.task15;

public class Main {
    public static void main(String[] args) {
        CourseGraph graph = new CourseGraph();
        graph.addPrerequisite("Java", "C");
        graph.addPrerequisite("Spring", "Java");
        graph.addPrerequisite("Spring Boot", "Spring");

        System.out.println(graph.topologicalOrder());

        CourseGraph cyclic = new CourseGraph();
        cyclic.addPrerequisite("A", "B");
        cyclic.addPrerequisite("B", "C");
        cyclic.addPrerequisite("C", "A");

        try {
            cyclic.topologicalOrder();
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }
    }
}