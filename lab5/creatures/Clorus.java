package creatures;

import huglife.*;

import java.awt.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;

public class Clorus extends Creature {
    private int r;
    private int g;
    private int b;

    private double energy;

    private static final double perMoveLostEnergy = 0.03;
    private static final double perStayLostEnergy = 0.01;

    public Clorus(double n) {
        super("clorus");
        r = 0;
        g = 0;
        b = 0;
        energy = n;
    }

    public Clorus() {
        this(1);
    }

    @Override
    public void attack(Creature c) {
        energy += c.energy();
    }

    public Clorus replicate() {
        energy = Math.max(energy/2, 0);

        return new Clorus(energy);
    }

    @Override
    public void stay() {
        energy = Math.max(energy - perStayLostEnergy, 0);
    }

    public void move() {
        energy = Math.max(energy - perMoveLostEnergy, 0);
    }


    @Override
    public Action chooseAction(Map<Direction, Occupant> neighbors) {
        Deque<Direction> emptyNeighbors = new ArrayDeque<>();
        Deque<Direction> plipNeighbors = new ArrayDeque<>();
        boolean anyPlip = false;

        for (Map.Entry<Direction, Occupant>  o : neighbors.entrySet()) {
            if (o.getValue().name().equals("empty")) {
                emptyNeighbors.add(o.getKey());
            } else if (o.getValue().name().equals("plip")) {
                plipNeighbors.add(o.getKey());
                anyPlip = true;
            }
        }

        if (emptyNeighbors.isEmpty() && !anyPlip) {
            return new Action(Action.ActionType.STAY);
        }

        if (anyPlip) {
            Direction d = HugLifeUtils.randomEntry(plipNeighbors);
            return new Action(Action.ActionType.ATTACK, d);
        }

        if (energy >=1 ) {
            Direction d = HugLifeUtils.randomEntry(emptyNeighbors);
            return new Action(Action.ActionType.REPLICATE, d);
        }


        Direction d = HugLifeUtils.randomEntry(emptyNeighbors);
        return new Action(Action.ActionType.MOVE, d);
    }

    @Override
    public double energy() {
        return super.energy();
    }

    @Override
    public String name() {
        return super.name();
    }

    @Override
    public Color color() {
        r = 34;
        g = 0;
        b = 231;
        return color(r, g, b);
    }
}
