package com.jordanmadrigal.tourguideaustin;

/**
 * Class of places that will be put on each card in the app
 */

public class Location {

    private String location;
    private int imgResId = NO_IMAGE_PROVIDED;
    private static final int NO_IMAGE_PROVIDED = -1;
    private int mediaResId;
    private String description;
    private String uriLocation;

    public Location(String location, int imgResId) {
        this.location = location;
        this.imgResId = imgResId;
    }

    public Location(int imgResId, String uriLocation, String description) {
        this.imgResId = imgResId;
        this.uriLocation = uriLocation;
        this.description = description;
    }

    public Location(String location, int imgResId, String description) {
        this.location = location;
        this.imgResId = imgResId;
        this.description = description;
    }


    public Location(String location, int imgResId, String uriLocation, String description) {
        this.location = location;
        this.imgResId = imgResId;
        this.uriLocation = uriLocation;
        this.description = description;
    }

    /**
     *
     * @param location is each place that a tourist can go visit
     * @param imgResId is an resource to be used with each place
     * @param mediaResId is a sound resource associated to specific venue or event
     * @param description is a short description of the place
     */
    public Location(String location, int imgResId, String uriLocation, String description, int mediaResId) {
        this.location = location;
        this.imgResId = imgResId;
        this.mediaResId = mediaResId;
        this.description = description;
        this.uriLocation = uriLocation;
    }

    public String getLocation() {
        return location;
    }

    public int getImgResId() {
        return imgResId;
    }

    public int getMediaResId() {
        return mediaResId;
    }

    public String getDescription() {
        return description;
    }

    public boolean hasImage(){
            return imgResId != NO_IMAGE_PROVIDED;
    }

    public String getUriLocation() {
        return uriLocation;
    }

    public void setUriLocation(String uriLocation) {
        this.uriLocation = uriLocation;
    }
}
