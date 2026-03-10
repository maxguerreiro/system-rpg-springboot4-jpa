package com.systemrpg.rpg.enums;


/**
* Represents the available character class types in the RPG system.
*
* Each class defines a predefined archetype that can be assigned to a character,
* such as Warrior or Mage.
*/
public enum ClassType {

    WARRIOR("Warrior"),
    MAGE("Mage"),
    ROGUE("Rogue"),
    CLERIC("Cleric"),
    PALADIN("Paladin");

    private String value;

    ClassType(String value) {
        this.value = value;
    }
    
    /**
     * Returns the value of the class type.
     *
     * @return the display name of the class
     */
    public String getValue() {
        return value;
    }

    /**
     * Converts a text value into the corresponding ClassType.
     *
     * This method performs a case-insensitive comparison with the
     * stored display values. If no matching class type is found,
     * an IllegalArgumentException is thrown.
     */
    public static ClassType fromString(String text) {

        for (ClassType type : ClassType.values()) {
            if (type.value.equalsIgnoreCase(text)) {
                return type;
            }
        }

        throw new IllegalArgumentException("Invalid class type: " + text);
    }

    @Override
    public String toString() {
        return value;
    }
}
