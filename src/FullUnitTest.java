import org.junit.jupiter.api.Assertions; import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;
class OrderTest{
    @Test
    void testOrderConstructor(){
        Customer customer= new Customer("C001", "John Doe", "john@gmail.com", 1000.00);
        List<Product> products= new ArrayList<>();

        products.add(new Product("P001", "Laptop", 999.99, 2));
        Date orderDate= new Date();
        Order order= new Order("O001",customer, products, orderDate);
        Assertions.assertEquals("O001", order.getOrderId());
        Assertions.assertEquals(customer, order.getCustomer());
        Assertions.assertEquals(products, order.getProducts());
        Assertions.assertEquals(orderDate, order.getOrderDate());
    }
    @Test
    void testGetOrderId(){
        Order order= new Order("O001", new Customer("C001", "John Doe", "john@gmail.com", 1000.00), new ArrayList<>(), new Date());
        order.setOrderId("O002");
        Assertions.assertEquals("O002", order.getOrderId());
    }
    @Test
    void testGetCustomer()
    {
        Customer customer= new Customer("C001", "John Doe", "john@gmail.com", 1000.00);
        Order order= new Order("O001", customer, new ArrayList<>(), new Date());
        Assertions.assertEquals(customer, order.getCustomer());
    }
    @Test
    void testSetCustomer()
    {
        Order order= new Order("O001", new Customer("C001", "John Doe", "john@gmail.com", 1000.00), new ArrayList<>(), new Date());
        Customer newCustomer = new Customer("C002", "Jane Doe", "jane@gmail.com", 1500.00);
        order.setCustomer(newCustomer);
        Assertions.assertEquals(newCustomer, order.getCustomer());
    }
    @Test
    void testGetProducts(){
        List<Product> products = new ArrayList<>();
        products.add(new Product("P001", "Laptop", 999.99,2));
        Order order= new Order("O001", new Customer("C001", "John Doe", "john@gmail.com", 1000.00), products, new Date());
        Assertions.assertEquals(products, order.getProducts());
    }







    @Test
    void testSetProducts(){
      Order order= new Order("O001", new Customer("C001", "John Doe", "john@example.com", 1000.00), new ArrayList<>(), new Date());
      List <Product> newProducts= new ArrayList<>();
      newProducts.add(new Product("P002", "Smartphone", 499.99,1));
      order.setProducts(newProducts);
      Assertions.assertEquals(newProducts, order.getProducts());
    }

    @Test
    void testGetOrderDate(){
        Date orderDate= new Date();
        Order order= new Order("O001", new Customer("C001", "John Doe", "john@example.com", 1000.00), new ArrayList<>(), orderDate);
        Assertions.assertEquals(orderDate, order.getOrderDate());
    }
    @Test
    void testSetOrderDate(){
      Order order= new Order("O001", new Customer("C001", "John Doe", "john@example.com", 1000.00), new ArrayList<>(), new Date());
      Date newOrderDate= new Date();
      order.setOrderDate(newOrderDate);
      Assertions.assertEquals(newOrderDate, order.getOrderDate());
    }

}




class CustomerCatalogTest{
    @Test
    public void testAddCustomer(){
        CustomerCatalog customerCatalog= new CustomerCatalog();
        Customer customer= new Customer("1", "John Doe", "c1", 10000.00);
        customerCatalog.addCustomer(customer);
        Customer foundCustomer= customerCatalog.searchCustomer("1");
        assertNotNull(foundCustomer);
        Assertions.assertEquals(customer, foundCustomer);
    }
    @Test
    public void testRemoveCustomer(){
        CustomerCatalog customerCatalog= new CustomerCatalog();  Customer customer= new Customer("3","John", "c2", 11000);
        customerCatalog.addCustomer(customer); customerCatalog.removeCustomer(customer);
        Customer foundCustomer= customerCatalog.searchCustomer("3"); assertNotNull(foundCustomer);
    }




    @Test
    public void testSearchCustomerFound(){
       CustomerCatalog customerCatalog= new CustomerCatalog();  Customer customer= new Customer("3","John Doe", "c3", 13900);
       customerCatalog.addCustomer(customer);
       Customer foundCustomer= customerCatalog.searchCustomer("3");
       assertNotNull(foundCustomer);
       Assertions.assertEquals(customer, foundCustomer);
    }



    @Test
    public void testSearchCustomerNotFound(){
        CustomerCatalog customerCatalog= new CustomerCatalog();
        Customer customer= new Customer("4", "John Doe", "c4", 14600.00);
        customerCatalog.addCustomer(customer);
        Customer foundCustomer= customerCatalog.searchCustomer("4");
        assertNotNull(foundCustomer);
    } }


