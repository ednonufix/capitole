package org.example.capitole.challenge.application;

import org.example.capitole.challenge.application.mapper.SearchMapper;
import org.example.capitole.challenge.application.model.request.SearchRequest;
import org.example.capitole.challenge.application.model.response.SearchResponse;
import org.example.capitole.challenge.domain.model.Price;
import org.example.capitole.challenge.domain.model.SearchParams;
import org.example.capitole.challenge.domain.repository.PriceDetailRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Comparator;

@Service
public class PriceDetailUseCase {

    private final Comparator<Price> pricePriorityComparator;
    private final SearchMapper mapper;
    private final PriceDetailRepository priceDetailRepository;

    public PriceDetailUseCase(SearchMapper mapper, PriceDetailRepository priceDetailRepository) {
        this.mapper = mapper;
        this.priceDetailRepository = priceDetailRepository;
        this.pricePriorityComparator = Comparator.comparing(Price::priority);
    }

    @Transactional(readOnly = true)
    public SearchResponse findPriceDetail(SearchRequest searchRequest) {
        SearchParams searchParams = mapper.map(searchRequest);
        return priceDetailRepository.findPrices(searchParams)
            .max(pricePriorityComparator)
            .map(mapper::map)
            .orElse(null);
    }

}
