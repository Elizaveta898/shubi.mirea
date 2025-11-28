package Pr7;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Locale;

public class Task3Student {
    private String name;
    private Date birthDate;

    public Task3Student(String name, Date birthDate) {
        this.name = name;
        this.birthDate = birthDate;
    }

    // Геттеры и сеттеры
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Date getBirthDate() { return birthDate; }
    public void setBirthDate(Date birthDate) { this.birthDate = birthDate; }

    @Override
    public String toString() {
        return "Student{name='" + name + "', birthDate=" +
                formatBirthDate("MEDIUM") + "}";
    }

    public String formatBirthDate(String formatType) {
        SimpleDateFormat formatter;

        switch (formatType.toUpperCase()) {
            case "SHORT":
                formatter = new SimpleDateFormat("dd.MM.yy");
                break;
            case "MEDIUM":
                formatter = new SimpleDateFormat("dd MMM yyyy", new Locale("ru"));
                break;
            case "LONG":
                formatter = new SimpleDateFormat("dd MMMM yyyy 'г.'", new Locale("ru"));
                break;
            case "FULL":
                formatter = new SimpleDateFormat("EEEE, dd MMMM yyyy 'г.'", new Locale("ru"));
                break;
            default:
                formatter = new SimpleDateFormat("dd.MM.yyyy");
        }

        return formatter.format(birthDate);
    }
}