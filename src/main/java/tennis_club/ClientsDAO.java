package tennis_club;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class ClientsDAO {

	private JdbcTemplate jdbcTemplate;

	public ClientsDAO(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public List<Client> list() {
		String sql = "SELECT * FROM KLIENCI";

		List<Client> clientsList = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Client.class));

		return clientsList;
	}

	public void save(Client client) {

	}

	public Client get(Client client) {
		return null;
	}

	public void update(Client client) {

	}

	public void delete(Client client) {

	}
}
