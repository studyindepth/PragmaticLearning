package tests;

import java.util.Arrays;

public enum Priority {
    ONE(1) {
        public String toString() {
            return "LOW";
        }
    }, // (1)
    TWO(2), THREE(3) {
        public String toString() {
            return "NORMAL";
        }
    }, // (2)
    FOUR(4), FIVE(5) {
        public String toString() {
            return "HIGH";
        }
    }; // (3)
    private int pValue;

    Priority(int pValue) {
        this.pValue = pValue;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(Priority.values()));
        System.out.println(Priority.THREE.name());
    }
}
