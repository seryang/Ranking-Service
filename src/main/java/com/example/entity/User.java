package com.example.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * Created by Seryang on 2016. 10. 30..
 */
@Getter
@Setter
@Entity
@Table(name = "user", schema = "smilegate")
public class User {

    @Id
    @Column(name = "user_id")
    private String userId;

    @Column(name = "score")
    private Integer score;

    public User(){}

    public User(String userId, int score) {
        this.userId = userId;
        this.score = score;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("RankUser{");
        sb.append("userId='").append(userId).append('\'');
        sb.append(", score=").append(score);
        sb.append('}');
        return sb.toString();
    }
}
