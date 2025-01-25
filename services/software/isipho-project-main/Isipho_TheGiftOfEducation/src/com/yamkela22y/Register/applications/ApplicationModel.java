
package com.yamkela22y.Register.applications;

/**
 *
 * @author yamkela
 */
public class ApplicationModel {
    private String university;
    private String province;
    private float ApplicationFee;
    private String applicationLink;

    public ApplicationModel(String university, String province, float ApplicationFee, String applicationLink) {
        this.university = university;
        this.province = province;
        this.ApplicationFee = ApplicationFee;
        this.applicationLink = applicationLink;
    }

    
    
    public ApplicationModel() {
        
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public float getApplicationFee() {
        return ApplicationFee;
    }

    public void setApplicationFee(float ApplicationFee) {
        this.ApplicationFee = ApplicationFee;
    }

    public String getApplicationLink() {
        return applicationLink;
    }

    public void setApplicationLink(String applicationLink) {
        this.applicationLink = applicationLink;
    }
    
    
}
