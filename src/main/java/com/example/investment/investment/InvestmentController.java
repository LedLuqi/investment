package com.example.investment.investment;

import com.example.investment.investmentInfo.InvestmentCalculationInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class InvestmentController {

    InvestmentCalculationInfo investmentCalculationInfo;

    InvestmentService investmentService;

    @Autowired
    public InvestmentController(InvestmentCalculationInfo investmentCalculationInfo, InvestmentService investmentService) {
        this.investmentCalculationInfo = investmentCalculationInfo;
        this.investmentService = investmentService;
    }

    @GetMapping("/investments")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    List<InvestmentInfo> getList() {
        return investmentService.getAllInvestments();
    }

    @PostMapping("/investments")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public InvestmentDTO addInvestment(@RequestBody InvestmentRequest investmentRequest) {
        return investmentService.addInvestment(investmentRequest);
    }

}
