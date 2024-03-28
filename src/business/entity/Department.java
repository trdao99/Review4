package business.entity;

public class Department {
    private int id;
    private String name;
    private int numberEmployee;
    private boolean Status;

    public Department() {
    }

    public Department(int id, String name, int numberEmployee, boolean status) {
        this.id = id;
        this.name = name;
        this.numberEmployee = numberEmployee;
        Status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberEmployee() {
        return numberEmployee;
    }

    public void setNumberEmployee(int numberEmployee) {
        this.numberEmployee = numberEmployee;
    }

    public boolean isStatus() {
        return Status;
    }

    public void setStatus(boolean status) {
        Status = status;
    }

    @Override
    public String toString() {
        return String.format("Name: %s | ID : %d | number employee : %d | Status : %s \n", this.name,this.id,this.numberEmployee,(this.Status?"đang hoạt động": "không hoạt động"));
    }
}
