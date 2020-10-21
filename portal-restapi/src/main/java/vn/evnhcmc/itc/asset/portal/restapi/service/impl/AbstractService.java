package vn.evnhcmc.itc.asset.portal.restapi.service.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;
import vn.evnhcmc.itc.asset.portal.restapi.common.exception.ResourceNotFoundException;
import vn.evnhcmc.itc.asset.portal.restapi.service.Operations;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

@Transactional
public abstract class AbstractService <T extends Serializable, K> implements Operations<T, K> {

    protected JpaRepository<T, K> repository;

    public AbstractService(JpaRepository<T, K> repository) {
        this.repository = repository;
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<T> findById(final K id) {
        return repository.findById(id);
    }

    @Override
    public List<T> findAll() {
        return repository.findAll();
    }

    @Override
    public Page<T> findAllPaging(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public T save(T t) {
        return repository.save(t);
    }

    @Override
    public T saveAndFlush(T t) {
        return repository.saveAndFlush(t);
    }

    @Override
    public void delete(T t) {
        repository.delete(t);
    }

    @Override
    public void deleteById(K id) {
        repository.deleteById(id);
    }

    @Override
    public List<T> saveAll(Iterable<T> lst) {
        return repository.saveAll(lst);
    }

    @Override
    public void deleteAll(Iterable<T> lst) {
        repository.deleteAll(lst);
    }

    @Override
    public T findOne(K id) {
        return repository.findById(id).orElseThrow(ResourceNotFoundException::new);
    }
}
