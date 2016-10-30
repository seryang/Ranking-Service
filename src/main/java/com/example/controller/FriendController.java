package com.example.controller;

import com.example.entity.User;
import com.example.service.FriendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by Seryang on 2016. 10. 30..
 */
@Controller
@RequestMapping("/friend")
public class FriendController {

    @Autowired
    private FriendService friendService;

    @RequestMapping(value = "/add")
    @ResponseBody
    public boolean addFriend(String ptop){

        if(!ptop.contains(":")) return false;

        String [] data = ptop.split(":");
        String from = data[0];
        String to = data[1];
        return friendService.addFriend(from, to);
    }

    @RequestMapping(value = "/delete")
    @ResponseBody
    public boolean deleteFriend(String ptop){
        if(!ptop.contains(":")) return false;

        String [] data = ptop.split(":");
        String from = data[0];
        String to = data[1];
        return friendService.deleteFriend(from, to);
    }

    @RequestMapping(value = "/list")
    public String selectFriendList(@RequestParam String myId, Model model){
        List<User> userList = friendService.listFriend(myId);
        model.addAttribute("friendList", userList);
        return "rank";
    }
}