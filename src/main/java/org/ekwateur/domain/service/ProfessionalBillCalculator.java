package org.ekwateur.domain.service;

import java.math.BigDecimal;

public class ProfessionalBillCalculator implements BillCalculator {
    private static final BigDecimal ELECTRICITY_RATE_ABOVE_1M = new BigDecimal("0.114");
    private static final BigDecimal GAS_RATE_ABOVE_1M = new BigDecimal("0.111");
    private static final BigDecimal ELECTRICITY_RATE_BELOW_1M = new BigDecimal("0.118");
    private static final BigDecimal GAS_RATE_BELOW_1M = new BigDecimal("0.113");

    private final BigDecimal annualRevenue;

    public ProfessionalBillCalculator(BigDecimal annualRevenue) {
        this.annualRevenue = annualRevenue;
    }

    @Override
    public BigDecimal calculateBill(BigDecimal electricityConsumption, BigDecimal gasConsumption) {
        BigDecimal electricityRate = isAbove1M() ? ELECTRICITY_RATE_ABOVE_1M : ELECTRICITY_RATE_BELOW_1M;
        BigDecimal gasRate = isAbove1M() ? GAS_RATE_ABOVE_1M : GAS_RATE_BELOW_1M;

        BigDecimal electricityBill = electricityConsumption == null ? BigDecimal.ZERO : electricityConsumption.multiply(electricityRate);
        BigDecimal gasBill = gasConsumption == null ? BigDecimal.ZERO : gasConsumption.multiply(gasRate);
        return electricityBill.add(gasBill);
    }

    private boolean isAbove1M() {
        return annualRevenue.compareTo(new BigDecimal("1000000")) > 0;
    }
}