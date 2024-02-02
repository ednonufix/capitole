package org.example.capitole.challenge.domain.repository;

import org.example.capitole.challenge.domain.model.Price;
import org.example.capitole.challenge.domain.model.SearchParams;

import java.util.stream.Stream;

public interface PriceDetailRepository {

    Stream<Price> findPrices(SearchParams searchParams);


}
