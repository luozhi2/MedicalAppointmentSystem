import java.util.ArrayList;
// Subclass for General Practitioners
public class GeneralPractitioner extends HealthProfessional {
    // Additional instance variable - whether accepting new patients
    private boolean acceptingNewPatients;

    // Default constructor
    public GeneralPractitioner() {
        super();
        this.acceptingNewPatients = true;
    }

    // Parameterized constructor
    public GeneralPractitioner(int ID, String name, String specialization, boolean acceptingNewPatients) {
        super(ID, name, specialization);
        this.acceptingNewPatients = acceptingNewPatients;
    }

    // Method to print professional details
    public void printProfessionalDetails() {
        System.out.println("=== General Practitioner ===");
        super.printDetails();
        System.out.println("Accepting New Patients: " + (acceptingNewPatients ? "Yes" : "No"));
        System.out.println();
    }

    // Getter method
    public boolean isAcceptingNewPatients() { return acceptingNewPatients; }
}