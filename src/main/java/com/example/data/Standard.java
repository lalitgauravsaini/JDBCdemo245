package com.example.data;

@SuppressWarnings("ALL")
public class Standard {
    private static String standard;
    private static String section;

    public Standard() {
    }

    public Standard(String standard, String section) {
        this.standard = standard;
        this.section = section;
    }

    public static String getStandard() {
        return standard;
    }

    public void setStandard(String standard) {
        this.standard = standard;
    }

    public static String getSection() {
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
