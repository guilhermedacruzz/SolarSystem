
import java.awt.*;
import java.awt.image.BufferedImage;

public class Sun {

    private int x;
    private int y;
    public static int WIDTH = 32;
    public static int HEIGHT = 32;
    public static int SCALE = 2;

    private int animationNow;
    private int frameNow;
    private int maxAnimation;
    private int maxFrame;

    private BufferedImage spriteSun[];

    public Sun(int x, int y) {
       this.setX(x);
       this.setY(y);
       this.setFrameNow(0);
       this.setMaxFrame(20);
       this.setAnimationNow(0);
       this.setMaxAnimation(2);
       this.setSpriteSun(new BufferedImage[2]);
       this.getSpriteSun()[0] = new SpriteSheet("/res/planets.png").getSprite(0, 0, WIDTH, HEIGHT);
       this.getSpriteSun()[1] = new SpriteSheet("/res/planets.png").getSprite(32, 0, WIDTH, HEIGHT);
    }

    public void kick() {
        this.setFrameNow(this.getFrameNow() + 1);
        if(this.getFrameNow() >= this.getMaxFrame()){
            this.setAnimationNow(this.getAnimationNow() + 1);
            if(this.getAnimationNow() == this.getMaxAnimation()){
                this.setAnimationNow(0);
            }
            this.setFrameNow(0);
        }
    }

    public void render(Graphics2D graphics2D) {
        graphics2D.setColor(Color.YELLOW);
        graphics2D.drawImage(this.getSpriteSun()[this.getAnimationNow()], this.getX() , this.getY(), WIDTH * SCALE, HEIGHT * SCALE, null);
    }

    public int getX() { return x; }

    public void setX(int x) { this.x = x; }

    public int getY() { return y; }

    public void setY(int y) { this.y = y; }

    public BufferedImage[] getSpriteSun() { return spriteSun; }

    public void setSpriteSun(BufferedImage[] spriteSun) { this.spriteSun = spriteSun; }

    public int getAnimationNow() { return animationNow; }

    public void setAnimationNow(int animationNow) { this.animationNow = animationNow; }

    public int getMaxAnimation() { return maxAnimation; }

    public void setMaxAnimation(int maxAnimation) { this.maxAnimation = maxAnimation; }

    public int getFrameNow() { return frameNow; }

    public void setFrameNow(int frameNow) { this.frameNow = frameNow; }

    public int getMaxFrame() { return maxFrame; }

    public void setMaxFrame(int maxFrame) { this.maxFrame = maxFrame; }
}
