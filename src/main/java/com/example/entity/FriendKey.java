package com.example.entity;

import java.io.Serializable;

/**
 * Created by Seryang on 2016. 10. 30..
 */
public class FriendKey implements Serializable {
    protected String userId;
    protected String friendId;

    public FriendKey() {}

    public FriendKey(String userId, String friendId) {
        this.userId = userId;
        this.friendId = friendId;
    }
}
