package MinisterioMeioAmbiente;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.text.MaskFormatter;

public class TelaCadastroProprietario extends JFrame {

	/**
	 *@author Carlos Rhedney
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textEntNome;
	private JTextField textEntCPF;
	private JTextField textEntDataNascimento;
	private JTextField textEntLogradouro;
	private JTextField textEntNumero;
	private JTextField textEntBairro;
	private JTextField textEntCEP;
	private JTextField textEntMunicipio;
	private JTextField textEntComplemento;
	private JTextField textEntDDDTelefoneResidencial;
	private JTextField textEntTelefoneResidencial;
	private JTextField textEntDDDTelefoneCelular;
	private JTextField textEntTelefoneCelular;
	private JTextField textEntDDDTelefoneComercial;
	private JTextField textEntTelefoneComercial;
	private JTextField textEntEmail;
	private JTextField textSexo;
	private JTextField textUF;
	private JTextField textSim;
	private JTextField textAceito;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroProprietario frame = new TelaCadastroProprietario();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws ParseException 
	 */
	public TelaCadastroProprietario() throws ParseException {
		setIconImage(Toolkit.getDefaultToolkit().getImage(TelaCadastroProprietario.class.getResource("/MinisterioMeioAmbienteImg/aps.png")));
		setTitle("Cadastro de Propriedade Rural");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 769);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//Panel com o formulario de Dados Pessoais.
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(10, 11, 664, 112);
		panel.setBorder(BorderFactory.createTitledBorder("Dados Pessoais"));
		contentPane.add(panel);
		panel.setLayout(null);
		//Label com Nome.
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblNome.setBounds(10, 28, 46, 14);
		panel.add(lblNome);
		
		//TextField entrada de nome do usuario.
		textEntNome = new JTextField();
		textEntNome.setBounds(66, 27, 242, 20);
		panel.add(textEntNome);
		textEntNome.setColumns(10);
		
		//Label CPF.
		JLabel lblCPF = new JLabel("CPF:");
		lblCPF.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblCPF.setBounds(10, 82, 46, 14);
		panel.add(lblCPF);
		
		//TextField entrada do CPF
		textEntCPF = new JFormattedTextField(new MaskFormatter("###.###.###-##"));
		textEntCPF.setBounds(66, 81, 242, 20);
		panel.add(textEntCPF);
		textEntCPF.setColumns(10);
		
		//Label Data de Nascimento.
		JLabel lblDataDeNascimento = new JLabel("Data de Nascimento:");
		lblDataDeNascimento.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblDataDeNascimento.setBounds(342, 30, 143, 14);
		panel.add(lblDataDeNascimento);
		
		//TextField entrada da Data de Nascimento
		textEntDataNascimento = new JFormattedTextField(new MaskFormatter("##/##/####"));
		textEntDataNascimento.setBounds(495, 27, 159, 20);
		panel.add(textEntDataNascimento);
		textEntDataNascimento.setColumns(10);
		
		//Label Sexo.
		JLabel lblSexo = new JLabel("Sexo:");
		lblSexo.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblSexo.setBounds(342, 84, 46, 14);
		panel.add(lblSexo);
		
