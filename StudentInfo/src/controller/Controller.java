package controller;

import com.callor.impl.StudentServiceImpl;
import com.callor.service.StudentService;

public class Controller {
	public static void main(String[] args) {
		StudentService stV1 = new StudentServiceImpl();

		stV1.inputStudent();
		stV1.saveStudent();
	}


}
