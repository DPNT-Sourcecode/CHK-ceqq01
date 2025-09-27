package io.accelerate.solutions.SUM;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;


import java.util.stream.Stream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class SumSolutionTest {
    private SumSolution sum;

    @BeforeEach
    public void setUp() {
        sum = new SumSolution();
    }

    @Test
    public void compute_sum() {
        assertThat(sum.compute(1, 1), equalTo(2));
    }

    @ParameterizedTest
    @MethodSource
    public void compute_sums(int x, int y, int expectedSum) {
        assertThat(sum.compute(x, y), equalTo(expectedSum));
    }

    private static Stream<Arguments> compute_sums() {
        return Stream.of(
                Arguments.of(1, 2, 3),
                Arguments.of(10, 20, 30),
                Arguments.of(5, 10, 15),
                Arguments.of(100, 200, 300)
        );
    }
}
