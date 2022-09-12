package com.example.data;

public class Standard {
    private String standard;
    private String section;

    public Standard() {
    }

    public Standard(String standard, String section) {
        this.standard = standard;
        this.section = section;
    }

    public String getStandard() {
        return standard;
    }

    public void setStandard(String standard) {
        this.standard = standard;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    @Override
    public String toString() {
        return "Standard{" +
                "standard='" + standard + '\'' +
                ", section='" + section + '\'' +
                '}';
    }
}
