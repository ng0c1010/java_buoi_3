package bai1;

import java.time.LocalDate;
import java.text.DecimalFormat;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        Product product1 = new Product("Nước tương", "sp4", 8000);
        Product product2 = new Product("Gạo", "sp1", 18000);
        Product priduct3 = new Product("Đường", "sp3", 10000);
        Product product4 = new Product("Gạo", "sp1", 18000);

        Order order = new Order(1, LocalDate.of(2015, 9, 10));
        
        order.addLineItems(product1, 10);
        order.addLineItems(product2, 5);
        order.addLineItems(priduct3, 1);
        order.addLineItems(product4, 1);

        
        System.out.println("Mã hóa đơn: " + order.getOrderID());
        System.out.println("Ngày lập hóa đơn: " + order.getOrderDate());
        System.out.println("STT       |  Mã Sp   |   Mô tả               |     Đơn giá     |     Số lượng    |    Thành tiền");

        DecimalFormat decimalFormat = new DecimalFormat("#,### VND");
        List<OrderDetail> lineItems = order.getLineItems();
        int stt = 1;
        for (OrderDetail orderDetail : lineItems) {
            System.out.printf("%-10s|  %-8s|   %-20s|  %-15s|  %-15s|  %-15s\n",
                    stt,
                    orderDetail.getProduct().getProductID(),
                    orderDetail.getProduct().getDes(),
                    decimalFormat.format(orderDetail.getProduct().getPrice()),
                    orderDetail.getQuantily(),
                    decimalFormat.format(orderDetail.calcTotalPrice()));
            stt++;
        }

        System.out.println("Tổng tiền thanh toán: " + decimalFormat.format(order.calcTotalCharge(0)));
    }
}
