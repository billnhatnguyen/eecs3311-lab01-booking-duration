# Lab 01 — Booking duration and first tests

Release: 2026-09-15. Read the matching Student Brief before editing.
This is an exercise starter. A clean compile does not mean the exercise is solved.
The public checks are expected to fail initially. Preserve them and add your own tests.
All data is synthetic. No personal paid AI account or model service is needed for the labs.

## First run

Extract the whole ZIP. Open its starter folder, containing this README and src/Main.java.
Use JDK 21. Check java -version and javac -version.

macOS/Linux (or Git Bash on Windows):

    bash run.sh compile
    bash run.sh run
    bash run.sh check
    bash setup-junit.shmpw
    bash run.sh test

Windows PowerShell:

    ./run.ps1 compile
    ./run.ps1 run
    ./run.ps1 check
    ./setup-junit.ps1
    ./run.ps1 test

If local policy blocks PowerShell scripts, use Git Bash or the lab-supported setup;
do not weaken institution-managed security policies. COURSE_JAVA_HOME may point to
a supported JDK folder. JAVA_HOME is also respected. Scripts always target Java 21.

setup-junit downloads the pinned JUnit 6.0.3 console jar from Maven Central and checks its
SHA-256. The TA can cache it once and provide JUNIT_JAR as an absolute path instead.
Compilation and plain Java checks work offline without JUnit. A missing dependency
is an environment issue; report it separately from failed behavioural checks.

## Your work

Complete Duration validation and Pricing.quote. Required hours are 1–24 inclusive; rates are 200 cents/hour for STUDENT and 400 for VISITOR. Reject null arguments. Add boundary and null tests; the optional capped price is not included in the mandatory API.

## Completed work

- **Task 1 — Duration:** constructor accepts only 1–24 hours; every other
  integer (0, 25, −1, …) throws IllegalArgumentException. The field is private
  final and read via hours(); there is no setter.
- **Task 2 — Pricing.quote:** rejects null duration and null customer with
  IllegalArgumentException; returns integer cents as hours × rate
  (STUDENT = 200¢/h, VISITOR = 400¢/h).
- **Task 3 — Tests:** test/junit/StudentTests.java adds focused Jupiter tests
  for valid endpoints (1, 24), invalid neighbours (0, 25, −1), both customer
  categories (600¢, 1200¢ for 3 h) and null arguments. Fresh objects per test.

**Limitation:** the optional capped-price operation (Math.min(base, 500)) is
not implemented; quote assumes the duration has already been validated.

**Exact command used:** bash run.sh test (plain checks: bash run.sh check) —
captured output in results.txt.

## Commands and evidence

- compile: compile source with Java 21 and compiler warnings enabled.
- run: small starter orientation or deliberately faulty demonstration, not a test suite.
- check: named plain Java checks, exit 1 when a required behaviour is missing.
- test: the same supplied cases through JUnit Jupiter plus your added test classes.
- lint: compile with -Xlint:all. Lab07 deliberately begins with raw/unchecked warnings.

Each check creates its own objects. Read the case name and assertion message; do not
delete failing cases or edit the captured output. Add focused Jupiter tests in
test/junit/StudentTests.java. An all-green public suite is not proof of every requirement.

For a lab submission include src/, test/, README.md, AI_USE.md and results.txt, plus
the diagram where the brief requests it. Do not submit build/, lib/, secrets or IDE caches.
Use the exact ZIP naming and end-of-session submission route in the brief.
The initial trace/design phase prohibits generative AI; permitted implementation assistance
must be disclosed. The supplied infrastructure is acknowledged in STARTER_PROVENANCE.md.

## References

- Java 21: https://docs.oracle.com/en/java/javase/21/
- JUnit 6.0.3 console: https://docs.junit.org/6.0.3/running-tests/console-launcher.html
