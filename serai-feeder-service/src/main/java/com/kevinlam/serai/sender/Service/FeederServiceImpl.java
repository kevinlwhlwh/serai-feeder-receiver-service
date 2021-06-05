package com.kevinlam.serai.sender.Service;

import com.kevinlam.serai.sender.client.ReceiverClient;
import com.kevinlam.serai.sender.config.UnexpectedDataInputDataException;
import com.kevinlam.serai.sender.model.Feeder;
import com.kevinlam.serai.sender.model.Receiver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;


@Service
public class FeederServiceImpl implements FeederService{

    private static final Logger log = LoggerFactory.getLogger(FeederServiceImpl.class);

    @Autowired
    ReceiverClient receiverClient;

    @Override
    public Receiver sendFeeder(Feeder feeder) {
        validateFeeder(feeder);
        Receiver receiver = receiverClient.createReceiverRecord(feeder);
        return receiver;
    }

    private void validateFeeder(Feeder feeder){
        if(feeder == null) throw new UnexpectedDataInputDataException("feeder body not found");
        if(feeder.getMessage() == null) throw new UnexpectedDataInputDataException("feeder message is null");
        if(feeder.getMessage().compareTo(BigDecimal.ZERO) < 0 ) throw new UnexpectedDataInputDataException("feeder message is negative amount");
    }
}
