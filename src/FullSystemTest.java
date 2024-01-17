import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;




public class FullSystemTest{

    public static void main(String[] args){
        ProductCatalog productCatalog= new ProductCatalog();
        ProductController productController= new ProductController(productCatalog);
        ShoppingCart shoppingCart= new ShoppingCart();
        OrderManager orderManager= new OrderManager();
        CustomerCatalog customerCatalog= new CustomerCatalog();
        CustomerController customerController= new CustomerController(customerCatalog);
        OnlineStore onlineStore= new OnlineStore();
        OnlineStoreManagementSystem system = new OnlineStoreManagementSystem(productController, customerController);
        Product laptop= new Product("P001","Laptop",999.99,10);
        Product smartphone= new Product("P002","Smartphone",499.99,20);
        productController.addToCatalog(laptop); productController.addToCatalog(smartphone);
        Customer customer= new Customer("C001","John Doe", "john@gmail.com",1000.00);
        customerController.addToCatalog(customer);
        ExecutorService executorService= Executors.newFixedThreadPool(3);
        executorService.execute(()-> {shoppingCart.addItem(laptop); shoppingCart.addItem(smartphone);});
        executorService.execute(()->{Order order= new Order("O001", customer, shoppingCart.getCartItems(),new Date());  orderManager.placeOrder(order);});
        executorService.execute(()->{onlineStore.setProductCatalog(productCatalog); onlineStore.setCustomerCatalog(customerCatalog);
        onlineStore.getProductCatalog().addProduct(laptop);  onlineStore.getCustomerCatalog().addCustomer(customer);});
        executorService.shutdown();
        try{
            executorService.awaitTermination(5, TimeUnit.SECONDS);
        }
        catch(InterruptedException ex){
            ex.printStackTrace();
        }
        Product searchedProduct= productCatalog.searchProduct("P001");
        assertNotNull(searchedProduct);
        assertEquals(laptop, searchedProduct);

        List<Product> cartItems= shoppingCart.getCartItems(); assertEquals(2, cartItems.size());
        assertTrue(cartItems.contains(laptop));  assertTrue(cartItems.contains(smartphone)); List<Order> allOrders= orderManager.getAllOrders();
        assertEquals(1, allOrders.size()); Order placedOrder= allOrders.get(0); assertEquals(customer, placedOrder.getCustomer());
        assertEquals(cartItems, placedOrder.getProducts());













        Customer searchedCustomer= customerCatalog.searchCustomer("C001");
        assertNotNull(searchedCustomer);
        assertEquals(customer, searchedCustomer);
        assertNotNull(onlineStore.getProductCatalog());
        assertNotNull(onlineStore.getCustomerCatalog());

    }


}