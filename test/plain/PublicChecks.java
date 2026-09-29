import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/** Public examples of required behaviour. Add independent tests of your own. */
public final class PublicChecks {
    @FunctionalInterface
    public interface Action {
        void run() throws Exception;
    }

    public record Case(String name, Action action) {
    }

    public static void equal(Object expected, Object actual) {
        if (!Objects.equals(expected, actual))
            throw new AssertionError("Expected " + expected + "; got " + actual);
    }

    public static void require(boolean condition, String message) {
        if (!condition)
            throw new AssertionError(message);
    }

    public static void rejects(Class<? extends Throwable> type, Action action) throws Exception {
        try {
            action.run();
        } catch (Throwable ex) {
            if (type.isInstance(ex))
                return;
            throw new AssertionError("Expected " + type.getSimpleName() + "; got " + ex, ex);
        }
        throw new AssertionError("Expected " + type.getSimpleName() + "; operation returned normally");
    }

    public static List<Case> cases() {
        List<Case> cases = new ArrayList<>();

        cases.add(new Case("duration endpoints", () -> {
            equal(1, new Duration(1).hours());
            equal(24, new Duration(24).hours());
        }));
        for (int bad : new int[] { 0, 25, -1, Integer.MIN_VALUE, Integer.MAX_VALUE }) {
            cases.add(new Case("reject duration " + bad,
                    () -> rejects(IllegalArgumentException.class, () -> new Duration(bad))));
        }
        cases.add(new Case("student three-hour price",
                () -> equal(600, new Pricing().quote(new Duration(3), Customer.STUDENT))));
        cases.add(new Case("visitor three-hour price",
                () -> equal(1200, new Pricing().quote(new Duration(3), Customer.VISITOR))));
        cases.add(new Case("null duration",
                () -> rejects(IllegalArgumentException.class, () -> new Pricing().quote(null, Customer.STUDENT))));
        cases.add(new Case("null customer",
                () -> rejects(IllegalArgumentException.class, () -> new Pricing().quote(new Duration(1), null))));

        return cases;
    }

    public static void main(String[] args) {
        int failed = 0;
        for (Case c : cases()) {
            try {
                c.action().run();
                System.out.println("PASS " + c.name());
            } catch (Throwable ex) {
                failed++;
                System.out.println("FAIL " + c.name() + ": " + ex);
            }
        }
        System.out.println("CHECKS " + cases().size() + "; FAILED " + failed);
        if (failed != 0)
            System.exit(1);
    }
}
