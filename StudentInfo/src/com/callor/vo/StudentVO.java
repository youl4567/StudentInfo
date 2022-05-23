package com.callor.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StudentVO {
	
	private String stNum;
	private String stName;
	private String stDept;
	private String stGrade;
	private String stTel;
	
	public String toString() {
		
		String result = "";
		// 전체 10자리의 공간을 만들고 이름위치를 확보
		result += String.format("%-10s\t", stNum);
		result += String.format("%-10s\t", stName);
		result += String.format("%-10s\t", stDept);
		result += String.format("%-10s\t", stGrade);
		result += String.format("%-10s\t", stTel);
		
		return result;
	}

}
