package com.example.site1.common;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
public class ResponseDTO<T> {
    
    private Integer code;
    private String message;
    private T data;
}
