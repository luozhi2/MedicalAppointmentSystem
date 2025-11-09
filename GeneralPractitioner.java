import java.util.ArrayList;
// Part 2 - 子类
public class GeneralPractitioner extends HealthProfessional {
    // 额外的实例变量 - 是否接受新患者
    private boolean acceptingNewPatients;

    // 默认构造函数
    public GeneralPractitioner() {
        super();
        this.acceptingNewPatients = true;
    }

    // 第二个构造函数
    public GeneralPractitioner(int ID, String name, String specialization, boolean acceptingNewPatients) {
        super(ID, name, specialization);
        this.acceptingNewPatients = acceptingNewPatients;
    }

    // 打印详细信息的方法
    public void printProfessionalDetails() {
        System.out.println("=== General Practitioner ===");
        super.printDetails();
        System.out.println("Accepting New Patients: " + (acceptingNewPatients ? "Yes" : "No"));
        System.out.println();
    }

    // Getter方法
    public boolean isAcceptingNewPatients() { return acceptingNewPatients; }
}