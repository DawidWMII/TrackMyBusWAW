package pl.creativesstudio.models;

import com.google.gson.annotations.SerializedName;
/**
 * @file Bus.java
 * @brief Model representing a bus on the map.
 *
 * This class stores details about bus lines, location, and departure time.
 * It maps the JSON response from the API to Java objects using Gson annotations.
 *
 * @version 1.0
 * @since 2024-12-16
 */
public class Bus {
    /**
     * The bus lines assigned to this bus.
     */
    @SerializedName("Lines")
    private String lines;
    /**
     * The longitude of the bus's current location.
     */
    @SerializedName("Lon")
    private double lon;
    /**
     * The latitude of the bus's current location.
     */
    @SerializedName("Lat")
    private double lat;
    /**
     * The departure time of the bus.
     */
    @SerializedName("Time")
    private String time;
    /**
     * The unique vehicle number of the bus.
     */
    @SerializedName("VehicleNumber")
    private String vehicleNumber;
    /**
     * The brigade assigned to the bus.
     */
    @SerializedName("Brigade")
    private String brigade;

    /**
     * Retrieves the bus lines assigned to this bus.
     *
     * @return The bus lines.
     */
    // Getters and Setters
    public String getLines() { return lines; }
    /**
     * Sets the bus lines assigned to this bus.
     *
     * @param lines The bus lines to set.
     */
    public void setLines(String lines) { this.lines = lines; }
    /**
     * Retrieves the longitude of the bus's current location.
     *
     * @return The longitude.
     */
    public double getLon() { return lon; }
    /**
     * Sets the longitude of the bus's current location.
     *
     * @param lon The longitude to set.
     */
    public void setLon(double lon) { this.lon = lon; }
    /**
     * Retrieves the latitude of the bus's current location.
     *
     * @return The latitude.
     */
    public double getLat() { return lat; }
    /**
     * Sets the latitude of the bus's current location.
     *
     * @param lat The latitude to set.
     */
    public void setLat(double lat) { this.lat = lat; }
    /**
     * Retrieves the departure time of the bus.
     *
     * @return The departure time.
     */
    public String getTime() { return time; }
    /**
     * Sets the departure time of the bus.
     *
     * @param time The departure time to set.
     */
    public void setTime(String time) { this.time = time; }
    /**
     * Retrieves the unique vehicle number of the bus.
     *
     * @return The vehicle number.
     */
    public String getVehicleNumber() { return vehicleNumber; }
    /**
     * Sets the unique vehicle number of the bus.
     *
     * @param vehicleNumber The vehicle number to set.
     */
    public void setVehicleNumber(String vehicleNumber) { this.vehicleNumber = vehicleNumber; }
    /**
     * Retrieves the brigade assigned to the bus.
     *
     * @return The brigade.
     */
    public String getBrigade() { return brigade; }
    /**
     * Sets the brigade assigned to the bus.
     *
     * @param brigade The brigade to set.
     */
    public void setBrigade(String brigade) { this.brigade = brigade; }
}
