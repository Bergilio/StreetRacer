package trafficracer.controller.game.collidable;

import trafficracer.Game;
import trafficracer.gui.ACTION;
import trafficracer.config.GameConfig;
import trafficracer.controller.game.GameController;
import trafficracer.model.game.elements.collidable.Collidable;
import trafficracer.model.game.elements.collidable.Fuel;
import trafficracer.model.game.elements.collidable.Obstacle;
import trafficracer.model.game.road.Road;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class CollidableController<T extends Collidable> extends GameController {
    private long last;
    private long speedDecider;
    protected long maxSpeed;

    public CollidableController(Road road) {
        super(road);

        this.last = 0;
        this.speedDecider = GameConfig.SPEED_DECIDER;
        this.maxSpeed = GameConfig.MAX_SPEED;
    }

    @Override
    public void update(Game game, ACTION action, long time) {
        if (time - this.last > this.speedDecider) {
            processElements(game);
            last = time;
            if (this.speedDecider > this.maxSpeed) {
                this.speedDecider -= 40;
            }

        }
    }

    public void processElements(Game game) {
        Iterator<T> iterator = getElementsIterator();
        List<T> newElements = new ArrayList<>();

        while (iterator.hasNext()) {
            T element = iterator.next();
            updateElement(game, element);

            if (shouldRemoveElement(element)) {
                iterator.remove();
                newElements.add(generateValidElement(newElements));
            }
        }
        addElements(newElements);
    }

    private T generateValidElement(List<T> newElements) {
        while (true) {
            T newElement = generateElement();
            if (isPositionValid(newElement, newElements)) {
                return newElement;
            }
        }
    }

    protected boolean isPositionValid(T element, List<T> newElements) {
        for (Obstacle obstacle : getModel().getObstacles()) {
            if (obstacle.collides(element.getPosition(), element.getWidth(), element.getHeight())) {
                return false;
            }
        }

        for (Fuel fuel : getModel().getFuels()) {
            if (fuel.collides(element.getPosition(), element.getWidth(), element.getHeight())) {
                return false;
            }
        }

        for (T newElement : newElements) {
            if (newElement.collides(element.getPosition(), element.getWidth(), element.getHeight())) {
                return false;
            }
        }

        return true;
    }


    protected abstract Iterator<T> getElementsIterator();

    protected abstract void updateElement(Game game, T element);

    protected abstract boolean shouldRemoveElement(T element);

    protected abstract T generateElement();

    protected abstract void addElements(List<T> elements);

}
