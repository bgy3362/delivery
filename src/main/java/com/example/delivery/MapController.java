package com.example.delivery;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/server")
public class MapController {
    @Value("${naver.client-id}")
    private String NAVER_API_ID;

    @Value("${naver.secret}")
    private String NAVER_API_SECRET;


}
