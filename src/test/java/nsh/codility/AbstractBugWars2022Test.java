package nsh.codility;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;
import java.time.Duration;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public abstract class AbstractBugWars2022Test {
	abstract BugWars2022Interface getTestObject();

	BugWars2022Interface testObject;

	private Duration getTimeoutDuration() {
		return Duration.ofMillis(5000);
	}

	@BeforeEach
	void setup() {
		testObject = getTestObject();
	}

	int[] reverse(int[] A) {
		for (int i = 0; i < A.length >> 1; i++) {
			int r = A.length - 1 - i;
			int t = A[i];
			A[i] = A[r];
			A[r] = t;
		}
		return A;
	}

	@ParameterizedTest
	@MethodSource
	void test_samples(int E, int[] A, int[] X) {
		assertEquals(E, testObject.solution(A, X));
	}

	@ParameterizedTest
	@MethodSource(value = "test_samples")
	void test_samples_reverse(int E, int[] A, int[] X) {
		A = reverse(A);
		assertEquals(E, testObject.solution(A, X));
	}

	static Stream<Arguments> test_samples() {
		return Stream.of( //
				Arguments.of(4, new int[] {4, 1, 4, 3, 3}, new int[] {8, 10, 11, 13, 100}),
				Arguments.of(3, new int[] {0, 10, 0}, new int[] {1, 2, 3}),
				Arguments.of(4, new int[] {0, 1, 0, 1, 1, 1, 0}, new int[] {1, 2, 3, 4, 5, 6, 7}) //
		);
	}

	@ParameterizedTest
	@MethodSource
	void test_corners(int E, int[] A, int[] X) {
		assertEquals(E, testObject.solution(A, X));
	}

	@ParameterizedTest
	@MethodSource(value = "test_corners")
	void test_corners_reverse(int E, int[] A, int[] X) {
		A = reverse(A);
		assertEquals(E, testObject.solution(A, X));
	}

	static Stream<Arguments> test_corners() {
		return Stream.of( //
				Arguments.of(1, new int[] {0}, new int[] {1}), //
				Arguments.of(2, new int[] {1, 1}, new int[] {1, 2}), //
				Arguments.of(2, new int[] {0, 1}, new int[] {1, 2}), //
				Arguments.of(1, new int[] {1, 5}, new int[] {1, 100}), //
				Arguments.of(2, new int[] {0, 5}, new int[] {1, 4})//
		);
	}

	@ParameterizedTest
	@MethodSource
	void test_skips(int E, int[] A, int[] X) {
		assertEquals(E, testObject.solution(A, X));
	}

	@ParameterizedTest
	@MethodSource(value = "test_skips")
	void test_skips_reverse(int E, int[] A, int[] X) {
		A = reverse(A);
		assertEquals(E, testObject.solution(A, X));
	}

	static Stream<Arguments> test_skips() {
		return Stream.of( //
				Arguments.of(4, new int[] {0, 3, 0, 1, 0}, new int[] {1, 2, 3, 4, 5}), //
				Arguments.of(5, new int[] {0, 4, 0, 1, 0}, new int[] {1, 2, 3, 4, 5}), //
				Arguments.of(6, new int[] {0, 4, 0, 2, 0, 0}, new int[] {1, 2, 3, 4, 5, 6}), //
				Arguments.of(5, new int[] {0, 0, 4, 0, 1, 0}, new int[] {1, 2, 3, 4, 5, 6}), //
				Arguments.of(5, new int[] {0, 0, 1, 0, 4, 0}, new int[] {1, 2, 3, 4, 5, 6}), //
				Arguments.of(6, new int[] {0, 0, 0, 4, 0, 3, 0, 0}, new int[] {1, 2, 3, 4, 5, 6, 7, 8}), //
				Arguments.of(5, new int[] {0, 0, 2, 0, 2}, new int[] {1, 2, 3, 4, 5}), //
				Arguments.of(2, new int[] {0, 5}, new int[] {1, 2})//
		);
	}

	@ParameterizedTest
	@MethodSource
	void test_straights(int E, int[] A, int[] X) {
		assertEquals(E, testObject.solution(A, X));
	}

	static Stream<Arguments> test_straights() {
		return Stream.of( //
				Arguments.of(5, new int[] {1, 1, 1, 1, 1}, new int[] {1, 2, 3, 4, 5}), //
				Arguments.of(5, new int[] {2, 0, 2, 0, 2}, new int[] {1, 2, 3, 4, 5}), //
				Arguments.of(3, new int[] {2, 2, 2}, new int[] {1, 3, 5}), //
				Arguments.of(3, new int[] {3, 3, 3}, new int[] {2, 4, 7}), //
				Arguments.of(7, new int[] {3, 0, 0, 3, 0, 0, 3}, new int[] {1, 2, 3, 4, 5, 6, 7}) //
		);
	}

	@ParameterizedTest
	@MethodSource
	void test_mountains(int E, int[] A, int[] X) {
		assertEquals(E, testObject.solution(A, X));
	}

	static Stream<Arguments> test_mountains() {
		return Stream.of( //
				Arguments.of(4, new int[] {0, 0, 5, 0, 0}, new int[] {1, 2, 3, 4, 5}), //
				Arguments.of(4, new int[] {0, 3, 0, 0, 0, 3, 0}, new int[] {1, 2, 3, 4, 5, 6, 7}), //
				Arguments.of(2, new int[] {1, 0, 0, 1}, new int[] {1, 2, 3, 4}), //
				Arguments.of(5, new int[] {1, 0, 100, 0, 1}, new int[] {1, 2, 3, 4, 5}), //
				Arguments.of(3, new int[] {1, 100, 1}, new int[] {1, 3, 5}), //
				Arguments.of(9, //
						new int[] {1, 0, 1, 0, 100000, 0, 1, 2, 3}, new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9}) //
		);
	}

	@ParameterizedTest
	@MethodSource
	void test_mountains2(int E, int[] A, int[] X) {
		assertEquals(E, testObject.solution(A, X));
	}

	static Stream<Arguments> test_mountains2() {
		return Stream.of( //
				Arguments.of(7, //
						new int[] {0, 0, 0, 9, 0, 0, 0}, new int[] {1, 2, 3, 4, 5, 6, 7}),
				Arguments.of(7, //
						new int[] {0, 0, 0, 0, 9, 0, 0, 0}, new int[] {1, 2, 3, 4, 5, 6, 7, 8}),
				Arguments.of(7, //
						new int[] {0, 0, 0, 9, 0, 0, 0, 0}, new int[] {1, 2, 3, 4, 5, 6, 7, 8}),
				Arguments.of(9, //
						new int[] {0, 0, 0, 0, 100000, 0, 0, 0, 0}, new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9}), //
				Arguments.of(12, //
						new int[] {0, 0, 0, 0, 14, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
						new int[] {1, 2, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 21}) //
		);
	}

	@Test
	@DisplayName("Our Sample 1")
	void test04() {
		int[] A = new int[] {1, 1, 1, 1};
		int[] X = new int[] {1, 3, 5, 6};
		int E = 2;

		assertEquals(E, testObject.solution(A, X));
	}

	@Test
	void test_long_1() {
		int n = 700;
		int[] A = new int[n];
		int[] X = new int[n];
		for (int i = 0; i < n; i++) {
			A[i] = 1;
			X[i] = i;
		}

		int E = n;
		assertTimeoutPreemptively(getTimeoutDuration(),
				() -> assertEquals(E, testObject.solution(A, X)));
	}


	@Test
	void test_long_2() {
		int n = 700;
		int[] A = new int[n];
		int[] X = new int[n];
		for (int i = 0; i < n; i++) {
			A[i] = 0;
			X[i] = i;
		}
		A[0] = n;

		int E = n;

		assertTimeoutPreemptively(getTimeoutDuration(),
				() -> assertEquals(E, testObject.solution(A, X)));
	}

	@Test
	void test_long_3() {
		int n = 700;
		int[] A = new int[n];
		int[] X = new int[n];
		for (int i = 0; i < n; i++) {
			A[i] = (i % 2 == 0) ? 2 : 0;
			X[i] = i;
		}

		int E = n;

		assertTimeoutPreemptively(getTimeoutDuration(),
				() -> assertEquals(E, testObject.solution(A, X)));
	}

}
