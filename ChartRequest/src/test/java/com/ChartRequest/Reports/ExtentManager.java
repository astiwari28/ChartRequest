package com.ChartRequest.Reports;

import java.io.File;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {

	private static ExtentReports extent;

	public static ExtentReports getInstance() {
		if (extent == null) {
			createInstance();
		}
		return extent;
	}

	public static synchronized ExtentReports createInstance() {
		String fileName = getReportName();
		String directory = System.getProperty("user.dir") + "/AutomationReports/";
		new File(directory).mkdir();
		String path = directory + fileName;
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(path);
		htmlReporter.config().setTheme(Theme.DARK);
		htmlReporter.config().setDocumentTitle("Chart Request");
		htmlReporter.config().setEncoding("utf-8");
		htmlReporter.config().setReportName("Automation Report");
		htmlReporter.config().setAutoCreateRelativePathMedia(true);
		extent = new ExtentReports();
		// Set environment details
		extent.setSystemInfo("OS", System.getProperty("os.name"));
		try {
			extent.setSystemInfo("AUT", InetAddress.getLocalHost().getHostName());
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		extent.attachReporter(htmlReporter);
		return extent;
	}

	public static String getReportName() {
		Date d = new Date();
		String fileName = "AutomationReport" + "_" + d.toString().replace(":", "_").replace(" ", "_") + ".html";
		return fileName;
	}
}
