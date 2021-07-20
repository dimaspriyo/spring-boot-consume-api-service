package com.example.demo.controller;

import com.example.demo.util.ResponseUtil;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping(value = "/data/car")
public class DataCarController {

    @Autowired
    ResponseUtil responseUtil;

    private CloseableHttpClient httpClient = HttpClients.createDefault();

    private String baseUrl = "http://api-service:8081/mysql/car";

    @GetMapping()
    public ResponseEntity<Object> getAll() throws IOException, ParseException {
        HttpGet httpRequest = new HttpGet(baseUrl);
        httpRequest.setHeader("Content-type", "application/json");
        httpRequest.setHeader("accept", "application/json");

        CloseableHttpResponse httpResponse = httpClient.execute(httpRequest);

        String responseBody = EntityUtils.toString(httpResponse.getEntity());
        return responseUtil.buildSuccessResponse(responseBody);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getById(@PathVariable("id") String id) throws IOException, ParseException {
        HttpGet httpRequest = new HttpGet(baseUrl + "/" + id);
        httpRequest.setHeader("Content-type", "application/json");
        httpRequest.setHeader("accept", "application/json");

        CloseableHttpResponse httpResponse = httpClient.execute(httpRequest);

        String responseBody = EntityUtils.toString(httpResponse.getEntity());
        return responseUtil.buildSuccessResponse(responseBody);
    }


}
