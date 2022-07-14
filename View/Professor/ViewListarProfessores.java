package View.Professor;

import Controller.ProfessorController;
import Model.Professor;
import App.PrincipalMain;
import java.awt.Color;

import java.util.ArrayList;
import static java.util.Objects.isNull;

import javax.swing.JDesktopPane;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ViewListarProfessores extends javax.swing.JInternalFrame {

	private final ProfessorController ac = new ProfessorController();
	private final PrincipalMain pa = new PrincipalMain();

	public ViewListarProfessores() {
		super();
		initComponents();
	}

	public void montarProfessores(ArrayList<Professor> aProfessores) {
		if (isNull(aProfessores)) {
			aProfessores = this.ac.consultarProfessores();
		}
		DefaultTableModel model = (DefaultTableModel) tableProfessores.getModel();
		model.setRowCount(0);
		if (!isNull(aProfessores) && !aProfessores.isEmpty()) {
			for (Professor aProfessor : aProfessores) {
				model.addRow(
						new Object[] { aProfessor.getNome(), aProfessor.getCodigoFuncionario(), aProfessor.getCpf() });
			}
		}

	}

	public void pesquisar(String editText) {
		if (editText.trim().isEmpty()) {
			editText = null;
		}
		montarProfessores(this.ac.consultarProfessorNome(editText));
	}

	public void editar(int matricula) {
		ViewEditarProfessor va = new ViewEditarProfessor(this);
		va.setVisible(true);
		JDesktopPane desk = super.getDesktopPane();
		va.montarProfessor(matricula);
		desk.add(va);
		this.setVisible(false);
	}

	private void initComponents() {

		EPesquisaNome = new javax.swing.JTextField();
		jButton1 = new javax.swing.JButton();
		jScrollPane1 = new javax.swing.JScrollPane();
		tableProfessores = new javax.swing.JTable();

		setClosable(true);
		setIconifiable(true);

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

		jButton1.setText("Editar");
		jButton1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton1ActionPerformed(evt);
			}
		});

		tableProfessores.setModel(new javax.swing.table.DefaultTableModel(new Object[][] {

		}, new String[] { "Nome", "Codigo", "CPF" }) {
			boolean[] canEdit = new boolean[] { false, false, false };

			public boolean isCellEditable(int rowIndex, int columnIndex) {
				return canEdit[columnIndex];
			}
		});

		jScrollPane1.setViewportView(tableProfessores);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addComponent(jScrollPane1)
				.addGroup(layout.createSequentialGroup()
						.addComponent(EPesquisaNome, javax.swing.GroupLayout.PREFERRED_SIZE, 324,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(jButton1,
								javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addContainerGap()
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(EPesquisaNome, javax.swing.GroupLayout.PREFERRED_SIZE, 34,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(4, 4, 4)
						.addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 312, Short.MAX_VALUE)));

		EPesquisaNome.getAccessibleContext().setAccessibleName("");
		EPesquisaNome.getAccessibleContext().setAccessibleDescription("Pesquisar");

		pack();
	}// </editor-fold>//GEN-END:initComponents

	private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton1ActionPerformed
		int row = tableProfessores.getSelectedRow();
		if (row >= 0) {
			DefaultTableModel model = (DefaultTableModel) tableProfessores.getModel();
			editar(Integer.parseInt(model.getValueAt(row, 1).toString()));
		} else {
			JOptionPane.showMessageDialog(null, "Selecione um professor");
		}

	}// GEN-LAST:event_jButton1ActionPerformed

	private void EPesquisaNomeKeyReleased(java.awt.event.KeyEvent evt) {// GEN-FIRST:event_EPesquisaNomeKeyReleased

		pesquisar(EPesquisaNome.getText());

	}// GEN-LAST:event_EPesquisaNomeKeyReleased

	private void EPesquisaNomeFocusGained(java.awt.event.FocusEvent evt) {// GEN-FIRST:event_EPesquisaNomeFocusGained
		if (EPesquisaNome.getText().equals("Pesquisar")) {
			EPesquisaNome.setText("");
			EPesquisaNome.setForeground(Color.BLACK);
		}
	}// GEN-LAST:event_EPesquisaNomeFocusGained

	private void EPesquisaNomeFocusLost(java.awt.event.FocusEvent evt) {// GEN-FIRST:event_EPesquisaNomeFocusLost
		if (EPesquisaNome.getText().isEmpty()) {
			EPesquisaNome.setForeground(Color.GRAY);
			EPesquisaNome.setText("Pesquisar");
		}
	}// GEN-LAST:event_EPesquisaNomeFocusLost

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JTextField EPesquisaNome;
	private javax.swing.JButton jButton1;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JTable tableProfessores;
	// End of variables declaration//GEN-END:variables
}
