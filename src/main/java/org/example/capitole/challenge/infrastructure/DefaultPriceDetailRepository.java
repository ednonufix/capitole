package org.example.capitole.challenge.infrastructure;

import lombok.AllArgsConstructor;
import org.example.capitole.challenge.domain.model.Price;
import org.example.capitole.challenge.domain.model.SearchParams;
import org.example.capitole.challenge.domain.repository.PriceDetailRepository;
import org.example.capitole.challenge.infrastructure.outbound.database.PriceRepository;
import org.example.capitole.challenge.infrastructure.outbound.database.entities.PriceEntity;
import org.example.capitole.challenge.infrastructure.outbound.database.mapper.EntitiesMapper;
import org.springframework.stereotype.Repository;

import java.util.stream.Stream;

@AllArgsConstructor
@Repository
public class DefaultPriceDetailRepository implements PriceDetailRepository {

    private final EntitiesMapper mapper;
    private final PriceRepository repository;

    @Override
    public Stream<Price> findPrices(SearchParams searchParams) {
        Stream<PriceEntity> priceEntities = repository.findByParams(searchParams.productId(), searchParams.brandId(), searchParams.date());
        return priceEntities.map(mapper::price);
    }
}
