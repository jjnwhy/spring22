package com.gura.spring01.file.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.gura.spring01.file.dto.FileDto;

/*
 *  [ 파일 업로드 처리 하는 방법 ]
 *  
 *  1. pom.xml 에  commons-io, commons-fileupload dependency 설정
 *  2. servlet-context.xml 에  CommonsMultipartResolver  bean 설정 (최대 업로드 사이즈 셋팅)
 *  3. <input type="file" name="myFile" />  에서   name 속성의 value 를
 *     MultipartFile  type 을 받을때 지역 변수명 혹은 필드명과 일치 시킨다.
 *     ex)  MultipartFile  myFile 
 */

@Controller
public class FileController {
	
	// 파일 업로드 요청 처리
	@RequestMapping("/file/upload")
   public ModelAndView upload(ModelAndView mView, 
	         MultipartFile myFile, HttpServletRequest request) {
	      
		// 원본 파일명
		String orgFileName = myFile.getOriginalFilename();
		// upload 폴더에 저장할 파일명을 직접구성한다.
		// 1234123424343xxx.jpg
		String saveFileName = System.currentTimeMillis() + orgFileName;
		// 파일의 크기
		long fileSize = myFile.getSize();
		// webapp/upload 폴더까지의 실제 경로 얻어내기
		String realPath = request.getServletContext().getRealPath("/upload");
		// upload 폴더가 존재하지 않을경우 만들기 위한 File 객체 생성
		File upload = new File(realPath);
		if (!upload.exists()) {// 만일 존재 하지 않으면
			upload.mkdir(); // 만들어준다.
		}
		try {
			// 파일을 저장할 전체 경로를 구성한다.
			String savePath = realPath + File.separator + saveFileName;
			// 임시폴더에 업로드된 파일을 원하는 파일을 저장할 경로에 전송한다.
			myFile.transferTo(new File(savePath));
			// 테스트로 저장된 경로를 콘솔에 출력하기
			System.out.println("savePath:" + savePath);
		} catch (Exception e) {
			e.printStackTrace();
		}

		mView.addObject("orgFileName", orgFileName);
		mView.addObject("saveFileName", saveFileName);
		mView.addObject("fileSize", fileSize);

		mView.setViewName("file/upload");
		return mView;
	}

	// 파일 업로드 요청 처리
	@RequestMapping("/file/upload2")
   public ModelAndView upload2(ModelAndView mView, 
	         FileDto dto, HttpServletRequest request) {
		// FileDto 객체에서 업로드된 파일의 정보를 가지고 있는 MultipartFile 객체의 참조값 얻어내기
		MultipartFile myFile = dto.getMyFile();

		// 원본 파일명
		String orgFileName = myFile.getOriginalFilename();
		// upload 폴더에 저장할 파일명을 직접구성한다.
		// 1234123424343xxx.jpg
		String saveFileName = System.currentTimeMillis() + orgFileName;
		// 파일의 크기
		long fileSize = myFile.getSize();
		// webapp/upload 폴더까지의 실제 경로 얻어내기
		String realPath = request.getServletContext().getRealPath("/upload");
		// upload 폴더가 존재하지 않을경우 만들기 위한 File 객체 생성
		File upload = new File(realPath);
		if (!upload.exists()) {// 만일 존재 하지 않으면
			upload.mkdir(); // 만들어준다.
		}
		try {
			// 파일을 저장할 전체 경로를 구성한다.
			String savePath = realPath + File.separator + saveFileName;
			// 임시폴더에 업로드된 파일을 원하는 파일을 저장할 경로에 전송한다.
			myFile.transferTo(new File(savePath));
			// 테스트로 저장된 경로를 콘솔에 출력하기
			System.out.println("savePath:" + savePath);
		} catch (Exception e) {
			e.printStackTrace();
		}

		
		mView.addObject("title",dto.getTitle())
		.addObject("orgFileName", orgFileName)
		.addObject("saveFileName", saveFileName)
		.addObject("fileSize", fileSize); // this를 리턴하기때문에 연쇄로 값 쓸 수 있다.

		mView.setViewName("file/upload2");
		return mView;
	   }
	
	// 파일 업로드 폼 요청 처리
	@RequestMapping("/file/upload_form")
	public String uploadForm() {
		
		return "file/upload_form";
	}
}
