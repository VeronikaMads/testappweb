package com.example.testapp.dao.service;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BaseJpaService <T,ID>{
    JpaRepository<T, ID> getRepository();
}
