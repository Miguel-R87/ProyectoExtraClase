
package co.edu.co.extraclase.data.dao;
import java.util.List;

public interface RetrieveDAO<E, ID> {
    List<E> findByFilter(E filterEntity);
    E findById(ID id);
}