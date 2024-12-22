package trafficracer.config;

public class GameConfig {
    public static final int SCREEN_WIDTH = 50;
    public static final int SCREEN_HEIGHT = 50;

    public static final int ROAD_WIDTH = SCREEN_WIDTH;
    public static final int ROAD_HEIGHT = SCREEN_HEIGHT;

    public static final int PLAYER_START_X = ROAD_WIDTH / 2;
    public static final int PLAYER_START_Y = ROAD_HEIGHT - 10;

    public static final int PLAYER_START_FUEL = 20;
    public static final int PLAYER_START_POINTS = 0;
    public static final int MAX_FUEL = 30;

    public static final int CAR_WIDTH = 5;
    public static final int CAR_HEIGHT = 5;

    public static final int FUEL_WIDTH = 2;
    public static final int FUEL_HEIGHT = 1;
    public static final int FUEL_ADITION = 5;

    public static final int NUMBER_OF_OBSTACLES_PER_DIVISION = 1;
    public static final int NUMBER_OF_FUELS_PER_DIVISION = 1;

    public static final int SPEED_DECIDER = 400;
    public static final int MAX_SPEED = 100;

    public static final int MAX_SCORES = 10;

    public static final int REASON_QUIT = 0;
    public static final int REASON_FUEL = 1;
    public static final int REASON_COLLISION = 2;

    public static final int MENU_START_Y = 4;
    public static final int MENU_START_X = 2;

    public static final String SCORES_FILE = "TrafficRacerFiles/Scores.txt";

}
