package mat.dev.generics;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryRepository<T, ID> {

	/* Simulando meu banco */
	private Map<ID, T> banco = new HashMap<>();

	public void save(ID id, T entity) {
		banco.put(id, entity);
	}

	public T findById(ID id) {
		return banco.get(id);
	}

	public List<T> findAll() {
		return banco.values().stream().toList();
	}

	public void delete(ID id) {
		banco.remove(id);
	}

}
