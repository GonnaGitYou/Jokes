package com.example.test;

import com.example.Jester;
import org.junit.Test;

/**
 * @author Dr. Ken
 */


public class JesterTest {
    @Test
    public void test() {
        Jester joker = new Jester();
        assert joker.tellAJoke().length() != 0;
    }

}
