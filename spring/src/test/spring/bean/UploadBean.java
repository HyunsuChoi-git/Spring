package test.spring.bean;

import java.io.File;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@Controller
public class UploadBean {
	@RequestMapping("uploadForm.do")
	public String uploadForm() {
		System.out.println("test");
		
		return "spring03/uploadForm";
	}
	
	@RequestMapping("Pro.do")
	public String uploadPro(String writer, MultipartHttpServletRequest request, Model md) {
		
		System.out.println("writer :" + writer);
		MultipartFile mf = null;
		String newName = null;
		try {
			// #1. D드라이브에 저장
			// 1. 파일정보 담기
			//mf = request.getFile("img");
			// 2. 저장 경로 + 오리지널 파일명
			//File copyFile = new File("d://save//"+mf.getOriginalFilename());
			// 3. 저장위치에 저장
			//mf.transferTo(copyFile);
			
			//////////////////////////////////////////////////
			
			// # 파일이름 중복처리  :  새로운 파일명 + 확장자 만들기
			//오리지널파일명+날짜 (개발자마다다름)
			
			//0. 파일 정보 담기
			mf = request.getFile("img");
			
			//1. 오리지널 파일명
			String orgName = mf.getOriginalFilename();
			//2. 파일명만 추출
			String imgName = orgName.substring(0, orgName.lastIndexOf('.'));
			//3. 확장자 추출
			String ext = orgName.substring(orgName.lastIndexOf('.'));
			//4. 날짜 받아오기
			long date = System.currentTimeMillis();
			//5. 최종 파일이름
			newName = imgName + date + ext;
			
			System.out.println(newName);
			
			
			// # 서버에 저장
			// 2. 저장경로 + 오리지널 파일명
			String path = request.getRealPath("save"); // 서버상 save폴더 경로 가져오기
			String imgPath = path+ "\\" + newName;
			File copyFile = new File(imgPath);
			//3. 저장위치에 저장
			mf.transferTo(copyFile);
			
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		md.addAttribute("newName", newName);
		
		return "spring03/uploadPro";
	}
	
	
	@RequestMapping("pract")
	public String upload(String writer, Model model, MultipartHttpServletRequest request) {
		
		MultipartFile mf = null;
		try {
			//파일 정보 담기
			mf = request.getFile("img");
			
			//파일명 중복처리
			//1. 오리지널 파일명
			String orgName = mf.getOriginalFilename();
			//2. 확장자를 뺀 파일명
			String fileName = orgName.substring(0, orgName.lastIndexOf("."));
			//3. 확장자명
			String ext = orgName.substring(orgName.lastIndexOf("."));
			//4. 날짜시간
			long day = System.currentTimeMillis();
			//5. 새파일명
			String newName = fileName+day+ext;
			
			//저장
			//1. 저장경로
			String path = request.getRealPath("save");
			//2. 저장경로로 파일저장
			File f = new File(path+"//"+newName);	
			//3. mf를 f 경로로 추가
			mf.transferTo(f);
			
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return "spring03/uploadPro";
	}
	
	@RequestMapping("moremore")
	public String upup(Model model, MultipartHttpServletRequest reqeust) {
		
		MultipartFile mf = null;
		
		try{
			// 1. 파일 정보 담기
			mf = reqeust.getFile("img");
			
			// 파일이름중복처리
			
			//1. 파일전체이름 담기
			String orgName = mf.getOriginalFilename();
			//2. 확장자명 뺀 이름
			String imgName = orgName.substring(0, orgName.lastIndexOf("."));
			//3. 확장자명
			String ext = orgName.substring(orgName.lastIndexOf("."));
			//4. 오늘날짜
			long date = System.currentTimeMillis();
			
			String newName = date+imgName+orgName;
			
			//파일 경로
			
			String path = reqeust.getRealPath("save");
			File f = new File(path+"//"+newName);
			mf.transferTo(f);
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		return "spring03/uploadPro";
	}
	
	@RequestMapping("uploadPro.do")
	public String upupup(Model model, MultipartHttpServletRequest request) {
		
		MultipartFile mf = null;
		String newName = null;
		try {
			mf = request.getFile("img");
			
			//중복처리
			String fullName = mf.getOriginalFilename();
			String imgName = fullName.substring(0, fullName.indexOf("."));
			String etx = fullName.substring(fullName.indexOf("."));
			long date = System.currentTimeMillis();
			newName = imgName+date+etx;
			
			//저장
			String path = request.getRealPath("save");
			File f = new File(path+"//"+newName);
			mf.transferTo(f);
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		model.addAttribute("newName",newName);
		
		return "spring03/uploadPro";
	}
	
	
	
	
}
