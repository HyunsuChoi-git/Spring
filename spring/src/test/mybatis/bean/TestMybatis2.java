package test.mybatis.bean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import test.spring.model.TestMybatisDTO;

@Controller
public class TestMybatis2 {
   
   @Autowired
   private SqlSessionTemplate sqlSession = null;
   
   @RequestMapping("selectIf.do")
   public String selectIf() {
      
      TestMybatisDTO dto = new TestMybatisDTO();
      dto.setId("java2");      
      dto.setPw("1234");
      
//      int count = (Integer)sqlSession.selectOne("myba.selectIf", dto);
//      System.out.println(count);
      
//      int count = (Integer)sqlSession.selectOne("myba.choose", dto);
//      System.out.println(count);
      
      /*
       * int count = (Integer)sqlSession.selectOne("myba.selectTrim", dto);
       * System.out.println(count);
       * 
       * sqlSession.update("myba.updateTest",dto);
       */
      
      // id들을 주고 이들 중 일치하는 id가 DB에 몇개 저장되어 있는지 알고 싶다.
//      List list = new ArrayList();
//      list.add("java");
//      list.add("java1");
//      list.add("java2");
//      list.add("java3");
//      int count  = (Integer)sqlSession.selectOne("myba.selectIn",list);
//      System.out.println(count);
      
      // like 구문
//      HashMap map = new HashMap();
//      map.put("sel", "id");   // a검색할 카테고리 : DB컬럼명
//      map.put("keyword", "java");   // a검색할 키워드 : 사용자가 입력한 값
//      int count = (Integer)sqlSession.selectOne("myba.selectLike", map);
//      System.out.println(count);
      
      sqlSession.update("myba.updateKey", dto);
      
      
      return "spring05/select";
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
   }
}