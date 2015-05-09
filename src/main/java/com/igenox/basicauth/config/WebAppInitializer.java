package com.igenox.basicauth.config;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import java.util.Set;

/**
 * Created by alexandru.ionita on 5/8/15.
 */
public class WebAppInitializer implements WebApplicationInitializer
{

    private static final Log LOG = LogFactory.getLog(WebAppInitializer.class);
    public static final String ROOT_PACKAGE = "com.igenox.basicauth";

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException
    {
        if (LOG.isDebugEnabled())
        {
            LOG.debug("Initialize Spring context with root scan in " + ROOT_PACKAGE);
        }
        AnnotationConfigWebApplicationContext root = new AnnotationConfigWebApplicationContext();
        root.scan(ROOT_PACKAGE);

        servletContext.addListener(new ContextLoaderListener(root));

        ServletRegistration.Dynamic appServlet =
                servletContext.addServlet("appServlet", new DispatcherServlet(root));
        appServlet.setLoadOnStartup(1);
        Set<String> mappingConflicts = appServlet.addMapping("/");
        if (!mappingConflicts.isEmpty())
        {
            throw new IllegalStateException("'appServlet' could not be mapped to '/'");
        }
    }
}
