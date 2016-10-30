package com.example.hibernate;

import com.example.entity.Friend;
import com.example.entity.User;
import com.example.entity.User;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Seryang on 2016. 10. 30..
 */
@Repository
@Transactional
public class FriendRepository extends BaseRepository{

    public void add(Friend friend) {
        getSession().saveOrUpdate(friend);
    }

    public void delete(Friend friend) {
        getSession().delete(friend);
    }

    public User selectUser(String userId) {
        return (User) getSession().createCriteria(User.class).add(Restrictions.idEq(userId)).uniqueResult();
    }

    public List<Friend> selectFriendList(String myId) {
        return getSession().createCriteria(Friend.class).add(Restrictions.eq("userId", myId)).list();

    }
}
