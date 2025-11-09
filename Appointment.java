import java.util.ArrayList;
// Part 3 - Appointment类
public class Appointment {
    // 患者详细信息的实例变量
    private String patientName;
    private String patientPhone;
    private String preferredTime;
    // 所选医生 - 使用基类类型以实现多态
    private HealthProfessional selectedDoctor;

    // 默认构造函数
    public Appointment() {
        this.patientName = "Unknown";
        this.patientPhone = "Unknown";
        this.preferredTime = "Unknown";
        this.selectedDoctor = new HealthProfessional();
    }

    // 第二个构造函数
    public Appointment(String patientName, String patientPhone, String preferredTime, HealthProfessional selectedDoctor) {
        this.patientName = patientName;
        this.patientPhone = patientPhone;
        this.preferredTime = preferredTime;
        this.selectedDoctor = selectedDoctor;
    }

    // 打印所有实例变量的方法
    public void printAppointmentDetails() {
        System.out.println("=== Appointment Details ===");
        System.out.println("Patient Name: " + patientName);
        System.out.println("Patient Phone: " + patientPhone);
        System.out.println("Preferred Time: " + preferredTime);
        System.out.println("Doctor: " + selectedDoctor.getName() + " (" + selectedDoctor.getSpecialization() + ")");
        System.out.println();
    }

    // Getter方法
    public String getPatientPhone() { return patientPhone; }
    public String getPatientName() { return patientName; }
}