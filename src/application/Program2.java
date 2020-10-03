package application;

import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		
		System.out.println("=== Test 1: department findById(3) ===");
		Department dep = departmentDao.findById(3);
		System.out.println(dep);

		System.out.println("\n=== Test 3: department findAll() ===");
		List<Department>  list = departmentDao.findAll();
		list.forEach(System.out::println);

		System.out.println("\n=== Test 4: department insert ===");
		Department newDep = new Department(null, "Music");
		departmentDao.insert(newDep);
		System.out.println("New department id: " + newDep.getId());
		
		System.out.println("\n=== Test 5: department update ===");
		Department upDepartment = new Department(1, "Food");
		departmentDao.update(upDepartment);
		System.out.println("Updated successfully!");
		
		
		System.out.println("\n=== Test 6: department delete ===");
		departmentDao.deleteById(6);
		System.out.println("Department deleted!");
		
		sc.close();

	}

}
