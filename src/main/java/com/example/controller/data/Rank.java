package com.example.controller.data;

import com.example.entity.User;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by Seryang on 2016. 10. 30..
 */
@Getter
@Setter
public class Rank {
    private int rank;
    private User user;

    public Rank() {}

    public Rank(int rank, User user) {
        this.rank = rank;
        this.user = user;
    }
}