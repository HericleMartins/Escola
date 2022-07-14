package View.Sala;

import Controller.SalaController;
import static Funcoes.FuncoesAuxiliares.passarParaNumero;
import static java.util.Objects.isNull;

import Model.Sala;
import javax.swing.JOptionPane;

public class ViewCadastrarSala extends javax.swing.JInternalFrame {
	private final SalaController sc = new SalaController();

	public ViewCadastrarSala() {
		initComponents();
	}

	public void cadastrarSala() {
		Sala sala = new Sala();
		sala.setNome(eNomeSala.getText().trim().isEmpty() ? null : eNomeSala.getText());
		sala.setPredio(ePredioSala.getText().trim().isEmpty() ? null : Integer.parseInt(ePredioSala.getText()));
		sala.setSala(eNumeroSala.getText().trim().isEmpty() ? null : Integer.parseInt(eNumeroSala.getText()));
		sala.setCapacidade(eCapacidadeSala.getText().trim().isEmpty() ? null : Integer.parseInt(eCapacidadeSala.getText()));
		String campos = this.sc.validarCamposSala(sala);
		if (isNull(campos)) {
			if (this.sc.cadastrarSala(sala)) {
				JOptionPane.showMessageDialog(null, "Sala cadastrada com sucesso");
				this.dispose();
			} else {
				JOptionPane.showMessageDialog(null, "N„o foi possivel cadastrar sala");
			}
		} else {
			JOptionPane.showMessageDialog(null, "Campos necessarios n„o preenchidos\n" + campos);
		}
	}

	
	private void initComponents() {

		jLabel4 = new javax.swing.JLabel();
		jButton2 = new javax.swing.JButton();
		eNumeroSala = new javax.swing.JTextField();
		eCapacidadeSala = new javax.swing.JTextField();
		jButton3 = new javax.swing.JButton();
		jLabel5 = new javax.swing.JLabel();
		jLabel3 = new javax.swing.JLabel();
		ePredioSala = new javax.swing.JTextField();
		jLabel2 = new javax.swing.JLabel();
		eNomeSala = new javax.swing.JTextField();

		jLabel4.setText("N∫Sala");

		jButton2.setText("Salvar");
		jButton2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton2ActionPerformed(evt);
			}
		});

		eNumeroSala.addKeyListener(new java.awt.event.KeyAdapter() {
			public void keyReleased(java.awt.event.KeyEvent evt) {
				eNumeroSalaKeyReleased(evt);
			}
		});

		eCapacidadeSala.addKeyListener(new java.awt.event.KeyAdapter() {
			public void keyReleased(java.awt.event.KeyEvent evt) {
				eCapacidadeSalaKeyReleased(evt);
			}
		});

		jButton3.setText("Cancelar");
		jButton3.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton3ActionPerformed(evt);
			}
		});

		jLabel5.setText("Capacidade:");

		jLabel3.setText("Nome:");

		ePredioSala.addKeyListener(new java.awt.event.KeyAdapter() {
			public void keyReleased(java.awt.event.KeyEvent evt) {
				ePredioSalaKeyReleased(evt);
			}
		});

		jLabel2.setText("Predio:");

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout
				.createSequentialGroup()
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(layout.createSequentialGroup().addContainerGap()
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
										.addGroup(layout.createSequentialGroup().addComponent(jLabel4)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
														javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(eNumeroSala, javax.swing.GroupLayout.PREFERRED_SIZE, 145,
														javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGroup(layout.createSequentialGroup()
												.addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 60,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
												.addComponent(
														eNomeSala, javax.swing.GroupLayout.PREFERRED_SIZE, 145,
														javax.swing.GroupLayout.PREFERRED_SIZE)))
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
												.addGroup(
														layout.createSequentialGroup().addGap(86, 86, 86).addComponent(
																ePredioSala, javax.swing.GroupLayout.PREFERRED_SIZE,
																145, javax.swing.GroupLayout.PREFERRED_SIZE))
												.addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING))
										.addGroup(layout.createSequentialGroup().addComponent(jLabel5)
												.addGap(21, 21, 21).addComponent(eCapacidadeSala,
														javax.swing.GroupLayout.PREFERRED_SIZE, 145,
														javax.swing.GroupLayout.PREFERRED_SIZE))))
						.addGroup(layout.createSequentialGroup().addGap(113, 113, 113).addComponent(jButton2)
								.addGap(65, 65, 65).addComponent(jButton3)))
				.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addGap(27, 27, 27)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 27,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(eNomeSala, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(jLabel2).addComponent(ePredioSala, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jLabel4)
								.addComponent(eNumeroSala, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(jLabel5).addComponent(eCapacidadeSala,
										javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(29, 29, 29)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jButton2).addComponent(jButton3))
						.addContainerGap(17, Short.MAX_VALUE)));

		pack();
	}// </editor-fold>//GEN-END:initComponents

	private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton2ActionPerformed
		cadastrarSala();
	}// GEN-LAST:event_jButton2ActionPerformed

	private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton3ActionPerformed
		JOptionPane.showMessageDialog(null, "Sala n√£o inserida");
		this.dispose();
	}// GEN-LAST:event_jButton3ActionPerformed

	private void eNumeroSalaKeyReleased(java.awt.event.KeyEvent evt) {// GEN-FIRST:event_eNumeroSalaKeyReleased
		eNumeroSala.setText(passarParaNumero(eNumeroSala.getText(), false));
	}// GEN-LAST:event_eNumeroSalaKeyReleased

	private void ePredioSalaKeyReleased(java.awt.event.KeyEvent evt) {// GEN-FIRST:event_ePredioSalaKeyReleased
		ePredioSala.setText(passarParaNumero(ePredioSala.getText(), false));
	}// GEN-LAST:event_ePredioSalaKeyReleased

	private void eCapacidadeSalaKeyReleased(java.awt.event.KeyEvent evt) {// GEN-FIRST:event_eCapacidadeSalaKeyReleased
		eCapacidadeSala.setText(passarParaNumero(eCapacidadeSala.getText(), false));

	}// GEN-LAST:event_eCapacidadeSalaKeyReleased

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JTextField eCapacidadeSala;
	private javax.swing.JTextField eNomeSala;
	private javax.swing.JTextField eNumeroSala;
	private javax.swing.JTextField ePredioSala;
	private javax.swing.JButton jButton2;
	private javax.swing.JButton jButton3;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JLabel jLabel5;
	// End of variables declaration//GEN-END:variables
}
