package edu.course.lab03;

public class PriceCalculator {
    private final DiscountPolicy policy;
    public PriceCalculator(DiscountPolicy policy){
        if (policy == null){
            throw new IllegalArgumentException("policy не может быть null");
        }
        this.policy = policy;
    }

    public double calculator(double price){
        return policy.apply(price);
    }

}
