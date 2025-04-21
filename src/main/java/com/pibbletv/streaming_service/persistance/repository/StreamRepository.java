package com.pibbletv.streaming_service.persistance.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import com.pibbletv.streaming_service.persistance.entities.StreamEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface StreamRepository extends ReactiveCrudRepository<StreamEntity, Long> {
}
