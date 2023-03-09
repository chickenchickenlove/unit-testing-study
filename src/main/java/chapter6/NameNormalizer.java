package chapter6;

public class NameNormalizer {
    public int normalizeNameLength(String name) {
        return Math.min(name.length(), 50);
    }
}
