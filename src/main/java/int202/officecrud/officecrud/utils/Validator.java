package int202.officecrud.officecrud.utils;

public class Validator {
    public static boolean isNullOrEmpty(String str) {
        return str == null || str.trim().isEmpty();
    }
}
