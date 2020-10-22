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

    protected JpaRepository<T, K> _repository;

    public AbstractService(JpaRepository<T, K> repository) {
        _repository = repository;
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<T> findById(final K id) {
        return _repository.findById(id);
    }

    @Override
    public List<T> findAll() {
        return _repository.findAll();
    }

    @Override
    public Page<T> findAllPaging(Pageable pageable) {
        return _repository.findAll(pageable);
    }

    @Override
    public T save(T t) {
        return _repository.save(t);
    }

    @Override
    public T saveAndFlush(T t) {
        return _repository.saveAndFlush(t);
    }

    @Override
    public void delete(T t) {
        _repository.delete(t);
    }

    @Override
    public void deleteById(K id) {
        _repository.deleteById(id);
    }

    @Override
    public List<T> saveAll(Iterable<T> lst) {
        return _repository.saveAll(lst);
    }

    @Override
    public void deleteAll(Iterable<T> lst) {
        _repository.deleteAll(lst);
    }

    @Override
    public T findOne(K id) {
        return _repository.findById(id).orElseThrow(ResourceNotFoundException::new);
    }
}