class CustomerControllerTest{
    @Test
    public void addToCatalog(){
        CustomerCatalog customerCatalog= new CustomerCatalog();
        CustomerController customerController = new CustomerController(customerCatalog);
        Customer customer= new Customer("1", "John Doe", "cstmremail",13200);
        customerController.addToCatalog(customer);
        Customer foundCustomer= customerCatalog.searchCustomer("1");
        assertNotNull(foundCustomer);
        Assertions.assertEquals(customer, foundCustomer);
    }
}



class CustomerTest{
@Test
public void testGettersandSetters(){
      Customer customer= new Customer("1", "John Doe", "john@gmail.com", 100.0);
      //Testing the getters
      Assertions.assertEquals("1", customer.getCustomerId());
      Assertions.assertEquals("John Doe", customer.getName());
      Assertions.assertEquals("john@gmail.com", customer.getEmail());
      Assertions.assertEquals(100.0, customer.getWalletBalance(),0.0001);







      customer.setCustomerId("2");  Assertions.assertEquals("2", customer.getCustomerId()); //check if the ID and other attributes are updated by the setters or not
      customer.setName("Jane Doe");  Assertions.assertEquals("Jane Doe", customer.getName());
      customer.setEmail("jane@example.com");   Assertions.assertEquals("jane@gmail.com", customer.getEmail());
      customer.setWalletBalance(200.0);  Assertions.assertEquals(200.0, customer.getWalletBalance(),0.0001);
}
    @Test
    public void testToString(){
    Customer customer= new Customer("1", "John Doe", "john@gmail.com", 100.0);
    String expectedToString= "Customer id: 1\nCustomer name: John Doe\nEmail: john@gmail.com\nBalance: 100.0";
    Assertions.assertEquals(expectedToString, customer.toString());
    }

}

class OnlineStoreTest{
    @Test

    public void testGettersAndSetters(){
        ProductCatalog productCatalog= new ProductCatalog();
        CustomerCatalog customerCatalog= new CustomerCatalog();
        OnlineStore onlineStore= new OnlineStore();
        //Testing getters and then setters afterwards
        assertNotNull(onlineStore.getProductCatalog()); assertNotNull(onlineStore.getCustomerCatalog());
        onlineStore.setProductCatalog(productCatalog);  Assertions.assertEquals(productCatalog, onlineStore.getProductCatalog());
        onlineStore.setCustomerCatalog(customerCatalog);  Assertions.assertEquals(customerCatalog, onlineStore.getCustomerCatalog());
    }


}

class ProductTest{
    @Test
    public void testProductGettersAndSetters(){
        Product product= new Product("P001", "Laptop", 999.99, 10);
        //Testing the getters
        Assertions.assertEquals("P001", product.getProductId());
        Assertions.assertEquals("Laptop", product.getName());
        Assertions.assertEquals(999.99, product.getPrice(),0.0001);
        Assertions.assertEquals(10, product.getQuantity());
        //Testing the setters
        product.setProductId("P002");   Assertions.assertEquals("P002", product.getProductId());
        product.setName("Desktop");  Assertions.assertEquals("Desktop", product.getName());
        product.setPrice(899.99);  Assertions.assertEquals(899.99, product.getPrice(), 0.0001);
        product.setQuantity(5);   Assertions.assertEquals(5, product.getQuantity()); }




    @Test
    public void testProductToString(){
     Product product= new Product("P001", "Laptop", 999.99,10);
     String expectedToString= "Product id: P001\nProduct name: Laptop\nPrice: $999.99\nStock: 10";
     Assertions.assertEquals(expectedToString, product.toString());
    }
}


class ProductCatalogTest{
    @Test
    public void testAddProduct(){
        ProductCatalog productCatalog= new ProductCatalog();
        Product product= new Product("P001", "Laptop", 999.99,10);
        List<Product> products= new ArrayList<>();
        productCatalog.addProduct(product);
        assertEquals(1, products.size());
        assertTrue(products.contains(product));
    }



    @Test
    public void testRemoveProduct(){
       ProductCatalog productCatalog= new ProductCatalog();
       Product product= new Product("P001", "Laptop", 999.99,10);
       productCatalog.addProduct(product);
       productCatalog.removeProduct(product);
       List<Product> products= new ArrayList<>();
       assertEquals(0, products.size());
       assertFalse(products.contains(product));
    }
    @Test
    public void testSearchProduct(){
        ProductCatalog productCatalog= new ProductCatalog();
        Product product1= new Product("P001", "Laptop", 999.99,10);
        Product product2= new Product("P002", "Desktop", 799.99, 5);
        productCatalog.addProduct(product1);
        productCatalog.addProduct(product2);
        Product foundProduct= productCatalog.searchProduct("P001");
        assertNotNull(foundProduct);
        Assertions.assertEquals("Laptop", foundProduct.getName());
    }
}








class ProductControllerTest
{
    private static class TestProductCatalog extends ProductCatalog{
        private Product lastAddedProduct;
        @Override
        public void addProduct(Product product){
            lastAddedProduct=product;
        }
        @Override
        public void removeProduct(Product product){
        }

