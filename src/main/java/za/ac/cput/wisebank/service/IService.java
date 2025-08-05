package za.ac.cput.wisebank.service;

public interface IService <T, ID>{
    T save(T t);
    T update(T t);
    void deleteById(ID id);
    T findById(ID id);
}
