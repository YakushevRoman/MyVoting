package com.example.myvoting.app.enums;

public enum TagsEnum {
    TAG ("Voting App");

    private final String mVotingTag;

    TagsEnum(String mVotingTag) {
        this.mVotingTag = mVotingTag;
    }

    public String getmVotingTag() {
        return mVotingTag;
    }
}
