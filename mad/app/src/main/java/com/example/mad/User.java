package com.example.mad;

import com.google.firebase.database.IgnoreExtraProperties;

@IgnoreExtraProperties
public class User {
    Integer ID, Total, Available;

    public User() {
    }

    public User(Integer ID, Integer total, Integer available) {
        this.ID = ID;
        Total = total;
        Available = available;
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public Integer getTotal() {
        return Total;
    }

    public void setTotal(Integer total) {
        Total = total;
    }

    public Integer getAvailable() {
        return Available;
    }

    public void setAvailable(Integer available) {
        Available = available;
    }
}
