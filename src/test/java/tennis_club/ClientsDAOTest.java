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
		Client client = new Client.Builder().withImie("Bart³omiej").withNazwisko("Koala").withNrTelefonu("485738222")
				.withNrSzafki("482").withStatusKlienta("aktywny").withIdKlubu(1).build();
		dao.save(client);
	}

	@Test
	void testGet() {
		int id = 2;
		Client client = dao.get(id);
		
		assertNotNull(client);
	}

	@Test
	void testUpdate() {
		Client client = new Client.Builder().withImie("Bart³omiej").withNazwisko("Koala").withNrTelefonu("485738222")
				.withNrSzafki("482").withStatusKlienta("zawieszony").withIdKlubu(1).build();
		
		dao.update(client);
	}

	@Test
	void testDelete() {
		int id = 15;
		dao.delete(id);
	}

}
