package MinisterioMeioAmbiente;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class TelaPrincipal extends JFrame {

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
					TelaPrincipal frame = new TelaPrincipal();
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
	public TelaPrincipal() {
		//Titulo, Imagem Icone, Altura Largura...
		setTitle("Acesso R\u00E1pido");
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(TelaPrincipal.class.getResource("/MinisterioMeioAmbienteImg/aps.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 769);
		
		//JMenuBar contendo o JMenu e o JMenuItem...
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		//JMenu contendo o JMenuItem...
		JMenu mnMenu = new JMenu("Menu");
		menuBar.add(mnMenu);
		
		//JMenuItem Sair...
		JMenuItem mntmSair = new JMenuItem("Sair");
		mntmSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		mnMenu.add(mntmSair);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//Botão Nível 1 chamando a Tela Apresenta Cadastro Proprietario
		JButton btnNvel1 = new JButton("N\u00EDvel 1");
		btnNvel1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaApresentaCadastroProprietario frame = new TelaApresentaCadastroProprietario();
				frame.setVisible(true);
			}
		});
		btnNvel1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		btnNvel1.setBounds(61, 504, 139, 95);
		contentPane.add(btnNvel1);
		
		//Botão Nível 2 chamando o Tela Leitor de Biometria Nível 2.
		JButton btnNvel2 = new JButton("N\u00EDvel 2");
		btnNvel2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Principal frame = new Principal();
				frame.setVisible(true);
			}
		});
		btnNvel2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		btnNvel2.setBounds(279, 504, 139, 95);
		contentPane.add(btnNvel2);
		
		//Botão Nível 3 chamando o Tela Leitor de Biometria Nível 3.
		JButton btnNvel3 = new JButton("N\u00EDvel 3");
		btnNvel3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Principal2 frame = new Principal2();
				frame.setVisible(true);
			}
		});
		btnNvel3.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		btnNvel3.setBounds(498, 504, 139, 95);
		contentPane.add(btnNvel3);
		
		//Label com a imagem de capa.
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/MinisterioMeioAmbienteImg/capa.png")));
		label.setBounds(0, 0, 684, 379);
		contentPane.add(label);
	}
}
