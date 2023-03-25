package com.rtlab.babyname;

public class Name {

    private String name;
    private String meaning;

    public Name(String name, String meaning) {
        this.name = name;
        this.meaning = meaning;
    }

    public String getName() {
        return name;
    }

    public String getMeaning() {
        return meaning;
    }
}
