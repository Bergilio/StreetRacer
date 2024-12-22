package trafficracer.model;

import java.util.Objects;

public class Position {
    private final int y;
    private final int x;


    public Position(int x, int y) {
        this.y = y;
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return this.y == position.y && this.x == position.x;
    }

    @Override
    public int hashCode() {
        return Objects.hash(y, x);
    }

    public Position getLeft() {
        return new Position(x - 1, y);
    }

    public Position getRight() {
        return new Position(x + 1, y);
    }

    public Position getDown() {
        return new Position(x, y + 1);
    }
}
