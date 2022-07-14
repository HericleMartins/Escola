package View.Professor;

import Controller.ProfessorController;
import static Funcoes.FuncoesAuxiliares.passarParaNumero;
import static Funcoes.FuncoesAuxiliares.validarUf;
import static java.util.Objects.isNull;

import Model.Professor;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;

public class ViewEditarProfessor extends javax.swing.JInternalFrame {

	private ProfessorController pc = new ProfessorController();
	private Professor professor = new Professor();
	private JInternalFrame chamador;

	public ViewEditarProfessor(JInternalFrame chamador) {
		initComponents();
		this.chamador = chamador;
	}

	public void montarProfessor(int codigoFuncionario) {
		this.professor = this.pc.consultarProfessorCodigoFuncionario(codigoFuncionario);
		eCodigoFuncionarioProfessor.setText(String.valueOf(professor.getCodigoFuncionario()));
		eNomeProfessor.setText(professor.getNome());
		eCpfProfessor.setText(String.valueOf(professor.getCpf()));
		eCelularProfessor.setText(String.valueOf(professor.getCelular()));
		eEmailProfessor.setText(professor.getEmail());
		eLogradouroProfessor.setText(professor.getLogradouro());
		eComplementoProfessor.setText(professor.getComplemento());
		eNumeroProfessor.setText(String.valueOf(professor.getNumero()));
		eCidadeProfessor.setText(professor.getCidade());
		eBairroProfessor.setText(professor.getBairro());
		eEstadoProfessor.setText(professor.getEstado());
	}

	public void alterarProfessor() {
		this.professor.setCodigoFuncionario(eCodigoFuncionarioProfessor.getText().trim().isEmpty() ? null: Integer.parseInt(eCodigoFuncionarioProfessor.getText()));
		this.professor.setNome(eNomeProfessor.getText().trim().isEmpty() ? null : eNomeProfessor.getText());
		this.professor.setCpf(eCpfProfessor.getText().trim().isEmpty() ? null : Long.parseLong(eCpfProfessor.getText()));
		this.professor.setCelular(eCelularProfessor.getText().trim().isEmpty() ? null : Long.parseLong(eCelularProfessor.getText()));
		this.professor.setEmail(eEmailProfessor.getText().trim().isEmpty() ? null : eEmailProfessor.getText());
		this.professor.setLogradouro(eLogradouroProfessor.getText().trim().isEmpty() ? null : eLogradouroProfessor.getText());
		this.professor.setComplemento(eComplementoProfessor.getText());
		this.professor.setNumero(eNumeroProfessor.getText().trim().isEmpty() ? null : Integer.parseInt(eNumeroProfessor.getText()));
		this.professor.setCidade(eCidadeProfessor.getText().trim().isEmpty() ? null : eCidadeProfessor.getText());
		this.professor.setBairro(eBairroProfessor.getText().trim().isEmpty() ? null : eBairroProfessor.getText());
		this.professor.setEstado(eEstadoProfessor.getText().trim().isEmpty() ? null : eEstadoProfessor.getText());
		String campos = this.pc.validarCamposProfessor(this.professor);
		if (isNull(campos)) {
			if (this.pc.alterarProfessor(professor)) {
				JOptionPane.showMessageDialog(null, "Professor alterado com sucesso");
				abrirUltimoEFecharAtual();
			} else {
				JOptionPane.showMessageDialog(null, "Não foi possivel alterar o professor");
			}
		} else {
			JOptionPane.showMessageDialog(null, "Campos necessarios não preenchidos\n" + campos);

		}
	}

	private void abrirUltimoEFecharAtual() {
		if (!isNull(chamador)) {
			chamador.setVisible(true);
		}
		this.dispose();
	}

