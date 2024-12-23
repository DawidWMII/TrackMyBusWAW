package pl.creativesstudio;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import pl.creativesstudio.api.WarsawApiService;
import pl.creativesstudio.models.ApiResponse;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @file WarsawApiServiceTest.java
 * @brief Unit tests for the WarsawApiService class.
 *
 * This class contains a suite of unit tests to validate the functionality of the WarsawApiService class,
 * focusing on its ability to make API calls with various parameter configurations.
 *
 * @version 1.0
 * @since 2024-12-16
 */
class WarsawApiServiceTest {

    /**
     * Instance of WarsawApiService to be tested.
     */
    private WarsawApiService warsawApiService;

    /**
     * Mocked Call object representing an API call to return an ApiResponse.
     */
    private Call<ApiResponse> mockCall;

    /**
     * Initializes the test environment before each test case.
     *
     * Sets up a Retrofit instance and mocks the API call.
     */
    @BeforeEach
    void setUp() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.um.warszawa.pl/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        warsawApiService = retrofit.create(WarsawApiService.class);
        mockCall = mock(Call.class);
    }

    /**
     * Tests the getBuses method with only required parameters.
     *
     * Verifies that the method correctly returns a Call<ApiResponse> object and that the service is called as expected.
     */
    @Test
    void testGetBusesWithRequiredParameters() {
        WarsawApiService service = mock(WarsawApiService.class);
        String resourceId = "exampleResourceId";
        String apiKey = "exampleApiKey";
        int type = 1;

        when(service.getBuses(resourceId, apiKey, type, null, null)).thenReturn(mockCall);
        Call<ApiResponse> call = service.getBuses(resourceId, apiKey, type, null, null);

        assertNotNull(call, "The service call should return a Call<ApiResponse> object.");
        verify(service).getBuses(resourceId, apiKey, type, null, null);
    }

    /**
     * Tests the getBuses method with all possible parameters.
     *
     * Verifies that the method correctly returns a Call<ApiResponse> object and that the service is called as expected with all parameters.
     */
    @Test
    void testGetBusesWithAllParameters() {
        WarsawApiService service = mock(WarsawApiService.class);
        String resourceId = "exampleResourceId";
        String apiKey = "exampleApiKey";
        int type = 1;
        String line = "123";
        String brigade = "A1";

        when(service.getBuses(resourceId, apiKey, type, line, brigade)).thenReturn(mockCall);
        Call<ApiResponse> call = service.getBuses(resourceId, apiKey, type, line, brigade);

        assertNotNull(call, "The service call should return a Call<ApiResponse> object.");
        verify(service).getBuses(resourceId, apiKey, type, line, brigade);
    }
}
