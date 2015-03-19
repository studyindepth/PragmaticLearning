package chapter10.separate_query_from_modifier;

public class MethodPamaterization {

    protected Dollars baseCharge() {
        double result = useRange(lastUsage(), 100) * 0.03;
        if (lastUsage() > 100) {
            result += (useRange(lastUsage(), 200) - 100) * 0.05;
        }
        if (lastUsage() > 200) {
            result += (lastUsage() - 200) * 0.07;
        }
        return new Dollars(result);
    }

    private int useRange(int start, int end) {
        return Math.min(start, end);
    }

    private int lastUsage() {
        return 0;
    }
}