	private void initComponents() {

		jLabel1 = new javax.swing.JLabel();
		eCodigoFuncionarioProfessor = new javax.swing.JTextField();
		jLabel3 = new javax.swing.JLabel();
		eEmailProfessor = new javax.swing.JTextField();
		jLabel2 = new javax.swing.JLabel();
		eNomeProfessor = new javax.swing.JTextField();
		jLabel4 = new javax.swing.JLabel();
		eCpfProfessor = new javax.swing.JTextField();
		eCelularProfessor = new javax.swing.JTextField();
		jLabel5 = new javax.swing.JLabel();
		eLogradouroProfessor = new javax.swing.JTextField();
		jLabel6 = new javax.swing.JLabel();
		eComplementoProfessor = new javax.swing.JTextField();
		Complemento = new javax.swing.JLabel();
		eCidadeProfessor = new javax.swing.JTextField();
		jLabel8 = new javax.swing.JLabel();
		jLabel9 = new javax.swing.JLabel();
		eBairroProfessor = new javax.swing.JTextField();
		jLabel10 = new javax.swing.JLabel();
		eEstadoProfessor = new javax.swing.JTextField();
		jButton2 = new javax.swing.JButton();
		jButton3 = new javax.swing.JButton();
		eNumeroProfessor = new javax.swing.JTextField();
		eNumeroAlu = new javax.swing.JLabel();

		setClosable(true);

		jLabel1.setText("Codigo funcionario:");

		eCodigoFuncionarioProfessor.setEditable(false);
		eCodigoFuncionarioProfessor.setEnabled(false);
		eCodigoFuncionarioProfessor.addKeyListener(new java.awt.event.KeyAdapter() {
			public void keyReleased(java.awt.event.KeyEvent evt) {
				eCodigoFuncionarioProfessorKeyReleased(evt);
			}
		});

		jLabel3.setText("Nome:");

		jLabel2.setText("Email:");

		jLabel4.setText("CPF:");

		eCpfProfessor.addKeyListener(new java.awt.event.KeyAdapter() {
			public void keyReleased(java.awt.event.KeyEvent evt) {
				eCpfProfessorKeyReleased(evt);
			}
		});

		eCelularProfessor.addKeyListener(new java.awt.event.KeyAdapter() {
			public void keyReleased(java.awt.event.KeyEvent evt) {
				eCelularProfessorKeyReleased(evt);
			}
		});

		jLabel5.setText("Celular:");

		jLabel6.setText("Logradouro:");

		Complemento.setText("Complemento:");

		jLabel8.setText("Cidade:");

		jLabel9.setText("Bairro:");

		jLabel10.setText("Estado");

		eEstadoProfessor.addKeyListener(new java.awt.event.KeyAdapter() {
			public void keyReleased(java.awt.event.KeyEvent evt) {
				eEstadoProfessorKeyReleased(evt);
			}
		});

		jButton2.setText("Salvar");
		jButton2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton2ActionPerformed(evt);
			}
		});

		jButton3.setText("Cancelar");
		jButton3.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton3ActionPerformed(evt);
			}
		});

		eNumeroProfessor.addKeyListener(new java.awt.event.KeyAdapter() {
			public void keyReleased(java.awt.event.KeyEvent evt) {
				eNumeroProfessorKeyReleased(evt);
			}
		});

		eNumeroAlu.setText("NÂº");

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout
				.createSequentialGroup().addContainerGap()
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout
						.createSequentialGroup()
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
								.addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
										.addComponent(jLabel10)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
												javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(eEstadoProfessor, javax.swing.GroupLayout.PREFERRED_SIZE, 145,
												javax.swing.GroupLayout.PREFERRED_SIZE))
								.addGroup(javax.swing.GroupLayout.Alignment.LEADING,
										layout.createSequentialGroup().addComponent(jLabel8)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
														javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(eCidadeProfessor, javax.swing.GroupLayout.PREFERRED_SIZE,
														145, javax.swing.GroupLayout.PREFERRED_SIZE))
								.addGroup(javax.swing.GroupLayout.Alignment.LEADING,
										layout.createSequentialGroup().addComponent(Complemento)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38,
														Short.MAX_VALUE)
												.addComponent(eComplementoProfessor,
														javax.swing.GroupLayout.PREFERRED_SIZE, 145,
														javax.swing.GroupLayout.PREFERRED_SIZE))
								.addGroup(layout.createSequentialGroup()
										.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
												.addComponent(jLabel5).addComponent(jLabel1,
														javax.swing.GroupLayout.PREFERRED_SIZE, 112,
														javax.swing.GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
												javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addGroup(layout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
												.addComponent(eCelularProfessor, javax.swing.GroupLayout.DEFAULT_SIZE,
														145, Short.MAX_VALUE)
												.addComponent(eCodigoFuncionarioProfessor))))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(layout.createSequentialGroup()
										.addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 60,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33,
												Short.MAX_VALUE)
										.addComponent(eNomeProfessor, javax.swing.GroupLayout.PREFERRED_SIZE, 183,
												javax.swing.GroupLayout.PREFERRED_SIZE))
								.addGroup(layout.createSequentialGroup()
										.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
												.addComponent(jLabel6).addComponent(eNumeroAlu).addComponent(jLabel9))
										.addGap(28, 28, 28)
										.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
												.addComponent(eBairroProfessor).addComponent(eNumeroProfessor)
												.addComponent(eLogradouroProfessor)))))
						.addGroup(layout.createSequentialGroup().addGroup(layout
								.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
								.addGroup(layout.createSequentialGroup().addGap(118, 118, 118).addComponent(
										eEmailProfessor, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE))
								.addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING))
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(jLabel4)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(eCpfProfessor, javax.swing.GroupLayout.PREFERRED_SIZE, 183,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
								layout.createSequentialGroup().addGap(0, 0, Short.MAX_VALUE).addComponent(jButton2)
										.addGap(84, 84, 84).addComponent(jButton3).addGap(153, 153, 153)))
				.addContainerGap()));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addGap(15, 15, 15)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 27,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(eCodigoFuncionarioProfessor, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 27,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(eNomeProfessor, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jLabel2)
								.addComponent(eEmailProfessor, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(jLabel4)
								.addComponent(eCpfProfessor, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jLabel5)
								.addComponent(eCelularProfessor, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(jLabel6)
								.addComponent(eLogradouroProfessor, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(Complemento)
								.addComponent(eComplementoProfessor, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(eNumeroAlu)
								.addComponent(eNumeroProfessor, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jLabel8)
								.addComponent(eCidadeProfessor, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(jLabel9)
								.addComponent(eBairroProfessor, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jLabel10).addComponent(eEstadoProfessor,
										javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(18, 18, 18)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jButton2).addComponent(jButton3))
						.addContainerGap(18, Short.MAX_VALUE)));

		pack();
	}// </editor-fold>//GEN-END:initComponents

	private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton3ActionPerformed
		JOptionPane.showMessageDialog(null, "Professor nÃ£o alterado");
		abrirUltimoEFecharAtual();

	}// GEN-LAST:event_jButton3ActionPerformed

	private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton2ActionPerformed
		alterarProfessor();

	}// GEN-LAST:event_jButton2ActionPerformed

	private void eCodigoFuncionarioProfessorKeyReleased(java.awt.event.KeyEvent evt) {// GEN-FIRST:event_eCodigoFuncionarioProfessorKeyReleased
		eCodigoFuncionarioProfessor.setText(passarParaNumero(eCodigoFuncionarioProfessor.getText(), false));
	}// GEN-LAST:event_eCodigoFuncionarioProfessorKeyReleased

	private void eCpfProfessorKeyReleased(java.awt.event.KeyEvent evt) {// GEN-FIRST:event_eCpfProfessorKeyReleased
		eCpfProfessor.setText(passarParaNumero(eCpfProfessor.getText(), false));
	}// GEN-LAST:event_eCpfProfessorKeyReleased

	private void eCelularProfessorKeyReleased(java.awt.event.KeyEvent evt) {// GEN-FIRST:event_eCelularProfessorKeyReleased
		eCelularProfessor.setText(passarParaNumero(eCelularProfessor.getText(), false));
	}// GEN-LAST:event_eCelularProfessorKeyReleased

	private void eNumeroProfessorKeyReleased(java.awt.event.KeyEvent evt) {// GEN-FIRST:event_eNumeroProfessorKeyReleased
		eNumeroProfessor.setText(passarParaNumero(eNumeroProfessor.getText(), false));
	}// GEN-LAST:event_eNumeroProfessorKeyReleased

	private void eEstadoProfessorKeyReleased(java.awt.event.KeyEvent evt) {// GEN-FIRST:event_eEstadoProfessorKeyReleased
		eEstadoProfessor.setText(validarUf(eEstadoProfessor.getText()));
	}// GEN-LAST:event_eEstadoProfessorKeyReleased

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JLabel Complemento;
	private javax.swing.JTextField eBairroProfessor;
	private javax.swing.JTextField eCelularProfessor;
	private javax.swing.JTextField eCidadeProfessor;
	private javax.swing.JTextField eCodigoFuncionarioProfessor;
	private javax.swing.JTextField eComplementoProfessor;
	private javax.swing.JTextField eCpfProfessor;
	private javax.swing.JTextField eEmailProfessor;
	private javax.swing.JTextField eEstadoProfessor;
	private javax.swing.JTextField eLogradouroProfessor;
	private javax.swing.JTextField eNomeProfessor;
	private javax.swing.JLabel eNumeroAlu;
	private javax.swing.JTextField eNumeroProfessor;
	private javax.swing.JButton jButton2;
	private javax.swing.JButton jButton3;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel10;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JLabel jLabel5;
	private javax.swing.JLabel jLabel6;
	private javax.swing.JLabel jLabel8;
	private javax.swing.JLabel jLabel9;
	// End of variables declaration//GEN-END:variables
}
