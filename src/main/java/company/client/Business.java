package main.java.company.client;

import main.java.company.loyality.TransactionCounter;


import static main.java.company.client.ClientType.BUSINESS;

public class Business implements Client {
    ClientId clientId;
    ClientCredit clientCredit;
    boolean clientWithImmediatePayment;
    TransactionCounter immediateTransactionsCounter;
    static final ClientType clientType = BUSINESS;

    public Business(ClientId clientId, ClientCredit clientCredit, boolean clientWithImmediatePayment,
                    TransactionCounter transactionCounter) {
        this.clientId = clientId;
        this.clientCredit = clientCredit;
        this.clientWithImmediatePayment = clientWithImmediatePayment;
        this.immediateTransactionsCounter = transactionCounter;
    }

    @Override
    public void immediateTransactionsIncrease() {
        immediateTransactionsCounter.increment();
    }

    @Override
    public ClientId getClientId() {
        return clientId;
    }

    @Override
    public ClientCredit getClientCredit() {
        return clientCredit;
    }

    @Override
    public boolean isClientWithImmediatePayment() {
        return clientWithImmediatePayment;
    }

    @Override
    public int getImmediateTransactionsCounter() {
        return immediateTransactionsCounter.getCounter();
    }

    @Override
    public ClientType type() {
        return clientType;
    }
}
