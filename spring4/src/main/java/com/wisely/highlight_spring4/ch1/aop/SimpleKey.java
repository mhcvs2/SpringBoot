package com.wisely.highlight_spring4.ch1.aop;

import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

import java.io.Serializable;
import java.util.Arrays;

public class SimpleKey implements Serializable {
    public static final com.wisely.highlight_spring4.ch1.aop.SimpleKey EMPTY = new com.wisely.highlight_spring4.ch1.aop.SimpleKey(new Object[0]);
    private final Object[] params;
    private final int hashCode;

    public SimpleKey(Object... elements) {
        Assert.notNull(elements, "Elements must not be null");
        this.params = new Object[elements.length];
        System.arraycopy(elements, 0, this.params, 0, elements.length);
        this.hashCode = Arrays.deepHashCode(this.params);
    }

    public boolean equals(Object obj) {
        return this == obj || obj instanceof com.wisely.highlight_spring4.ch1.aop.SimpleKey && Arrays.deepEquals(this.params, ((com.wisely.highlight_spring4.ch1.aop.SimpleKey)obj).params);
    }

    public final int hashCode() {
        return this.hashCode;
    }

    public String toString() {
        return this.getClass().getSimpleName() + " [" + StringUtils.arrayToCommaDelimitedString(this.params) + "]";
    }
}