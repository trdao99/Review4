package presentation;

import business.design.Emethod;

import java.util.Scanner;

public class total_manager {
    public static void main(String[] args) {
        D_manager dManager = new D_manager();
        E_manager eManager = new E_manager();
        out:
        do {
            System.out.println("1. quản lý department\n" +
                    "2.quản lý employee\n" +
                    "3. thoát. \n");
            Scanner sc = new Scanner(System.in);
            System.out.println("chọn chức năng:");
            int choose = Integer.parseInt(sc.nextLine());
            switch (choose) {
                case 1:
                    dManager.manager();
                    break;
                case 2:
                    eManager.manager();
                    break;
                case 3:
                    break out;
            }
        }
        while (true);
    }
}
