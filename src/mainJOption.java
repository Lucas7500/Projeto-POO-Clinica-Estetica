import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.clinicaestetica.Models.Cliente;
import com.clinicaestetica.Models.Clinica;
import com.clinicaestetica.Models.Pacote;
import com.clinicaestetica.Models.Profissional;
import com.clinicaestetica.Models.Enums.Pagamento;
import com.clinicaestetica.Models.Enums.TipoPacote;

public class mainJOption {

	public static void main(String[] args) {
		Object[] generos = {"Feminino", "Masculino", "Não Binario"};
		
		//Pag principal
		JFrame mainFrame = new JFrame("Clinica Estética");
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setSize(400,400);
		mainFrame.setLayout(new FlowLayout());
		
		//Botão
		JButton b1 = new JButton("Cadastrar Sessão");
		JButton b2 = new JButton("Cadastrar Pacote");
		JButton b3 = new JButton("Cadastrar Cliente");
		JButton b4 = new JButton("Cadastrar Profissional");
		JButton b5 = new JButton("Cadastrar Clínica");
		b1.addActionListener(e -> {
			//frame
			JFrame cadastro = new JFrame();
			cadastro.setSize(300, 500);
			cadastro.setLocationRelativeTo(mainFrame);
			
			//painel e layout
			JPanel panel = new JPanel();
	        panel.setLayout(new GridBagLayout());
	        GridBagConstraints gbc = new GridBagConstraints();
	        gbc.insets = new Insets(5, 5, 5, 5); 
	        gbc.anchor = GridBagConstraints.WEST; 
	        gbc.fill = GridBagConstraints.HORIZONTAL; 
	        gbc.weightx = 1; 
	        //mainFrame.add(panel);
	        // cadastro data e horario
	        JLabel dataS = new JLabel("data [dd/mm/aaaa]");
	        gbc.gridx = 0;
	        gbc.gridy = 0;
	        panel.add(dataS, gbc);
	        JTextField dataSF = new JTextField(15);
	        gbc.gridx = 1;
	        panel.add(dataSF, gbc);
	        
	        JLabel tempoS = new JLabel("Hora (HH:mm):");
	        gbc.gridx = 0;
	        gbc.gridy = 1;
	        panel.add(tempoS, gbc);

	        JTextField tempoSF = new JTextField(5);
	        gbc.gridx = 1;
	        panel.add(tempoSF, gbc);
	        
	        //pagamento
	        JLabel pagS = new JLabel("Pagamento: ");
	        gbc.gridx = 0;
	        gbc.gridy = 3;
	        panel.add(pagS, gbc);

	        JComboBox<String> pagSF = new JComboBox<>(new String[] {"EFETUADO","PENDENTE","SEM_COBRANCA"});
	        gbc.gridx = 1;
	        gbc.gridy = 3;
	        panel.add(pagSF, gbc);
	        
	        //
	        
	        cadastro.add(panel);
	        cadastro.setVisible(true);
		});
		
		mainFrame.add(b1);
		
		b2.addActionListener(e -> {
			int tipoPacote = JOptionPane.showOptionDialog(mainFrame, "Qual o Tipo de Pacote desejado?", null, JOptionPane.DEFAULT_OPTION,  JOptionPane.INFORMATION_MESSAGE, null, TipoPacote.values(), TipoPacote.UNICO);
			Pacote pacote = null;
			switch(tipoPacote) {
				case 0:
					 pacote = new Pacote(TipoPacote.COMUM);
					break;
				case 1:
					 pacote = new Pacote(TipoPacote.VIP);
					break;
				case 2:
					 pacote = new Pacote(TipoPacote.PREMIUM);
					break;
				case 3:
					 pacote = new Pacote(TipoPacote.UNICO);
					break;
			}
			JOptionPane.showMessageDialog(mainFrame, "Tipo: " + pacote.getTipoPacote() + "  -  "+ pacote.getId() +"\nSessões: " + pacote.getqntd() + "\nValor Unitário: " + pacote.getValorUnitario());
			
		});
		
		mainFrame.add(b2);
		
		
		b3.addActionListener(e -> {
			String nomeC = JOptionPane.showInputDialog("Informe o nome desse Cliente:");
			String cpfC = JOptionPane.showInputDialog("Informe o CPF desse Cliente: ");
			Long cpfCL = Long.parseLong(cpfC);
			String contatoC = JOptionPane.showInputDialog("Informe o contato desse Cliente: ");
			Long contatoCL = Long.parseLong(contatoC);
			Object generoC = JOptionPane.showInputDialog(null, "Escolha o gênero: ", "Gênero Cliente", JOptionPane.INFORMATION_MESSAGE,null,generos,generos[0]);
			char generoCC = 0;
			switch(generoC.toString()) {
				case "Feminino":
					generoCC  = 'F';
					break;
				case "Masculino":
					generoCC = 'M';
					break;
				case "Não Binario":
					generoCC = 'N';
					break;
			}
			Cliente cliente = new Cliente(nomeC, cpfCL, contatoCL, generoCC);
			JOptionPane.showMessageDialog(mainFrame, cliente.getNomeCompleto() + " - "+ cliente.getGenero() + "\n CPF:" + cliente.getCpf() + "\n Contato:" + cliente.getContato(), "Cliente Cadastrado!", JOptionPane.PLAIN_MESSAGE );
			
		});
		
		mainFrame.add(b3);
		
		b4.addActionListener(e -> {
			String nomeP = JOptionPane.showInputDialog(mainFrame,"Informe o nome desse profissional: ");
			String cpfP = JOptionPane.showInputDialog(mainFrame,"Informe o CPF desse profissional: ");
			Long cpfPL = Long.parseLong(cpfP);
			String contatoP = JOptionPane.showInputDialog(mainFrame,"Informe o contato desse profissional: ");
			Long contatoPL = Long.parseLong(contatoP);
			Object generoP = JOptionPane.showInputDialog(mainFrame, "Escolha o gênero: ", "Gênero Profissional", JOptionPane.INFORMATION_MESSAGE,null,generos,generos[0]);
			char generoPC = 0;
			switch(generoP.toString()) {
				case "Feminino":
					generoPC  = 'F';
					break;
				case "Masculino":
					generoPC = 'M';
					break;
				case "Não Binario":
					generoPC = 'N';
					break;
				}
			Profissional profissonal = new Profissional(nomeP, cpfPL, contatoPL, generoPC);
			JOptionPane.showMessageDialog(mainFrame,profissonal.toString());
			
		});
		
		mainFrame.add(b4);
		
		b5.addActionListener(e -> {
			String endereco = JOptionPane.showInputDialog(mainFrame,"Informe o endereço da Clínica: ");
			Clinica clinica = new Clinica(endereco);
			JOptionPane.showMessageDialog(mainFrame,"Clínica Cadastrada" + "\n Endereço: " + clinica.getEndereco() + "\n Id: " + clinica.getId());
		
		});
		
		mainFrame.add(b5);
		
		mainFrame.setVisible(true);
		
		
	}

}
