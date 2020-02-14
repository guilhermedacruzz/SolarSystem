import java.awt.*;

public class Planet {

    private int x;
    private int y;
    public static int WIDTH = 40;
    public static int HEIGHT = 40;

    public Planet(int x, int y) {
       this.setX(x);
       this.setY(y);
    }

    public void kick() {

    }

    public void render(Graphics2D graphics2D) {
        graphics2D.setColor(Color.YELLOW);
        graphics2D.fillOval(this.getX(), this.getY(), WIDTH, HEIGHT);
    }
    public int getX() {
        return x;
    }
    public void setX(int x) {
        this.x = x;
    }
    public int getY() {
        return y;
    }
    public void setY(int y) {
        this.y = y;
    }
}
