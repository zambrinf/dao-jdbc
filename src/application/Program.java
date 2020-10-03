package application;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		SellerDao sellerDao = DaoFactory.createSellerDao();

		System.out.println("=== Test 1: seller findById(3) ===");

		Seller seller = sellerDao.findById(3);

		System.out.println(seller);

		System.out.println("\n=== Test 2: seller findByDepartment(2) ===");
		
		Department department = new Department(2, null);
		List<Seller> list = sellerDao.findbyDepartment(department);

		for (Seller s : list) {
			System.out.println(s);
		}

		System.out.println("\n=== Test 3: seller findAll() ===");

		list = sellerDao.findAll();

		for (Seller s : list) {
			System.out.println(s);
		}
		
		System.out.println("\n=== Test 4: seller insert ===");

		Seller newSeller = new Seller(null, "Greg", "greg@gmail.com", new Date(), 4000.0, department);
		
		sellerDao.insert(newSeller);
		
		System.out.println("Inserted: New id = " + newSeller.getId());
		
		System.out.println("\n=== Test 5: seller update ===");
		
		seller = sellerDao.findById(1);
		seller.setName("Marta Waine");
		sellerDao.update(seller);
		System.out.println("Update completed!");
		
		
		System.out.println("\n=== Test 6: seller insert ===");
		System.out.print("Enter ID to delete: ");
		Integer idDelete = sc.nextInt();
		sellerDao.deleteById(idDelete);
		System.out.print("Delete Completed!");
		sc.close();
	}

}
