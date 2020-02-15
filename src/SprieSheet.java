import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

class SpriteSheet {

    private BufferedImage sprite;

    public SpriteSheet(String path) {
        try {
            sprite = ImageIO.read(this.getClass().getResource(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public BufferedImage getSprite(int x, int y, int w, int h) { return sprite.getSubimage(x, y, w, h); }
}
