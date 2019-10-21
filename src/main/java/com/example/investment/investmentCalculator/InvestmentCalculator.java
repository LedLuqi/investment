package com.example.investment.investmentCalculator;

import com.example.investment.investment.Investment;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Entity
public class InvestmentCalculator {

    @Id
    @GeneratedValue
    private Long id;

    private Integer amount;
    private LocalDate calculationDate;
    @ManyToOne
    @JoinColumn(name = "DETAILS_ID")
    private Investment investment;

    public InvestmentCalculator(Integer amount, LocalDate calculationDate, Investment investment) {
        this.amount = amount;
        this.calculationDate = calculationDate;
        this.investment = investment;
    }

    public InvestmentCalculator(Integer amount, Investment investment) {
        this.amount = amount;
        this.investment = investment;
    }

    public Double calculateInterest() {

        Integer validation = null;

        switch (investment.getCapitalizationPeriod()) {
            case ONE_MONTH:
                validation = 12;
                break;
            case THREE_MONTH:
                validation = 4;
                break;
            case SIX_MONTH:
                validation = 2;
                break;
            case ELEVEN_MONTH:
                validation = 1;
        }

        int quantityOfValidation;
        int days;

        if (calculationDate != null) {
            days = (int) ChronoUnit.DAYS.between(investment.getDateOfStart(), this.calculationDate);
        } else days = (int) ChronoUnit.DAYS.between(investment.getDateOfStart(), investment.getDateOfEnd());

        quantityOfValidation = (days / 360) * validation;

        return (((Math.pow((1 + (1 * (investment.getInterest() / quantityOfValidation)) / 100), quantityOfValidation)) - 1) * 100);

    }

    public Double calculateProfit() {
        return (calculateInterest() / 100) * amount;
    }

    public Investment getInvestment() {
        return investment;
    }

    public void setInvestment(Investment investment) {
        this.investment = investment;
    }
}
