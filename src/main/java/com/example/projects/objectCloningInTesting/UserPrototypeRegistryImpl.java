package com.example.projects.objectCloningInTesting;

import java.util.HashMap;
import java.util.Map;

public class UserPrototypeRegistryImpl implements UserPrototypeRegistry {
    private final Map<UserType, User> prototypes;

    public UserPrototypeRegistryImpl() {
        prototypes = new HashMap<>();
    }

    @Override
    public void addPrototype(User user) {
        prototypes.put(user.getType(), user);
    }

    @Override
    public User getPrototype(UserType type) {
        return prototypes.get(type);
    }

    @Override
    public User clone(UserType type) {
        User prototype = prototypes.get(type);
        if (prototype != null) {
            return prototype.cloneObject();
        }
        throw new IllegalArgumentException("No prototype found for type: " + type);
    }
}
