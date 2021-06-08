package tennis_club;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

@Repository
public class PlacowkiDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	
	public PlacowkiDAO(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public List<Placowka> list() {
		String sql = "SELECT * FROM PLACOWKI";
		List<Placowka> placowki = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Placowka.class));

		return placowki;
	}

	public void save(Placowka placowka) {
		SimpleJdbcInsert insert = new SimpleJdbcInsert(jdbcTemplate);
		insert.withTableName("placowki").usingColumns("idPlacowki", "nazwaPlacowki", "nrTelefonu", "idAdresu", "idKlubu");
		
		BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(placowka);
		insert.execute(param);
	}

	public Placowka get(Placowka placowka) {
		return null;
	}

	public void update(Placowka placowka) {

	}

	public void delete(Placowka placowka) {

	}
}
