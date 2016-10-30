package com.example.service;

import com.example.entity.Friend;
import com.example.entity.User;
import com.example.hibernate.FriendRepository;
import com.example.hibernate.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Seryang on 2016. 10. 30..
 */
@Service
public class FriendService {

    @Autowired
    private FriendRepository friendRepository;

    @Autowired
    private UserRepository userRepository;

    public boolean addFriend(String from, String to) {
        User userInfo = getUserInfo(from);
        User friendInfo = getUserInfo(to);
        Friend friend = new Friend(userInfo.getUserId(), friendInfo.getUserId());
        friendRepository.add(friend);
        return true;
    }

    private User getUserInfo(String userId) {
        return friendRepository.selectUser(userId);
    }

    public boolean deleteFriend(String from, String to) {
        User userInfo = getUserInfo(from);
        User friendInfo = getUserInfo(to);
        Friend friend = new Friend(userInfo.getUserId(), friendInfo.getUserId());
        friendRepository.delete(friend);
        return true;
    }

    public List<User> listFriend(String myId) {
        List<Friend> myFriendList = friendRepository.selectFriendList(myId);
        List<String> friendIdList = new ArrayList<>();
        for(Friend friend : myFriendList){
            friendIdList.add(friend.getFriendId());
        }
        return userRepository.selectFriendList(friendIdList);
    }
}
