import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;
import java.awt.Desktop;
import java.io.*;

public class PatientProfileInterface implements ActionListener{
    // global variables used for elements of the GUI. They are split up into panels
    // with the name of the elements of each panel starting with the panel name
    private PatientDatabase db;
    private String file;
    private JFrame f;
    private JButton back;

    private JPanel start;
    private JButton startSubmit;
    private JLabel startMessage;
    private JTextField startText;

    private JPanel welcome;
    private JButton welcomeNewPatient;
    private JButton welcomeDeletePatient;
    private JButton welcomeDisplayPatient;
    private JButton welcomeModifyPatient;
    private JButton welcomeSearchDB;
    private JButton welcomeData;

    private JPanel profile;
    private JLabel profileFNMessage;
    private JLabel profileLNMessage;
    private JLabel profileAddressMessage;
    private JLabel profilePhoneMessage;
    private JLabel profileDOBMessage;
    private JLabel profileInsuranceMessage;
    private JLabel profileCoPayMessage;
    private JLabel profilePatientMessage;
    private JLabel profilePhysicianMessage;
    private JLabel profilePhysicianPhoneMessage;
    private JLabel profileAllergyMessage;
    private JLabel profileIllnessMessage;
    private JLabel profileMessage;
    private JButton profileSubmit;
    private JTextField profileFN;
    private JTextField profileLN;
    private JTextField profileAddress;
    private JTextField profilePhone;
    private JTextField profileDOB;
    private JTextField profileInsurance;
    private JTextField profileCoPay;
    private JTextField profilePatient;
    private JTextField profilePhysician;
    private JTextField profilePhysicianPhone;
    private JTextField profileAllergy;
    private JTextField profileIllness;
    private JLabel profileBLANK;

    private JPanel delete;
    private JLabel deleteNameMessage;
    private JTextField deleteName;
    private JLabel deleteDOBMessage;
    private JTextField deleteDOB;
    private JButton deleteSubmit;
    private JLabel deleteMessage;

    private JPanel display;
    private JLabel displayNameMessage;
    private JTextField displayName;
    private JLabel displayDOBMessage;
    private JTextField displayDOB;
    private JButton displaySubmit;
    private JLabel displayMessage;

    private JPanel modify;
    private JLabel modifyLabel;
    private JComboBox<String> modifyOption;
    private JTextField modifyData;
    private JLabel modifyNameMessage;
    private JTextField modifyName;
    private JLabel modifyDOBMessage;
    private JTextField modifyDOB;
    private JButton modifySubmit;
    private JLabel modifyMessage;

    private JPanel search;
    private JLabel searchLabel;
    private JComboBox<String> searchOption;
    private JTextField searchData;
    private JButton searchSubmit;
    private JLabel searchMessage;

