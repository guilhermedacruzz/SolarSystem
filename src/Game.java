

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JFrame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;


@SuppressWarnings("serial")
public class Game extends Canvas implements Runnable{

    private Thread thread;
    private boolean isRunning = false;

    private JFrame frame;
    public static final int WIDTH = 1366;
    public static int HEIGHT = 768;

    private BufferedImage image;

    private Sun sun;
    private PlanetSystem planets;

    public Game() {
        super();
        this.janela();
        this.setPlanets(new PlanetSystem());
        this.setSun(new Sun((WIDTH / 2) - ((Sun.WIDTH * Sun.SCALE) / 2), (HEIGHT / 2) - ((Sun.HEIGHT * Sun.SCALE) / 2)));
        this.setImage(new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB));
    }

    public void janela() {
        this.setFrame(new JFrame("Janela"));
        this.setPreferredSize(new Dimension(WIDTH , HEIGHT));
        this.getFrame().add(this);
        this.getFrame().setResizable(false);
        this.getFrame().pack();
        this.getFrame().setLocation(0, 0);
        this.getFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getFrame().setVisible(true);
    }

    public synchronized void start() {
        this.setThread(new Thread(this));
        this.setRunning(true);
        this.getThread().start();
    }

    public synchronized void stop() {
        this.setRunning(false);
        try {
            this.getThread().join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void kick() {
        for(int i = 0; i < PlanetSystem.amountOfPlanet; i++){

            this.getPlanets().getPlanet()[i].kick();
        }
    }

    public void render() {
        BufferStrategy bs = this.getBufferStrategy();
        if(bs == null) {
            this.createBufferStrategy(3);
            return;
        }

        Graphics g = this.getImage().getGraphics();
        g.setColor(new Color(0, 0, 0));
        g.fillRect(0, 0, WIDTH, HEIGHT);

        Graphics2D g2 = (Graphics2D) g;
        this.getSun().render(g2);
        for(int i = 0; i < PlanetSystem.amountOfPlanet; i++){
            this.getPlanets().getPlanet()[i].render(g2, this.getSun());
        }

        g.dispose();
        g = bs.getDrawGraphics();
        g.drawImage(this.getImage(), 0, 0, WIDTH, HEIGHT, null);

        bs.show();
    }

    @Override
    public void run() {

        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;

        int contFPS = 0;
        double timer = System.currentTimeMillis();

        while(this.isRunning) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;

            if(delta >= 1) {
                this.kick();
                this.render();
                contFPS++;
                delta--;
            }

            if(System.currentTimeMillis() - timer >= 1000) {
                System.out.println("FPS: " + contFPS);
                contFPS = 0;
                timer += 1000;
            }
        }
        this.stop();
    }

    public boolean isRunning() {
        return isRunning;
    }

    public void setRunning(boolean isRunning) {
        this.isRunning = isRunning;
    }

    public Thread getThread() {
        return thread;
    }

    public void setThread(Thread thread) {
        this.thread = thread;
    }

    public JFrame getFrame() {
        return frame;
    }

    public void setFrame(JFrame frame) {
        this.frame = frame;
    }

    public BufferedImage getImage() {
        return image;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }

    public Sun getSun() { return sun; }

    public void setSun(Sun sun) { this.sun = sun; }

    public PlanetSystem getPlanets() { return planets; }

    public void setPlanets(PlanetSystem planets) { this.planets = planets; }
}