        @Override
        public Product searchProduct(String productId){
            return null;
        }
        public Product getLastAddedProduct(){
            return lastAddedProduct;
        }

    }
    @Test
    public void testAddToCatalog(){
        TestProductCatalog testProductCatalog= new TestProductCatalog();
        ProductController productController= new ProductController(testProductCatalog);
        Product product= new Product("P001", "Laptop", 999.99,10);


        productController.addToCatalog(product);
        Product lastAddedProduct= testProductCatalog.getLastAddedProduct();
        assertNotNull(lastAddedProduct);
        Assertions.assertEquals("P001", lastAddedProduct.getProductId());
        Assertions.assertEquals("Laptop", lastAddedProduct.getName());
        Assertions.assertEquals(999.99, lastAddedProduct.getPrice());
        Assertions.assertEquals(10, lastAddedProduct.getQuantity());
    }
}

class ShoppingCartTest{
    @Test
    public void testAddItem(){
        ShoppingCart shoppingCart= new ShoppingCart();
        Product product= new Product("P001", "Laptop", 999.99, 10);
        shoppingCart.addItem(product);




        List<Product> cartItems= shoppingCart.getCartItems();
        assertEquals(1, cartItems.size());
        assertTrue(cartItems.contains(product));
    }

    @Test
    public void testRemoveItem(){
        ShoppingCart shoppingCart= new ShoppingCart();

        Product product= new Product("P001", "Laptop", 999.99, 10);
        shoppingCart.addItem(product);
        shoppingCart.removeItem(product);
        List<Product> cartItems= shoppingCart.getCartItems();
        assertEquals(0, cartItems.size());
        assertFalse(cartItems.contains(product));
    }
    @Test
    public void testGetCartItems(){
        ShoppingCart shoppingCart= new ShoppingCart();
        Product product1= new Product("P001", "Laptop", 999.99, 10);
        Product product2= new Product("P002", "Desktop", 799.99,5);
        shoppingCart.addItem(product1);  shoppingCart.addItem(product2);
        List<Product> cartItems= shoppingCart.getCartItems();
        assertEquals(2, cartItems.size());
        assertTrue(cartItems.contains(product1));
        assertTrue(cartItems.contains(product2));
    }
}

class OnlineStoreManagementSystemTest{
    @Test
    public void testRun(){
        ProductCatalog productCatalog= new ProductCatalog();
        CustomerCatalog customerCatalog= new CustomerCatalog();
        ProductController productController= new ProductController(productCatalog);
        CustomerController customerController= new CustomerController(customerCatalog);
        OnlineStoreManagementSystem system= new OnlineStoreManagementSystem(productController, customerController);
        Product laptop= new Product("P001", "Laptop", 999.99,10);
        Customer customer= new Customer("C001", "John Doe", "john@example.com", 1000.00);
        System.out.println("Redirected Output: ");
        System.out.println("Product Details:\n" + laptop.toString());
        System.out.println("\nCustomer Details:\n" + customer.toString());
    }
    @Test
    public void testMain(){
        System.out.println("Redirected Output: ");  OnlineStoreManagementSystem.main(new String[]{}); }}






class OrderManagerTest{
    @Test
    public void testPlaceOrder(){
        OrderManager orderManager= new OrderManager();
        Customer customer= new Customer("C001", "John Doe", "john@gmail.com", 1000.00);
        Product product= new Product("P001", "Laptop", 999.99,5);
        Order order= new Order("O001", customer, List.of(product), new Date());
        orderManager.placeOrder(order);
        assertTrue(orderManager.getAllOrders().contains(order));
        assertEquals(1, orderManager.getAllOrders().size());
    }

    @Test
    public void testCancelOrder(){
        OrderManager orderManager= new OrderManager();
        Customer customer= new Customer("C001", "John Doe", "john@gmail.com", 1000.00);

        Product product= new Product("P001", "Laptop",999.99,5);
        Order order= new Order("O001", customer, List.of(product), new Date());
        orderManager.placeOrder(order);  orderManager.cancelOrder(order);
        assertFalse(orderManager.getAllOrders().contains(order));
        assertEquals(0, orderManager.getAllOrders().size());
    }





    @Test
    public void testGetAllOrders(){
      OrderManager orderManager= new OrderManager();
      Customer customer= new Customer("C001", "John Doe", "john@gmail.com", 1000.00);
      Product product= new Product("P001", "Laptop", 999.99,5);
      Order order1= new Order("O001", customer, List.of(product), new Date());
      Order order2= new Order("O002", customer, List.of(product), new Date());
      orderManager.placeOrder(order1);  orderManager.placeOrder(order2);
      List<Order> allOrders= orderManager.getAllOrders();
      assertEquals(2, allOrders.size());
      assertTrue(allOrders.contains(order1));
      assertTrue(allOrders.contains(order2));
    }
}