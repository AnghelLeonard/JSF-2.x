package com.bean;

import java.math.BigDecimal;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class NumberBean {

    private Double nr1;
    private Integer nr2;
    private Number discount = 0.05;
    private BigDecimal price = new BigDecimal(2645.5);

    public NumberBean() {
    }

    public Double getNr1() {
        return nr1;
    }

    public void setNr1(Double nr1) {
        this.nr1 = nr1;
    }

    public Integer getNr2() {
        return nr2;
    }

    public void setNr2(Integer nr2) {
        this.nr2 = nr2;
    }

    public Number getDiscount() {
        return discount;
    }

    public void setDiscount(Number discount) {
        this.discount = discount;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void send1() {
        System.out.println("nr1 = " + nr1);
    }

    public void send2() {
        System.out.println("nr2 = " + nr2);
    }

}
