import java.time.LocalDateTime;
import java.util.Scanner;

import com.clinicaestetica.Models.Cliente;
import com.clinicaestetica.Models.Clinica;
import com.clinicaestetica.Models.Pacote;
import com.clinicaestetica.Models.Profissional;
import com.clinicaestetica.Models.Sessao;
import com.clinicaestetica.Models.Enums.Pagamento;
import com.clinicaestetica.Models.Enums.TipoPacote;

public class Main {

	public static void main(String[] args) {
		
		// Cadastrar uma clínica
		Clinica clinica1 = new Clinica("Rua 32, Qd 5, Lt 20, setor balneario, Goiânia (GO)");
		Clinica clinica2 = new Clinica("Avenida Pedro Ganso, numero 210, setor Vigesio Lima, petrópolis(RJ)");
		Clinica clinica3 = new Clinica("Praça Joaquim lemes, Qd 7, Lt1, setor  Liviano,  Jataí(GO)");
		
		// Cadastrar um profissional
		//Generos:  Feminino(F) | Masculino (M) | Não-binário (N)
		Profissional  p1 = new Profissional("Alane Souza", 34898762485L, 62914365798L, 'F');
		Profissional  p2 = new Profissional("Pedro  alvaro", 51274918307L, 57952146399L, 'M');
		Profissional  p3 = new Profissional("Livinia Cardoso", 73025691860L, 62983215466L, 'N');
		Profissional  p4 = new Profissional("Frascico Lemes", 89510437251L, 11965478231L ,'M');
		Profissional  p5 = new Profissional("Vinicius Jorge", 27154890633L, 33958476588L, 'N');
		Profissional  p6 = new Profissional("Laura Marques", 66309254740L, 64985326751L, 'F');
		
		clinica1.addProfissional(p1);
		clinica1.addProfissional(p4);
		clinica1.addProfissional(p6);
		
		clinica2.addProfissional(p2);
		clinica2.addProfissional(p3);
		
		clinica3.addProfissional(p5);
		clinica3.addProfissional(p1);
		clinica3.addProfissional(p2);
	
		
		
		// Cadastrar um cliente
		Cliente cliente1 = new Cliente("Carlos Silva", 34898762485L, 62914365798L, 'M');
        Pacote pacote1 = new Pacote(TipoPacote.COMUM);
        cliente1.addPacote(pacote1);
		
		Cliente cliente2 = new Cliente("Ana Pereira", 51274918307L, 61987452367L, 'F');
		Pacote pacote2 = new Pacote(TipoPacote.PREMIUM);
		cliente2.addPacote(pacote2);
		
        Cliente cliente3 = new Cliente("João Oliveira", 73025691860L, 61978543219L, 'M');
        Pacote pacote3 = new Pacote(TipoPacote.UNICO);
		cliente3.addPacote(pacote3);
		
		
		// Realizar uma Sessão
		// LocalDateTime data, Pagamento pagamento,Profissional profissional, Cliente cliente, Clinica clinica) {
		LocalDateTime atend = LocalDateTime.of(2024, 3, 15, 14, 00);
		Sessao s1 = new Sessao(atend, Pagamento.EFETUADO,p1, cliente3, clinica1);
		cliente3.addSessaPacote(s1);
		
		atend = LocalDateTime.of(2024, 11, 8, 16, 00);
		Sessao s2 = new Sessao(atend, Pagamento.PENDENTE,p3,cliente2,clinica2);
		cliente2.addSessaPacote(s2);
		
		atend = LocalDateTime.of(2024, 3, 11, 13, 00);
		Sessao s3 = new Sessao(atend, Pagamento.EFETUADO,p5,cliente1,clinica3);
		cliente1.addSessaPacote(s3);
		
		atend = LocalDateTime.of(2024, 3, 14, 15, 00);
		Sessao s4 = new Sessao(atend,Pagamento.SEM_COBRANCA,p4,cliente1,clinica1);
		cliente1.addSessaPacote(s4);
		
		// interação
		Scanner sc = new Scanner(System.in);
		System.out.println("Qual Cliente gostaria de ler os dados? [1|2|3] ");
		int client = sc.nextInt();
		if(client == 1) {
			System.out.println(cliente1.toString());
		}else if(client == 2){
			System.out.println(cliente2.toString());
		}else if(client == 3) {
			System.out.println(cliente3.toString());
		}
		
		
		sc.close();
	}

}
