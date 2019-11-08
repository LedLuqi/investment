package com.example.investment.investmentInfo;

import com.example.investment.ivestmentReopsitories.InvestmentCalculatorRepository;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.hamcrest.junit.MatcherAssert.assertThat;

public class InvestmentCalculationInfoTest {
    @Autowired
    InvestmentCalculatorRepository investmentCalculatorRepositoryRepository;
    @Test
    public void update() {
        //given
        InvestmentCalculationInfo investmentCalculationInfo = new InvestmentCalculationInfo(investmentCalculatorRepositoryRepository);
        //when
        investmentCalculationInfo.update();
        //then
        assertThat(investmentCalculationInfo.getInvestmentCalculatorList(), Matchers.equalTo(investmentCalculatorRepositoryRepository.findAll()));

    }
}