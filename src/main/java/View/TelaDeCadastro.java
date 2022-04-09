package View;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import Controller.Controlador;
import Model.Sexo;


public class TelaDeCadastro extends JFrame{

	private static final long serialVersionUID = 1949106005264109267L;
	private JPanel painel, barraPadraoSuperio, barraPadraoinferior;
	private JTextField TNome, TEmail, TTelefone, TCpf, TSexo, TData;
	private JTextField TRua,TNumero,TCep,TCidade, TEstado, TReferencia,TPais;
	
	private JLabel label,label2;
	private JSeparator separador;
	private JButton cadastrar, sair;
	private JRadioButton m, f, i;
	private Sexo gen;

	public TelaDeCadastro() {
		setTitle("Cadastro");
	    textos();
		caixaDeTexto();
		separadores();
		imagem();
		cadastrar();
		sexo();
		configurandoTela();
		setVisible(true);
	}
	
	public void configurandoTela() {
		setSize(900, 550);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(null);
		setResizable(false);
		configurandoPainel();
	}
	
	public void configurandoPainel() {

		painel = new JPanel();
		painel.setLayout(null);
		painel.setSize(900, 550);
		painel.setBackground(Color.decode("#cccccc"));
		add(painel);

		barraPadraoSuperio = new JPanel();
		barraPadraoSuperio.setSize(900, 13);
		barraPadraoSuperio.setBackground(Color.decode("#540c83"));
		painel.add(barraPadraoSuperio);
		
		barraPadraoinferior = new JPanel();
		barraPadraoinferior.setBounds(0, 500, 450, 13);
		barraPadraoinferior.setBackground(Color.decode("#540c83"));
		add(barraPadraoinferior);
	}
	
	public void textos() {

		label = new JLabel("Nome:");
		label.setBounds(50, 150, 50, 50);
		label.setOpaque(false);
		add(label);
		
		label = new JLabel("E-mail:");
		label.setBounds(50, 220, 100, 50);
		label.setOpaque(false);
		add(label);
		
		label = new JLabel("Telefone:");
		label.setBounds(50, 295, 100, 50);
		label.setOpaque(false);
		add(label);
		
		label = new JLabel("CPF:");
		label.setBounds(220, 150, 100, 50);
		label.setOpaque(false);
		add(label);
		
		label = new JLabel("Data Nasc:");
		label.setBounds(220, 295, 100, 50);
		label.setOpaque(false);
		add(label);
		
		label = new JLabel("Genero:");
		label.setBounds(50, 367, 100, 50);
		label.setOpaque(false);
		add(label);
		
		textosEnd();
	}
	
	public void textosEnd() {

		label = new JLabel("Rua:");
		label.setBounds(470, 150, 50, 50);
		label.setOpaque(false);	
		add(label);
		
		label = new JLabel("Numero:");
		label.setBounds(690, 150, 100, 50);
		label.setOpaque(false);
		add(label);
		
		label = new JLabel("CEP: ");
		label.setBounds(470, 220, 50, 50);
		label.setOpaque(false);
		add(label);
		
		label = new JLabel("Cidade: ");
		label.setBounds(595, 220, 100, 50);
		label.setOpaque(false);
		add(label);
		
		label = new JLabel("País: ");
		label.setBounds(725, 220, 100, 50);
		label.setOpaque(false);
		add(label);
		
		label = new JLabel("Ponto de referência: ");
		label.setBounds(470, 290, 150, 50);
		label.setOpaque(false);
		add(label);
		
		label = new JLabel("Estado: ");
		label.setBounds(690, 290, 150, 50);
		label.setOpaque(false);
		add(label);

	}
	
