import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;

//Path testing will check if the test cases for a class are true or not. If there are no faults, and if all statements are true, then the class will generate True as an output when tested thoroughly, otherwise it will generate False.
class PathTestCustomer{
    @Test  //Is a constructor null or not?    Follow 1) the path that it is null and 2) the path that it is not null
    public void testConstructor(){
        Customer customer= new Customer("123", "John Doe", "john@gmail.com", 100.0);
        assertNotNull(customer);  assertNull(customer);
    }
    @Test
    public void testToString(){   //Does the string match a given string from the user or not - 2 paths here as well; it either does or doesn't match the toString() format
       Customer customer= new Customer("123", "John Doe", "john@gmail.com", 100.0);
       String validstring= "Customer id: 123\nCustomer name: John Doe\nEmail: john@gmail.com\nBalance: 100.0";
       assertEquals(validstring, customer.toString());
        String invalidstring= "Customer id: 123\nCustomer name: John Doe\nEmail: john@gmail.com\nBalance: $100.0"; //dollar not part of the toString() method
        assertNotEquals(validstring, customer.toString());

    }

    @Test
    public void testFalseAndTrueGettersSetters(){  //Are the getters and setters true or false
        Customer customer= new Customer("123","John Doe", "john@gmail.com",100.0);
        assertEquals("123", customer.getCustomerId());  //true getter
        assertEquals("456", customer.getCustomerId());  //false getter
        assertEquals("John Doe", customer.getName());  //true getter
        assertEquals("John D", customer.getName());   //false getter
        assertEquals("john@gmail.com", customer.getEmail());  //true getter
        assertEquals("john@example.com", customer.getEmail());    //false getter
        assertEquals(100.0, customer.getWalletBalance(), 0.0001);  //true getter
        assertEquals(200.0, customer.getWalletBalance());  //false getter
        customer.setCustomerId("456");
        assertEquals("123", customer.getCustomerId());   //it will give a false result because the setter set the id to 456
        assertEquals("456", customer.getCustomerId());   //it will give a true result because the setter set the id to 456
        customer.setName("John D");
        assertEquals("John Doe", customer.getName());   //it will give a false result because the setter set the name to John D
        assertEquals("John D", customer.getName());   //it will give a true result because the setter set the name to John D
        customer.setEmail("john@example.com");
        assertEquals("john@gmail.com", customer.getEmail()); //it will give a false result because the setter set the email to john@example.com
        assertEquals("john@example.com", customer.getEmail()); //it will give a true result because the setter set the email to john@example.com
        customer.setWalletBalance(200.0);
        assertEquals(100.0, customer.getWalletBalance(), 0.0001);  //it will give a false result because the setter set the balance to 200.0
        assertEquals(200.0, customer.getWalletBalance(), 0.0001);  //it will give a true result because the setter set the balance to 200.0
    } }






//It is the same for the other classes as well
class PathTestCustomerController{
    CustomerCatalog customercatalog= new CustomerCatalog();
    CustomerController customerController= new CustomerController(customercatalog);
    @Test
    public void testConstructor(){
        CustomerCatalog catalog= new CustomerCatalog();
        CustomerController customerController= new CustomerController(catalog); //by default, the class has a 1-arg constructor with a CustomerCatalog object
        assertNotNull(customerController);  assertNull(customerController);
    }

    @Test
    public void testAddToCatalog(){

        Customer customer= new Customer("1","John Doe", "john@gmail.com", 100.0);
        customerController.addToCatalog(customer);
        assertNotNull(customerController);  //check if the customer was added to customercontroller
        assertNull(customerController);
    }
}

class PathTestOnlineStore{
    @Test
    public void testOnlineStoreConstructor(){
        OnlineStore onlineStore= new OnlineStore();  assertNotNull(onlineStore); assertNull(onlineStore);
    }



    @Test
    public void testSetProductCatalog(){
        OnlineStore onlineStore= new OnlineStore();
        ProductCatalog newProductCatalog= new ProductCatalog();
        onlineStore.setProductCatalog(newProductCatalog); assertEquals(newProductCatalog, onlineStore.getProductCatalog());
        assertEquals("", onlineStore.getProductCatalog());  //it is not a newProductCatalog object that is added now, a false test case
    }
    @Test
    public void testSetCustomerCatalog()
    {  //Repeat the same thing as in product catalog but with a customer catalog object now
        OnlineStore onlineStore= new OnlineStore();
        CustomerCatalog newCustomerCatalog= new CustomerCatalog();
        onlineStore.setCustomerCatalog(newCustomerCatalog); assertEquals(newCustomerCatalog, onlineStore.getCustomerCatalog());
        assertEquals("", onlineStore.getCustomerCatalog());  //it is not a newProductCatalog object that is added now, a false test case
    } }




