package org.example.capitole.challenge.domain.model;

import org.example.capitole.challenge.infrastructure.outbound.database.entities.Currency;

import java.io.Serializable;
import java.time.LocalDateTime;

public record Price(Long id, LocalDateTime startDate, LocalDateTime endDate, Double price, Currency currency,
                    Integer priority, Product productEntity, Brand brandEntity, PriceList priceList) implements Serializable {
}