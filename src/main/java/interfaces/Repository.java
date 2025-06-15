package interfaces;
import java.util.List;
public interface Repository <T>{
    T findById(int id);
    List<T> findAll();
    int save(T t ,boolean Log);
    int update(T t ,int id,boolean Log);
    int delete(int id,boolean Log);
    int delete(boolean Log, int... id);
}
