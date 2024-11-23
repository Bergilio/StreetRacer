
/*
import javax.imageio.ImageIO; // Para carregar a imagem usando ImageIO.read()
import java.awt.image.BufferedImage; // Para manipular a imagem como BufferedImage
import java.io.File;

import com.googlecode.lanterna.TextCharacter; // Para criar TextCharacter
import com.googlecode.lanterna.TextColor; // Para trabalhar com as cores no formato RGB
import com.googlecode.lanterna.graphics.TextGraphics; // Para desenhar caracteres na tela
import com.googlecode.lanterna.screen.Screen; // Caso esteja utilizando um Screen para renderização

*/

package model.game.elements;

public class PlayerCar extends Element {
    /*
    private final int width = 10;
    private final int length = 10;
    */
    private int fuelLevel;

    public PlayerCar(int x, int y, int fuel) {
        super(x, y);
        this.fuelLevel = fuel;
    }

    public void spendFuel() {
        this.fuelLevel--;
    }

    public int getFuel() {
        return fuelLevel;
    }

    public void setFuel(int fuel) {
        this.fuelLevel = fuel;
    }

    /*
    public int getWidth() {
        return width;
    }

    public int getLength() {
        return length;
    }

    BufferedImage sprite = ImageIO.read(new File("src/main/resources/Images/car1.png"));

    for (int x = 0; x < sprite.getWidth(); x++){
        for (int y = 0; y < sprite.getHeight(); y++){
            int a = sprite.getRGB(x, y);
            int alpha = (a >> 24) & 0xff;
            int red = (a >> 16) & 255;
            int green = (a >> 8) & 255;
            int blue = a & 255;

            if (alpha != 0) {
                TextCharacter c = new TextCharacter(' ', new TextColor.RGB(red, green, blue), new TextColor.RGB(red, green, blue));
                graphics.setCharacter(position.getX() + x, position.getY() + y, c);
            }
        }
    }

    */
}
