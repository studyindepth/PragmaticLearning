package hfooad.chapter01.improved;

public abstract class Duck {

    private FlyingBehavior flying;

    private QuackingBehavior quacking;

    private SwimmingBehavior swimming;

    private Displaying displaying;

    public FlyingBehavior getFlying() {
        return flying;
    }

    public void setFlying(FlyingBehavior flying) {
        this.flying = flying;
    }

    public QuackingBehavior getQuacking() {
        return quacking;
    }

    public void setQuacking(QuackingBehavior quacking) {
        this.quacking = quacking;
    }

    public SwimmingBehavior getSwimming() {
        return swimming;
    }

    public void setSwimming(SwimmingBehavior swimming) {
        this.swimming = swimming;
    }

    public Displaying getDisplaying() {
        return displaying;
    }

    public void setDisplaying(Displaying displaying) {
        this.displaying = displaying;
    }

}
