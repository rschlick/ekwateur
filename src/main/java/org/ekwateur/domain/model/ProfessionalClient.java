package org.ekwateur.domain.model;

import org.ekwateur.domain.builder.ProfessionalClientBuilder;
import org.ekwateur.domain.service.ProfessionalBillCalculator;

import java.math.BigDecimal;
import java.time.YearMonth;
import java.util.HashMap;
import java.util.Map;

public class ProfessionalClient extends Client {
    private final String siretNumber;
    private final String companyName;
    private final BigDecimal annualRevenue;

    private ProfessionalClient(Builder builder) {
        super(builder.clientReference, builder.electricityConsumptions, builder.gasConsumptions);
        this.siretNumber = builder.siretNumber;
        this.companyName = builder.companyName;
        this.annualRevenue = builder.annualRevenue;
    }

    public ProfessionalClient(String clientReference, Map<YearMonth, BigDecimal> electricityConsumptions, Map<YearMonth, BigDecimal> gasConsumptions,
                              String siretNumber, String companyName, BigDecimal annualRevenue) {
        super(clientReference, electricityConsumptions, gasConsumptions);
        this.siretNumber = siretNumber;
        this.companyName = companyName;
        this.annualRevenue = annualRevenue;
    }

    @Override
    public BigDecimal calculateBill(YearMonth yearMonth) {
        ProfessionalBillCalculator billCalculator = new ProfessionalBillCalculator(annualRevenue);
        return billCalculator.calculateBill(electricityConsumptions.get(yearMonth), gasConsumptions.get(yearMonth));
    }

    public String getSiretNumber() {
        return siretNumber;
    }

    public String getCompanyName() {
        return companyName;
    }

    public BigDecimal getAnnualRevenue() {
        return annualRevenue;
    }


    public static class Builder {
        private final String clientReference;
        private String siretNumber;
        private String companyName;
        private BigDecimal annualRevenue;
        private Map<YearMonth, BigDecimal> gasConsumptions = new HashMap<>();
        private Map<YearMonth, BigDecimal> electricityConsumptions = new HashMap<>();

        public Builder(String clientReference) {
            this.clientReference = clientReference;
        }

        public Builder siretNumber(String siretNumber) {
            this.siretNumber = siretNumber;
            return this;
        }

        public Builder companyName(String companyName) {
            this.companyName = companyName;
            return this;
        }

        public Builder annualRevenue(BigDecimal annualRevenue) {
            this.annualRevenue = annualRevenue;
            return this;
        }

        public Builder gasConsumptions(Map<YearMonth, BigDecimal> gasConsumptions) {
            this.gasConsumptions = gasConsumptions;
            return this;
        }

        public Builder electricityConsumptions(Map<YearMonth, BigDecimal> electricityConsumptions) {
            this.electricityConsumptions = electricityConsumptions;
            return this;
        }

        public ProfessionalClient build() {
            return new ProfessionalClient(this);
        }
    }
}