package Lab3.task12;

public class Student implements Identifiable<Integer>{
    private final Integer id;
    private final String name;

    public Student(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public String toString() {
        return id + ":" + name;
    }
}
