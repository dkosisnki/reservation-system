package com.luxmed.reservationsystem.visitnoteadder;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;

import java.util.*;
import java.util.function.Function;

public class VisitNoteRepositoryTestImpl implements VisitNoteRepository{

    Map<Integer, VisitNoteEntity> repository = new HashMap<>();


    @Override
    public <S extends VisitNoteEntity> S save(S entity) {
        entity.setVisitNoteId(UUID.randomUUID().hashCode());
        repository.put(entity.getVisitNoteId(),entity);
        return entity;
    }

    @Override
    public Optional<VisitNoteEntity> findById(Integer id) {
        return Optional.ofNullable(repository.get(id));
    }

    @Override
    public void flush() {

    }

    @Override
    public <S extends VisitNoteEntity> boolean exists(Example<S> example) {
        return false;
    }
    @Override
    public <S extends VisitNoteEntity> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends VisitNoteEntity> List<S> saveAllAndFlush(Iterable<S> entities) {
        return null;
    }

    @Override
    public void deleteAllInBatch(Iterable<VisitNoteEntity> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Integer> integers) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public VisitNoteEntity getOne(Integer integer) {
        return null;
    }

    @Override
    public VisitNoteEntity getById(Integer integer) {
        return null;
    }

    @Override
    public VisitNoteEntity getReferenceById(Integer integer) {
        return null;
    }

    @Override
    public <S extends VisitNoteEntity> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends VisitNoteEntity> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends VisitNoteEntity> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends VisitNoteEntity> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends VisitNoteEntity> long count(Example<S> example) {
        return 0;
    }



    @Override
    public <S extends VisitNoteEntity, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }



    @Override
    public <S extends VisitNoteEntity> List<S> saveAll(Iterable<S> entities) {
        return null;
    }



    @Override
    public boolean existsById(Integer integer) {
        return false;
    }

    @Override
    public List<VisitNoteEntity> findAll() {
        return null;
    }

    @Override
    public List<VisitNoteEntity> findAllById(Iterable<Integer> integers) {
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
    public void delete(VisitNoteEntity entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Integer> integers) {

    }

    @Override
    public void deleteAll(Iterable<? extends VisitNoteEntity> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public List<VisitNoteEntity> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<VisitNoteEntity> findAll(Pageable pageable) {
        return null;
    }
}
