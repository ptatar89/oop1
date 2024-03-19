import javax.xml.crypto.Data;

class ReturnScooterService {
    void returnScooter(ClientId clientId, ScooterId scooterId, Position where, int minutes) {
        //metoda returnScooter ma 4 parametry - clientId, scooterId, where, minutes
        //resztę pobieramy na podstawię clientId i scooterId z bazy
        //(batteryLevel, Object[] scooterData, float clientCredit, boolean clientWithImmediatePayment, int immediateTransactionsCounter)
        //kod celowo nie jest najpiękniejszy

        Client client = new Client(clientId);
        Scooter scooter = new Scooter(scooterId);

        PriceComponents priceComponents = new PriceComponents(scooter.scooterData);
        Price price = new Price(priceComponents, client.clientWithImmediatePayment);

        float chargeAmount = Math.max(price.calculate(priceComponents, minutes) - client.clientCredit, 0);
        chargeClient(client.clientId, chargeAmount);
        client.immediateTransactionsIncrease();

        Database.saveInDatabase(
                Loyalty.calculate(minutes, price.priceAmountClientMultiplicationFactor, chargeAmount),
                chargeAmount,
                scooter.needsToChargeBattery(),
                new TransactionCounter(client.immediateTransactionsCounter)
        );
    }

    private void chargeClient(ClientId clientId, float chargeAmount) {
        //obciążenie karty kredytowej
    }

}

class Position {
    private float latitude;
    private float longitude;
}