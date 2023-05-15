package bai1;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.text.DecimalFormat;
import java.util.List;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập mã hóa đơn: ");
        int orderID = scanner.nextInt();
        System.out.print("Nhập ngày lập hóa đơn (d/M/yyyy): ");
        String orderDateStr = scanner.next();
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("d/M/yyyy");
        LocalDate orderDate = LocalDate.parse(orderDateStr, dateFormatter);
       

        /*Product product1 = new Product("Nước tương", "sp4", 8000);
        Product product2 = new Product("Gạo", "sp1", 18000);
        Product priduct3 = new Product("Đường", "sp3", 10000);
        Product product4 = new Product("Gạo", "sp1", 18000);
        Product product5 = new Product("Muối", "sp5", 10000);
        Product product6 = new Product("Bột ngọt", "sp6" , 5000);
       
        order.addLineItems(product1, 10);
        order.addLineItems(product2, 5);
        order.addLineItems(priduct3, 1);
        order.addLineItems(product4, 1);
        order.addLineItems(product5, 2);
        order.addLineItems(product6, 1);*/
        
        Order order = new Order(orderID, orderDate);
        boolean continueAdding = true;
        while (continueAdding) {
            System.out.print("Nhập tên sản phẩm: ");
            String productName = scanner.next();
            scanner.nextLine();
            System.out.print("Nhập mã sản phẩm: ");
            String productID = scanner.next();
            System.out.print("Nhập đơn giá: ");
            double price = scanner.nextDouble();
            System.out.print("Nhập số lượng: ");
            int quantity = scanner.nextInt();
            
            Product product = new Product(productName, productID, price);
            order.addLineItems(product, quantity);
            
            System.out.print("Tiếp tục thêm sản phẩm? (y/n): ");
            String choice = scanner.next();
            continueAdding = choice.equalsIgnoreCase("y");
        }

        System.out.println("Mã hóa đơn: " + order.getOrderID());
        String formattedDate = order.getOrderDate().format(dateFormatter);
        System.out.println("Ngày lập hóa đơn: " + formattedDate);
        System.out.println("STT       |  Mã Sp   |         Mô tả         |     Đơn giá     |     Số lượng    |    Thành tiền");

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


