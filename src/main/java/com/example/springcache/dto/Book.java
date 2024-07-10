package com.example.springcache.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Book implements Serializable {
    @Id
            @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Integer bookId;
    String bookName;
    String bookCategory;
    String bookAuthor;
    String bookPublisher;
    String bookEdition;

}
