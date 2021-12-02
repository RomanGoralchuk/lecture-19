package by.itacademy.javaenterprise.goralchuk.dao;

import by.itacademy.javaenterprise.goralchuk.entity.first.WindInstrument;

import java.util.List;

public interface Dao<T> {
    T find(Long id);

    T save(T t);

    T update(T t);

    long delete(Long id);

    List<T> findAll();
}
