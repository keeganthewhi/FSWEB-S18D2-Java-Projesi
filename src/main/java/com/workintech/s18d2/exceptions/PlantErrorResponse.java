package com.workintech.s18d2.exceptions;

import lombok.AllArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
public class PlantErrorResponse {
    private Integer status;
    private String message;
    private LocalDateTime dateTime;

}
