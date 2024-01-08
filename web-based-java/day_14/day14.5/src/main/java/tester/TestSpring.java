package tester;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import config.MyConfiguration;
import dependent.ATMImpl;

public class TestSpring {

	public static void main(String[] args) {
		// launch SC
		try (AnnotationConfigApplicationContext ctx = 
				new AnnotationConfigApplicationContext(MyConfiguration.class)) {
			System.out.println("SC up n running ....");
			// deposit funds
			// get rdy to use (ready for servicing) spring bean from SC
			ATMImpl ref1 = ctx.getBean("my_atm", ATMImpl.class);
			ref1.deposit(12345);

		} // ctx.close() => shutting down SC --
			// searches for singleton beans --if it has custom destroy method --
			// invokes it --marks the bean for GC
		catch (Exception e) {
			e.printStackTrace();
		}

	}

}
