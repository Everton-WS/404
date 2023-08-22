package nascimento.patrick.devops.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import nascimento.patrick.devops.model.Bakery;

@Repository
public class BakeryDaoImpl extends JdbcDaoSupport implements BakeryDao {

	@Autowired
	DataSource dataSource;

	@PostConstruct
	private void initialize() {
		setDataSource(dataSource);
	}

	@Override
	public List<Bakery> getAllBakeries() {
		String sql = "SELECT * FROM Padarias";
		List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);

		List<Bakery> result = new ArrayList<>();
		for (Map<String, Object> row : rows) {
			Bakery bakery = new Bakery();
			bakery.setNome((String) row.get("Nome"));
			bakery.setNotaBolinho((Integer) row.get("NotaBolinho"));
			result.add(bakery);
		}

		return result;
	}

	@Override
	public void insertBakery(Bakery bakery) {
		String sql = "INSERT INTO Padarias " + "(Nome, NotaBolinho) VALUES (?, ?)";
		getJdbcTemplate().update(sql, new Object[] { bakery.getNome(), bakery.getNotaBolinho() });

	}
}