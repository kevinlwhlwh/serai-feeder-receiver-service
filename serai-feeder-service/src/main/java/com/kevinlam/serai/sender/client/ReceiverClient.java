package com.kevinlam.serai.sender.client;

import com.kevinlam.serai.sender.config.BasicAuthInterceptor;
import com.kevinlam.serai.sender.model.Feeder;
import com.kevinlam.serai.sender.model.Receiver;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "serai-receiver-service", url = "${serai.receiver.url}",
        path = "/receiver", configuration = BasicAuthInterceptor.class
)
public interface ReceiverClient {
    @RequestMapping(method = RequestMethod.POST, value = "/receive", produces = "application/json")
    Receiver createReceiverRecord(Feeder feeder);

}
