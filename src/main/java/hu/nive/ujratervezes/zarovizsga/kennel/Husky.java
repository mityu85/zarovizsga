package hu.nive.ujratervezes.zarovizsga.kennel;

public class Husky extends Dog {

    private int happiness;

    public Husky(String name) {
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
        setHappiness(super.getHappiness()+4);
    }

    @Override
    public void play(int hours) {
        setHappiness(super.getHappiness()+(hours*3));
    }
}
