package com.example.myvoting.data.Entities;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class VotingEntity {
    @PrimaryKey (autoGenerate = true)
    public int uid;
    public int idUser;
    public int answer;
    public String currentDate;
    public String currentTime;

}
