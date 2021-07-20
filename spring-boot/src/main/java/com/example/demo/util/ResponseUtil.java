package com.example.demo.util;

import com.example.demo.response.BaseResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class ResponseUtil {

    public ResponseEntity<Object> buildSuccessResponse(Object data){
        BaseResponse baseResponse = BaseResponse.builder()
                .success(true)
                .message(null)
                .data(data)
                .build();
        return new ResponseEntity<>(baseResponse, HttpStatus.OK);
    }

    public ResponseEntity<Object> buildCreatedResponse(Object data){
        BaseResponse baseResponse = BaseResponse.builder()
                .success(true)
                .message(null)
                .data(data)
                .build();
        return new ResponseEntity<>(baseResponse, HttpStatus.CREATED);
    }

    public ResponseEntity<Object> buildBadRequestResponse(Object data){
        BaseResponse baseResponse = BaseResponse.builder()
                .success(false)
                .message(null)
                .data(data)
                .build();
        return new ResponseEntity<>(baseResponse,HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<Object> buildInternalServerErrorResponse(Object data){
        BaseResponse baseResponse = BaseResponse.builder()
                .success(false)
                .message(null)
                .data(data)
                .build();
        return new ResponseEntity<>(baseResponse,HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
