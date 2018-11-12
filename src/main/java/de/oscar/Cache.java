package de.oscar;

public class Cache {
    private final String lonLat;
    private final String hint;
    private final String difficulty;

    public Cache(String lonLat, String hint, String difficulty) {
        this.lonLat = lonLat;
        this.hint = hint;
        this.difficulty = difficulty;
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
}
