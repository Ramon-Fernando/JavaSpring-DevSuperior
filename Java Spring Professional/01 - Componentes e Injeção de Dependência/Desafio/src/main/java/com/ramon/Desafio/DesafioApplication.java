package com.ramon.Desafio;

import com.ramon.Desafio.entities.Order;
import com.ramon.Desafio.services.OrderService;
import com.ramon.Desafio.services.ShippingService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Locale;
import java.util.Scanner;

@SpringBootApplication
public class DesafioApplication implements CommandLineRunner {

    public static void main(String[] args) {
		SpringApplication.run(DesafioApplication.class, args);
	}

	private final OrderService orderService;

	public DesafioApplication(OrderService orderService) {
		this.orderService = orderService;
	}

	@Override
	public void run(String... args) throws Exception {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		System.out.println("Digite o código do pedido: ");
		Integer code = sc.nextInt();
		System.out.println("Digite o valor do pedido: ");
		Double basic = sc.nextDouble();
		System.out.println("Digite a porcentagem do desconto: ");
		Double discount = sc.nextDouble();

		Order order = new Order(code, basic, discount);

		System.out.println("Pedido código " + order.getCode());
		System.out.printf("Valor total: R$ %.2f%n", orderService.total(order));
	}
}
