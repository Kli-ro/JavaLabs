package Lab3.task13;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class InvertedIndex {
    private final Map<String, Set<String>> tagToCourses = new HashMap<>();
    private final Map<String, Set<String>> courseToTags = new HashMap<>();

    public void addCourse(String courseId, Set<String> tags) {
        Objects.requireNonNull(courseId, "courseId");
        Objects.requireNonNull(tags, "tags");

        removeCourse(courseId);

        Set<String> nonEmptyTags = new HashSet<>(tags);
        nonEmptyTags.remove(null);
        if (nonEmptyTags.isEmpty()) {
            return;
        }

        courseToTags.put(courseId, nonEmptyTags);
        for (String tag : nonEmptyTags) {
            tagToCourses.computeIfAbsent(tag, t -> new HashSet<>()).add(courseId);
        }
    }
    public void removeCourse(String courseId) {
        Set<String> oldTags = courseToTags.remove(courseId);
        if (oldTags == null) {
            return;
        }
        for (String tag : oldTags) {
            Set<String> courses = tagToCourses.get(tag);
            if (courses != null) {
                courses.remove(courseId);
                if (courses.isEmpty()) {
                    tagToCourses.remove(tag);
                }
            }
        }
    }

    public Set<String> coursesByTag(String tag) {
        return Collections.unmodifiableSet(
                tagToCourses.getOrDefault(tag, Collections.emptySet())
        );
    }

    public Set<String> tagsOf(String courseId) {
        return Collections.unmodifiableSet(
                courseToTags.getOrDefault(courseId, Collections.emptySet())
        );
    }
    public Set<String> coursesByAllTags(Set<String> tags) {
        if (tags == null || tags.isEmpty()) {
            return Collections.emptySet();
        }
        Set<String> result = null;
        for (String tag : tags) {
            Set<String> courses = tagToCourses.getOrDefault(tag, Collections.emptySet());
            if (result == null) {
                result = new HashSet<>(courses);
            } else {
                result.retainAll(courses);
            }
            if (result.isEmpty()) {
                return Collections.emptySet();
            }
        }
        return result;
    }
}
