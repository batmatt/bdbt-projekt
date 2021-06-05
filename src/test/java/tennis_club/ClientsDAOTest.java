package tennis_club;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

class ClientsDAOTest {

	private ClientsDAO dao;

	@BeforeEach
	void setUp() throws Exception {
		DriverManagerDataSource datasource = new DriverManagerDataSource();
		datasource.setUrl("jdbc:oracle:thin:@ora3.elka.pw.edu.pl:1521:ora3inf");
		datasource.setUsername("mwinnick");
		datasource.setPassword("mwinnick");
		datasource.setDriverClassName("oracle.jdbc.OracleDriver");
		
		final JdbcTemplate template = new JdbcTemplate(datasource);
		dao = new ClientsDAO(template);
	}

	@Test
	void testList() {
		List<Client> clients = dao.list();
		assertTrue(!clients.isEmpty());
	}

	@Test
	void testSave() {
		Client client = new Client(0, "Karol", "Karolak", "213742002", "aktywny", "4", 1);
		dao.save(client);
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
