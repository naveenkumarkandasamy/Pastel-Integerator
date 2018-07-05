import java.io.File;
import java.util.List;

import com.prud.pastel.comm.FTPManager;
import com.prud.pastel.converter.ObjectToCSV;
import com.prud.pastel.converter.XLSXtoJavaObject;
import com.prud.pastel.mapper.BeanMapper;
import com.prud.pastel.model.UserConversionInfo;
import com.prud.pastel.model.UserTransactionInfo;

public class Test {
	public static void main(String[] args) throws Exception {
		List<UserTransactionInfo> people = XLSXtoJavaObject.xlsxToJavaObject();
		BeanMapper mapper=new BeanMapper();
		List<UserConversionInfo> userList=mapper.userInfoMapper(people);
		
		ObjectToCSV objectCsv = new ObjectToCSV();
		
		File file = objectCsv.objectToCSV(userList);
		FTPManager.send(file);

	}
}
