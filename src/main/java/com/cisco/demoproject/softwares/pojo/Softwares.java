
package com.cisco.demoproject.softwares.pojo;


import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

public class Softwares {
    @Id
    private ObjectId _id;
    private String softwareId;
    private String softwareName;
    private String languageUsed;
    private String createdDate;
    private String owner;
    private String application;

    public String getApplication() {
        return application;
    }

    public void setApplication(String application) {
        this.application = application;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public String getServiceOwner() {
        return serviceOwner;
    }

    public void setServiceOwner(String serviceOwner) {
        this.serviceOwner = serviceOwner;
    }

    private String service;
    private String serviceOwner;
    private int views;



    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }

    public String getSoftwareId() {
        return softwareId;
    }

    public void setSoftwareId(String softwareId) {
        this.softwareId = softwareId;
    }

    public String getSoftwareName() {
        return softwareName;
    }

    public void setSoftwareName(String softwareName) {
        this.softwareName = softwareName;
    }

    public String getLanguageUsed() {
        return languageUsed;
    }

    public void setLanguageUsed(String languageUsed) {
        this.languageUsed = languageUsed;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }
}