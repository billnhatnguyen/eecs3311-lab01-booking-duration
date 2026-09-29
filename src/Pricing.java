public final class Pricing {
	public int quote(Duration duration, Customer customer) {
		// TODO Lab01 Task 2: null validation and integer-cent pricing.
		if (duration == null || customer == null) {
			throw new IllegalArgumentException("TODO Lab01 Pricing.quote");
		}

		int hourlyRateInCents = switch (customer) {
			case STUDENT -> 200;
			case VISITOR -> 400;
		};

		return duration.hours() * hourlyRateInCents;

	}
}
