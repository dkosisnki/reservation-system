package com.luxmed.reservationsystem.doctorregister;

import com.luxmed.reservationsystem.patientregister.PatientEntity;
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

public class DoctorRegisterRepositoryTestImpl implements DoctorRepository{

    final Map<String, DoctorEntity> repository = new ConcurrentHashMap<>();

    @Override
    public <S extends DoctorEntity> S save(S entity) {
        repository.put(entity.getEmail(),entity);
        return entity;
    }

    @Override
    public Optional<DoctorEntity> findByMedicalLicense(String license) {
        return Optional.ofNullable(repository.get(license));
    }

    @Override
    public void flush() {

    }

    @Override
    public <S extends DoctorEntity> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends DoctorEntity> List<S> saveAllAndFlush(Iterable<S> entities) {
        return null;
    }

    @Override
    public void deleteAllInBatch(Iterable<DoctorEntity> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Integer> integers) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public DoctorEntity getOne(Integer integer) {
        return null;
    }

    @Override
    public DoctorEntity getById(Integer integer) {
        return null;
    }

    @Override
    public DoctorEntity getReferenceById(Integer integer) {
        return null;
    }

    @Override
    public <S extends DoctorEntity> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends DoctorEntity> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends DoctorEntity> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends DoctorEntity> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends DoctorEntity> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends DoctorEntity> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends DoctorEntity, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }

    @Override
    public <S extends DoctorEntity> List<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<DoctorEntity> findById(Integer integer) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Integer integer) {
        return false;
    }

    @Override
    public List<DoctorEntity> findAll() {
        return null;
    }

    @Override
    public List<DoctorEntity> findAllById(Iterable<Integer> integers) {
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
    public void delete(DoctorEntity entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Integer> integers) {

    }

    @Override
    public void deleteAll(Iterable<? extends DoctorEntity> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public List<DoctorEntity> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<DoctorEntity> findAll(Pageable pageable) {
        return null;
    }


}
