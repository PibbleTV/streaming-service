package com.pibbletv.streaming_service.persistance.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table("streams")
public class StreamEntity {

    @Id
    private Long id;

    @Column("userId")
    private Long userId;

    @Column("streamKey")
    private Long streamKey;

    @Column("streamName")
    private String streamName;

    @Column("description")
    private String description;

    @Column("categoryId")
    private Long categoryId;

    @Column("watching")
    private Integer watching;

    @Column("started_at")
    private LocalDateTime startedAt;
}