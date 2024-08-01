package JUnit_test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.clinicaestetica.Models.Profissional;

class test_Profissional {
	private static Profissional p1,p2,p3 ;
	
	@BeforeAll
	static void inicializa() {
		 p1 = new Profissional("Joana Mendes", "11111111111", "6298888888", 'F');
		 p2 = new Profissional("Luana Paula", "22222222222", "62966666666", 'N');
		 p3 = new Profissional("Fernando Souza", "33333333333", "62933333333", 'M');

	}
	@Test
	void test1() {
		assertEquals(1,p1.getId(),"Id gerado incorretamente");
		assertEquals(2,p2.getId(),"Id gerado incorretamente");
		assertEquals(3,p3.getId(),"Id gerado incorretamente");
	}
	
	@Test
	void test2() {
		double inicial = p1.getContabAtendimentos();
		p1.contabilidade(75.00);
		assertEquals(inicial+75, p1.getContabAtendimentos(),"Contabilidade feita incorretamente.");
		
	}

}
