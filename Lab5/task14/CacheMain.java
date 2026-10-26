package Lab3.task14;

public class CacheMain {
    public static void main(String[] args) {
        LRUCache<String, String> cache = new LRUCache<>(3);
        cache.put("Java", "Java course");
        cache.put("Python", "Python course");
        cache.put("Go", "Go course");

        cache.get("Java");

        cache.put("C", "C course");

        System.out.println(cache.keys());
        System.out.println(cache.get("Python"));
        System.out.println(cache.get("Java"));
        System.out.println(cache.get("Go"));
        System.out.println(cache.get("C"));
    }
}
