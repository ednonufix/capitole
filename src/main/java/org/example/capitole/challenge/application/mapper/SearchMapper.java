package org.example.capitole.challenge.application.mapper;

import org.example.capitole.challenge.application.model.request.SearchRequest;
import org.example.capitole.challenge.application.model.response.SearchResponse;
import org.example.capitole.challenge.domain.model.Price;
import org.example.capitole.challenge.domain.model.SearchParams;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface SearchMapper {

    SearchParams map(SearchRequest searchRequest);

    @Mapping(target = "productId", source = "productEntity.id")
    @Mapping(target = "brandId", source = "brandEntity.id")
    @Mapping(target = "priceList", source = "priceList.name")
    SearchResponse map(Price price);

}
