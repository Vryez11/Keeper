package com.keeper.keeperapp.store.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/client")
public class ClientInfoController {

    @PostMapping("/info")
    public ResponseEntity<String> saveClientInfo(@RequestBody Map<String, Object> info) {
        System.out.println("클라이언트 정보: " + info);
        return ResponseEntity.ok("저장 완료");
    }
}
