package oo_advanced.person;

public class Teacher extends Person {
    private String module1;
    private String module2;
    private String module3;
    private String module4;

    public Teacher(String name, int age, char gender, double weight, double height,
            String module1, String module2, String module3, String module4) {
        super(name, age, gender, weight, height);
        this.module1 = module1;
        this.module2 = module2;
        this.module3 = module3;
        this.module4 = module4;
    }

    public String getModule1() {
        return module1;
    }

    public void setModule1(String module1) {
        this.module1 = module1;
    }

    public String getModule2() {
        return module2;
    }

    public void setModule2(String module2) {
        this.module2 = module2;
    }

    public String getModule3() {
        return module3;
    }

    public void setModule3(String module3) {
        this.module3 = module3;
    }

    public String getModule4() {
        return module4;
    }

    public void setModule4(String module4) {
        this.module4 = module4;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", modules={" + module1 + ", " + module2 + ", " + module3 + ", " + module4 + "}";
    }
}
