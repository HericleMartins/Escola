package View.Aluno;

import Controller.AlunoController;
import static Funcoes.FuncoesAuxiliares.passarParaNumero;
import Model.Aluno;
import static java.util.Objects.isNull;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;

/**
 * Classe para responsavel pelo formulario de edição dos alunos
 * 
 * @author HÃ©ricles Martins
 */
public class ViewEditarAluno extends javax.swing.JInternalFrame {

	private AlunoController ac = new AlunoController();
	private Aluno aluno = new Aluno();
	public JInternalFrame chamador;

	public ViewEditarAluno(JInternalFrame chamador) {
		initComponents();
		this.chamador = chamador;
	}

	/**
	 * Função que monta o aluno no formulario
	 * 
	 * @param matricula
	 */
	public void montarAluno(int matricula) {
		this.aluno = this.ac.consultarAlunoMatricula(matricula);
		eMatriculaAluno.setText(String.valueOf(this.aluno.getMatricula()));
		eNomeAluno.setText(this.aluno.getNome());
		eCpfAluno.setText(String.valueOf(this.aluno.getCpf()));
		eCelularAluno.setText(String.valueOf(this.aluno.getCelular()));
		eEmailAluno.setText(this.aluno.getEmail());
		eLogradouroAluno.setText(this.aluno.getLogradouro());
		eComplementoAluno.setText(this.aluno.getComplemento());
		eNumeroAluno.setText(String.valueOf(this.aluno.getNumero()));
		eCidadeAluno.setText(this.aluno.getCidade());
		eBairroAluno.setText(this.aluno.getBairro());
		eEstadoAluno.setText(this.aluno.getEstado());
	}

	/**
	 * Função para realizar as alteraÃ§Ãµes do aluno
	 */
	public void alterarAluno() {
		this.aluno.setMatricula(eMatriculaAluno.getText().trim().isEmpty() ? null : Integer.parseInt(eMatriculaAluno.getText()));
		this.aluno.setNome(eNomeAluno.getText().trim().isEmpty() ? null : eNomeAluno.getText());
		this.aluno.setCpf(eCpfAluno.getText().trim().isEmpty() ? null : Long.parseLong(eCpfAluno.getText()));
		this.aluno.setCelular(eCelularAluno.getText().trim().isEmpty() ? null : Long.parseLong(eCelularAluno.getText()));
		this.aluno.setEmail(eEmailAluno.getText().trim().isEmpty() ? null : eEmailAluno.getText());
		this.aluno.setLogradouro(eLogradouroAluno.getText().trim().isEmpty() ? null : eLogradouroAluno.getText());
		this.aluno.setComplemento(eComplementoAluno.getText());
		this.aluno.setNumero(eNumeroAluno.getText().trim().isEmpty() ? null : Integer.parseInt(eNumeroAluno.getText()));
		this.aluno.setCidade(eCidadeAluno.getText().trim().isEmpty() ? null : eCidadeAluno.getText());
		this.aluno.setBairro(eBairroAluno.getText().trim().isEmpty() ? null : eBairroAluno.getText());
		this.aluno.setEstado(eEstadoAluno.getText().trim().isEmpty() ? null : eEstadoAluno.getText());
		String campos = this.ac.validarCamposAluno(aluno);
		if (isNull(campos)) {
			if (this.ac.alterarAluno(this.aluno)) {
				JOptionPane.showMessageDialog(null, "Aluno alterado com sucesso");
				abrirUltimoEFecharAtual();
			} else {
				JOptionPane.showMessageDialog(null, "Não foi possivel alterar o aluno");
			}
		} else {
			JOptionPane.showMessageDialog(null, "Campos necessarios não preenchidos\n" + campos);
		}
	}

	/**
	 * Função para abrir o formulario que chamou esse
	 */
	public void abrirUltimoEFecharAtual() {
		if (!isNull(this.chamador)) {
			this.chamador.setVisible(true);
		}
		this.dispose();
	}

