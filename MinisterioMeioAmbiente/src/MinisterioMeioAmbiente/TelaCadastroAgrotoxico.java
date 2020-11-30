package MinisterioMeioAmbiente;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
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

public class TelaCadastroAgrotoxico extends JFrame {

	/**
	 *@author Carlos Rhedney
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textEntCPF;
	private JTextField textSaiNome;
	private JTextField textSaiDataNascimento;
	private JTextField textSaiSexo;
	private JTextField textSaiLogradouro;
	private JTextField textSaiNumero;
	private JTextField textSaiBairro;
	private JTextField textSaiCEP;
	private JTextField textSaiMunicipio;
	private JTextField textUF;
	private JTextField textSaiComplemento;
	private JTextField textFazUso;
	private JTextField textEntTamPropriedade;
	private JTextField textHerbicida;
	private JTextField textInseticida;
	private JTextField textFungicida;
	private JTextField textBactericida;
	private JTextField textQtdHerb;
	private JTextField textQtdInset;
	private JTextField textQtdFung;
	private JTextField textQtdBact;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroAgrotoxico frame = new TelaCadastroAgrotoxico();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * 
	 * @throws ParseException
	 */
	public TelaCadastroAgrotoxico() throws ParseException {
		//Titulo, Imagem icone, Largura Altura.. 
		setTitle("Cadastro de Agrot\u00F3xicos");
		setIconImage(Toolkit.getDefaultToolkit().getImage(TelaCadastroAgrotoxico.class.getResource("/MinisterioMeioAmbienteImg/aps.png")));
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 769);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//Jpanel com os dados do proprietario.
		//Quando feita a verificação do CPF informado pelo proprietario anteriormente cadastrado,
		//É retornado os dados do Banco de Dados caso o CPF seja válido.
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBorder(new TitledBorder(null, "Dados", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK));
		panel.setBounds(0, 0, 684, 250);
		contentPane.add(panel);
		panel.setLayout(null);
		
		//Label com a frase "Digite seu CPF".
		JLabel lblDigiteSeuCpf = new JLabel("Digite seu CPF:");
		lblDigiteSeuCpf.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblDigiteSeuCpf.setBounds(10, 22, 114, 23);
		panel.add(lblDigiteSeuCpf);
		
		//FormatedTextField com a entrada do CPF, para a pesquisa do mesmom no Banco de Dados.
		textEntCPF = new JFormattedTextField(new MaskFormatter("###.###.###-##"));
		textEntCPF.setBounds(122, 25, 182, 20);
		panel.add(textEntCPF);
		textEntCPF.setColumns(10);
		
		//Label com "Nome"
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblNome.setBounds(10, 56, 91, 14);
		panel.add(lblNome);
		
		//TextField com a saida do nome, retornado do Banco de Dados.
		//Campo não editavel.
		textSaiNome = new JTextField();
		textSaiNome.setEditable(false);
		textSaiNome.setBounds(122, 56, 182, 20);
		panel.add(textSaiNome);
		textSaiNome.setColumns(10);
		
		//Label com "Data de Nascimento".
		JLabel lblDataDeNascimento = new JLabel("Data de Nascimento:");
		lblDataDeNascimento.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblDataDeNascimento.setBounds(347, 28, 150, 17);
		panel.add(lblDataDeNascimento);
		
		//TextField com a saida da data de nascimento, retornado do Banco de Dados.
		//Campo não editavel.
		textSaiDataNascimento = new JTextField();
		textSaiDataNascimento.setEditable(false);
		textSaiDataNascimento.setBounds(507, 25, 134, 20);
		panel.add(textSaiDataNascimento);
		textSaiDataNascimento.setColumns(10);
		
		//Labem com "Sexo"
		JLabel lblSexo = new JLabel("Sexo:");
		lblSexo.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblSexo.setBounds(440, 56, 46, 14);
		panel.add(lblSexo);
		
		//TextField com a saida do sexo, retornado do Banco de Dados.
		//Campo não editavel.
		textSaiSexo = new JTextField();
		textSaiSexo.setEditable(false);
		textSaiSexo.setBounds(507, 55, 134, 20);
		panel.add(textSaiSexo);
		textSaiSexo.setColumns(10);
		
		//Label com "Logradouro".
		JLabel lblLogradouro = new JLabel("Logradouro:");
		lblLogradouro.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblLogradouro.setBounds(10, 81, 96, 23);
		panel.add(lblLogradouro);
		
		//TextField com a saida do logradouro, retornado do Banco de Dados.
		//Campo não editavel.
		textSaiLogradouro = new JTextField();
		textSaiLogradouro.setEditable(false);
		textSaiLogradouro.setBounds(122, 87, 182, 20);
		panel.add(textSaiLogradouro);
		textSaiLogradouro.setColumns(10);
		