	public void caixaDeTexto() { 

		TNome = new JTextField();
		TNome.setBounds(50, 185, 145, 25);
		TNome.setBorder(null);
		TNome.setBackground(Color.decode("#cccccc"));
		add(TNome);
		
		TEmail = new JTextField();
		TEmail.setBounds(50, 260, 330, 25);
		TEmail.setBorder(null);
		TEmail.setBackground(Color.decode("#cccccc"));
		add(TEmail);
		
		try {
			TTelefone = new JFormattedTextField(new MaskFormatter("(##) #####-####"));
		} catch (ParseException e) {
			JOptionPane.showMessageDialog(null,"Formatter com problema");
		}
		TTelefone.setBounds(50, 330, 110, 25);
		TTelefone.setBorder(null);
		TTelefone.setBackground(Color.decode("#cccccc"));
		add(TTelefone);
		
		try {
			TCpf = new JFormattedTextField(new MaskFormatter("###.###.###-##"));
		} catch (ParseException e) {
			JOptionPane.showMessageDialog(null,"Formatter com problema");
		}
		TCpf.setBounds(220, 183, 145, 25);
		TCpf.setBorder(null);
		TCpf.setBackground(Color.decode("#cccccc"));
		add(TCpf);
		
		try {
			TData = new JFormattedTextField(new MaskFormatter("##/##/####"));
		} catch (ParseException e) {
			JOptionPane.showMessageDialog(null,"Formatter com problema");
		}
		TData.setBounds(220, 330, 110, 20);
		TData.setBorder(null);
		TData.setBackground(Color.decode("#cccccc"));
		add(TData);
		
		caixaDeTextoEnd();
	}
	
	public void caixaDeTextoEnd() {
		
		TRua = new JTextField();
		TRua.setBounds(470, 185, 200, 25);
		TRua.setBorder(null);
		TRua.setBackground(Color.decode("#cccccc"));
		add(TRua);
		
		TNumero = new JTextField();
		TNumero.setBounds(690, 183, 50, 25);
		TNumero.setBorder(null);
		TNumero.setBackground(Color.decode("#cccccc"));
		add(TNumero);
		
		try {
			TCep = new JFormattedTextField(new MaskFormatter("##.###-###"));
		} catch (ParseException e) {
			JOptionPane.showMessageDialog(null,"Formatter com problema");
		}
		TCep.setBounds(470, 260, 70, 25);
		TCep.setBorder(null);
		TCep.setBackground(Color.decode("#cccccc"));
		add(TCep);
		
		TCidade = new JTextField();
		TCidade.setBounds(595, 260, 110, 25);
		TCidade.setBorder(null);
		TCidade.setBackground(Color.decode("#cccccc"));
		add(TCidade);
		
		TPais = new JTextField();
		TPais.setBounds(725, 260, 110, 25);
		TPais.setBorder(null);
		TPais.setBackground(Color.decode("#cccccc"));
		add(TPais);
		
		TEstado = new JTextField();
		TEstado.setBounds(690, 330, 110, 25);
		TEstado.setBorder(null);
		TEstado.setBackground(Color.decode("#cccccc"));
		add(TEstado);
		
		TReferencia = new JTextField();
		TReferencia.setBounds(470, 330, 110, 25);
		TReferencia.setBorder(null);
		TReferencia.setBackground(Color.decode("#cccccc"));
		add(TReferencia);
	
		
	}
	
