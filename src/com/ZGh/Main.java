package com.ZGh;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static User signUp() {
        User user = new User();
        System.out.println("Enter your desired 'Username' (Necessary): ");
        Scanner input = new Scanner(System.in);
        String name = input.nextLine();
        while (name.length() < 1) {
            name = input.nextLine();
        }
        user.setUsername(name);

        System.out.println("Enter your 'Password' (Necessary) : ");
        String pass = input.nextLine();
        while (pass.length() < 1) {
            pass = input.nextLine();
        }
        user.setPassword(pass);

        System.out.println("Please answer the following details (Not necessary, Enter to skipp them):");
        System.out.println("First name:");
        user.setName(input.nextLine());

        System.out.println("Last name:");
        user.setLastName(input.nextLine());

        System.out.println("Province:");
        user.setProvince(input.nextLine());

        System.out.println("City:");
        user.setCity(input.nextLine());

        System.out.println("Avenue:");
        user.setAvenue(input.nextLine());

        System.out.println("Zip code:");
        user.setZipCode(input.nextLine());

        System.out.println("email address:");
        user.setEmailAddress(input.nextLine());

        return user;
    }

    static void display(ArrayList<Goods> electronics, ArrayList<Goods> shoes, ArrayList<Goods> books) {

        System.out.println("Store Goods in Stock:\n");
        System.out.println("-----------------------------------------------------------------------------------------\nElectronics Devices: \nCode   name                         price        stock count ");
        for (Goods e : electronics) {
            System.out.println(e.code + "   " + e.name + " " + e.price + " toman         " + e.availableNumber);
        }
        System.out.println("-----------------------------------------------------------------------------------------\nShoes:\nCode   name                         price        stock count ");
        for (Goods s : shoes) {
            System.out.println(s.code + "   " + s.name + " " + s.price + " toman         " + s.availableNumber);
        }
        System.out.println("-----------------------------------------------------------------------------------------\nBooks:\nCode   name                         price        stock count ");
        for (Goods b : books) {
            System.out.println(b.code + "   " + b.name + " " + b.price + " toman         " + b.availableNumber);
        }
        System.out.println("\n\n");
    }

    public static void guide() {
        System.out.println("SHOPPING GUIDE:" +
                "\n Enter the 'l' key to the show list of goods in stock." +
                "\n Enter the 'o' key to order new item or reorder an item with new number." +
                "\n Enter the 'r' key to remove an item from your cart. " +
                "\n Enter the 'sl' key to show your shopping list and the total cost. " +
                "\n Enter the 'f' key for final approval of your shopping cart." +
                "\n Enter the 'q' key to end running.");


    }

    public static void main(String[] args) {
        /* The goods and their features are defined here*/
        /*Electronics Stuffs: */
        Goods laptop1 = new Goods("Surface Laptop Go - A      ", 1, 19_010_000, 100, 0);
        Goods laptop2 = new Goods("IdeaPad 3 15IGL05 - Z      ", 2, 8_100_000, 90, 0);
        Goods radio1 = new Goods("RX-BT88SQ                  ", 3, 742_000, 200, 0);
        Goods radio2 = new Goods("RX-608ACW                  ", 4, 310_000, 150, 0);
        Goods TV1 = new Goods("SLD-32SA1220              ", 5, 4_597_000, 54, 0);
        Goods TV2 = new Goods("x-vision 55XTU835           ", 6, 16_100_000, 24, 0);
        ArrayList<Goods> electronics = new ArrayList<Goods>(Arrays.asList(laptop1, laptop2, radio1, radio2, TV1, TV2));

        /* Shoes */
        Goods shoe1 = new Goods("Skechers 52813NVY            ", 7, 2_100_000, 10, 0);
        Goods shoe2 = new Goods("Skechers 52938BKCC           ", 8, 2_625_000, 12, 0);
        ArrayList<Goods> shoes = new ArrayList<>(Arrays.asList(shoe1, shoe2));

        /* Books */
        Goods book1 = new Goods("Jane Eyre by Charlotte Brontë ", 9, 120_000, 30, 0);
        Goods book2 = new Goods("Anna Karenina by Leo Tolstoy  ", 10, 200_000, 32, 0);
        Goods book3 = new Goods("Emma by Jane Austen           ", 11, 50_000, 41, 0);
        ArrayList<Goods> books = new ArrayList<>(Arrays.asList(book1, book2, book3));

//        /* List of all items */
        ArrayList<Goods> goodsList = new ArrayList<>();
        goodsList.addAll(electronics);
        goodsList.addAll(shoes);
        goodsList.addAll(books);
        User user = new User();
        Scanner input = new Scanner(System.in);
        System.out.println("***** Welcome to the store *****\n******* Enter to sign up ******* ");
        int counter = 0;
        while (true) {
            String inputC = input.nextLine();
            if (counter == 0) {

                    user = signUp();
                    counter++;
                    System.out.println("***** Hello " + user.getUsername() + "! You signed up  successfully.*****\n");
                    System.out.println("-------------------------------\nEnter to see the list of goods:\n-------------------------------\n");
                    input.nextLine();
                    display(electronics, shoes, books);

                    System.out.println("\n----------------------------\nEnter to see shopping guide:\n----------------------------");
                    input.nextLine();
                    guide();


            }
            else if (inputC.equals("o")) {
                System.out.println("\n-------------------------------\nEnter the code of desired item:\n-------------------------------");
                int code = input.nextInt();
                if (code < 1 || code > 11) {
                    System.out.println("!!!There is no item with this code!!!");
                    afterOperation();

                } else {
                    System.out.println("\n--------------------------\nEnter the number of the item you need:\n--------------------------");
                    int number = input.nextInt();
                    order(user, goodsList, code, number);
                    afterOperation();
                }

            }
            else if (inputC.equals("r")) {
                Scanner in = new Scanner(System.in);
                System.out.println("\n---------------------------------------------\nEnter the code of the item to remove\n---------------------------------------------");
                int code = in.nextInt();
                remove(user, goodsList, code);
                afterOperation();
            }

            else if (inputC.equals("sl")) {
                cartDisplay(user);
                afterOperation();
            }
            else if (inputC.equals("g")) {
                guide();
            }
            else if (inputC.equals("l")) {
                display(electronics, shoes, books);
                afterOperation();
            }
            else if (inputC.equals("f")){
                cartDisplay(user);
                System.out.println("***** Your shopping is done! *****");
                user.shoppingCart=new ArrayList<Goods>();

            }
            else if(inputC.equals("q")){
                break;
            }
//            else
//                System.out.println("!!!Invalid input!!!");


        }


    }

    public static void order(User user, ArrayList<Goods> goodsList, int code, int number) {
        Goods goods = goodsList.get(code - 1);
        user.addToCart(goods, number);
    }

    public static void remove(User user, ArrayList<Goods> goodsList, int code) {
        Goods goods = goodsList.get(code - 1);
        user.removeGoods(goods);
    }

    public static void cartDisplay(User user) {
        float totalCost = 0;
        ArrayList<Goods> cart = user.shoppingCart;
        if (cart.size() < 1) System.out.println("~~ Your shopping cart is empty ~~");
        else {
            System.out.println("\n------------------\nyour shopping list:\n------------------\nCode   name                         price        reserved_number   ");
            for (Goods c : cart) {
                System.out.println(c.code + "   " + c.name + " " + c.price + " toman         " + c.reservedNumber);
                totalCost += c.price * c.reservedNumber;
            }
        }
        System.out.println("-----------------------------------------------------------------------------------------\n                                 The total_cost:  " + totalCost + "  toman");
    }

    public static void afterOperation() {
        System.out.println("");
        System.out.println("\n--------------------------------------------------\nEnter your desired command, based on SHOPPING GUIDE  \nOr enter the 'g' to see the SHOPPING GUIDE again\n--------------------------------------------------");

    }

    public static boolean cancelOperation(String input) {
        boolean cancelOrNot = false;
        if (input.equals("c")) {
            cancelOrNot = true;
            System.out.println("The previous operation was canceled");
            afterOperation();
        }
        return cancelOrNot;
    }
}
