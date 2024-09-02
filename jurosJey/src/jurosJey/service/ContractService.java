package jurosJey.service;

import java.util.Calendar;
import java.util.Date;

import jurosJey.entities.Contract;
import jurosJey.entities.Installment;

public class ContractService {
	
	private Contract contrato;
	private OnlinePaymentService onlinePaymentService;
	public ContractService(OnlinePaymentService onlinePaymentService) {
		this.onlinePaymentService = onlinePaymentService;
	}
	
	public void processContract(Contract contrato, int months) {
		double basicquota = contrato.getTotalvalue() / months;
		for(int i = 1; i <= months; i++) {
			double updatequota = basicquota + onlinePaymentService.interest(basicquota, i);
			double fullquota = updatequota + onlinePaymentService.paymentFee(updatequota);
			Date duedate = addMonths(contrato.getDate(), i);
			contrato.getInstallment().add(new Installment(duedate, fullquota));
		}
	}
	private Date addMonths(Date date, int N) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.MONTH, N);
		return calendar.getTime();
	}

}
