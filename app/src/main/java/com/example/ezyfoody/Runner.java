package com.example.ezyfoody;

import android.util.Log;

import java.util.Vector;

public class Runner {

    public static Vector<Order> orderlist = new Vector<>();
    public static Vector<Order> historylist = new Vector<>();
    public static int money = 5000;

    public static void addOrder(String menu, int price, int quantity){
        Order order = new Order(menu, price, quantity);
        orderlist.add(order);
    }

    public static int totalPrice(){
        int totalprice=0;
        if(orderlist.isEmpty()){
            return 0;
        }
        for(int i=0; i<orderlist.size(); i++){
            totalprice = totalprice+orderlist.get(i).getPrice() * orderlist.get(i).getQuantity();
        }

        return totalprice;
    }

    public static void transfer() {
        for(int i=0; i<orderlist.size(); i++){
            historylist.add(orderlist.get(i));
        }

    }
}
