package com.god;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * Created by feng on 2016/7/9.
 */
public class HangmenTest {
    @Test
    public void show_properties_when_word_is_apple() {
        Hangmen Hangmen = new Hangmen("apple");

        assertThat(Hangmen.str, is("apple"));
        assertThat(Hangmen.strLength, is(5));
        assertThat(Hangmen.times, is(6));
        assertThat(Hangmen.guessedStr, is("iaoue"));
        assertThat(Hangmen.displayedStr, is("a___e"));

    }

    @Test
    public void show_properties_when_word_is_application() {
        Hangmen Hangmen = new Hangmen("application");

        assertThat(Hangmen.str, is("application"));
        assertThat(Hangmen.strLength, is(11));
        assertThat(Hangmen.times, is(12));
        assertThat(Hangmen.guessedStr, is("iaoue"));
        assertThat(Hangmen.displayedStr, is("a___i_a_io_"));
    }


    @Test
    public void show_guess_word_when_guess_char_is_p() {
        Hangmen Hangmen = new Hangmen("apple");

        Hangmen.guessAChar('p');

        assertThat(Hangmen.times, is(5));
        assertThat(Hangmen.guessedStr, is("iaouep"));
        assertThat(Hangmen.displayedStr, is("app_e"));
    }

    @Test
    public void show_false_when_times_out_put() {

        Hangmen Hangmen = new Hangmen("apple");

        Hangmen.guessAChar('p');
        Hangmen.guessAChar('w');
        Hangmen.guessAChar('r');
        Hangmen.guessAChar('t');
        Hangmen.guessAChar('y');
        Hangmen.guessAChar('s');

        assertThat(Hangmen.checkTimes(), is(false));
    }

    @Test
    public void show_propertiex_when_guess_the_same_char() {
        Hangmen Hangmen = new Hangmen("apple");

        Hangmen.guessAChar('p');
        Hangmen.guessAChar('p');

        assertThat(Hangmen.times, is(5));
        assertThat(Hangmen.guessedStr, is("iaouep"));
        assertThat(Hangmen.displayedStr, is("app_e"));
    }

    @Test
    public void show_true_when_guess_right_the_word() {
        Hangmen Hangmen = new Hangmen("apple");

        Hangmen.guessAChar('p');
        Hangmen.guessAChar('l');

        assertThat(Hangmen.guessedStr, is("iaouepl"));
        assertThat(Hangmen.displayedStr, is("apple"));
        assertThat(Hangmen.chenkAnswer(), is(true));
    }

    @Test
    public void show_false_when_guess_wrong_the_word() {
        Hangmen Hangmen = new Hangmen("apple");

        Hangmen.guessAChar('p');
        Hangmen.guessAChar('q');
        Hangmen.guessAChar('w');
        Hangmen.guessAChar('r');
        Hangmen.guessAChar('t');
        Hangmen.guessAChar('y');

        assertThat(Hangmen.chenkAnswer(), is(false));
    }

    @Test
    public void should_return_false_given_apple_when_guess_r() {
        Hangmen Hangmen = new Hangmen("apple");

        Hangmen.guessAChar('r');

        assertThat(Hangmen.times, is(5));
        assertThat(Hangmen.guessedStr, is("iaouer"));
        assertThat(Hangmen.displayedStr, is("a___e"));
        assertThat(Hangmen.chenkAnswer(), is(false));
    }

}