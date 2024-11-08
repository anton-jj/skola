package utils;

import java.io.IOException;

public interface DataStorage<T> {
    void save(T data) throws IOException;
    T load() throws IOException;

}
