public class MyRange {
    public static final int ASCII_CODE_1 = 48;
    private final String input;

    public MyRange(String input) {
        this.input = input;
    }

    public boolean startWithInclude() {
        return input.startsWith("[");
    }

    public int getStart() {
        char start = input.charAt(1);
        if(startWithInclude()) {
            return start - ASCII_CODE_1;
        }
        return start - (ASCII_CODE_1 - 1);
    }

    public void validate() {
        // Fail fast
        if (!input.startsWith("[") && !input.startsWith("(")) {
            throw new InputInvalidException("Input error");
        }
        // ok
    }
}
