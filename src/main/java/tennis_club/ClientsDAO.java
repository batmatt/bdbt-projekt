package tennis_club;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

@Repository
public class ClientsDAO {

	@Autowired
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
		SimpleJdbcInsert insert = new SimpleJdbcInsert(jdbcTemplate);
		insert.withTableName("klienci").usingColumns("imie", "nazwisko", "nrTelefonu", "nrSzafki", "statusKlienta",
				"idKlubu");

		client.setIdKlubu(1);
		BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(client);
		insert.execute(param);
	}

	public Client get(int id) {
		Object[] args = { id };
		String sql = "SELECT * FROM klienci WHERE idKlienta = " + args[0];
		Client client = jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(Client.class));

		return client;
	}

	public void update(Client client) {
		String sql = "UPDATE klienci SET imie=:imie, nazwisko=:nazwisko, nrTelefonu=:nrTelefonu, statusKlienta=:statusKlienta, nrSzafki=:nrSzafki, idKlubu=:idKlubu WHERE idKlienta=:idKlienta";
		BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(client);
		NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);

		template.update(sql, param);

	}

	public void delete(int id) {
		String sql = "DELETE FROM klienci WHERE idKlienta = ?";
		jdbcTemplate.update(sql, id);
	}
}
