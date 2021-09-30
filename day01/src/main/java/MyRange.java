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
        return input.charAt(1) - ASCII_CODE_1;
    }
}
