import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.MockitoAnnotations;
import java.util.*;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;



@RunWith(MockitoJUnitRunner.class) class MockCustomerTest{
    @Test
    public void testCustomerSettersAndGetters(){
        Customer mockcustomer= mock(Customer.class);
        doNothing().when(mockcustomer).setCustomerId(anyString());
        doNothing().when(mockcustomer).setName(anyString());
        doNothing().when(mockcustomer).setEmail(anyString());
        doNothing().when(mockcustomer).setWalletBalance(anyDouble());
        when(mockcustomer.getCustomerId()).thenReturn("C001");
        when(mockcustomer.getName()).thenReturn("Jane Doe");
        when(mockcustomer.getEmail()).thenReturn("jane@gmail.com");
        when(mockcustomer.getWalletBalance()).thenReturn(1000.00);
        assertEquals("C001",mockcustomer.getCustomerId());
        assertEquals("Jane Doe",mockcustomer.getName());
        assertEquals("jane@gmail.com",mockcustomer.getEmail());
        assertEquals(1000.00,mockcustomer.getWalletBalance(),0.0001);
    }
}
@RunWith(MockitoJUnitRunner.class) class MockCustomerControllerTest{
    @Mock
    CustomerCatalog customerCatalog= new CustomerCatalog();
    @InjectMocks
    private CustomerController customerController;
    @Test
    public void testAddToCatalog(){
        MockitoAnnotations.initMocks(this); Customer customer= new Customer("C001","John Doe","john@gmail.com", 1000.00);
        customerController.addToCatalog(customer);  verify(customerCatalog).addCustomer(customer);
    }}











class MockOnlineStoreTest{
    @Mock  ProductCatalog productCatalog= new ProductCatalog();

    @Mock  CustomerCatalog customerCatalog= new CustomerCatalog();
    @Mock
    ProductController productController=new ProductController(productCatalog);
    @Mock
    CustomerController customerController= new CustomerController(customerCatalog);
    @Mock
    OrderManager orderManager= new OrderManager();

    @InjectMocks  OnlineStore onlineStore= new OnlineStore();

    @Test
    void testAddProductToCatalog(){
        Product mockProduct= mock(Product.class);
        onlineStore.getProductCatalog().addProduct(mockProduct);
        verify(productController).addToCatalog(mockProduct);
    }
    @Test
    void testAddCustomerToCatalog(){
        Customer mockCustomer= mock(Customer.class);
        onlineStore.getCustomerCatalog().addCustomer(mockCustomer);
        verify(customerController).addToCatalog(mockCustomer);
    } }




class MockOnlineStoreManagementSystem{
    @Mock
    CustomerCatalog customerCatalog= new CustomerCatalog();
    @Mock
    CustomerController customerController= new CustomerController(customerCatalog);
    @Mock
            ProductCatalog productCatalog= new ProductCatalog();
    @Mock
    ProductController productController= new ProductController(productCatalog);
    @InjectMocks
    OnlineStoreManagementSystem system= new OnlineStoreManagementSystem(productController, customerController);
    @Test
    void testRun(){
        Product mockProduct= mock(Product.class); when(mockProduct.toString()).thenReturn("Mocked Product Details");
        Customer mockCustomer= mock(Customer.class); when(mockCustomer.toString()).thenReturn("Mocked Customer Details"); MockitoAnnotations.initMocks(this); system.run();




    verify(productController).addToCatalog(mockProduct);  verify(customerController).addToCatalog(mockCustomer);

    verify(mockProduct.toString()); verify(mockCustomer.toString());}






    @Test
    void testMain(){
       ProductCatalog productCatalog= mock(ProductCatalog.class);
       CustomerCatalog customerCatalog= mock(CustomerCatalog.class);
       ProductController mainProductController= new ProductController(productCatalog);
       CustomerController mainCustomerController= new CustomerController(customerCatalog);
       OnlineStoreManagementSystem mainSystem= new OnlineStoreManagementSystem(mainProductController, mainCustomerController);
       mainSystem.main(null);  verify(mainProductController).addToCatalog(any(Product.class));
       verify(mainCustomerController).addToCatalog(any(Customer.class));
    }}



@RunWith(MockitoJUnitRunner.class)
class MockCustomerCatalogTest{
    @InjectMocks CustomerCatalog customerCatalog= new CustomerCatalog();
    @Before
    public void setUp(){
        MockitoAnnotations.openMocks(this);}


    @Test
    public void testAddCustomer(){
        Customer customer= new Customer("C001","John Doe","john@gmail.com", 1000.00);
        customerCatalog.addCustomer(customer);
        assert customerCatalog.searchCustomer("C001") != null;
    }
    @Test
    public void testRemoveCustomer(){
        Customer customer= new Customer("C001","John Doe","john@gmail.com", 1000.00);
        customerCatalog.addCustomer(customer);  customerCatalog.removeCustomer(customer);
        assert customerCatalog.searchCustomer("C001") == null;
    }
    @Test
    public void testSearchCustomer(){
        Customer customer= new Customer("C001","John Doe","john@gmail.com", 1000.00);
        customerCatalog.addCustomer(customer);  Customer result= customerCatalog.searchCustomer("C001");






        assert result!=null; assert result.getCustomerId().equals("C001"); assert result.getName().equals("John Doe");
        assert result.getEmail().equals("john@gmail.com"); assert result.getWalletBalance() == 1000.00; }

    @Test
    public void testSearchCustomerNotFound(){
        Customer result= customerCatalog.searchCustomer("NoCustomerId");
        assertNull(result);
    } }

class MockOrderTest{
    @Mock private Customer mockCustomer;

    @Mock private Product mockProduct1; @Mock private Product mockProduct2;  @InjectMocks private Order order;

