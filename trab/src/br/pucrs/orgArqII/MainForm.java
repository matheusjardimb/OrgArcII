package br.pucrs.orgArqII;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;

import br.pucrs.orgArqII.MIPS.Command;
import br.pucrs.orgArqII.MIPS.MIPS;
import br.pucrs.orgArqII.Utils.SourceReader;

public class MainForm extends javax.swing.JFrame {

	private static final long serialVersionUID = 1L;
	private MIPS mips;

	public MainForm() {
		initComponents();
	}

	private void initComponents() {
		jLabel1 = new javax.swing.JLabel();
		jScrollPane1 = new javax.swing.JScrollPane();
		jRegs = new javax.swing.JTable();
		jLabel2 = new javax.swing.JLabel();
		jScrollPane2 = new javax.swing.JScrollPane();
		jCommands = new javax.swing.JList();
		jProximo = new javax.swing.JButton();
		jSair = new javax.swing.JButton();
		jReiniciar = new javax.swing.JButton();
		jScrollPane3 = new javax.swing.JScrollPane();
		jStatus = new javax.swing.JTable();
		jLabel3 = new javax.swing.JLabel();
		jButton4 = new javax.swing.JButton();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		jLabel1.setText("Banco de registradores");

		jRegs.setModel(new javax.swing.table.DefaultTableModel(new Object[][] {}, new String[] { "Reg", "Valor" }) {
			boolean[] canEdit = new boolean[] { false, false };

			public boolean isCellEditable(int rowIndex, int columnIndex) {
				return canEdit[columnIndex];
			}
		});
		jScrollPane1.setViewportView(jRegs);

		jLabel2.setText("Comandos");

		jCommands.setRequestFocusEnabled(false);// Unclickable!
		jScrollPane2.setViewportView(jCommands);

		jProximo.setText("Próximo");
		jProximo.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton1ActionPerformed(evt);
			}
		});

		jSair.setText("Sair");
		jSair.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton2ActionPerformed(evt);
			}
		});

		jReiniciar.setText("Reiniciar");
		jReiniciar.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton3ActionPerformed(evt);
			}
		});

		jStatus.setModel(new javax.swing.table.DefaultTableModel(new Object[][] {}, new String[] { "Busca",
				"Decodificação", "Execução", "Memória", "Write Back" }) {
			boolean[] canEdit = new boolean[] { false, false, false, false, false };

			public boolean isCellEditable(int rowIndex, int columnIndex) {
				return canEdit[columnIndex];
			}
		});
		jScrollPane3.setViewportView(jStatus);

		jLabel3.setText("Estado atual");

		jButton4.setText("Arquivo");
		jButton4.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton4ActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						layout.createSequentialGroup()
								.addContainerGap()
								.addGroup(
										layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
												.addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING,
														0, 0, Short.MAX_VALUE)
												.addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(
										layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
												.addGroup(
														layout.createSequentialGroup()
																.addComponent(jButton4)
																.addPreferredGap(
																		javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																.addComponent(jReiniciar)
																.addGap(7, 7, 7)
																.addComponent(jProximo)
																.addGap(6, 6, 6)
																.addComponent(jSair,
																		javax.swing.GroupLayout.PREFERRED_SIZE, 69,
																		javax.swing.GroupLayout.PREFERRED_SIZE))
												.addGroup(
														layout.createSequentialGroup()
																.addGroup(
																		layout.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.LEADING)
																				.addGroup(
																						javax.swing.GroupLayout.Alignment.TRAILING,
																						layout.createSequentialGroup()
																								.addComponent(
																										jScrollPane2,
																										javax.swing.GroupLayout.PREFERRED_SIZE,
																										176,
																										javax.swing.GroupLayout.PREFERRED_SIZE)
																								.addPreferredGap(
																										javax.swing.LayoutStyle.ComponentPlacement.RELATED))
																				.addGroup(
																						layout.createSequentialGroup()
																								.addComponent(jLabel2)
																								.addGap(108, 108, 108)))
																.addGroup(
																		layout.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.LEADING)
																				.addComponent(jLabel3)
																				.addComponent(
																						jScrollPane3,
																						javax.swing.GroupLayout.PREFERRED_SIZE,
																						javax.swing.GroupLayout.DEFAULT_SIZE,
																						javax.swing.GroupLayout.PREFERRED_SIZE))))
								.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				layout.createSequentialGroup()
						.addContainerGap()
						.addGroup(
								layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
										.addComponent(jLabel1).addComponent(jLabel2).addComponent(jLabel3))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(
								layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
										.addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(jScrollPane2)
										.addComponent(jScrollPane1))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(
								layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
										.addComponent(jProximo).addComponent(jReiniciar).addComponent(jSair)
										.addComponent(jButton4))
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

		pack();
	}

	private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
		System.exit(0);
	}

	private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
		this.mips.next();
	}

	private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {
		System.out.println("2");
	}

	private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {
		JFileChooser jFileChooser = new JFileChooser();
		jFileChooser.showOpenDialog(this);
		this.mips = new MIPS(SourceReader.readFile(jFileChooser.getSelectedFile().getPath()));
		DefaultListModel defaultListModel = new DefaultListModel();
		for (Command c : this.mips.getCommands()) {
			defaultListModel.addElement(c);
		}
		this.jCommands.setModel(defaultListModel);
	}

	public static void main(String args[]) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new MainForm().setVisible(true);
			}
		});
	}

	// UI elements
	private javax.swing.JButton jProximo;
	private javax.swing.JButton jSair;
	private javax.swing.JButton jReiniciar;
	private javax.swing.JButton jButton4;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JList jCommands;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JScrollPane jScrollPane2;
	private javax.swing.JScrollPane jScrollPane3;
	private javax.swing.JTable jRegs;
	private javax.swing.JTable jStatus;
}
