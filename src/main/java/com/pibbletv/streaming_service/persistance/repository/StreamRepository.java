package com.pibbletv.streaming_service.persistance.repository;

import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import com.pibbletv.streaming_service.persistance.entities.StreamEntity;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface StreamRepository extends ReactiveCrudRepository<StreamEntity, Long> {

    @Query("SELECT * FROM streams WHERE LOWER(stream_name) LIKE LOWER(CONCAT('%', :keyword, '%')) OR LOWER(description) LIKE LOWER(CONCAT('%', :keyword, '%'))")
    Flux<StreamEntity> findByKeyword(@Param("keyword") String keyword);

    Flux<StreamEntity> findByCategoryId(Long categoryId);
}
