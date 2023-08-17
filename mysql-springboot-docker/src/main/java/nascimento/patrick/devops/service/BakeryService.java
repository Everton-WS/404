package nascimento.patrick.devops.service;

import java.util.List;

import nascimento.patrick.devops.model.Bakery;

public interface BakeryService {
	
	List<Bakery> getAllBakeries();

	void insertBakery(Bakery bakery);
}