package org.example.utils;

public interface DataStorage<T> {

    void save(T data) ;
    T load();
}
