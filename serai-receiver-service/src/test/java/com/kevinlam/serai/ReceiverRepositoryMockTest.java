package com.kevinlam.serai;

import com.kevinlam.serai.entity.ReceiverEntity;
import com.kevinlam.serai.model.Feeder;
import com.kevinlam.serai.model.Receiver;
import com.kevinlam.serai.repository.ReceiverRepository;
import com.kevinlam.serai.service.ReceiverService;
import com.kevinlam.serai.service.ReceiverServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.math.BigDecimal;
import java.sql.Timestamp;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ReceiverRepositoryMockTest {

    @Mock
    public ReceiverRepository receiverRepository;

    @InjectMocks
    private ReceiverService receiverService;

    @BeforeEach
    void setMockOutput() {
        receiverRepository = mock(ReceiverRepository.class);
        receiverService = new ReceiverServiceImpl(receiverRepository);
        ReceiverEntity receiverEntity = new ReceiverEntity();
        receiverEntity.setId("ABCD-123-XXXX");
        receiverEntity.setMessage(BigDecimal.TEN);
        receiverEntity.setCreateDateTime(new Timestamp(System.currentTimeMillis()));
        when(receiverRepository.saveAndFlush(any()))
                .thenReturn(receiverEntity);
    }

    @DisplayName("Test Mock receiverService + receiverRepository")
    @Test
    void testSaveAndFlush() {

        Feeder feeder = new Feeder();
        feeder.setMessage(BigDecimal.TEN);
        Receiver receiver = receiverService.receiveFeed(feeder);
        assertEquals("ABCD-123-XXXX", receiver.getId());
        assertEquals(BigDecimal.TEN, receiver.getMessage());
    }
}
