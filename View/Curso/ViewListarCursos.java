package View.Curso;

import Controller.AlunoCursoController;
import Controller.CursoController;
import Model.Aluno;
import Model.Curso;
import View.Aluno.ViewListarAlunos;
import java.awt.Color;
import java.util.ArrayList;
import static java.util.Objects.isNull;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ViewListarCursos extends javax.swing.JInternalFrame {

	private final CursoController cc = new CursoController();
	private final AlunoCursoController acc = new AlunoCursoController();
	private JInternalFrame chamador;

	public ViewListarCursos(JInternalFrame chamador) {
		initComponents();
		this.chamador = chamador;
	}

	public void montarCursos(ArrayList<Curso> aCursos) {
		DefaultTableModel model = (DefaultTableModel) tableCursos.getModel();
		model.setRowCount(0);
		if (isNull(aCursos)) {
			aCursos = cc.consultarCursos(selecoesRadioButton());
		}
		if (!isNull(aCursos) && !aCursos.isEmpty()) {
			for (Curso aCurso : aCursos) {
				model.addRow(new Object[] { aCurso.getNome(), aCurso.getCodigo(), aCurso.getSala().getPredio(),
						aCurso.getSala().getSala(), aCurso.getProfessor().getNome(),
						aCurso.getStatus() ? "Ativo" : "Inativo", aCurso.getStatus() });
			}
		} else {
			JOptionPane.showMessageDialog(null, "NÃo existe cursos cadastrados nos parametros desejados");
		}
	}

	private void pesquisar(String editText) {
		if (editText.trim().isEmpty()) {
			editText = null;
		}
		Boolean status = selecoesRadioButton();
		montarCursos(this.cc.consultarCursoNome(editText, status));
	}

	private void editar(int codigo) {
		ViewEditarCurso vec = new ViewEditarCurso(this);
		vec.setVisible(true);
		JDesktopPane desk = super.getDesktopPane();
		vec.montarCurso(codigo);
		desk.add(vec);
		this.setVisible(false);
	}

	private Boolean selecoesRadioButton() {
		if (rAtivos.isSelected()) {
			return true;
		} else if (rInativos.isSelected()) {
			return false;
		} else {
			return null;
		}
	}

	private void buscarAlunosCurso() {
		int row = tableCursos.getSelectedRow();
		if (row >= 0) {
			DefaultTableModel model = (DefaultTableModel) tableCursos.getModel();
			int codigoCurso = Integer.parseInt(model.getValueAt(row, 1).toString());
			Curso curso = cc.consultarCursoCodigo(codigoCurso);
			ArrayList<Aluno> aAlunos = acc.buscarAlunosCurso(curso);
			if (!aAlunos.isEmpty()) {
				ViewListarAlunos vla = new ViewListarAlunos(this);
				vla.montarAlunos(aAlunos);
				vla.setVisible(true);
				JDesktopPane desk = super.getDesktopPane();
				desk.add(vla);
				this.setVisible(false);
			} else {
				JOptionPane.showMessageDialog(null, "Curso sem nenhum Aluno");
			}
		} else {
			JOptionPane.showMessageDialog(null, "Selecione um curso");
		}
	}

	private void abrirUltimoEFecharAtual() {
		if (!isNull(chamador)) {
			chamador.setVisible(true);
		}
		this.dispose();
	}

	
	private void initComponents() {

		radioGroup = new javax.swing.ButtonGroup();
		EPesquisaNome = new javax.swing.JTextField();
		jScrollPane1 = new javax.swing.JScrollPane();
		tableCursos = new javax.swing.JTable();
		jButton1 = new javax.swing.JButton();
		rInativos = new javax.swing.JRadioButton();
		rAtivos = new javax.swing.JRadioButton();
		rTodos = new javax.swing.JRadioButton();
		jLabel1 = new javax.swing.JLabel();
		jButton2 = new javax.swing.JButton();

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

		tableCursos.setModel(new javax.swing.table.DefaultTableModel(new Object[][] {

		}, new String[] { "Nome", "Codigo curso", "Predio", "Sala", "Professor", "Situacao" }) {
			boolean[] canEdit = new boolean[] { false, false, true, false, false, false };

			public boolean isCellEditable(int rowIndex, int columnIndex) {
				return canEdit[columnIndex];
			}
		});

		jScrollPane1.setViewportView(tableCursos);

		jButton1.setText("Editar");
		jButton1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton1ActionPerformed(evt);
			}
		});

		radioGroup.add(rInativos);
		rInativos.setText("Inativos");
		rInativos.addItemListener(new java.awt.event.ItemListener() {
			public void itemStateChanged(java.awt.event.ItemEvent evt) {
				rInativosItemStateChanged(evt);
			}
		});

		radioGroup.add(rAtivos);
		rAtivos.setText("Ativos");
		rAtivos.addItemListener(new java.awt.event.ItemListener() {
			public void itemStateChanged(java.awt.event.ItemEvent evt) {
				rAtivosItemStateChanged(evt);
			}
		});

		radioGroup.add(rTodos);
		rTodos.setSelected(true);
		rTodos.setText("Todos");
		rTodos.addItemListener(new java.awt.event.ItemListener() {
			public void itemStateChanged(java.awt.event.ItemEvent evt) {
				rTodosItemStateChanged(evt);
			}
		});

		jLabel1.setText("Situação dos cursos");

		jButton2.setText("Turma");
		jButton2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton2ActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
						layout.createSequentialGroup()
								.addComponent(EPesquisaNome, javax.swing.GroupLayout.PREFERRED_SIZE, 225,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addGroup(layout.createSequentialGroup()
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
												.addComponent(rTodos)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
												.addComponent(rAtivos)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
														javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(rInativos)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
										.addGroup(layout.createSequentialGroup().addGap(45, 45, 45)
												.addComponent(jLabel1)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
														javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
										.addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 161,
												Short.MAX_VALUE)
										.addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
						layout.createSequentialGroup().addGap(0, 0, Short.MAX_VALUE).addComponent(jScrollPane1,
								javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout
				.createSequentialGroup()
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout
						.createSequentialGroup().addContainerGap()
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
								.addComponent(jLabel1).addComponent(jButton2))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(rAtivos).addComponent(rInativos)
								.addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(rTodos)))
						.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
								layout.createSequentialGroup().addGap(0, 0, Short.MAX_VALUE).addComponent(EPesquisaNome,
										javax.swing.GroupLayout.PREFERRED_SIZE, 34,
										javax.swing.GroupLayout.PREFERRED_SIZE)))
				.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
				.addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 267, Short.MAX_VALUE)));

		pack();
	}// </editor-fold>//GEN-END:initComponents

	private void EPesquisaNomeKeyReleased(java.awt.event.KeyEvent evt) {// GEN-FIRST:event_EPesquisaNomeKeyReleased
		pesquisar(EPesquisaNome.getText());
	}// GEN-LAST:event_EPesquisaNomeKeyReleased

	private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton1ActionPerformed
		int row = tableCursos.getSelectedRow();
		if (row >= 0) {
			DefaultTableModel model = (DefaultTableModel) tableCursos.getModel();
			editar(Integer.parseInt(model.getValueAt(row, 1).toString()));
		} else {
			JOptionPane.showMessageDialog(null, "Selecione um curso");
		}
	}// GEN-LAST:event_jButton1ActionPerformed

	private void rTodosItemStateChanged(java.awt.event.ItemEvent evt) {// GEN-FIRST:event_rTodosItemStateChanged
		pesquisar(EPesquisaNome.getText());
	}

	private void rAtivosItemStateChanged(java.awt.event.ItemEvent evt) {// GEN-FIRST:event_rAtivosItemStateChanged
		pesquisar(EPesquisaNome.getText());
	}// GEN-LAST:event_rAtivosItemStateChanged

	private void rInativosItemStateChanged(java.awt.event.ItemEvent evt) {// GEN-FIRST:event_rInativosItemStateChanged
		pesquisar(EPesquisaNome.getText());
	}// GEN-LAST:event_rInativosItemStateChanged

	private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton2ActionPerformed
		buscarAlunosCurso();
	}// GEN-LAST:event_jButton2ActionPerformed

	private void formInternalFrameClosing(javax.swing.event.InternalFrameEvent evt) {// GEN-FIRST:event_formInternalFrameClosing
		abrirUltimoEFecharAtual();
	}// GEN-LAST:event_formInternalFrameClosing

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
	private javax.swing.JButton jButton2;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JRadioButton rAtivos;
	private javax.swing.JRadioButton rInativos;
	private javax.swing.JRadioButton rTodos;
	private javax.swing.ButtonGroup radioGroup;
	private javax.swing.JTable tableCursos;
	// End of variables declaration//GEN-END:variables
}
