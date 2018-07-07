package com.prud.pastel.converter;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import com.prud.pastel.model.UserConversionInfo;

@Component
public class ObjectToCSVConvertor {
	private static final Logger logger = Logger.getLogger(ObjectToCSVConvertor.class);
	private static final char COMMA = ',';

	public File objectToCSV(List<? extends Object> list) {
		CsvMapper mapper = new CsvMapper();

		CsvSchema schema = mapper.schemaFor(UserConversionInfo.class);
		schema = schema.withColumnSeparator(COMMA).withHeader();

		// output writer
		ObjectWriter myObjectWriter = mapper.writer(schema);
		File tempFile = new File("transaction.csv");
		FileOutputStream tempFileOutputStream = null;
		try {
			tempFileOutputStream = new FileOutputStream(tempFile);
			BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(tempFileOutputStream, 1024);
			OutputStreamWriter writerOutputStream = new OutputStreamWriter(bufferedOutputStream, "UTF-8");
			myObjectWriter.writeValue(writerOutputStream, list);
		} catch (FileNotFoundException e) {

			logger.error("Error while creating CSV file" + e);
			e.printStackTrace();
		} catch (Exception e) {
			logger.error("Error while writing into CSV using jackson" + e);
			e.printStackTrace();
		}
		return tempFile;
	}
}
