package trafficracer.model.game.elements;

import trafficracer.model.Position;

public class Element {
    private Position position;
    private final int width;
    private final int height;

    public Element(int x, int y, int w, int h) {
        this.position = new Position(x, y);
        this.width = w;
        this.height = h;
    }

    public boolean collides(Position p, int w, int h) {
        int x1 = this.position.getX();
        int x2 = x1 + this.width;
        int y1 = this.position.getY();
        int y2 = y1 + this.height;

        int i1 = p.getX();
        int i2 = i1 + w;
        int j1 = p.getY();
        int j2 = j1 + h;

        return x2 > i1 && x1 < i2 && y2 > j1 && y1 < j2;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }
}
