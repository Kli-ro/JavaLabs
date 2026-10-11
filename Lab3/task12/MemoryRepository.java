package Lab3.task12;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

public class MemoryRepository<ID, T extends Identifiable<ID>> implements Repository<ID, T> {
    private final Map<ID, T> storage = new LinkedHashMap<>();

    @Override
    public void save(T entity) {
        Objects.requireNonNull(entity, "entity");
        storage.put(entity.getId(), entity);
    }

    @Override
    public Optional<T> findById(ID id) {
        Objects.requireNonNull(id, "id");
        return Optional.ofNullable(storage.get(id));
    }

    @Override
    public List<T> findAll() {
        return new ArrayList<>(storage.values());
    }
    @Override
    public boolean deleteById(ID id) {
        Objects.requireNonNull(id, "id");
        return storage.remove(id) != null;
    }
}
