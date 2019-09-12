package com.jiaflu.graphql.resolver;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.jiaflu.graphql.entity.User;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class UserMutation implements GraphQLMutationResolver {
    private static Map<Integer, User> userMap = new HashMap<>();

    static {
        userMap.put(1, new User(1, "admin", "pass", 18));
        userMap.put(2, new User(2, "admin2", "pass2", 21));
        userMap.put(3, new User(3, "admin3", "pass3", 23));
    }

    public boolean saveUser(User user) {
        System.out.println("save");
        userMap.put(user.getId(), user);
        printMap();
        return true;
    }

    public boolean deleteUser(Integer id) {
        System.out.println("delete");
        userMap.remove(id);
        printMap();
        return true;
    }

    public boolean updateUser(User user) {
        System.out.println("update");
        User localUser = userMap.get(user.getId());
        if (user.getAge() != 0) {
            localUser.setAge(user.getAge());
        }
        if (!StringUtils.isEmpty(user.getPassword())) {
            localUser.setPassword(user.getPassword());
        }
        if (!StringUtils.isEmpty(user.getUsername())) {
            localUser.setUsername(user.getUsername());
        }

        userMap.put(user.getId(), localUser);
        printMap();
        return true;

    }

    private void printMap() {
        userMap.forEach((id, user) ->System.out.println("id[" + id + "] => " + user.toString()));
    }
}
