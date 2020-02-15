public class PlanetSystem {

    private Planet planet[];
    public static int amountOfPlanet = 8;
    public static int SCALE = 3;

    public PlanetSystem(){
        this.setPlanet(new Planet[amountOfPlanet]);

        this.getPlanet()[0] = new Planet(20 * SCALE, 0.206, 6.0);
        this.getPlanet()[1] = new Planet(55 * SCALE, 0.007, 4.6);
        this.getPlanet()[2] = new Planet(75 * SCALE, 0.017, 4);
        this.getPlanet()[3] = new Planet(90 * SCALE, 0.093, 3.6);
        this.getPlanet()[4] = new Planet(120 * SCALE, 0.048, 2.5);
        this.getPlanet()[5] = new Planet(140 * SCALE, 0.056, 1.3);
        this.getPlanet()[6] = new Planet(180 * SCALE, 0.047, 0.8);
        this.getPlanet()[7] = new Planet(210 * SCALE, 0.009, 0.5);
    }

    public Planet[] getPlanet() { return planet; }

    public void setPlanet(Planet[] planet) { this.planet = planet; }
}
