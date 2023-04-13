# Ekwateur Billing System
Ce programme permet de calculer le montant à facturer à un client d'Ekwateur pour un mois calendaire. Il gère deux types de clients : les clients professionnels et les clients particuliers. Les clients peuvent consommer de l'électricité et du gaz.

## Prérequis
Java 8 ou une version ultérieure

## Structure du projet
Le projet est organisé en packages et contient les classes suivantes :

*org.ekwateur.domain.model* : contient les classes Client, IndividualClient et ProfessionalClient
*org.ekwateur.domain.service* : contient les classes BillCalculator, IndividualBillCalculator et ProfessionalBillCalculator
*Main* : une classe pour exécuter le programme et calculer les factures des clients

## Utilisation du programme
Pour utiliser le programme, vous devez créer des instances de IndividualClient et/ou ProfessionalClient en utilisant les classes Builder.
Ensuite, vous pouvez appeler la méthode calculateBill pour calculer la facture d'un client pour un mois donné.
Voici un exemple d'utilisation :

```
import org.ekwateur.domain.model.IndividualClient;
import org.ekwateur.domain.model.ProfessionalClient;

import java.math.BigDecimal;
import java.time.YearMonth;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {          
            // (1) Créez des instances de IndividualClient et/ou ProfessionalClient en utilisant les classes Builder
    
            // (2) Appelez la méthode calculateBill pour chaque client et le mois souhaité
    
            // (3) Affichez le montant de la facture pour chaque client
        }
}
```