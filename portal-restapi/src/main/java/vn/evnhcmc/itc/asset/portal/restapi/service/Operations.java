package vn.evnhcmc.itc.asset.portal.restapi.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

/**
 *
 * @param <T> This is entity
 * @param <K> This is key of entity
 */
public interface Operations<T extends Serializable, K>{

    Optional<T> findById(K id);

    List<T> findAll();

    Page<T> findAllPaging(Pageable pageable);

    // crud

    T save(T t);

    T saveAndFlush(T t);

    void delete(T t);

    void deleteById(K id);

    List<T> saveAll(Iterable<T> lst);

    void deleteAll(Iterable<T> lst);

    @Transactional(readOnly = true)
    T findOne(K id);
}
