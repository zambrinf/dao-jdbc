package application;

import java.util.List;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		
		SellerDao sellerDao = DaoFactory.createSellerDao();
		
		System.out.println("=== Test 1: seller findById(3) ===");
		
		Seller seller = sellerDao.findById(3);
		
		System.out.println(seller);
		
		System.out.println("=== Test 2: seller findByDepartment(2) ===");
		
		List<Seller> list = sellerDao.findbyDepartment(2);
		
		for (Seller s : list) {
			System.out.println(s);
		}
	}

}
