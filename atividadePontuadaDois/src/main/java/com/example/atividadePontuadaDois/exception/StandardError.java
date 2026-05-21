package com.example.atividadePontuadaDois.exception;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serial;
import java.io.Serializable;
import java.time.Instant;

public record StandardError(
        @JsonFormat (shape = JsonFormat.Shape.STRING, pattern = "'Data:' dd-MM-yyyy' / Hora: 'HH:mm:ss", timezone = "UTC")
        Instant timestamp,
        Integer status,
        String error,
        String message,
        String path
) implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
}