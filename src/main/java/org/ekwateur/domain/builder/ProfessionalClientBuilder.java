package org.ekwateur.domain.builder;

import org.ekwateur.domain.model.ProfessionalClient;

import java.math.BigDecimal;
import java.time.YearMonth;
import java.util.HashMap;
import java.util.Map;

public class ProfessionalClientBuilder {
        private String clientReference;
        private String siretNumber;
        private String companyName;
        private BigDecimal annualRevenue;
        private Map<YearMonth, BigDecimal> gasConsumptions = new HashMap<>();
        private Map<YearMonth, BigDecimal> electricityConsumptions = new HashMap<>();


        public ProfessionalClientBuilder(String clientReference) {
            this.clientReference = clientReference;
        }

        public ProfessionalClientBuilder siretNumber(String siretNumber) {
            this.siretNumber = siretNumber;
            return this;
        }
        public ProfessionalClientBuilder companyName(String companyName) {
            this.companyName = companyName;
            return this;
        }
        public ProfessionalClientBuilder annualRevenue(BigDecimal annualRevenue) {
            this.annualRevenue = annualRevenue;
            return this;
        }
        public ProfessionalClientBuilder gasConsumptions(Map<YearMonth, BigDecimal> gasConsumptions) {
            this.gasConsumptions = gasConsumptions;
            return this;
        }
        public ProfessionalClientBuilder electricityConsumptions(Map<YearMonth, BigDecimal> electricityConsumptions) {
            this.electricityConsumptions = electricityConsumptions;
            return this;
        }
        public ProfessionalClient build() {
            return new ProfessionalClient(clientReference, electricityConsumptions, gasConsumptions, siretNumber, companyName, annualRevenue);
        }
    }