public class MedicalConditions {
    // global private variables used to hold values in MedicalConditions object
    private String phy;
    private String num;
    private AllergyType all;
    private IllnessType ill;

    // values that allergy can have (held in an enum)
    enum AllergyType {
        Food, Medication, Seasonal, None, Other
    }
    // values that illness can have (held in an enum)
    enum IllnessType {
        Diabetes, CHD, Asthma, None, Other
    }

    // constructor for medical
    public MedicalConditions(String physician, String phoneNum, String allergy, String illness) {
        phy = physician;
        num = phoneNum;
        all = AllergyType.valueOf(allergy);
        ill = IllnessType.valueOf(illness);
    }

    // used to get name of physician
    public String getPhysicianName() {
        return phy;
    }

    // used to get contact number of physician
    public String getContactNumber() {
        return num;
    }

    // used to get allergy of patient
    public String getAllergy() {
        // using a switch statement, see which of the allergies does the current patient have
        switch(all) {
            case Food:
                return "Food";
            case Medication:
                return "Medication";
            case Seasonal:
                return "Seasonal";
            case None:
                return "None";
            case Other:
                return "Other";
        }
        // if all value doesn't match values in the enum, return error
        return "Error";
    }

    // used to get illness of patient
    public String getIllness() {
        // using a switch statement, see which of the illnesses does the current patient have
        switch(ill) {
            case Diabetes:
                return "Diabetes";
            case CHD:
                return "CHD";
            case Asthma:
                return "Asthma";
            case None:
                return "None";
            case Other:
                return "Other";
        }
        // if ill value doesn't match values in the enum, return error
        return "Error";
    }

    // update the physician of the patient
    public void updatePhysicianName(String name) {
        phy = name;
    }

    // update the contact number of the patient
    public void updateContactNumber(String number) {
        num = number;
    }

    // update the allergy of the patient
    public void updateAllergy(String allergy) {
        all = AllergyType.valueOf(allergy);
    }

    // update the illness of the patient
    public void updateIllness(String illness) {
        ill = IllnessType.valueOf(illness);
    }
}
