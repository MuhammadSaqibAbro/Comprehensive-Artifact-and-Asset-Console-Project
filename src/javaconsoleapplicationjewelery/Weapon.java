/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaconsoleapplicationjewelery;

/**
 *
 * @author SAQIB
 */
import java.util.Date;

public class Weapon {
    private int id;
    private double latitude;
    private double longitude;
    private int finderId;
    private Date foundDate;
    private int estimatedYear;
    private int museumId;
    private String type;
    private String material;
    private int damageRating;

    public Weapon(int id, double latitude, double longitude, int finderId, Date foundDate, int estimatedYear, int museumId, String type, String material, int damageRating) {
        this.id = id;
        this.latitude = latitude;
        this.longitude = longitude;
        this.finderId = finderId;
        this.foundDate = foundDate;
        this.estimatedYear = estimatedYear;
        this.museumId = museumId;
        this.type = type;
        this.material = material;
        this.damageRating = damageRating;
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

    public String getType() {
        return type;
    }

    public String getMaterial() {
        return material;
    }

    public int getDamageRating() {
        return damageRating;
    }
}

