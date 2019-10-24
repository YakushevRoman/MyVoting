package com.example.myvoting.database.Entities;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import java.util.ArrayList;
import java.util.List;

@Entity (tableName = "voting_entity")
public class VotingEntity {

    @PrimaryKey (autoGenerate = true)
    @ColumnInfo  (name = "_id")
    public long id;
    @ColumnInfo (name = "_key")
    public String key;
    @ColumnInfo (name = "_result")
    public int result;

    public VotingEntity(long id, String key, int result) {
        this.id = id;
        this.key = key;
        this.result = result;
    }

    public List<VotingEntity> getVotingEntity (){
        List<VotingEntity> votingEntities = new ArrayList<>();
        int TEXT_THE_WORST = 1;
        int TEXT_GOOD = 2;
        int TEXT_THE_BEST = 3;
        String KEY_THE_WORST = "The_worst";
        String KEY_GOOD = "Good";
        String KEY_THE_BEST = "The_best";

        votingEntities.add(new VotingEntity(1, KEY_THE_WORST, TEXT_THE_WORST));
        votingEntities.add(new VotingEntity(2, KEY_GOOD, TEXT_GOOD));
        votingEntities.add(new VotingEntity(3, KEY_THE_BEST, TEXT_THE_BEST));
        return  votingEntities;
    }

}
