package com.example.api_transfers.service;

import com.example.api_transfers.cliente.NotificationClient;
import com.example.api_transfers.entity.Transfers;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class NotificationService {

    private final NotificationClient notificationClient;

    public NotificationService(NotificationClient notificationClient) {
        this.notificationClient = notificationClient;
    }

    public void sendNotification(Transfers transfers){
        try{
            var resp = notificationClient.sendNotification(transfers);

            if(resp.getStatusCode().isError()){
                log.error("error while sending notification, status code not okay {}", resp);
            }

        } catch (Exception e){
            log.error("error while sending notification {}", e);
        }
    }
}
