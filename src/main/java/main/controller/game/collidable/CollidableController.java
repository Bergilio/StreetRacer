package main.controller.game.collidable;

import main.Game;
import main.Gui.ACTION;
import main.controller.game.GameController;
import main.model.game.road.Road;

import java.util.Iterator;

public abstract class CollidableController<T> extends GameController {
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
            speedDecider -= 20;
        }
    }

    public void processElements(Game game) {
        Iterator<T> iterator = getElementsIterator();

        while (iterator.hasNext()) {
            T element = iterator.next();
            updateElement(game, element);

            if (shouldRemoveElement(element)) {
                iterator.remove();
            }
        }
    }

    protected abstract Iterator<T> getElementsIterator();

    protected abstract void updateElement(Game game, T element);

    protected abstract boolean shouldRemoveElement(T element);

}
