package com.kevinlam.serai.service;

import com.kevinlam.serai.entity.ReceiverEntity;
import com.kevinlam.serai.model.Feeder;
import com.kevinlam.serai.model.Receiver;
import com.kevinlam.serai.repository.ReceiverRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import java.sql.Timestamp;
import java.util.UUID;


@Service
@RequiredArgsConstructor
public class ReceiverServiceImpl implements ReceiverService {

    private static final Logger log = LoggerFactory.getLogger(ReceiverServiceImpl.class);

    private final ReceiverRepository receiverRepository;

    @Override
    public Receiver receiveFeed(Feeder feeder) {
        ReceiverEntity receiverEntity = new ReceiverEntity();
        receiverEntity.setId(UUID.randomUUID().toString());
        receiverEntity.setMessage(feeder.getMessage());
        receiverEntity.setCreateDateTime(new Timestamp(System.currentTimeMillis()));
        ReceiverEntity result = receiverRepository.saveAndFlush(receiverEntity);
        return convert(result);
    }

    private Receiver convert(ReceiverEntity receiverEntity) {
        if (receiverEntity != null) {
            return new Receiver(receiverEntity.getId(), receiverEntity.getMessage(),
                    receiverEntity.getCreateDateTime(), receiverEntity.getUpdatedDateTime());
        }
        return null;
    }
}
