package business.entity;

import business.entity.Department;

import java.time.LocalDate;

public class Employee {
    private int ID;
    private String name;
    private String phone;
    private String address;
    private LocalDate dateOfBirth;
    private Department department;
    private boolean status;

    public Employee() {
    }

    public Employee(int ID, String name, String phone, String address, LocalDate dateOfBirth, Department department, boolean status) {
        this.ID = ID;
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.dateOfBirth = dateOfBirth;
        this.department = department;
        this.status = status;
    }

    public int getID() {

        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return String.format("ID : %d | Name : %s | phone : %s | birth : %s | department : %s | status : %s", this.ID, this.name, this.phone, this.dateOfBirth.toString(),(this.department==null?"null":this.department.getName()),(this.status? "đang làm": "nghỉ phép "));
    }
}
