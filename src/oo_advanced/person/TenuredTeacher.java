package oo_advanced.person;

/*
Clase ProfesorTitular que hereda de Teacher.
Dispone de un método que devuelve la fecha del aprobado de la oposición.
 */

import java.time.LocalDate;

public class TenuredTeacher extends Teacher {
    private LocalDate examDate;

    public TenuredTeacher(String name, int age, char gender, double weight, double height, String module1,
            String module2, String module3, String module4, LocalDate examDate) {
        super(name, age, gender, weight, height, module1, module2, module3, module4);
        this.examDate = examDate;
    }

    public LocalDate getExamDate() {
        return examDate;
    }

    public void setExamDate(LocalDate examDate) {
        this.examDate = examDate;
    }

    public String getExamDateInfo() {
        return "Fecha de oposición: " + examDate.toString();
    }
}
