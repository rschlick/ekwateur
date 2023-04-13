package org.ekwateur.domain.model;

import org.ekwateur.domain.service.IndividualBillCalculator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import static org.assertj.core.api.Assertions.assertThat;
public class IndividualBillCalculatorTest {
    private IndividualBillCalculator individualBillCalculator;

    @BeforeEach
    public void setUp() {
        individualBillCalculator = new IndividualBillCalculator();
    }

    @Test
    public void calculateBill_shouldCalculateCorrectBill() {
        BigDecimal electricityConsumption = new BigDecimal("100");
        BigDecimal gasConsumption = new BigDecimal("200");
        BigDecimal result = individualBillCalculator.calculateBill(electricityConsumption, gasConsumption);
        assertThat(result).isEqualByComparingTo("35.10");
    }

    @Test
    public void calculateBill_withNullElectricityConsumption_shouldCalculateCorrectBill() {
        BigDecimal gasConsumption = new BigDecimal("200");
        BigDecimal result = individualBillCalculator.calculateBill(null, gasConsumption);
        assertThat(result).isEqualByComparingTo("23.00");
    }

    @Test
    public void calculateBill_withNullGasConsumption_shouldCalculateCorrectBill() {
        BigDecimal electricityConsumption = new BigDecimal("100");
        BigDecimal result = individualBillCalculator.calculateBill(electricityConsumption, null);
        assertThat(result).isEqualByComparingTo("12.10");
    }
}