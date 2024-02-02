package org.example.capitole.challenge.application.model.request;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public record SearchRequest(@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss") LocalDateTime date,
                            Long productId, Long brandId) {
}
