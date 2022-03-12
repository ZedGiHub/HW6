package com.ZGh;

public class Goods {
    public String name;
    public float price;
    public int code;
    public int availableNumber;
    public int reservedNumber;
    public boolean isAvailable = (availableNumber > 0);

    public Goods(String name, int code, float price, int number, int reserved) {
        this.name = name;
        this.code = code;
        this.price = price;
        this.availableNumber = number;
        this.reservedNumber = reserved;
    }

    /* List updating after adding new item to cart */
    public boolean addListUpdate(int numberOfaAdded) {
        boolean invalidNumber=false;
        this.availableNumber+=this.reservedNumber;
            if(this.availableNumber-numberOfaAdded<0){
                System.out.println("Inventory is not enough, We have only "+this.availableNumber+" of them in stock");
                this.availableNumber-=this.reservedNumber;
                invalidNumber=true;}
            else if(numberOfaAdded<0) {System.out.println("invalid number");
                this.availableNumber-=this.reservedNumber;
                invalidNumber=true;}
            else{
            this.availableNumber -= numberOfaAdded;
            this.reservedNumber = numberOfaAdded;
            }
            return invalidNumber;


    }

    /* List updating after removing an item from cart */
    public void removeListUpdate(){
        if(this.reservedNumber<1)
            System.out.println("!!!This item doesn't exist in your cart to remove!!!");
        else{
            this.availableNumber+=this.reservedNumber;
            this.reservedNumber=0;
        }
    }

    /* For changing the primary price */
    public void setPrice(float price) {
        this.price = price;
    }




}
