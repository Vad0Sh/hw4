package task3;


import task3.Entity.Cars;
import task3.Entity.Clients;
import task3.Entity.Marks;
import task3.Entity.Orders;
import task3.service.CarsService;
import task3.service.ClientsService;
import task3.service.MarksService;
import task3.service.OrdersService;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args)  {
        CarsService carsService = new CarsService();
        ClientsService clientsService = new ClientsService();
        MarksService marksService = new MarksService();
        OrdersService ordersService = new OrdersService();

        Cars cars = new Cars();
        cars.setId(1);
        cars.setMark_id(1);
        cars.setModel("A6");
        cars.setPrice(30000);

        Clients clients = new Clients();
        clients.setId(4);
        clients.setName("Valera");
        clients.setAge(24);
        clients.setPhone("0951234567");

        Marks marks = new Marks();
        marks.setId(3);
        marks.setMark("VW");

        Orders orders = new Orders();
        orders.setCar_id(cars.getId());
        orders.setClient_id(clients.getId());

        try {
            carsService.add(cars);
            clientsService.add(clients);
            marksService.add(marks);
            ordersService.add(orders);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
