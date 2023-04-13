package org.ekwateur.domain.service;

import org.ekwateur.domain.model.Client;

import java.math.BigDecimal;

public interface BillCalculator {
    BigDecimal calculateBill(BigDecimal electricityConsumption, BigDecimal gasConsumption);
}
