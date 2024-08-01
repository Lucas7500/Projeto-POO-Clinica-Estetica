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

class test_Pacote {
	private static Cliente c1;
	private static Pacote pacote1,pacote2,pacote3,pacote4;
	private static Profissional p1,p2;
	private static Clinica clinica;
	private static Sessao s1,s2,s3,s4;
	
	@BeforeAll
	static void inicializa() {
		c1 = new Cliente("Luiza Souza", "44444444444", "62955555555",'F');
		
		clinica = new Clinica("Shopping Cerrado");
		
		p1 = new Profissional("Joana Mendes", "11111111111", "6298888888", 'F');
		p2 = new Profissional("Luana Paula", "22222222222", "62966666666", 'N');
		
		pacote1 = new Pacote(TipoPacote.COMUM);
		pacote2 = new Pacote(TipoPacote.VIP);
		pacote3 = new Pacote(TipoPacote.PREMIUM);
		pacote4 = new Pacote(TipoPacote.UNICO);
		
		LocalDateTime atend = LocalDateTime.of(2024, 3, 15, 14, 00);
		s1 = new Sessao(atend, Pagamento.EFETUADO,p1,c1,clinica);
		
		atend = LocalDateTime.of(2024, 5, 20, 12, 00);
		s2 = new Sessao(atend, Pagamento.SEM_COBRANCA,p1,c1,clinica);
		
		atend = LocalDateTime.of(2024, 5, 20, 13, 00);
		s3 = new Sessao(atend, Pagamento.PENDENTE,p2,c1,clinica);
		
		atend = LocalDateTime.of(2024, 7, 10, 17, 00);
		s4 = new Sessao(atend, Pagamento.EFETUADO,p2,c1,clinica);
	
	}	
	
	@Test
	void test1() {
		assertEquals(4, pacote1.getqntd(),"Quantidade1 de sessões errada.");
		assertEquals(180, pacote1.getValorUnitario(),"Valor1 incorreto");
		assertEquals(TipoPacote.COMUM,pacote1.getTipoPacote(),"Tipo1 pacote incorreto");
		
		assertEquals(6, pacote2.getqntd(),"Quantidade2 de sessões errada.");
		assertEquals(150, pacote2.getValorUnitario(),"Valor2 incorreto");
		assertEquals(TipoPacote.VIP,pacote2.getTipoPacote(),"Tipo2 pacote incorreto");

		assertEquals(10, pacote3.getqntd(),"Quantidade3 de sessões errada.");
		assertEquals(130, pacote3.getValorUnitario(),"Valor3 incorreto");
		assertEquals(TipoPacote.PREMIUM,pacote3.getTipoPacote(),"Tipo3 pacote incorreto");

		assertEquals(1, pacote4.getqntd(),"Quantidade4 de sessões errada.");
		assertEquals(200, pacote4.getValorUnitario(),"Valor4 incorreto");
		assertEquals(TipoPacote.UNICO,pacote4.getTipoPacote(),"Tipo4 pacote incorreto");

	}
	
	@Test
	void test2(){
		assertEquals(720,pacote1.valorPacote(),"Valor Pacote1 incorreto.");
		assertEquals(900,pacote2.valorPacote(),"Valor Pacote2 incorreto.");
		assertEquals(1300,pacote3.valorPacote(),"Valor Pacote3 incorreto.");
		assertEquals(200,pacote4.valorPacote(),"Valor Pacote4 incorreto.");
		
	}
	
	@Test
	void test3() {
		pacote4.addSessao(s2);
		List<Sessao> esperado = Arrays.asList(s2);
		assertEquals(esperado,pacote4.getSessoes(),"Lista de sessões adicionada incorretamente");
		assertEquals(Pagamento.SEM_COBRANCA, pacote4.getSessoes().get(0).getPagamento(),"Pagamento incorreto");
		assertEquals(pacote4.getValorUnitario(), s2.getValor(),"Valor da sessão passada incorretamente");
		
		
		pacote4.addSessao(s1);
		assertEquals(esperado,pacote4.getSessoes(),"Lista de sessões adicionada incorretamente");
		
		
		assertEquals(Pagamento.SEM_COBRANCA, s2.getPagamento(),"Pagamento incorreto");
		pacote1.addSessao(s2);
		assertEquals(Pagamento.PENDENTE, s2.getPagamento(),"Pagamento incorreto");
		assertEquals(Pagamento.PENDENTE, pacote1.getSessoes().get(0).getPagamento());
		assertEquals(pacote1.getValorUnitario(), s2.getValor(),"Valor da sessão passada incorretamente");

		
	}
}
