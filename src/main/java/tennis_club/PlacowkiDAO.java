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
		insert.withTableName("placowki").usingColumns("nazwaPlacowki", "nrTelefonu", "idAdresu", "idKlubu");

		placowka.setIdKlubu(1);

		BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(placowka);
		insert.execute(param);
	}

	public Placowka get(int idPlacowki) {
		Object[] args = { idPlacowki };
		String sql = "SELECT * FROM placowki WHERE idPlacowki = " + args[0];
		Placowka placowka = jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(Placowka.class));

		return placowka;
	}

	public void update(Placowka placowka) {
		String sql = "UPDATE placowki SET nazwaPlacowki=:nazwaPlacowki, nrTelefonu=:nrTelefonu, idAdresu=:idAdresu, idKlubu=:idKlubu WHERE idPlacowki=:idPlacowki";
		BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(placowka);
		NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);

		template.update(sql, param);

	}

	public void delete(int idPlacowki) {
		String sql = "DELETE FROM placowki WHERE idPlacowki = ?";
		jdbcTemplate.update(sql, idPlacowki);
	}
}
