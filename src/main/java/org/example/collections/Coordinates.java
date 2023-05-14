package org.example.collections;

/**
 * This class represents a point in a two-dimensional space.
 */
public class Coordinates {
    private float x;
    private Double y; //Поле не может быть null
    public Coordinates(float x, Double y){
        this.x = x;
        this.y = y;
    }
    /**
     * Returns the y-coordinate of the point.
     *
     * @return The value of the variable y.
     */
    public Double getY() {
        return y;
    }
    /**
     * Get the x-coordinate of the point.
     *
     * @return The value of the variable x.
     */
    public float getX() {
        return x;
    }

    @Override
    public String toString() {
        return "Coordinates{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
