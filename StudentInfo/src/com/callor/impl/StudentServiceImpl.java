package com.callor.impl;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.callor.service.StudentService;
import com.callor.vo.StudentVO;

public class StudentServiceImpl implements StudentService {

	protected final Scanner scan;
	protected final List<StudentVO> stList;
	protected String fileName;

	public StudentServiceImpl() {

		scan = new Scanner(System.in);
		stList = new ArrayList<>();
		fileName = "src/controller/student.txt";
	}

	@Override
	public void inputStudent() {
		while (true) {
			System.out.print("학번 입력(QUIT:종료) >> ");
			String stNum = scan.nextLine();
			if (stNum.equals("QUIT")) {
				break;
			}
			System.out.print("이름 입력 >> ");
			String stName = scan.nextLine();
			System.out.print("학과 입력 >> ");
			String stDept = scan.nextLine();
			System.out.print("학년 입력>> ");
			String stGrade = scan.nextLine();
			System.out.print("전화번호 입력>> ");
			String stTel = scan.nextLine();

			// VO 생성
			StudentVO stVO = new StudentVO();
			// VO에 Setting
			stVO.setStNum(stNum);
			stVO.setStName(stName);
			stVO.setStDept(stDept);
			stVO.setStGrade(stGrade);
			stVO.setStTel(stTel);

			// scList.add()
			stList.add(stVO);

		}
	}

	public void saveStudent() {
		FileWriter file = null;
		PrintWriter out = null;

		try {
			file = new FileWriter(fileName);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		out = new PrintWriter(file);
		for (StudentVO stVO : stList) {
			out.print(stVO.getStNum() + ":");
			out.print(stVO.getStName() + ":");
			out.print(stVO.getStDept() + ":");
			out.print(stVO.getStGrade() + ":");
			out.print(stVO.getStTel() + ":");
		}
		out.flush();
		out.close();
		try {
			file.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void printStudent() {
		FileInputStream is = null;
		Scanner scan = null;
		
		try {
			is = new FileInputStream(fileName);
		} catch (FileNotFoundException e) {
			System.out.println(fileName + "파일이 없습니다.");
			return;
		}
		scan = new Scanner(is);
		
		while(scan.hasNext()) {
			String line = scan.nextLine();
			String[] stVO = line.split(":");
			
			StudentVO tVO = StudentVO.builder()
							.stNum(stVO[1])
							.stName(stVO[2])
							.stDept(stVO[3])
							.stGrade(stVO[4])
							.stTel(stVO[5])
							.build();
			stList.add(tVO);
		}
		try {
			is.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	

}
