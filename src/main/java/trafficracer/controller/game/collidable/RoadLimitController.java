package trafficracer.controller.game.collidable;

import trafficracer.Game;
import trafficracer.config.GameConfig;
import trafficracer.model.Position;
import trafficracer.model.game.elements.collidable.RoadLimit;
import trafficracer.model.game.road.Road;

import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class RoadLimitController extends CollidableController<RoadLimit> {

    public RoadLimitController(Road road) {
        super(road);
        this.maxSpeed += 20;
    }

    @Override
    protected Iterator<RoadLimit> getElementsIterator() {
        return getModel().getDashLines().iterator();
    }

    @Override
    protected void updateElement(Game game, RoadLimit element) {
        moveLine(new Position(element.getPosition().getX(), element.getPosition().getY() + 1), element);
    }

    @Override
    protected boolean shouldRemoveElement(RoadLimit element) {
        return element.getPosition().getY() > GameConfig.ROAD_HEIGHT;
    }

    @Override
    protected RoadLimit generateElement() {
        Random random = new Random();
        int decider = random.nextInt(2);
        int y = 0;
        int x;
        if (decider == 0) {
            x = GameConfig.ROAD_WIDTH / 3;
        }else {
            x = (GameConfig.ROAD_WIDTH / 3) * 2 + 1;
        }
        return new RoadLimit(x, y);
    }

    @Override
    protected boolean isPositionValid(RoadLimit element, List<RoadLimit> newElements) {
        if (newElements.isEmpty()) {
            return true;
        }
        Position newPosition = element.getPosition();
        for (RoadLimit existingElement : newElements) {
            if (existingElement.getPosition().equals(newPosition)) {
                return false;
            }
        }
        return true;
    }

    @Override
    protected void addElements(List<RoadLimit> elements) {
        List<RoadLimit> newLimits = getModel().getDashLines();
        newLimits.addAll(elements);
        getModel().setDashLines(newLimits);
    }


    private void moveLine(Position position, RoadLimit element) {
        element.setPosition(position);
    }




}
