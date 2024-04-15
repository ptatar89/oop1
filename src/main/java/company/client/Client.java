package main.java.company.client;

public interface Client {

    void immediateTransactionsIncrease();
    ClientId getClientId();

    float getClientCredit();

    boolean isClientWithImmediatePayment();

    int getImmediateTransactionsCounter();

    ClientType type();
}
