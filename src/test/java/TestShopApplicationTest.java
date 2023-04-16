import org.example.TestShopFinalApplication;
import org.example.components.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = TestShopFinalApplication.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TestShopApplicationTest {
    @Autowired
    UserComponent userComponent;
    @Autowired
    ServeComponent serveComponent;

    @Autowired
    OrderComponent orderComponent;

    @Autowired
    GoodsComponent goodsComponent;

    @Test
    public void test1() { /*GoodsComponent.addNewGood("beer", 100);
        GoodsComponent.addNewGood("beer", 120);
        GoodsComponent.addNewGood("vodka", 1000);
        ServeComponent.addNewServe("nalit pivo", 200);
        GoodsComponent.addNewGood("nalit pivo", 100);

        System.out.println("PRODUCTS:");
        System.out.println(ProductComponent.getListOfProduct());

*/
      goodsComponent.addNewGood("milk",300);
      orderComponent.createOrder("Oleg", "+7999", "milk");

        System.out.println("USERS:");
        System.out.println(userComponent.getAllUsers());


        System.out.println("ORDERS:");
        System.out.println(orderComponent.getAllOrders());

        System.out.println(goodsComponent.getListOfProduct());

        serveComponent.addNewServe("nalit pivo", 200);
    }
}

