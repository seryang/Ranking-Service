package com.example;

import com.example.entity.User;
import com.example.controller.data.Rank;
import com.example.entity.User;

import java.util.*;

/**
 * Created by Seryang on 2016. 10. 30..
 */
public class Main {

    public static void main(String [] args){
        List<User> list = new ArrayList<>();
        list.add(new User("a", 100));
        list.add(new User("a", 100));
        list.add(new User("a", 100));
        list.add(new User("a", 100));
        list.add(new User("a", 100));
        list.add(new User("a", 100));
        list.add(new User("a", 100));
        list.add(new User("a", 100));
        list.add(new User("a", 100));
        list.add(new User("b", 90));


        System.out.println(sortRank(list));
    }

    public static List<Rank> sortRank(List<User> userList){

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
