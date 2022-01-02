package com.example.testapp.dao.service;

import java.util.Collection;

public interface CrudService<D, ID> {
//    Нам необходимо добавлять новых сотрудников, удалять уволенных, обновлять
//    данные о сотрудниках, а также должна быть возможность просмотреть весь список сотрудников сразу и отдельно получить
//    каждого сотрудника

    void save(D entity);

    void delete(ID id);

    D update(ID id, D entity);

    Collection<D> findAll();

    D findById(ID id);
}