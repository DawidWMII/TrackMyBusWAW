package pl.creativesstudio.models;

import com.google.gson.annotations.SerializedName;
import java.util.List;
/**
 * @file ApiResponse.java
 * @brief Represents the response from the Warsaw API.
 *
 * This class holds the data returned by the API, which is utilized by the application.
 * It maps the JSON response to Java objects using Gson annotations.
 *
 * @version 1.0
 * @since 2024-12-16
 */

public class ApiResponse {
    /**
     * The result list containing bus information from the API response.
     */
    @SerializedName("result")
    private List<Bus> result;

    /**
     * Retrieves the result from the API response.
     *
     * @return The list of Bus objects representing the API response.
     */
    public List<Bus> getResult() { return result; }
    /**
     * Sets the result in the API response.
     *
     * @param result The list of Bus objects to set as the API response.
     */
    public void setResult(List<Bus> result) { this.result = result; }
}
