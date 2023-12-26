import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;
class EquivalenceCustomerTest{
    @Test
    public void testConstructorAndSetters(){
        Customer customer1= new Customer("C123", "John Doe", "john@gmail.com", 100.0); assertEquals("C123", customer1.getCustomerId());
        Customer customer2= new Customer("", "John Doe","john@gmail.com", 100.0); assertEquals("", customer2.getCustomerId());

        Customer customer3= new Customer(null, "John Doe","john@gmail.com",100.0); assertNull(customer3.getCustomerId());



        Customer customer4= new Customer("C456", "Jane Smith", "jane@gmail.com", 50.0);  assertEquals("Jane Smith", customer4.getName());
        Customer customer5= new Customer("C789", "", "jane@gmail.com",50.0); assertEquals("", customer5.getName());
        Customer customer6= new Customer("C101",null, "jane@gmail.com", 50.0);  assertNull(customer6.getName());

        Customer customer7= new Customer("C112", "John Doe", "john@gmail.com", 100.0); assertEquals("john@gmail.com", customer7.getEmail());
        Customer customer8= new Customer("C415", "John Doe","", 100.0); assertEquals("", customer8.getEmail());
        Customer customer10= new Customer("C161", "John Doe", null, 100.0); assertNull(customer10.getEmail());




        Customer customer12= new Customer("C718","John Doe", "john@gmail.com", 75.0);
        assertEquals(75.0, customer12.getWalletBalance(),0.0001);
        Customer customer13= new Customer("C919", "John Doe", "john@gmail.com", 0.0);
        assertEquals(0.0, customer13.getWalletBalance(),0.0001);
        Customer customer14= new Customer("C202", "John Doe", "john@gmail.com", -50.0);
        assertEquals(-50.0, customer14.getWalletBalance(),0.0001);

        //Equivalence classes for: 1)valid, empty, and null customer ID
        //2) valid, empty, and null name
        //3) valid, empty, and null email
        //4)positive, zero, or negative wallet balance

    }
}

class EquivalenceCustomerControllerTest{

    @Test
    public void testAddToCatalog(){
        //Equivalence class when a valid customer is added to a valid catalog
        CustomerCatalog customerCatalog= new CustomerCatalog();
        Customer validCustomer= new Customer("C123","John Doe","john@gmail.com",100.00);






        CustomerController customerController= new CustomerController(customerCatalog);
        customerController.addToCatalog(validCustomer);
        Customer retrievedcustomer= customerCatalog.searchCustomer(validCustomer.getCustomerId());
        assertNotNull(retrievedcustomer);   assertEquals(validCustomer, retrievedcustomer);

        //Adding a customer to an empty customer catalog
        CustomerCatalog emptycustomerCatalog= new CustomerCatalog();
        CustomerController controller2= new CustomerController(emptycustomerCatalog); controller2.addToCatalog(validCustomer);

        Customer retrievedcustomer2= emptycustomerCatalog.searchCustomer(validCustomer.getCustomerId());
        assertNotNull(retrievedcustomer2); assertEquals(validCustomer, retrievedcustomer2);

        //Adding a valid customer to a null customer catalog; if a NullPointerException was thrown, the test case will be true because a null object was added
        CustomerController customercontroller3= new CustomerController(null);
        assertThrows(NullPointerException.class, ()-> customercontroller3.addToCatalog(validCustomer));
        //Adding a null customer to a valid customer catalog, the test case will be false since the controller will have a customer catalog object beforehand
        CustomerCatalog nullcustomercatalog= new CustomerCatalog();
        CustomerController controller4= new CustomerController(nullcustomercatalog);
        assertThrows(NullPointerException.class, ()-> controller4.addToCatalog(null));
        //Adding multiple customers to a valid customer catalog
        CustomerCatalog multiplecustomercatalog= new CustomerCatalog();
        CustomerController controller5= new CustomerController(multiplecustomercatalog);
        Customer customer1= new Customer("C456", "Jane Smith", "jane@gmail.com", 50.0);
        Customer customer2= new Customer("C789", "Bob Johnson", "bob@gmail.com", 75.0);
        controller5.addToCatalog(customer1);  controller5.addToCatalog(customer2);



        Customer retrievedcustomer3= multiplecustomercatalog.searchCustomer(customer1.getCustomerId());
        assertNotNull(retrievedcustomer3); assertEquals(customer1, retrievedcustomer3);
        Customer retrievedcustomer4= multiplecustomercatalog.searchCustomer(customer2.getCustomerId());
        assertNotNull(retrievedcustomer4);  assertEquals(customer2, retrievedcustomer4);
    }
}
class EquivalenceOnlineStoreTest{
    @Test
    public void testOnlineStoreInitialization(){  //Testing non-null getters of product and customer catalog of the online store
        OnlineStore onlineStore1= new OnlineStore();
        assertNotNull(onlineStore1.getProductCatalog());
        assertNotNull(onlineStore1.getCustomerCatalog());
        //Setting a new product catalog, testing the setter
        ProductCatalog productCatalog= new ProductCatalog();
        OnlineStore onlineStore2= new OnlineStore();
        onlineStore2.setProductCatalog(productCatalog); assertEquals(productCatalog, onlineStore2.getProductCatalog());




        //Same as product catalog, but now setters for customer catalog

        CustomerCatalog customerCatalog= new CustomerCatalog();
        OnlineStore onlineStore3= new OnlineStore();
        onlineStore3.setCustomerCatalog(customerCatalog);
        assertEquals(customerCatalog, onlineStore3.getCustomerCatalog());



        //Setting a null product/customer catalog

        OnlineStore onlineStore4= new OnlineStore(); onlineStore4.setProductCatalog(null); assertNull(onlineStore4.getProductCatalog());
        OnlineStore onlineStore5= new OnlineStore(); onlineStore5.setCustomerCatalog(null); assertNull(onlineStore5.getCustomerCatalog());  }}

