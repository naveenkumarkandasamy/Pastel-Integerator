import java.io.File;
import java.util.List;

import com.prud.pastel.comm.FTPManager;
import com.prud.pastel.converter.ObjectToCSVConvertor;
import com.prud.pastel.converter.XLSXtoObjectConvertor;
import com.prud.pastel.mapper.PASToPastelMapper;
import com.prud.pastel.model.PASRecord;
import com.prud.pastel.model.PastelRecord;

public class Test {

	public static void main(String[] args) throws Exception {
		XLSXtoObjectConvertor XLSXtoObjectConvertor = new XLSXtoObjectConvertor();
		List<PASRecord> people = XLSXtoObjectConvertor.xlsxToJavaObject();
		PASToPastelMapper mapper = PASToPastelMapper.getInstance();
		List<PastelRecord> userList = mapper.createPastelList(people);
		ObjectToCSVConvertor objectCsv = new ObjectToCSVConvertor();
		File file = objectCsv.convertObjectToCSV(userList);
		FTPManager.send(file);
	}
}
