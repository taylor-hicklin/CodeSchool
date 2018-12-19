package com.sg.commandmodel.organization.createorg;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;

public class CreateOrgCmdModel {

    @NotEmpty(message = "Field cannot be empty.")
    @Length(max = 50, message = "No more than 50 characters allowed")
    private String name;

    @NotNull(message = "Please select a location")
    private Long locationId;

    @NotEmpty(message = "Field cannot be empty.")
    @Length(max = 255, message = "No more than 255 characters allowed")
    private String description;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getLocationId() {
        return locationId;
    }

    public void setLocationId(Long locationId) {
        this.locationId = locationId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
