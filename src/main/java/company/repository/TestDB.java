package company.repository;

import company.maintanace.Position;
import company.ride.Ride;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

//Generic db, Let say it is nosql db. Yoiu can get object data by its id
public class TestDB {
    public static final String CLIENT_ID = "clientId";
    public static final String SCOOTER_DATA = "scooterData";
    public static final String CLIENT_WITH_IMMEDIATE_PAYMENT = "clientWithImmediatePayment";
    public static final String CLIENT_CREDIT = "clientCredit";
    public static final String CLIENT_TYPE = "clientType";
    public static final String IMMEDIATE_TRANSACTIONS_COUNTER = "immediateTransactionsCounter";
    public static final String SCOOTER_ID = "scooterId";
    public static final String BATTERY_LEVEL = "batteryLevel";

    public static final String LOYALTY_POINTS = "loyaltyPoints";
    public static final String CHARGE_AMOUNT = "chargeAmount";
    public static final String NEEDS_TO_CHARGE_BATTERY = "needsToChargeBattery";
    public static final String RIDES = "rides";
    public static final String OFFICE_POSITION = "officePosition";

    private HashMap<Long, HashMap<String, Object>> db = new HashMap<>();

    public TestDB(){
        this.setUp();
    }
    public void setUp() {
        // client data
        HashMap<String, Object> clientData = new HashMap<>();
        var clientId = 1L;

        clientData.put(CLIENT_ID, clientId);
        clientData.put(CLIENT_CREDIT, 123.23f);
        clientData.put(CLIENT_TYPE, "BUSINESS");
        clientData.put(CLIENT_WITH_IMMEDIATE_PAYMENT, false);
        clientData.put(IMMEDIATE_TRANSACTIONS_COUNTER, 32);

        List<Ride> rides = new LinkedList<>();
        clientData.put(RIDES, rides);

        // load client data db
        db.put(clientId, clientData);

        // scooter data
        var scooterId = 100L;
        HashMap<String, Object> scooterData = new HashMap<>();
        scooterData.put(SCOOTER_ID, 100L);
        scooterData.put(BATTERY_LEVEL, 32.3f);
        scooterData.put(SCOOTER_DATA, new Object[]{"not_fast", 1.0f, 2.0f, 3.0f, 4.0f});

        // load sco0ter data db
        db.put(scooterId, scooterData);

        //offices data
        var officeId = 1000L;
        HashMap<String, Object> officeData = new HashMap<>();
        officeData.put(OFFICE_POSITION, Position.from(50.071184F,19.939664F));
        db.put(officeId, officeData);
        var secondOfficeId = 1100L;
        officeData.put(OFFICE_POSITION, Position.from(50.063928F, 19.960947F));
        db.put(secondOfficeId, officeData);
    }

    public HashMap<Long, HashMap<String, Object>> getDb() {
        return db;
    }

    public HashMap<String, Object> getClientData(Long clientId){
        //check if exist etc..
        return getDb().get(clientId);
    }

    public HashMap<String, Object> getScooterData(Long scooterId){
        //check if exist etc..
        return getDb().get(scooterId);
    }

    public HashMap<String, Object> getOfficeData(Long officeId){
        return getDb().get(officeId);
    }

    public HashMap<String, Object> storeClientData(Long clientId, HashMap<String, Object> data){
        //update data, ofc we can do here validation etc.
        return db.put(clientId, data);
    }
}