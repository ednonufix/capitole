package org.example.capitole.challenge.infrastructure.outbound.database;

import jakarta.persistence.QueryHint;
import org.example.capitole.challenge.infrastructure.outbound.database.entities.PriceEntity;
import org.hibernate.jpa.HibernateHints;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.stream.Stream;

@Repository
public interface PriceRepository extends JpaRepository<PriceEntity, Long> {

    @QueryHints(@QueryHint(name = HibernateHints.HINT_FETCH_SIZE, value = "25"))
    @Query(value = "select * from price " +
        "where :date between start_date and end_date " +
        "and product_id = :productId " +
        "and brand_id = :brandId ;", nativeQuery = true)
    Stream<PriceEntity> findByParams(Long productId, Long brandId, LocalDateTime date);

}
