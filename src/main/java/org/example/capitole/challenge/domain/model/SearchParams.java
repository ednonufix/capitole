package org.example.capitole.challenge.domain.model;

import java.time.LocalDateTime;

public record SearchParams(LocalDateTime date, Long productId, Long brandId) {
}
