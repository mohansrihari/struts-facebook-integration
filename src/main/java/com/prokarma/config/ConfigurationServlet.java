package com.prokarma.config;

import java.io.File;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Properties;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.apache.log4j.Logger;
import org.apache.log4j.RollingFileAppender;

import com.prokarma.common.Context;
import com.prokarma.common.FacebookConstants.PropertyFields;

public class ConfigurationServlet extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;
	static Logger logger = Logger.getLogger(ConfigurationServlet.class);
	public void init(ServletConfig config) throws ServletException {
		try {

			configureLogger(config);
			commonConfiguration();

		} catch (IOException e) {
			logger.error("Global configuration generation failed.",e);
		}
	}

	private void configureLogger(ServletConfig config) throws IOException {


		ServletContext servletContext = config.getServletContext();
		String logDir =servletContext.getRealPath("");
		File logFile = new File(logDir+"\\FacebookUI.log");

		Logger logger = Logger.getLogger(ConfigurationServlet.class);
		@SuppressWarnings("unchecked")
		Enumeration<RollingFileAppender> en = logger.getParent().getAllAppenders();
		RollingFileAppender appender = new RollingFileAppender();
		while (en.hasMoreElements()) {
			appender = en.nextElement();
		}
		appender.setFile(logFile.getAbsolutePath(), true, true, 1024);
		String appenderName = appender.getName();
		logger.removeAppender(appenderName);
		logger.addAppender(appender);
	}

	private void commonConfiguration() throws IOException {
		Properties facebookInforProperties = new Properties();
		facebookInforProperties.load(ConfigurationServlet.class.getResourceAsStream("facebook.info.properties"));
		
		String facebookAppId=facebookInforProperties.getProperty(PropertyFields.facebookAppId);
		String facebookAppSecret=facebookInforProperties.getProperty(PropertyFields.facebookAppSecret);
		String facebookAppChannelURL=facebookInforProperties.getProperty(PropertyFields.facebookAppChannelURL);
		String facebookAppLandingPageCanvas=facebookInforProperties.getProperty(PropertyFields.facebookAppLandingPageCanvas);
		String facebookAppUrl=facebookInforProperties.getProperty(PropertyFields.facebookAppUrl);
		
		Context.configureConstants(facebookAppId, facebookAppSecret, facebookAppChannelURL, facebookAppLandingPageCanvas, facebookAppUrl);

	}
}