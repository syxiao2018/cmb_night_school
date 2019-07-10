package com.gradle.study.util;

import org.junit.Assert;
import org.junit.Test;

public class StringUtilsTest {

    @Test
    public void should_string_is_empty_when_it_is_null() {
        StringUtils stringUtils = new StringUtils("test");
        boolean nullValue = stringUtils.isEmpty(null);
        Assert.assertTrue(nullValue);
    }

    @Test
    public void should_string_is_empty_when_it_is_empty() {
        StringUtils stringUtils = new StringUtils("test");
        boolean emptyValue = stringUtils.isEmpty("");
        Assert.assertTrue(emptyValue);
    }

    @Test
    public void should_string_is_null_when_it_is_blank() {
        StringUtils stringUtils = new StringUtils("test");
        boolean nullValue = stringUtils.isBlank(null);
        Assert.assertTrue(nullValue);
    }

    @Test
    public void should_string_is_empty_when_it_is_blank() {
        StringUtils stringUtils = new StringUtils("test");
        boolean nullValue = stringUtils.isBlank("");
        Assert.assertTrue(nullValue);
    }

    @Test
    public void should_string_is_empty_when_it_has_blank() {
        StringUtils stringUtils = new StringUtils("test");
        boolean blankValue = stringUtils.isBlank(" ");
        Assert.assertTrue(blankValue);
    }

    @Test
    public void should_string_is_empty_when_it_does_not_has_blank() {
        StringUtils stringUtils = new StringUtils("test");
        boolean blankValue = stringUtils.isBlank("notblank");
        Assert.assertFalse(blankValue);
    }

    @Test
    public void should_string_is_not_alpha_when_it_is_empty() {
        StringUtils stringUtils = new StringUtils("test");
        boolean blankValue = stringUtils.isAlpha("");
        Assert.assertFalse(blankValue);
    }

    @Test
    public void should_string_is_not_alpha_when_it_has_num() {
        StringUtils stringUtils = new StringUtils("test");
        boolean value = stringUtils.isAlpha("3d");
        Assert.assertFalse(value);
    }

    @Test
    public void should_string_is_alpha_when_it_is_all_letter() {
        StringUtils stringUtils = new StringUtils("test");
        boolean value = stringUtils.isAlpha("ddd");
        Assert.assertTrue(value);
    }
}