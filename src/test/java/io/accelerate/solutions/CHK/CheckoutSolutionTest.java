package io.accelerate.solutions.CHK;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullSource;

import java.util.stream.Stream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class CheckoutSolutionTest {
    private CheckoutSolution underTest;

    @BeforeEach
    public void setUp() throws Exception {
        underTest = new CheckoutSolution();
    }

    @ParameterizedTest
    @NullSource
    public void whenInvalidInput_thenReturnMinusOne(String skus) {
        assertThat(underTest.checkout(skus), equalTo(-1));
    }

    @ParameterizedTest
    @EmptySource
    public void whenEmptyTrolley_thenZero(String skus) {
        assertThat(underTest.checkout(skus), equalTo(0));
    }

    @ParameterizedTest
    @MethodSource
    public void whenNoOffersApplicable_thenReturnSimpleTotal(String skus, Integer expectedTotal) {
        assertThat(underTest.checkout(skus), equalTo(expectedTotal));
    }

    private static Stream<Arguments> whenNoOffersApplicable_thenReturnSimpleTotal() {
        return Stream.of(
                Arguments.of("AAB", 130)
        );
    }

    @ParameterizedTest
    @MethodSource
    public void whenOnlyOffersApplicable_thenReturnSimpleTotal(String skus, Integer expectedTotal) {
        assertThat(underTest.checkout(skus), equalTo(expectedTotal));
    }

    private static Stream<Arguments> whenOnlyOffersApplicable_thenReturnSimpleTotal() {
        return Stream.of(
                Arguments.of("AAABB", 175)
        );
    }

    @ParameterizedTest
    @MethodSource
    public void whenSomeOffersApplicable_thenReturnSimpleTotal(String skus, Integer expectedTotal) {
        assertThat(underTest.checkout(skus), equalTo(expectedTotal));
    }

    private static Stream<Arguments> whenSomeOffersApplicable_thenReturnSimpleTotal() {
        return Stream.of(
                Arguments.of("AAAABBB", 255)
        );
    }
}

