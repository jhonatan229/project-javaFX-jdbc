package model.service;

import java.util.ArrayList;
import java.util.List;

import model.entities.Department;

public class DepartmentService {

	public List<Department> findAll(){
		List<Department> list = new ArrayList<>();
		list.add(new Department(1, "computer"));
		list.add(new Department(2, "office"));
		list.add(new Department(3, "game"));
		
		return list;
	}
}
