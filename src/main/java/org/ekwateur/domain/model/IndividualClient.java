package org.ekwateur.domain.model;

import org.ekwateur.domain.service.IndividualBillCalculator;

import java.math.BigDecimal;
import java.time.YearMonth;
import java.util.HashMap;
import java.util.Map;

public class IndividualClient extends Client {
    private final String civility;
    private final String firstName;
    private final String lastName;

    public IndividualClient(String clientReference, Map<YearMonth, BigDecimal> electricityConsumptions, Map<YearMonth, BigDecimal> gasConsumptions,
                            String civility, String firstName, String lastName) {
        super(clientReference, electricityConsumptions, gasConsumptions);
        this.civility = civility;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    private IndividualClient(Builder builder) {
        super(builder.clientReference, builder.electricityConsumptions, builder.gasConsumptions);
        this.civility = builder.civility;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
    }

    @Override
    public BigDecimal calculateBill(YearMonth yearMonth) {
        IndividualBillCalculator billCalculator = new IndividualBillCalculator();
        return billCalculator.calculateBill(electricityConsumptions.get(yearMonth) , gasConsumptions.get(yearMonth));
    }

    public String getCivility() {
        return civility;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }


    public static class Builder {
        private final String clientReference;
        private String civility;
        private String firstName;
        private String lastName;
        private Map<YearMonth, BigDecimal> gasConsumptions = new HashMap<>();
        private Map<YearMonth, BigDecimal> electricityConsumptions = new HashMap<>();

        public Builder(String clientReference) {
            this.clientReference = clientReference;
        }

        public Builder civility(String civility) {
            this.civility = civility;
            return this;
        }

        public Builder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder lastName(String lastName) {
            this.lastName = lastName;
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

        public IndividualClient build() {
            return new IndividualClient(this);
        }
    }
}