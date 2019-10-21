package com.example.investment.investmentControllers;

import com.example.investment.investment.InvestmentService;
import com.example.investment.investmentCalculator.InvestmentCalculator;
import com.example.investment.investmentCalculator.InvestmentCalculatorService;
import com.example.investment.investmentInfo.InvestmentInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

@RestController
@RequestMapping("/api/investments/")
public class InvestmentCalculatorController {

    InvestmentCalculatorService investmentCalculatorService;

    InvestmentService investmentService;

    InvestmentInfo investmentInfo;

    @Autowired
    public InvestmentCalculatorController(InvestmentCalculatorService investmentCalculatorService, InvestmentService investmentService, InvestmentInfo investmentInfo) {
        this.investmentCalculatorService = investmentCalculatorService;
        this.investmentService = investmentService;
        this.investmentInfo = investmentInfo;
    }

    @GetMapping("{id}/calculations")
    @ResponseStatus(HttpStatus.OK)
    public Class<InvestmentInfo> investmentAndHistoryOfCalculation(@PathParam("id") Long id) {
        investmentInfo.update();
        investmentInfo.setInvestment(investmentService.getInvestmentById(id).get());
        return InvestmentInfo.class;
    }

    @PostMapping("{id}/calculations")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public InvestmentInfo caluclate(@RequestBody InvestmentCalculator investmentCalculator, @PathParam("id") Long id) {
        investmentInfo.setInvestmentCalculator(investmentCalculator);
        investmentInfo.setProfit(investmentCalculator.calculateProfit());
        investmentInfo.setAlgorithm(investmentCalculator.getInvestment().getInterest().toString());
        investmentCalculator.setInvestment(investmentService.getInvestmentById(id).get());
        investmentInfo.update();
        investmentCalculatorService.addCalculation(investmentCalculator);
        return investmentInfo;
    }
}
