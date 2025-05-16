package com.pibbletv.streaming_service.domain;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.relational.core.mapping.Column;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Stream {

    private Long id;

    private UUID streamKey;

    private UUID userId;

    private UUID categoryId;

    private String streamName;

    private String description;

    private Integer watching;

    private LocalDateTime startedAt;
}
