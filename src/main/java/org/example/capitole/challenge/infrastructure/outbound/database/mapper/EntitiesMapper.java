package org.example.capitole.challenge.infrastructure.outbound.database.mapper;

import org.example.capitole.challenge.domain.model.Brand;
import org.example.capitole.challenge.domain.model.Price;
import org.example.capitole.challenge.domain.model.PriceList;
import org.example.capitole.challenge.domain.model.Product;
import org.example.capitole.challenge.infrastructure.outbound.database.entities.BrandEntity;
import org.example.capitole.challenge.infrastructure.outbound.database.entities.PriceEntity;
import org.example.capitole.challenge.infrastructure.outbound.database.entities.PriceListEntity;
import org.example.capitole.challenge.infrastructure.outbound.database.entities.ProductEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EntitiesMapper {

    Price price(PriceEntity priceEntity);

    Brand brand(BrandEntity brandEntity);

    Product product(ProductEntity productEntity);

    PriceList priceList(PriceListEntity priceListEntity);

}
