package com.pibbletv.streaming_service.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Stream {

    private Long id;

    private Long userId;

    private Long streamKey;

    private String streamName;

    private String description;

    private Long categoryId;

    private Integer watching;

    private LocalDateTime startedAt;
}