    @Test void testGettersAndSetters(){
        MockitoAnnotations.initMocks(this);

        String orderId="O001"; List<Product> products= Arrays.asList(mockProduct1, mockProduct2);
        Date orderDate= new Date();
        order.setOrderId(orderId);  order.setCustomer(mockCustomer);  order.setProducts(products); order.setOrderDate(orderDate);
        when(mockCustomer.getCustomerId()).thenReturn("C001"); when(mockProduct1.getProductId()).thenReturn("P001");
        when(mockProduct2.getProductId()).thenReturn("P002");
        assertEquals(orderId, order.getOrderId()); assertEquals(mockCustomer, order.getCustomer());
        assertEquals(products, order.getProducts());  assertEquals(orderDate, order.getOrderDate());




        verify(mockCustomer, times(2)).getCustomerId();
        verify(mockProduct1).getProductId();  verify(mockProduct2).getProductId();
    }
}

class MockOrderManagerTest{
    @Mock private Order mockOrder1;  @Mock private Order mockOrder2;  @InjectMocks private OrderManager orderManager;
    @Test void testPlaceOrder(){
        MockitoAnnotations.initMocks(this);
        orderManager.placeOrder(mockOrder1);   orderManager.placeOrder(mockOrder2);
        verify(orderManager, times(2)).placeOrder(any(Order.class));
        verify(orderManager).placeOrder(mockOrder1);  verify(orderManager).placeOrder(mockOrder2);
        List<Order> expectedOrders= new ArrayList<>();
        expectedOrders.add(mockOrder1);
        expectedOrders.add(mockOrder2);
        assertEquals(expectedOrders, orderManager.getAllOrders()); }




    @Test void testCancelOrder(){

        MockitoAnnotations.initMocks(this);  orderManager.placeOrder(mockOrder1);  orderManager.placeOrder(mockOrder2);
        orderManager.cancelOrder(mockOrder1);  verify(orderManager).cancelOrder(mockOrder1);
        List<Order> expectedOrders= new ArrayList<>();  expectedOrders.add(mockOrder2); assertEquals(expectedOrders, orderManager.getAllOrders());
    }



    @Test void testGetAllOrders() {

        MockitoAnnotations.initMocks(this);
        assertEquals(new ArrayList<>(), orderManager.getAllOrders());
        orderManager.placeOrder(mockOrder1);  orderManager.placeOrder(mockOrder2);
        List<Order> expectedOrders= new ArrayList<>();  expectedOrders.add(mockOrder1);  expectedOrders.add(mockOrder2);
        assertEquals(expectedOrders, orderManager.getAllOrders());
    }
}




class MockProductCatalogTest{
    @Test void testAddProduct(){
        Product mockProduct= mock(Product.class);  when(mockProduct.getProductId()).thenReturn("P001");
        ProductCatalog productCatalog= new ProductCatalog();
        productCatalog.addProduct(mockProduct);  assertTrue(productCatalog.products.contains(mockProduct));
    }
    @Test void testRemoveProduct()
    {
        Product mockProduct1= mock(Product.class);  when(mockProduct1.getProductId()).thenReturn("P001");
        Product mockProduct2= mock(Product.class);  when(mockProduct2.getProductId()).thenReturn("P002");
        ProductCatalog productCatalog= new ProductCatalog(); productCatalog.addProduct(mockProduct1);
        productCatalog.addProduct(mockProduct2);  productCatalog.removeProduct(mockProduct1);
        assertFalse(productCatalog.products.contains(mockProduct1));
        assertTrue(productCatalog.products.contains(mockProduct2));
    }
    @Test
    void testSearchProduct(){
        Product mockproduct1= mock(Product.class); when(mockproduct1.getProductId()).thenReturn("P001");
        Product mockproduct2= mock(Product.class); when(mockproduct2.getProductId()).thenReturn("P002");
        ProductCatalog productCatalog= new ProductCatalog();
        productCatalog.addProduct(mockproduct1); productCatalog.addProduct(mockproduct2);
        Product foundProduct= productCatalog.searchProduct("P001");
        assertEquals(mockproduct1, foundProduct); Product notFoundProduct= productCatalog.searchProduct("P003"); assertNull(notFoundProduct); }
}











class MockProductControllerTest{
    @Mock private ProductCatalog mockProductCatalog;


    @InjectMocks private ProductController productController;
    @Test void testAddToCatalog(){

        MockitoAnnotations.initMocks(this);  Product mockProduct= mock(Product.class);

        when(mockProduct.getProductId()).thenReturn("P001");
        productController.addToCatalog(mockProduct);

        verify(mockProductCatalog).addProduct(mockProduct);
    }
}
class MockShoppingCartTest{
    @Mock private Product mockProduct1;  @Mock private Product mockProduct2; @InjectMocks private ShoppingCart shoppingCart;

    @Test void testAddItem(){
        MockitoAnnotations.initMocks(this);
        shoppingCart.addItem(mockProduct1);  assertTrue(shoppingCart.getCartItems().contains(mockProduct1)); }


    @Test void testRemoveItem(){
        MockitoAnnotations.initMocks(this);
        shoppingCart.addItem(mockProduct1);  shoppingCart.addItem(mockProduct2); shoppingCart.removeItem(mockProduct1);
        assertFalse(shoppingCart.getCartItems().contains(mockProduct1));
        assertTrue(shoppingCart.getCartItems().contains(mockProduct2));}

    @Test void testGetCartItems(){
        MockitoAnnotations.initMocks(this);  List<Product> expectedItems= Arrays.asList(mockProduct1, mockProduct2);
        shoppingCart.addItem(mockProduct1); shoppingCart.addItem(mockProduct2);
        List<Product> cartItems= shoppingCart.getCartItems();

        assertEquals(expectedItems, cartItems);
        } }
