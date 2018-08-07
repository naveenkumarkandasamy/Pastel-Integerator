import java.io.File;
import java.util.List;

import com.prud.pastel.converter.FlatFileToObjectConvertor;
import com.prud.pastel.converter.ObjectToCSVConvertor;
import com.prud.pastel.converter.ObjectToExcelConvertor;
import com.prud.pastel.converter.XLSXtoObjectConvertor;
import com.prud.pastel.mapper.PASToPastelMapper;
import com.prud.pastel.model.PASRecord;
import com.prud.pastel.model.Receipts;

public class Test {

	public static void main(String[] args) throws Exception {
		FlatFileToObjectConvertor flatFileToObjectConvertor = new FlatFileToObjectConvertor();
		List<Receipts> userList = flatFileToObjectConvertor.convertToPastelRecord();
		ObjectToExcelConvertor objectToExcel = new ObjectToExcelConvertor();
		File file = objectToExcel.convertObjectToExcel(userList);
		//FTPManager.send(file);
	}
}
