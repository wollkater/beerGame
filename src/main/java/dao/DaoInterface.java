package dao;

import java.util.List;

/**
 * Created by marcel on 19.10.17.
 */
public interface DaoInterface<T> {
	T findOne(int id);
	T save(T entity);
	void delete(T entity);
	List<T> getAll();
}
