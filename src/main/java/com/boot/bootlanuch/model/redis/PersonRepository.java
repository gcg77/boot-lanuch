package com.boot.bootlanuch.model.redis;

import org.springframework.data.repository.CrudRepository;

/**
 * @author Administrator
 */
public interface PersonRepository extends CrudRepository<People,String> {
}
