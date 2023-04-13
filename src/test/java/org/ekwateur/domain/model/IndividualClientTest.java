package org.ekwateur.domain.model;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Map;

import static java.time.YearMonth.of;
import static org.assertj.core.api.Assertions.assertThat;

public class IndividualClientTest {


    @Test
    public void billCalculationWithElectricityAndGasShouldBeCorrect() {
        // Given
        IndividualClient individualClient = new IndividualClient.Builder("EKW12345678")
                .civility("Mr")
                .firstName("John")
                .lastName("Doe")
                .gasConsumptions(Map.of(of(2023, 4), new BigDecimal("500")))
                .electricityConsumptions(Map.of(of(2023, 4), new BigDecimal("1000")))
                .build();

        // When
        BigDecimal bill = individualClient.calculateBill(of(2023, 4));

        // Then
        assertThat(bill).isEqualByComparingTo(new BigDecimal("178.5"));
    }

    @Test
    public void billCalculationWithElectricityWithoutGasShouldBeCorrect() {
        // Given
        IndividualClient individualClient = new IndividualClient.Builder("EKW12345678")
                .civility("Mr")
                .firstName("John")
                .lastName("Doe")
                .gasConsumptions(Map.of())
                .electricityConsumptions(Map.of(of(2023, 4), new BigDecimal("1000")))
                .build();

        // When
        BigDecimal bill = individualClient.calculateBill(of(2023, 4));

        // Then
        assertThat(bill).isEqualByComparingTo(new BigDecimal("121"));
    }
}