		//Label com "Número".
		JLabel lblNmero = new JLabel("N\u00FAmero:");
		lblNmero.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblNmero.setBounds(410, 85, 76, 14);
		panel.add(lblNmero);
		
		//TextField com a saida do número, retornado do Banco de Dados.
		//Campo não editavel.
		textSaiNumero = new JTextField();
		textSaiNumero.setEditable(false);
		textSaiNumero.setBounds(507, 86, 134, 20);
		panel.add(textSaiNumero);
		textSaiNumero.setColumns(10);
		
		//Label com "Bairro".
		JLabel lblBairro = new JLabel("Bairro:");
		lblBairro.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblBairro.setBounds(10, 115, 91, 14);
		panel.add(lblBairro);
		
		//TextField com a saida do bairro, retornado do Banco de Dados.
		//Campo não editavel.
		textSaiBairro = new JTextField();
		textSaiBairro.setEditable(false);
		textSaiBairro.setBounds(122, 114, 182, 20);
		panel.add(textSaiBairro);
		textSaiBairro.setColumns(10);
		
		//Label com "CEP".
		JLabel lblCep = new JLabel("CEP:");
		lblCep.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblCep.setBounds(440, 110, 46, 23);
		panel.add(lblCep);

		//TextField com a saida do cep, retornado do Banco de Dados.
		//Campo não editavel.
		textSaiCEP = new JTextField();
		textSaiCEP.setEditable(false);
		textSaiCEP.setBounds(507, 114, 134, 20);
		panel.add(textSaiCEP);
		textSaiCEP.setColumns(10);
		
		//Label com "Municipio".
		JLabel lblMunicipio = new JLabel("Municipio:");
		lblMunicipio.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblMunicipio.setBounds(10, 142, 76, 23);
		panel.add(lblMunicipio);

		//TextField com a saida do municipio, retornado do Banco de Dados.
		//Campo não editavel.
		textSaiMunicipio = new JTextField();
		textSaiMunicipio.setEditable(false);
		textSaiMunicipio.setBounds(122, 145, 182, 20);
		panel.add(textSaiMunicipio);
		textSaiMunicipio.setColumns(10);
		
		//Label com "UF"
		JLabel lblUf = new JLabel("UF:");
		lblUf.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblUf.setBounds(440, 146, 46, 19);
		panel.add(lblUf);
		
		//TextField com a saida do uf, retornado do Banco de Dados.
		//Campo não editavel.
		textUF = new JTextField();
		textUF.setEditable(false);
		textUF.setBounds(507, 145, 134, 20);
		panel.add(textUF);
		textUF.setColumns(10);
		
