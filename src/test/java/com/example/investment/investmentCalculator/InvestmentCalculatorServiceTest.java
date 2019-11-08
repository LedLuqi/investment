package com.example.investment.investmentCalculator;

import com.example.investment.investment.CapitalizationPeriod;
import com.example.investment.investment.Investment;
import com.example.investment.investment.InvestmentService;
import com.example.investment.investmentInfo.InvestmentCalculationInfo;
import com.example.investment.ivestmentReopsitories.InvestmentCalculatorRepository;
import com.example.investment.ivestmentReopsitories.InvestmentRepository;
import org.hamcrest.Matchers;
import org.junit.Test;

import java.time.LocalDate;

import static org.hamcrest.junit.MatcherAssert.assertThat;
import static org.mockito.Mockito.mock;

public class InvestmentCalculatorServiceTest {

    @Test
    public void addCalculation() {
        //given
        String start = "2019-05-12";
        String end = "2020-05-12";
        Investment investment = new Investment("Locat", 5.0, CapitalizationPeriod.ONE_MONTH, LocalDate.parse(start), LocalDate.parse(end));
        InvestmentCalculator investmentCalculator = new InvestmentCalculator(1000, investment);
        InvestmentCalculatorRepository investmentCalculatorRepository = mock(InvestmentCalculatorRepository.class);
        InvestmentRepository investmentRepository = mock(InvestmentRepository.class);
        InvestmentCalculationInfo investmentCalculationInfo = new InvestmentCalculationInfo(investmentCalculatorRepository);
        InvestmentService investmentService = new InvestmentService(investmentRepository, investmentCalculationInfo);
        InvestmentCalculatorService investmentCalculatorService = new InvestmentCalculatorService(investmentCalculatorRepository,investmentService);
        //when
       //
        investmentCalculatorService.addCalculation(investmentCalculator);
        //then
        assertThat(investmentCalculatorRepository.findAll(), Matchers.hasSize(1));

    }

    @Test
    public void getCalculationHistory() {
        //given
        String start = "2019-05-12";
        String end = "2020-05-12";
        Investment investment = new Investment("Locat", 5.0, CapitalizationPeriod.ONE_MONTH, LocalDate.parse(start), LocalDate.parse(end));
        InvestmentCalculator investmentCalculator = new InvestmentCalculator(1000, investment);
        InvestmentCalculatorRepository investmentCalculatorRepository = mock(InvestmentCalculatorRepository.class);
        InvestmentRepository investmentRepository = mock(InvestmentRepository.class);
        InvestmentCalculationInfo investmentCalculationInfo = new InvestmentCalculationInfo(investmentCalculatorRepository);
        InvestmentService investmentService = new InvestmentService(investmentRepository, investmentCalculationInfo);
        InvestmentCalculatorService investmentCalculatorService = new InvestmentCalculatorService(investmentCalculatorRepository,investmentService);
        //when
        investmentCalculatorService.addCalculation(investmentCalculator);
        //then
        //assertThat(investmentCalculatorRepository.findAll(), Matchers.equalTo());

    }

    @Test
    public void getCalculationByInvestmentId() {
        //given
        String start = "2019-05-12";
        String end = "2020-05-12";
        Investment investment = new Investment("Locat", 5.0, CapitalizationPeriod.ONE_MONTH, LocalDate.parse(start), LocalDate.parse(end));
        InvestmentCalculator investmentCalculator = new InvestmentCalculator(1000, investment);
        InvestmentCalculatorRepository investmentCalculatorRepository = mock(InvestmentCalculatorRepository.class);
        InvestmentRepository investmentRepository = mock(InvestmentRepository.class);
        InvestmentCalculationInfo investmentCalculationInfo = new InvestmentCalculationInfo(investmentCalculatorRepository);
        InvestmentService investmentService = new InvestmentService(investmentRepository, investmentCalculationInfo);
        InvestmentCalculatorService investmentCalculatorService = new InvestmentCalculatorService(investmentCalculatorRepository,investmentService);
        //when
        investmentCalculatorService.addCalculation(investmentCalculator);
        //then
        //assertThat(investmentCalculatorRepository.findAll(), Matchers.equalTo(investment));

    }
}