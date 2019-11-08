package com.example.investment.investment;

import java.time.LocalDate;

public class InvestmentRequest {

    private String name;
    private double interest;
    private CapitalizationPeriod capitalizationPeriod;
    private LocalDate dateOfStart;
    private LocalDate dateOfEnd;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getInterest() {
        return interest;
    }

    public void setInterest(double interest) {
        this.interest = interest;
    }

    public CapitalizationPeriod getCapitalizationPeriod() {
        return capitalizationPeriod;
    }

    public void setCapitalizationPeriod(CapitalizationPeriod capitalizationPeriod) {
        this.capitalizationPeriod = capitalizationPeriod;
    }

    public LocalDate getDateOfStart() {
        return dateOfStart;
    }

    public void setDateOfStart(LocalDate dateOfStart) {
        this.dateOfStart = dateOfStart;
    }

    public LocalDate getDateOfEnd() {
        return dateOfEnd;
    }

    public void setDateOfEnd(LocalDate dateOfEnd) {
        this.dateOfEnd = dateOfEnd;
    }

}
