package org.example.capitole.challenge.application.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public record SearchResponse(Long productId, Long brandId, String startDate, String endDate, Double price,
                             @JsonProperty("price_list_name") String priceList) {
}