class EquivalenceOnlineStoreSystemTest{
    @Test

    public void testRun(){
        //Running the system with valid controllers and catalogs
        ProductCatalog validproductcatalog= new ProductCatalog();  CustomerCatalog validcustomercatalog= new CustomerCatalog();
        ProductController validproductcontroller= new ProductController(validproductcatalog);
        CustomerController validcustomercontroller= new CustomerController(validcustomercatalog);
        OnlineStoreManagementSystem system1= new OnlineStoreManagementSystem(validproductcontroller, validcustomercontroller);
        system1.run();
        assertNotNull(validproductcatalog.searchProduct("P001"));  assertNotNull(validcustomercatalog.searchCustomer("C001"));   //to ensure that a product and a customer were added with their respective ids, we test them with an assertNotNull method
        //Running the system with a null product controller
        CustomerCatalog nullProductControllerCatalog= new CustomerCatalog();
        ProductController nullProductController= null;
        CustomerController validCustomerController2= new CustomerController(nullProductControllerCatalog);
        OnlineStoreManagementSystem system2= new OnlineStoreManagementSystem(nullProductController, validCustomerController2);
        assertThrows(NullPointerException.class, system2::run);
        //Running the system with a null customer controller
        ProductCatalog nullCustomerControllerCatalog= new ProductCatalog();
        CustomerController nullcustomercontroller=null;
        ProductController validProductController3= new ProductController(nullCustomerControllerCatalog);
        OnlineStoreManagementSystem system3= new OnlineStoreManagementSystem(validProductController3, nullcustomercontroller);
        assertThrows(NullPointerException.class, system3::run);
    } }






class EquivalenceOrderTest{







    @Test
    public void testValidInput(){
        Customer customer= new Customer("C001","John Doe", "john@gmail.com", 1000.00);
        List<Product> products= Arrays.asList(new Product("P001", "Product1", 10.0,5));
        Date orderDate= new Date();
        Order order= new Order("O001", customer, products, orderDate);
        assertEquals("O001", order.getOrderId());  assertEquals(customer, order.getCustomer()); assertEquals(products, order.getProducts());
        assertEquals(orderDate, order.getOrderDate()); }

    @Test
    public void testInvalidOrderId(){

        Customer customer= new Customer("C001","John Doe", "john@gmail.com", 1000.00);
        List<Product> products= Arrays.asList(new Product("P001", "Product1", 10.0,5));
        Date orderDate= new Date();  Order order= new Order("O001", customer, products, orderDate);
        assertEquals("O003", order.getOrderId()); }


    @Test
    public void testNullCustomer(){
        List<Product> products= Arrays.asList(new Product("P001", "Product1", 10.0,5));
        Date orderDate= new Date(); Order order= new Order("O001", null, products, orderDate);
        assertNull(order.getCustomer());
    }


    @Test
    public void testNullProduct(){
        Customer customer= new Customer("C001", "John Doe", "john@gmail.com", 1000.00);
        Date orderDate= new Date(); Order order= new Order("O001", customer, null, orderDate);
        assertNull(order.getProducts());
    }
    @Test
    public void testNullOrderDate(){
        Customer customer= new Customer("C001", "John Doe", "john@gmail.com", 1000.00);
        List<Product> products= Arrays.asList(new Product("P001", "Product1", 10.0,5));
        Order order= new Order("O001", customer, products, null);
        assertNull(order.getOrderDate());
    }}
class EquivalenceOrderManagerTest{
    @Test
    public void testValidInput(){




        OrderManager orderManager= new OrderManager(); Customer customer= new Customer("C001","John Doe","john@gmail.com", 1000.00);

        List<Product> products= Arrays.asList(new Product("P001", "Product1", 10.0,5));
        Date orderDate= new Date();   Order order= new Order("O001", customer, products, orderDate);
        orderManager.placeOrder(order);  assertTrue(orderManager.getAllOrders().contains(order));
    }



