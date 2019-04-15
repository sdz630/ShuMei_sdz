package Divide_Hongbao;

import java.math.BigDecimal;
import java.util.Random;

public class HongBao {
    private double leftMoney;
    private int leftNum;
    private double averageMoney;
    private int money;
    private int num;

    public HongBao(double Money, int num) {
        this.leftMoney = Money;
        this.leftNum = num;
        this.averageMoney = Money/leftNum;
        this.num=num;
        this.money=money;
    }

    public synchronized double getRandomMoney(){
        double perMoney;//每个人分配到的金额
        if(leftNum <= 0)/*红包发完了*/{
            perMoney = 0;
        }else if(leftNum == 1){
            perMoney =leftMoney;//如果是最后一个
        }else {
            while(true) {
                try{
                    Thread.sleep(1000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                int count;
                if (leftMoney/ leftNum >= averageMoney){
                    count = new Random().nextInt(300);
                }else {
                    count = new Random().nextInt(100);
                }
                double percentage = count / 100.0;
                perMoney = averageMoney * percentage;
                leftMoney = leftMoney - perMoney;
                if (leftMoney / (leftNum - 1) >= 0.01 && perMoney > 0) break;
            }
        }
        leftNum--;
        //此处使用四舍五入,可能会导致有微小误差;
        BigDecimal b = new BigDecimal(perMoney);
        perMoney = b.setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();
        return perMoney;
    }
}
