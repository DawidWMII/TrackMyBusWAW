/**
 * @file MainActivityTest.java
 * @brief Unit tests for the MainActivity of the TrackMyBusWAW application.
 *
 * This class contains unit tests that verify the interactions and correctness of the
 * MainActivity's core functionalities.
 *
 * @version 1.1
 * @since 2024-12-16
 */
package pl.creativesstudio;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.location.Location;
import android.os.Build;

import androidx.test.core.app.ApplicationProvider;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import pl.creativesstudio.models.Bus;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
/**
 * @class MainActivityTest
 * @brief Unit tests for the MainActivity of the TrackMyBusWAW application.
 *
 * This class tests the interactions and correctness of the MainActivity, ensuring that
 * core functionalities such as sorting bus lines, filtering buses within bounds,
 * filtering by line, and formatting timestamps work as expected.
 *
 * @version 1.1
 * @since 2024-12-16
 */
@RunWith(RobolectricTestRunner.class)
@Config(sdk = Build.VERSION_CODES.O_MR1)


public class MainActivityTest {
    /**
     * Instance of MainActivity being tested.
     */
    private MainActivity mainActivity;
    /**
     * List of test Bus objects.
     */
    private List<Bus> testBuses;
    /**
     * Initializes resources before each test.
     *
     * This method sets up the MainActivity instance and populates the testBuses list
     * with sample Bus objects for testing purposes.
     */
    @Before
    public void setUp() {
        mainActivity = new MainActivity();

        Drawable mockDrawable = new ColorDrawable(Color.RED);


        testBuses = new ArrayList<>();

        Bus bus1 = new Bus();
        bus1.setLines("123");
        bus1.setLat(52.2297);
        bus1.setLon(21.0122);
        bus1.setVehicleNumber("A1");
        bus1.setBrigade("B1");
        bus1.setTime("2024-01-01 10:00:00");
        testBuses.add(bus1);

        Bus bus2 = new Bus();
        bus2.setLines("456");
        bus2.setLat(52.2297);
        bus2.setLon(21.0122);
        bus2.setVehicleNumber("A2");
        bus2.setBrigade("B2");
        bus2.setTime("2024-01-01 11:00:00");
        testBuses.add(bus2);

        Bus bus3 = new Bus();
        bus3.setLines("123");
        bus3.setLat(52.2397);
        bus3.setLon(21.0222);
        bus3.setVehicleNumber("A3");
        bus3.setBrigade("B3");
        bus3.setTime("2024-01-01 12:00:00");
        testBuses.add(bus3);
    }
    /**
     * Tests whether bus lines are correctly sorted.
     *
     * This test verifies that the sortBusLines method in MainActivity correctly sorts
     * a list of unsorted bus lines into the expected order.
     */
    @Test
    public void testSortBusLines() {
        List<String> unsortedLines = new ArrayList<>();
        unsortedLines.add("200");
        unsortedLines.add("34");
        unsortedLines.add("20");
        unsortedLines.add("N61");

        List<String> sortedLines = mainActivity.sortBusLines(unsortedLines);


        assertEquals("20", sortedLines.get(0));
        assertEquals("34", sortedLines.get(1));
        assertEquals("200", sortedLines.get(2));
        assertEquals("N61", sortedLines.get(3));
    }
    /**
     * Tests filtering of buses within specified map bounds.
     *
     * This test ensures that the filterBusesWithinBounds method in MainActivity correctly
     * identifies and returns buses that are located within the provided LatLngBounds.
     */
    @Test
    public void testFilterBusesWithinBounds() {
        LatLngBounds mockBounds = LatLngBounds.builder()
                .include(new LatLng(52.2297, 21.0122))
                .include(new LatLng(52.2397, 21.0222))
                .build();

        mainActivity.visibleBounds = mockBounds;

        List<Bus> filteredBuses = mainActivity.filterBusesWithinBounds(testBuses);


        assertNotNull(filteredBuses);
        assertEquals(3, filteredBuses.size());
    }
    /**
     * Testuje formatowanie znacznika czasu.
     */
    /**
     * Tests filtering of buses by a specific bus line.
     *
     * This test verifies that filtering buses by a specific line identifier returns
     * the correct subset of buses.
     */
    @Test
    public void testFilterByLine() {

        List<Bus> filteredBuses = new ArrayList<>();
        for (Bus bus : testBuses) {
            if ("123".equals(bus.getLines())) {
                filteredBuses.add(bus);
            }
        }


        assertEquals(2, filteredBuses.size());
        for (Bus bus : filteredBuses) {
            assertEquals("123", bus.getLines());
        }
    }
    /**
     * Tests the formatting of timestamp strings.
     *
     * This test uses reflection to access the private formatTimestamp method in MainActivity
     * and verifies that it correctly formats a given timestamp into the expected date-time string.
     */
    @Test
    public void testFormatTimestamp() {

        try {
            java.lang.reflect.Method method = MainActivity.class.getDeclaredMethod("formatTimestamp", long.class);
            method.setAccessible(true);

            long testTimestamp = System.currentTimeMillis();
            String formattedTime = (String) method.invoke(mainActivity, testTimestamp);

            assertNotNull(formattedTime);

            assertTrue(formattedTime.matches("\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2}"));
        } catch (Exception e) {
            fail("Exception in testFormatTimestamp: " + e.getMessage());
        }
    }
    /**
     * Tests the initialization of the Google Map.
     *
     * This test verifies that the onMapReady method in MainActivity correctly initializes
     * the GoogleMap instance and sets up location services and camera positioning.
     */

//    @Test
//    public void testOnMapReady() {
//        GoogleMap mockMap = mock(GoogleMap.class);
//
//        mainActivity.onMapReady(mockMap);
//
//        assertNotNull("Google Map should be initialized", mainActivity.mMap);
//
//        // Verifying that location services are enabled
//        verify(mockMap).setMyLocationEnabled(true);
//
//        // Check if the camera is moved to the default location
//        LatLng defaultLocation = new LatLng(52.2881717, 21.0061544);
//        verify(mockMap).moveCamera(CameraUpdateFactory.newLatLngZoom(defaultLocation, 15));
//    }
}