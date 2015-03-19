package chaper09.replaceConditionalWithPoly;

public class Bird2 {
    private BirdType1 birdType1;
    private int baseSpeed1;

    public float getSpeed() {
        return birdType1.getSpeed();
    }

    public BirdType1 getBirdType() {
        return birdType1;
    }

    public void setBirdType(BirdType1 birdType1) {
        this.birdType1 = birdType1;
    }

    public int getBaseSpeed1() {
        return baseSpeed1;
    }

    public void setBaseSpeed1(int baseSpeed) {
        this.baseSpeed1 = baseSpeed;
    }

}
