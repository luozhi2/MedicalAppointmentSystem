import java.util.ArrayList;
// Base class for all health professionals
public class HealthProfessional {
    // Required instance variables
    private int ID;
    private String name;
    // Additional instance variable - specialization field
    private String specialization;

    // Default constructor
    public HealthProfessional() {
        this.ID = 0;
        this.name = "Unknown";
        this.specialization = "General";
    }

    // Parameterized constructor
    public HealthProfessional(int ID, String name, String specialization) {
        this.ID = ID;
        this.name = name;
        this.specialization = specialization;
    }

    // Method to print all instance variables
    public void printDetails() {
        System.out.println("ID: " + ID);
        System.out.println("Name: " + name);
        System.out.println("Specialization: " + specialization);
    }

    // Getter methods
    public int getID() { return ID; }
    public String getName() { return name; }
    public String getSpecialization() { return specialization; }
}