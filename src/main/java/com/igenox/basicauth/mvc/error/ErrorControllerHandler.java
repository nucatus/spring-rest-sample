package com.igenox.basicauth.mvc.error;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by alexandru.ionita on 5/17/15.
 */
@ControllerAdvice
public class ErrorControllerHandler
{
    private static final Log LOG = LogFactory.getLog(ErrorControllerHandler.class);

    @ExceptionHandler(value = Exception.class)
    public void handleExceptions(HttpServletRequest req, HttpServletResponse rep) throws IOException
    {
        if (LOG.isDebugEnabled())
        {
            LOG.debug("Error detected while handling: " + req.getContextPath());
        }
        rep.getWriter().write("An error occurred");
    }

}
