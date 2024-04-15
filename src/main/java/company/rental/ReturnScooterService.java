package main.java.company.rental;

import main.java.company.client.Client;
import main.java.company.client.ClientService;
import main.java.company.client.Individual;
import main.java.company.client.ClientId;
import main.java.company.loyality.Loyalty;
import main.java.company.maintanace.Position;
import main.java.company.price.PriceCalculator;
import main.java.company.repository.TestDB;

import java.util.HashMap;

import static main.java.company.repository.TestDB.CHARGE_AMOUNT;
import static main.java.company.repository.TestDB.CLIENT_WITH_IMMEDIATE_PAYMENT;
import static main.java.company.repository.TestDB.IMMEDIATE_TRANSACTIONS_COUNTER;
import static main.java.company.repository.TestDB.LOYALTY_POINTS;
import static main.java.company.repository.TestDB.SCOOTER_DATA;

public class ReturnScooterService {

    private final TestDB testDB = new TestDB();
    private static final ClientService clientService = new ClientService();

    public static void returnScooter(ClientId clientId, ScooterId scooterId, Position position, UsageTime minutes, TestDB testDB) {
        //metoda returnScooter ma 4 parametry - clientId, scooterId, where, minutes
        //resztę pobieramy na podstawię clientId i scooterId z bazy
        //(batteryLevel, Object[] scooterData, float clientCredit, boolean clientWithImmediatePayment, int immediateTransactionsCounter)
        //kod celowo nie jest najpiękniejszy


        //Individual client = new Individual(clientId);
        //Scooter scooter = new Scooter(scooterId);

        //hashmap should be replaced by the DB object
        HashMap<String, Object> clientData = testDB.getClientData(clientId.id());
        HashMap<String, Object> scooterData = testDB.getScooterData(scooterId.id());

        float priceAmountClientMultiplicationFactor = 0.9f;  //this can be takes from db eg from Individual props, different clients differt multifactors


        float chargeAmount = PriceCalculator.calculate((Object[]) scooterData.get(SCOOTER_DATA), (Boolean) clientData.get(CLIENT_WITH_IMMEDIATE_PAYMENT), minutes, priceAmountClientMultiplicationFactor);

        Client client = clientService.getClientById(clientId); //this should be get from db, in place of 31 line
        chargeClient(client.getClientId(), chargeAmount);

        client.immediateTransactionsIncrease();
        clientData.put(IMMEDIATE_TRANSACTIONS_COUNTER, client.getImmediateTransactionsCounter());
        clientData.put(LOYALTY_POINTS, Loyalty.calculate(minutes, priceAmountClientMultiplicationFactor, chargeAmount));
        clientData.put(CHARGE_AMOUNT, chargeAmount);
        testDB.storeClientData(clientId.id(), clientData);
/*
        Database.saveInDatabase(
                Loyalty.calculate(minutes, price.getPriceAmountClientMultiplicationFactor(), chargeAmount),
                chargeAmount,
                scooter.needsToChargeBattery(),
                new TransactionCounter(client.getImmediateTransactionsCounter())
        );*/
    }

    private static void chargeClient(ClientId clientId, float chargeAmount) {
        //obciążenie karty kredytowej
    }

}

