package web_app_listeners;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import utils.HibernateUtils;

@WebListener
public class HibernateSFManager implements ServletContextListener {

	public HibernateSFManager() {
	}

	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("in ctx destroyed");
		HibernateUtils.getFactory().close();
	}

	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("in ctx inited");
		HibernateUtils.getFactory();
	}

}
