package oo_advanced.person;

/*
Clase ProfesorInterino que hereda de Teacher.
Dispone de un método que devuelve la fecha de inicio de la interinidad.
 */

import java.time.LocalDate;

public class SubstituteTeacher extends Teacher {
    private LocalDate startDate;

    public SubstituteTeacher(String name, int age, char gender, double weight, double height,
            String module1, String module2, String module3, String module4,
            LocalDate startDate) {
        super(name, age, gender, weight, height, module1, module2, module3, module4);
        this.startDate = startDate;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public String getInterimStartDate() {
        return "Fecha de inicio de interinidad: " + startDate.toString();
    }
}
