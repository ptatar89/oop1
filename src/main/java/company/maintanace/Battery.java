package company.maintanace;

public class Battery {
    Integer level;

    private final static Integer MIN_LEVEL = 0;
    private final static Integer MAX_LEVEL = 100;

    public Battery(Integer level) {
        if (level < MIN_LEVEL || level > MAX_LEVEL) {
            throw new RuntimeException("Battery level is over limit");
        }

        this.level = level;
    }
}
