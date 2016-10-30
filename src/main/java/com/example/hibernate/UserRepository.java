package com.example.hibernate;

import com.example.entity.User;
import com.example.entity.User;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Seryang on 2016. 10. 30..
 */
@Repository
@Transactional
public class UserRepository extends BaseRepository{

    private static final int BATCH_SIZE = 100;

    public void  bulkInsertUserAndScore(List<User> userList) {
        Session session = getSession();

        int count = 0;
        for (User user: userList) {
            session.saveOrUpdate(user);

            if (++count == BATCH_SIZE) {
                session.flush();
                session.clear();
            }
        }
    }

    public List<User> selectAllUser() {
        return getSession().createCriteria(User.class)
                .addOrder(Order.desc("score")).list();
    }

    public List<User> selectFriendList(List<String> friendIdList) {
        return getSession().createCriteria(User.class)
                .add(Restrictions.in("userId", friendIdList))
                .addOrder(Order.desc("score")).list();
    }
}
