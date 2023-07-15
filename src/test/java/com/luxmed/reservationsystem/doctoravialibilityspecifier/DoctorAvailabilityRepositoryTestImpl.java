package com.luxmed.reservationsystem.doctoravialibilityspecifier;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class DoctorAvailabilityRepositoryTestImpl implements DoctorAvailabilityRepository {

    Map<Integer,VisitEntity> repository = new ConcurrentHashMap<>();

    @Override
    public <S extends VisitEntity> List<S> saveAll(Iterable<S> entities) {
        Stream<S> stream = StreamSupport.stream(entities.spliterator(), false);
        List<S> list = stream.toList();
        entities.forEach(entity -> entity.setVisitId(UUID.randomUUID().hashCode()));
        entities.forEach(entity -> repository.put(entity.getVisitId(),entity));
        return list;
    }

    @Override
    public List<VisitEntity> findAll() {
        return repository.values().stream().toList();
    }

    @Override
    public Optional<VisitEntity> findByVisitDate(LocalDate visitDate) {
        return Optional.empty();
    }

    @Override
    public Optional<VisitEntity> findByBeginningOfVisit(LocalTime beginningOfVisit) {
        return Optional.empty();
    }

    @Override
    public Optional<VisitEntity> findByEndOfVisit(LocalTime endOfVisit) {
        return Optional.empty();
    }

    @Override
    public <S extends VisitEntity> boolean exists(Example<S> example) {
        S probe = example.getProbe();
        return repository.containsValue(probe);
    }

    @Override
    public <S extends VisitEntity> Optional<S> findOne(Example<S> example) {
    return null;
    }


    @Override
    public void flush() {

    }

    @Override
    public <S extends VisitEntity> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends VisitEntity> List<S> saveAllAndFlush(Iterable<S> entities) {
        return null;
    }

    @Override
    public void deleteAllInBatch(Iterable<VisitEntity> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Integer> integers) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public VisitEntity getOne(Integer integer) {
        return null;
    }

    @Override
    public VisitEntity getById(Integer integer) {
        return null;
    }

    @Override
    public VisitEntity getReferenceById(Integer integer) {
        return null;
    }


    @Override
    public <S extends VisitEntity> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends VisitEntity> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends VisitEntity> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends VisitEntity> long count(Example<S> example) {
        return 0;
    }



    @Override
    public <S extends VisitEntity, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }

    @Override
    public <S extends VisitEntity> S save(S entity) {
        return null;
    }

    @Override
    public Optional<VisitEntity> findById(Integer integer) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Integer integer) {
        return false;
    }


    @Override
    public List<VisitEntity> findAllById(Iterable<Integer> integers) {
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
    public void delete(VisitEntity entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Integer> integers) {

    }

    @Override
    public void deleteAll(Iterable<? extends VisitEntity> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public List<VisitEntity> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<VisitEntity> findAll(Pageable pageable) {
        return null;
    }



}
