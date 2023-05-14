package org.example.commands;

import org.example.collections.Organization;
import org.example.exceptions.WrongAmountOfElementsException;
import org.example.managers.CollectionManager;
import org.example.managers.Console;

import java.util.LinkedHashSet;

public class PrintFieldAscendingPostalAddressCommand extends AbstractCommand{
    private final CollectionManager collectionManager;
    public PrintFieldAscendingPostalAddressCommand(CollectionManager collectionManager){
        super("print_field_ascending_postal_address","display the values of the postalAddress field of all elements in ascending order");
        this.collectionManager = collectionManager;
    }

    @Override
    public boolean execute(String argument) {
        try {
            if (!argument.isEmpty()) throw new WrongAmountOfElementsException();
            LinkedHashSet<Organization> organizations = collectionManager.getCollection();
            organizations.stream().sorted().map(Organization::getPostalAddress).forEach(Console::printLn);
            return true;
        } catch (WrongAmountOfElementsException exception) {
            Console.printLn("Usage: '" + getName() + "'");
        }
        return false;
    }
}
