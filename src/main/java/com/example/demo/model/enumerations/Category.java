package com.example.demo.model.enumerations;

public enum Category {
    NOVEL,
    THRILLER,
    HISTORY,
    FANTASY,
    BIOGRAPHY,
    CLASSICS,
    DRAMA;

    public static Category getRandom() {
        return values()[(int) (Math.random() * values().length)];
    }
}
