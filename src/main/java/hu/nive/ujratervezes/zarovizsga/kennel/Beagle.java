package hu.nive.ujratervezes.zarovizsga.kennel;

public class Beagle extends Dog {

    private int happiness;

    public Beagle(String name) {
        super(name);
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public int getHappiness() {
        return happiness;
    }

    public void setHappiness(int happiness) {
        this.happiness = happiness;
    }

    @Override
    public void feed() {
        setHappiness(super.getHappiness()+2);
    }

    @Override
    public void play(int hours) {
        setHappiness(super.getHappiness()+(hours*2));
    }
}
