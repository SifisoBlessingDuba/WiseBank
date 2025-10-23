package za.ac.cput.wisebank.service;

public interface IService <T, ID>{
    T save(T t);
    T update(T t);
    void deleteById(ID id);
    T findById(ID id);
}
//guys check if this page will show up in the final project
//65