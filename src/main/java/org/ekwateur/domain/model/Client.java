package org.ekwateur.domain.model;

import java.math.BigDecimal;
import java.time.YearMonth;
import java.util.Map;

public abstract class Client {
    protected final String clientReference;
    protected final Map<YearMonth, BigDecimal> gasConsumptions;
    protected final Map<YearMonth, BigDecimal> electricityConsumptions;

    public Client(String clientReference, Map<YearMonth, BigDecimal> electricityConsumptions, Map<YearMonth, BigDecimal> gasConsumptions) {
        this.clientReference = clientReference;
        this.gasConsumptions = gasConsumptions;
        this.electricityConsumptions = electricityConsumptions;
    }


    public abstract BigDecimal calculateBill(YearMonth yearMonth);

    public String getClientReference() {
        return clientReference;
    }

    public Map<YearMonth, BigDecimal> getGasConsumptions() {
        return gasConsumptions;
    }

    public Map<YearMonth, BigDecimal> getElectricityConsumptions() {
        return electricityConsumptions;
    }
}