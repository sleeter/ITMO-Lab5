package org.example.commands;

import org.example.collections.Organization;
import org.example.exceptions.IncorrectInputInScriptException;
import org.example.exceptions.WrongAmountOfElementsException;
import org.example.managers.CollectionManager;
import org.example.managers.Console;
import org.example.managers.OrganizationAsker;

import java.util.LinkedHashSet;

public class RemoveLowerCommand extends AbstractCommand{
    private final CollectionManager collectionManager;
    private final OrganizationAsker organizationAsker;
    public RemoveLowerCommand(CollectionManager collectionManager, OrganizationAsker organizationAsker){
        super("remove_lower {element}","remove from the collection all elements smaller than the given one");
        this.collectionManager = collectionManager;
        this.organizationAsker = organizationAsker;
    }

    @Override
    public boolean execute(String argument) {
        try {
            if(!argument.isEmpty()) throw new WrongAmountOfElementsException();
            Organization askerOrganization = new Organization(
                    organizationAsker.setId(),
                    organizationAsker.askName(),
                    organizationAsker.askCoordinates(),
                    organizationAsker.askCreationDate(),
                    organizationAsker.askAnnualTurnover(),
                    organizationAsker.askFullName(),
                    organizationAsker.askEmployeesCount(),
                    organizationAsker.askOrganizationType(),
                    organizationAsker.askAddress()
            );
            askerOrganization.setFullName();
            LinkedHashSet<Organization> organizations = collectionManager.getCollection();
            organizations.removeIf(organization -> askerOrganization.compareTo(organization) >= 0);
            return true;
        } catch (WrongAmountOfElementsException exception) {
            Console.printLn("Usage of (" + argument + ") in " + getName());
        } catch (IncorrectInputInScriptException ignored) {
        }
        return false;
    }
}