    // constructor of the GUI that initializes all the global variables
    PatientProfileInterface() {
        // creates the window and close the program upon exit
        // also initializes the back button used to return to the welcome page
        f = new JFrame();
        f.setResizable(false);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        back = new JButton("Go back");
        back.addActionListener(this);

        // initialize components of the start page which requires the user to enter the data file
        // includes a text field, submit button, and a message field
        start = new JPanel();
        start.setBounds(75,150,350,200);
        start.setBorder(new EmptyBorder(40, 40, 40, 40));
        start.setLayout(new GridLayout(3, 1));
        startSubmit = new JButton("Submit");
        startSubmit.addActionListener(this);
        startMessage = new JLabel("Welcome to the MIS. Please enter the data file.");
        startText = new JTextField(32);
        start.add(startText);
        start.add(startSubmit);
        start.add(startMessage);

        // initialize components of the welcome page which has a button for all the actions that the user can perform on the database
        // each button will take the user to the page that corresponds with that action
        welcome = new JPanel();
        welcome.setBounds(0,0,500,500);
        welcome.setBorder(new EmptyBorder(40, 40, 40, 40));
        welcome.setLayout(new GridLayout(6, 1));
        welcomeNewPatient = new JButton("Enter a new patient");
        welcomeNewPatient.addActionListener(this);
        welcomeDeletePatient = new JButton("Delete a patient");
        welcomeDeletePatient.addActionListener(this);
        welcomeDisplayPatient = new JButton("Find and display a patient");
        welcomeDisplayPatient.addActionListener(this);
        welcomeModifyPatient = new JButton("Modify a patient profile");
        welcomeModifyPatient.addActionListener(this);
        welcomeSearchDB = new JButton("Search the database");
        welcomeSearchDB.addActionListener(this);
        welcomeData = new JButton("View data");
        welcomeData.addActionListener(this);
        welcome.add(welcomeNewPatient);
        welcome.add(welcomeDeletePatient);
        welcome.add(welcomeDisplayPatient);
        welcome.add(welcomeModifyPatient);
        welcome.add(welcomeSearchDB);
        welcome.add(welcomeData);

        // page to add a new patient to the database
        // contains a label and text field for each argument in patient, submit button, and result message
        profile = new JPanel();
        profile.setBounds(0,0,500,500);
        profile.setBorder(new EmptyBorder(40, 40, 40, 40));
        profile.setLayout(new GridLayout(14, 2));
        profileFNMessage = new JLabel("First name");
        profileLNMessage = new JLabel("Last name");
        profileAddressMessage = new JLabel("Address");
        profilePhoneMessage = new JLabel("Phone number");
        profileDOBMessage = new JLabel("Date of birth");
        profileInsuranceMessage = new JLabel("Insurance type");
        profileCoPayMessage = new JLabel("Co-Pay");
        profilePatientMessage = new JLabel("Patient type");
        profilePhysicianMessage = new JLabel("Physician name");
        profilePhysicianPhoneMessage = new JLabel("Physician phone number");
        profileAllergyMessage = new JLabel("Allergy");
        profileIllnessMessage = new JLabel("Illness");
        profileMessage = new JLabel();
        profileSubmit = new JButton("Add profile");
        profileSubmit.addActionListener(this);
        profileFN = new JTextField();
        profileLN = new JTextField();
        profileAddress = new JTextField();
        profilePhone = new JTextField();
        profileDOB = new JTextField();
        profileInsurance = new JTextField();
        profileCoPay = new JTextField();
        profilePatient = new JTextField();
        profilePhysician = new JTextField();
        profilePhysicianPhone = new JTextField();
        profileAllergy = new JTextField();
        profileIllness = new JTextField();
        profileBLANK = new JLabel();
        profile.add(profileFNMessage);
        profile.add(profileFN);
        profile.add(profileLNMessage);
        profile.add(profileLN);
        profile.add(profileAddressMessage);
        profile.add(profileAddress);
        profile.add(profilePhoneMessage);
        profile.add(profilePhone);
        profile.add(profileDOBMessage);
        profile.add(profileDOB);
        profile.add(profileInsuranceMessage);
        profile.add(profileInsurance);
        profile.add(profileCoPayMessage);
        profile.add(profileCoPay);
        profile.add(profilePatientMessage);
        profile.add(profilePatient);
        profile.add(profilePhysicianMessage);
        profile.add(profilePhysician);
        profile.add(profilePhysicianPhoneMessage);
        profile.add(profilePhysicianPhone);
        profile.add(profileAllergyMessage);
        profile.add(profileAllergy);
        profile.add(profileIllnessMessage);
        profile.add(profileIllness);
        profile.add(profileMessage);
        profile.add(profileBLANK);
        profile.add(profileSubmit);

        // initializes components of to delete patient page
        // has a field where users can put in the last name and dob, submit button, and resulting message
        delete = new JPanel();
        delete.setBounds(0,0,500,500);
        delete.setBorder(new EmptyBorder(40, 40, 40, 40));
        delete.setLayout(new GridLayout(7, 1));
        deleteNameMessage = new JLabel("Enter last name of the patient to be deleted:");
        deleteName = new JTextField();
        deleteDOBMessage = new JLabel("Enter DOB of the patient to be deleted:");
        deleteDOB = new JTextField();
        deleteSubmit = new JButton("Submit");
        deleteSubmit.addActionListener(this);
        deleteMessage = new JLabel();
        delete.add(deleteNameMessage);
        delete.add(deleteName);
        delete.add(deleteDOBMessage);
        delete.add(deleteDOB);
        delete.add(deleteSubmit);
        delete.add(deleteMessage);

        // initializes components of to display patient page
        // has a field where users can put in the last name and dob, submit button, and resulting message
        display = new JPanel();
        display.setBounds(0,0,500,500);
        display.setBorder(new EmptyBorder(40, 40, 40, 40));
        display.setLayout(new GridLayout(7, 1));
        displayNameMessage = new JLabel("Enter last name of the patient to be displayed:");
        displayName = new JTextField();
        displayDOBMessage = new JLabel("Enter DOB of the patient to be deisplayed:");
        displayDOB = new JTextField();
        displaySubmit = new JButton("Submit");
        displaySubmit.addActionListener(this);
        displayMessage = new JLabel();
        display.add(displayNameMessage);
        display.add(displayName);
        display.add(displayDOBMessage);
        display.add(displayDOB);
        display.add(displaySubmit);
        display.add(displayMessage);

        // initializes components of to modify patient page
        // has a field where users can choose what they want to change, data they want to input,
        // put in the last name and dob, submit button, and resulting message
        modify = new JPanel();
        modify.setBounds(0,0,500,500);
        modify.setBorder(new EmptyBorder(40, 40, 40, 40));
        modify.setLayout(new GridLayout(10, 1));
        modifyLabel = new JLabel("Modify (choose option below)");
        String [] options1 = {"Address", "Phone number", "Insurance type", "Co-Pay", "Patient type", "Physician", "Patient", "Insurance Type", "Allergy", "Illness"};
        modifyOption = new JComboBox<String>(options1);
        modifyData = new JTextField();
        modifyNameMessage = new JLabel("Enter last name of the patient to be modified:");
        modifyName = new JTextField();
        modifyDOBMessage = new JLabel("Enter DOB of the patient to be modified:");
        modifyDOB = new JTextField();
        modifySubmit = new JButton("Modify");
        modifySubmit.addActionListener(this);
        modifyMessage = new JLabel();
        modify.add(modifyLabel);
        modify.add(modifyOption);
        modify.add(modifyData);
        modify.add(modifyNameMessage);
        modify.add(modifyName);
        modify.add(modifyDOBMessage);
        modify.add(modifyDOB);
        modify.add(modifySubmit);
        modify.add(modifyMessage);

        // initializes components of to search patient page
        // has a field where users can select which feature to search by and by what value,
        // put in the last name and dob, submit button, and resulting message
        search = new JPanel();
        search.setBounds(0,0,500,500);
        search.setBorder(new EmptyBorder(40, 40, 40, 40));
        search.setLayout(new GridLayout(6, 1));
        searchLabel = new JLabel("Search by (choose option below)");
        String [] options2 = {"Physician", "Patient", "Insurance Type", "Allergy", "Illness"};
        searchOption = new JComboBox<String>(options2);
        searchData = new JTextField();
        searchSubmit = new JButton("Search");
        searchSubmit.addActionListener(this);
        searchMessage = new JLabel();
        search.add(searchLabel);
        search.add(searchOption);
        search.add(searchData);
        search.add(searchSubmit);
        search.add(searchMessage);

        // make and display the starting screen the panel which requests the url of the page, set size of window
        f.add(start);
        f.setSize(500, 500);
        f.setLayout(null);
        f.setVisible(true);
    }

