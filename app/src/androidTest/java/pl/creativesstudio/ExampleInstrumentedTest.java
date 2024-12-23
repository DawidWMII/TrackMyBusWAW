package pl.creativesstudio;

import android.content.Context;

import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * @file ExampleInstrumentedTest.java
 * @brief Instrumented tests for the TrackMyBusWAW application.
 *
 * This class contains instrumented tests that run on an Android device or emulator.
 * It verifies the application context and ensures that the app is functioning within the correct system context.
 *
 * @version 1.0
 * @since 2024-12-16
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    /**
     * Tests the application context.
     *
     * This test verifies that the application under test is running in the correct context
     * by checking the package name.
     *
     * @throws Exception If an error occurs during the test.
     */
    @Test
    public void useAppContext() throws Exception {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        assertEquals("pl.creativesstudio", appContext.getPackageName());
    }
}
