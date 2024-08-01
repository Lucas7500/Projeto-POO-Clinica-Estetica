package JUnit_test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.RepeatedTest;

import com.clinicaestetica.Models.Clinica;
import com.clinicaestetica.Models.Profissional;

class test_Clinica {
	private static Clinica clinica1, clinica2,clinica3;
	private static Profissional p1,p2,p3 ;
	
	@BeforeAll
	static void inicializa() {
		 clinica1 = new Clinica("Shopping Cerrado");
		 clinica2 = new Clinica("Avenida Figueira");
		 clinica3 = new Clinica("Praça Gomes");
		 p1 = new Profissional("Joana Mendes", "11111111111", "6298888888", 'F');
		 p2 = new Profissional("Luana Paula", "22222222222", "62966666666", 'N');
		 p3 = new Profissional("Fernando Souza", "33333333333", "62933333333", 'M');

	}
	

	@Test
	void test1() {
		clinica1.addProfissional(p1);
		clinica1.addProfissional(p2);
		clinica1.addProfissional(p3);
		List<Profissional> esperado = Arrays.asList(p1,p2,p3);
		assertEquals(esperado,clinica1.getProfissionais(),"Lista1 de profissionais não corresponde com o esperado.\n");
		
		
		clinica2.addProfissional(p1);
		clinica2.addProfissional(p3);
		List<Profissional> esperado2 = Arrays.asList(p1,p3);
		assertEquals(esperado2,clinica2.getProfissionais(),"Lista2 de profissionais não corresponde com o esperado.\n");
		
		clinica3.addProfissional(p2);
		clinica3.addProfissional(p3);
		List<Profissional> esperado3 = Arrays.asList(p2,p3);
		assertEquals(esperado3,clinica3.getProfissionais(),"Lista2 de profissionais não corresponde com o esperado.\n");
		
	}
	
	
	@RepeatedTest(5)
	void test2() {
		double inicial = clinica1.getcontabilidadeClinica();
		clinica1.contabilidade(150.00);
		assertEquals(inicial+150, clinica1.getcontabilidadeClinica(),"Contabilidade feita incorretamente.");
		
	}
}
