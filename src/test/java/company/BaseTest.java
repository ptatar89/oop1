package test.java.company;

import company.maintanace.Position;
import company.repository.TestDB;
import org.junit.jupiter.api.BeforeEach;

public abstract class BaseTest {

    protected TestDB testDB;

    public final static Position TEST_START_POSITION = Position.from(50.071184F,19.939664F);
    public final static Position TEST_END_POSITION = Position.from(50.063928F, 19.960947F);

    @BeforeEach
    public void setUp() {
        testDB = new TestDB();
    }

}
