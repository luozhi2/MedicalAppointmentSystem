import java.util.ArrayList;
// Part 2 - 子类
public class Dermatologist extends HealthProfessional {
    // 额外的实例变量 - 可进行的特殊治疗类型
    private String specialTreatments;

    // 默认构造函数
    public Dermatologist() {
        super();
        this.specialTreatments = "Basic Dermatology";
    }

    // 第二个构造函数
    public Dermatologist(int ID, String name, String specialization, String specialTreatments) {
        super(ID, name, specialization);
        this.specialTreatments = specialTreatments;
    }

    // 打印详细信息的方法
    public void printProfessionalDetails() {
        System.out.println("=== Dermatologist ===");
        super.printDetails();
        System.out.println("Special Treatments: " + specialTreatments);
        System.out.println();
    }

    // Getter方法
    public String getSpecialTreatments() { return specialTreatments; }
}