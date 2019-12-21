package view;

import Constant.ConstantNumber;
import domain.MenuRepository;
import domain.TableRepository;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static int inputAction(){
        System.out.println("1 - 주문등록");
        System.out.println("2 - 결제하기");
        System.out.println("3 - 프로그램 종료\n");

        System.out.println("## 원하는 기능을 선택하세요.");
        return scanner.nextInt();
    }

    public static int inputTableNumber() {
        int tableNumber;

        System.out.println("## 주문할 테이블을 선택하세요.");
        tableNumber = scanner.nextInt();
        if(!TableRepository.contains(tableNumber)){
            tableNumber = inputTableNumber();
        }else if(TableRepository.getTablebyNumber(tableNumber).getOrderedMenuNumber()
                >= ConstantNumber.MAX_ORDER){
            System.out.println("더 이상 주문할 수 없습니다.");
            return ConstantNumber.EXIT;
        }

        return tableNumber;
    }

    public static int inputTableNumber_Pay(){
        int tableNumber;

        System.out.println("## 테이블을 선택하세요.");
        tableNumber = scanner.nextInt();
        if(!TableRepository.contains(tableNumber)){
            tableNumber = inputTableNumber();
        }else if(TableRepository.getTablebyNumber(tableNumber).getOrderedMenuNumber()
                == ConstantNumber.ZERO){
            tableNumber = inputTableNumber();
        }

        return tableNumber;
    }

    public static int inputMenu(){
        int menu;

        System.out.println("## 등록할 메뉴를 선택하세요.");
        menu = scanner.nextInt();
        if(!MenuRepository.contains(menu)) {
            menu = inputMenu();
        }

        return menu;
    }

    public static int inputOrderNumber(){
        int order;

        System.out.println("## 메뉴의 수량을 입력하세요. (99개 이하 입력 가능)");
        order = scanner.nextInt();

        if(order > 99){
            order = inputOrderNumber();
        }

        return order;

    }
}
