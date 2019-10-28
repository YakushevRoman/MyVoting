package com.example.myvoting.app.enums;
/**
 *
 */
public enum AppVotingEnum {

    KEY_THE_WORST (1) ,
    KEY_GOOD (2),
    KEY_THE_BEST (3);

    private final int value;

    AppVotingEnum(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
