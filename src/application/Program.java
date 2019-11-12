package application;

import java.util.Date;
import java.util.List;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
				
		SellerDao sellerDao = DaoFactory.createSellerDao();
		
		Seller seller = sellerDao.findById(3);
		
		System.out.println("=== Teste 1 - Seller findById ===");
		System.out.println(seller);
		
		System.out.println("=== Teste 2 - Seller findByDepartment ===");
		Department department = new Department(2, null);
		List<Seller> list = sellerDao.findByDepartment(department);
		for (Seller obj : list) {
			System.out.println(obj);
		}
		
		System.out.println("=== Teste 3 - Seller findAll ===");
		List<Seller> list2 = sellerDao.findAll();
		for (Seller obj : list2) {
			System.out.println(obj);
		}
		
		System.out.println("=== Teste 4 - Seller insert ===");
		Seller newSeller = new Seller(null, "Pedro Silva", "pedro@gmail.com", new Date(), 3300.0, department);
		sellerDao.insert(newSeller);
		System.out.println("Inserted! new Id: "+ newSeller.getId());
		
		System.out.println("=== Teste 5 - Seller update ===");
		Seller alterSeller = sellerDao.findById(1);
		alterSeller.setName("Joana Dark");
		sellerDao.update(alterSeller);
		System.out.println("Seller atualizado! ");
	}

}
