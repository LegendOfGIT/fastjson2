package com.alibaba.fastjson2.annotation;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NamingStrategyTest {

    private static List<Arguments> snakeToCamel() {

        return List.of(
            Arguments.of(null, null),
            Arguments.of("", ""),
            Arguments.of("abBccC", "abBccC"),
            Arguments.of("a_Bb_CCc", "aBbCCc"),
            Arguments.of("a_bb_ccc", "aBbCcc"),
            Arguments.of("a_Bb _  CCc", "aBb   CCc"),
            Arguments.of("a_B%_CC!", "aB%CC!"));

    }

    @ParameterizedTest(name = "given name: {0}")
    @MethodSource
    public void snakeToCamel(String given, String excepted) {

        assertEquals(
            excepted,
            NamingStrategy.snakeToCamel(given));

    }

}
