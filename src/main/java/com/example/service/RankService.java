package com.example.service;

import com.example.entity.Friend;
import com.example.entity.User;
import com.example.controller.data.Rank;
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
public class RankService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private FriendRepository friendRepository;

    private List<Rank> cacheRankList;

    public boolean bulkInsertUserAndScore(List<User> userList) {
        userRepository.bulkInsertUserAndScore(userList);
        cacheRankList = null;
        return true;
    }

    public List<Rank> selectAllRank() {

        if(cacheRankList != null){
            return cacheRankList;
        }

        cacheRankList = sortRank(userRepository.selectAllUser());

        return cacheRankList;
    }

    public List<Rank> selectFriendRank(String myId) {

        List<Friend> myFriendList = friendRepository.selectFriendList(myId);
        List<String> friendIdList = new ArrayList<>();

        friendIdList.add(myId);

        for(Friend friend : myFriendList){
            friendIdList.add(friend.getFriendId());
        }

        return sortRank(userRepository.selectFriendList(friendIdList));
    }

    public List<Rank> selectMyRank(String userId) {
        List<Rank> userRankList = sortRank(userRepository.selectAllUser());
        for(Rank rank : userRankList){
            if(userId.equals(rank.getUser().getUserId())){
                List<Rank> list = new ArrayList<>();
                list.add(rank);
                return list;
            }
        }
        return null;
    }

    private List<Rank> sortRank(List<User> userList){
        if(userList == null || userList.size() == 0) return null;

        List<Rank> rankList = new ArrayList<>();

        int beforeRank = 0;
        int beforeScore = 0;

        for(int i = 1 ; i <= userList.size() ; i++){
            int score = userList.get(i-1).getScore();

            if(score == beforeScore){
                rankList.add(new Rank(beforeRank, userList.get(i - 1)));
            }else{
                rankList.add(new Rank(i, userList.get(i - 1)));
                beforeRank = i;
                beforeScore = score;
            }
        }
        return rankList;
    }
}
