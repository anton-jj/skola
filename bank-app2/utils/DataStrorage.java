package utils;

import financeManager.Transaction;

import java.io.IOException;
import java.util.ArrayList;

public interface DataStrorage<T> {
    void save(T data) throws IOException;
    T load() throws IOException;

}
