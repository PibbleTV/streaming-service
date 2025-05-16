//package com.pibbletv.streaming_service.integration;
//
//import com.pibbletv.streaming_service.business.converters.StreamConverter;
//import com.pibbletv.streaming_service.business.implementations.StreamServiceImpl;
//import com.pibbletv.streaming_service.domain.Stream;
//import com.pibbletv.streaming_service.persistance.entities.StreamEntity;
//import com.pibbletv.streaming_service.persistance.repository.StreamRepository;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.reactive.server.WebTestClient;
//import reactor.core.publisher.Flux;
//import reactor.core.publisher.Mono;
//
//import java.time.LocalDateTime;
//
//import static org.mockito.Mockito.when;
//
//@SpringBootTest
//@AutoConfigureWebTestClient
//public class StreamingControllerTest {
//
//    @Autowired
//    private WebTestClient webTestClient;
//
//    @InjectMocks
//    private StreamServiceImpl streamService;
//
//    @Mock
//    private StreamRepository streamRepository;
//
//    @Test
//    void getStreamsPerKeyword_shouldReturnStreams_whenKeywordIsValid() {
//        String keyword = "gaming";
//        StreamEntity streamEntity1 = StreamEntity.builder()
//                .id(1L)
//                .userId(1L)
//                .streamKey(123L)
//                .streamName("Stream1")
//                .description("Description1")
//                .categoryId(1L)
//                .watching(10)
//                .startedAt(LocalDateTime.now())
//                .build();
//        StreamEntity streamEntity2 = StreamEntity.builder()
//                .id(2L)
//                .userId(2L)
//                .streamKey(124L)
//                .streamName("Stream2")
//                .description("Description2")
//                .categoryId(1L)
//                .watching(5)
//                .startedAt(LocalDateTime.now())
//                .build();
//
//        when(streamRepository.findByKeyword(keyword)).thenReturn(Flux.just(streamEntity1, streamEntity2));
//        when(streamService.getStreamsPerKeyword(keyword)).thenReturn(Flux.just(StreamConverter.convertToObject(streamEntity1),StreamConverter.convertToObject(streamEntity2)));
//
//        webTestClient.get()
//                .uri(uriBuilder -> uriBuilder
//                        .path("stream/getPerKeyword")
//                        .queryParam("keyword", keyword)
//                        .build())
//                .exchange()
//                .expectStatus().isOk()
//                .expectHeader().contentTypeCompatibleWith(MediaType.APPLICATION_JSON)
//                .expectBodyList(Stream.class);
//    }
//
//    @Test
//    void getStreamsPerKeyword_shouldReturnEmptyList_whenNoStreamsMatchKeyword() {
//        String keyword = "nonexistent";
//
//        when(streamRepository.findByKeyword(keyword)).thenReturn(Flux.empty());
//        when(streamService.getStreamsPerKeyword(keyword)).thenReturn(Flux.empty());
//
//        webTestClient.get()
//                .uri(uriBuilder -> uriBuilder
//                        .path("stream/getPerKeyword")
//                        .queryParam("keyword", keyword)
//                        .build())
//                .exchange()
//                .expectStatus().isOk()
//                .expectHeader().contentTypeCompatibleWith(MediaType.APPLICATION_JSON)
//                .expectBodyList(Stream.class)
//                .hasSize(0);
//    }
//
//    @Test
//    void getStreamsPerCategory_shouldReturnStreams_whenCategoryIdIsValid() {
//        Long categoryId = 1L;
//        StreamEntity streamEntity1 = StreamEntity.builder()
//                .id(1L)
//                .userId(1L)
//                .streamKey(123L)
//                .streamName("Stream1")
//                .description("Description1")
//                .categoryId(categoryId)
//                .watching(10)
//                .startedAt(LocalDateTime.now())
//                .build();
//        StreamEntity streamEntity2 = StreamEntity.builder()
//                .id(2L)
//                .userId(2L)
//                .streamKey(124L)
//                .streamName("Stream2")
//                .description("Description2")
//                .categoryId(categoryId)
//                .watching(5)
//                .startedAt(LocalDateTime.now())
//                .build();
//
//        when(streamRepository.findByCategoryId(categoryId)).thenReturn(Flux.just(streamEntity1, streamEntity2));
//        when(streamService.getStreamsPerCategory(categoryId)).thenReturn(Flux.just(StreamConverter.convertToObject(streamEntity1),StreamConverter.convertToObject(streamEntity2)));
//
//        webTestClient.get()
//                .uri(uriBuilder -> uriBuilder
//                        .path("stream/getPerCategory")
//                        .queryParam("categoryId", categoryId)
//                        .build())
//                .exchange()
//                .expectStatus().isOk()
//                .expectHeader().contentTypeCompatibleWith(MediaType.APPLICATION_JSON)
//                .expectBodyList(Stream.class);
//    }
//
//
//    @Test
//    void getStreamsPerCategory_shouldReturnEmptyList_whenNoStreamsMatchCategory() {
//        Long categoryId = 999L;
//
//        when(streamRepository.findByCategoryId(categoryId)).thenReturn(Flux.empty());
//        when(streamService.getStreamsPerCategory(categoryId)).thenReturn(Flux.empty());
//
//        webTestClient.get()
//                .uri(uriBuilder -> uriBuilder
//                        .path("stream/getPerCategory")
//                        .queryParam("categoryId", categoryId)
//                        .build())
//                .exchange()
//                .expectStatus().isOk()
//                .expectHeader().contentTypeCompatibleWith(MediaType.APPLICATION_JSON)
//                .expectBodyList(Stream.class)
//                .hasSize(0);
//    }
//
//    @Test
//    void getStream_shouldReturnStream_whenStreamIdIsValid() {
//        Long streamId = 1L;
//        StreamEntity streamEntity = StreamEntity.builder()
//                .id(streamId)
//                .userId(1L)
//                .streamKey(123L)
//                .streamName("Stream1")
//                .description("Description1")
//                .categoryId(1L)
//                .watching(10)
//                .startedAt(LocalDateTime.now())
//                .build();
//
//        Stream stream = StreamConverter.convertToObject(streamEntity);
//
//        when(streamRepository.findById(streamId)).thenReturn(Mono.just(streamEntity));
//        when(streamService.getStream(streamId)).thenReturn(Mono.just(stream));
//
//        webTestClient.get()
//                .uri(uriBuilder -> uriBuilder
//                        .path("stream/getStream")
//                        .queryParam("streamId", streamId)
//                        .build())
//                .exchange()
//                .expectStatus().isOk()
//                .expectHeader().contentTypeCompatibleWith(MediaType.APPLICATION_JSON)
//                .expectBody(Stream.class)
//                .isEqualTo(StreamConverter.convertToObject(streamEntity));
//    }
//
//    @Test
//    void getStream_shouldReturn404_whenStreamDoesNotExist() {
//        Long streamId = 999L;
//
//        when(streamRepository.findById(streamId)).thenReturn(Mono.empty());
//        when(streamService.getStream(streamId)).thenReturn(Mono.empty());
//
//
//        webTestClient.get()
//                .uri(uriBuilder -> uriBuilder
//                        .path("stream/getStream")
//                        .queryParam("streamId", streamId)
//                        .build())
//                .exchange()
//                .expectStatus().isNotFound();
//    }
//
//    @Test
//    void getAllStreams_shouldReturnStreams_whenStreamsExist() {
//        StreamEntity streamEntity1 = StreamEntity.builder()
//                .id(1L)
//                .userId(1L)
//                .streamKey(123L)
//                .streamName("Stream1")
//                .description("Description1")
//                .categoryId(1L)
//                .watching(10)
//                .startedAt(LocalDateTime.now())
//                .build();
//        StreamEntity streamEntity2 = StreamEntity.builder()
//                .id(2L)
//                .userId(2L)
//                .streamKey(124L)
//                .streamName("Stream2")
//                .description("Description2")
//                .categoryId(2L)
//                .watching(5)
//                .startedAt(LocalDateTime.now())
//                .build();
//
//        when(streamRepository.findAll()).thenReturn(Flux.just(streamEntity1, streamEntity2));
//        when(streamService.getAllStreams()).thenReturn(Flux.just(StreamConverter.convertToObject(streamEntity1),StreamConverter.convertToObject(streamEntity2)));
//
//        webTestClient.get()
//                .uri("stream/getAll")
//                .exchange()
//                .expectStatus().isOk()
//                .expectHeader().contentTypeCompatibleWith(MediaType.APPLICATION_JSON)
//                .expectBodyList(Stream.class);
//    }
//
//    @Test
//    void getAllStreams_shouldReturnEmptyList_whenNoStreamsExist() {
//        when(streamRepository.findAll()).thenReturn(Flux.empty());
//        when(streamService.getAllStreams()).thenReturn(Flux.empty());
//
//        webTestClient.get()
//                .uri("stream/getAll")
//                .exchange()
//                .expectStatus().isOk()
//                .expectHeader().contentTypeCompatibleWith(MediaType.APPLICATION_JSON)
//                .expectBodyList(Stream.class)
//                .hasSize(0);
//    }
//
//    @Test
//    void addStream_shouldReturn200_whenStreamIsAdded() {
//        StreamEntity streamEntity = StreamEntity.builder()
//                .id(1L)
//                .userId(1L)
//                .streamKey(123L)
//                .streamName("NewStream")
//                .description("Description")
//                .categoryId(1L)
//                .watching(0)
//                .startedAt(LocalDateTime.now())
//                .build();
//
//        Stream stream = StreamConverter.convertToObject(streamEntity);
//
//        when(streamRepository.save(streamEntity)).thenReturn(Mono.empty());
//        when(streamService.addStream(stream)).thenReturn(Mono.empty());
//
//        webTestClient.post()
//                .uri("stream/addStream")
//                .contentType(MediaType.APPLICATION_JSON)
//                .bodyValue(StreamConverter.convertToObject(streamEntity))
//                .exchange()
//                .expectStatus().isOk();
//    }
//
//    @Test
//    void addStream_shouldReturn400_whenStreamDataIsInvalid() {
//        StreamEntity streamEntity = StreamEntity.builder().build();
//
//        webTestClient.post()
//                .uri("stream/addStream")
//                .contentType(MediaType.APPLICATION_JSON)
//                .bodyValue(StreamConverter.convertToObject(streamEntity))
//                .exchange()
//                .expectStatus().isBadRequest();
//    }
//
//    @Test
//    void updateStream_shouldReturn200_whenStreamIsUpdated() {
//        StreamEntity streamEntity = StreamEntity.builder()
//                .id(1L)
//                .userId(1L)
//                .streamKey(123L)
//                .streamName("UpdatedStream")
//                .description("Updated Description")
//                .categoryId(1L)
//                .watching(20)
//                .startedAt(LocalDateTime.now())
//                .build();
//
//        Stream stream = StreamConverter.convertToObject(streamEntity);
//
//        when(streamRepository.existsById(1L)).thenReturn(Mono.just(true));
//        when(streamRepository.save(streamEntity)).thenReturn(Mono.empty());
//        when(streamService.updateStream(stream)).thenReturn(Mono.empty());
//
//        webTestClient.put()
//                .uri("stream/updateStream")
//                .contentType(MediaType.APPLICATION_JSON)
//                .bodyValue(StreamConverter.convertToObject(streamEntity))
//                .exchange()
//                .expectStatus().isOk();
//    }
//
//
//    @Test
//    void updateStream_shouldReturn400_whenStreamIdIsNull() {
//        StreamEntity streamEntity = StreamEntity.builder()
//                .streamName("UpdatedStream")
//                .description("Updated Description")
//                .categoryId(1L)
//                .watching(20)
//                .startedAt(LocalDateTime.now())
//                .build();
//
//        Stream stream = StreamConverter.convertToObject(streamEntity);
//
//        when(streamService.updateStream(stream)).thenReturn(Mono.error(new IllegalArgumentException("Cannot update stream without ID")));
//
//
//        webTestClient.put()
//                .uri("/stream/updateStream")
//                .contentType(MediaType.APPLICATION_JSON)
//                .bodyValue(stream)
//                .exchange()
//                .expectStatus().isBadRequest();
//    }
//}
