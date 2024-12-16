
/*
import javax.imageio.ImageIO; // Para carregar a imagem usando ImageIO.read()
import java.awt.image.BufferedImage; // Para manipular a imagem como BufferedImage
import java.io.File;

import com.googlecode.lanterna.TextCharacter; // Para criar TextCharacter
import com.googlecode.lanterna.TextColor; // Para trabalhar com as cores no formato RGB
import com.googlecode.lanterna.graphics.TextGraphics; // Para desenhar caracteres na tela
import com.googlecode.lanterna.screen.Screen; // Caso esteja utilizando um Screen para renderização

*/

package main.model.game.elements;

import main.config.GameConfig;

public class PlayerCar extends Element {
    private int fuelLevel;
    private int points;
    private boolean collided;

    public PlayerCar(int x, int y, int w, int h) {
        super(x, y, w, h);
        this.fuelLevel = GameConfig.PLAYER_START_FUEL;
        this.points = GameConfig.PLAYER_START_POINTS;
        this.collided = false;
    }

    public void spendFuel() {
        this.fuelLevel--;
    }

    public void increasePoints() {
        this.points++;
    }

    public int getFuel() {
        return fuelLevel;
    }

    public void setFuel(int fuel) {
        this.fuelLevel = fuel;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public boolean getCollided() {
        return collided;
    }

    public void setCollided(boolean collided) {
        this.collided = collided;
    }
}
