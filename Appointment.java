import java.util.ArrayList;
// Appointment class to manage patient bookings
public class Appointment {
    // Instance variables for patient details
    private String patientName;
    private String patientPhone;
    private String preferredTime;
    // Selected doctor - using base class type for polymorphism
    private HealthProfessional selectedDoctor;

    // Default constructor
    public Appointment() {
        this.patientName = "Unknown";
        this.patientPhone = "Unknown";
        this.preferredTime = "Unknown";
        this.selectedDoctor = new HealthProfessional();
    }

    // Parameterized constructor
    public Appointment(String patientName, String patientPhone, String preferredTime, HealthProfessional selectedDoctor) {
        this.patientName = patientName;
        this.patientPhone = patientPhone;
        this.preferredTime = preferredTime;
        this.selectedDoctor = selectedDoctor;
    }

    // Method to print all instance variables
    public void printAppointmentDetails() {
        System.out.println("=== Appointment Details ===");
        System.out.println("Patient Name: " + patientName);
        System.out.println("Patient Phone: " + patientPhone);
        System.out.println("Preferred Time: " + preferredTime);
        System.out.println("Doctor: " + selectedDoctor.getName() + " (" + selectedDoctor.getSpecialization() + ")");
        System.out.println();
    }

    // Getter methods
    public String getPatientPhone() { return patientPhone; }
    public String getPatientName() { return patientName; }
}