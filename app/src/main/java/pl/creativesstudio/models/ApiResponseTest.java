package pl.creativesstudio.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @file ApiResponseTest.java
 * @brief Unit tests for the ApiResponse class.
 *
 * This class contains a suite of unit tests to validate the functionality of the ApiResponse class,
 * ensuring proper handling of the result field and operations on the list of Bus objects.
 *
 * @version 1.0
 * @since 2024-12-16
 */
class ApiResponseTest {

    /**
     * Instance of ApiResponse to be tested.
     */
    private ApiResponse apiResponse;

    /**
     * List of Bus objects used as a test fixture.
     */
    private List<Bus> busList;

    /**
     * Initializes the test environment before each test case.
     *
     * Prepares an empty ApiResponse instance and populates a test list of Bus objects.
     */
    @BeforeEach
    void setUp() {
        apiResponse = new ApiResponse();
        busList = new ArrayList<>();

        // Create and add first Bus object
        Bus bus1 = new Bus();
        bus1.setLines("Bus1");
        bus1.setTime("10:00");
        busList.add(bus1);

        // Create and add second Bus object
        Bus bus2 = new Bus();
        bus2.setLines("Bus2");
        bus2.setTime("11:00");
        busList.add(bus2);
    }

    /**
     * Tests that the initial value of the result field in ApiResponse is null.
     */
    @Test
    void testGetResultWhenListIsNull() {
        assertNull(apiResponse.getResult(), "The initial value of result should be null.");
    }

    /**
     * Tests setting a non-null list of Bus objects to the result field.
     *
     * Verifies that the result is updated correctly and the size of the list matches expectations.
     */
    @Test
    void testSetResult() {
        apiResponse.setResult(busList);
        assertNotNull(apiResponse.getResult(), "Result should not be null after setting the list.");
        assertEquals(2, apiResponse.getResult().size(), "The list should contain 2 elements.");
    }

    /**
     * Tests retrieving the result field after setting it with a list of Bus objects.
     *
     * Verifies that the returned list matches the one set previously.
     */
    @Test
    void testGetResultReturnsCorrectList() {
        apiResponse.setResult(busList);
        List<Bus> result = apiResponse.getResult();

        assertNotNull(result, "Result should not be null.");
        assertEquals(busList, result, "The list should match the one that was set.");
    }

    /**
     * Tests overwriting the result field with a new list of Bus objects.
     *
     * Verifies that the previous value is replaced and the new value is correctly stored.
     */
    @Test
    void testSetResultOverwritesPreviousValue() {
        // Create a new list with a single Bus object
        List<Bus> newBusList = new ArrayList<>();
        Bus newBus = new Bus();
        newBus.setLines("Bus3");
        newBus.setTime("12:00");
        newBusList.add(newBus);

        // Set the initial list and then overwrite it
        apiResponse.setResult(busList);
        apiResponse.setResult(newBusList);

        // Validate the updated result field
        assertEquals(1, apiResponse.getResult().size(), "The list should contain one element after overwriting.");
        assertEquals("Bus3", apiResponse.getResult().get(0).getLines(), "The bus name should be Bus3.");
    }
}
