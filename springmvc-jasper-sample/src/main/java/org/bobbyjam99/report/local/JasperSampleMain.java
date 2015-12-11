package org.bobbyjam99.report.local;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRCsvDataSource;

/**
 * JasperReports Library Output Sample.
 *
 */
public class JasperSampleMain {

	public static void main(String[] args) {
		Map<String, Object> parameters = new HashMap<>();
		JRCsvDataSource dataSource = new JRCsvDataSource(
				JasperSampleMain.class.getResourceAsStream("example.csv"));
		dataSource.setUseFirstRowAsHeader(true);
		try (InputStream template = JasperSampleMain.class
				.getResourceAsStream("members.jrxml")) {
			JasperReport report = JasperCompileManager.compileReport(template);
			JasperPrint jasperPrint = JasperFillManager.fillReport(report,
					parameters, dataSource);
			JasperExportManager.exportReportToPdfFile(jasperPrint,
					"example.pdf");
		} catch (IOException | JRException e) {
			e.printStackTrace();
		}
	}
}