class PathTestOnlineStoreManagementSystem{

    @Test
    public void testOnlineStoreManagementSystemConstructor(){
        ProductCatalog productCatalog= new ProductCatalog();
        CustomerCatalog customerCatalog= new CustomerCatalog();
        ProductController productController= new ProductController(productCatalog);
        CustomerController customerController= new CustomerController(customerCatalog);

        OnlineStoreManagementSystem system= new OnlineStoreManagementSystem(productController, customerController);

        assertNotNull(system);  assertNull(system);
    }

    @Test
    public void TestRunAndSearchProductMethods(){
        ProductCatalog productCatalog= new ProductCatalog();
        CustomerCatalog customerCatalog= new CustomerCatalog();
        ProductController productController= new ProductController(productCatalog);
        CustomerController customerController= new CustomerController(customerCatalog);
        OnlineStoreManagementSystem system= new OnlineStoreManagementSystem(productController, customerController);
        system.run();
        assertNotNull(productCatalog.searchProduct("P001"));  //If we search the product with the id, then it will not be null because there is actually an id of that product
        assertNotNull(customerCatalog.searchCustomer("C001"));
        assertNull(productCatalog.searchProduct("P001")); assertNull(customerCatalog.searchCustomer("C001"));
    }
}



class OrderPathTesting{
    @Test
    public void testOrderConstructor(){
     Customer customer= new Customer("C001", "John Doe", "john@gmail.com", 1000.00);
     List<Product> products= new ArrayList<>();
     Date orderDate = new Date();
     Order order= new Order("O001", customer, products, orderDate);
     assertNotNull(order);   assertNull(order);
    }
    @Test
    public void testSetOrderId(){
     Order order= new Order("O001", new Customer("C1", "Customer1", "CustomerEmail", 11000), new ArrayList<>(), new Date());
     order.setOrderId("O002");
     assertEquals("O002", order.getOrderId());
     assertEquals("O003", order.getOrderId());
    }






    @Test
    public void testSetCustomer(){
        Order order= new Order("O001", new Customer("C002", "Jane Doe", "jane@gmail.com", 1000.00), new ArrayList<>(), new Date());
        Customer newCustomer= new Customer("C002", "Jane Doe", "jane@gmail.com", 1500.00);
        order.setCustomer(newCustomer);  assertEquals(newCustomer, order.getCustomer());  assertNotEquals(newCustomer, order.getCustomer());
    }
    @Test
    public void testSetProducts(){
        Order order= new Order("O001", new Customer("C002", "Jane Doe", "jane@gmail.com", 1000.00), new ArrayList<>(), new Date());
        List<Product> newProducts= Arrays.asList(new Product("P001", "Laptop", 999.99,2));
        order.setProducts(newProducts);  assertEquals(newProducts, order.getProducts());  assertNotEquals(newProducts, order.getProducts()); }

    @Test
    public void testSetDate(){
        Order order= new Order("O001", new Customer("C002", "Jane Doe", "jane@gmail.com", 1000.00), new ArrayList<>(), new Date());
        Date date= new Date();

        assertEquals(date, order.getOrderDate());
    }
}

class OrderManagerPathTest{
    @Test
    public void testOrderManagerConstructor(){
        OrderManager orderManager= new OrderManager();  assertNotNull(orderManager); 
    }


    @Test
    public void testPlaceOrder(){
       OrderManager orderManager= new OrderManager();
       Order order= new Order("O001", new Customer("C001", "Jane Doe", "jane@gmail.com",1000.00), new ArrayList<>(), new Date());
       orderManager.placeOrder(order);
       assertTrue(orderManager.getAllOrders().contains(order));   assertFalse(orderManager.getAllOrders().contains(order));
    }

    @Test
    public void testCancelOrder()
    {
        OrderManager orderManager= new OrderManager();
        List<Order> allOrders= orderManager.getAllOrders();
        assertNotNull(allOrders);                 assertNull(allOrders);
        assertEquals(orderManager.orders, allOrders);   assertNotEquals(orderManager.orders, allOrders);
    } }




class PathTestProduct{
    @Test
    public void testProductConstructor(){
        Product product= new Product("P001", "Laptop", 999.99, 10);
        assertNotNull(product);
    }



