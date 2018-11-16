package de.oscar;

public class Cache {
    private final String lonLat;
    private final String hint;
    private final String difficulty;
    private final String terrain;
    private final String size;
    private final String cacheName;
    private final String user;
    private final String type;

    public Cache(String cacheName, String user, String lonLat, String hint, String difficulty, String terrain, String size, String type) {
        this.cacheName = cacheName;
        this.user = user;
        this.lonLat = lonLat;
        this.hint = hint;
        this.difficulty = difficulty;
        this.terrain = terrain;
        this.size = size;
        this.type = type;
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

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Cache{" +
                "lonLat='" + lonLat + '\'' +
                ", hint='" + hint + '\'' +
                ", difficulty='" + difficulty + '\'' +
                ", terrain='" + terrain + '\'' +
                ", size='" + size + '\'' +
                ", cacheName='" + cacheName + '\'' +
                ", user='" + user + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
