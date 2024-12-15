package main.controller.game.collidable;

import main.Game;
import main.Gui.ACTION;
import main.controller.game.GameController;
import main.model.game.elements.collidable.Collidable;
import main.model.game.elements.collidable.Fuel;
import main.model.game.elements.collidable.Obstacle;
import main.model.game.road.Road;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class CollidableController<T extends Collidable> extends GameController {
    private long last;
    private long speedDecider;

    public CollidableController(Road road) {
        super(road);

        this.last = 0;
        this.speedDecider = 500;
    }

    @Override
    public void update(Game game, ACTION action, long time) {
        if (time - last > speedDecider) {
            processElements(game);
            last = time;
            if (speedDecider > 100) {
                speedDecider -= 20;
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

    private boolean isPositionValid(T element, List<T> newElements) {
        for (Obstacle obstacle : getModel().getObstacles()) {
            if (obstacle.getPosition().equals(element.getPosition())) {
                return false;
            }
        }

        for (Fuel fuel : getModel().getFuels()) {
            if (fuel.getPosition().equals(element.getPosition())) {
                return false;
            }
        }

        for (T newElement : newElements) {
            if (newElement.getPosition().equals(element.getPosition())) {
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
