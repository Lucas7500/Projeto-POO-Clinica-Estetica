import java.util.Scanner;

import com.clinicaestetica.Models.Cliente;

public class Main {

	public static void main(String[] args) {
		// Cadastrar um cliente
		Cliente cliente = new Cliente();
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Qual o nome completo do cliente? ");
		cliente.setNomeCompleto(sc.nextLine());
		
		System.out.print("Qual o cpf do cliente? ");
		cliente.setCpf(sc.nextLine());
		
		System.out.print("Qual o gênero do cliente? (M/F) ");
		cliente.setGenero(sc.nextLine().charAt(0));
		
		System.out.print("Qual o telefone do cliente? ");
		cliente.setTelefone(sc.nextLine());
		
		System.out.print(cliente.toString());

		sc.close();
		// Cadastrar uma clínica
		// Cadastrar um profissional
		// Realizar um Atendimento
	}

}
