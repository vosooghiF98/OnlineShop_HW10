package org.maktab.Base;

import org.maktab.Repository.CartRepository;
import org.maktab.Repository.Impl.CartRepositoryImpl;

import java.sql.SQLException;

public abstract class BaseService<T> {
    private BaseRepository<T> repository;

    public BaseService(BaseRepository<T> repository) {
        this.repository = repository;
    }

    public void create(T entity) throws SQLException {
        repository.create(entity);
    }
    public T read(T entity) throws SQLException {
        return repository.read(entity);
    }
    public void update(T entity, int id) throws SQLException {
        repository.update(entity,id);
    }
    public void delete(T entity) throws SQLException {
        repository.delete(entity);
    }

    public BaseRepository<T> getRepository() {
        return repository;
    }
}
