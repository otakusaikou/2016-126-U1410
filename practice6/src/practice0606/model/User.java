package practice0606.model;

import java.io.Serializable;

@SuppressWarnings("serial")
public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    private String name;
    private String address;
    private String phoneNumber;
    private String education;
    private String[] exercise;
    private String[] leisure;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public String getEducation() {
        return education;
    }
    public void setEducation(String education) {
        this.education = education;
    }
    public String[] getExercise() {
        return exercise;
    }
    public void setExercise(String[] exercise) {
        this.exercise = exercise;
    }
    public String[] getLeisure() {
        return leisure;
    }
    public void setLeisure(String[] leisure) {
        this.leisure = leisure;
    }
}
