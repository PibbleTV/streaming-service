//package com.pibbletv.streaming_service.unit;
//
//import com.pibbletv.streaming_service.business.implementations.StreamServiceImpl;
//import com.pibbletv.streaming_service.domain.Stream;
//import com.pibbletv.streaming_service.persistance.entities.StreamEntity;
//import com.pibbletv.streaming_service.persistance.repository.StreamRepository;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import reactor.core.publisher.Flux;
//import reactor.core.publisher.Mono;
//import reactor.test.StepVerifier;
//
//import java.time.LocalDateTime;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.mockito.Mockito.*;
//
//@ExtendWith(org.mockito.junit.jupiter.MockitoExtension.class)
//public class StreamingServiceImplTest {
//
//    @Mock
//    private StreamRepository streamRepository;
//
//    @InjectMocks
//    private StreamServiceImpl streamService;
//
//    private StreamEntity buildStreamEntity(Long id) {
//        return new StreamEntity(
//                id, 101L, 999L, "Cool Stream", "Gaming time!",
//                1L, 5, LocalDateTime.now()
//        );
//    }
//
//    @Test
//    void testGetStreamsPerKeyword_FoundSuccessfully() {
//        StreamEntity entity = buildStreamEntity(1L);
//        when(streamRepository.findByKeyword("Cool")).thenReturn(Flux.just(entity));
//
//        StepVerifier.create(streamService.getStreamsPerKeyword("Cool"))
//                .assertNext(stream -> {
//                    assertEquals(1L, stream.getId());
//                    assertEquals("Cool Stream", stream.getStreamName());
//                })
//                .verifyComplete();
//    }
//
//    @Test
//    void testGetStreamsPerKeyword_NotFound() {
//        when(streamRepository.findByKeyword("Unknown")).thenReturn(Flux.empty());
//
//        StepVerifier.create(streamService.getStreamsPerKeyword("Unknown"))
//                .expectNextCount(0)
//                .verifyComplete();
//    }
//
//    @Test
//    void testGetStreamsPerCategory_ReturnedSuccessfully() {
//        StreamEntity entity = buildStreamEntity(2L);
//        when(streamRepository.findByCategoryId(1L)).thenReturn(Flux.just(entity));
//
//        StepVerifier.create(streamService.getStreamsPerCategory(1L))
//                .assertNext(stream -> {
//                    assertEquals(2L, stream.getId());
//                    assertEquals(1L, stream.getCategoryId());
//                })
//                .verifyComplete();
//    }
//
//    @Test
//    void testGetStream_ReturnedSuccessfully() {
//        StreamEntity entity = buildStreamEntity(3L);
//        when(streamRepository.findById(3L)).thenReturn(Mono.just(entity));
//
//        StepVerifier.create(streamService.getStream(3L))
//                .assertNext(stream -> {
//                    assertEquals(3L, stream.getId());
//                    assertEquals("Cool Stream", stream.getStreamName());
//                })
//                .verifyComplete();
//    }
//
//    @Test
//    void testGetStream_NotFound() {
//        when(streamRepository.findById(999L)).thenReturn(Mono.empty());
//
//        StepVerifier.create(streamService.getStream(999L))
//                .expectNextCount(0)
//                .verifyComplete();
//    }
//
//    @Test
//    void testGetAllStreams_StreamsObtainedSuccessfully() {
//        StreamEntity s1 = buildStreamEntity(1L);
//        StreamEntity s2 = buildStreamEntity(2L);
//
//        when(streamRepository.findAll()).thenReturn(Flux.just(s1, s2));
//
//        StepVerifier.create(streamService.getAllStreams())
//                .expectNextCount(2)
//                .verifyComplete();
//    }
//
//    @Test
//    void testAddStream_SuccessfullyAddingStream() {
//        Stream stream = new Stream(10L, 101L, 202L, "Fun Stream", "Chill vibes", 1L, 12, LocalDateTime.now());
//
//        when(streamRepository.save(any())).thenReturn(Mono.just(new StreamEntity()));
//
//        StepVerifier.create(streamService.addStream(stream))
//                .verifyComplete();
//    }
//
//    @Test
//    void testAddStream_SaveFails() {
//        Stream stream = new Stream(11L, 101L, 202L, "Failed Stream", "desc", 1L, 0, LocalDateTime.now());
//
//        when(streamRepository.save(any())).thenReturn(Mono.error(new RuntimeException("DB save failed")));
//
//        StepVerifier.create(streamService.addStream(stream))
//                .expectErrorMessage("DB save failed")
//                .verify();
//    }
//
//    @Test
//    void testUpdateStream_SuccessfullyUpdated() {
//        Stream stream = new Stream(12L, 101L, 202L, "Updated Stream", "desc", 1L, 10, LocalDateTime.now());
//
//        when(streamRepository.existsById(12L)).thenReturn(Mono.just(true));
//        when(streamRepository.save(any())).thenReturn(Mono.just(new StreamEntity()));
//
//        StepVerifier.create(streamService.updateStream(stream))
//                .verifyComplete();
//    }
//
//    @Test
//    void testUpdateStream_MissingId() {
//        Stream stream = new Stream(null, 101L, 202L, "No ID", "desc", 1L, 10, LocalDateTime.now());
//
//        StepVerifier.create(streamService.updateStream(stream))
//                .expectErrorMatches(err -> err instanceof IllegalArgumentException &&
//                        err.getMessage().equals("Cannot update stream without ID"))
//                .verify();
//    }
//
//    @Test
//    void testUpdateStream_DoesNotExist() {
//        Stream stream = new Stream(13L, 101L, 202L, "Ghost Stream", "desc", 1L, 0, LocalDateTime.now());
//
//        when(streamRepository.existsById(13L)).thenReturn(Mono.just(false));
//
//        StepVerifier.create(streamService.updateStream(stream))
//                .expectErrorMatches(err -> err instanceof IllegalArgumentException &&
//                        err.getMessage().equals("Stream does not exist"))
//                .verify();
//    }
//
//}
