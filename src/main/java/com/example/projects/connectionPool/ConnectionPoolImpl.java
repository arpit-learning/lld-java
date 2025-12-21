package com.example.projects.connectionPool;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class ConnectionPoolImpl implements ConnectionPool {

    // 1. Volatile is needed for double-checked locking safety
    private static volatile ConnectionPoolImpl instance;

    private final int maxConnections;
    private final Queue<DatabaseConnection> availableConnections;
    private final Set<DatabaseConnection> usedConnections;

    private ConnectionPoolImpl(int maxConnections) {
        this.maxConnections = maxConnections;
        this.availableConnections = new LinkedList<>();
        this.usedConnections = new HashSet<>();
        initializePool();
    }

    public static ConnectionPoolImpl getInstance(int maxConnections) {
        if (instance == null) {
            synchronized (ConnectionPoolImpl.class) {
                if (instance == null) {
                    instance = new ConnectionPoolImpl(maxConnections);
                }
            }
        }
        return instance;
    }

    public static void resetInstance() {
        instance = null;
    }

    // 2. SYNCHRONIZED is critical here to prevent multiple threads modifying lists at the same time
    @Override
    public synchronized void initializePool() {
        availableConnections.clear();
        usedConnections.clear();

        for (int i = 0; i < maxConnections; i++) {
            // Requirement: Use DummyConnection
            availableConnections.add(new DummyConnection());
        }
    }

    @Override
    public synchronized DatabaseConnection getConnection() {
        if (availableConnections.isEmpty()) {
            return null;
        }

        DatabaseConnection connection = availableConnections.poll();
        usedConnections.add(connection);

        return connection;
    }

    @Override
    public synchronized void releaseConnection(DatabaseConnection connection) {
        if (connection == null) {
            return;
        }

        // Only release if it is currently in use
        if (usedConnections.contains(connection)) {
            usedConnections.remove(connection);
            availableConnections.add(connection);
        }
    }

    @Override
    public synchronized int getAvailableConnectionsCount() {
        return availableConnections.size();
    }

    @Override
    public synchronized int getTotalConnectionsCount() {
        return availableConnections.size() + usedConnections.size();
    }
}
