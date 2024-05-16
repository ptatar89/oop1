package company.client;

import company.loyality.TransactionCounter;

import static company.client.ClientType.INDIVIDUAL;

public class Individual implements Client {
    ClientId clientId;
    ClientCredit clientCredit;
    boolean clientWithImmediatePayment;
    TransactionCounter immediateTransactionsCounter;
    static final ClientType clientType = INDIVIDUAL;
    ClientLoyaltyPoints clientLoyaltyPoints;

    public Individual(ClientId clientId, ClientCredit clientCredit, boolean clientWithImmediatePayment,
                      TransactionCounter transactionCounter, ClientLoyaltyPoints loyaltyPoints) {
        this.clientId = clientId;
        this.clientCredit = clientCredit;
        this.clientWithImmediatePayment = clientWithImmediatePayment;
        this.immediateTransactionsCounter = transactionCounter;
        this.clientLoyaltyPoints = loyaltyPoints;
    }

    public void immediateTransactionsIncrease() {
        immediateTransactionsCounter.increment();
    }
    public ClientId getClientId() {
        return clientId;
    }

    public ClientCredit getClientCredit() {
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

    @Override
    public ClientLoyaltyPoints getClientLoyaltyPoints() {
        return clientLoyaltyPoints;
    }
}
