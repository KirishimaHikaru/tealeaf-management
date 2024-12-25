// WeightUnit.java
enum WeightUnit {
    GRAM(0.001),
    KILOGRAM(1),
    KUINTAL(100),
    TON(1000);

    private final double toKgFactor;

    WeightUnit(double toKgFactor) {
        this.toKgFactor = toKgFactor;
    }

    public double toKilograms(double value) {
        return value * toKgFactor;
    }
}