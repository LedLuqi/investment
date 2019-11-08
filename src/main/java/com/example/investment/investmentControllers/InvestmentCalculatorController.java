package com.example.investment.investmentControllers;

import com.example.investment.investment.InvestmentService;
import com.example.investment.investmentCalculator.InvestmentCalculator;
import com.example.investment.investmentCalculator.InvestmentCalculatorService;
import com.example.investment.investmentInfo.InvestmentCalculationInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

@RestController
@RequestMapping("/api/investments/")
public class InvestmentCalculatorController {

    InvestmentCalculatorService investmentCalculatorService;

    InvestmentService investmentService;

    InvestmentCalculationInfo investmentCalculationInfo;

    @Autowired
    public InvestmentCalculatorController(InvestmentCalculatorService investmentCalculatorService, InvestmentService investmentService, InvestmentCalculationInfo investmentCalculationInfo) {
        this.investmentCalculatorService = investmentCalculatorService;
        this.investmentService = investmentService;
        this.investmentCalculationInfo = investmentCalculationInfo;
    }

    @GetMapping("{id}/calculations")
    @ResponseStatus(HttpStatus.OK)
    public Class<InvestmentCalculationInfo> investmentAndHistoryOfCalculation(@PathParam("id") Long id) {
        investmentCalculationInfo.update();
        investmentCalculationInfo.setInvestment(investmentService.getInvestmentById(id).get());
        return InvestmentCalculationInfo.class;
    }

    @PostMapping("{id}/calculations")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public InvestmentCalculationInfo caluclate(@RequestBody InvestmentCalculator investmentCalculator, @PathParam("id") Long id) {
        investmentCalculationInfo.setInvestmentCalculator(investmentCalculator);
        investmentCalculationInfo.setProfit(investmentCalculator.calculateProfit());
        investmentCalculationInfo.setAlgorithm(investmentCalculator.getInvestment().getInterest().toString());
        investmentCalculator.setInvestment(investmentService.getInvestmentById(id).get());
        investmentCalculationInfo.update();
        investmentCalculatorService.addCalculation(investmentCalculator);
        return investmentCalculationInfo;
    }

    @ExceptionHandler({ FutureInvestmentCalculationException.class })
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public void handleFutureInvestmentCalculationException() {
    }
}
