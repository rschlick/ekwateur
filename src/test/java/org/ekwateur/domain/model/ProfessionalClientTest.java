package org.ekwateur.domain.model;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.YearMonth;

import static java.util.Map.of;
import static org.assertj.core.api.Assertions.assertThat;

public class ProfessionalClientTest {


    @Test
    public void billCalculationWithCompanyAboveOneMillionCAShouldBeCorrect() {
        // Given
        ProfessionalClient professionalClient = new ProfessionalClient.Builder("EKW12345679")
                .siretNumber("12345678901234")
                .companyName("ACME Inc")
                .annualRevenue(new BigDecimal("2000000"))
                .gasConsumptions(of(YearMonth.of(2023, 4), new BigDecimal("500")))
                .electricityConsumptions(of(YearMonth.of(2023, 4), new BigDecimal("1000")))
                .build();

        // When
        BigDecimal bill = professionalClient.calculateBill(YearMonth.of(2023, 4));
        // Then
        assertThat(bill).isEqualByComparingTo(new BigDecimal("169.5"));
    }

    @Test
    public void billCalculationWithCompanyBelowOneMillionCAShouldBeCorrect() {
        // Given
        ProfessionalClient professionalClient = new ProfessionalClient.Builder("EKW12345679")
                .siretNumber("12345678901234")
                .companyName("ACME Inc")
                .annualRevenue(new BigDecimal("500000"))
                .gasConsumptions(of(YearMonth.of(2023, 4), new BigDecimal("500")))
                .electricityConsumptions(of(YearMonth.of(2023, 4), new BigDecimal("1000")))
                .build();
        // When
        BigDecimal bill = professionalClient.calculateBill(YearMonth.of(2023, 4));
        // Then
        assertThat(bill).isEqualByComparingTo(new BigDecimal("174.5"));
    }
}