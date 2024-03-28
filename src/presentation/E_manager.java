package presentation;

import business.design.DesEmethod;
import business.design.DescriDmethod;
import business.design.Emethod;

import java.util.Scanner;

public class E_manager {
    public  void manager() {
        out:
        do {
            System.out.println("1. Hiển thị employee\n" +
                    "2. thêm mới employee\n" +
                    "3. sửa thông tin employee\n" +
                    "4. thay đổi trạng thái employee\n" +
                    "5 .tìm kiếm employee\n" +
                    "6. Sắp xếp nhân viên theo tên tăng dần\n" +
                    "7. tìm nhân viên theo mã phòng ban.\n" +
                    "8.quay lại.\n");
            Scanner sc = new Scanner(System.in);
            System.out.println("chọn chức năng:");
            int choose = Integer.parseInt(sc.nextLine());
            Emethod emethod = new DesEmethod() {
            };
            switch (choose) {
                case 1:
                    emethod.displayData();
                    break;
                case 2:
                    emethod.add();
                    break;
                case 3:
                    emethod.edit();
                    break;
                case 4:
                    emethod.switchStatus();
                    break;
                case 5:
                    emethod.search();
                    break;
                case 6:
                    emethod.sortByname();
                    break;
                case 7:
                    emethod.searchBydepartment();
                    break;
                case 8:
                    break out;
                default:
                    System.err.println("chọn 1-8?");
                    break;
            }
        } while (true);
    }
}
