import java.util.ArrayList;
// Part 1 - 基类
public class HealthProfessional {
    // 必需的实例变量
    private int ID;
    private String name;
    // 另一个相关的实例变量 - 专业领域
    private String specialization;

    // 默认构造函数
    public HealthProfessional() {
        this.ID = 0;
        this.name = "Unknown";
        this.specialization = "General";
    }

    // 第二个构造函数
    public HealthProfessional(int ID, String name, String specialization) {
        this.ID = ID;
        this.name = name;
        this.specialization = specialization;
    }

    // 打印所有实例变量的方法
    public void printDetails() {
        System.out.println("ID: " + ID);
        System.out.println("Name: " + name);
        System.out.println("Specialization: " + specialization);
    }

    // Getter方法
    public int getID() { return ID; }
    public String getName() { return name; }
    public String getSpecialization() { return specialization; }
}