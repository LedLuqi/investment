package com.example.investment.investment;

public class InvestmentDTO {
    private long id;
    private String name;
    private double interest;
    private long durationInDays;

    public InvestmentDTO(long id, String name, double interest, long durationInDays) {
        this.id = id;
        this.name = name;
        this.interest = interest;
        this.durationInDays = durationInDays;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getInterest() {
        return interest;
    }

    public long getDurationInDays() {
        return durationInDays;
    }
}
