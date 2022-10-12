package utils.enums;

public enum TimeForWaiting {

    FIVE_SECONDS(5),
    TEN_SECONDS(10),
    TWENTY_SECONDS(20),
    THIRTY_SECONDS(30),
    ONE_MINUTE(60);

    private int value;

    TimeForWaiting(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

}
