package com.example.springcashier;

import java.util.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
class Order {
    private String drink ;
    private String milk ;
    private String size ;
    private double total ;
    private String register ;
    private String status ;

    public static Order GetNewOrder(String drink, String milk, String size) {
        String[] DRINK_OPTIONS = { "Caffe Latte", "Caffe Americano", "Caffe Mocha", "Espresso", "Cappuccino" };
        String[] MILK_OPTIONS = { "Whole Milk", "2% Milk", "Nonfat Milk", "Almond Milk", "Soy Milk" };
        String[] SIZE_OPTIONS = { "Short", "Tall", "Grande", "Venti", "Your Own Cup" };

        Order o = new Order();

        double price = 0;
        switch (drink) {
            case "Caffe Latte":
            case "Cappuccino":
                switch (size) {
                    case "Tall":
                        price = 2.95;
                        break;
                    case "Grande":
                        price = 3.65;
                        break;
                    case "Venti":
                        price = 3.95;
                        break;
                }
                break;
            case "Caffe Americano":
                switch (size) {
                    case "Tall":
                        price = 2.25;
                        break;
                    case "Grande":
                        price = 2.65;
                        break;
                    case "Venti":
                        price = 2.95;
                        break;
                }
                break;
            case "Caffe Mocha":
                switch (size) {
                    case "Tall":
                        price = 3.45;
                        break;
                    case "Grande":
                        price = 4.15;
                        break;
                    case "Venti":
                        price = 4.45;
                        break;
                }
                break;
            case "Espresso":
                switch (size) {
                    case "Short":
                        price = 1.75;
                        break;
                    case "Tall":
                        price = 1.95;
                        break;
                }
                break;
        }
        o.drink = drink;
        o.milk = milk;
        o.size = size;
        o.total = price;
        o.status = "Ready for Payment";
        return o;
    }


}


/*

https://priceqube.com/menu-prices/%E2%98%95-starbucks

var DRINK_OPTIONS = [ "Caffe Latte", "Caffe Americano", "Caffe Mocha", "Espresso", "Cappuccino" ];
var MILK_OPTIONS  = [ "Whole Milk", "2% Milk", "Nonfat Milk", "Almond Milk", "Soy Milk" ];
var SIZE_OPTIONS  = [ "Short", "Tall", "Grande", "Venti", "Your Own Cup" ];

Caffè Latte
=============
tall 	$2.95
grande 	$3.65
venti 	$3.95 (Your Own Cup)

Caffè Americano
===============
tall 	$2.25
grande 	$2.65
venti 	$2.95 (Your Own Cup)

Caffè Mocha
=============
tall 	$3.45
grande 	$4.15
venti 	$4.45 (Your Own Cup)

Cappuccino
==========
tall 	$2.95
grande 	$3.65
venti 	$3.95 (Your Own Cup)

Espresso
========
short 	$1.75
tall 	$1.95

 */



