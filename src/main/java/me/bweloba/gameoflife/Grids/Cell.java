package me.bweloba.gameoflife.Grids;

import javafx.scene.Node;

//a cell in a grid of cells for the game of life
public class Cell extends Node {
    private final int k;
    private final int i;
    private boolean alive;

    public Cell(int k, int i, boolean alive) {
        this.k = k;
        this.i = i;
        this.alive = alive;
    }

    public int getk() {
        return k;
    }

    public int geti() {
        return i;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    @Override
    public Node getStyleableNode() {
        return super.getStyleableNode();
    }
}

