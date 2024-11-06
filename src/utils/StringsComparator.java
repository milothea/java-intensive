package src.utils;

import src.constants.Action;

public class StringsComparator {
    public StringsComparator() {}

    public static boolean isEqual(String string, Action action) {
        return action.toString().toLowerCase().equals(string.toLowerCase());
    }
}
