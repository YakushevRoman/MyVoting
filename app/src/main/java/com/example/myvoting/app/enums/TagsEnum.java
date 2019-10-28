package com.example.myvoting.app.enums;
/**
 *
 */
public enum TagsEnum {
    TAG ("VotingApp"), BUNDLE ("Bundle");

    private final String mVotingTag;

    TagsEnum(String mVotingTag) {
        this.mVotingTag = mVotingTag;
    }

    public String getVotingTag() {
        return mVotingTag;
    }
}
