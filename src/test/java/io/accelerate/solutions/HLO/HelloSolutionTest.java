package io.accelerate.solutions.HLO;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class HelloSolutionTest {
    private HelloSolution underTest;

    @BeforeEach
    public void setUp() {
        underTest = new HelloSolution();
    }

    @Test
    public void testHello() {
        assertThat(underTest.hello("Name1"), equalTo("Hello, World!"));
    }

    @ParameterizedTest
    @MethodSource
    public void testHelloStrings(String name, String expectedMessage) {
        assertThat(underTest.hello(name), equalTo(expectedMessage));
    }

    private static Stream<Arguments> testHelloStrings() {
        return Stream.of(
                Arguments.of("Name A", "Hello, World!"),
                Arguments.of("FirstName lastName", "Hello, World!")
        );
    }
}