		//Radio button Masculino
		JRadioButton rdbtnEntMasculino = new JRadioButton("Masculino");
		rdbtnEntMasculino.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Como tive um pouco de dificuldade para enviar o valor propriamente dito do radio button,
				//Optei em fazer dessa forma, verifico se o radio button "Masculino" foi selecionado, se sim,
				//variavel Sexo recebe "Masculino".
				String Sexo;
				if(rdbtnEntMasculino.isSelected()) {
					rdbtnEntMasculino.setText("Masculino");
					Sexo = "Masculino";
					textSexo.setText(Sexo);
				}
			}
		});
		rdbtnEntMasculino.setFont(new Font("Tahoma", Font.ITALIC, 12));
		rdbtnEntMasculino.setBounds(394, 80, 79, 23);
		panel.add(rdbtnEntMasculino);
		
		//Radio button Feminino.
		JRadioButton rdbtnEntFeminino = new JRadioButton("Feminino");
		rdbtnEntFeminino.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Como tive um pouco de dificuldade para enviar o valor propriamente dito do radio button,
				//Optei em fazer dessa forma, verifico se o radio button "Feminino" foi selecionado, se sim,
				//variavel Sexo recebe "Feminino".
				String Sexo;
				if(rdbtnEntFeminino.isSelected()){
					rdbtnEntFeminino.setText("Feminino");
					Sexo = "Feminino";
					textSexo.setText(Sexo);
				}
			}
		});
		rdbtnEntFeminino.setFont(new Font("Tahoma", Font.ITALIC, 12));
		rdbtnEntFeminino.setBounds(482, 79, 79, 23);
		panel.add(rdbtnEntFeminino);
		
		//Adicionando os radio buttons
		ButtonGroup btnGrp = new ButtonGroup();
		btnGrp.add(rdbtnEntMasculino);
		btnGrp.add(rdbtnEntFeminino);
		
		//textSexo recebe o valor do radio button setado pelo usuario
		//O mesmo recebe o valor e envia pro banco de dados.
		//Optei em deixar o textSexo "invisivel", diminui totalmente o tamanho dele,
		//para ficar "invisivel" aos olhos do usuario.
		textSexo = new JTextField();
		textSexo.setEditable(false);
		textSexo.setBounds(595, 96, 0, 0);
		panel.add(textSexo);
		textSexo.setColumns(10);
		
		
		//Panel com os formulario Endereço.
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBorder(new TitledBorder(null, "Endereço", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK));
		panel_1.setBounds(10, 134, 664, 246);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		//Label Logradouro.
		JLabel lblLogradouro = new JLabel("Logradouro:");
		lblLogradouro.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblLogradouro.setBounds(10, 22, 87, 22);
		panel_1.add(lblLogradouro);
		
		//TextField entrada do logradouro.
		textEntLogradouro = new JTextField();
		textEntLogradouro.setBounds(107, 25, 353, 20);
		panel_1.add(textEntLogradouro);
		textEntLogradouro.setColumns(10);
		
		//Label com o Número do logradouro.
		JLabel lblNmero = new JLabel("N\u00FAmero:");
		lblNmero.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblNmero.setBounds(481, 28, 72, 14);
		panel_1.add(lblNmero);
		
		//TextField entrada do Número.
		textEntNumero = new JTextField();
		textEntNumero.setBounds(547, 25, 107, 20);
		panel_1.add(textEntNumero);
		textEntNumero.setColumns(10);
		
		//Label Bairro
		JLabel lblBairro = new JLabel("Bairro:");
		lblBairro.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblBairro.setBounds(10, 67, 54, 14);
		panel_1.add(lblBairro);
		
		//TextField entrada do Bairro.
		textEntBairro = new JTextField();
		textEntBairro.setBounds(107, 66, 353, 20);
		panel_1.add(textEntBairro);
		textEntBairro.setColumns(10);
		
		//Label CEP
		JLabel lblCep = new JLabel("CEP:");
		lblCep.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblCep.setBounds(481, 69, 46, 14);
		panel_1.add(lblCep);
		
		//TextField entrada CEP.
		textEntCEP = new JFormattedTextField(new MaskFormatter("#####-###"));
		textEntCEP.setBounds(547, 67, 107, 20);
		panel_1.add(textEntCEP);
		textEntCEP.setColumns(10);
		
		//Label Municipio.
		JLabel lblMunicipio = new JLabel("Municipio:");
		lblMunicipio.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblMunicipio.setBounds(10, 108, 87, 22);
		panel_1.add(lblMunicipio);
		
		//TextField entrada Municipio.
		textEntMunicipio = new JTextField();
		textEntMunicipio.setBounds(107, 111, 353, 20);
		panel_1.add(textEntMunicipio);
		textEntMunicipio.setColumns(10);
		
		//Label UF.
		JLabel lblUf = new JLabel("UF:");
		lblUf.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblUf.setBounds(481, 114, 46, 14);
		panel_1.add(lblUf);
		
		//Label Complemento.
		JLabel lblComplemento = new JLabel("Complemento:");
		lblComplemento.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblComplemento.setBounds(0, 154, 112, 14);
		panel_1.add(lblComplemento);
		
		//TextField entrada Municipio.
		textEntComplemento = new JTextField();
		textEntComplemento.setBounds(107, 153, 353, 22);
		panel_1.add(textEntComplemento);
		textEntComplemento.setColumns(10);
		
		//Jcombobox com todas estados
		JComboBox comboBoxUF = new JComboBox();
		comboBoxUF.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Como tive um pouco de dificuldade para enviar o valor propriamente dito do JComboBox,
				//Optei em fazer dessa forma, verifico qual estado foi selecionado,
				//variavel UF recebe o conteúdo setado pelo usuário.
				String UF = (String) comboBoxUF.getSelectedItem();
				textUF.setText(UF);
				if(textUF.getText().equals("Selecione")) {
					JOptionPane.showMessageDialog(null, "Favor preencher o campo UF!", "Erro", JOptionPane.WARNING_MESSAGE);
					System.exit(0);
				}
			}
		});
		comboBoxUF.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		comboBoxUF.setModel(new DefaultComboBoxModel(new String[] {"Selecione", "SP", "RJ", "AM", "RS", "RO", "AC", "RR", "PA", "AP", "TO", "MA", "PI", "CE", "RN", "PB", "PE", "AL", "SE", "BA", "MG", "ES", "PR", "SC", "MS", "MT", "GO", "DF"}));
		comboBoxUF.setToolTipText("");
		comboBoxUF.setBounds(547, 110, 96, 22);
		panel_1.add(comboBoxUF);
		
		//textUF recebe o valor do comboBoxUF setado pelo usuário
		//O mesmo recebe o valor e envia pro banco de dados.
		//Optei em deixar o textUF "invisivel", diminui totalmente o tamanho dele,
		//para ficar "invisivel" aos olhos do usuario.
		textUF = new JTextField();
		textUF.setBackground(Color.WHITE);
		textUF.setEnabled(false);
		textUF.setEditable(false);
		textUF.setBounds(655, 130, -1, 0);
		panel_1.add(textUF);
		textUF.setColumns(10);
		
		//Panel com o formulario Contatos
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel_2.setBorder(new TitledBorder(null, "Contatos", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK));
		panel_2.setBounds(10, 391, 664, 246);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		//Label com Telefone Residencial.
		JLabel lblTelefoneResidncial = new JLabel("Telefone Resid\u00EAncial:");
		lblTelefoneResidncial.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblTelefoneResidncial.setBounds(10, 24, 151, 26);
		panel_2.add(lblTelefoneResidncial);
		
		//TextField com entrada do DDD
		textEntDDDTelefoneResidencial = new JFormattedTextField(new MaskFormatter("(##)"));
		textEntDDDTelefoneResidencial.setBounds(171, 29, 38, 20);
		panel_2.add(textEntDDDTelefoneResidencial);
		textEntDDDTelefoneResidencial.setColumns(10);
		
		//TextField com entrada do Telefone Residencial
		textEntTelefoneResidencial = new JFormattedTextField(new MaskFormatter("####-####"));
		textEntTelefoneResidencial.setBounds(219, 29, 151, 20);
		panel_2.add(textEntTelefoneResidencial);
		textEntTelefoneResidencial.setColumns(10);
		
		//Label com Telefone Celular.
		JLabel lblTelefoneCelular = new JLabel("Telefone Celular:");
		lblTelefoneCelular.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblTelefoneCelular.setBounds(10, 55, 151, 26);
		panel_2.add(lblTelefoneCelular);
		
		//TextField com entrada do DDD.
		textEntDDDTelefoneCelular = new JFormattedTextField(new MaskFormatter("(##)"));
		textEntDDDTelefoneCelular.setBounds(171, 60, 38, 20);
		panel_2.add(textEntDDDTelefoneCelular);
		textEntDDDTelefoneCelular.setColumns(10);
		
		//TextField com entrada do Telefone Celular.
		textEntTelefoneCelular = new JFormattedTextField(new MaskFormatter("#####-####"));
		textEntTelefoneCelular.setBounds(219, 60, 151, 20);
		panel_2.add(textEntTelefoneCelular);
		textEntTelefoneCelular.setColumns(10);
		
		//Label com Telefone Comercial.
		JLabel lblTelefoneComercial = new JLabel("Telefone Comercial:");
		lblTelefoneComercial.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblTelefoneComercial.setBounds(10, 86, 151, 26);
		panel_2.add(lblTelefoneComercial);
		
		//TextField com entrada do DDD
		textEntDDDTelefoneComercial = new JFormattedTextField(new MaskFormatter("(##)"));
		textEntDDDTelefoneComercial.setBounds(171, 91, 38, 20);
		panel_2.add(textEntDDDTelefoneComercial);
		textEntDDDTelefoneComercial.setColumns(10);
		
		//TextField com entrada do Telefone Comercial.
		textEntTelefoneComercial = new JFormattedTextField(new MaskFormatter("####-####"));
		textEntTelefoneComercial.setBounds(219, 91, 151, 20);
		panel_2.add(textEntTelefoneComercial);
		textEntTelefoneComercial.setColumns(10);
		
		//Label com Email.
		JLabel lblEmail = new JLabel("E-mail:");
		lblEmail.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblEmail.setBounds(10, 123, 67, 14);
		panel_2.add(lblEmail);
		
		//TextField com entrada do Email.
		textEntEmail = new JTextField();
		textEntEmail.setBounds(171, 122, 199, 20);
		panel_2.add(textEntEmail);
		textEntEmail.setColumns(10);
		
		//Label com o titulo Deseja receber Email´s do Ministerio do Meio Ambiente.
		JLabel lblNewLabel = new JLabel("Deseja receber emails do Minist\u00E9rio do Meio Ambiente?");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblNewLabel.setBounds(10, 153, 381, 20);
		panel_2.add(lblNewLabel);
		
		//CheckBox com Sim.
		JCheckBox chckbxSim = new JCheckBox("Sim");
		chckbxSim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Como tive um pouco de dificuldade para enviar o valor propriamente dito do CheckBox,
				//Optei em fazer dessa forma, verifico se o CheckBox "Sim" foi selecionado, se sim,
				//variavel conteudo recebe o valor do CheckBox.
				String conteudo = chckbxSim.getText();
				textSim.setText(conteudo);
			}
		});
		chckbxSim.setBounds(64, 180, 97, 23);
		panel_2.add(chckbxSim);
		
		//CheckBox com Não.
		JCheckBox chckbxNo = new JCheckBox("N\u00E3o");
		chckbxNo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Como tive um pouco de dificuldade para enviar o valor propriamente dito do CheckBox,
				//Optei em fazer dessa forma, verifico se o CheckBox "Não" foi selecionado, se sim,
				//variavel conteudo recebe o valor do CheckBox.
				String conteudo = chckbxNo.getText();
				textSim.setText(conteudo);
			}
		});
		chckbxNo.setBounds(183, 180, 97, 23);
		panel_2.add(chckbxNo);
		
		//Adicionando os CheckBox
		ButtonGroup btnChec = new ButtonGroup();
		btnChec.add(chckbxSim);
		btnChec.add(chckbxNo);
		
		//Label Li e Aceito os Termos e Condições.
		JLabel lblLiEAceito = new JLabel("Li e Aceito os Termos e Condi\u00E7\u00F5es:");
		lblLiEAceito.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblLiEAceito.setBounds(396, 30, 258, 14);
		panel_2.add(lblLiEAceito);
		
		//CheckBox com Aceito.
		JCheckBox chckbxAceito = new JCheckBox("Aceito");
		chckbxAceito.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Como tive um pouco de dificuldade para enviar o valor propriamente dito do CheckBox,
				//Optei em fazer dessa forma, verifico se o CheckBox "Aceito" foi selecionado, se sim,
				//variavel conteudo2 recebe o valor do CheckBox.
				String conteudo2 = chckbxAceito.getText();
				textAceito.setText(conteudo2);
			}
		});
		chckbxAceito.setBounds(440, 55, 86, 23);
		panel_2.add(chckbxAceito);
		
		//CheckBox com Não Aceito.
		JCheckBox chckbxNoAceito = new JCheckBox("N\u00E3o aceito");
		chckbxNoAceito.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Como tive um pouco de dificuldade para enviar o valor propriamente dito do CheckBox,
				//Optei em fazer dessa forma, verifico se o CheckBox "Não aceito" foi selecionado, se sim,
				//variavel conteudo2 recebe o valor do CheckBox.
				String conteudo2 = chckbxNoAceito.getText();
				textAceito.setText(conteudo2);
			}
		});
		chckbxNoAceito.setBounds(539, 55, 97, 23);
		panel_2.add(chckbxNoAceito);
		
		//Adicionando os CheckBox
		ButtonGroup btnChec2 = new ButtonGroup();
		btnChec2.add(chckbxAceito);
		btnChec2.add(chckbxNoAceito);
		
		//textSim recebe o valor do CheckBox setado pelo usuário
		//O mesmo recebe o valor e envia pro banco de dados.
		//Optei em deixar o textSim "invisivel", diminui totalmente o tamanho dele,
		//para ficar "invisivel" aos olhos do usuario.
		textSim = new JTextField();
		textSim.setEnabled(false);
		textSim.setEditable(false);
		textSim.setBounds(305, 201, 0, 0);
		panel_2.add(textSim);
		textSim.setColumns(10);
		
		//textAceito recebe o valor do CheckBox setado pelo usuário
		//O mesmo recebe o valor e envia pro banco de dados.
		//Optei em deixar o textAceito "invisivel", diminui totalmente o tamanho dele,
		//para ficar "invisivel" aos olhos do usuario.
		textAceito = new JTextField();
		textAceito.setEnabled(false);
		textAceito.setEditable(false);
		textAceito.setBounds(476, 111, 0, 0);
		panel_2.add(textAceito);
		textAceito.setColumns(10);
		
		//Botão Cadastrar.
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					//Aqui faço a chamado do metodo de verificação
					//do CPF, caso o CPF informado já esteja cadatrado
					//informo o proprietario que o CPF já está cadastrado,
					//senão libero o cadastro do proprietario.
					ValidaCPF();
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnCadastrar.setFont(new Font("Tahoma", Font.ITALIC, 14));
		btnCadastrar.setBounds(175, 664, 103, 37);
		contentPane.add(btnCadastrar);
		
		//Botão Limpar.
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Metodo que limpa os campos.
				limparCampos();
			}
		});
		btnLimpar.setFont(new Font("Tahoma", Font.ITALIC, 14));
		btnLimpar.setBounds(300, 664, 103, 37);
		contentPane.add(btnLimpar);
		
		//Botão Sair.
		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnSair.setFont(new Font("Tahoma", Font.ITALIC, 14));
		btnSair.setBounds(429, 664, 103, 37);
		contentPane.add(btnSair);
	}
	// Metodo que cadastra o usuario, é chamado pelo botao cadastrar
		public void CadastroProprietario() throws ParseException {
			try {
			//Driver de conexao com o MySQL.
			Class.forName("com.mysql.jdbc.Driver");
			 
			//Conexão com o Banco de Dados.
			Connection con = DriverManager.getConnection(
			"jdbc:mysql://localhost/ministerio_meio_ambiente", "root", "");
			 
			//Objeto comdo SQL.
			java.sql.Statement stmt = con.createStatement();
			 
			//Pega os dados do formulário.
			String nome = textEntNome.getText();
			String cpf = textEntCPF.getText();
			String dataNasc = textEntDataNascimento.getText();
			String sexo = textSexo.getText();
			String rua = textEntLogradouro.getText();
			String bairro = textEntBairro.getText();
			String cep = textEntCEP.getText();
			String numero = textEntNumero.getText();
			String municipio = textEntMunicipio.getText();
			String uf = textUF.getText();
			String complemento = textEntComplemento.getText();
			String dddtelefoneResidencial = textEntDDDTelefoneResidencial.getText();
			String telefoneResidencial = textEntTelefoneResidencial.getText();
			String dddtelefoneCelular = textEntDDDTelefoneCelular.getText();
			String telefoneCelular = textEntTelefoneCelular.getText();
			String dddtelefoneComercial = textEntDDDTelefoneComercial.getText();
			String telefoneComercial = textEntTelefoneComercial.getText();
			String email = textEntEmail.getText();
			String recebeEmail = textSim.getText();
			String termos = textAceito.getText();
			
			//Verifica se todos os campos foram preenchidos.
			if(nome.equals("") || cpf.equals("") || dataNasc.equals("") || sexo.equals("") || rua.equals("") || bairro.equals("") || cep.equals("") || numero.equals("") || municipio.equals("") || uf.equals("") || complemento.equals("") || dddtelefoneResidencial.equals("") || telefoneResidencial.equals("") || dddtelefoneCelular.equals("") || telefoneCelular.equals("") || dddtelefoneComercial.equals("") || telefoneComercial.equals("") || email.equals("") || recebeEmail.equals("") || termos.equals("")) {
				JOptionPane.showMessageDialog(null, "Todos campos devem ser preenchidos!", "Alerta", JOptionPane.WARNING_MESSAGE);
			}else {
				//Insere os dados no Banco de Dados, optei em fazer quatro insert´s em quatro tabelas diferentes
				//Para que não acumulasse muita informação numa única tabela.
				stmt.executeUpdate("insert into cadastro_proprietario_rural (nome, cpf, data_nasc, sexo) values ('"+ nome + "','" + cpf + "', '" + dataNasc + "', '" + sexo + "')");
				stmt.executeUpdate("insert into endereco (id_proprietario, logradouro, bairro, cep, numero, municipio, uf, complemento) values ('" + cpf + "', '" + rua + "' , '" + bairro + "' , '" + cep + "' , '" + numero + "' , '" + municipio + "' , '" + uf + "' , '" + complemento + "')");
				stmt.executeUpdate("insert into contato (id_proprietario, ddd_telefone_residencial, telefone_residencial, ddd_telefone_celular, telefone_celular, ddd_telefone_comercial, telefone_comercial, email) values ('" + cpf + "', '" + dddtelefoneResidencial + "' , '" + telefoneResidencial + "' , '" + dddtelefoneCelular + "' , '" + telefoneCelular + "' , '" + dddtelefoneComercial + "' , '" + telefoneComercial + "' , '" + email + "')");
				stmt.executeUpdate("insert into termos (id_proprietario, receber_email, aceita_termos) values ('"+ cpf + "','" + recebeEmail + "', '" + termos + "')");
				JOptionPane.showMessageDialog(null, "Proprietário cadastrado com sucesso!", "Informação", JOptionPane.INFORMATION_MESSAGE);
				//Quando feita toda verificação dos campos e inserções, ai é liberada a tela de cadastro de agrotoxico.
				//Logo em seguida fecho a tela cadastro de proprietario.
				TelaCadastroAgrotoxico frame = new TelaCadastroAgrotoxico();
				frame.setVisible(true);
				dispose();
			}
			 
			//Fecha a conexão com o Banco de Dados.
			con.close();
			 
			//Trata os erros de conexão.
			} catch (SQLException Erro) {
				JOptionPane.showMessageDialog(null,"Erro ao tentar se conectar com o BD MYSQL: " + Erro.getMessage());
			 
			} catch (ClassNotFoundException Erro) {
				JOptionPane.showMessageDialog(null, "Driver não encontrado!", "Erro", JOptionPane.ERROR_MESSAGE);
			 
			}
		}
		
		//Verificacão de cpf do proprietario, aqui verifico se o CPF que
		//o proprietario esta tentando cadastrar, já foi cadastrado.
		public void ValidaCPF() throws ParseException {
			try {
				// Drive de conexao com o MySQL.
				Class.forName("com.mysql.jdbc.Driver");

				//Conexão com o Banco de Dados.
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost/ministerio_meio_ambiente", "root", "");

				//Objeto comdo SQL.
				java.sql.Statement stmt = con.createStatement();
				ResultSet RS = null;

				//Compara o CPF digitado no jtextfield com os CPF´s existentes no Banco de Dados,
				//Se forem iguais mando uma mensagem informando o proprietario que aquele
				//CPF já está cadastrado.
				String cpfUsuario = textEntCPF.getText();
				RS = stmt.executeQuery(" select cpf from cadastro_proprietario_rural where cpf = '" + cpfUsuario + "' ");
				if (RS.next()) {
					JOptionPane.showMessageDialog(null, "O CPF informado já está cadastrado!", "Erro", JOptionPane.ERROR_MESSAGE);
				} else {
					//Depois de toda a verificação feita ai
					//sim libero o cadastro do proprietario.
					CadastroProprietario();
				}

				//Fecha a conexão com o BD.
				con.close();

			} catch (SQLException Erro) {
				JOptionPane.showMessageDialog(null, "Erro ao tentar se conectar com o BD MYSQL: " + Erro.getMessage());

				//Trata os erros de conexão.
			} catch (ClassNotFoundException Erro) {

				JOptionPane.showMessageDialog(null, "Driver não encontrado!", "Erro", JOptionPane.WARNING_MESSAGE);

			}
		}
		
		//Limpa os campos de cadastro do usuario.
		public void limparCampos() {
			textEntNome.setText("");
			textEntCPF.setText("");
			textEntDataNascimento.setText("");
			textEntLogradouro.setText("");
			textEntBairro.setText("");
			textEntCEP.setText("");
			textEntNumero.setText("");
			textEntMunicipio.setText("");
			textEntComplemento.setText("");
			textEntDDDTelefoneResidencial.setText("");
			textEntTelefoneResidencial.setText("");
			textEntDDDTelefoneCelular.setText("");
			textEntTelefoneCelular.setText("");
			textEntDDDTelefoneComercial.setText("");
			textEntTelefoneComercial.setText("");
			textEntEmail.setText("");
		}
}