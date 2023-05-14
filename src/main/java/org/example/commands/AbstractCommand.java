package org.example.commands;

import java.util.Objects;

/**
 * The AbstractCommand class is an abstract class that implements the ICommand interface.
 * It has two fields: name and description.
 * It has two methods: getName and getDescription.
 * It has one constructor: AbstractCommand(String name, String description).
 * It has one toString method: toString().
 * It has one hashCode method: hashCode().
 * It has one equals method: equals(Object obj).
 */
public abstract class AbstractCommand implements  ICommand {
    private final String name;
    private final String description;

    public AbstractCommand(String name, String description){
        this.name = name;
        this.description = description;
    }
    /**
     * It returns the name of the command.
     *
     * @return The name of the command.
     */
    public String getName() {
        return name;
    }
    /**
     * It returns the description of the command.
     *
     * @return The description of the command.
     */
    public String getDescription() {
        return description;
    }
    /**
     * It returns a string representation of the object.
     *
     * @return The name of the question and the description of the command.
     */
    @Override
    public String toString() {
        return getClass()+"{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    /**
     * The hashCode method returns a hash code for the object.
     *
     * @return The hash code of the name and description.
     */
    @Override
    public int hashCode() {
        return Objects.hash(name, description);
    }
    /**
     * The equals method compares the name and description of the command to the name and description
     * of the other command.
     * If the names and descriptions are equal, the method returns true. Otherwise, it returns false.
     *
     * @param otherObject The object to compare to.
     * @return The boolean value of the equals method.
     */
    @Override
    public boolean equals(Object otherObject){
        if (this == otherObject) return true;
        if (otherObject == null) return false;
        if ( getClass () != otherObject.getClass () )
            return false;
        AbstractCommand other = (AbstractCommand) otherObject;
        return Objects.equals(name, other.name) && Objects.equals(description, other.description);
    }
}

