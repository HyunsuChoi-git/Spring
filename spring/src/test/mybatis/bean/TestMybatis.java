package test.mybatis.bean;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import test.spring.model.TestMybatisDTO;

@Controller
public class TestMybatis {
	
	@Autowired
	private SqlSessionTemplate sqlSession = null;
	
	@RequestMapping("mybatis.do")
	public String helloMybatis() {
		
		System.out.println(sqlSession);
		
		return "spring01/hello";
	}
	
	@RequestMapping("testTable.do")
	public String testTable(Model model) {
		
		//sqlSession -> DB -> sql 쿼리문 호출 -> 데이터 가져오기
		
		//전체 count 가져오기
		int count = (Integer)sqlSession.selectOne("test.userCount");
		model.addAttribute("count",count);
		
		//age가 가장 큰 데이터 가져오기
		int maxAge = (Integer)sqlSession.selectOne("test.maxAge");
		model.addAttribute("maxAge", maxAge);

		//모든 레코드 가져오기
		List<TestMybatisDTO> userList = (List)sqlSession.selectList("test.selectAll");
		model.addAttribute("userList", userList);
		
		//id를 주고 해당 id에 일치하는 레코드 가져옿기
		//파라미터는 한개만 보낼 수 있다.
		//여러개를 보낼 때에는 Map 타입에 넣어서 보내야 한다.
		String id = "test1";
		TestMybatisDTO user = (TestMybatisDTO)sqlSession.selectOne("test.getUser",id);
		model.addAttribute("user", user);
		
		//id 주고 reg결과 가져오기
		Timestamp reg = (Timestamp)sqlSession.selectOne("test.getReg", id);
		model.addAttribute("reg", reg);
		
		
		return "spring04/test";
	}
	
	@RequestMapping("insertForm.do")
	public String insertForm() {
		return "spring04/form";
	}
	@RequestMapping("insertPro.do")
	public String insertPro(TestMybatisDTO dto, Model model) {
		
		//db에 insert
		sqlSession.insert("test.insertUser", dto);
		model.addAttribute("dto", dto);
		
		
		return "spring04/pro";
	}
	
	@RequestMapping("update.do")
	public String update(Model model) {
		
		//id하나 던져주고 정보 가져오기
		TestMybatisDTO dto = (TestMybatisDTO)sqlSession.selectOne("test.getUser", "test2");
		model.addAttribute("dto", dto);
		
		return "spring04/update";
	}
	@RequestMapping("updatePro.do")
	public String updatePro(TestMybatisDTO dto, Model model) {
		
		//db에 insert

		//dto로 보낼 수 도 있지만 HashMap을 이용해보자
		HashMap map = new HashMap();
		map.put("mapId", dto.getId());
		map.put("mapPw", dto.getPw());
		map.put("mapAge", dto.getAge());
		
		sqlSession.insert("test.updateUser", map);
		model.addAttribute("dto", dto);
		
		
		return "spring04/updatePro";
	}
	
	
	@RequestMapping("deleteUser.do")
	public String deleteUser() {
		
		sqlSession.delete("deleteUser", "test1");
		
		
		return "spring04/delete";
	}
	

	
	
}
