import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.prud.pastel.comm.FTPManager;
import com.prud.pastel.converter.ObjectToCSVConvertor;
import com.prud.pastel.converter.XLSXtoObjectConvertor;
import com.prud.pastel.mapper.BeanMapper;
import com.prud.pastel.model.UserConversionInfo;
import com.prud.pastel.model.UserTransactionInfo;

public class Test {

	public static void main(String[] args) throws Exception {
		XLSXtoObjectConvertor XLSXtoObjectConvertor = new XLSXtoObjectConvertor();
		List<UserTransactionInfo> people = XLSXtoObjectConvertor.xlsxToJavaObject();
		BeanMapper mapper = BeanMapper.getInstance();
		List<UserConversionInfo> userList = mapper.userInfoMapper(people);
		ObjectToCSVConvertor objectCsv = new ObjectToCSVConvertor();

		File file = objectCsv.objectToCSV(userList);
		FTPManager.send(file);
	}
}
