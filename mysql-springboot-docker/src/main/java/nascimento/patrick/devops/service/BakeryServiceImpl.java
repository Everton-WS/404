package nascimento.patrick.devops.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nascimento.patrick.devops.dao.BakeryDao;
import nascimento.patrick.devops.model.Bakery;

@Service
public class BakeryServiceImpl implements BakeryService {

	@Autowired
	BakeryDao bakeryDao;



	@Override
	public List<Bakery> getAllBakeries() {
		List<Bakery> bakeries = bakeryDao.getAllBakeries();
		return bakeries;
	}

	@Override
	public void insertBakery(Bakery bakery) {
		bakeryDao.insertBakery(bakery);
		
	}

}