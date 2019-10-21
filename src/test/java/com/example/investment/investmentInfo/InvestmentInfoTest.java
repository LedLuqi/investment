package com.example.investment.investmentInfo;

import com.example.investment.ivestmentReopsitories.InvestmentCalculatorRepository;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.hamcrest.junit.MatcherAssert.assertThat;

public class InvestmentInfoTest {
    @Autowired
    InvestmentCalculatorRepository investmentCalculatorRepositoryRepository;
    @Test
    public void update() {
        //given
        InvestmentInfo investmentInfo = new InvestmentInfo(investmentCalculatorRepositoryRepository);
        //when
        investmentInfo.update();
        //then
        assertThat(investmentInfo.getInvestmentCalculatorList(), Matchers.equalTo(investmentCalculatorRepositoryRepository.findAll()));

    }
}