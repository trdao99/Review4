package presentation;

import business.design.DMethod;
import business.design.DescriDmethod;

import java.util.Scanner;

public class D_manager {
    public  void manager() {
        out:
        do {
            System.out.println("1. Hiển thị phòng ban\n" +
                    "2. thêm mới department\n" +
                    "3. sửa thông tin department\n" +
                    "4. thay đổi trạng thái department\n" +
                    "5 .tìm kiếm phòng ban\n" +
                    "6.quay lại.");
            Scanner sc = new Scanner(System.in);
            System.out.println("chọn chức năng:");
            int choose = Integer.parseInt(sc.nextLine());
            DMethod descriDmethod = new DescriDmethod();
            switch (choose) {
                case 1:
                    descriDmethod.displayData();
                    break;
                case 2:descriDmethod.add();
                    break;
                case 3:descriDmethod.edit();
                    break;
                case 4:descriDmethod.switchStatus();
                    break;
                case 5:descriDmethod.search();
                    break;
                case 6:
                    break out;
                default:
                    System.err.println("chọn 1-6?");
                    break ;
            }
        } while (true);
    }

}
