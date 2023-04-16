package org.example.components;

import org.example.Goods;
import org.example.Order;
import org.example.ProdsAbstract;
import org.example.repositories.GoodsRepository;
import org.example.repositories.OrderRepository;
import org.example.repositories.ServRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderComponent {

    private final UserComponent userComponent;
    private final GoodsComponent goodsComponent;

    private final ServeComponent serveComponent;
    private  final OrderRepository orderRepository;


    public OrderComponent(UserComponent userComponent,
                          OrderRepository orderRepository,
                          GoodsRepository goodsRepository, ServRepository servRepository, GoodsComponent goodsComponent, ServeComponent serveComponent) {
        this.userComponent = userComponent;
        this.goodsComponent = goodsComponent;
        this.serveComponent = serveComponent;

        this.orderRepository = orderRepository;
    }

    public Order createOrder(String userName, String phoneNumber, String productName) {
        ProdsAbstract product = null;
        var user = userComponent.getOrCreateUser(userName, phoneNumber);
        product = goodsComponent.getProductByName(productName);
        if (product instanceof Goods) {
            Goods good = (Goods) product;
            if (good.getRemainder() < 1) {
                throw new IllegalStateException(String.format("Товара '%s' не осталось", productName));
            }
            good.setRemainder(good.getRemainder() - 1);
        }
        var order = new Order(user.getId(), product.getId());
        orderRepository.save(order);
        return order;
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public static void deleteOrder(String name, String productName) {

    }

    public List<Order> getAllOrdersByUser(String phoneNumber) {
        var user = userComponent.getUserIdByPhone(phoneNumber);
        var ordersOfUser = orderRepository.findByAuthorId(user.getId());
        return ordersOfUser;
    }
}
