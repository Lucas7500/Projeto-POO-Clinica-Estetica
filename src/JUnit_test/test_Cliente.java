package JUnit_test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.clinicaestetica.Models.Cliente;
import com.clinicaestetica.Models.Clinica;
import com.clinicaestetica.Models.Pacote;
import com.clinicaestetica.Models.Profissional;
import com.clinicaestetica.Models.Sessao;
import com.clinicaestetica.Models.Enums.Pagamento;
import com.clinicaestetica.Models.Enums.TipoPacote;

class test_Cliente {

	private static Cliente c1,c2,c3;
	private static Pacote pacote1,pacote2;
	private static Profissional p1,p2;
	private static Clinica clinica;
	private static Sessao s1,s2,s3,s4;
	
	@BeforeAll
	static void inicializa() {
		c1 = new Cliente("Luiza Souza", 44444444444L, 62955555555L,'F');
		c2 = new Cliente("Lucas Moura", 66666666666L, 62911111111L,'N');
		c3 = new Cliente("Paulo Freire", 77777777777L, 62933333333L,'M');
		clinica = new Clinica("Shopping Cerrado");
		p1 = new Profissional("Joana Mendes", 11111111111L, 6298888888L, 'F');
		p2 = new Profissional("Luana Paula", 22222222222L, 62966666666L, 'N');
		pacote1 = new Pacote(TipoPacote.COMUM);
		pacote2 = new Pacote(TipoPacote.UNICO);
		
		LocalDateTime atend = LocalDateTime.of(2024, 3, 15, 14, 00);
		s1 = new Sessao(atend, Pagamento.EFETUADO,p1,c1,clinica);
		
		atend = LocalDateTime.of(2024, 5, 20, 12, 00);
		s2 = new Sessao(atend, Pagamento.PENDENTE,p1,c1,clinica);
		
		atend = LocalDateTime.of(2024, 5, 20, 13, 00);
		s3 = new Sessao(atend, Pagamento.PENDENTE,p2,c1,clinica);
		
		atend = LocalDateTime.of(2024, 7, 10, 17, 00);
		s4 = new Sessao(atend, Pagamento.EFETUADO,p2,c1,clinica);
	}
	
	
	@Test
	void test1() {
		assertEquals(1,c1.getId(),"Id1 gerado incorretamente");
		assertEquals(2,c2.getId(),"Id2 gerado incorretamente");
		assertEquals(3,c3.getId(),"Id3 gerado incorretamente");
	}

	@Test
	void test2() {
		double inicial = c1.getContabSessoes();
		c1.contabilidade(180.00);
		assertEquals(inicial+180, c1.getContabSessoes(),"Contabilidade feita incorretamente.");

	}
	
	@Test
	void test3() {
		c1.addPacote(pacote2);
		c1.addPacote(pacote1);
		List<Pacote> esperado = Arrays.asList(pacote2,pacote1);
		assertEquals(esperado,c1.getPacotes(),"Adição de pacotes incorreta.");
	}
	
	@Test
	void test4() {
		c1.addPacote(pacote1);
		c1.addSessaPacote(s1);
		c1.addSessaPacote(s2);
		c1.addSessaPacote(s3);
		c1.addSessaPacote(s4);
		
		List<Sessao> esperado = Arrays.asList(s1,s2,s3,s4);
		Pacote pacotetest = c1.getPacotes().get(c1.getPacotes().size() - 1);
		assertEquals(esperado,pacotetest.getSessoes(),"Sessões adicionadas incorretamente");
		
	}
}
