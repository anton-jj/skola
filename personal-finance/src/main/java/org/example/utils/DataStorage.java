package org.example.utils;

import org.example.user.Account;

import java.util.Map;

public interface DataStorage<T> {

    void save(T data) ;

    T load();
}
