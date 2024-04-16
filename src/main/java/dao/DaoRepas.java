package dao;

import metier.Repas;

import java.util.List;

public interface DaoRepas extends Dao<Repas> {
    public Repas find(String id);
    public List<Repas> findAll();
    public boolean deleteAll();
}
