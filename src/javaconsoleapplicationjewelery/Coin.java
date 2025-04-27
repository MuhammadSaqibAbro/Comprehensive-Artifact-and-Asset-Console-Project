/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author SAQIB
 */
package javaconsoleapplicationjewelery;
import java.util.Date;

public class Coin {
    private int id;
    private double latitude;
    private double longitude;
    private int finderId;
    private Date foundDate;
    private int estimatedYear;
    private int museumId;
    private String denomination;
    private String material;

    public Coin(int id, double latitude, double longitude, int finderId, Date foundDate,
                int estimatedYear, int museumId, String denomination, String material) {
        this.id = id;
        this.latitude = latitude;
        this.longitude = longitude;
        this.finderId = finderId;
        this.foundDate = foundDate;
        this.estimatedYear = estimatedYear;
        this.museumId = museumId;
        this.denomination = denomination;
        this.material = material;
    }

    public int getId() {
        return id;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public int getFinderId() {
        return finderId;
    }

    public Date getFoundDate() {
        return foundDate;
    }

    public int getEstimatedYear() {
        return estimatedYear;
    }

    public int getMuseumId() {
        return museumId;
    }

    public String getDenomination() {
        return denomination;
    }

    public String getMaterial() {
        return material;
    }
}


