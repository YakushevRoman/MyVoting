package com.example.myvoting.database.Entities;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity (tableName = "result_user_voting")
public class ResultUserVotingEntity {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo (name = "_id")
    private long id;

    @ColumnInfo(name = "_id_user")
    public int mIdUser;

    @ColumnInfo (name = "_result")
    public int mResult;

    @ColumnInfo (name = "_time_result")
    public String mTimeResult;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


}
