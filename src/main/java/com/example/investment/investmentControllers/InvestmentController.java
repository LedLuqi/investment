package com.example.investment.investmentControllers;

import com.example.investment.investment.CapitalizationPeriod;
import com.example.investment.investment.Investment;
import com.example.investment.investment.InvestmentService;
import com.example.investment.investmentInfo.InvestmentIdNameList;
import com.example.investment.investmentInfo.InvestmentInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class InvestmentController {

    InvestmentInfo investmentInfo;

    InvestmentService investmentService;

    @Autowired
    public InvestmentController(InvestmentInfo investmentInfo, InvestmentService investmentService) {
        this.investmentInfo = investmentInfo;
        this.investmentService = investmentService;
    }

    @GetMapping("/investments")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    List<InvestmentIdNameList> getList() {
        return investmentService.getAllInvestments().stream()
                .map(x -> new InvestmentIdNameList(x.getId(), x.getName()))
                .collect(Collectors.toList());
    }

    @PostMapping("/investments")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Investment addInvestment(@RequestBody Investment investment) {
        investmentService.addInvestment(investment);
        return investment;
    }

}
