package utils;



import java.io.IOException;


public interface DataStrorage<T> {
    void save(T data) throws IOException;
    T load() throws IOException;

}
