import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class maintest {

    public static void main(String[] args) {
    	 // Criar o painel que conterá os campos de entrada
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());

        // Configurar as restrições de layout
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5); // Espaçamento entre os componentes
        gbc.anchor = GridBagConstraints.WEST; // Alinha os componentes à esquerda
        gbc.fill = GridBagConstraints.HORIZONTAL; // Faz os componentes se esticarem horizontalmente
        gbc.weightx = 1; // Faz com que os componentes ocupem o espaço disponível

        // Campo de entrada para o nome
        JLabel nameLabel = new JLabel("Nome:");
        gbc.gridx = 0; // Coluna
        gbc.gridy = 0; // Linha
        panel.add(nameLabel, gbc);

        JTextField nameField = new JTextField(15);
        gbc.gridx = 1; // Coluna
        gbc.gridy = 0; // Linha
        panel.add(nameField, gbc);

        // Campo de entrada para o e-mail
        JLabel emailLabel = new JLabel("E-mail:");
        gbc.gridx = 0; // Coluna
        gbc.gridy = 1; // Linha
        panel.add(emailLabel, gbc);

        JTextField emailField = new JTextField(15);
        gbc.gridx = 1; // Coluna
        gbc.gridy = 1; // Linha
        panel.add(emailField, gbc);

        // Campo de entrada para a idade
        JLabel ageLabel = new JLabel("Idade:");
        gbc.gridx = 0; // Coluna
        gbc.gridy = 2; // Linha
        panel.add(ageLabel, gbc);

        JTextField ageField = new JTextField(5);
        gbc.gridx = 1; // Coluna
        gbc.gridy = 2; // Linha
        panel.add(ageField, gbc);

        // ComboBox para escolher o gênero
        JLabel genderLabel = new JLabel("Gênero:");
        gbc.gridx = 0; // Coluna
        gbc.gridy = 3; // Linha
        panel.add(genderLabel, gbc);

        JComboBox<String> genderCombo = new JComboBox<>(new String[] {"Masculino", "Feminino", "Outro"});
        gbc.gridx = 1; // Coluna
        gbc.gridy = 3; // Linha
        panel.add(genderCombo, gbc);

        // Exibir o JOptionPane com o painel customizado
        int result = JOptionPane.showConfirmDialog(null, panel, "Cadastro de Usuário", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        // Verificar a ação do usuário
        if (result == JOptionPane.OK_OPTION) {
            // Obter os dados inseridos pelo usuário
            String nome = nameField.getText();
            String email = emailField.getText();
            String idade = ageField.getText();
            String genero = (String) genderCombo.getSelectedItem();

            // Validar e processar os dados
            if (nome.isEmpty() || email.isEmpty() || idade.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Por favor, preencha todos os campos.", "Erro", JOptionPane.ERROR_MESSAGE);
            } else {
                try {
                    int age = Integer.parseInt(idade); // Converter idade para inteiro
                    // Mostrar os dados coletados
                    String message = String.format("Nome: %s\nE-mail: %s\nIdade: %d\nGênero: %s", nome, email, age, genero);
                    JOptionPane.showMessageDialog(null, message, "Dados Cadastrados", JOptionPane.INFORMATION_MESSAGE);
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Idade deve ser um número válido.", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Cadastro cancelado.", "Cancelado", JOptionPane.INFORMATION_MESSAGE);
        }
    }

}
