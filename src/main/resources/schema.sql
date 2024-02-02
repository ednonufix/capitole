CREATE TABLE brand
(
    id   BIGINT NOT NULL,
    name VARCHAR(255),
    CONSTRAINT pk_brand PRIMARY KEY (id)
);

CREATE TABLE product
(
    id   BIGINT NOT NULL,
    name VARCHAR(255),
    CONSTRAINT pk_product PRIMARY KEY (id)
);

CREATE TABLE price_list
(
    id   BIGINT NOT NULL,
    name VARCHAR(255),
    CONSTRAINT pk_price_list PRIMARY KEY (id)
);

CREATE TABLE price
(
    id         BIGINT                              NOT NULL,
    start_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
    end_date   TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
    price      DOUBLE PRECISION                    NOT NULL,
    curr       VARCHAR(3)                          NOT NULL,
    priority   INTEGER                             NOT NULL,
    brand_id   BIGINT                              NOT NULL,
    product_id BIGINT                              NOT NULL,
    price_list BIGINT                              NOT NULL,
    CONSTRAINT pk_price PRIMARY KEY (id)
);

ALTER TABLE price
    ADD CONSTRAINT FK_PRICE_ON_BRAND FOREIGN KEY (brand_id) REFERENCES brand (id);

ALTER TABLE price
    ADD CONSTRAINT FK_PRICE_ON_PRODUCT FOREIGN KEY (product_id) REFERENCES product (id);

ALTER TABLE price
    ADD CONSTRAINT FK_PRICE_ON_PRICE_LIST FOREIGN KEY (price_list) REFERENCES price_list (id);