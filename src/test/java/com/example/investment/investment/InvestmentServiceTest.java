package com.example.investment.investment;

import com.example.investment.investmentInfo.InvestmentInfo;
import com.example.investment.ivestmentReopsitories.InvestmentCalculatorRepository;
import com.example.investment.ivestmentReopsitories.InvestmentRepository;
import org.hamcrest.Matchers;
import org.junit.Test;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class InvestmentServiceTest {

    @Test
    public void addInvestment() {
        //given
        InvestmentCalculatorRepository investmentCalculatorRepository = mock(InvestmentCalculatorRepository.class);
        InvestmentRepository investmentRepository = mock(InvestmentRepository.class);
        InvestmentInfo investmentInfo = new InvestmentInfo(investmentCalculatorRepository);
        InvestmentService investmentService = new InvestmentService(investmentRepository,investmentInfo);
        investmentService.setInvestmentRepository(investmentRepository);
        Investment investment = new Investment("name",5.0,CapitalizationPeriod.ELEVEN_MONTH,LocalDate.parse("2019-05-12"),LocalDate.parse("2019-12-12"));
        List <Investment> investmentList = null;
        //when
        //doAnswer(investmentList.add(investment); return null).when(investmentService.addInvestment(investment));
        //then
        assertThat(investmentService.getAllInvestments(), Matchers.hasSize(8));
    }

    @Test
    public void getAllInvestments() {
        //given
        InvestmentService investmentService = mock(InvestmentService.class);
        InvestmentRepository investmentRepository = mock(InvestmentRepository.class);
        investmentService.setInvestmentRepository(investmentRepository);
        List<Investment> investments = this.investmentList();
        //when
        when(investmentService.getAllInvestments()).thenReturn(investments);
        //then
        assertThat(investmentService.getAllInvestments(), Matchers.equalTo(investments));

    }

    @Test
    public void getInvestmentById() {
        //given
        InvestmentService investmentService = mock(InvestmentService.class);
        InvestmentRepository investmentRepository = mock(InvestmentRepository.class);
        investmentService.setInvestmentRepository(investmentRepository);
        List<Investment> investments = this.investmentList();
        //when
//        Mockito.when(investmentService.getInvestmentById(any(Long.class))).thenReturn(investments.get());
        //then
//        assertThat(investmentService.getInvestmentById(), Matchers.equalTo(new Investment("lol3", 2.2, CapitalizationPeriod.THREE_MONTH, LocalDate.now(), LocalDate.now())));
    }

    List<Investment> investmentList() {
        Investment investment = new Investment("lol", 8.6, CapitalizationPeriod.ONE_MONTH, LocalDate.now(), LocalDate.now());
        Investment investment1 = new Investment("lol1", 2.5, CapitalizationPeriod.ELEVEN_MONTH, LocalDate.now(), LocalDate.now());
        Investment investment2 = new Investment("lol2", 2.3, CapitalizationPeriod.SIX_MONTH, LocalDate.now(), LocalDate.now());
        Investment investment3 = new Investment("lol3", 2.2, CapitalizationPeriod.THREE_MONTH, LocalDate.now(), LocalDate.now());
        Investment investment4 = new Investment("lol4", 2.6, CapitalizationPeriod.ONE_MONTH, LocalDate.now(), LocalDate.now());
        Investment investment5 = new Investment("lol5", 5.0, CapitalizationPeriod.ELEVEN_MONTH, LocalDate.now(), LocalDate.now());
        Investment investment6 = new Investment("lol6", 6.0, CapitalizationPeriod.THREE_MONTH, LocalDate.now(), LocalDate.now());
        Investment investment7 = new Investment("lol7", 2.0, CapitalizationPeriod.ONE_MONTH, LocalDate.now(), LocalDate.now());

        return Arrays.asList(investment, investment1, investment2, investment3, investment4, investment5, investment6, investment7);

    }


}