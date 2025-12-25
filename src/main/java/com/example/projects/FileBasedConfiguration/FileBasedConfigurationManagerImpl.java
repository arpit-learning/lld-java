package com.example.projects.FileBasedConfiguration;

public class FileBasedConfigurationManagerImpl extends FileBasedConfigurationManager {

    private static FileBasedConfigurationManagerImpl singleton;

    private FileBasedConfigurationManagerImpl() {
        super();
    }

    public static FileBasedConfigurationManager getInstance() {
        if (singleton == null) {
            synchronized (FileBasedConfigurationManagerImpl.class) {
                if (singleton == null) {
                    singleton = new FileBasedConfigurationManagerImpl();
                }
            }
        }
        return singleton;
    }

    public static void resetInstance() {
        singleton = null;
    }

    @Override
    public String getConfiguration(String key) {
        if (this.properties.get(key) != null) {
            return this.properties.get(key).toString();
        }
        return null;
    }

    @Override
    public <T> T getConfiguration(String key, Class<T> type) {
        if (this.properties.get(key) != null) {
            return this.convert(this.properties.get(key).toString(), type);
        }
        return null;
    }

    @Override
    public void setConfiguration(String key, String value) {
        this.properties.setProperty(key, value);
    }

    @Override
    public <T> void setConfiguration(String key, T value) {
        Object typedValue;
        if (value instanceof Integer i) {
            typedValue = i;
        } else if (value instanceof Long l) {
            typedValue = l;
        } else if (value instanceof Float f) {
            typedValue = f;
        } else if (value instanceof Double d) {
            typedValue = d;
        } else {
            throw new UnsupportedOperationException("Invalid type: " + value.getClass().getSimpleName());
        }

        this.properties.setProperty(key, typedValue.toString());
    }

    @Override
    public void removeConfiguration(String key) {
        this.properties.remove(key);
    }

    @Override
    public void clear() {
        this.properties.clear();
    }

}