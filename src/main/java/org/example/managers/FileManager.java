package org.example.managers;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import org.example.collections.*;

import java.io.*;
import java.time.LocalDate;
import java.util.*;

public class FileManager {
    private String filename;
    public FileManager(){}
    public FileManager(String filename) {
        this.filename = filename;
    }

    public void setFilename(String file) {
        this.filename = file;
    }
    private static List<String[]> toStringArray(LinkedHashSet<Organization> organizations) {
        List<String[]> records = new ArrayList<String[]>();

        Iterator<Organization> it = organizations.iterator();
        while (it.hasNext()) {
            Organization organization = it.next();
            records.add(new String[] {String.valueOf(organization.getId()), organization.getName(), String.valueOf(organization.getCoordinates().getX()),
                    String.valueOf(organization.getCoordinates().getY()), String.valueOf(organization.getCreationDate()), String.valueOf(organization.getAnnualTurnover()),
                    organization.getFullName(), String.valueOf(organization.getEmployeesCount()), String.valueOf(organization.getType()),
                    organization.getPostalAddress().getStreet()});
        }
        return records;
    }

    public void writeCollectionsOPENCSV(LinkedHashSet<Organization> organizations){
        try {
            File file = new File(filename);
            FileWriter outputfile = new FileWriter(file);
            CSVWriter csvWriter = new CSVWriter(outputfile);
            List<String[]> arr = toStringArray(organizations);
            for (String[] ar : arr){
                csvWriter.writeNext(ar);
            }
            csvWriter.close();
        }catch (java.io.IOException e){

        }

    }
    public void writeCollections(LinkedHashSet<Organization> organizations){
        try(PrintWriter printWriter = new PrintWriter(filename)) {
            for (Organization organization : organizations) {
                StringBuffer pr = new StringBuffer();
                pr.append(organization.getId())
                        .append(",")
                        .append(organization.getName())
                        .append(",")
                        .append(organization.getCoordinates().getX())
                        .append(",")
                        .append(organization.getCoordinates().getY())
                        .append(",")
                        .append(organization.getCreationDate())
                        .append(",")
                        .append(organization.getAnnualTurnover())
                        .append(",")
                        .append(organization.getFullName())
                        .append(",")
                        .append(organization.getEmployeesCount())
                        .append(",")
                        .append(organization.getType())
                        .append(",")
                        .append(organization.getPostalAddress().getStreet());
                printWriter.println(pr);
            }
        }catch (java.io.FileNotFoundException e){

        }
    }
    public LinkedHashSet<Organization> readCollectionsOPENCSV(){
        LinkedHashSet<Organization> organizations = new LinkedHashSet<>();
        try{
            FileReader filereader = new FileReader(new File(filename));
            CSVReader csvReader = new CSVReader(filereader);
            String[] nextRecord;
            while ((nextRecord = csvReader.readNext()) != null) {
                Integer id = Integer.parseInt(nextRecord[0]);
                String name = nextRecord[1];
                float x = Float.parseFloat(nextRecord[2]);
                Double y = Double.parseDouble(nextRecord[3]);
                Coordinates coordinates = new Coordinates(x, y);
                String date = nextRecord[4];
                LocalDate creationDate = LocalDate.parse(date);
                float annualTurnover = Float.parseFloat(nextRecord[5]);
                String fullName = nextRecord[6];
                Integer employeesCount = Integer.parseInt(nextRecord[7]);
                OrganizationType type = OrganizationType.getOrganizationType(nextRecord[8]);
                Address postalAddress = new Address(nextRecord[9]);
                Organization organization = new Organization(id, name, coordinates, creationDate, annualTurnover, fullName, employeesCount, type, postalAddress);
                organizations.add(organization);
            }
            return  organizations;
        }catch (FileNotFoundException e){

        }catch (com.opencsv.exceptions.CsvValidationException e){

        }catch (java.io.IOException e){

        }
        return new LinkedHashSet<>();
    }
    public LinkedHashSet<Organization> readCollections(){
        LinkedHashSet<Organization> organizations = new LinkedHashSet<>();
        try(Scanner scanner1 = new Scanner(new File(filename))){
            scanner1.useDelimiter(System.getProperty("line.separator"));
            while(scanner1.hasNext()){
                Scanner scanner = new Scanner(scanner1.nextLine());
                scanner.useDelimiter(",");
                Integer id = Integer.parseInt(scanner.next());
                String name = scanner.next();
                float x = Float.parseFloat(scanner.next());
                Double y = Double.parseDouble(scanner.next());
                Coordinates coordinates = new Coordinates(x, y);
                String date = scanner.next();
                LocalDate creationDate = LocalDate.parse(date);
                float annualTurnover = Float.parseFloat(scanner.next());
                String fullName = scanner.next();
                Integer employeesCount = Integer.parseInt(scanner.next());
                OrganizationType type = OrganizationType.getOrganizationType(scanner.next());
                Address postalAddress = new Address(scanner.next());
                Organization organization = new Organization(id, name, coordinates, creationDate, annualTurnover, fullName, employeesCount, type, postalAddress);
                organizations.add(organization);
            }
            return organizations;
        }catch (java.io.FileNotFoundException e){

        }
        return new LinkedHashSet<>();
    }

}
