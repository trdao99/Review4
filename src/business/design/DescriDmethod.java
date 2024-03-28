package business.design;

import business.entity.Department;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//cần chỉnh input để thêm numberEmployee
//chỉnh del khi có employ thì khôgn xóa được
public class DescriDmethod implements DMethod {

    public static List<Department> departmentList = new ArrayList<>();
    Scanner sc = new Scanner(System.in);
    boolean editOrno = true;

    @Override
    public Department inputData() {
        Department department = new Department();
        if (editOrno) {
            departmentList.add(department);
            department.setId(departmentList.indexOf(department) + 1);
        }
        do {
            System.out.println("nhập tên: ");
            String NewName = sc.nextLine();
            boolean NameCorrect = true;
            if (!NewName.trim().isEmpty()) {
                for (int i = 0; i < departmentList.size() - 1; i++) {
                    if (departmentList.get(i).getName().toLowerCase().equals(NewName.toLowerCase())) {
                        System.err.println("tên đã tồn tại ");
                        NameCorrect = false;
                        break;
                    }
                }
                if (NameCorrect) {
                    department.setName(NewName);
                    break;
                }
            } else {
                System.err.println("tên không được để trống");
            }
        } while (true);

        department.setStatus(true);
        int count = 0;
        return department;
    }

    @Override
    public void add() {
        System.out.println("nhập số phòng ban muốn thêm: ");
        int numAdd = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < numAdd; i++) {
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
                for (int i = 0; i < departmentList.size(); i++) {
                    if (departmentList.get(i).getId() == editID) {
                        editOrno = false;
                        Department updatedDepartment = inputData();
                        updatedDepartment.setId(editID);
                        departmentList.set(i, updatedDepartment);
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
            System.out.println("Nhập ID phòng ban muốn xóa:");
            int delID = Integer.parseInt(sc.nextLine());
            if (delID > 0) {
                for (int i = 0; i < departmentList.size(); i++) {
                    if (departmentList.get(i).getId() == delID) {
                        if (departmentList.get(i).getNumberEmployee() > 0) {
                            System.err.println("phòng có nhân viên không thể xóa");
                        } else {
                            departmentList.remove(i);
                            System.out.println("Xóa thành công");
                            break out;
                        }
                    }
                }
                System.err.println("ID không tồn tại");
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
                for (int i = 0; i < departmentList.size(); i++) {
                    if (departmentList.get(i).getId() == SearchID) {
                        System.out.println(departmentList.get(i).toString());
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
                for (int i = 0; i < departmentList.size(); i++) {
                    if (departmentList.get(i).getId() == SwitchID) {
                        departmentList.get(i).setStatus(!departmentList.get(i).isStatus());
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
    public void displayData() {
        departmentList.forEach(v -> System.out.println(v.toString()));
    }

}


