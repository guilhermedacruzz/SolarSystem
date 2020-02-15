public class PlanetSystem {

    private Planet planet[];
    public static int amountOfPlanet = 8;
    public static int WIDTH = 32;
    public static int HEIGHT = 32;
    public static int SCALE = 3;

    public PlanetSystem(){
        this.setPlanet(new Planet[amountOfPlanet]);

        this.getPlanet()[0] = new Planet(20 * SCALE, 0.206, 6.0, new SpriteSheet("/res/planets.png").getSprite(32, 0, WIDTH, HEIGHT));
        this.getPlanet()[1] = new Planet(55 * SCALE, 0.007, 4.6, new SpriteSheet("/res/planets.png").getSprite(64, 0, WIDTH, HEIGHT));
        this.getPlanet()[2] = new Planet(75 * SCALE, 0.517, 4, new SpriteSheet("/res/planets.png").getSprite(96, 0, WIDTH, HEIGHT));
        this.getPlanet()[3] = new Planet(90 * SCALE, 0.093, 3.6, new SpriteSheet("/res/planets.png").getSprite(128, 0, WIDTH, HEIGHT));
        this.getPlanet()[4] = new Planet(120 * SCALE, 0.048, 1.5, new SpriteSheet("/res/planets.png").getSprite(0, 32, WIDTH, HEIGHT));
        this.getPlanet()[5] = new Planet(140 * SCALE, 0.056, 1.3, new SpriteSheet("/res/planets.png").getSprite(32, 32, WIDTH, HEIGHT));
        this.getPlanet()[6] = new Planet(180 * SCALE, 0.047, 0.8, new SpriteSheet("/res/planets.png").getSprite(64, 32, WIDTH, HEIGHT));
        this.getPlanet()[7] = new Planet(210 * SCALE, 0.009, 0.5, new SpriteSheet("/res/planets.png").getSprite(96, 32, WIDTH, HEIGHT));
    }

    public Planet[] getPlanet() { return planet; }

    public void setPlanet(Planet[] planet) { this.planet = planet; }
}
