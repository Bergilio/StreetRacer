public class Game {

    private static Game instance;

    private Game(){

    }

    public static Game getInstance(){
        if (instance==null){
            instance = new Game();
        }
        return instance;
    }



    public static void main(String[] args) {
        Game game = Game.getInstance();
        game.start();
    }

    private void start(){
        int FPS = 30;
        int frameTime = 1000/ FPS;
    }
}
