package com.kevinlam.serai.service;

import com.kevinlam.serai.model.Feeder;
import com.kevinlam.serai.model.Receiver;

public interface ReceiverService {
    Receiver receiveFeed(Feeder feeder);
}
