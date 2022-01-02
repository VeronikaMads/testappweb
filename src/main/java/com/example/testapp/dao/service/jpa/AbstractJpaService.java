package com.example.testapp.dao.service.jpa;

import com.example.testapp.dao.service.BaseJpaService;
import com.example.testapp.dao.service.CrudService;
import com.example.testapp.entity.BaseEntity;

import java.util.Collection;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public abstract class AbstractJpaService <D, T extends BaseEntity<ID>, ID> implements CrudService<D, ID>, BaseJpaService<T, ID> {
    @Override
    public D findById(ID id) {
        return getRepository().findById(id).map(this::mapToDto)
                .orElseThrow(()-> new NoSuchElementException("not found"));
    }

    @Override
    public void save(D dto) {
        getRepository().save(mapToEntity(dto));
    }

    @Override
    public Collection<D> findAll() {
        return getRepository().findAll().stream().map(this::mapToDto).collect(Collectors.toList());
    }

    @Override
    public void delete(ID id) {
        getRepository().deleteById(id);
    }

    @Override
    public D update(ID id, D dto) {
        return null;
    }

    public abstract D mapToDto (T entity);
    public abstract T mapToEntity(D dto);
}
