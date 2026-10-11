package Lab3.task12;

import java.util.List;
import java.util.Optional;

public interface Repository<ID, T extends Identifiable<ID>> {
    void save(T entity);
    Optional<T> findById(ID id);
    List<T> findAll();
    boolean deleteById(ID id);
}
