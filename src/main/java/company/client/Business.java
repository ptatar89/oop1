package company.client;

import company.loyalty.TransactionCounter;


import static company.client.ClientType.BUSINESS;

public class Business implements Client {
    ClientId clientId;
    ClientCredit clientCredit;
    boolean clientWithImmediatePayment;
    TransactionCounter immediateTransactionsCounter;
    static final ClientType clientType = BUSINESS;
    ClientLoyaltyPoints clientLoyaltyPoints;

    public Business(ClientId clientId, ClientCredit clientCredit, boolean clientWithImmediatePayment,
                    TransactionCounter transactionCounter, ClientLoyaltyPoints loyaltyPoints) {
        this.clientId = clientId;
        this.clientCredit = clientCredit;
        this.clientWithImmediatePayment = clientWithImmediatePayment;
        this.immediateTransactionsCounter = transactionCounter;
        this.clientLoyaltyPoints = loyaltyPoints;
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

    @Override
    public ClientLoyaltyPoints getClientLoyaltyPoints() {
        return clientLoyaltyPoints;
    }
}
