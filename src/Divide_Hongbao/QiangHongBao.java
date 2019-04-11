package Divide_Hongbao;

import java.util.Scanner;

public class QiangHongBao {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入红包的金额:");
        double money = sc.nextDouble();
        System.out.println("请输入红包的个数:");
        int num = sc.nextInt();
        System.out.println("请输入抢红包的人数");
        int people = sc.nextInt();
        HongBao hongBao =new HongBao(money,num);
        UserThread user = new UserThread(hongBao);
        for(int i=0;i<people;i++) {
            new Thread(user).start();
        }
    }

}
