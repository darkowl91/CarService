package com.motors.programm.nav;

import java.io.Serializable;

public final class BreadCrumbs implements Serializable {
    public static final String BEAN_NAME = "BreadCrumbs";

    private String id;
    private String link;
    private String value;

    public BreadCrumbs(String id, String link, String value) {
        this.id = id;
        this.link = link;
        this.value = value;
    }

    public String getId() {
        return id;
    }

    public String getLink() {
        return link;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "BreadCrumbs{" +
                "id='" + id + '\'' +
                ", link='" + link + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
