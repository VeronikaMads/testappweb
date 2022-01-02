package com.example.testapp.dao.service.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@ConditionalOnProperty(name = "spring.data.jpa.repositories.enabled", havingValue = "true")
@Retention(RetentionPolicy.RUNTIME)
@Service
public @interface JpaImplementation {
}
