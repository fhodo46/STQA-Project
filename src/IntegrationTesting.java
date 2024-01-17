//The integration testing will be further extended with test cases; this is only the beginning

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.*;
import static org.junit.Assert.*; import static org.mockito.Mockito.*;



class ProductCatalogProductIntegration{



    @Test public void testProductProductCatalogIntegration(){
        Product product= new Product("P001", "Laptop", 999.99,10);
        ProductCatalog productCatalogMock= Mockito.mock(ProductCatalog.class);
        ProductController productController= new ProductController(productCatalogMock);
        productController.addToCatalog(product);
        Mockito.verify(productCatalogMock).addProduct(product);
    }
}





class CustomerCustomerCatalogIntegrationTesting {
    @Test public void testCustomerCustomerCatalogIntegration()
    {
        Customer customer= new Customer("C001", "John Doe","john@gmail.com", 1000.00);
        CustomerCatalog customerCatalogMock= Mockito.mock(CustomerCatalog.class);
        CustomerController customerController= new CustomerController(customerCatalogMock);
        customerController.addToCatalog(customer);

        Mockito.verify(customerCatalogMock).addCustomer(customer);
    } }












class ProductShoppingCartIntegration{
    @Test
    public void testProductShoppingCartIntegration(){
        Product product= new Product("P001","Laptop", 999.99,10);
        ShoppingCart shoppingCart= new ShoppingCart();
        shoppingCart.addItem(product);
        assertTrue(shoppingCart.getCartItems().contains(product));
    } }

class CustomerOrderIntegration{
    @Test
    public void testCustomerOrderIntegration(){
        Customer customer= new Customer("C001","John Doe", "john@gmail.com", 1000.00);
        Order order= new Order("O001",null,new ArrayList<>(), new Date());
        order.setCustomer(customer);
        assertEquals(customer, order.getCustomer());
    }
}
class ProductOrderIntegration{
    @Test
    public void testProductOrderIntegration(){
        Product product= new Product("P001","Laptop",999.99,10);
        Order order= new Order("O001",new Customer("C001", "John Doe", "john@gmail.com",1000.00), new ArrayList<>(), new Date());
        order.getProducts().add(product);
        assertTrue(order.getProducts().contains(product));
    } }


class CustomerOrderManagerIntegration{
    @Test
    public void testCustomerOrderManagerIntegration(){
        Customer customer= new Customer("C001","John Doe", "john@gmail.com", 1000.00);
        OrderManager orderManager= new OrderManager();
        Order order= new Order("O001", customer, new ArrayList<>(), new Date());
        orderManager.placeOrder(order);
        assertTrue(orderManager.getAllOrders().contains(order));
    }
}



















class ProductControllerShoppingCartIntegration{
    @Test
    public void testProductControllerShoppingCartIntegration(){
        Product product= new Product("P001", "Laptop", 999.99,10);
        ProductController productController= new ProductController(new ProductCatalog());
        ShoppingCart shoppingCart= new ShoppingCart();
        productController.addToCatalog(product);
        shoppingCart.addItem(product);
        assertTrue(shoppingCart.getCartItems().contains(product));
    }
}


class ProductCatalogOrderManagerIntegration{
    @Test
    public void testProductCatalogOrderManagerIntegration(){
        ProductCatalog productCatalog= new ProductCatalog();
        OrderManager orderManager= new OrderManager();
        Product product= new Product("P001","Laptop",999.99,10);
        productCatalog.addProduct(product);
        Order order= new Order("O001", new Customer("C001","John Doe", "john@gmail.com", 1000.00), Collections.singletonList(product),new Date());
        orderManager.placeOrder(order);
        assertTrue(orderManager.getAllOrders().contains(order));
    }
}
class CustomerCatalogOrderManagerIntegration{
    @Test
    public void testCustomerCatalogOrderManagerIntegration(){
        CustomerCatalog customerCatalog= new CustomerCatalog();
        OrderManager orderManager= new OrderManager();
        Customer customer= new Customer("C001","John Doe", "john@gmail.com", 1000.00);
        customerCatalog.addCustomer(customer);
        Order order= new Order("O001", customer, Collections.emptyList(), new Date());
        orderManager.placeOrder(order);
        assertTrue(orderManager.getAllOrders().contains(order));
    }
}












class IntegrationTestForAllClasses{
    @Test
    public void testIntegrationForAllClasses(){
        ProductCatalog productCatalog= new ProductCatalog();
        ProductController productController= new ProductController(productCatalog);
        ShoppingCart shoppingCart= new ShoppingCart();
        OrderManager orderManager= new OrderManager();
        CustomerCatalog customerCatalog= new CustomerCatalog();
        CustomerController customerController= new CustomerController(customerCatalog);
        OnlineStore onlineStore= new OnlineStore();

        OnlineStoreManagementSystem system= new OnlineStoreManagementSystem(productController, customerController);
        Product laptop= new Product("P001", "Laptop",999.99,10);
        Product smartphone= new Product("P002","Smartphone", 499.99,20);
        productController.addToCatalog(laptop);
        productController.addToCatalog(smartphone);

        Customer customer= new Customer("C001","John Doe", "john@gmail.com", 1000.00);
        customerController.addToCatalog(customer);



        Order order= new Order("O001", customer, shoppingCart.getCartItems(), new Date());
        orderManager.placeOrder(order);

        Product searchedProduct= productCatalog.searchProduct("P001");
        assertNotNull(searchedProduct);
        assertEquals(laptop, searchedProduct);

        List<Product> cartItems= shoppingCart.getCartItems();
        assertEquals(0, cartItems.size());
        assertTrue(!(cartItems.contains(laptop)));

        List<Order> allOrders= new OrderManager().getAllOrders();
        assertEquals(1, allOrders.size());
        Order placedOrder= allOrders.get(0);
        assertEquals(customer, placedOrder.getCustomer());
        assertEquals(cartItems, placedOrder.getProducts());








        Customer searchedCustomer= customerCatalog.searchCustomer("C001");
        assertNotNull(searchedCustomer);
        assertEquals(customer, searchedCustomer);












        assertNotNull(onlineStore.getProductCatalog());


        assertNotNull(onlineStore.getCustomerCatalog());
    }
}











