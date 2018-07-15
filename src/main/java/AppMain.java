import statementparser.DocumentParser;
import statementparser.DocumentParserFactory;
import statementprocessor.DataProcessor;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;

import model.*;

public class AppMain {
	static Logger logger = Logger.getLogger(AppMain.class.getName());

	public static void main(String[] args) throws IOException {

		DocumentParser parser = null;
		List<Record> records = new ArrayList<Record>();
		DataProcessor processor = null;
		FileWriter fw = null;
		String appConfigPath = ".\\config.properties";
		Properties appProps = new Properties();
		

		try {
			appProps.load(new FileInputStream(appConfigPath));
			String rootDir = appProps.getProperty("STATEMENTS_DIRECTORY");

			// Collect all files
			List<File> files = Files.walk(Paths.get(rootDir)).filter(Files::isRegularFile).map(Path::toFile)
					.collect(Collectors.toList());

			// Parse each file serially
			for (File file : files) {
				parser = DocumentParserFactory.getParserFactory(file);
				records.addAll(parser.parse());
				logger.fine("File Name :" + file.getName() + " Records :" + records);
			}

			// Process all the records and prepare report
			processor = new DataProcessor(records);
			logger.fine("Invalid Mutation :" + processor.findInvalidMutations());
			logger.fine("Duplicate Reference :" + processor.findDuplicateReferenceRecords());
			logger.fine(" -------------- \n\n");
			List<ResultRecord> results = processor.prepareReport(processor.findDuplicateReferenceRecords(),
					processor.findInvalidMutations());
			logger.fine(" Results : " + results);

			// Generate html report
			VelocityEngine velocityEngine = new VelocityEngine();
			velocityEngine.init();
			Template t = velocityEngine.getTemplate("result_template.vm"); // html template file
			VelocityContext context = new VelocityContext();
			context.put("results", results);
			StringWriter writer = new StringWriter();
			t.merge(context, writer);
			fw = new FileWriter("results" + " _" + System.currentTimeMillis() + ".html");
			fw.write(writer.toString());
			logger.info("Results Generated");

		} catch (IOException e) {
			logger.info("Results Generated");
			// e.printStackTrace();
		} catch (Exception e) {
			logger.info("Results Generated");
			// e.printStackTrace();
		} finally {
			fw.close();
		}
	}
}
