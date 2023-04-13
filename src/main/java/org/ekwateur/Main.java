package org.ekwateur;

import org.ekwateur.domain.model.IndividualClient;
import org.ekwateur.domain.model.ProfessionalClient;

import java.math.BigDecimal;
import java.time.YearMonth;
import java.util.Map;

import static java.util.Map.of;

public class Main {

    public static void main(String[] args) {
        System.out.println("Démarrage du calculateur Ekwateur ...");

        // Création d'un client particulier
        IndividualClient individualClient = new IndividualClient.Builder("EKW12345678")
                .civility("Mr")
                .firstName("John")
                .lastName("Doe")
                .gasConsumptions(of(YearMonth.of(2023, 4), new BigDecimal("500")))
                .electricityConsumptions(of(YearMonth.of(2023, 4), new BigDecimal("1000")))
                .build();

        // Calcul de la facture pour le client particulier
        BigDecimal individualBill = individualClient.calculateBill(YearMonth.of(2023, 4));
        System.out.println("Facture du client particulier pour avril 2023 : " + individualBill);

        // Création d'un client professionnel en utilisant le Builder
        ProfessionalClient professionalClient = new ProfessionalClient.Builder("EKW12345679")
                .siretNumber("12345678901234")
                .companyName("ACME Inc")
                .annualRevenue(new BigDecimal("2000000"))
                .gasConsumptions(of(YearMonth.of(2023, 4), new BigDecimal("500")))
                .electricityConsumptions(of(YearMonth.of(2023, 4), new BigDecimal("1000")))
                .build();

        // Calcul de la facture pour le client professionnel
        BigDecimal professionalBill = professionalClient.calculateBill(YearMonth.of(2023, 4));
        System.out.println("Facture du client professionnel pour avril 2023 : " + professionalBill);

    }
}