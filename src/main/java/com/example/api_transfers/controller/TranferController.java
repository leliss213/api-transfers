package com.example.api_transfers.controller;

import com.example.api_transfers.controller.dto.TransferDTO;
import com.example.api_transfers.entity.Transfers;
import com.example.api_transfers.service.TransferService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TranferController {

    private final TransferService transferService;

    public TranferController(TransferService transferService) {
        this.transferService = transferService;
    }

    @PostMapping("/transfer")
    public ResponseEntity<Transfers> transfer(@RequestBody @Valid TransferDTO dto){
        var resp = transferService.transfer(dto);

        return ResponseEntity.ok(resp);
    }
}
