package MinisterioMeioAmbiente;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class TelaInicial extends JFrame {

	/**
	 *@author Carlos Rhedney
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaInicial frame = new TelaInicial();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaInicial() {
		//Titulo, imagem icone, redimensionamento, fechamento da janela...
		setTitle("Minist\u00E9rio do Meio Ambiente");
		setIconImage(Toolkit.getDefaultToolkit().getImage(TelaInicial.class.getResource("/MinisterioMeioAmbienteImg/aps.png")));
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 769);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//Label com a ione de imagem.
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(TelaInicial.class.getResource("/MinisterioMeioAmbienteImg/aps.png")));
		label.setBounds(0, 0, 684, 637);
		contentPane.add(label);
		
		//Botão Iniciar
		JButton btnIniciar = new JButton("Iniciar");
		btnIniciar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaCadastroProprietario frame = null;
				try {
					//Tela cadastro de proprietario
					frame = new TelaCadastroProprietario();
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				frame.setVisible(true);
			}
		});
		btnIniciar.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		btnIniciar.setBounds(181, 660, 132, 59);
		contentPane.add(btnIniciar);
		
		//Botão Sair
		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnSair.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		btnSair.setBounds(361, 660, 132, 59);
		contentPane.add(btnSair);
	}
}