	private void initComponents() {

		jLabel1 = new javax.swing.JLabel();
		eMatriculaAluno = new javax.swing.JTextField();
		jLabel3 = new javax.swing.JLabel();
		eEmailAluno = new javax.swing.JTextField();
		jLabel2 = new javax.swing.JLabel();
		eNomeAluno = new javax.swing.JTextField();
		jLabel4 = new javax.swing.JLabel();
		eCpfAluno = new javax.swing.JTextField();
		eCelularAluno = new javax.swing.JTextField();
		jLabel5 = new javax.swing.JLabel();
		eLogradouroAluno = new javax.swing.JTextField();
		jLabel6 = new javax.swing.JLabel();
		eComplementoAluno = new javax.swing.JTextField();
		Complemento = new javax.swing.JLabel();
		eCidadeAluno = new javax.swing.JTextField();
		jLabel8 = new javax.swing.JLabel();
		jLabel9 = new javax.swing.JLabel();
		eBairroAluno = new javax.swing.JTextField();
		jLabel10 = new javax.swing.JLabel();
		eEstadoAluno = new javax.swing.JTextField();
		jButton2 = new javax.swing.JButton();
		jButton3 = new javax.swing.JButton();
		eNumeroAluno = new javax.swing.JTextField();
		eNumeroAlu = new javax.swing.JLabel();

		jLabel1.setText("Matricula:");

		eMatriculaAluno.setEditable(false);
		eMatriculaAluno.addKeyListener(new java.awt.event.KeyAdapter() {
			public void keyReleased(java.awt.event.KeyEvent evt) {
				eMatriculaAlunoKeyReleased(evt);
			}
		});

		jLabel3.setText("Nome:");

		jLabel2.setText("Email:");

		jLabel4.setText("CPF:");

		eCpfAluno.addKeyListener(new java.awt.event.KeyAdapter() {
			public void keyReleased(java.awt.event.KeyEvent evt) {
				eCpfAlunoKeyReleased(evt);
			}
		});

		eCelularAluno.addKeyListener(new java.awt.event.KeyAdapter() {
			public void keyReleased(java.awt.event.KeyEvent evt) {
				eCelularAlunoKeyReleased(evt);
			}
		});

		jLabel5.setText("Celular:");

		jLabel6.setText("Logradouro:");

		Complemento.setText("Complemento:");

		jLabel8.setText("Cidade:");

		jLabel9.setText("Bairro:");

		jLabel10.setText("Estado");

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

		eNumeroAluno.addKeyListener(new java.awt.event.KeyAdapter() {
			public void keyReleased(java.awt.event.KeyEvent evt) {
				eNumeroAlunoKeyReleased(evt);
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
								.addGroup(javax.swing.GroupLayout.Alignment.LEADING,
										layout.createSequentialGroup().addComponent(jLabel10)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
														javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(eEstadoAluno, javax.swing.GroupLayout.PREFERRED_SIZE, 145,
														javax.swing.GroupLayout.PREFERRED_SIZE))
								.addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
										.addComponent(jLabel8)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
												javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(eCidadeAluno, javax.swing.GroupLayout.PREFERRED_SIZE, 145,
												javax.swing.GroupLayout.PREFERRED_SIZE))
								.addGroup(javax.swing.GroupLayout.Alignment.LEADING,
										layout.createSequentialGroup().addComponent(Complemento)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
														javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(eComplementoAluno, javax.swing.GroupLayout.PREFERRED_SIZE,
														145, javax.swing.GroupLayout.PREFERRED_SIZE))
								.addGroup(layout.createSequentialGroup().addGroup(
										layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
												.addComponent(jLabel5).addComponent(jLabel1,
														javax.swing.GroupLayout.PREFERRED_SIZE, 60,
														javax.swing.GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
												javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
												.addComponent(eCelularAluno, javax.swing.GroupLayout.PREFERRED_SIZE,
														145, javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(eMatriculaAluno, javax.swing.GroupLayout.PREFERRED_SIZE,
														145, javax.swing.GroupLayout.PREFERRED_SIZE))))
						.addGap(18, 18, 18)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(layout.createSequentialGroup()
										.addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 60,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
												javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(eNomeAluno, javax.swing.GroupLayout.PREFERRED_SIZE, 145,
												javax.swing.GroupLayout.PREFERRED_SIZE))
								.addGroup(layout.createSequentialGroup().addComponent(jLabel6)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
												javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(eLogradouroAluno, javax.swing.GroupLayout.PREFERRED_SIZE, 145,
												javax.swing.GroupLayout.PREFERRED_SIZE))
								.addGroup(layout.createSequentialGroup().addComponent(eNumeroAlu)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
												javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(eNumeroAluno, javax.swing.GroupLayout.PREFERRED_SIZE, 145,
												javax.swing.GroupLayout.PREFERRED_SIZE))
								.addGroup(layout.createSequentialGroup().addComponent(jLabel9)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
												javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(eBairroAluno, javax.swing.GroupLayout.PREFERRED_SIZE, 145,
												javax.swing.GroupLayout.PREFERRED_SIZE))))
						.addGroup(layout.createSequentialGroup()
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
										.addGroup(layout.createSequentialGroup().addGap(86, 86, 86).addComponent(
												eEmailAluno, javax.swing.GroupLayout.PREFERRED_SIZE, 145,
												javax.swing.GroupLayout.PREFERRED_SIZE))
										.addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING))
								.addGap(18, 18, 18).addComponent(jLabel4)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(eCpfAluno, javax.swing.GroupLayout.PREFERRED_SIZE, 145,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
								layout.createSequentialGroup().addGap(0, 0, Short.MAX_VALUE).addComponent(jButton2)
										.addGap(84, 84, 84).addComponent(jButton3).addGap(116, 116, 116)))
				.addGap(45, 45, 45)));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addGap(15, 15, 15)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 27,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(eMatriculaAluno, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 27,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(eNomeAluno, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jLabel2)
								.addComponent(eEmailAluno, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(jLabel4).addComponent(eCpfAluno, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jLabel5)
								.addComponent(eCelularAluno, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(jLabel6)
								.addComponent(eLogradouroAluno, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(Complemento)
								.addComponent(eComplementoAluno, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(eNumeroAlu)
								.addComponent(eNumeroAluno, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jLabel8)
								.addComponent(eCidadeAluno, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(jLabel9)
								.addComponent(eBairroAluno, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jLabel10).addComponent(eEstadoAluno,
										javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(18, 18, 18)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jButton2).addComponent(jButton3))
						.addContainerGap(18, Short.MAX_VALUE)));

		pack();
	}// </editor-fold>//GEN-END:initComponents

	private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton3ActionPerformed
		JOptionPane.showMessageDialog(null, "Aluno não alterado");
		abrirUltimoEFecharAtual();
	}// GEN-LAST:event_jButton3ActionPerformed

	private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton2ActionPerformed
		alterarAluno();
	}// GEN-LAST:event_jButton2ActionPerformed

	private void eMatriculaAlunoKeyReleased(java.awt.event.KeyEvent evt) {// GEN-FIRST:event_eMatriculaAlunoKeyReleased
		eMatriculaAluno.setText(passarParaNumero(eMatriculaAluno.getText(), false));
	}// GEN-LAST:event_eMatriculaAlunoKeyReleased

	private void eCpfAlunoKeyReleased(java.awt.event.KeyEvent evt) {// GEN-FIRST:event_eCpfAlunoKeyReleased
		eCpfAluno.setText(passarParaNumero(eCpfAluno.getText(), false));
	}// GEN-LAST:event_eCpfAlunoKeyReleased

	private void eNumeroAlunoKeyReleased(java.awt.event.KeyEvent evt) {// GEN-FIRST:event_eNumeroAlunoKeyReleased
		eNumeroAluno.setText(passarParaNumero(eNumeroAluno.getText(), false));
	}// GEN-LAST:event_eNumeroAlunoKeyReleased

	private void eCelularAlunoKeyReleased(java.awt.event.KeyEvent evt) {// GEN-FIRST:event_eCelularAlunoKeyReleased
		eCelularAluno.setText(passarParaNumero(eCelularAluno.getText(), false));
	}// GEN-LAST:event_eCelularAlunoKeyReleased

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JLabel Complemento;
	private javax.swing.JTextField eBairroAluno;
	private javax.swing.JTextField eCelularAluno;
	private javax.swing.JTextField eCidadeAluno;
	private javax.swing.JTextField eComplementoAluno;
	private javax.swing.JTextField eCpfAluno;
	private javax.swing.JTextField eEmailAluno;
	private javax.swing.JTextField eEstadoAluno;
	private javax.swing.JTextField eLogradouroAluno;
	private javax.swing.JTextField eMatriculaAluno;
	private javax.swing.JTextField eNomeAluno;
	private javax.swing.JLabel eNumeroAlu;
	private javax.swing.JTextField eNumeroAluno;
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
