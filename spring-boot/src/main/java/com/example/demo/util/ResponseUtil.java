package com.example.demo.util;

import com.example.demo.response.BaseResponse;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class ResponseUtil {

    public ResponseEntity<Object> buildSuccessResponse(Object data) {
        BaseResponse baseResponse = BaseResponse.builder()
                .success(true)
                .message(null)
                .data(data)
                .build();
        return new ResponseEntity<>(baseResponse, HttpStatus.OK);
    }

    public ResponseEntity<Object> buildSuccessResponse(String data) throws ParseException {
        BaseResponse baseResponse = BaseResponse.builder()
                .success(true)
                .message(null)
                .data(toData(data))
                .build();
        return new ResponseEntity<>(baseResponse, HttpStatus.OK);
    }

    public ResponseEntity<Object> buildCreatedResponse(Object data) {
        BaseResponse baseResponse = BaseResponse.builder()
                .success(true)
                .message(null)
                .data(data)
                .build();
        return new ResponseEntity<>(baseResponse, HttpStatus.CREATED);
    }

    public ResponseEntity<Object> buildCreatedResponse(String data) throws ParseException {
        BaseResponse baseResponse = BaseResponse.builder()
                .success(true)
                .message(null)
                .data(toData(data))
                .build();
        return new ResponseEntity<>(baseResponse, HttpStatus.CREATED);
    }

    public ResponseEntity<Object> buildBadRequestResponse(Object data) {
        BaseResponse baseResponse = BaseResponse.builder()
                .success(false)
                .message(null)
                .data(data)
                .build();
        return new ResponseEntity<>(baseResponse, HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<Object> buildBadRequestResponse(String data) throws ParseException {
        BaseResponse baseResponse = BaseResponse.builder()
                .success(false)
                .message(null)
                .data(toData(data))
                .build();
        return new ResponseEntity<>(baseResponse, HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<Object> buildInternalServerErrorResponse(Object data) {
        BaseResponse baseResponse = BaseResponse.builder()
                .success(false)
                .message(null)
                .data(data)
                .build();
        return new ResponseEntity<>(baseResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    private Object toJson(String data) throws ParseException {
        Object obj = new JSONParser().parse(data);
        return obj;
    }

    private Object toData(String data) throws ParseException {

        if (isValidJSON(data)) {
            return toJson(data);
        }
        return data;
    }

    private boolean isValidJSON(String json) throws ParseException {
        try {
            Object obj = new JSONParser().parse(json);
            return true;
        } catch (ParseException exception) {
            return false;
        }
    }
}