    @Test
    public void testRemoveOrder(){
        OrderManager orderManager= new OrderManager();
        Customer customer= new Customer("C001","John Doe", "john@gmail.com", 1000.00);
        List<Product> products= Arrays.asList(new Product("P001", "Product1", 10.0,5));
        Date orderDate= new Date();  Order order= new Order("O001", customer, products, orderDate);
        orderManager.placeOrder(order);
        orderManager.cancelOrder(order);
        assertFalse(orderManager.getAllOrders().contains(order));
    }
    @Test
    public void testNullOrder(){

        OrderManager orderManager= new OrderManager();
        assertNull(orderManager);  assertNotNull(orderManager);
    }
    @Test
    public void testRetrieveAllOrdersEmpty(){
        OrderManager orderManager= new OrderManager();
        assertTrue(orderManager.getAllOrders().isEmpty());
    }
    @Test
    public void testRetrieveAllOrdersNonEmpty(){
        OrderManager orderManager= new OrderManager();
        Customer customer= new Customer("C001","John Doe","john@gmail.com", 1000.00);
        List<Product> products= Arrays.asList(new Product("P001","Product1", 10.0,5));
        Date orderDate= new Date();
        Order order= new Order("O001",customer, products, orderDate);
        orderManager.placeOrder(order);
        assertEquals(1, orderManager.getAllOrders().size()); //there should be only one order
        assertTrue(orderManager.getAllOrders().contains(order)); //check if the orders are part of the order manager or not
        } }
class EquivalenceProductTest{
    @Test
    public void testValidArguments(){
        Product product= new Product("P001","Laptop",999.99,10);
        assertEquals("P001", product.getProductId()); assertEquals("Laptop", product.getName()); assertEquals(999.99, product.getPrice()); assertEquals(10, product.getQuantity()); }






    @Test
    public void testProductPrice(){
        Product product= new Product("P001","Laptop",199.99,5);  //Positive price
        assertTrue(product.getPrice()>0);
        Product product2= new Product("P001","Laptop",0,5);  //Zero price
        assertTrue(product2.getPrice()==0);
        Product product3= new Product("P001","Laptop",-59.99,5);  //Negative price
        assertTrue(product3.getPrice()<0);

    }


    @Test
    public void testProductQuantity(){
        Product product4= new Product("P001","Laptop",199.99,5);  //Positive quantity
        assertTrue(product4.getQuantity()>0);
        Product product5= new Product("P001","Laptop",199.99,0);  //Zero quantity
        assertTrue(product5.getQuantity()==0);
        Product product6= new Product("P001","Laptop",199.99,-10);  //Negative quantity
        assertTrue(product6.getQuantity()<0);
    }
    @Test
    public void testProductName(){
        Product prdct= new Product("P001",null,999.99, 10); //Null name
        assertNull(prdct.getName());



        Product prdct2= new Product("P001","",999.99, 10); //Empty name
        assertEquals("", prdct2.getName());
        Product prdct3= new Product("P001","Laptop",999.99, 10); //Valid name
        assertEquals("Laptop", prdct3.getName());
    }
}
class EquivalenceProductCatalogTest{
    ProductCatalog productCatalog= new ProductCatalog();
    @Test
    public void testAddProduct(){
        Product product= new Product("P001","TestProduct", 19.99,5);
        productCatalog.addProduct(product); assertTrue(productCatalog.products.contains(product));  //A product was added to the product catalog, so it will be a true test case
        }
    @Test
    public void testRemoveProduct(){ Product product2= new Product("P002","AnotherProduct", 29.99,10); productCatalog.addProduct(product2);  productCatalog.removeProduct(product2);  assertFalse(productCatalog.products.contains(product2));  //A product was added to the product catalog, so it will be a true test case
    }




    @Test public void testSearchProduct(){

        Product product1= new Product("P003", "Product1", 9.99,3); Product product2= new Product("P004", "Product2", 14.99,8);
        productCatalog.addProduct(product1);  productCatalog.addProduct(product2); Product result= productCatalog.searchProduct("P003");  assertEquals(product1, result);
        Product result2= productCatalog.searchProduct("P004");  assertEquals(product2, result2);
    } }
















class EquivalenceProductControllerTest{
    @Test
    public void testAddToCatalog(){
        ProductCatalog productCatalog= new ProductCatalog();
        ProductController productController= new ProductController(productCatalog);
        Product product= new Product("P001","Laptop",999.99,10);
        productController.addToCatalog(product);
        assertTrue(productCatalog.products.contains(product));
    }
    @Test  public void testDuplicateProductAddedToCatalog(){
        ProductCatalog productCatalog= new ProductCatalog();
        Product previousproduct= new Product("P001","Laptop",299.99,5);
        productCatalog.addProduct(previousproduct);
        ProductController productController= new ProductController(productCatalog);
        Product anotherproduct= new Product("P002","Phone",299.99,5);
        productController.addToCatalog(anotherproduct);

        assertEquals(1, productCatalog.products.size());  //false because 2 products were actually added to the catalog
    } }




class EquivalenceShoppingCartTest{
    @Test
    public void testAddItemValidProduct(){
        ShoppingCart shoppingCart= new ShoppingCart();
        Product product= new Product("P001", "Laptop", 999.99, 1);
        shoppingCart.addItem(product);
        assertTrue(shoppingCart.getCartItems().contains(product));
    }}
