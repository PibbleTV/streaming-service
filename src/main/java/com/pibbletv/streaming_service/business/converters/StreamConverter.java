package com.pibbletv.streaming_service.business.converters;
import com.pibbletv.streaming_service.domain.Stream;
import com.pibbletv.streaming_service.persistance.entities.StreamEntity;

public final class StreamConverter {

    private StreamConverter() {
        throw new IllegalStateException("Stream Converter should not be instantiated");
    }

    public static Stream convertToObject(StreamEntity entity) {
        if (entity == null) return null;

        return Stream.builder()
                .id(entity.getId())
                .streamKey(entity.getStreamKey())
                .userId(entity.getUserId())
                .categoryId(entity.getCategoryId())
                .streamName(entity.getStreamName())
                .description(entity.getDescription())
                .watching(entity.getWatching())
                .startedAt(entity.getStartedAt())
                .build();
    }

    public static StreamEntity convertToEntity(Stream stream) {
        if (stream == null) return null;

        return StreamEntity.builder()
                .id(stream.getId())
                .streamKey(stream.getStreamKey())
                .userId(stream.getUserId())
                .categoryId(stream.getCategoryId())
                .streamName(stream.getStreamName())
                .description(stream.getDescription())
                .watching(stream.getWatching())
                .startedAt(stream.getStartedAt())
                .build();
    }
}