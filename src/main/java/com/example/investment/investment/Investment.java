package com.example.investment.investment;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Investment {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private Double interest;
    @Enumerated(EnumType.STRING)
    private CapitalizationPeriod capitalizationPeriod;
    private LocalDate dateOfStart;
    private LocalDate dateOfEnd;

    public Investment(String name, Double interest, CapitalizationPeriod capitalizationPeriod, LocalDate dateOfStart, LocalDate dateOfEnd) {
        this.name = name;
        this.interest = interest;
        this.capitalizationPeriod = capitalizationPeriod;
        this.dateOfStart = dateOfStart;
        this.dateOfEnd = dateOfEnd;
    }


    public String getName() {
        return name;
    }

    public Double getInterest() {
        return interest;
    }

    public CapitalizationPeriod getCapitalizationPeriod() {
        return capitalizationPeriod;
    }

    public LocalDate getDateOfStart() {
        return dateOfStart;
    }

    public LocalDate getDateOfEnd() {
        return dateOfEnd;
    }

    public Long getId() {
        return id;
    }
}
