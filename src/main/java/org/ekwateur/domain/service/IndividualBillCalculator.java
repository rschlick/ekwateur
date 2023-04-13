package org.ekwateur.domain.service;

import java.math.BigDecimal;

public class IndividualBillCalculator implements BillCalculator {

    private static final BigDecimal ELECTRICITY_RATE = new BigDecimal("0.121");
    private static final BigDecimal GAS_RATE = new BigDecimal("0.115");

    @Override
    public BigDecimal calculateBill(BigDecimal electricityConsumption, BigDecimal gasConsumption) {
        BigDecimal electricityBill = electricityConsumption == null ? BigDecimal.ZERO : electricityConsumption.multiply(ELECTRICITY_RATE);
        BigDecimal gasBill = gasConsumption == null ? BigDecimal.ZERO : gasConsumption.multiply(GAS_RATE);
        return electricityBill.add(gasBill);
    }
}