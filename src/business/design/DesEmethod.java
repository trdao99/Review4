package business.design;

import business.entity.Employee;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class DesEmethod implements Emethod {
    public static List<Employee> employeeList = new ArrayList<>();
    Scanner sc = new Scanner(System.in);
    boolean editOrno = true;

    @Override
    public Employee inputData() {
        Employee employee = new Employee();

        if (editOrno) {
            employeeList.add(employee);
            employee.setID(employeeList.indexOf(employee) + 1);
        }
        do {
            System.out.println("nhập tên: ");
            String NewName = sc.nextLine();
            if (!NewName.trim().isEmpty()) {
                employee.setName(NewName);
                break;
            } else {
                System.err.println("tên không được để trống");
            }
        } while (true);
        do {
            System.out.println("nhập địa chỉ");
            String newAdress = sc.nextLine();
            if (!newAdress.trim().isEmpty()) {
                employee.setAddress(newAdress);
                break;
            } else {
                System.err.println("địa chỉ không được để trống");
            }
        } while (true);
        do {
            System.out.println("nhập số điện thoại");
            String newSdt = sc.nextLine();
            String regex = "^(\\+?84|0)(3[2-9]|5[2689]|7[06-9]|8[1-689]|9[0-9])[0-9]{7}$";
            if (!newSdt.trim().isEmpty() && newSdt.matches(regex)) {
                employee.setPhone(newSdt);
                break;
            } else {
                System.err.println("sdt sai");
            }
        } while (true);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        do {
            System.out.println("Nhập ngày sinh:");
            String DOB = sc.nextLine();
            if (!DOB.trim().isEmpty()) {
                LocalDate dateOfBirth = LocalDate.parse(DOB, dtf);
                employee.setDateOfBirth(dateOfBirth);
                break;
            }
        } while (true);
        do {
            DescriDmethod.departmentList.forEach(v -> v.toString());

            if (DescriDmethod.departmentList.size() == 0) {
                System.err.println("chưa có phòng ban");
                employee.setDepartment(null);
                break;
            } else {
                System.out.println("chọn phòng ban");
                int chosseDepartment = Integer.parseInt(sc.nextLine());
                DescriDmethod.departmentList.stream().filter(v -> v.getId() == chosseDepartment).forEach(v -> employee.setDepartment(v));
                for (int i = 0; i < DescriDmethod.departmentList.size(); i++) {
                    if (employee.getDepartment().getName().equals(DescriDmethod.departmentList.get(i).getName())) {
                        DescriDmethod.departmentList.get(i).setNumberEmployee(DescriDmethod.departmentList.get(i).getNumberEmployee() + 1);
                    }
                }
                break;
            }
        }
        while (true);
        employee.setStatus(true);
        return employee;
    }

    @Override
    public void add() {
        System.out.println("nhập số nhân viên muốn them:");
        int addNum = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < addNum; i++) {
            editOrno = true;
            inputData();
        }
    }

    @Override
    public void edit() {
        out:
        do {
            System.out.println("nhập ID muốn sửa");
            int editID = Integer.parseInt(sc.nextLine());
            if (editID > 0) {
                for (int i = 0; i < employeeList.size(); i++) {
                    if (employeeList.get(i).getID() == editID) {
                        editOrno = false;
                        Employee update = inputData();
                        update.setID(editID);
                        employeeList.set(i, update);
                        System.out.println("update thành công");
                        break out;
                    }
                }
                System.err.println("ID không tồn tại");
            } else {
                System.err.println("ID lớn hơn 0");
            }
        } while (true);
    }

    @Override
    public void del() {
        out:
        do {
            System.out.println("nhập ID nhân viên muốn xóa");
            int delID = Integer.parseInt(sc.nextLine());
            if (delID > 0) {
                for (int i = 0; i < employeeList.size(); i++) {
                    if (employeeList.get(i).getID() == delID) {
                        for (int j = 0; j < DescriDmethod.departmentList.size(); j++) {
                            if (DescriDmethod.departmentList.get(j).getName().equals(employeeList.get(i).getDepartment().getName())) {
                                DescriDmethod.departmentList.get(j).setNumberEmployee(DescriDmethod.departmentList.get(j).getNumberEmployee() - 1);
                            }
                        }
                        employeeList.remove(i);
                        System.out.println("Xóa thành công");
                        break out;
                    } else {
                        System.err.println("ID không tồn tại");
                    }
                }
            } else {
                System.err.println("ID phải lớn hơn 0");
            }
        } while (true);
    }

    @Override
    public void search() {
        out:
        do {
            System.out.println("Nhập ID phòng ban muốn xem:");
            int SearchID = Integer.parseInt(sc.nextLine());
            if (SearchID > 0) {
                for (int i = 0; i < employeeList.size(); i++) {
                    if (employeeList.get(i).getID() == SearchID) {
                        System.out.println(employeeList.get(i).toString());
                        break out;
                    }
                }
                System.err.println("ID không tồn tại");
            } else {
                System.err.println("ID phải lớn hơn 0");
            }
        } while (true);
    }

    @Override
    public void switchStatus() {
        out:
        do {
            System.out.println("nhập ID muốn sửa");
            int SwitchID = Integer.parseInt(sc.nextLine());
            if (SwitchID > 0) {
                for (int i = 0; i < employeeList.size(); i++) {
                    if (employeeList.get(i).getID() == SwitchID) {
                        employeeList.get(i).setStatus(!employeeList.get(i).isStatus());
                        System.out.println("update thành công");
                        break out;
                    }
                }
                System.err.println("ID không tồn tại");
            } else {
                System.err.println("ID lớn hơn 0");
            }
        } while (true);
    }

    @Override
    public void searchBydepartment() {
        DescriDmethod.departmentList.forEach(v -> v.toString());
        System.out.println("chọn ID department để xem nhân viên: ");
        int searchBydepartment = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < DescriDmethod.departmentList.size(); i++) {
            if (searchBydepartment == DescriDmethod.departmentList.get(i).getId()) {
                for (int j = 0; j < employeeList.size(); j++) {
                    if (DescriDmethod.departmentList.get(i).getId() == employeeList.get(j).getDepartment().getId()) {
                        System.out.println(employeeList.get(j).toString());
                    }
                }
            }
        }

    }

    @Override
    public void sortByname() {
        List<Employee> sortedList = employeeList.stream()
                .sorted((o1, o2) -> o1.getName().compareTo(o2.getName()))
                .toList();
        employeeList = sortedList;
    }


    @Override
    public void displayData() {
        int k = 0;
        boolean flag ;
        boolean flag2 ;
        out:
        do {
            int j = k + 1;
            for (int i = k; i < j; i++) {
                System.out.println(employeeList.get(i).toString());
            }


            if (k >= 1) {
                System.out.print("1.trang trước");
                flag2 = true;
            }
            else{
                flag2 = false;
            }


            if (j <= employeeList.size() - 1) {
                System.out.print("\t2.trang sau");
                flag = true;
            }
            else{
                flag = false;
            }
            System.out.println("\t3.thoát");
            System.out.print("chọn :");
            int choose = Integer.parseInt(sc.nextLine());
            switch (choose) {
                case 1:
                    if (flag2) {
                        k -= 1;
                    }
                    break;
                case 2:
                    if (flag) {
                        k += 1;
                    }
                    break;
                case 3:
                    break out;
            }
        } while (true);
    }
}
