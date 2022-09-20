public class Patient {
    // global private variables used to hold values in Patient object
    private String fname;
    private String lname;
    private String addr;
    private String num;
    private String dob;
    private InsuranceType ins;
    private float pay;
    private PatientType pat;
    private MedicalConditions data;

    // values that insurance can have (held in an enum)
    enum InsuranceType {
        Private, Government
    }

    // values that patient type can have (held in an enum)
    enum PatientType {
        Pediatric, Adult, Geriatric
    }

    // constructor of Patient, creates a patient based on values given
    public Patient(String fn, String ln, String a, String pn, String b, String i, float cp, String pt, String pname, String pnum, String all, String ill) {
        fname = fn;
        lname = ln;
        addr = a;
        num = pn;
        dob = b;
        ins = InsuranceType.valueOf(i);
        pay = cp;
        pat = PatientType.valueOf(pt);
        data = new MedicalConditions(pname, pnum, all, ill);
    }

    // how a Patient object is printed out
    public String toString() {
        String str = "";
        str += getFirstName() + "\n";
        str += getLastName() + "\n";
        str += getAddress() + "\n";
        str += getPhoneNumber() + "\n";
        str += getDateOfBirth() + "\n";
        str += getInsuranceType() + "\n";
        str += Float.toString(getCoPay()) + "\n";
        str += getPatientType() + "\n";
        str += getData(1) + "\n";
        str += getData(2) + "\n";
        str += getData(3) + "\n";
        str += getData(4);
        return str;
    }

    // used to get first name of patient
    public String getFirstName() {
        return fname;
    }

    // used to get last name of the patient
    public String getLastName() {
        return lname;
    }

    // used to get address of the patient
    public String getAddress() {
        return addr;
    }

    // used to get phone number of the patient
    public String getPhoneNumber() {
        return num;
    }

    // used to get the date of birth of the patient
    public String getDateOfBirth() {
        return dob;
    }

    // used to get the insurance of the patient
    public String getInsuranceType() {
        // using a switch statement, see which of the insurance types does the current patient have
        switch(ins) {
            case Private:
                return "Private";
            case Government:
                return "Government";
        }
        // if ins value doesn't match values in the enum, return error
        return "Error";
    }

    public float getCoPay() {
        return pay;
    }

    public String getPatientType() {
        // using a switch statement, see which of the patient types does the current patient have
        switch(pat) {
            case Pediatric:
                return "Pediatric";
            case Adult:
                return "Adult";
            case Geriatric:
                return "Geriatric";
        }
        // if pat value doesn't match values in the enum, return error
        return "Error";
    }

    // used to get data of the MedicalConditions object of the patient
    public String getData(int i) {
        // passed in a value and depending on what that value is, get the corresponding data value
        // if i = 1, get name of physician
        // if i = 2, get contact number of physician
        // if i = 3, get allergy of current patient
        // if i = 4, get illness of current patient
        switch(i) {
            case 1:
                return data.getPhysicianName();
            case 2:
                return data.getContactNumber();
            case 3:
                return data.getAllergy();
            case 4:
                return data.getIllness();
        }
        // if i value doesn't match values in the enum, return error
        return "Error";
    }

    // set up update values for each variable in patient, even if they wouldn't update

    // used to update first name of patient (however not used)
    public void updateFirstName(String newName) {
        fname = newName;
    }

    // used to update last name of patient (however not used)
    public void updateLastName(String newName) {
        lname = newName;
    }

    // used to update address of patient
    public void updateAddress(String newAddress) {
        addr = newAddress;
    }

    // used to update phone number of patient
    public void updatePhoneNumber(String newNumber) {
        num = newNumber;
    }

    // used to update date of birth of patient (however not used)
    public void updateDateOfBirth(String newBirth) {
        dob = newBirth;
    }

    // used to update insurance type of patient
    public void updateInsuranceType(String newInsurance) {
        ins = InsuranceType.valueOf(newInsurance);
    }

    // used to update co-pay of patient
    public void updateCoPay(float newCoPay) {
        pay = newCoPay;
    }

    // used to update patient type of patient
    public void updatePatientType(String newPatient) {
        pat = PatientType.valueOf(newPatient);
    }

    // used to update data of the MedicalConditions object of the patient
    public void updateData(int i, String info) {
        // passed in a value and depending on what that value is, update the corresponding data value
        // if i = 1, update name of physician
        // if i = 2, update contact number of physician
        // if i = 3, update allergy of current patient
        // if i = 4, update illness of current patient
        switch(i) {
            case 1:
                data.updatePhysicianName(info);
                break;
            case 2:
                data.updateContactNumber(info);
                break;
            case 3:
                data.updateAllergy(info);
                break;
            case 4:
                data.updateIllness(info);
                break;
        }
    }
}
