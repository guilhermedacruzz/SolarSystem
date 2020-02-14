import java.awt.*;

public class Moon {

    private int x;
    private int y;
    public static int WIDTH = 20;
    public static int HEIGHT = 20;
    private int angle;

    public Moon(int x, int y) {
        this.setX(x);
        this.setY(y);
        this.setAngle(0);
    }

    public void kick() {
        this.setAngle(this.getAngle() + 1);

        if(this.getAngle() > 360){
            this.setAngle(0);
        }
    }

    public void render(Graphics2D graphics2D, Planet planet) {
        graphics2D.setColor(Color.BLUE);
        graphics2D.rotate(Math.toRadians(this.getAngle()), planet.getX() + 20, planet.getY() + 20);
        graphics2D.fillOval(this.getX(), this.getY(), WIDTH, HEIGHT);
        graphics2D.rotate(Math.toRadians(-this.getAngle()), planet.getX() + 20, planet.getY() + 20);
    }

    public int getAngle() {
        return angle;
    }

    public void setAngle(int angle) {
        this.angle = angle;
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
