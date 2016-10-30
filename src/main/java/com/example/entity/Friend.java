package com.example.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Seryang on 2016. 10. 30..
 */
@Getter
@Setter
@Entity
@IdClass(FriendKey.class)
@Table(name = "friend", schema = "smilegate")
public class Friend implements Serializable{

    @Id
    @Column(name = "user_id")
    private String userId;

    @Id
    @Column(name = "friend_id")
    private String friendId;

    public Friend(){}

    public Friend(String from, String to) {
        this.userId = from;
        this.friendId = to;
    }
}
