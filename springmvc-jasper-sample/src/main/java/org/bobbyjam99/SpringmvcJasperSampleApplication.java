package org.bobbyjam99;

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

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringmvcJasperSampleApplication {

	public static void main(String[] args) {
		Map<String, Object> parameters = new HashMap<>();
		JRCsvDataSource dataSource = new JRCsvDataSource(
				SpringmvcJasperSampleApplication.class
						.getResourceAsStream("brm.csv"));
		dataSource.setUseFirstRowAsHeader(true);
		try (InputStream template = SpringmvcJasperSampleApplication.class
				.getResourceAsStream("example.jrxml")) {
			JasperReport report = JasperCompileManager.compileReport(template);
			JasperPrint jasperPrint = JasperFillManager.fillReport(report,
					parameters, dataSource);
			JasperExportManager.exportReportToPdfFile(jasperPrint,
					"example.pdf");
		} catch (IOException | JRException e) {
			e.printStackTrace();
		}
		SpringApplication.run(SpringmvcJasperSampleApplication.class, args);
	}
}
