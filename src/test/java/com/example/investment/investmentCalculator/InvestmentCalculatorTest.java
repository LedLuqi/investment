package com.example.investment.investmentCalculator;

import com.example.investment.investment.Investment;
import com.example.investment.investment.CapitalizationPeriod;
import org.hamcrest.Matchers;
import org.junit.Test;

import java.time.LocalDate;

import static org.hamcrest.junit.MatcherAssert.assertThat;

public class InvestmentCalculatorTest {

    @Test
    public void calcultateInterestMetodShouldReturnInterest() {
        //given
        String start = "2019-05-12";
        String end = "2020-05-12";
        LocalDate dateOfStart = LocalDate.parse(start);
        LocalDate dateOfEnd = LocalDate.parse(end);
        Investment investment = new Investment("Locat", 5.0, CapitalizationPeriod.ONE_MONTH, dateOfStart, dateOfEnd);
        InvestmentCalculator investmentCalculator = new InvestmentCalculator(1000,investment);
        //when
        Double result = investmentCalculator.calculateInterest();
        //then
        assertThat(result, Matchers.equalTo(5.116189788173298));
    }

    @Test
    public void calculateProfitMetodShouldReturnLocateProfit() {
        //given
        String start = "2019-05-12";
        String end = "2020-05-12";
        LocalDate dateOfStart = LocalDate.parse(start);
        LocalDate dateOfEnd = LocalDate.parse(end);
        Investment investment = new Investment("Locat", 5.0, CapitalizationPeriod.ONE_MONTH, dateOfStart, dateOfEnd);
        InvestmentCalculator investmentCalculator = new InvestmentCalculator(1000,investment);
        //when
        Double result = investmentCalculator.calculateProfit();
        //then
        assertThat(result, Matchers.equalTo(51.161897881732976));
    }
}
