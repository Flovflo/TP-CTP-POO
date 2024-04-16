package dao;

import metier.Symptome;

import java.util.List;

public interface DaoSymptome extends Dao<Symptome> {
    public Symptome find(String id);
    public List<Symptome> findAll();
    public boolean deleteAll();
}
