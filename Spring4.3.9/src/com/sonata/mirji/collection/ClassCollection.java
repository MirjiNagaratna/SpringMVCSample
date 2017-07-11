package com.sonata.mirji.collection;

import java.util.List;
import java.util.Map;
import java.util.Properties;

public class ClassCollection {
	
	public List<String> studentIdList;
	public Map<String, String> idNameMap;
	public Properties studentProp;
	public List<String> getStudentIdList() {
		System.out.println("getStudentIdList"+studentIdList);
		return studentIdList;
	}
	public void setStudentIdList(List<String> studentIdList) {
		System.out.println("setStudentIdList"+studentIdList);
		this.studentIdList = studentIdList;
	}
	public Map<String, String> getIdNameMap() {
		System.out.println("getIdNameMap"+idNameMap);
		return idNameMap;
	}
	public void setIdNameMap(Map<String, String> idNameMap) {
		System.out.println("setIdNameMap"+idNameMap);
		this.idNameMap = idNameMap;
	}
	public Properties getStudentProp() {
		System.out.println("getStudentProp"+studentProp);
		return studentProp;
	}
	public void setStudentProp(Properties studentProp) {
		System.out.println("setStudentProp"+studentProp);
		this.studentProp = studentProp;
	}

}