		//Botão pesquisar com a imagem icone de pesquisa.
		JButton btnOk = new JButton("");
		btnOk.setIcon(new ImageIcon(TelaCadastroAgrotoxico.class.getResource("/MinisterioMeioAmbienteImg/pesquisa.png")));
		btnOk.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//Metdo chamando a verificação do CPF, caso o proprietario queira colocar
				//Um CPF diferente do que ele cadastrou, é feita uma verificação no Banco de Dados.
				VerificaCPF();
			}
		});
		btnOk.setBounds(305, 25, 29, 20);
		panel.add(btnOk);
		
		//Label com "Complemento".
		JLabel lblComplemento = new JLabel("Complemento:");
		lblComplemento.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblComplemento.setBounds(10, 176, 108, 23);
		panel.add(lblComplemento);
		
		//TextField com a saida do complemento, retornado do Banco de Dados.
		//Campo não editavel.
		textSaiComplemento = new JTextField();
		textSaiComplemento.setEditable(false);
		textSaiComplemento.setBackground(Color.WHITE);
		textSaiComplemento.setBounds(122, 176, 182, 63);
		panel.add(textSaiComplemento);
		textSaiComplemento.setColumns(10);
		
		//Jpanel com o Cadastro de Agrotoxicos.
		JPanel panelCadastroAgrotoxico = new JPanel();
		panelCadastroAgrotoxico.setBackground(Color.WHITE);
		panelCadastroAgrotoxico.setBorder(new TitledBorder(null, "Cadastro de Agrot\u00F3xicos", TitledBorder.LEADING,
				TitledBorder.TOP, null, Color.BLACK));
		panelCadastroAgrotoxico.setBounds(0, 256, 684, 339);
		contentPane.add(panelCadastroAgrotoxico);
		panelCadastroAgrotoxico.setLayout(null);
		
		//Label com a frase "Faz uso de Agrotóxicos?".
		JLabel lblFazUsoDe = new JLabel("Faz uso de Agrot\u00F3xicos?");
		lblFazUsoDe.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblFazUsoDe.setBounds(10, 25, 178, 23);
		panelCadastroAgrotoxico.add(lblFazUsoDe);
		
		//RadioButton com "Sim".
		JRadioButton rdbtnSim = new JRadioButton("Sim");
		rdbtnSim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Como tive um pouco de dificuldade para enviar o valor propriamente dito do radio button,
				//Optei em fazer dessa forma, verifico se o radio button "Sim" foi selecionado, se sim,
				//variavel fazUsoAgrotoxico recebe "Sim" ai seto ela no TextFazUso.
				String fazUsoAgrotoxico;
				if (rdbtnSim.isSelected()) {
					rdbtnSim.setText("Sim");
					fazUsoAgrotoxico = "Sim";
					textFazUso.setText(fazUsoAgrotoxico);
				}
			}
		});
		rdbtnSim.setFont(new Font("Tahoma", Font.ITALIC, 14));
		rdbtnSim.setBounds(6, 55, 60, 23);
		panelCadastroAgrotoxico.add(rdbtnSim);
		
		//RadioButton com "Não".
		JRadioButton rdbtnNo = new JRadioButton("N\u00E3o");
		rdbtnNo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Como tive um pouco de dificuldade para enviar o valor propriamente dito do radio button,
				//Optei em fazer dessa forma, verifico se o radio button "Não" foi selecionado, se sim,
				//variavel fazUsoAgrotoxico recebe "Não" ai seto ela no TextFazUso.
				String fazUsoAgrotoxico;
				if (rdbtnNo.isSelected()) {
					rdbtnNo.setText("Não");
					fazUsoAgrotoxico = "Não";
					textFazUso.setText(fazUsoAgrotoxico);
				}
			}
		});
		rdbtnNo.setFont(new Font("Tahoma", Font.ITALIC, 14));
		rdbtnNo.setBounds(68, 55, 60, 23);
		panelCadastroAgrotoxico.add(rdbtnNo);
		
		//Adicionando os radio buttons.
		ButtonGroup btnRb = new ButtonGroup();
		btnRb.add(rdbtnSim);
		btnRb.add(rdbtnNo);
		
		//textFazUso recebe o valor do radio button setado pelo proprietario.
		//O mesmo recebe o valor e envia pro banco de dados.
		//Optei em deixar o textFazUso "invisivel", diminui totalmente o tamanho dele,
		//para ficar "invisivel" aos olhos do usuario.
		textFazUso = new JTextField();
		textFazUso.setEnabled(false);
		textFazUso.setEditable(false);
		textFazUso.setBounds(140, 75, 0, 0);
		panelCadastroAgrotoxico.add(textFazUso);
		textFazUso.setColumns(10);
		
		//Label com "Tamanho da Propriedade"
		JLabel lblTamanhoDaPropriedade = new JLabel("Tamanho da Propriedade:");
		lblTamanhoDaPropriedade.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblTamanhoDaPropriedade.setBounds(10, 107, 191, 23);
		panelCadastroAgrotoxico.add(lblTamanhoDaPropriedade);
		
		//TextField com a entrada do tamanho da propriedade.
		textEntTamPropriedade = new JTextField();
		textEntTamPropriedade.setBounds(10, 141, 130, 20);
		panelCadastroAgrotoxico.add(textEntTamPropriedade);
		textEntTamPropriedade.setColumns(10);
		
		//Label com "M²".
		JLabel lblM = new JLabel("M\u00B2");
		lblM.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblM.setBounds(145, 141, 30, 20);
		panelCadastroAgrotoxico.add(lblM);
		
		//Label com "Herbicidas".
		JLabel lblHerbicida = new JLabel("Herbicidas:");
		lblHerbicida.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblHerbicida.setBounds(270, 31, 84, 17);
		panelCadastroAgrotoxico.add(lblHerbicida);
		
		//RadioButton com "Sim".
		JRadioButton rdbtnSimHerbicida = new JRadioButton("Sim");
		rdbtnSimHerbicida.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Como tive um pouco de dificuldade para enviar o valor propriamente dito do radio button,
				//Optei em fazer dessa forma, verifico se o radio button "Sim" foi selecionado, se sim,
				//variavel Herbicida recebe "Sim" ai seto ela no TextHerbicida.
				String Herbicida;
				if (rdbtnSimHerbicida.isSelected()) {
					rdbtnSimHerbicida.setText("Sim");
					Herbicida = "Sim";
					textHerbicida.setText(Herbicida);
				}
			}
		});
		rdbtnSimHerbicida.setFont(new Font("Tahoma", Font.ITALIC, 14));
		rdbtnSimHerbicida.setBounds(270, 57, 60, 23);
		panelCadastroAgrotoxico.add(rdbtnSimHerbicida);
		
		//RadioButton com "Não".
		JRadioButton rdbtnNoHerbicida = new JRadioButton("N\u00E3o");
		rdbtnNoHerbicida.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Como tive um pouco de dificuldade para enviar o valor propriamente dito do radio button,
				//Optei em fazer dessa forma, verifico se o radio button "Não" foi selecionado, se sim,
				//variavel Herbicida recebe "Não" ai seto ela no TextHerbicida.
				String Herbicida;
				if (rdbtnNoHerbicida.isSelected()) {
					rdbtnNoHerbicida.setText("Não");
					Herbicida = "Não";
					textHerbicida.setText(Herbicida);
				}
			}
		});
		rdbtnNoHerbicida.setFont(new Font("Tahoma", Font.ITALIC, 14));
		rdbtnNoHerbicida.setBounds(332, 57, 60, 23);
		panelCadastroAgrotoxico.add(rdbtnNoHerbicida);
		
		//Adicionando os radio buttons.
		ButtonGroup btnRbHerb = new ButtonGroup();
		btnRbHerb.add(rdbtnSimHerbicida);
		btnRbHerb.add(rdbtnNoHerbicida);
		
		//textHerbicida recebe o valor do radio button setado pelo proprietario
		//O mesmo recebe o valor e envia pro banco de dados.
		//Optei em deixar o textHerbicida "invisivel", diminui totalmente o tamanho dele,
		//para ficar "invisivel" aos olhos do usuario.
		textHerbicida = new JTextField();
		textHerbicida.setEnabled(false);
		textHerbicida.setEditable(false);
		textHerbicida.setBounds(357, 48, 0, 0);
		panelCadastroAgrotoxico.add(textHerbicida);
		textHerbicida.setColumns(10);
		
		//Label com "Inseticidas".
		JLabel lblInseticidas = new JLabel("Inseticidas:");
		lblInseticidas.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblInseticidas.setBounds(270, 96, 84, 20);
		panelCadastroAgrotoxico.add(lblInseticidas);
		
		//RadioButton com "Sim".
		JRadioButton rdbtnSimInseticida = new JRadioButton("Sim");
		rdbtnSimInseticida.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Como tive um pouco de dificuldade para enviar o valor propriamente dito do radio button,
				//Optei em fazer dessa forma, verifico se o radio button "Sim" foi selecionado, se sim,
				//variavel Inseticida recebe "Sim" ai seto ela no TextInseticida.
				String Inseticida;
				if (rdbtnSimInseticida.isSelected()) {
					rdbtnSimInseticida.setText("Sim");
					Inseticida = "Sim";
					textInseticida.setText(Inseticida);
				}
			}
		});
		rdbtnSimInseticida.setFont(new Font("Tahoma", Font.ITALIC, 14));
		rdbtnSimInseticida.setBounds(270, 123, 60, 23);
		panelCadastroAgrotoxico.add(rdbtnSimInseticida);
		
		//RadioButton com "Não".
		JRadioButton rdbtnNoInseticida = new JRadioButton("N\u00E3o");
		rdbtnNoInseticida.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Como tive um pouco de dificuldade para enviar o valor propriamente dito do radio button,
				//Optei em fazer dessa forma, verifico se o radio button "Não" foi selecionado, se sim,
				//variavel Inseticida recebe "Não" ai seto ela no TextInseticida.
				String Inseticida;
				if (rdbtnNoInseticida.isSelected()) {
					rdbtnNoInseticida.setText("Não");
					Inseticida = "Não";
					textInseticida.setText(Inseticida);
				}
			}
		});
		rdbtnNoInseticida.setFont(new Font("Tahoma", Font.ITALIC, 14));
		rdbtnNoInseticida.setBounds(332, 123, 60, 23);
		panelCadastroAgrotoxico.add(rdbtnNoInseticida);
		
		//Adicionando os radio buttons.
		ButtonGroup btnRbInset = new ButtonGroup();
		btnRbInset.add(rdbtnSimInseticida);
		btnRbInset.add(rdbtnNoInseticida);
		
		//textInseticida recebe o valor do radio button setado pelo usuario
		//O mesmo recebe o valor e envia pro banco de dados.
		//Optei em deixar o textInseticida "invisivel", diminui totalmente o tamanho dele,
		//para ficar "invisivel" aos olhos do usuario.
		textInseticida = new JTextField();
		textInseticida.setEditable(false);
		textInseticida.setEnabled(false);
		textInseticida.setBounds(357, 118, 0, 0);
		panelCadastroAgrotoxico.add(textInseticida);
		textInseticida.setColumns(10);
		
		//Label com "Fungicidas".
		JLabel lblFungicidas = new JLabel("Fungicidas:");
		lblFungicidas.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblFungicidas.setBounds(270, 162, 84, 23);
		panelCadastroAgrotoxico.add(lblFungicidas);
		
		//RadioButton com "Sim".
		JRadioButton rdbtnSimFungicida = new JRadioButton("Sim");
		rdbtnSimFungicida.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Como tive um pouco de dificuldade para enviar o valor propriamente dito do radio button,
				//Optei em fazer dessa forma, verifico se o radio button "Sim" foi selecionado, se sim,
				//variavel Fungicida recebe "Sim" ai seto ela no TextFungicida.
				String Fungicida;
				if (rdbtnSimFungicida.isSelected()) {
					rdbtnSimFungicida.setText("Sim");
					Fungicida = "Sim";
					textFungicida.setText(Fungicida);
				}
			}
		});
		rdbtnSimFungicida.setFont(new Font("Tahoma", Font.ITALIC, 14));
		rdbtnSimFungicida.setBounds(270, 188, 60, 23);
		panelCadastroAgrotoxico.add(rdbtnSimFungicida);
		
		//RadioButton com "Não".
		JRadioButton rdbtnNoFungicida = new JRadioButton("N\u00E3o");
		rdbtnNoFungicida.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Como tive um pouco de dificuldade para enviar o valor propriamente dito do radio button,
				//Optei em fazer dessa forma, verifico se o radio button "Não" foi selecionado, se sim,
				//variavel Fungicida recebe "Não" ai seto ela no TextFungicida.
				String Fungicida;
				if (rdbtnNoFungicida.isSelected()) {
					rdbtnNoFungicida.setText("Não");
					Fungicida = "Não";
					textFungicida.setText(Fungicida);
				}
			}
		});
		rdbtnNoFungicida.setFont(new Font("Tahoma", Font.ITALIC, 14));
		rdbtnNoFungicida.setBounds(332, 188, 60, 23);
		panelCadastroAgrotoxico.add(rdbtnNoFungicida);
		
		//Adicionando os radio buttons.
		ButtonGroup btnRbFung = new ButtonGroup();
		btnRbFung.add(rdbtnSimFungicida);
		btnRbFung.add(rdbtnNoFungicida);
		
		//textFungicida recebe o valor do radio button setado pelo usuario
		//O mesmo recebe o valor e envia pro banco de dados.
		//Optei em deixar o textFungicida "invisivel", diminui totalmente o tamanho dele,
		//para ficar "invisivel" aos olhos do usuario.
		textFungicida = new JTextField();
		textFungicida.setEditable(false);
		textFungicida.setEnabled(false);
		textFungicida.setBounds(354, 185, 0, 0);
		panelCadastroAgrotoxico.add(textFungicida);
		textFungicida.setColumns(10);
		
		//Label com "Bactericidas".
		JLabel lblBactericidas = new JLabel("Bactericidas:");
		lblBactericidas.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblBactericidas.setBounds(270, 228, 95, 23);
		panelCadastroAgrotoxico.add(lblBactericidas);

		JRadioButton rdbtnSimBactericida = new JRadioButton("Sim");
		rdbtnSimBactericida.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Como tive um pouco de dificuldade para enviar o valor propriamente dito do radio button,
				//Optei em fazer dessa forma, verifico se o radio button "Sim" foi selecionado, se sim,
				//variavel Bactericida recebe "Sim" ai seto ela no TextBactericida.
				String Bactericida;
				if (rdbtnSimBactericida.isSelected()) {
					rdbtnSimBactericida.setText("Sim");
					Bactericida = "Sim";
					textBactericida.setText(Bactericida);
				}
			}
		});
		rdbtnSimBactericida.setFont(new Font("Tahoma", Font.ITALIC, 14));
		rdbtnSimBactericida.setBounds(270, 257, 60, 23);
		panelCadastroAgrotoxico.add(rdbtnSimBactericida);
		
		//RadioButton com "Sim".
		JRadioButton rdbtnNoBactericida = new JRadioButton("N\u00E3o");
		rdbtnNoBactericida.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Como tive um pouco de dificuldade para enviar o valor propriamente dito do radio button,
				//Optei em fazer dessa forma, verifico se o radio button "Não" foi selecionado, se sim,
				//variavel Bactericida recebe "Não" ai seto ela no TextBactericida.
				String Bactericida;
				if (rdbtnNoBactericida.isSelected()) {
					rdbtnNoBactericida.setText("Não");
					Bactericida = "Não";
					textBactericida.setText(Bactericida);
				}
			}
		});
		rdbtnNoBactericida.setFont(new Font("Tahoma", Font.ITALIC, 14));
		rdbtnNoBactericida.setBounds(332, 258, 60, 23);
		panelCadastroAgrotoxico.add(rdbtnNoBactericida);
		
		//Adicionando os radio buttons.
		ButtonGroup btnRbBact = new ButtonGroup();
		btnRbBact.add(rdbtnSimBactericida);
		btnRbBact.add(rdbtnNoBactericida);
		
		//textBactericida recebe o valor do radio button setado pelo usuario
		//O mesmo recebe o valor e envia pro banco de dados.
		//Optei em deixar o textBactericida "invisivel", diminui totalmente o tamanho dele,
		//para ficar "invisivel" aos olhos do usuario.
		textBactericida = new JTextField();
		textBactericida.setEditable(false);
		textBactericida.setEnabled(false);
		textBactericida.setBounds(363, 251, 0, 0);
		panelCadastroAgrotoxico.add(textBactericida);
		textBactericida.setColumns(10);
		
		//Label com "Quantidade".
		JLabel lblQuantidade = new JLabel("Quantidade:");
		lblQuantidade.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblQuantidade.setBounds(478, 25, 103, 23);
		panelCadastroAgrotoxico.add(lblQuantidade);
		
		//TextQtdHerb com a entrada da quantidade de Herbicida utilizado pelo proprietario.
		textQtdHerb = new JTextField();
		textQtdHerb.setBounds(454, 58, 143, 20);
		panelCadastroAgrotoxico.add(textQtdHerb);
		textQtdHerb.setColumns(10);

		//TextQtdInset com a entrada da quantidade de Inseticida utilizado pelo proprietario.
		textQtdInset = new JTextField();
		textQtdInset.setBounds(454, 126, 143, 20);
		panelCadastroAgrotoxico.add(textQtdInset);
		textQtdInset.setColumns(10);
		
		//TextQtdFung com a entrada da quantidade de Fungicida utilizado pelo proprietario.
		textQtdFung = new JTextField();
		textQtdFung.setBounds(454, 191, 143, 20);
		panelCadastroAgrotoxico.add(textQtdFung);
		textQtdFung.setColumns(10);
		
		//TextQtdBact com a entrada da quantidade de Bactericida utilizado pelo proprietario.
		textQtdBact = new JTextField();
		textQtdBact.setBounds(454, 260, 143, 20);
		panelCadastroAgrotoxico.add(textQtdBact);
		textQtdBact.setColumns(10);
		
		//Label com "Kg".
		JLabel lblKglt = new JLabel("Kg/M\u00B2");
		lblKglt.setFont(new Font("Tahoma", Font.ITALIC, 14));
		lblKglt.setBounds(607, 61, 60, 17);
		panelCadastroAgrotoxico.add(lblKglt);
		
		//Label com "Kg".
		JLabel lblKgcm = new JLabel("Kg/M\u00B2");
		lblKgcm.setFont(new Font("Tahoma", Font.ITALIC, 14));
		lblKgcm.setBounds(607, 129, 60, 17);
		panelCadastroAgrotoxico.add(lblKgcm);

		//Label com "Kg".
		JLabel lblKgcm_1 = new JLabel("Kg/M\u00B2");
		lblKgcm_1.setFont(new Font("Tahoma", Font.ITALIC, 14));
		lblKgcm_1.setBounds(607, 194, 60, 17);
		panelCadastroAgrotoxico.add(lblKgcm_1);

		//Label com "Kg".
		JLabel lblKgcm_2 = new JLabel("Kg/M\u00B2");
		lblKgcm_2.setFont(new Font("Tahoma", Font.ITALIC, 14));
		lblKgcm_2.setBounds(607, 263, 60, 17);
		panelCadastroAgrotoxico.add(lblKgcm_2);
		
		//Label com "Obs:".
		JLabel lblObs = new JLabel("Obs:");
		lblObs.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblObs.setBounds(270, 311, 40, 17);
		panelCadastroAgrotoxico.add(lblObs);
		
		//Label com a frase "Caso não faça uso de agrotóxicos, digite 0 na quantidade".
		JLabel lblCasoNoFaa = new JLabel("Caso n\u00E3o fa\u00E7a uso de agrot\u00F3xicos, digite 0 na quantidade.");
		lblCasoNoFaa.setFont(new Font("Tahoma", Font.ITALIC, 14));
		lblCasoNoFaa.setBounds(319, 311, 355, 17);
		panelCadastroAgrotoxico.add(lblCasoNoFaa);
		
		//Botão Cadastrar
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					//Aqui faço a chamado do metodo de verificação
					//do CPF, caso o proprietario anteriormente cadastrado, queira informar
					//Um CPF diferente do que ele cadastrou, resolvi fazer a chamada de um metodo
					//Que impedisse tal façanha.
					ValidaCPF();
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnCadastrar.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		btnCadastrar.setBounds(207, 637, 117, 41);
		contentPane.add(btnCadastrar);
		
		//Botão Limpar.
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Metodo que limpa os campos preenchido pelo proprietario.
				limparCampos();
			}
		});
		btnLimpar.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		btnLimpar.setBounds(361, 637, 117, 41);
		contentPane.add(btnLimpar);
	}

	//Verificacão de usuario proprietario e conexao com o Banco de Dados.
	public void VerificaCPF() {
		try {
			//Drive de conexao com o MySQL.
			Class.forName("com.mysql.jdbc.Driver");

			//Conexão com o BD.
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/ministerio_meio_ambiente", "root", "");

			//Objeto comdo SQL.
			java.sql.Statement stmt = con.createStatement();
			ResultSet RS = null;

			//Compara os dados no BD com os dados digitados no jtextfield
			//Se forem iguais mostra o cadastro do usuario e libera o cadastro do agrotoxico
			String cpfUsuario = textEntCPF.getText();
			RS = stmt.executeQuery(" select cpf from cadastro_proprietario_rural where cpf = '" + cpfUsuario + "' ");
			if (RS.next()) {
				JOptionPane.showMessageDialog(null, "Registro encontrado com sucesso!", "Info", JOptionPane.INFORMATION_MESSAGE);
				BuscaDados();
			} else {
				JOptionPane.showMessageDialog(null, "CPF invalido!", "Erro", JOptionPane.ERROR_MESSAGE);
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

	//Busca os dados do proprietário no Banco de Dados.
	public void BuscaDados() {
		boolean consulta = true;

		try {
			//Driver de conexao com o MySQL.
			Class.forName("com.mysql.jdbc.Driver");

			//Conexão com o Banco de Dados.
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/ministerio_meio_ambiente", "root", "");

			//Objeto comdo SQL.
			java.sql.Statement stmt = con.createStatement();
			ResultSet RS = null;

			//Retorna os dados do Banco de Dados e insere na saida textfield.
			RS = stmt.executeQuery(" Select c.*, e.* from cadastro_proprietario_rural AS c JOIN endereco AS e ON (c.cpf = e.id_proprietario) where c.cpf = e.id_proprietario ");
			while (RS.next()) {
				textSaiNome.setText(RS.getString("nome"));
				textSaiDataNascimento.setText(RS.getString("data_nasc"));
				textSaiSexo.setText(RS.getString("sexo"));
				textSaiLogradouro.setText(RS.getString("logradouro"));
				textSaiNumero.setText(RS.getString("numero"));
				textSaiBairro.setText(RS.getString("bairro"));
				textSaiCEP.setText(RS.getString("cep"));
				textSaiMunicipio.setText(RS.getString("municipio"));
				textUF.setText(RS.getString("uf"));
				textSaiComplemento.setText(RS.getString("complemento"));

				consulta = false;

			}

			if (consulta) {
				JOptionPane.showMessageDialog(null, "Dados não Encontrados!", "Erro", JOptionPane.ERROR_MESSAGE);

			}

			//Fecha as conexões.
			RS.close();
			stmt.close();
			con.close();

			// Trata os erros de conexão.
		} catch (SQLException Erro) {
			JOptionPane.showMessageDialog(null, "Erro Cmdo SQL" + Erro.getMessage());

		} catch (ClassNotFoundException Erro) {
			JOptionPane.showMessageDialog(null, "Driver não Encontrado!", "Erro", JOptionPane.ERROR_MESSAGE);

		}
	}

	//Metodo que cadastra os agrotoxicos usados pelo usuário, é chamado pelo botao
	//cadastrar
	public void cadastroAgrotoxicos() throws ParseException {
		try {
			//Driver de conexao com o MySQL.
			Class.forName("com.mysql.jdbc.Driver");

			//Conexão com o Banco de Dados.
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/ministerio_meio_ambiente", "root", "");

			//Objeto comdo SQL.
			java.sql.Statement stmt = con.createStatement();

			//Pega os dados do formulário.
			String cpf = textEntCPF.getText();
			String fazUso = textFazUso.getText();
			String tamPropriedade = textEntTamPropriedade.getText();
			String herbicida = textHerbicida.getText();
			String inseticida = textInseticida.getText();
			String fungicida = textFungicida.getText();
			String bactericida = textBactericida.getText();
			String qtdHerb = textQtdHerb.getText();
			String qtdInset = textQtdInset.getText();
			String qtdFung = textQtdFung.getText();
			String qtdBact = textQtdBact.getText();

			//Verifica se todos os campos foram preenchidos.
			if (cpf.equals("") || fazUso.equals("") || tamPropriedade.equals("") || herbicida.equals("") || inseticida.equals("") || fungicida.equals("") || bactericida.equals("") || qtdHerb.equals("") || qtdInset.equals("") || qtdFung.equals("") || qtdBact.equals("")) {
				JOptionPane.showMessageDialog(null, "Todos campos devem ser preenchidos!", "Alerta", JOptionPane.WARNING_MESSAGE);
			} else {
				//Insere os dados no Banco de Dados, optei em fazer dois insert´s em tabelas
				//diferentes
				//Para que não acumulasse muita informação numa única tabela.
				stmt.executeUpdate("insert into agrotoxicos (id_proprietario, faz_uso, tam_propriedade, herbicida, inseticida, fungicida, bactericida) values ('" + cpf + "', '" + fazUso + "', '" + tamPropriedade + "', '" + herbicida + "', '" + inseticida + "', '" + fungicida + "', '" + bactericida + "')");
				stmt.executeUpdate("insert into qtd_agrotoxicos (id_proprietario, qtd_herbicida, qtd_inseticida, qtd_fungicida, qtd_bactericida) values ('" + cpf + "', '" + qtdHerb + "', '" + qtdInset + "', '" + qtdFung + "', '" + qtdBact + "')");
				JOptionPane.showMessageDialog(null, "Agrotóxicos cadastrados com sucesso!", "Info", JOptionPane.INFORMATION_MESSAGE);
				//Quando feita toda verificação dos campos e inserções, ai é liberada a tela principal.
				//Logo em seguida fecho a tela cadastro de agrotoxico.
				TelaPrincipal frame = new TelaPrincipal();
				frame.setVisible(true);
				dispose();
			}

			//Fecha a conexão com o Banco de Dados.
			con.close();

			//Trata os erros de conexão.
		} catch (SQLException Erro) {
			JOptionPane.showMessageDialog(null, "Erro ao tentar se conectar com o BD MYSQL: " + Erro.getMessage());

		} catch (ClassNotFoundException Erro) {
			JOptionPane.showMessageDialog(null, "Driver não encontrado!", "Erro", JOptionPane.ERROR_MESSAGE);

		}
	}

	//Limpa os campos de cadastro do agrotoxico.
	public void limparCampos() {
		textEntTamPropriedade.setText("");
		textQtdHerb.setText("");
		textQtdInset.setText("");
		textQtdFung.setText("");
		textQtdBact.setText("");
	}

	//Verificacão de cpf do proprietario, caso o usuario seja engraçadinho
	//e queira colocar outro cpf diferente do cadastrado, é System.exit(0) pra ele.
	public void ValidaCPF() throws ParseException {
		try {
			//Drive de conexao com o MySQL.
			Class.forName("com.mysql.jdbc.Driver");

			//Conexão com o BD.
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/ministerio_meio_ambiente", "root", "");

			//Objeto comdo SQL.
			java.sql.Statement stmt = con.createStatement();
			ResultSet RS = null;

			//Compara os dados no Banco de Dados com os dados digitados no jtextfield
			//Se forem diferentes System.exit(0) pra ele, ou seja, não banque o
			//engraçadinho.
			String cpfUsuario = textEntCPF.getText();
			RS = stmt.executeQuery(" select cpf from cadastro_proprietario_rural where cpf = '" + cpfUsuario + "' ");
			if (RS.next()) {
				//Caso o usuario "esqueça" de clicar no botão de pesquisa para validar o cpf,
				//Chamei a função aqui por precaução.
				BuscaDados();
				//Aí sim libero o cadastro do agrotoxico.
				cadastroAgrotoxicos();
			} else {
				JOptionPane.showMessageDialog(null, "CPF invalido!", "Erro", JOptionPane.ERROR_MESSAGE);
			}

			//Fecha a conexão com o Banco de Dados.
			con.close();

		} catch (SQLException Erro) {
			JOptionPane.showMessageDialog(null, "Erro ao tentar se conectar com o BD MYSQL: " + Erro.getMessage());

			//Trata os erros de conexão.
		} catch (ClassNotFoundException Erro) {

			JOptionPane.showMessageDialog(null, "Driver não encontrado!", "Erro", JOptionPane.WARNING_MESSAGE);

		}
	}
}
