package application;
import jurosJey.service.OnlinePaymentService;
import jurosJey.service.PaypalService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import jurosJey.entities.Contract;
import jurosJey.entities.Installment;
import jurosJey.service.ContractService;

public class Program {

	public static void main(String[] args) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter contract data");
		System.out.println("Number: ");
		Integer number = sc.nextInt();
		System.out.println("Date (dd/MM/yyyy): ");
		Date date = sdf.parse(sc.next());
		System.out.println("Contract value: ");
		Double totalValue = sc.nextDouble();
		System.out.println("Enter number of installments: ");
		int N = sc.nextInt();
		Contract contract = new Contract(number, date, totalValue);
		ContractService cs = new ContractService(new PaypalService());
		cs.processContract(contract, N);
		System.out.println("Instalments: ");
		for (Installment it : contract.getInstallment()) {
			System.out.println(it);
		}
		
		
		
		
		
		
	sc.close();
	}
}
