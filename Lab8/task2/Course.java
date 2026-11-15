package task2;

import java.util.List;

public class Course {
    private final String name;
    private final List<Module> modules;

    public Course(String name, List<Module> modules) {
        this.name = name;
        this.modules = modules;
    }

    public String getName() { return name; }
    public List<Module> getModules() { return modules; }
}