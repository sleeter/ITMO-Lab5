package org.example;

import org.example.commands.*;
import org.example.managers.*;

import java.io.File;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        try(Scanner scanner = new Scanner(System.in)){
            CollectionManager collectionManager = new CollectionManager();
            FileManager fileManager = new FileManager();
            while(true) {
                Console.printLn("Enter an environment variable that stores the file name:");
                String envVar = scanner.nextLine();
                String filename = System.getenv(envVar);
                String nametmp = "tmp.csv";
                File tmp = new File(nametmp);
                File fileEnvVar = new File(filename);
                if (tmp.exists() && !tmp.isDirectory()) {
                    Console.printLn("Last time you don't exit correctly. Do you want to upload your last autosave data?");
                    while(true) {
                        Console.printLn("Write y or n");
                        String nl = scanner.nextLine();
                        if (nl.equals("y")) {
                            fileManager.setFilename(nametmp);
                            collectionManager.setCollection(fileManager.readCollectionsOPENCSV());
                            break;
                        } else if (nl.equals("n")) {
                            fileManager.setFilename(filename);
                            collectionManager.setCollection(fileManager.readCollectionsOPENCSV());
                            break;
                        }else{
                            Console.printLn("Incorrect input");
                        }
                    }
                    break;
                } else if (fileEnvVar.exists() && !fileEnvVar.isDirectory()) {
                    fileManager.setFilename(filename);
                    collectionManager.setCollection(fileManager.readCollectionsOPENCSV());
                    break;
                } else {
                    Console.printLn("File not found");
                }
            }
            OrganizationAsker organizationAsker = new OrganizationAsker(collectionManager, scanner);
            CommandManager commandManager = new CommandManager(
                    new AddCommand(collectionManager, organizationAsker),
                    new AddIfMaxCommand(collectionManager, organizationAsker),
                    new ClearCommand(collectionManager),
                    new ExecuteScriptCommand(),
                    new ExitCommand(),
                    new FilterStartsWithNameCommand(collectionManager),
                    new HelpCommand(),
                    new InfoCommand(collectionManager),
                    new PrintFieldAscendingPostalAddressCommand(collectionManager),
                    new RemoveByIdCommand(collectionManager),
                    new RemoveGreaterCommand(collectionManager, organizationAsker),
                    new RemoveLowerCommand(collectionManager, organizationAsker),
                    new SaveCommand(collectionManager, fileManager),
                    new ShowCommand(collectionManager),
                    new SumOfEmployeesCountCommand(collectionManager),
                    new UpdateCommand(collectionManager, organizationAsker)
            );
            Console console = new Console(commandManager, scanner, organizationAsker, collectionManager);
            console.interactiveMode();


        }finally {

        }
    }
}