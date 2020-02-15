import java.awt.*;

public class Planet {

    private int x;
    private int y;
    private double eccentricity;
    public static int WIDTH = 16;
    public static int HEIGHT = 16;
    private double angle;
    private double lap;

    public Planet(int d, double e, double l) {
        this.setX((Game.WIDTH / 2) - (Sun.WIDTH / 2) + d);
        this.setY((Game.HEIGHT / 2) - (Sun.HEIGHT / 2));
        this.setAngle(0);
        this.setEccentricity((int)(e * 100));
        this.setLap(l);
    }

    public void kick() {
        this.setAngle((this.getAngle() + (this.getLap())));

        if(this.getAngle() > 360){
            this.setAngle(0);
        }
    }

    public void render(Graphics2D graphics2D, Sun sun) {
        graphics2D.setColor(Color.BLUE);
        graphics2D.rotate(Math.toRadians(this.getAngle()), (sun.getX() + 32) - this.getEccentricity(), (sun.getY() + 32) - this.getEccentricity());
        graphics2D.fillOval(this.getX(), this.getY(), WIDTH, HEIGHT);
        graphics2D.rotate(Math.toRadians(-this.getAngle()), (sun.getX() + 32) - this.getEccentricity(),(sun.getY() + 32) - this.getEccentricity());

        graphics2D.setColor(Color.WHITE);
        for(int i = 0; i <= 360; i++){
            graphics2D.rotate(Math.toRadians(i), (sun.getX() + 32) - this.getEccentricity(), (sun.getY() + 32) - this.getEccentricity());
            graphics2D.fillOval(this.getX(), this.getY(), 5, 5);
            graphics2D.rotate(Math.toRadians(-i), (sun.getX() + 32) - this.getEccentricity(), (sun.getY() + 32) - this.getEccentricity());
        }
    }

    public double getAngle() {
        return angle;
    }

    public void setAngle(double angle) { this.angle = angle; }

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

    public double getEccentricity() {
        return eccentricity;
    }

    public void setEccentricity(double eccentricity) {
        this.eccentricity = eccentricity;
    }

    public double getLap() { return lap; }

    public void setLap(double lap) { this.lap = lap; }
}
