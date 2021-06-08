package tennis_club;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

class PlacowkiDAOTest {

	private PlacowkiDAO dao;

	@BeforeEach
	void setUp() throws Exception {
		DriverManagerDataSource datasource = new DriverManagerDataSource();
		datasource.setUrl("jdbc:oracle:thin:@ora3.elka.pw.edu.pl:1521:ora3inf");
		datasource.setUsername("mwinnick");
		datasource.setPassword("mwinnick");
		datasource.setDriverClassName("oracle.jdbc.OracleDriver");
		
		final JdbcTemplate template = new JdbcTemplate(datasource);
		dao = new PlacowkiDAO(template);
	}

	@Test
	void testListIsNotEmpty() {
		List<Placowka> placowki = dao.list();
		assertTrue(!placowki.isEmpty());
	}

	@Test
	void testSave() {
		Placowka placowka = new Placowka(5, "Promyk", "213742002", 5, 1);
		dao.save(placowka);
	}

	@Test
	void testGet() {
		fail("Not yet implemented");
	}

	@Test
	void testUpdate() {
		fail("Not yet implemented");
	}

	@Test
	void testDelete() {
		fail("Not yet implemented");
	}

}
