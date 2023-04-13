package com.alten.products.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "products")
@EntityListeners(AuditingEntityListener.class)
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@JsonIgnoreProperties(value = {"createdAt"}, allowGetters = true)
public class Products implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String code;

    private String name;

    @Nullable
    private String description;

    @Nullable
    private Float price;

    @Nullable
    private Integer quantity;

    @Nullable
    private String inventoryStatus;

    @Nullable
    private String category;

    @Nullable
    private String image;

    @Nullable
    private Integer rating;


    @Column(nullable = false, updatable = false)
    @Temporal(TemporalType.DATE)
    @CreatedDate
    private Date createdAt;



}
