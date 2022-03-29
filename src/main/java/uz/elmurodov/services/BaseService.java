package uz.elmurodov.services;

import uz.elmurodov.dtos.GenericBaseDto;
import uz.elmurodov.dtos.GenericDto;
import uz.elmurodov.repository.BaseRepository;
import uz.elmurodov.response.Data;
import uz.elmurodov.response.ResponseEntity;

import java.io.Serializable;


/**
 * @param <R> -> Repository
 */
public abstract class BaseService<R extends BaseRepository,
        CR extends GenericBaseDto,
        D extends GenericDto,
        UD extends GenericDto ,
        K extends Serializable> {
    protected R repository;

    protected BaseService() {
    }

    public BaseService(R repository) {
        this.repository = repository;
    }

    public abstract ResponseEntity<Data<?>> create(CR dto);
    public abstract ResponseEntity<Data<?>> update(UD dto);
    public abstract ResponseEntity<D> get(K id);

}
