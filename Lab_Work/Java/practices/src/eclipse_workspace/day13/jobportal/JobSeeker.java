package eclipse_workspace.day13.jobportal;

import java.time.LocalDate;
import java.util.Objects;

public class JobSeeker implements Comparable<JobSeeker>{
    String registrationId;
    String name;
    String email;
    String password;
    LocalDate dateOfBirth;
    String aadharId;
    String phone;
    LocalDate graduationDate;
    Degree degree;

    public JobSeeker() {}

    public JobSeeker(String registrationId, String name, String email, String password, LocalDate dateOfBirth, String aadharId, String phone, LocalDate graduationDate, Degree degree) {
        if (dateOfBirth.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("Date of birth cannot be in the future.");
        }

        if (graduationDate.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("Graduation date should be in the past.");
        }

        if (!phone.matches("\\d{10}")) {
            throw new IllegalArgumentException("Phone number must be 10 digits.");
        }

        this.registrationId = registrationId;
        this.name = name;
        this.email = email;
        this.password = password;
        this.dateOfBirth = dateOfBirth;
        this.aadharId = aadharId;
        this.phone = phone;
        this.graduationDate = graduationDate;
        this.degree = degree;
    }

    @Override
    public String toString() {
        return "JobSeeker{" +
                "registrationId=" + registrationId +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", aadharId='" + aadharId + '\'' +
                ", phone=" + phone +
                ", graduationDate=" + graduationDate +
                ", degree=" + degree +
                '}';
    }

//    Override
//    public String toString() {
//        return name + " | " + email + " | " + degree + " | DOB: " + dateOfBirth + " | Grad: " + graduationDate;
//    }


    public String getRegistrationId() {
        return registrationId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getAadharId() {
        return aadharId;
    }

    public void setAadharId(String aadharId) {
        this.aadharId = aadharId;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public LocalDate getGraduationDate() {
        return graduationDate;
    }

    public void setGraduationDate(LocalDate graduationDate) {
        this.graduationDate = graduationDate;
    }

    public Degree getDegree() {
        return degree;
    }

    public void setDegree(Degree degree) {
        this.degree = degree;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JobSeeker jobSeeker = (JobSeeker) o;
        return registrationId == jobSeeker.registrationId && Objects.equals(name, jobSeeker.name) && Objects.equals(email, jobSeeker.email) && Objects.equals(password, jobSeeker.password) && Objects.equals(dateOfBirth, jobSeeker.dateOfBirth) && Objects.equals(aadharId, jobSeeker.aadharId) && Objects.equals(phone, jobSeeker.phone) && Objects.equals(graduationDate, jobSeeker.graduationDate) && Objects.equals(degree, jobSeeker.degree);
    }

    @Override
    public int hashCode() {
        return Objects.hash(registrationId, name, email, password, dateOfBirth, aadharId, phone, graduationDate, degree);
    }

    @Override
    public int compareTo(JobSeeker other) {
        return this.email.compareTo(other.email);
    }
}
