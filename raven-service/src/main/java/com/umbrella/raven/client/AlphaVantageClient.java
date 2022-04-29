package com.umbrella.raven.client;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

@Component
public class AlphaVantageClient {

    RestTemplate restTemplate;
    HttpHeaders headers;
    MultiValueMap<String, String> params;

    public AlphaVantageClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
        this.headers = new HttpHeaders();
        this.headers.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
        this.params = new LinkedMultiValueMap<>() {{
            put("apiKey", Collections.singletonList(
                    System.getenv("ALPHA_VANTAGE_API_KEY")
            ));
        }};
    }
}
