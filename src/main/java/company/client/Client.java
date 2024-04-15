package main.java.company.client;

public interface Client {

    void immediateTransactionsIncrease();
    ClientId getClientId();

    ClientCredit getClientCredit();

    boolean isClientWithImmediatePayment();

    int getImmediateTransactionsCounter();

    ClientType type();
}
