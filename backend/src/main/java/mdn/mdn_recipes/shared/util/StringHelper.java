package mdn.mdn_recipes.shared.util;

public class StringHelper {

    private StringHelper() {}

    public static boolean isNullOrBlank(String str) {
        return (str == null || str.isBlank());
    }

}
