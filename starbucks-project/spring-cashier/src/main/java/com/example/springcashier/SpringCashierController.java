package com.example.springcashier;


import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.net.InetAddress;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
//import com.example.springcashier.SpringCashierRepository;
import lombok.extern.slf4j.Slf4j;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import org.springframework.beans.factory.annotation.Value;

@Slf4j
@Controller
@RequestMapping("/user/cashier")
public class SpringCashierController {
    @Value("${API_KEY}")
    private String apiKey;
    @Value("${API_HOST}")
    private String apiHost;
    //private SpringCashierRepository scr;
    @GetMapping
    public String getAction( @ModelAttribute("command") Command command,
                             Model model, HttpSession session) {

        String message = "" ;

        command.setRegister( "5012349" ) ;
        message = "Starbucks Reserved Order" + "\n\n" +
                "Register: " + command.getRegister() + "\n" +
                "Status:   " + "Ready for New Order"+ "\n" ;

        String server_ip = "" ;
        String host_name = "" ;
        try {
            InetAddress ip = InetAddress.getLocalHost() ;
            server_ip = ip.getHostAddress() ;
            host_name = ip.getHostName() ;
        } catch (Exception e) { }

        model.addAttribute( "message", message ) ;
        model.addAttribute( "server",  host_name + "/" + server_ip ) ;

        return "user/starbucks" ;

    }


    @PostMapping
    public String postAction(@Valid @ModelAttribute("command") Command command,
                             @RequestParam(value="action", required=true) String action,
                             Errors errors, Model model, HttpServletRequest request) {

        String message = "" ;

        log.info( "Action: " + action ) ;
        command.setRegister( command.getStores() ) ;
        log.info( "Command: " + command ) ;

        //List<Order> orders = scr.findByRegister(command.getRegister());

        /* Process Post Action */
        if ( action.equals("Place Order") ) {
            RestTemplate restTemplate = new RestTemplate();
            try {
                String drink = request.getParameter("drink");
                String milk = request.getParameter("milk");
                String size = request.getParameter("size");
                message = "";
                String resourceUrl = "http://" + apiHost + "/api/order/register/" + command.getRegister() + "?apikey=" + apiKey;            // get response as POJO
                //String resourceUrl = "http://localhost:8080/order/register/" + command.getRegister();
                Order orderRequest = Order.GetNewOrder(drink, milk, size);
                HttpEntity<Order> newOrderRequest = new HttpEntity<Order>(orderRequest) ;
                ResponseEntity<Order> newOrderResponse = restTemplate.postForEntity(resourceUrl, newOrderRequest, Order.class);
                Order newOrder = newOrderResponse.getBody();
                System.out.println( newOrder );
                orderRequest.setRegister( command.getRegister() ) ;
                //scr.save(orderRequest);
                message = "Starbucks Reserved Order" + "\n\n" +
                        "Drink: " + orderRequest.getDrink() + "\n" +
                        "Milk:  " + orderRequest.getMilk() + "\n" +
                        "Size:  " + orderRequest.getSize() + "\n" +
                        "Total: " + orderRequest.getTotal() + "\n" +
                        "\n" +
                        "Register: " + orderRequest.getRegister() + "\n" +
                        "Status:   " + orderRequest.getStatus() + "\n" ;
            } catch (Exception e) {
                message = "Starbucks Reserved Order" + "\n\n" +
                            "only 1 order per register is allowed";
            }
        }
        else if ( action.equals("Get Order") ) {
            String resourceUrl = "http://" + apiHost + "/api/order/register/" + command.getRegister() + "?apikey=" + apiKey;
            //String resourceUrl = "http://localhost:8080/order/register/" + command.getRegister();

            RestTemplate restTemplate = new RestTemplate();

            try {
                Order order = restTemplate.getForObject(resourceUrl, Order.class);
                message = "Starbucks Reserved Order" + "\n\n" +
                        "Drink: " + order.getDrink() + "\n" +
                        "Milk:  " + order.getMilk() + "\n" +
                        "Size:  " + order.getSize() + "\n" +
                        "Total: " + order.getTotal() + "\n" +
                        "\n" +
                        "Register: " + order.getRegister() + "\n" +
                        "Status:   " + order.getStatus() + "\n";
            } catch (Exception e) {
                message = "Starbucks Reserved Order" + "\n\n" +
                        "Register: " + command.getRegister() + "\n" +
                        "Status:   " + "Ready for New Order"+ "\n" ;
            }
        }
        else if ( action.equals("Clear Order") ) {
            String resourceUrl = "http://" + apiHost + "/api/order/register/" + command.getRegister() + "?apikey=" + apiKey;
            //String resourceUrl = "http://localhost:8080/order/register/" + command.getRegister();

            RestTemplate restTemplate = new RestTemplate();

            try {
                restTemplate.delete(resourceUrl);
            } catch (Exception e) {
                log.info("No order available to clear");
            }
            message = "Starbucks Reserved Order" + "\n\n" +
                    "Register: " + command.getRegister() + "\n" +
                    "Status:   " + "Ready for New Order"+ "\n" ;
        }
        command.setMessage( message ) ;

        String server_ip = "" ;
        String host_name = "" ;
        try {
            InetAddress ip = InetAddress.getLocalHost() ;
            server_ip = ip.getHostAddress() ;
            host_name = ip.getHostName() ;
        } catch (Exception e) { }

        model.addAttribute( "message", message ) ;
        model.addAttribute( "server",  host_name + "/" + server_ip ) ;

        return "user/starbucks" ;

    }


}

