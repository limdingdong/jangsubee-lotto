package lotto;

public enum Prize {

    THREE(5000L)
    ,FOUR(50000L)
    ,FIVE(1500000L)
    ,SIX(2000000000L)
    ;

    private long price;

    Prize(long price) {
        this.price = price;
    }

    public long getPrice() {
        return price;
    }
}
