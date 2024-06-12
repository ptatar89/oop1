package company.discount;

public enum DiscountLevel{
    LEVEL_0(0, 0),
    LEVEL_1(50, 0.05),
    LEVEL_2(100, 0.1),
    LEVEL_3(150, 0.15),
    LEVEL_4(200, 0.2);

    final int level;
    final double discount;

    DiscountLevel(int level, double discount) {
        this.level = level;
        this.discount = discount;
    }
}