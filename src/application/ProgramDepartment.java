package application;

import java.util.List;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class ProgramDepartment {

	public static void main(String[] args) {

		DepartmentDao departmentDao = DaoFactory.createDepartmentDao(); 
		System.out.println("=== ListAll Department ===");
		List<Department> listAll = departmentDao.findAll();
		for (Department department : listAll) {
			System.out.println(department);
		}
		
		System.out.println("\r\n === ListById Department ===");
		Department department = departmentDao.findById(22);
		if (department != null) {
			System.out.println(department);
		}else {
			System.out.println("Department not exist!");
		}

		System.out.println("\r\n === Insert Department ===");
		Department obj = new Department(null, "Moveis");
		departmentDao.insert(obj);
		System.out.println("Department inserido. Id: "+obj.getId());
		

		System.out.println("\r\n === Delete Department ===");
		departmentDao.delete(6);
		System.out.println("Department deletado com sucesso");
		
		

	}

}
