package com.example.projects.configurationObjectCloning;

import java.util.HashMap;
import java.util.Map;

public class ConfigurationPrototypeRegistryImpl implements ConfigurationPrototypeRegistry {
    Map<ConfigurationType, Configuration> prototypes;

    public ConfigurationPrototypeRegistryImpl() {
        prototypes = new HashMap<>();
    }

    public void addPrototype(Configuration user) {
        prototypes.put(user.getType(), user);
    }

    public Configuration getPrototype(ConfigurationType type) {
        return prototypes.get(type);
    }

    public Configuration clone(ConfigurationType type) {
        Configuration configuration = prototypes.get(type);
        return configuration.cloneObject();
    }
}
