package com.example.investment.investmentInfo;

import com.example.investment.investment.Investment;
import com.example.investment.investmentCalculator.InvestmentCalculator;
import com.example.investment.ivestmentReopsitories.InvestmentCalculatorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class InvestmentCalculationInfo {

    InvestmentCalculatorRepository investmentCalculatorRepository;

    List<InvestmentCalculator> investmentCalculatorList;

    InvestmentCalculator investmentCalculator;

    Investment investment;

    Double profit;

    String algorithm;

    @Autowired
    public InvestmentCalculationInfo(InvestmentCalculatorRepository investmentCalculatorRepository) {
        this.investmentCalculatorRepository = investmentCalculatorRepository;
    }

    public Investment getInvestment() {
        return investment;
    }

    public void setInvestment(Investment investment) {
        this.investment = investment;
    }

    public void update() {
        investmentCalculatorList = investmentCalculatorRepository.findAll();
    }

    public void setInvestmentCalculator(InvestmentCalculator investmentCalculator) {
        this.investmentCalculator = investmentCalculator;
    }

    public void setProfit(Double profit) {
        this.profit = profit;
    }

    public void setAlgorithm(String algorithm) {
        this.algorithm = algorithm;
    }

    public List<InvestmentCalculator> getInvestmentCalculatorList() {
        return investmentCalculatorList;
    }
}
