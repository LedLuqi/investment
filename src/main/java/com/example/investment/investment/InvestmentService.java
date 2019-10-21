package com.example.investment.investment;

import com.example.investment.investmentInfo.InvestmentInfo;
import com.example.investment.ivestmentReopsitories.InvestmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class InvestmentService {

    InvestmentRepository investmentRepository;

    InvestmentInfo investmentInfo;

    @Autowired
    public InvestmentService(InvestmentRepository investmentRepository, InvestmentInfo investmentInfo) {
        this.investmentRepository = investmentRepository;
        this.investmentInfo = investmentInfo;
    }

    public void addInvestment(Investment investment) {
        investmentRepository.save(investment);
    }

    public List<Investment> getAllInvestments() {
        return investmentRepository.findAll();
    }

    public Optional<Investment> getInvestmentById(Long id) {
        investmentInfo.setInvestment(investmentRepository.findById(id).get());
        return investmentRepository.findById(id);
    }

    public void setInvestmentRepository(InvestmentRepository investmentRepository) {
        this.investmentRepository = investmentRepository;
    }
}
