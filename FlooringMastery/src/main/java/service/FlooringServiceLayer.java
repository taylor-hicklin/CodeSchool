package service;

import dao.FlooringPersistenceException;
import dto.Order;
import dto.Product;
import dto.Tax;

import java.time.LocalDate;
import java.util.List;

public interface FlooringServiceLayer {
    List<Order> retrieveAllOrdersByDate(LocalDate orderDate) throws FlooringPersistenceException, OrderNotFoundException, DateNotFoundException;
    List<Product> retrieveAllProducts() throws FlooringPersistenceException;
    List<Tax> retrieveAllTaxes() throws FlooringPersistenceException;
    Order processOrder(Order orderObj) throws FlooringPersistenceException, TaxStateNotFoundException, ProductMaterialNotFoundException;
    Order addOrder(Order orderObj) throws FlooringPersistenceException, TaxStateNotFoundException, ProductMaterialNotFoundException;
    Order retrieveOrderByDateAndId(LocalDate orderDate, int orderNumber) throws FlooringPersistenceException, OrderNotFoundException, DateNotFoundException;
    void removeOrder(LocalDate orderDate, int orderNumber) throws FlooringPersistenceException, OrderNotFoundException, DateNotFoundException;
    Order editOrder(Order orderObj) throws FlooringPersistenceException, TaxStateNotFoundException, ProductMaterialNotFoundException;
    void saveAllOrders() throws FlooringPersistenceException;
    boolean activateTrainingMode();

}
