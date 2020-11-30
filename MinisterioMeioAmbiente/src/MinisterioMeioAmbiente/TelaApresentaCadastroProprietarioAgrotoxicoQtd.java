package MinisterioMeioAmbiente;

import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class TelaApresentaCadastroProprietarioAgrotoxicoQtd extends JFrame implements ActionListener {
	/**
	 *@author Carlos Rhedney
	 */
	private static final long serialVersionUID = 1L;
	JTable tabelaApresentaProprietarios;
	DefaultTableModel modelo;
	JButton btnExibir;

	public TelaApresentaCadastroProprietarioAgrotoxicoQtd() {
		//Imagem icone, Background, Titulo, Celulas da Tabela, Dados vazio pois retorna do Banco de Dados,
		//Modelo, Bot�o...
		setIconImage(Toolkit.getDefaultToolkit().getImage(TelaApresentaCadastroProprietario.class.getResource("/MinisterioMeioAmbienteImg/aps.png")));
		setBackground(Color.WHITE);
		setTitle("Apresenta\u00E7\u00E3o Propriet\u00E1rios Endere\u00E7o Contato e Quantidade de Agrot�xicos");
		String colunas[] = { "Nome", "CPF", "Data Nascimento", "Sexo", "Logradouro", "Bairro", "CEP", "N�mero", "Munic�pio", "UF", "Complemento", "DDD", "Tel", "Cel", "Email", "Qtd Herbicida", "Qtd Inseticida", "Qtd Fungicida", "Qtd Bactericida" };
		String dados[][] = { };
		modelo = new DefaultTableModel(dados, colunas);
		tabelaApresentaProprietarios = new JTable(new DefaultTableModel(new Object[][] {},
		new String[] { "Nome", "CPF", "Data Nascimento", "Sexo", "Logradouro", "Bairro", "CEP", "N�mero", "Munic�pio", "UF", "Complemento", "DDD", "Tel", "Cel", "Email", "Qtd Herbicida", "Qtd Inseticida", "Qtd Fungicida", "Qtd Bactericida" }));
		JScrollPane sp = new JScrollPane(tabelaApresentaProprietarios);
		getContentPane().add(sp, "Center");
		btnExibir = new JButton("Exibir Propriet�rios");
		btnExibir.addActionListener(this);
		getContentPane().add(btnExibir, "South");
		pack();
		setVisible(true);
	}
	
	//Metodo que preenche a tabela com os dados do Banco de Dados
	//Aproveitei para fazer um esqueminha de sele��o dos itens da tabela (gambiarras a parte).
	public void actionPerformed(ActionEvent evt) {
		//Pegando o valor das linhas da tabela que est�o sendo retornados do Banco de Dados.
		int linha = tabelaApresentaProprietarios.getSelectedRow();
		//Pegando o valor das colunas da tabela que est�o sendo retornados do Banco de Dados.
		int coluna = tabelaApresentaProprietarios.getSelectedColumn();
		//Chamada do metodo PopularJTable.
		PopularJTable();
		//Select nas tabela cadastro_proprietario_rural, endereco, contato e Quantidade de Agrot�xicos.
		//Para popular a tabela com os dados do Banco de Dados.
		this.PopularJTable(" Select c.*, e.*, con.ddd_telefone_residencial, con.telefone_residencial, con.telefone_celular, con.email, qtd.qtd_herbicida, qtd.qtd_inseticida, qtd.qtd_fungicida, qtd.qtd_bactericida from cadastro_proprietario_rural AS c INNER JOIN endereco AS e ON (c.cpf = e.id_proprietario) INNER JOIN contato AS con ON (c.cpf = con.id_proprietario) INNER JOIN qtd_agrotoxicos AS qtd ON (c.cpf = qtd.id_proprietario) where c.cpf = e.id_proprietario AND c.cpf = con.id_proprietario AND c.cpf = qtd.id_proprietario ");
		//Verificando se foi selecionado algum campo da tabela.
		if (linha != -1 && coluna != -1) {
			//Inserindo os valores selecionados da tabela na String dados
			String dados = (String) tabelaApresentaProprietarios.getValueAt(linha, coluna);
			//Se foi selecionado algum campo da tabela, � apresentado.
			JOptionPane.showMessageDialog(null, dados, "Informa��o", JOptionPane.INFORMATION_MESSAGE);
		} else {
			//Se n�o foi selecionado nenhum campo, informo o proprietario para selecionar.
			JOptionPane.showMessageDialog(null, "Selecione uma linha da tabela", "Informa��o", JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	//Metodo AutoGenerated.
	private void PopularJTable(String string) {
		// TODO Auto-generated method stub

	}
	
	//Metodo que faz a chamada da pagina.
	public static void main(String[] args) {
		new TelaApresentaCadastroProprietarioAgrotoxicoQtd();
	}

	//Busca os dados do propriet�rio no Banco de Dados.
	public void PopularJTable() {
		boolean consulta = true;

		try {
			//Driver de conexao com o MySQL.
			Class.forName("com.mysql.jdbc.Driver");

			//Conex�o com o Banco de Dados.
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/ministerio_meio_ambiente", "root", "");

			//Objeto comdo SQL.
			java.sql.Statement stmt = con.createStatement();
			ResultSet RS = null;
			DefaultTableModel model = (DefaultTableModel) tabelaApresentaProprietarios.getModel();
			model.setNumRows(0);

			//Retorna os dados do Banco de Dados.
			//Aqui fa�o o select de quatro tabelas Cadastro_proprietario_rural, Endereco, Contato e Quantidae de Agrotoxicos.
			RS = stmt.executeQuery(" Select c.*, e.*, con.ddd_telefone_residencial, con.telefone_residencial, con.telefone_celular, con.email, qtd.qtd_herbicida, qtd.qtd_inseticida, qtd.qtd_fungicida, qtd.qtd_bactericida from cadastro_proprietario_rural AS c INNER JOIN endereco AS e ON (c.cpf = e.id_proprietario) INNER JOIN contato AS con ON (c.cpf = con.id_proprietario) INNER JOIN qtd_agrotoxicos AS qtd ON (c.cpf = qtd.id_proprietario) where c.cpf = e.id_proprietario AND c.cpf = con.id_proprietario AND c.cpf = qtd.id_proprietario ");
			while (RS.next()) {
				model.addRow(new Object[] {
						//Retorna os dados da tabela do Banco de Dados, cada campo e um coluna.
						RS.getString("nome"),
						RS.getString("cpf"),
						RS.getString("data_nasc"),
						RS.getString("sexo"),
						RS.getString("logradouro"),
						RS.getString("bairro"),
						RS.getString("cep"),
						RS.getString("numero"),
						RS.getString("municipio"),
						RS.getString("uf"),
						RS.getString("complemento"),
						RS.getString("ddd_telefone_residencial"),
						RS.getString("telefone_residencial"),
						RS.getString("telefone_celular"),
						RS.getString("email"),
						RS.getString("qtd_herbicida"),
						RS.getString("qtd_inseticida"),
						RS.getString("qtd_fungicida"),
						RS.getString("qtd_bactericida")
				});

				consulta = false;

			}
			//Caso os dados n�o existam, informo ao proprietario que os dados n�o foram encontrados.
			//Por�m isso s� acontecer� se n�o ouver cadastros no Banco de Dados.
			if (consulta) {
				JOptionPane.showMessageDialog(null, "Dados n�o Encontrados!", "Erro", JOptionPane.ERROR_MESSAGE);

			}

			//Fecha as conex�es.
			RS.close();
			stmt.close();
			con.close();

		//Trata os erros de conex�o.
		} catch (SQLException Erro) {
			JOptionPane.showMessageDialog(null, "Erro Cmdo SQL" + Erro.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);

		} catch (ClassNotFoundException Erro) {
			JOptionPane.showMessageDialog(null, "Driver n�o Encontrado!", "Erro", JOptionPane.ERROR_MESSAGE);

		}
	}
}