package com.droidcba.techorelevamiento.features.families;

/**
 * Created by juancho on 6/6/15.
 */
public class FamilyItem {

    private String id;
    private String bossFirstName;
    private String bossLastName;
    private String street;
    private String streetNumber;
    private String neighborhood;
    private String comments;
    private String phone;
    private String lat;
    private String lng;
    private String status;
    private String pollCount;
    private String priority;

    public FamilyItem() {}

    public FamilyItem(String id, String bossFirstName, String bossLastName, String street, String streetNumber, String phone,
                     String lat, String lng, String status, String pollCount, String priority) {
        this.id = id;
        this.bossFirstName = bossFirstName;
        this.bossLastName = bossLastName;
        this.street = street;
        this.streetNumber = streetNumber;
        this.phone = phone;
        this.lat = lat;
        this.lng = lng;
        this.status = status;
        this.pollCount = pollCount;
        this.priority = priority;
    }

    /**
     *
     * @return
     * The id
     */
    public String getId() {
        return id;
    }

    /**
     *
     * @param id
     * The id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     *
     * @return
     * The bossFirstName
     */
    public String getBossFirstName() {
        return bossFirstName;
    }

    /**
     *
     * @param bossFirstName
     * The bossFirstName
     */
    public void setBossFirstName(String bossFirstName) {
        this.bossFirstName = bossFirstName;
    }

    /**
     *
     * @return
     * The bossLastName
     */
    public String getBossLastName() {
        return bossLastName;
    }

    /**
     *
     * @param bossLastName
     * The bossLastName
     */
    public void setBossLastName(String bossLastName) {
        this.bossLastName = bossLastName;
    }

    /**
     *
     * @return
     * The street
     */
    public String getStreet() {
        return street;
    }

    /**
     *
     * @param street
     * The street
     */
    public void setStreet(String street) {
        this.street = street;
    }

    /**
     *
     * @return
     * The streetNumber
     */
    public String getStreetNumber() {
        return streetNumber;
    }

    /**
     *
     * @param streetNumber
     * The streetNumber
     */
    public void setStreetNumber(String streetNumber) {
        this.streetNumber = streetNumber;
    }

    /**
     *
     * @return
     * The neighborhood
     */
    public String getNeighborhood() {
        return neighborhood;
    }

    /**
     *
     * @param neighborhood
     * The neighborhood
     */
    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    /**
     *
     * @return
     * The comments
     */
    public String getComments() {
        return comments;
    }

    /**
     *
     * @param comments
     * The comments
     */
    public void setComments(String comments) {
        this.comments = comments;
    }

    /**
     *
     * @return
     * The phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     *
     * @param phone
     * The phone
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     *
     * @return
     * The lat
     */
    public String getLat() {
        return lat;
    }

    /**
     *
     * @param lat
     * The lat
     */
    public void setLat(String lat) {
        this.lat = lat;
    }

    /**
     *
     * @return
     * The lng
     */
    public String getLng() {
        return lng;
    }

    /**
     *
     * @param lng
     * The lng
     */
    public void setLng(String lng) {
        this.lng = lng;
    }

    /**
     *
     * @return
     * The status
     */
    public String getStatus() {
        return status;
    }

    /**
     *
     * @param status
     * The status
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     *
     * @return
     * The pollCount
     */
    public String getPollCount() {
        return pollCount;
    }

    /**
     *
     * @param pollCount
     * The pollCount
     */
    public void setPollCount(String pollCount) {
        this.pollCount = pollCount;
    }

    /**
     *
     * @return
     * The priority
     */
    public String getPriority() {
        return priority;
    }

    /**
     *
     * @param priority
     * The priority
     */
    public void setPriority(String priority) {
        this.priority = priority;
    }

}