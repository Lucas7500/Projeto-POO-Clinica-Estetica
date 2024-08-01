package JUnit_test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.clinicaestetica.Models.Cliente;
import com.clinicaestetica.Models.Clinica;
import com.clinicaestetica.Models.Pacote;
import com.clinicaestetica.Models.Profissional;
import com.clinicaestetica.Models.Sessao;
import com.clinicaestetica.Models.Enums.Pagamento;
import com.clinicaestetica.Models.Enums.Status;
import com.clinicaestetica.Models.Enums.TipoPacote;

class test_Sessao {

	private static Cliente c1;
	private static Pacote pacote1,pacote2;
	private static Profissional p1,p2;
	private static Clinica clinica;
	private static Sessao s1,s2,s3,s4;
	
	@BeforeAll
	static void inicializa() {
		c1 = new Cliente("Luiza Souza", 44444444444L, 62955555555L,'F');
		
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
	
	//test alterarStatus
	@Test
	void test1() {
		s1.alterarStatus(Status.CONCLUIDO, null);
		assertEquals(Status.CONCLUIDO, s1.getStatus(),"ALteração de Status incorreta.");
		assertEquals(s1.getValor()*0.7, p1.getContabAtendimentos(),"Passagem de valor para profissional incorreta.");
		assertEquals(s1.getValor(), clinica.getcontabilidadeClinica(),"Passagem de valor para clinica incorreta.");;
		
		s2.alterarStatus(Status.REMARCADO, LocalDateTime.of(2024, 8, 01, 15, 00));
		assertEquals(LocalDateTime.of(2024, 8, 01, 15, 00), s2.getData(),"Data não foi alterada.");
		assertEquals(Status.AGENDADO, s2.getStatus(),"Status definido incorretamente.");
		
		s3.alterarStatus(Status.CANCELADO, null);
		assertEquals(Status.CANCELADO,s3.getStatus(),"Status definido incorretamente.");
		assertEquals(null, s3.getData(),"Data definida incorretamente.");
	}
	
	@Test
	void test2() {
		s1.alterarPagamento(Pagamento.PENDENTE);
		assertEquals(Pagamento.PENDENTE, s1.getPagamento(),"Pagamento alterado incorretamente.");
		
		s2.alterarPagamento(Pagamento.EFETUADO);
		assertEquals(Pagamento.EFETUADO, s2.getPagamento(),"Pagamento alterado incorretamente.");
		
		s3.alterarPagamento(Pagamento.SEM_COBRANCA);
		assertEquals(Pagamento.SEM_COBRANCA, s3.getPagamento(),"Pagamento alterado incorretamente.");
		
	}
	
	@Test
	void test3() {
		s1.addObservacao("OBSERVAÇÃO TESTE!! 123!@#$%");
		assertEquals("OBSERVAÇÃO TESTE!! 123!@#$%",s1.getObservacao(),"Observação alterada incorretamente.");
	
	}
	
	
			
}
