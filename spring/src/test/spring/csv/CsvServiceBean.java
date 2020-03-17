package test.spring.csv;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;

import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.CSVWriter;
import au.com.bytecode.opencsv.bean.ColumnPositionMappingStrategy;
import au.com.bytecode.opencsv.bean.CsvToBean;

public class CsvServiceBean {
	
	//0. openCSV 라이브러리 pom.xml에 추가
	//	<dependency>
	//    <groupId>net.sf.opencsv</groupId>
	//    <artifactId>opencsv</artifactId>
	//    <version>2.3</version>
	//	</dependency>
	
	//1. 파일 쓰기 메소드 ( 리스트 타입의 데이터, 파일경로 두개를 매개변수로 받는다)
	public void writeCSV(List<String[]> data, String filename) {
		// openCSV 라이브러리에 있는 CSVWriter 클래스 객체 생성
		CSVWriter cw = null;
		
		try {
			// 새 파일명으로 FileWriter객체, 구분자, 따옴표문자(quotecher) 지정
			//https://blog.naver.com/loveyou_a_a/221720964374  참고
			FileOutputStream fos = new FileOutputStream(filename);
			cw = new CSVWriter(new OutputStreamWriter(fos, "UTF-8"),',','"');
			
			
			//한줄 씩 꺼내어 일일이 작성하는 로직
			/*	Iterator<String[]> it = data.iterator();
			try {
				while(it.hasNext()) {
					String[] s = (String[])it.next();
					cw.writeNext(s);
				}
			}finally {
				cw.close();
			}
			 */
			
			cw.writeAll(data); //한번에 데이터 저장
			cw.flush();
			cw.close();
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	
	//2. csv 파일 읽기 메소드
	public List<String[]> readCSV(String filename){
		List<String[]> data = new ArrayList<String[]>();
		try {
			System.out.println("readCSV readCSV");
			//new CSVReader(InputStreamReader 객체, 구분자, 예외구문, 삭제할 열)
			//구분자 : csv 구분자가 ',' 이므로 ,로 지정. 챕들 다른 표식일 경우 다른 것으로 지정도 가능
			//예외구문 : "는 예외 구분
			//삭제할 열 : 윗줄은 보통 설명문구일 경우가 많으므로 삭제하고 출력하고 싶은 경우 줄삭제가 가능하다
			CSVReader reader = new CSVReader(new InputStreamReader(new FileInputStream(filename),"UTF-8"),',','"',0);
			data = reader.readAll();
			
			reader.close();
		}catch(Exception e) { e.getStackTrace(); }
		
		return data;
	}
	
	
	//3. csv -> Bean 맵핑해서 List에 담아 리턴
	public List<TestCsvVO> readCsvToBean(String filename){
		
		List<TestCsvVO> data = null;
		try {
			//csv 파일 읽기
			CSVReader reader = new CSVReader(new InputStreamReader(new FileInputStream(filename),"UTF-8"),',','"',0);
			
			//CSV 를 VO에 매핑해주는 매퍼 역할을 할 클래스 객체 생성
			ColumnPositionMappingStrategy<TestCsvVO> mapper = new ColumnPositionMappingStrategy<TestCsvVO>();
			mapper.setType(TestCsvVO.class);   //VO파일을 맵핑하겠다.
			String[] columns = new String[] {"num","name","mobile"}; // 각 컬럼을 정의할 배열
			mapper.setColumnMapping(columns); //각 컬럼명을 매퍼에 설정
			
			//매핑하기!!
			CsvToBean<TestCsvVO> csv = new CsvToBean<TestCsvVO>();
			data = csv.parse(mapper, reader); //(매핑방법, csv파일)
			
			reader.close();
 			
			
		}catch(Exception e) {
			e.getStackTrace();
		}
		
		return data;
	}
	
}
