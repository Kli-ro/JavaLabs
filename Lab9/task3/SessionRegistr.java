package Lab9.task3;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class SessionRegistr {
    private final Map<String, Session> sessions = new ConcurrentHashMap<>();

    public boolean registerSession(String sessionId, Session session) {
        return sessions.putIfAbsent(sessionId, session) == null;
    }

    public Session getSession(String sessionId) {
        return sessions.get(sessionId);
    }
}