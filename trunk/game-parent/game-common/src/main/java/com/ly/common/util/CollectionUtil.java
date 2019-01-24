package com.ly.common.util;

import java.util.Collection;
import java.util.Map;

public class CollectionUtil {

    public static boolean isEmpty(Collection<?> value) {
        return value == null || value.isEmpty();
    }

    public static boolean isEmpty(Map<?, ?> value) {
        return value == null || value.isEmpty();
    }

    public static boolean isNotEmpty(Collection<?> value) {
        return !isEmpty(value);
    }

    public static boolean isNotEmpty(Map<?, ?> value) {
        return !isEmpty(value);
    }
}
