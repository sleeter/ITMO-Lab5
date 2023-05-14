package org.example.commands;

import org.example.collections.Organization;
import org.example.exceptions.WrongAmountOfElementsException;
import org.example.managers.CollectionManager;
import org.example.managers.Console;

import java.util.LinkedHashSet;

public class ShowCommand extends AbstractCommand{
    private final CollectionManager collectionManager;
    public ShowCommand(CollectionManager collectionManager) {
        super("show", "print to standard output all elements of the collection in string representation");
        this.collectionManager = collectionManager;
    }

    @Override
    public boolean execute(String argument) {
        try {
            if (!argument.isEmpty()) throw new WrongAmountOfElementsException();
            LinkedHashSet<Organization> organizations = collectionManager.getCollection();
            for(Organization organization : organizations){
                Console.printLn(organization.toString());
            }
            return true;
        } catch (WrongAmountOfElementsException e){
            Console.printLn("Usage: '" + getName() + "'");
        }
        return false;
    }
}
