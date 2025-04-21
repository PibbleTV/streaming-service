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
                .userId(entity.getUserId())
                .streamKey(entity.getStreamKey())
                .streamName(entity.getStreamName())
                .description(entity.getDescription())
                .categoryId(entity.getCategoryId())
                .watching(entity.getWatching())
                .startedAt(entity.getStartedAt())
                .build();
    }

    public static StreamEntity convertToEntity(Stream stream) {
        if (stream == null) return null;

        return StreamEntity.builder()
                .id(stream.getId())
                .userId(stream.getUserId())
                .streamKey(stream.getStreamKey())
                .streamName(stream.getStreamName())
                .description(stream.getDescription())
                .categoryId(stream.getCategoryId())
                .watching(stream.getWatching())
                .startedAt(stream.getStartedAt())
                .build();
    }
}