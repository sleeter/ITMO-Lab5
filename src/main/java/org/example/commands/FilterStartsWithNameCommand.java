package org.example.commands;

import org.example.collections.Organization;
import org.example.exceptions.WrongAmountOfElementsException;
import org.example.managers.CollectionManager;
import org.example.managers.Console;

import java.util.LinkedHashSet;

public class FilterStartsWithNameCommand extends AbstractCommand{
    private final CollectionManager collectionManager;
    public FilterStartsWithNameCommand(CollectionManager collectionManager){
        super("filter_starts_with_name name","display elements whose name field value starts with the given substring");
        this.collectionManager = collectionManager;
    }

    @Override
    public boolean execute(String argument) {
        try {
            if (argument.isEmpty()) throw new WrongAmountOfElementsException();
            LinkedHashSet<Organization> organizations = collectionManager.getCollection();
            for (Organization organization : organizations) {
                if (organization.getName().regionMatches(0, argument, 0, argument.length()))
                    Console.printLn(organization.toString());
            }
            return true;
        } catch (WrongAmountOfElementsException exception) {
            Console.printError("No arguments in " + getName());
        }
        return false;
    }
}
