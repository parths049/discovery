package com.discovery.repository;

import org.springframework.data.repository.CrudRepository;
import com.discovery.model.Tags;

public interface TagsRepository extends CrudRepository<Tags, Long> {

}
