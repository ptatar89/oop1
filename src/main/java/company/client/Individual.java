package main.java.company.client;

import main.java.company.loyality.TransactionCounter;

import static main.java.company.client.ClientType.INDIVIDUAL;

public class Individual implements Client {
    ClientId clientId;
    float clientCredit;
    boolean clientWithImmediatePayment;
    TransactionCounter immediateTransactionsCounter;
    static final ClientType clientType = INDIVIDUAL;

    public Individual(ClientId clientId, float clientCredit, boolean clientWithImmediatePayment,
                      TransactionCounter transactionCounter) {
        this.clientId = clientId;
        this.clientCredit = clientCredit;
        this.clientWithImmediatePayment = clientWithImmediatePayment;
        this.immediateTransactionsCounter = transactionCounter;
    }

    public void immediateTransactionsIncrease() {
        immediateTransactionsCounter.increment();
    }
    public ClientId getClientId() {
        return clientId;
    }

    public float getClientCredit() {
        return clientCredit;
    }

    public boolean isClientWithImmediatePayment() {
        return clientWithImmediatePayment;
    }

    public int getImmediateTransactionsCounter() {
        return immediateTransactionsCounter.getCounter();
    }

    @Override
    public ClientType type() {
        return clientType;
    }
}
