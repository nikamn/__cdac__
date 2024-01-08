package web_listeners;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import static utils.HibernateUtils.getFactory;

@WebListener
public class HibernateSFManager implements ServletContextListener {

	public HibernateSFManager() {
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("In contextDestroyed() of " + getClass());
		getFactory().close();
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("In contextInitialized() of " + getClass());
		getFactory();
	}

}
