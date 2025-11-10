import java.util.ArrayList;
// Subclass for Dermatologists
public class Dermatologist extends HealthProfessional {
    // Additional instance variable - types of special treatments available
    private String specialTreatments;

    // Default constructor
    public Dermatologist() {
        super();
        this.specialTreatments = "Basic Dermatology";
    }

    // Parameterized constructor
    public Dermatologist(int ID, String name, String specialization, String specialTreatments) {
        super(ID, name, specialization);
        this.specialTreatments = specialTreatments;
    }

    // Method to print professional details
    public void printProfessionalDetails() {
        System.out.println("=== Dermatologist ===");
        super.printDetails();
        System.out.println("Special Treatments: " + specialTreatments);
        System.out.println();
    }

    // Getter method
    public String getSpecialTreatments() { return specialTreatments; }
}