package com.company.gamestore.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.persistence.Column;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "tax")

public class Tax  implements Serializable {

    @NotEmpty(message = "You must supply a value for state.")
    @Size(min = 2, max = 2, message = "You must supply the two letter abbreviation.")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String state;
    @Column(precision = 8, scale = 2)
    private BigDecimal rate;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public BigDecimal getRate() {
        return rate;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tax tax = (Tax) o;
        return Objects.equals(state, tax.state) && Objects.equals(rate, tax.rate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(state, rate);
    }

    @Override
    public String toString() {
        return "Tax{" +
                "state='" + state + '\'' +
                ", rate=" + rate +
                '}';
    }
}
