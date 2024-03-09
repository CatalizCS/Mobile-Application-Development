package com.tama.android;

public class JobModel {
    private String jobTitle;
    private String jobDescription;
    private String jobDate;
    private String jobTime;

    public JobModel(String jobTitle, String jobDescription, String jobDate, String jobTime) {
        this.jobTitle = jobTitle;
        this.jobDescription = jobDescription;
        this.jobDate = jobDate;
        this.jobTime = jobTime;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getJobDescription() {
        return jobDescription;
    }

    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }

    public String getJobDate() {
        return jobDate;
    }

    public void setJobDate(String jobDate) {
        this.jobDate = jobDate;
    }

    public String getJobTime() {
        return jobTime;
    }

    public void setJobTime(String jobTime) {
        this.jobTime = jobTime;
    }

    @Override
    public String toString() {
        return jobTitle + " - " + jobDescription + " - " + jobDate + " - " + jobTime;
    }
}
