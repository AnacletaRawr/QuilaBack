package com.vuelos.serviciosdevuelo.entities;

import java.sql.Date;
import java.sql.Timestamp;

public class Flight {

    // Declaración de atributos
    private int id;
    private String flightNumber;
    private String oprationAirlines;
    private String departurecity;
    private String arrivalCity;
    private Date dateOfDeparture;
    private Timestamp estimatedDepartureTime;

    // Declaración de Getters and Setters


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getOprationAirlines() {
        return oprationAirlines;
    }

    public void setOprationAirlines(String oprationAirlines) {
        this.oprationAirlines = oprationAirlines;
    }

    public String getDeparturecity() {
        return departurecity;
    }

    public void setDeparturecity(String departurecity) {
        this.departurecity = departurecity;
    }

    public String getArrivalCity() {
        return arrivalCity;
    }

    public void setArrivalCity(String arrivalCity) {
        this.arrivalCity = arrivalCity;
    }

    public Date getDateOfDeparture() {
        return dateOfDeparture;
    }

    public void setDateOfDeparture(Date dateOfDeparture) {
        this.dateOfDeparture = dateOfDeparture;
    }

    public Timestamp getEstimatedDepartureTime() {
        return estimatedDepartureTime;
    }

    public void setEstimatedDepartureTime(Timestamp estimatedDepartureTime) {
        this.estimatedDepartureTime = estimatedDepartureTime;
    }
}
