package dao;

import metier.TypeRepas;

import java.util.List;

public interface DaoTypeRepas extends Dao<TypeRepas> {
    public TypeRepas find(String id);
    public List<TypeRepas> findAll();
    public boolean deleteAll();
}
