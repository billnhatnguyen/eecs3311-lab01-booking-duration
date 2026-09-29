public final class Duration {
    private final int hours;

    public Duration(int hours) {
        // TODO Lab01 Task 1: reject values outside 1..24 before assigning.
        if (hours < 1 || hours > 24) {
            throw new IllegalArgumentException("The specified hours duration falls outside of range");
        }
        this.hours = hours;
    }

    public int hours() {
        return hours;
    }
}
