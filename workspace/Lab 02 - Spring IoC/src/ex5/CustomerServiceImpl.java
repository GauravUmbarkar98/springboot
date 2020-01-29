package ex5;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class CustomerServiceImpl implements CustomerService, ApplicationContextAware {

	private ApplicationContext ctx;
	
	@Override
	public void setApplicationContext(ApplicationContext ctx) {
		System.out.println("ApplicationContext is set");
		this.ctx = ctx;
	}

	private BillPaymentService createBillPaymentInstance() {
		System.out.println("private createBillPaymentInstance() returning BillPaymentService object");
		return ctx.getBean("billPaymentService", BillPaymentService.class);
	}
	
	public void payBill(double amt) {
		System.out.println("payBill invoked..");
		BillPaymentService billingService = createBillPaymentInstance();
		//we need to call some method of BillPaymentService here. Right now not required.
	}
}
