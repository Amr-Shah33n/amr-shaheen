package org.moneyapp.enums;

/**
 * Enum of a select category of expenses
 * Ideally usage of unique locators for
 * each expense is preferable and would
 * make this enum redundant
 */
public enum ExpenseCategories {
    BILLS("Bills"),
    CAR("Car"),
    CLOTHES("Clothes"),
    EATING_OUT("Eating Out"),
    COMMUNICATIONS("Communications");

    private final String displayName;

    ExpenseCategories(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