    @Test
    public void testSetProductId(){
        Product product= new Product("P001", "Laptop", 999.99, 10);
        product.setProductId("P002");
        assertEquals("P002", product.getProductId());   assertEquals("P003", product.getProductId());
    }
    @Test
    public void testSetName(){
        Product product= new Product("P001", "Laptop", 999.99, 10);
        product.setName("Desktop");
        assertEquals("Desktop", product.getName());   assertEquals("Laptop", product.getName());
    }

    @Test
    public void testSetPrice(){
        Product product= new Product("P001", "Laptop", 999.99, 10);
        product.setPrice(1082.00);
        assertEquals(1082.00, product.getPrice());   assertEquals(1083.00, product.getPrice()); }


    @Test
    public void testSetQuantity(){
        Product product= new Product("P001", "Laptop", 999.99, 10);
        product.setQuantity(23);
        assertEquals(23, product.getQuantity());   assertEquals(31, product.getQuantity());
    }


    @Test
    public void testToString(){
        Product product= new Product("P001", "Laptop", 999.99, 10);
        assertEquals("Product id: P001\nProduct name: Laptop\nPrice: $999.99\nStock: 10", product.toString());
        assertEquals("Product id: P001\nProduct name: Laptop\nPrice: 999.99\nStock: 10", product.toString()); //it is false without a dollar
    }
}

class PathTestProductCatalog{






    @Test
    public void testProductCatalogConstructor(){
        ProductCatalog productCatalog= new ProductCatalog();
        assertNotNull(productCatalog);   assertNull(productCatalog);
    }
    @Test
    public void testAddProduct(){
        ProductCatalog productCatalog= new ProductCatalog();
        Product product= new Product("P001", "Laptop", 999.99,10);
        productCatalog.addProduct(product);
        assertTrue(productCatalog.products.contains(product)); assertTrue(!productCatalog.products.contains(product));

    }

    @Test
    public void testRemoveProduct(){

        ProductCatalog productCatalog= new ProductCatalog();
        Product product= new Product("P001", "Laptop", 999.99,10);
        productCatalog.addProduct(product);
        productCatalog.removeProduct(product);
        assertFalse(productCatalog.products.contains(product));  //it will generate a true result because the product was removed from the product catalog after it was added to the array list
        assertFalse(productCatalog.products.contains(product));
    }
    @Test
    public void testSearchProductFound(){


        ProductCatalog productCatalog= new ProductCatalog();
        Product product= new Product("P001", "Laptop", 999.99,10);
        productCatalog.addProduct(product);
        Product foundproduct= productCatalog.searchProduct("P001");
        assertEquals(product, foundproduct);
        Product foundproduct3= productCatalog.searchProduct("P003"); //False, because this is not the id we are looking for
        assertEquals(product, foundproduct3);
    }
}


class PathTestProductController{
    @Test
    public void testProductControllerConstructor(){
        ProductCatalog productCatalog= new ProductCatalog();
        ProductController productController= new ProductController(productCatalog); assertNotNull(productController);  assertNull(productController); }




    @Test
    public void testAddToCatalog(){
        ProductCatalog productCatalog= new ProductCatalog();
        ProductController productController= new ProductController(productCatalog);
        Product product= new Product("P001","Laptop", 999.99, 10);
        productController.addToCatalog(product);   assertTrue(productCatalog.products.contains(product));  assertTrue(!productCatalog.products.contains(product));} }
class PathTestShoppingCart{


    @Test
    public void testShoppingCartConstructor(){
        ShoppingCart shoppingCart= new ShoppingCart();  assertNotNull(shoppingCart); assertNull(shoppingCart);
    }
    @Test
    public void testAddItem(){
        ShoppingCart shoppingCart= new ShoppingCart();
        Product product= new Product("P001", "Laptop",999.99, 10);
        shoppingCart.addItem(product);
        assertTrue(shoppingCart.getCartItems().contains(product));  assertTrue(!shoppingCart.getCartItems().contains(product));
    }
    @Test
    public void testRemoveItem(){
        ShoppingCart shoppingCart= new ShoppingCart();
        Product product= new Product("P001", "Laptop",999.99, 10);
        shoppingCart.addItem(product);
        shoppingCart.removeItem(product);
        assertFalse(shoppingCart.getCartItems().contains(product)); }


    @Test
    public void testGetCartItems()
    {
     ShoppingCart shoppingCart= new ShoppingCart();
     List<Product> cartItems= shoppingCart.getCartItems();

     assertNotNull(cartItems);
     assertNull(cartItems);
     assertEquals(shoppingCart.getCartItems(),cartItems);} }



