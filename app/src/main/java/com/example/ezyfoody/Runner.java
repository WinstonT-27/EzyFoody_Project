package com.example.ezyfoody;

import java.util.Vector;

public class Runner {

    public static Vector<Order> orderlist = new Vector<>();
    public static Vector<Order> historylist = new Vector<>();
    public static int money = 5000;
    public static Vector<String> menu = new Vector<>();

    public static void initialize()
    {
        menu.add("Air Mineral/123");
        menu.add("Jus Apel/123");
        menu.add("Jus Mangga/123");
        menu.add("Jus Alpukat/123");
        menu.add("Nasi Putih/300");
        menu.add("Nasi Kuning/350");
        menu.add("Burger/350");
        menu.add("Hot Dog/350");
        menu.add("Risoles/100");
        menu.add("Pukis/100");
        menu.add("Bolu/80");
        menu.add("Martabak/150");
    }

    public static String getPrice(String item)
    {
        for(String s: menu){
            if(s.contains(item)){
                String[]arr = s.split("/");
                return arr[1];
            }
        }
        return null;
    }

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
