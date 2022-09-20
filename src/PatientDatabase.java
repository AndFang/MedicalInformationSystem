import java.io.*;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class PatientDatabase {
    // global private variables used to hold values in PatientDatabase object
    private final ArrayList<Patient> database = new ArrayList<>(100); // Arraylist used to hold patients
    private int size = 0;
    private int status = 0; // used to convey if there are any errors in the PatientDatabase to the Interface so that it can display the correct error message

    // constructor of PatientDatabase, which takes in a file name and reads from it to populate the database
    public PatientDatabase(String fileName) {
        // checks if the file given exists in the current directory
        Scanner inputStream = null;
        try {
            inputStream = new Scanner(new File(fileName));
        }
        catch (FileNotFoundException e) {
            // status = 1 means that there is an error opening the file
            status = 1;
        }
        // reads from the file and each line corresponds with some data value based on the profile schema
        while (status == 0 && inputStream.hasNextLine()) {
            try {
                String firstName = inputStream.nextLine().trim();
                String lastName = inputStream.nextLine().trim();
                String address = inputStream.nextLine().trim();
                String phoneNumber = inputStream.nextLine().trim();
                String dob = inputStream.nextLine().trim();
                String insurance = inputStream.nextLine().trim();
                Float copay = Float.valueOf(inputStream.nextLine().trim());
                String patientType = inputStream.nextLine().trim();
                String physicianName = inputStream.nextLine().trim();
                String physicianPhone = inputStream.nextLine().trim();
                String allergy = inputStream.nextLine().trim();
                String illness = inputStream.nextLine().trim();
                // calls following function to add patient
                insertProfile(firstName, lastName, address, phoneNumber, dob, insurance, copay, patientType, physicianName, physicianPhone, allergy, illness);
            }
            catch (NoSuchElementException e){
                // if the data given doesn't fill out all the fields of the patient then error is thrown
                // status = 2 means that data file isn't correct format
                status = 2;
            }
        }

        // if there are no errors then close the file
        if (status == 0) {
            inputStream.close();
        }
    }

    // get status of PatientDatabase (used for error checking)
    public int status() {
        return status;
    }

    // makes new patient based on values received and adds it to the database. Increases the size afterwards
    public void insertProfile(String fn, String ln, String a, String pn, String b, String i, float cp, String pt, String pname, String pnum, String all, String ill) {
        Patient newPatient = new Patient(fn, ln, a, pn, b, i, cp, pt, pname, pnum, all, ill);
        database.add(newPatient);
        size += 1;
    }

    // deletes a patient from the database based on the last name and date of birth
    public void deleteProfile(String lastName, String dob, String file) {
        // used to make sure if a patient exists with the given last name and dob
        boolean change = false;
        // goes through the arraylist and checks if a patient has the given last name and dob
        for (int i = 0; i < size; i++) {
            if (database.get(i).getLastName().equals(lastName) && database.get(i).getDateOfBirth().equals(dob)) {
                // if a patient matches the given last name and dob remove it break from the loop
                database.remove(i);
                change = true;
                break;
            }
        }
        if (change == false) {
            // if status == 3 then a patient cannot be removed and return from function
            status = 3;
            return;
        }
        // decrease size of database
        size -= 1;
        // updates the data file with the new database values
        PrintWriter outputStream = null;
        try {
            outputStream = new PrintWriter(file);
        }
        catch(FileNotFoundException e) {

        }
        // prints the contents of each patient to the data file
        for (int i = 0; i < size; i++) {
            outputStream.println(database.get(i).toString());
        }
        // close the file
        outputStream.close();
    }

    // updates a specific field (based on var) of the profile that matches the given last name and dob with data
    public void updateProfile(String lastName, String dob, int var, String data, String file) {
        Patient cur = null; // used to hold which patient is to be updated
        int ind = -1; // index of patient to be updated
        for (int i = 0; i < size; i++) {
            if (database.get(i).getLastName().equals(lastName) && database.get(i).getDateOfBirth().equals(dob)) {
                // if current patient matches the given last name and dob then save the patient and break from loop
                cur = database.get(i);
                ind = i;
                break;
            }
        }
        if (cur == null) {
            // if status = 4 then profile to be updated based on the given last name and dob cannot be found
            status = 4;
            return;
        }
        // based on what val is, update the corresponding field
        // if val = 1, update patient address
        // if val = 2, update patient phone number
        // if val = 3, update patient insurance type
        // if val = 4, update patient co-pay
        // if val = 5, update patient type
        // if val = 6, update patient physician name
        // if val = 7, update patient physician contact info
        // if val = 8, update patient allergy
        // if val = 9, update patient illness
        switch(var) {
            case 1:
                cur.updateAddress(data);
                break;
            case 2:
                cur.updatePhoneNumber(data);
                break;
            case 3:
                cur.updateInsuranceType(data);
                break;
            case 4:
                cur.updateCoPay(Float.valueOf(data));
                break;
            case 5:
                cur.updatePatientType(data);
                break;
            case 6:
                cur.updateData(1, data);
                break;
            case 7:
                cur.updateData(2, data);
                break;
            case 8:
                cur.updateData(3, data);
                break;
            case 9:
                cur.updateData(4, data);
                break;
        }
        // opens up data file to save changes
        PrintWriter outputStream = null;
        try {
            outputStream = new PrintWriter(file);
        }
        catch(FileNotFoundException e) {

        }
        // write contents of each patient to the data file
        for (int i = 0; i < size; i++) {
            outputStream.println(database.get(i).toString());
        }
        outputStream.close();
        // opens up output file to display changes
        try {
            outputStream = new PrintWriter("out.txt");
        }
        catch(FileNotFoundException e) {

        }
        // write contents of updated patient to output file
        outputStream.println(database.get(ind).toString());
        outputStream.close();
    }

    // finds the patient with the given last name and dob and prints out their information
    public void findAndDisplay(String lastName, String dob) {
        // open output file to display contents
        PrintWriter outputStream = null;
        try {
            outputStream = new PrintWriter("out.txt");
        }
        catch(FileNotFoundException e) {
            System.out.println("Error opening the output file");
            System.exit(0);
        }
        // checks if there exists a patient with the given last name and dob
        for (int i = 0; i < size; i++) {
            if (database.get(i).getLastName().equals(lastName) && database.get(i).getDateOfBirth().equals(dob)) {
                outputStream.println(database.get(i).toString());
                break;
            }
        }

        outputStream.close();
    }

    // reports all patients that have the data for a certain field
    public void summary(int var, String data) {
        // open output text file
        PrintWriter outputStream = null;
        try {
            outputStream = new PrintWriter("out.txt");
        }
        catch(FileNotFoundException e) {
            System.out.println("Error opening the output file");
            System.exit(0);
        }
        // check which field is being searched for and which patients have the same value in that field as the requested data
        // depending on which val is given, a field will be chosen.
        // 1:physician, 2:patientType, 3:insuranceType, 4:allergies, 5:illnesses
        // if the given data equals the data of the current patient, then add the patient's name and phone number to output
        switch(var) {
            case 1:
                for (int i = 0; i < size; i++) {
                    Patient cur = database.get(i);
                    if (cur.getData(1).equals(data)) {
                        outputStream.println(cur.getFirstName() + " " + cur.getLastName() + ":" + cur.getPhoneNumber());
                    }
                }
                break;
            case 2:
                for (int i = 0; i < size; i++) {
                    Patient cur = database.get(i);
                    if (cur.getPatientType().equals(data)) {
                        outputStream.println(cur.getFirstName() + " " + cur.getLastName() + ":" + cur.getPhoneNumber());
                    }
                }
                break;
            case 3:
                for (int i = 0; i < size; i++) {
                    Patient cur = database.get(i);
                    if (cur.getInsuranceType().equals(data)) {
                        outputStream.println(cur.getFirstName() + " " + cur.getLastName() + ":" + cur.getPhoneNumber());
                    }
                }
                break;
            case 4:
                for (int i = 0; i < size; i++) {
                    Patient cur = database.get(i);
                    if (cur.getData(3).equals(data)) {
                        outputStream.println(cur.getFirstName() + " " + cur.getLastName() + ":" + cur.getPhoneNumber());
                    }
                }
                break;
            case 5:
                for (int i = 0; i < size; i++) {
                    Patient cur = database.get(i);
                    if (cur.getData(4).equals(data)) {
                        outputStream.println(cur.getFirstName() + " " + cur.getLastName() + ":" + cur.getPhoneNumber());
                    }
                }
                break;
        }

        outputStream.close();
    }

    // used to save the current database to the data file
    public void save(String file) {
        PrintWriter outputStream = null;
        try {
            outputStream = new PrintWriter(file);
        }
        catch(FileNotFoundException e) {

        }
        // prints content of each patient to the file
        for (int i = 0; i < size; i++) {
            outputStream.println(database.get(i).toString());
        }
        // close file
        outputStream.close();
    }

}