	public void separadoresEnd() {
		//rua
		separador = new JSeparator();
		separador.setBounds(470, 210,200, 3);
		separador.setForeground(Color.decode("#540c83"));
		separador.setBackground(Color.decode("#540c83"));
		add(separador);
		
		//cep
		separador = new JSeparator();
		separador.setBounds(470, 285, 70, 3);
		separador.setForeground(Color.decode("#540c83"));
		separador.setBackground(Color.decode("#540c83"));
		add(separador);
		//pontoR
		separador = new JSeparator();
		separador.setBounds(470, 355, 200, 3);
		separador.setForeground(Color.decode("#540c83"));
		separador.setBackground(Color.decode("#540c83"));
		add(separador);
		//num
		separador = new JSeparator();
		separador.setBounds(690, 210, 70, 3);
		separador.setForeground(Color.decode("#540c83"));
		separador.setBackground(Color.decode("#540c83"));
		add(separador);
		//cidade
		separador = new JSeparator();
		separador.setBounds(595, 285, 110, 3);
		separador.setForeground(Color.decode("#540c83"));
		separador.setBackground(Color.decode("#540c83"));
		add(separador);
		//pais
		separador = new JSeparator();
		separador.setBounds(725, 285, 100, 3);
		separador.setForeground(Color.decode("#540c83"));
		separador.setBackground(Color.decode("#540c83"));
		add(separador);
		//estado
		separador = new JSeparator();
		separador.setBounds(690,355, 110, 3);
		separador.setForeground(Color.decode("#540c83"));
		separador.setBackground(Color.decode("#540c83"));
		add(separador);
	}

	public void imagem() {
		label = new JLabel(new ImageIcon(getClass().getResource("colabs.png")));
		label.setBounds(120, 30, 172, 130);
		add(label);
		
		label2 = new JLabel(new ImageIcon(getClass().getResource("predio3.png")));
		label2.setBounds(530, 30, 172, 130);
		add(label2);
		
		
	}
	
	public void separadores() {
		separador = new JSeparator();
		separador.setBounds(50, 210, 145, 3);
		separador.setForeground(Color.decode("#540c83"));
		separador.setBackground(Color.decode("#540c83"));
		add(separador);
		
		separador = new JSeparator();
		separador.setBounds(50, 285, 330, 3);
		separador.setForeground(Color.decode("#540c83"));
		separador.setBackground(Color.decode("#540c83"));
		add(separador);
		
		separador = new JSeparator();
		separador.setBounds(50, 355, 100, 3);
		separador.setForeground(Color.decode("#540c83"));
		separador.setBackground(Color.decode("#540c83"));
		add(separador);
		
		separador = new JSeparator();
		separador.setBounds(220, 210, 155, 3);
		separador.setForeground(Color.decode("#540c83"));
		separador.setBackground(Color.decode("#540c83"));
		add(separador);
		
		separador = new JSeparator();
		separador.setBounds(220, 355, 75, 3);
		separador.setForeground(Color.decode("#540c83"));
		separador.setBackground(Color.decode("#540c83"));
		add(separador);
		
		separadoresEnd();
	}
	
