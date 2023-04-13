package org.ekwateur.domain.model;

import org.ekwateur.domain.service.ProfessionalBillCalculator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import static org.assertj.core.api.Assertions.assertThat;
public class ProfessionalBillCalculatorTest {

    private ProfessionalBillCalculator professionalBillCalculatorAbove1M;
    private ProfessionalBillCalculator professionalBillCalculatorBelow1M;

    @BeforeEach
    public void setUp() {
        professionalBillCalculatorAbove1M = new ProfessionalBillCalculator(new BigDecimal("1500000"));
        professionalBillCalculatorBelow1M = new ProfessionalBillCalculator(new BigDecimal("900000"));
    }
    @Test
    public void calculateBill_above1M_shouldCalculateCorrectBill() {
        BigDecimal electricityConsumption = new BigDecimal("100");
        BigDecimal gasConsumption = new BigDecimal("200");
        BigDecimal result = professionalBillCalculatorAbove1M.calculateBill(electricityConsumption, gasConsumption);
        assertThat(result).isEqualByComparingTo("33.60");
    }
    @Test
    public void calculateBill_below1M_shouldCalculateCorrectBill() {
        BigDecimal electricityConsumption = new BigDecimal("100");
        BigDecimal gasConsumption = new BigDecimal("200");
        BigDecimal result = professionalBillCalculatorBelow1M.calculateBill(electricityConsumption, gasConsumption);
        assertThat(result).isEqualByComparingTo("34.40");
    }
    @Test
    public void calculateBill_withNullElectricityConsumption_shouldCalculateCorrectBill() {
        BigDecimal gasConsumption = new BigDecimal("200");
        BigDecimal resultAbove1M = professionalBillCalculatorAbove1M.calculateBill(null, gasConsumption);
        BigDecimal resultBelow1M = professionalBillCalculatorBelow1M.calculateBill(null, gasConsumption);
        assertThat(resultAbove1M).isEqualByComparingTo("22.20");
        assertThat(resultBelow1M).isEqualByComparingTo("22.60");
    }
    @Test
    public void calculateBill_withNullGasConsumption_shouldCalculateCorrectBill() {
        BigDecimal electricityConsumption = new BigDecimal("100");
        BigDecimal resultAbove1M = professionalBillCalculatorAbove1M.calculateBill(electricityConsumption, null);
        BigDecimal resultBelow1M = professionalBillCalculatorBelow1M.calculateBill(electricityConsumption, null);
        assertThat(resultAbove1M).isEqualByComparingTo("11.40");
        assertThat(resultBelow1M).isEqualByComparingTo("11.80");
    }
}