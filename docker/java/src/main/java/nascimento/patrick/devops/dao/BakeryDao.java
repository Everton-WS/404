package nascimento.patrick.devops.dao;

import java.util.List;

import nascimento.patrick.devops.model.Bakery;

public interface BakeryDao {
	List<Bakery> getAllBakeries();

	void insertBakery(Bakery bakery);
}