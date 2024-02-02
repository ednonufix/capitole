package org.example.capitole.challenge.domain.model;

import java.io.Serializable;

public record Product(Long id, String name) implements Serializable {
}