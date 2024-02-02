package org.example.capitole.challenge.infrastructure.inbound.controllers;

import lombok.RequiredArgsConstructor;
import org.example.capitole.challenge.application.PriceDetailUseCase;
import org.example.capitole.challenge.application.model.request.SearchRequest;
import org.example.capitole.challenge.application.model.response.SearchResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class PriceController {

    private final PriceDetailUseCase priceDetailUseCase;

    @PostMapping("/price_detail")
    public ResponseEntity<SearchResponse> priceDetail(@RequestBody SearchRequest searchRequest) {
        SearchResponse responses = priceDetailUseCase.findPriceDetail(searchRequest);
        return ResponseEntity.ok(responses);
    }

}
