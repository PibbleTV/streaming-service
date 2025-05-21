package com.pibbletv.streaming_service.domain;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.relational.core.mapping.Column;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Stream {

    private Long id;

    private String streamKey;

    private String userId;

    private String categoryId;

    private String streamName;

    private String description;

    private Integer watching;

    private LocalDateTime startedAt;
}
