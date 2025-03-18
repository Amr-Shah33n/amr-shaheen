package org.moneyapp.enums;

/**
 * Enum of a few select initial balance sources
 * Ideally usage of unique locators for
 * each balance source is preferable and would
 * make this enum redundant
 */
public enum InitialBalanceSources {
    AMEX(0),
    CASH(1),
    BITCOIN(2);

    private final int index;

    InitialBalanceSources(int index) {
        this.index = index;
    }

    public int getIndex() {
        return index;
    }
}
