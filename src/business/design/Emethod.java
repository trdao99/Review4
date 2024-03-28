package business.design;

import business.entity.Employee;

public interface Emethod extends Method {
    Employee inputData();
    void searchBydepartment();
    void sortByname();
}
