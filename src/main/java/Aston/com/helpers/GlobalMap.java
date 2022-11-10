package Aston.com.helpers;

import java.util.HashMap;
import java.util.Map;

public final class GlobalMap {
    private static Map<String, Object> globalMap;

    public static Map<String, Object> getGlobalMap() {
        if (globalMap == null) {
            globalMap = new HashMap<>();
        }
        return globalMap;
    }

    public static void addToGlobalMap(String key, Object object) {
        GlobalMap.getGlobalMap();
        globalMap.put(key, object);
        System.out.println();
    }

    public static Object getFromGlobalMap(String key) {

        return globalMap.get(key);
    }
}