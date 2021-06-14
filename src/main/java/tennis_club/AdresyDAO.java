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
public class AdresyDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public AdresyDAO(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public List<Adres> list() {
		String sql = "SELECT * FROM adresy";
		List<Adres> adresy = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Adres.class));

		return adresy;
	}

	public void save(Adres adres) {
		SimpleJdbcInsert insert = new SimpleJdbcInsert(jdbcTemplate);
		insert.withTableName("adresy").usingColumns("ulica", "nrDzialki", "miejscowosc", "kodPocztowy", "nrLokalu");

		BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(adres);
		insert.execute(param);
	}

	public Adres get(int idAdresu) {
		Object[] args = { idAdresu };
		String sql = "SELECT * FROM adresy WHERE idAdresu = " + args[0];
		Adres adres = jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(Adres.class));

		return adres;
	}

	public void update(Adres adres) {
		String sql = "UPDATE adresy SET ulica=:ulica, nrDzialki=:nrDzialki, miejscowosc=:miejscowosc, kodPocztowy=:kodPocztowy, nrLokalu=:nrLokalu WHERE idAdresu=:idAdresu";
		BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(adres);
		NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);

		template.update(sql, param);

	}

	public void delete(int idAdresu) {
		String sql = "DELETE FROM adresy WHERE idAdresu = ?";
		jdbcTemplate.update(sql, idAdresu);
	}
}
