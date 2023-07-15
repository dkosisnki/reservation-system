package com.luxmed.reservationsystem.patientregister;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;

public class PatientRegisterRepositoryTestImpl implements PatientRepository {

    final Map<String, PatientEntity> repository = new ConcurrentHashMap<>();

    @Override
    public <S extends PatientEntity> S save(S entity) {
        repository.put(entity.getEmail(), entity);
        return entity;
    }
    @Override
    public void flush() {

    }

    @Override
    public <S extends PatientEntity> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends PatientEntity> List<S> saveAllAndFlush(Iterable<S> entities) {
        return null;
    }

    @Override
    public void deleteAllInBatch(Iterable<PatientEntity> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Integer> integers) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public PatientEntity getOne(Integer integer) {
        return null;
    }

    @Override
    public PatientEntity getById(Integer integer) {
        return null;
    }

    @Override
    public PatientEntity getReferenceById(Integer integer) {
        return null;
    }

    @Override
    public <S extends PatientEntity> Optional<S> findOne(Example<S>  example) {
        return Optional.empty();
    }

    @Override
    public <S extends PatientEntity> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends PatientEntity> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends PatientEntity> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends PatientEntity> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends PatientEntity> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends PatientEntity, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }

    @Override
    public <S extends PatientEntity> List<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<PatientEntity> findById(Integer integer) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Integer integer) {
        return false;
    }

    @Override
    public List<PatientEntity> findAll() {
        return null;
    }

    @Override
    public List<PatientEntity> findAllById(Iterable<Integer> integers) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Integer integer) {

    }

    @Override
    public void delete(PatientEntity entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Integer> integers) {

    }

    @Override
    public void deleteAll(Iterable<? extends PatientEntity> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public List<PatientEntity> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<PatientEntity> findAll(Pageable pageable) {
        return null;
    }
}
