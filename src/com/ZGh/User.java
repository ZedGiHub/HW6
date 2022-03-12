package com.ZGh;

import java.util.ArrayList;

import static com.ZGh.Main.guide;
import static com.ZGh.Main.main;

public class User {
    private String username;
    private String password;
    private String name;
    private String lastName;
    private String province;
    private String city;
    private String avenue;
    private String zipCode;
    private String emailAddress;
    ArrayList<Goods> shoppingCart=new ArrayList<Goods>();

    /* definition of setters for user attributes */
    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setAvenue(String avenue) {
        this.avenue = avenue;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getUsername() {
        return username;
    }

    /* A methode for user authentication */
    public boolean authenticationFunc(String userPass) {
        boolean validOrNot;
        if (password.equals(userPass))
            validOrNot = true;
        else
            validOrNot = false;
        return validOrNot;
    }

    /* Method for adding Goods to shopping cart */
    public void addToCart(Goods goods, int numberOfReserved) {
        /* this item is added before or not?
         * new reserved number will be replaced the privies one*/


        if (goods.reservedNumber > 0) {
            goods.addListUpdate(numberOfReserved);
        } else {
            if (shoppingCart.size() == 5) {
                System.out.println("Your Cart Capacity is full. You can only buy 5 items from the store.");
                guide();
            } else {
                boolean  invalid=goods.addListUpdate(numberOfReserved);
                if(invalid==false){
                shoppingCart.add(goods);}
            }
        }


    }

    /* Method for removing Goods from shopping cart */
    public void removeGoods(Goods goods) {
        shoppingCart.remove(goods);
        goods.removeListUpdate();
    }


}
