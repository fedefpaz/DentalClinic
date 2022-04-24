package ProyectoFinal.DentalClinic.Service;

import java.util.Set;

public interface ICRUDService<T> {

    T findById(Long id);

    T create(T t);

    void deleteById(Long id);

    T update(T t);

    Set<T> findAll();

}
