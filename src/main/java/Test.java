import java.io.File;
import java.util.List;

import com.prud.pastel.converter.FlatFileToObjectConvertor;
import com.prud.pastel.converter.ObjectToCSVConvertor;
import com.prud.pastel.converter.XLSXtoObjectConvertor;
import com.prud.pastel.mapper.PASToPastelMapper;
import com.prud.pastel.model.PASRecord;
import com.prud.pastel.model.PastelRecord;

public class Test {

	public static void main(String[] args) throws Exception {
		FlatFileToObjectConvertor flatFileToObjectConvertor = new FlatFileToObjectConvertor();
		List<PastelRecord> userList = flatFileToObjectConvertor.convertToPastelRecord();
		ObjectToCSVConvertor objectCsv = new ObjectToCSVConvertor();
		File file = objectCsv.convertObjectToCSV(userList);
		//FTPManager.send(file);
	}
}
