package org.example.commands;

import org.example.collections.Organization;
import org.example.exceptions.IncorrectInputInScriptException;
import org.example.exceptions.WrongAmountOfElementsException;
import org.example.managers.CollectionManager;
import org.example.managers.Console;
import org.example.managers.OrganizationAsker;

import java.util.LinkedHashSet;

public class AddIfMaxCommand extends AbstractCommand{
    private final CollectionManager collectionManager;
    private final OrganizationAsker organizationAsker;

    public AddIfMaxCommand(CollectionManager collectionManager, OrganizationAsker organizationAsker) {
        super("add_if_max {element}", "add a new element to the collection if its value is greater than the value of the largest element in this collection");
        this.collectionManager = collectionManager;
        this.organizationAsker = organizationAsker;
    }

    @Override
    public boolean execute(String argument) {
        try{
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

            if(collectionManager.getCollection().size() == 0){
                collectionManager.addToCollection(askerOrganization);
                Console.printLn("Organization was added successfully");
                return true;
            }

            LinkedHashSet<Organization> organizations = collectionManager.getCollection();
            for (Organization organization : organizations){
                if (askerOrganization.compareTo(organization) <= 0){
                    Console.printLn("Organization annual turnover is not enough to add");
                    return false;
                }
            }
            collectionManager.addToCollection(askerOrganization);
            Console.printLn("Organization was added successfully");
            return true;
        } catch (WrongAmountOfElementsException e){
            Console.printError("Usage of (" + argument + ") in " + getName());
        } catch (IncorrectInputInScriptException ignored) {
        }
        return false;
    }
}