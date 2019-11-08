package com.example.investment.investmentCalculator;

import com.example.investment.investment.InvestmentService;
import com.example.investment.ivestmentReopsitories.InvestmentCalculatorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class InvestmentCalculatorService {

    InvestmentCalculatorRepository investmentCalculatorRepository;

    InvestmentService investmentService;

    @Autowired
    public InvestmentCalculatorService(InvestmentCalculatorRepository investmentCalculatorRepository, InvestmentService investmentService) {
        this.investmentCalculatorRepository = investmentCalculatorRepository;
        this.investmentService = investmentService;
    }

    public void addCalculation(InvestmentCalculator investmentCalculator) {
        investmentCalculatorRepository.save(investmentCalculator);
    }

}
