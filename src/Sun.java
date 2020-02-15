
import java.awt.*;
import java.awt.image.BufferedImage;

public class Sun {

    private int x;
    private int y;
    public static int WIDTH = 32;
    public static int HEIGHT = 32;
    public static int SCALE = 2;

    private BufferedImage spriteSun;

    public Sun(int x, int y) {
       this.setX(x);
       this.setY(y);
       this.setSpriteSun(new SpriteSheet("/res/planets.png").getSprite(0, 0, WIDTH, HEIGHT));
    }

    public void render(Graphics2D graphics2D) {
        graphics2D.drawImage(this.getSpriteSun(), this.getX() , this.getY(), WIDTH * SCALE, HEIGHT * SCALE, null);
    }

    public int getX() { return x; }

    public void setX(int x) { this.x = x; }

    public int getY() { return y; }

    public void setY(int y) { this.y = y; }

    public BufferedImage getSpriteSun() { return spriteSun; }

    public void setSpriteSun(BufferedImage spriteSun) { this.spriteSun = spriteSun; }
}
