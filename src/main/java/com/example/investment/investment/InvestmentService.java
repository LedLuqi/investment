package com.example.investment.investment;

import com.example.investment.investmentInfo.InvestmentCalculationInfo;
import com.example.investment.ivestmentReopsitories.InvestmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class InvestmentService {

    InvestmentRepository investmentRepository;

    InvestmentCalculationInfo investmentCalculationInfo;

    @Autowired
    public InvestmentService(InvestmentRepository investmentRepository, InvestmentCalculationInfo investmentCalculationInfo) {
        this.investmentRepository = investmentRepository;
        this.investmentCalculationInfo = investmentCalculationInfo;
    }

    public InvestmentDTO addInvestment(InvestmentRequest investmentRequest) {
        Investment investment = investmentRepository.save(createInvestment(investmentRequest));
        return createInvestmentDTO(investment);
    }

    public List<InvestmentInfo> getAllInvestments() {
        return investmentRepository.findAll().stream()
                .map(x -> new InvestmentInfo(x.getId(), x.getName()))
                .collect(Collectors.toList());
    }

    public Optional<Investment> getInvestmentById(Long id) {
        investmentCalculationInfo.setInvestment(investmentRepository.findById(id).get());
        return investmentRepository.findById(id);
    }

    private Investment createInvestment(InvestmentRequest investmentRequest) {
        return new Investment(investmentRequest.getName(),
                investmentRequest.getInterest(),
                investmentRequest.getCapitalizationPeriod(),
                investmentRequest.getDateOfStart(),
                investmentRequest.getDateOfEnd());
    }

    private InvestmentDTO createInvestmentDTO(Investment investment) {
        return new InvestmentDTO(investment.getId(),
                investment.getName(),
                investment.getInterest(),
                ChronoUnit.DAYS.between(investment.getDateOfStart(), investment.getDateOfEnd()));
    }
}
