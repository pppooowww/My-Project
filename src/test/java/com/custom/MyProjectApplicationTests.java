package com.custom;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

@SpringBootTest
class MyProjectApplicationTests {

    @Test
    void contextLoads() {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://api.odcloud.kr/api/15109950/v1/uddi:1f78fe49-78b4-4784-a5f0-e2c8a60515b4?page=2&perPage=10&serviceKey=WX/qIsVj4inhHOXPUgOGfxI7MQh1LIHyhfli2ch1DGUWsG37xoDDh724K5F05MzVG2OQJuigRzUq63r/nTMfRg==";
        ResponseEntity<Map> response = restTemplate.getForEntity(url, Map.class);
        Map resultMap = response.getBody();
        List dataList = (List) resultMap.get("data");
        for (Object data : dataList) {
            Map d = (Map) data;
            String 가맹점명 = (String) d.get("가맹점명");
            System.out.println(가맹점명);
        }
    }

}