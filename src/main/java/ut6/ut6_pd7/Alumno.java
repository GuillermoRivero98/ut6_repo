package ut6.ut6_pd7;

import java.util.Objects;

public class Alumno {
    private int ID;
    private String fullName;
    private String email;

    public Alumno(int ID, String fullName, String email) {
        this.ID = ID;
        this.fullName = fullName;
        this.email = email;
    }

    public int getID() {
        return ID;
    }

    public String getFullName() {
        return fullName;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Alumno alumno = (Alumno) obj;
        return ID == alumno.ID && 
               Objects.equals(fullName, alumno.fullName) && 
               Objects.equals(email, alumno.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID, fullName, email);
    }
}
