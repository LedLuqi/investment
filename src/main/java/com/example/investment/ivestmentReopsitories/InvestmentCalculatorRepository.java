package com.example.investment.ivestmentReopsitories;

import com.example.investment.investmentCalculator.InvestmentCalculator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvestmentCalculatorRepository extends JpaRepository<InvestmentCalculator, Long> {
}
