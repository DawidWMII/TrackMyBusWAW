/**
 * @file WarsawApiService.java
 * @brief Interface for the Warsaw Bus System API.
 *
 * Defines methods for communicating with the API using Retrofit.
 */

package pl.creativesstudio.api;

import pl.creativesstudio.models.ApiResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * @interface WarsawApiService
 * @brief Interface for the Warsaw Bus System API.
 *
 * Defines methods for communicating with the external API.
 */
public interface WarsawApiService {

    @GET("api/action/busestrams_get/")

    /**
     * @brief Retrieves data on bus positions.
     *
     * Sends a request to the API and returns a list of bus positions in Warsaw.
     *
     * @param resourceId The resource ID of the API.
     * @param apiKey The API key required for authorization.
     * @param type The type of transport (e.g., bus, tram).
     * @param line (Optional) The bus line to filter by.
     * @param brigade (Optional) The brigade to filter by.
     * @return A {@link Call} object containing the API response data.
     */
    
    Call<ApiResponse> getBuses(
            @Query("resource_id") String resourceId,
            @Query("apikey") String apiKey,
            @Query("type") int type,
            @Query("line") String line,      // Opcjonalny
            @Query("brigade") String brigade // Opcjonalny
    );
}
