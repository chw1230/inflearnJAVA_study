package ref.ex;

import java.util.Scanner;

public class ProductOrderMain3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("입력할 주문의 개수를 입력하세요: ");
        int option = input.nextInt();
        input.nextLine();

        ProductOrder[] orders = new ProductOrder[3];
        for (int i = 0; i < option; i++) {
            System.out.println((i+1)+"번째 주문 정보를 입력하세요.");

            System.out.print("상품명: ");
            String productName = input.nextLine();
            System.out.print("가격: ");
            int price = input.nextInt();
            System.out.print("수량: ");
            int quantity = input.nextInt();
            input.nextLine();

            orders[i] = createOrder(productName,price,quantity);
        }

        printOrder(orders);
        System.out.println("총 결제 금액: "+getTotalAmount(orders)+"원");

    }

    static int getTotalAmount(ProductOrder[] orders){
        int total = 0;
        for (ProductOrder order : orders) {
            total += (order.price) * (order.quantity);
        }

        return total;
    }

    static ProductOrder createOrder(String productName, int price, int quantity){
        ProductOrder product = new ProductOrder();
        product.productName = productName;
        product.price = price;
        product.quantity = quantity;
        return product;
    }

    static void printOrder(ProductOrder[] orders){
        for (ProductOrder order : orders) {
            System.out.println("상품명: " + order.productName + ", 가격: " + order.price + ", 수량: " + order.quantity);
        }
    }
}
