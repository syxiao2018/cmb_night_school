package com.gradle.study.util;

import org.junit.Test;

import java.util.Locale;

import static org.assertj.core.api.Assertions.assertThat;


public class LocaleUtilsTest {

    @Test
    public void should_return_null_locale_when_pass_null() {
        // given
        String str = null;
        LocaleUtils utils = new LocaleUtils();

        // when
        Locale result = utils.toLocale(str);

        // then
        assertThat(result).isNull();
    }

    @Test
    public void should_return_empty_locale_when_pass_empty() {
        // given
        String str = "";
        LocaleUtils utils = new LocaleUtils();

        // when
        Locale result = utils.toLocale(str);

        // then
        assertThat(result.getLanguage()).isEqualTo("");
        assertThat(result.getCountry()).isEqualTo("");
    }

    @Test(expected = IllegalArgumentException.class)
    public void should_throw_IAE_when_arg_include_jin() {
        // given
        String str = "######";
        LocaleUtils utils = new LocaleUtils();

        // when
        utils.toLocale(str);

        // then
    }

    @Test(expected = IllegalArgumentException.class)
    public void should_throw_IAE_when_arg_length_low_than_2() {
        // given
        String str = "x";
        LocaleUtils utils = new LocaleUtils();

        // when
        utils.toLocale(str);

        // then
    }

    @Test(expected = IllegalArgumentException.class)
    public void should_throw_IAE_when_arg_length_low_than_3_and_start_with_xia() {
        // given
        String str = "_x";
        LocaleUtils utils = new LocaleUtils();

        // when
        utils.toLocale(str);

        // then
    }

    @Test(expected = IllegalArgumentException.class)
    public void should_throw_IAE_when_arg_2nd_char_is_not_upper() {
        // given
        String str = "_xx";
        LocaleUtils utils = new LocaleUtils();

        // when
        utils.toLocale(str);

        // then
    }

    @Test
    public void should_return_locale_when_arg_start_with_xia_and_length_eq_3() {
        // given
        String str = "_XX";
        LocaleUtils utils = new LocaleUtils();

        // when
        Locale result = utils.toLocale(str);

        // then
        assertThat(result.getCountry()).isEqualTo("XX");
        assertThat(result.getLanguage()).isEqualTo("");
    }

    @Test(expected = IllegalArgumentException.class)
    public void should_throw_IAE_when_arg_length_low_than_5_and_great_than_3() {
        // given
        String str = "_XXs";
        LocaleUtils utils = new LocaleUtils();

        // when
        utils.toLocale(str);

        // then
    }

    @Test(expected = IllegalArgumentException.class)
    public void should_throw_IAE_when_arg_length_great_than_5_and_4th_not_eq_xia() {
        // given
        String str = "_XXnx";
        LocaleUtils utils = new LocaleUtils();

        // when
        utils.toLocale(str);

        // then
    }

    @Test
    public void should_return_specific_locale_when_arg_start_with_xia_and_exact() {
        // given
        String str = "_XX_ss";
        LocaleUtils utils = new LocaleUtils();

        // when
        Locale result = utils.toLocale(str);

        // then
        assertThat(result.getCountry()).isEqualTo("XX");
        assertThat(result.getLanguage()).isEqualTo("");
        assertThat(result.getVariant()).isEqualTo("ss");
    }

    @Test
    public void should_return_origin_locale_when_arg_is_iso_639_and_arg_length_eq_3() {
        // given
        String str = "xxx";
        LocaleUtils utils = new LocaleUtils();

        // when
        Locale result = utils.toLocale(str);

        // then
        assertThat(result.getLanguage()).isEqualTo("xxx");
    }

    @Test(expected = IllegalArgumentException.class)
    public void should_throw_IAE_when_arg_is_not_iso_639_and_arg_has_upper_case() {
        // given
        String str = "XXx";
        LocaleUtils utils = new LocaleUtils();

        // when
        utils.toLocale(str);

        // then
    }

    @Test
    public void should_return_locale_when_country_is_iso_639_and_iso_3166_and_length_eq_2() {
        // given
        String str = "xx_BB";
        LocaleUtils utils = new LocaleUtils();

        // when
        Locale result = utils.toLocale(str);

        // then
        assertThat(result.getCountry()).isEqualTo("BB");
        assertThat(result.getLanguage()).isEqualTo("xx");
    }

    @Test
    public void should_return_locale_when_country_is_number_code_and_length_eq_3() {
        // given
        String str = "xx_333";
        LocaleUtils utils = new LocaleUtils();

        // when
        Locale result = utils.toLocale(str);

        // then
        assertThat(result.getCountry()).isEqualTo("333");
        assertThat(result.getLanguage()).isEqualTo("xx");
    }

    @Test(expected = IllegalArgumentException.class)
    public void should_throw_IAE_when_country_is_iso_639_and_iso_3166_and_has_lower_case() {
        // given
        String str = "xx_Xx";
        LocaleUtils utils = new LocaleUtils();

        // when
        utils.toLocale(str);

        // then
    }

    @Test(expected = IllegalArgumentException.class)
    public void should_return_locale_when_country_is_iso_639_and_iso_3166_and_number_code_has_letter() {
        // given
        String str = "xx_3A3";
        LocaleUtils utils = new LocaleUtils();

        // when
        utils.toLocale(str);

        // then
    }

    @Test
    public void should_return_locale_when_arg_correct() {
        // given
        String str = "xxx_235_x";
        LocaleUtils utils = new LocaleUtils();

        // when
        Locale result = utils.toLocale(str);

        // then
        assertThat(result.getLanguage()).isEqualTo("xxx");
        assertThat(result.getCountry()).isEqualTo("235");
        assertThat(result.getVariant()).isEqualTo("x");
    }
}