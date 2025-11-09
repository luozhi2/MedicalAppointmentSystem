import java.util.ArrayList;
import java.util.ArrayList;
import java.util.Scanner;

public class MedicalAppointmentSystem {
    // Part 5 – Collection of appointments
    private static ArrayList<Appointment> appointments = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    // 创建医疗专业人员列表
    private static ArrayList<HealthProfessional> doctors = new ArrayList<>();

    // 初始化医生数据
    public static void initializeDoctors() {
        // 创建医疗专业人员对象
        GeneralPractitioner gp1 = new GeneralPractitioner(101, "Dr. Smith", "Family Medicine", true);
        GeneralPractitioner gp2 = new GeneralPractitioner(102, "Dr. Johnson", "Internal Medicine", false);
        GeneralPractitioner gp3 = new GeneralPractitioner(103, "Dr. Brown", "Pediatrics", true);

        Dermatologist derm1 = new Dermatologist(201, "Dr. Wilson", "Dermatology", "Laser Treatment");
        Dermatologist derm2 = new Dermatologist(202, "Dr. Davis", "Cosmetic Dermatology", "Chemical Peels");

        // 添加到医生列表
        doctors.add(gp1);
        doctors.add(gp2);
        doctors.add(gp3);
        doctors.add(derm1);
        doctors.add(derm2);
    }

    // 显示所有医生
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

    // 创建预约的方法
    public static void createAppointment() {
        System.out.println("=== Create New Appointment ===");

        // 显示可用医生
        displayAllDoctors();

        // 选择医生
        System.out.print("Enter the ID of the doctor you want to book: ");
        int doctorId = scanner.nextInt();
        scanner.nextLine(); // 消耗换行符

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

        // 检查全科医生是否接受新患者
        if (selectedDoctor instanceof GeneralPractitioner) {
            GeneralPractitioner gp = (GeneralPractitioner) selectedDoctor;
            if (!gp.isAcceptingNewPatients()) {
                System.out.println("Error: This doctor is not accepting new patients.");
                return;
            }
        }

        // 获取患者信息
        System.out.print("Enter patient name: ");
        String patientName = scanner.nextLine();

        System.out.print("Enter patient phone: ");
        String patientPhone = scanner.nextLine();

        System.out.print("Enter preferred time: ");
        String preferredTime = scanner.nextLine();

        // 创建预约
        Appointment newAppointment = new Appointment(patientName, patientPhone, preferredTime, selectedDoctor);
        appointments.add(newAppointment);
        System.out.println("Appointment created successfully!");
    }

    // 显示现有预约的方法
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

    // 取消预约的方法
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

    // 显示菜单
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
        // 初始化医生数据
        initializeDoctors();

        System.out.println("Welcome to the Medical Appointment System!");

        boolean running = true;
        while (running) {
            displayMenu();
            int choice = scanner.nextInt();
            scanner.nextLine(); // 消耗换行符

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