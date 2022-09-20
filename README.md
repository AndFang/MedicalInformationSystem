# Medical Information System (MIS)
This program is used to run a database and alter it. Through a GUI, users are able to load up a database and change certain attributes of it or request information from the data. It focuses on establishing a repository of patient profiles that can be utilized in many different ways within the MIS.

## Files
- **MedicalConditions.java**: Class for information of a medical condition. Contains ...
  - Physician name
  - Physician phone number
  - Allergy type *(Food, Medication, Seasonal, None, Other)*
  - Illness type *(Diabetes, CHD, Asthma, None, Other)*
- **Patient.java**: Class for information of a patient. Contains ... 
  - First name
  - Last name
  - Address
  - Phone number
  - Date of birth
  - Insurance type *(Private, Government)*
  - Co pay
  - Patient type *(Pediatric, Adult, Geriatric)*
  - Medical conditions
- **PatientDatabase.java**: Class for establishing and manipulating the databased for patients.
  - Creates database from input file
  - Creates, delete, updates patient profile
  - Prints out information of patient
  - Find all patients that match a certain criteria
  - Saves current state of database to file
- **PatientProfileInterface.java**: Establishes the GUI for the program and functionality for buttons or text boxes.

- **data.txt**: Data of the system. When the program first starts up it requires an input file to read the data from.
- **out.txt**: Any output of data from the program if any a query is made.
- **testcases.txt**: Used for testing out the program.

## Instructions
When loading up the program, user must give the file name a data file before proceeding. It checks if the file exists and if the data is in the proper format. After proceeding with a correct data file, there are a few actions that alters the database. Safeguards are in place in which data is not processed if input for a text field is missing. Additionally the database is saved whenever the program is terminated.
- **Enter a new patient**: Adds a patient profile to the database.
- **Delete a patient**: Deletes a patient profile from the database based on last name and date of birth.
- **Find and display a patient**: Retrives information of a patient profile based on last name and date of birth.
- **Modify a patient profile**: Able to change the fields of a patient profile.
- **Search the database**: Returns patient profiles which match the value for a given field.
- **View data**: Opens up the data file of the database.
