package test.spring.csv;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/csv/")
public class TestCsvBean {
	@Autowired
	CsvServiceBean csvService = null;
	
	@RequestMapping("writeCsv.do")
	public String writeCsv(HttpServletRequest request) {
		
		List<String[]> data = new ArrayList<String[]>();
		data.add(new String[] {"1", "아이언맨", "010-1111-1111"});
		data.add(new String[] {"2", "토르", "010-1111-2222"});
		data.add(new String[] {"3", "캡틴아메이카", "010-1111-3333"});
		data.add(new String[] {"4", "헐크", "010-1111-4444"});
		
		//실제 서버에서 서비스 해주는 폴더의 경로 가져오기
		String path = request.getRealPath("resources/csv");
		
		path += "\\test.csv";  //실제 폴더경로에 파일(+확장자)명 붙히기
		System.out.println("path: "+path);
		
		//위의 List에 들어있는 정보를 CSV 비지니스로직 처리하는 메소드에 전달하며
		//CSV 파일을 만들게 시켜야함
		csvService.writeCSV(data, path);
		
		return "testCsv/testCsv";
	}
	
	@RequestMapping("readCsv.do")
	public String readCsv(HttpServletRequest request) {
		//읽어온 파일 저장할 data 변수
		System.out.println("readread");
		List<String[]> data = new ArrayList<String[]>();
		//파일이 위치한 실제 경로 찾기
		String path = request.getRealPath("resources/csv");
		path += "\\test.csv";
		data = csvService.readCSV(path);
		System.out.println("data 받았다 : "+ data);
		
		Iterator<String[]> it = data.iterator();
		while(it.hasNext()) {
			String[] arr = (String[])it.next();
			for(String s : arr) {
				System.out.print(s + " ");
			}
			System.out.println();
		}
		
		return "testCsv/testCsv";
	}
	
	//3. CSV -> Bean
	@RequestMapping("csvToBean.do")
	public String csvToBean(HttpServletRequest request) {
		
		//파일이 위치한 실제 경로 찾기
		String path = request.getRealPath("resources/csv");
		path += "\\test.csv";
		//파일 경로 던져주면, 데이터가 VO에 담긴 vo들이 저장된 리스트를 리턴받겠다.
		List<TestCsvVO> data = csvService.readCsvToBean(path);
		Iterator<TestCsvVO> it = data.iterator();
		while(it.hasNext()) {
			TestCsvVO vo = (TestCsvVO)it.next();
			System.out.println("num : "+ vo.getNum());
			System.out.println("name : "+ vo.getName());
			System.out.println("mobile : "+ vo.getMobile());
			
		}
		
		
		return "testCsv/testCsv";
	}
}
