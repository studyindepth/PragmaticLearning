package refactoring.chapter01;

import java.util.HashMap;
import java.util.Map;

public enum PriceCode {
    REGULAR(0), NEW_RELEASE(1), CHILDRENS(2);
    public static final Map<Integer, PriceCode> codeMap = new HashMap<>();

    private int code;

    private PriceCode(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    static {
        codeMap.put(0, REGULAR);
        codeMap.put(1, NEW_RELEASE);
        codeMap.put(2, CHILDRENS);
    }

    public static PriceCode fromInteger(Integer codeInt) {
        PriceCode priceCode = codeMap.get(codeInt);
        if (priceCode == null) {
            throw new IllegalArgumentException("Invalid code");
        } else {
            return priceCode;
        }
    }

}
