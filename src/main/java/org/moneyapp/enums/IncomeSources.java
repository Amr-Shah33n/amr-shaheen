package org.moneyapp.enums;

/**
 * Enum of income categories
 * Ideally usage of unique locators for
 * each income category is preferable and would
 * make this enum redundant
 */
public enum IncomeSources {
    DEPOSITS("Deposits"),
    SALARY("Salary"),
    SAVINGS("Savings");

    private final String displayName;

    IncomeSources(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
