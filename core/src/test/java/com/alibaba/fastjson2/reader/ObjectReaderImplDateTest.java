package com.alibaba.fastjson2.reader;

import com.alibaba.fastjson2.annotation.NamingStrategy;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;

public class ObjectReaderImplDateTest {

    @Test
    public void snakeToCamel() {

        assertInstanceOf(
            ObjectReaderImplDate.class,
            ObjectReaderImplDate.of(null, null));

    }

}
