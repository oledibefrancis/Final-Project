package com.company.gamestore.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.Objects;
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "fee")
public class Fee {

    @NotEmpty(message = "You must provide a value for product type.")
    @Size(max = 50, message = "You must provide a value less than 50 characters")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String productType;
    @Column(precision = 8, scale = 2)
    private BigDecimal fee;

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public BigDecimal getFee() {
        return fee;
    }

    public void setFee(BigDecimal fee) {
        this.fee = fee;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Fee fee1 = (Fee) o;
        return Objects.equals(productType, fee1.productType) && Objects.equals(fee, fee1.fee);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productType, fee);
    }

    @Override
    public String toString() {
        return "Fee{" +
                "productType='" + productType + '\'' +
                ", fee=" + fee +
                '}';
    }
}
