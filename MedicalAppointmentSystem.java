import java.util.ArrayList;
import java.util.Scanner;

public class MedicalAppointmentSystem {
    // Collection of appointments
    private static ArrayList<Appointment> appointments = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    // List of healthcare professionals
    private static ArrayList<HealthProfessional> doctors = new ArrayList<>();

    // Initialize doctor data
    public static void initializeDoctors() {
        // Create healthcare professional objects
        GeneralPractitioner gp1 = new GeneralPractitioner(101, "Dr. Smith", "Family Medicine", true);
        GeneralPractitioner gp2 = new GeneralPractitioner(102, "Dr. Johnson", "Internal Medicine", false);
        GeneralPractitioner gp3 = new GeneralPractitioner(103, "Dr. Brown", "Pediatrics", true);

        Dermatologist derm1 = new Dermatologist(201, "Dr. Wilson", "Dermatology", "Laser Treatment");
        Dermatologist derm2 = new Dermatologist(202, "Dr. Davis", "Cosmetic Dermatology", "Chemical Peels");

        // Add to doctors list
        doctors.add(gp1);
        doctors.add(gp2);
        doctors.add(gp3);
        doctors.add(derm1);
        doctors.add(derm2);
    }

    // Display all doctors
    public static void displayAllDoctors() {
        System.out.println("=== Available Medical Professionals ===");
        for (int i = 0; i < doctors.size(); i++) {
            HealthProfessional doctor = doctors.get(i);
            if (doctor instanceof GeneralPractitioner) {
                ((GeneralPractitioner) doctor).printProfessionalDetails();
            } else if (doctor instanceof Dermatologist) {
                ((Dermatologist) doctor).printProfessionalDetails();
            }
        }
    }

    // Method to create an appointment
    public static void createAppointment() {
        System.out.println("=== Create New Appointment ===");

        // Display available doctors
        displayAllDoctors();

        // Select doctor
        System.out.print("Enter the ID of the doctor you want to book: ");
        int doctorId = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        HealthProfessional selectedDoctor = null;
        for (HealthProfessional doctor : doctors) {
            if (doctor.getID() == doctorId) {
                selectedDoctor = doctor;
                break;
            }
        }

        if (selectedDoctor == null) {
            System.out.println("Error: Doctor with ID " + doctorId + " not found.");
            return;
        }

        // Check if general practitioner is accepting new patients
        if (selectedDoctor instanceof GeneralPractitioner) {
            GeneralPractitioner gp = (GeneralPractitioner) selectedDoctor;
            if (!gp.isAcceptingNewPatients()) {
                System.out.println("Error: This doctor is not accepting new patients.");
                return;
            }
        }

        // Get patient information
        System.out.print("Enter patient name: ");
        String patientName = scanner.nextLine();

        System.out.print("Enter patient phone: ");
        String patientPhone = scanner.nextLine();

        System.out.print("Enter preferred time: ");
        String preferredTime = scanner.nextLine();

        // Create appointment
        Appointment newAppointment = new Appointment(patientName, patientPhone, preferredTime, selectedDoctor);
        appointments.add(newAppointment);
        System.out.println("Appointment created successfully!");
    }

    // Method to display existing appointments
    public static void printExistingAppointments() {
        if (appointments.isEmpty()) {
            System.out.println("No appointments found.");
            return;
        }

        System.out.println("=== All Appointments ===");
        for (int i = 0; i < appointments.size(); i++) {
            System.out.println("Appointment #" + (i + 1));
            appointments.get(i).printAppointmentDetails();
        }
    }

    // Method to cancel a booking
    public static void cancelBooking() {
        if (appointments.isEmpty()) {
            System.out.println("No appointments to cancel.");
            return;
        }

        System.out.print("Enter patient phone number to cancel appointment: ");
        String patientPhone = scanner.nextLine();

        for (int i = 0; i < appointments.size(); i++) {
            if (appointments.get(i).getPatientPhone().equals(patientPhone)) {
                System.out.println("Found appointment for: " + appointments.get(i).getPatientName());
                System.out.print("Are you sure you want to cancel this appointment? (yes/no): ");
                String confirmation = scanner.nextLine();

                if (confirmation.equalsIgnoreCase("yes")) {
                    appointments.remove(i);
                    System.out.println("Appointment cancelled successfully!");
                } else {
                    System.out.println("Cancellation aborted.");
                }
                return;
            }
        }
        System.out.println("Error: No appointment found with phone number: " + patientPhone);
    }

    // Display menu
    public static void displayMenu() {
        System.out.println("\n=== Medical Appointment System ===");
        System.out.println("1. View All Doctors");
        System.out.println("2. Create Appointment");
        System.out.println("3. View All Appointments");
        System.out.println("4. Cancel Appointment");
        System.out.println("5. Exit");
        System.out.print("Please choose an option (1-5): ");
    }

    public static void main(String[] args) {
        // Initialize doctor data
        initializeDoctors();

        System.out.println("Welcome to the Medical Appointment System!");

        boolean running = true;
        while (running) {
            displayMenu();
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    displayAllDoctors();
                    break;
                case 2:
                    createAppointment();
                    break;
                case 3:
                    printExistingAppointments();
                    break;
                case 4:
                    cancelBooking();
                    break;
                case 5:
                    running = false;
                    System.out.println("Thank you for using the Medical Appointment System. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }

        scanner.close();
    }
}