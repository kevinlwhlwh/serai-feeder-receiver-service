package com.kevinlam.serai.controller;

import com.kevinlam.serai.entity.ReceiverEntity;
import com.kevinlam.serai.model.Feeder;
import com.kevinlam.serai.model.Receiver;
import com.kevinlam.serai.repository.ReceiverRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import java.sql.Timestamp;
import java.util.UUID;

@Controller
public class ReceiverApiController implements ReceiverApi{

    private static final Logger log = LoggerFactory.getLogger(ReceiverApiController.class);

    @Autowired
    private ReceiverRepository receiverRepository;

    @Override
    public ResponseEntity<Receiver> createReceiverRecord(Feeder feeder) {
        ReceiverEntity receiverEntity = new ReceiverEntity();
        receiverEntity.setId(UUID.randomUUID().toString());
        receiverEntity.setMessage(feeder.getMessage());
        receiverEntity.setCreateDateTime(new Timestamp(System.currentTimeMillis()));
        ReceiverEntity result = receiverRepository.saveAndFlush(receiverEntity);

        Receiver receiver = new Receiver(
                result.getId(),
                result.getMessage(),
                result.getCreateDateTime(),
                result.getUpdatedDateTime());

        return new ResponseEntity<>(receiver, HttpStatus.ACCEPTED);
    }
}
