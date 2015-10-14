package com.afk.twitteru;



import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;

import static junit.framework.Assert.assertEquals;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */@RunWith(RobolectricGradleTestRunner.class)
   @Config(constants = BuildConfig.class, emulateSdk = 21)
   public class ApplicationTest {

    @Test
    public void testFoo() {
        // test passes
        assertEquals("+Achievements+","+Achievements+");
        // Assert.fail();
    }
}