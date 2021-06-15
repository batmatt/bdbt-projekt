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
public class KortyDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public KortyDAO(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public List<Kort> list() {
		String sql = "SELECT * FROM korty";
		List<Kort> korty = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Kort.class));

		return korty;
	}

	public void save(Kort kort) {
		SimpleJdbcInsert insert = new SimpleJdbcInsert(jdbcTemplate);
		insert.withTableName("korty").usingColumns("nawierzchnia", "statusKortu", "idPlacowki");

		BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(kort);
		insert.execute(param);
	}

	public Kort get(int idKortu) {
		Object[] args = { idKortu };
		String sql = "SELECT * FROM korty WHERE idKortu = " + args[0];
		Kort kort = jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(Kort.class));

		return kort;
	}

	public void update(Kort kort) {
		String sql = "UPDATE korty SET nawierzchnia=:nawierzchnia, statusKortu=:statusKortu, idPlacowki=:idPlacowki WHERE idKortu=:idKortu";
		BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(kort);
		NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);

		template.update(sql, param);

	}
	
	public void reserve(int idKortu) {
		String sql = "UPDATE korty SET statusKortu = 'zarezerwowany' WHERE idKortu = ?";
		jdbcTemplate.update(sql, idKortu);
	}
	
	public void delete(int idKortu) {
		String sql = "DELETE FROM korty WHERE idKortu = ?";
		jdbcTemplate.update(sql, idKortu);
	}
}
