package dao;

import java.util.List;

public interface Dao<T> {
    public T create(T obj);
    public T find(Class<T> c, String id);
    public List<T> findAll(Class<T> c);
    public T update(T obj);
    public boolean delete(T obj);
    public boolean deleteAll(Class<T> c);
    public void close();
}
