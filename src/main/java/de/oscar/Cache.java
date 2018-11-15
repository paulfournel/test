package de.oscar;

public class Cache {
    private final String lonLat;
    private final String hint;
    private final String difficulty;
    private final String terrain;
    private final String size;
    private final String cacheName;
    private final String user;

    public Cache(String cacheName, String user, String lonLat, String hint, String difficulty, String terrain, String size) {
        this.cacheName = cacheName;
        this.user = user;
        this.lonLat = lonLat;
        this.hint = hint;
        this.difficulty = difficulty;
        this.terrain = terrain;
        this.size = size;
    }

    public String getLonLat() {
        return lonLat;
    }

    public String getHint() {
        return hint;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public String getTerrain() {
        return terrain;
    }

    public String getSize() {
        return size;
    }

    public String getCacheName() {
        return cacheName;
    }

    public String getUser() {
        return user;
    }
}