    // set all values of components to blank (so that old results aren't reloaded when going back to that screen)
    public void setBlank() {
        profileFN.setText("");
        profileLN.setText("");
        profileAddress.setText("");
        profilePhone.setText("");
        profileDOB.setText("");
        profileInsurance.setText("");
        profileCoPay.setText("");
        profilePatient.setText("");
        profilePhysician.setText("");
        profilePhysicianPhone.setText("");
        profileAllergy.setText("");
        profileIllness.setText("");
        profileMessage.setText("");
        deleteName.setText("");
        deleteDOB.setText("");
        deleteMessage.setText("");
        displayName.setText("");
        displayDOB.setText("");
        displayMessage.setText("");
        modifyData.setText("");
        modifyMessage.setText("");
        modifyName.setText("");
        modifyDOB.setText("");
        searchData.setText("");
        searchMessage.setText("");
    }

    // maps the functionality of each button click so that when clicked, it brings to the proper page or performs the
    // correct function
    public void actionPerformed(ActionEvent e) {
        // when the back button is clicked, remove all panels and clear fields, then set the screen to the welcome panel
        if (e.getSource() == back) {
            f.remove(profile);
            f.remove(delete);
            f.remove(display);
            f.remove(modify);
            f.remove(search);
            setBlank();
            f.add(welcome);
            f.invalidate();
            f.validate();
            f.repaint();
        }
        // when the start submit button is clicked, checks if the data file exists
        if (e.getSource() == startSubmit) {
            // get file name from input
            file = startText.getText();
            // adds .txt to file name if not included
            if (!file.contains(".txt")) {
                file += ".txt";
            }
            // makes a new database based on input file
            db = new PatientDatabase(file);
            startText.setText("");
            // if there aren't any errors with opening the data file, then set screen to welcome page
            if (db.status() == 0) {
                f.remove(start);
                f.add(welcome);
                f.invalidate();
                f.validate();
                f.repaint();
            }
            // if file doesn't exist, throw error
            if (db.status() == 1) {
                startMessage.setText("Error opening the data file " + file);
            }
            // if incorrect format in file, throw error
            if (db.status() == 2) {
                startMessage.setText("Corrupt data (incorrect format)");
            }
        }
        // set page to make new profile if corresponding button is clicked
        if (e.getSource() == welcomeNewPatient) {
            f.remove(welcome);
            f.add(profile);
            profile.add(back);
            f.invalidate();
            f.validate();
            f.repaint();
        }
        // set page to delete profile if corresponding button is clicked
        if (e.getSource() == welcomeDeletePatient) {
            f.remove(welcome);
            f.add(delete);
            delete.add(back);
            f.invalidate();
            f.validate();
            f.repaint();
        }
        // set page to display profile if corresponding button is clicked
        if (e.getSource() == welcomeDisplayPatient) {
            f.remove(welcome);
            f.add(display);
            display.add(back);
            f.invalidate();
            f.validate();
            f.repaint();
        }
        // set page to modify profile if corresponding button is clicked
        if (e.getSource() == welcomeModifyPatient) {
            f.remove(welcome);
            f.add(modify);
            modify.add(back);
            f.invalidate();
            f.validate();
            f.repaint();
        }
        // set page to display profile if corresponding button is clicked
        if (e.getSource() == welcomeSearchDB) {
            f.remove(welcome);
            f.add(search);
            search.add(back);
            f.invalidate();
            f.validate();
            f.repaint();
        }
        // open up data file in notepad
        if (e.getSource() == welcomeData) {
            // open up file and use commands to open it as a notepad file
            File dataFile = new File(file);
            Desktop desktop = Desktop.getDesktop();
            try {
                desktop.open(dataFile);
            }
            catch (Exception exc) {

            }
        }
        // when user clicks submit the information it is saved into the database
        if (e.getSource() == profileSubmit) {
            // gets all parameters from the textfields
            boolean error = false;
            String firstName = profileFN.getText();
            String lastName = profileLN.getText();
            String address = profileAddress.getText();
            String phoneNumber = profilePhone.getText();
            String dob = profileDOB.getText();
            String insurance = profileInsurance.getText();
            Float copay = -1.0f;
            // sees if the value for copay is a number
            try {
                copay = Float.valueOf(profileCoPay.getText());
            }
            catch (NumberFormatException ex) {
                profileMessage.setText("CoPay must be a number");
                error = true;
            }
            String patientType = profilePatient.getText();
            String physicianName = profilePhysician.getText();
            String physicianPhone = profilePhysicianPhone.getText();
            String allergy = profileAllergy.getText();
            String illness = profileIllness.getText();
            // if one of the fields are empty display message to fill them in
            if (firstName.length() == 0 || lastName.length() == 0 || address.length() == 0 || phoneNumber.length() == 0 || dob.length() == 0 || insurance.length() == 0 || profileCoPay.getText().length() == 0 || patientType.length() == 0 || physicianName.length() == 0 || physicianPhone.length() == 0 || allergy.length() == 0 || illness.length() == 0) {
                profileMessage.setText("Please fill out the fields");
            }
            else {
                try {
                    // adds new patient information to database and make all text fields empty
                    db.insertProfile(firstName, lastName, address, phoneNumber, dob, insurance, copay, patientType, physicianName, physicianPhone, allergy, illness);
                    db.save(file);
                    profileMessage.setText("Successfully added new patient");
                    profileFN.setText("");
                    profileLN.setText("");
                    profileAddress.setText("");
                    profilePhone.setText("");
                    profileDOB.setText("");
                    profileInsurance.setText("");
                    profileCoPay.setText("");
                    profilePatient.setText("");
                    profilePhysician.setText("");
                    profilePhysicianPhone.setText("");
                    profileAllergy.setText("");
                    profileIllness.setText("");
                }
                // checks if the data values entered are valid
                catch (IllegalArgumentException exc) {
                    if (!error) {
                        profileMessage.setText("Error with data values");
                    }
                }
            }


        }
        // when user clicks submit the profile is deleted if it exists in the database
        if (e.getSource() == deleteSubmit) {
            // gets data from the text fields
            String last = deleteName.getText();
            String dob = deleteDOB.getText();
            // checks if any of the text fields are empty
            if (last.length() == 0 || dob.length() == 0) {
                deleteMessage.setText("Please fill out the fields");
            }
            else {
                // attempts to delete the patient from the database using function
                db.deleteProfile(last, dob, file);
                // error if patient information doesn't exist
                if (db.status() == 3) {
                    deleteMessage.setText("Patient does not exist");
                }
                else {
                    // successfully deletes the patient
                    deleteMessage.setText("Successfully deleted");
                    deleteName.setText("");
                    deleteDOB.setText("");
                }
            }
        }
        // when user clicks submit the profile is displayed if it exists
        if (e.getSource() == displaySubmit) {
            // gets data from text fields
            String last = displayName.getText();
            String dob = displayDOB.getText();

            // use function to find patient
            db.findAndDisplay(last, dob);
            String cur = System.getProperty("user.dir") + "\\out.txt";
            File dataFile = new File(cur);
            // open current file and if length is 0 then patient is not found
            if (dataFile.length() == 0) {
                displayMessage.setText("Patient doesn't exist");
            }
            else {
                Desktop desktop = Desktop.getDesktop();
                try {
                    desktop.open(dataFile);
                }
                catch (Exception exc) {

                }
                displayMessage.setText("Success");
            }
            // resets both text fields
            displayName.setText("");
            displayDOB.setText("");
        }
        // modify the patient if it exists
        if (e.getSource() == modifySubmit) {
            // get data from text fields
            int i = -1;
            String val = modifyOption.getSelectedItem().toString();
            String data = modifyData.getText();
            String last = modifyName.getText();
            String dob = modifyDOB.getText();
            // if a text field is empty throw error
            if (data.length() == 0 || last.length() == 0|| dob.length() == 0) {
                modifyMessage.setText("Please fill out the fields");
            }
            else {
                // sees which field is getting changed
                if (val.equals("Address")) {
                    i = 1;
                }
                if (val.equals("Phone number")) {
                    i = 2;
                }
                if (val.equals("Insurance type")) {
                    i = 3;
                }
                if (val.equals("Co-Pay")) {
                    i = 4;
                }
                if (val.equals("Patient type")) {
                    i = 5;
                }
                if (val.equals("Physician")) {
                    i = 6;
                }
                if (val.equals("Patient")) {
                    i = 7;
                }
                if (val.equals("Allergy")) {
                    i = 8;
                }
                if (val.equals("Illness")) {
                    i = 9;
                }
            }
            // attempts to change patient field to input data value
            boolean error = false;
            try {
                db.updateProfile(last, dob, i, data, file);
            }
            catch (Exception exc) {
                // if incorrect format throw error
                modifyMessage.setText("Incorrect input type");
                error = true;
            }
            // checks if patient exists or not
            if (db.status() == 4) {
                modifyMessage.setText("Patient doesn't exist");
            }
            else if (!error){
                // opens up the output file which contains the updated patient information
                String cur = System.getProperty("user.dir") + "\\out.txt";
                File dataFile = new File(cur);
                Desktop desktop = Desktop.getDesktop();
                try {
                    desktop.open(dataFile);
                }
                catch (Exception exc) {

                }
                // if no errors then print success and clear fields
                if (!error) {
                    modifyMessage.setText("Success");
                    modifyName.setText("");
                    modifyDOB.setText("");
                }
            }
        }
        // when user clicks submit profiles that have a certain data value for certain field
        if (e.getSource() == searchSubmit) {
            // get data values from text fields
            int i = -1;
            String val = searchOption.getSelectedItem().toString();
            String data = searchData.getText();
            // sees which field is getting changed
            if (val.equals("Physician")) {
                i = 1;
            }
            if (val.equals("Patient")) {
                i = 2;
            }
            if (val.equals("Insurance Type")) {
                i = 3;
            }
            if (val.equals("Allergy")) {
                i = 4;
            }
            if (val.equals("Illness")) {
                i = 5;
            }
            // get list of patients with certain value in certain field
            db.summary(i, data);
            String cur = System.getProperty("user.dir") + "\\out.txt";
            File dataFile = new File(cur);
            // if nothing in output text file then no patient is found
            if (dataFile.length() == 0) {
                searchMessage.setText("No patients with '" + data + "' for '" + val + "'");
            }
            else {
                // opens up output file that contains the patients and display message of success
                Desktop desktop = Desktop.getDesktop();
                try {
                    desktop.open(dataFile);
                }
                catch (Exception exc) {

                }
                searchMessage.setText("All patients with '" + data + "' for '" + val + "'");
            }
            searchData.setText("");
        }
    }

    // call the PatientProfileInterface object which starts up the GUI
    public static void main(String[] args) {
            new PatientProfileInterface();
    }
}