package edu.course.lab03;

public class PercentDiscount implements DiscountPolicy{
    private final double procent;
    public PercentDiscount(double procent){
        if (procent > 100 || procent < 0){
            throw new IllegalArgumentException("скидка не может быть меньше 0 и больше 100" + procent);
        }
        this.procent = procent;
    }
    @Override
    public  double apply (double price){
        if (price < 0){
            throw new IllegalArgumentException("цена не может быть  меньше 0" + price);
        }
        return (price - price/100*procent);

    }


}
