package com.pibbletv.streaming_service.persistance.entities;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table("streams")
public class StreamEntity {

    @Id
    @Column("id")
    private Long id;

    @NotNull
    @Column("streamKey")
    private String streamKey;

    @NotNull
    @Column("userId")
    private String userId;

    @NotNull
    @Column("categoryId")
    private String categoryId;

    @Column("streamName")
    private String streamName;

    @Column("description")
    private String description;

    @Column("watching")
    private Integer watching;

    @Column("started_at")
    private LocalDateTime startedAt;
}