	public void cadastrar() {
		cadastrar = new JButton("Cadastrar");
		cadastrar.setForeground(Color.WHITE);
		cadastrar.setBackground(Color.decode("#540c83"));
		cadastrar.setBounds(380, 440, 130, 25);
		cadastrar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				try{
					if(new Controlador().Cadastrar(TNome.getText(), TEmail.getText(),TTelefone.getText(), TCpf.getText(), getData(), gen,
							new Controlador().CriarEn(TRua.getText(), TNumero.getText(), TCep.getText(), TCidade.getText(),TEstado.getText(),TReferencia.getText(), TPais.getText()))) {
						JOptionPane.showMessageDialog(null,"Cadastrador com sucesso");
						dispose();
						new TelaDeCadastro();
					}
					else {
						JOptionPane.showMessageDialog(null,"Preencha os campos");
					}
					
				}catch(Exception e1){
					JOptionPane.showMessageDialog(null,e1.getMessage());
				}
				
			}
		});
		add(cadastrar);
		
		sair = new JButton(new ImageIcon(getClass().getResource("iconExit.png")));
		sair.setBounds(800, 445, 30, 30);
		sair.setBorder(null);
		sair.setOpaque(false);
		sair.setContentAreaFilled(false);
		sair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new TelaMenu();
			}
		});
		add(sair);
		
	}
	
	public void sexo() {
		m = new JRadioButton("Masculino");
		m.setBounds(110, 377, 100, 30);
		m.setBackground(Color.decode("#cccccc"));
		m.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gen = Sexo.MASCULINO;
			}
		});
		add(m);

		f = new JRadioButton("Feminino");
		f.setBounds(210, 377, 90, 30);
		f.setBackground(Color.decode("#cccccc"));
		f.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gen = Sexo.FEMININO;
			}
		});
		add(f);
		
		i = new JRadioButton("Indefinido");
		i.setBounds(300, 377, 100, 30);
		i.setBackground(Color.decode("#cccccc"));
		i.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gen = Sexo.INDEFINIDO;
			}
		});
		add(i);
		
		ButtonGroup grupo = new ButtonGroup();
		grupo.add(f);
		grupo.add(m);
		grupo.add(i);
	}
	
	public Date getData() {
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy"); 
		Date dataFormatada = null;
		try {
			dataFormatada = formato.parse(TData.getText());
		} catch (ParseException e) {
			JOptionPane.showMessageDialog(null,"verifique a data passada");
		} 
		return dataFormatada;
	}
	
	public JTextField getTNome() {
		return TNome;
	}
	public void setTNome(JTextField tNome) {
		TNome = tNome;
	}
	
	public JTextField getTEmail() {
		return TEmail;
	}
	public void setTEmail(JTextField tEmail) {
		TEmail = tEmail;
	}
	
	public JTextField getTTelefone() {
		return TTelefone;
	}
	public void setTTelefone(JTextField tTelefone) {
		TTelefone = tTelefone;
	}

	public JLabel getLabel() {
		return label;
	}
	public void setLabel(JLabel label) {
		this.label = label;
	}

	public JSeparator getSeparador() {
		return separador;
	}
	public void setSeparador(JSeparator separador) {
		this.separador = separador;
	}
	public JTextField getTCpf() {
		return TCpf;
	}
	public void setTCpf(JTextField tCpf) {
		TCpf = tCpf;
	}
	public JButton getCadastrar() {
		return cadastrar;
	}
	public void setCadastrar(JButton cadastrar) {
		this.cadastrar = cadastrar;
	}
	public JButton getSair() {
		return sair;
	}
	public void setSair(JButton sair) {
		this.sair = sair;
	}
	public JRadioButton getM() {
		return m;
	}

	public void setM(JRadioButton m) {
		this.m = m;
	}

	public JRadioButton getF() {
		return f;
	}

	public void setF(JRadioButton f) {
		this.f = f;
	}

	public JRadioButton getI() {
		return i;
	}

	public void setI(JRadioButton i) {
		this.i = i;
	}
	public Sexo getGen() {
		return gen;
	}

	public void setGen(Sexo gen) {
		this.gen = gen;
	}
	public JTextField getTSexo() {
		return TSexo;
	}
	public void setTSexo(JTextField tSexo) {
		TSexo = tSexo;
	}
	public JTextField getTData() {
		return TData;
	}
	public void setTData(JTextField tData) {
		TData = tData;
	}
	public JTextField getTRua() {
		return TRua;
	}

	public void setTRua(JTextField tRua) {
		TRua = tRua;
	}

	public JTextField getTNumero() {
		return TNumero;
	}

	public void setTNumero(JTextField tNumero) {
		TNumero = tNumero;
	}

	public JTextField getTCep() {
		return TCep;
	}

	public void setTCep(JTextField tCep) {
		TCep = tCep;
	}

	public JTextField getTCidade() {
		return TCidade;
	}

	public void setTCidade(JTextField tCidade) {
		TCidade = tCidade;
	}

	public JTextField getTEstado() {
		return TEstado;
	}

	public void setTEstado(JTextField tEstado) {
		TEstado = tEstado;
	}

	public JTextField getTReferencia() {
		return TReferencia;
	}

	public void setTReferencia(JTextField tReferencia) {
		TReferencia = tReferencia;
	}

	public JTextField getTPais() {
		return TPais;
	}

	public void setTPais(JTextField tPais) {
		TPais = tPais;
	}
}
