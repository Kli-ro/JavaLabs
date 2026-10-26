package Lab3.task12;

public class RepositoryMain {
    public static void main(String[] args) {
        Repository<Integer, Student> repo = new MemoryRepository<>();
        repo.save(new Student(1, "Alice"));
        repo.save(new Student(2, "Bob"));
        repo.save(new Student(1, "Alice v2"));

        System.out.println(repo.findById(1));
        System.out.println(repo.findById(3));
        System.out.println(repo.findAll());
        System.out.println(repo.deleteById(2));
        System.out.println(repo.findAll());
    }
}
