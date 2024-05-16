package company.client;

public interface Client {

    void immediateTransactionsIncrease();
    ClientId getClientId();

    ClientCredit getClientCredit();

    ClientLoyaltyPoints getClientLoyaltyPoints();

    boolean isClientWithImmediatePayment();

    int getImmediateTransactionsCounter();

    ClientType type();
}
