package View.Sala;

import Controller.SalaController;
import Model.Sala;
import java.awt.Color;
import java.util.ArrayList;
import static java.util.Objects.isNull;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Héricles Martins
 */
public class ViewListarSalas extends javax.swing.JInternalFrame {

	private final SalaController sc = new SalaController();

	public ViewListarSalas() {
		initComponents();
	}

	public void montarSalas(ArrayList<Sala> aSalas) {
		DefaultTableModel model = (DefaultTableModel) tableSalas.getModel();
		model.setRowCount(0);
		if (isNull(aSalas)) {
			aSalas = this.sc.consultarSalas();
		}
		if (!isNull(aSalas)) {
			for (Sala aSala : aSalas) {
				model.addRow(new Object[] { aSala.getNome(), aSala.getCodigo(), aSala.getPredio(), aSala.getSala(),
						aSala.getCapacidade() });
			}
		}
	}

	public void pesquisar(String editText) {
		if (editText.trim().isEmpty()) {
			editText = null;
		}
		montarSalas(this.sc.consultarSalaNome(editText));
	}

	public void editar(int codigo) {
		ViewEditarSala ves = new ViewEditarSala(this);
		ves.setVisible(true);
		JDesktopPane desk = super.getDesktopPane();
		ves.montarSala(codigo);
		desk.add(ves);
		this.setVisible(false);
	}

	private void initComponents() {

		EPesquisaNome = new javax.swing.JTextField();
		jScrollPane1 = new javax.swing.JScrollPane();
		tableSalas = new javax.swing.JTable();
		jButton1 = new javax.swing.JButton();

		setClosable(true);

		EPesquisaNome.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
		EPesquisaNome.setForeground(java.awt.Color.gray);
		EPesquisaNome.setText("Pesquisar");
		EPesquisaNome.addFocusListener(new java.awt.event.FocusAdapter() {
			public void focusGained(java.awt.event.FocusEvent evt) {
				EPesquisaNomeFocusGained(evt);
			}

			public void focusLost(java.awt.event.FocusEvent evt) {
				EPesquisaNomeFocusLost(evt);
			}
		});

		EPesquisaNome.addKeyListener(new java.awt.event.KeyAdapter() {
			public void keyReleased(java.awt.event.KeyEvent evt) {
				EPesquisaNomeKeyReleased(evt);
			}
		});

		tableSalas.setModel(new javax.swing.table.DefaultTableModel(new Object[][] {

		}, new String[] { "Nome", "Codigo", "Predio", "Sala", "Capacidade" }) {
			boolean[] canEdit = new boolean[] { false, false, false, false, false };

			public boolean isCellEditable(int rowIndex, int columnIndex) {
				return canEdit[columnIndex];
			}
		});

		jScrollPane1.setViewportView(tableSalas);

		jButton1.setText("Editar");
		jButton1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton1ActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
						layout.createSequentialGroup()
								.addComponent(EPesquisaNome, javax.swing.GroupLayout.PREFERRED_SIZE, 225,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 236,
										javax.swing.GroupLayout.PREFERRED_SIZE))
				.addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 600,
						javax.swing.GroupLayout.PREFERRED_SIZE));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addContainerGap()
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(EPesquisaNome, javax.swing.GroupLayout.PREFERRED_SIZE, 34,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 307, Short.MAX_VALUE)));

		pack();
	}

	private void EPesquisaNomeKeyReleased(java.awt.event.KeyEvent evt) {
		pesquisar(EPesquisaNome.getText());
	}

	private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
		int row = tableSalas.getSelectedRow();
		if (row >= 0) {
			DefaultTableModel model = (DefaultTableModel) tableSalas.getModel();
			editar(Integer.parseInt(model.getValueAt(row, 1).toString()));
		} else {
			JOptionPane.showMessageDialog(null, "Selecione uma sala");
		}

	}

	private void EPesquisaNomeFocusGained(java.awt.event.FocusEvent evt) {
		if (EPesquisaNome.getText().equals("Pesquisar")) {
			EPesquisaNome.setText("");
			EPesquisaNome.setForeground(Color.BLACK);
		}
	}

	private void EPesquisaNomeFocusLost(java.awt.event.FocusEvent evt) {
		if (EPesquisaNome.getText().isEmpty()) {
			EPesquisaNome.setForeground(Color.GRAY);
			EPesquisaNome.setText("Pesquisar");
		}
	}

	private javax.swing.JTextField EPesquisaNome;
	private javax.swing.JButton jButton1;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JTable tableSalas;

}
