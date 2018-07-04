package com.prud.converter;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import com.prud.model.Answer;

public class ObjectToCSV<T> {

	public void objectToCSV(List<T> list) throws Exception {
		CsvMapper mapper = new CsvMapper();
		CsvSchema schema = mapper.schemaFor(Answer.class);
		schema = schema.withColumnSeparator(',');

		// output writer
		ObjectWriter myObjectWriter = mapper.writer(schema);
		File tempFile = new File("users.csv");
		FileOutputStream tempFileOutputStream = new FileOutputStream(tempFile);
		BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(tempFileOutputStream, 1024);
		OutputStreamWriter writerOutputStream = new OutputStreamWriter(bufferedOutputStream, "UTF-8");
		myObjectWriter.writeValue(writerOutputStream, list);
	}
}
