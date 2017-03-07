package br.com.fiap.view;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import br.com.fiap.bo.PratoBOStub;
import br.com.fiap.bo.PratoBOStub.Cadastrar;
import br.com.fiap.bo.PratoBOStub.Prato;

public class Tela {

	protected Shell shell;
	private Text txtNome;
	private Text txtDescricao;
	private Label lblPreo;
	private Text txtPreco;
	private Text text;
	private Label lblCdigo;
	private Button btnBuscar;
	private Text txtNomeBusca;
	private Text txtDescricaoBusca;
	private Text txtPrecoBusca;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Tela window = new Tela();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(461, 300);
		shell.setText("SWT Application");
		
		Label lblNome = new Label(shell, SWT.NONE);
		lblNome.setBounds(24, 23, 55, 15);
		lblNome.setText("Nome");
		
		txtNome = new Text(shell, SWT.BORDER);
		txtNome.setBounds(24, 44, 126, 21);
		
		Label lblDescrio = new Label(shell, SWT.NONE);
		lblDescrio.setBounds(24, 71, 55, 15);
		lblDescrio.setText("Descri\u00E7\u00E3o");
		
		txtDescricao = new Text(shell, SWT.BORDER);
		txtDescricao.setBounds(24, 92, 126, 43);
		
		lblPreo = new Label(shell, SWT.NONE);
		lblPreo.setBounds(24, 141, 55, 15);
		lblPreo.setText("Pre\u00E7o");
		
		txtPreco = new Text(shell, SWT.BORDER);
		txtPreco.setBounds(24, 162, 126, 21);
		
		Button btnNewButton = new Button(shell, SWT.NONE);
		btnNewButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				//Executa no clique do botão
				String nome = txtNome.getText();
				String desc = txtDescricao.getText();
				float preco = Float.parseFloat(txtPreco.getText());
				
				Prato prato = new Prato();
				prato.setDescricao(desc);
				prato.setNome(nome);
				prato.setPreco(preco);
				try {
					//Chamar o webservice
					//Instanciar o Stub
					PratoBOStub stub = new PratoBOStub();
					//Instanciar o Cadastrar e passar o prato
					Cadastrar params = new Cadastrar();
					params.setPrato(prato);
					//Chamar o webservice 
					stub.cadastrar(params);
					//Mensagem de sucesso
					MessageBox dialog = new MessageBox(shell, SWT.OK);
					dialog.setMessage("Prato cadastrado!");
					dialog.open();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(24, 198, 126, 25);
		btnNewButton.setText("Enviar");
		
		text = new Text(shell, SWT.BORDER);
		text.setBounds(259, 44, 76, 21);
		
		lblCdigo = new Label(shell, SWT.NONE);
		lblCdigo.setBounds(212, 47, 44, 15);
		lblCdigo.setText("C\u00F3digo");
		
		btnBuscar = new Button(shell, SWT.NONE);
		btnBuscar.setBounds(341, 42, 75, 25);
		btnBuscar.setText("Buscar");
		
		Label label = new Label(shell, SWT.SEPARATOR | SWT.VERTICAL);
		label.setBounds(183, 23, 2, 213);
		
		Label lblNome_1 = new Label(shell, SWT.NONE);
		lblNome_1.setBounds(212, 92, 55, 15);
		lblNome_1.setText("Nome");
		
		Label lblDescrio_1 = new Label(shell, SWT.NONE);
		lblDescrio_1.setBounds(212, 120, 55, 15);
		lblDescrio_1.setText("Descri\u00E7\u00E3o");
		
		Label lblPreo_1 = new Label(shell, SWT.NONE);
		lblPreo_1.setBounds(212, 151, 55, 15);
		lblPreo_1.setText("Pre\u00E7o");
		
		txtNomeBusca = new Text(shell, SWT.BORDER);
		txtNomeBusca.setEditable(false);
		txtNomeBusca.setBounds(291, 92, 133, 21);
		
		txtDescricaoBusca = new Text(shell, SWT.BORDER);
		txtDescricaoBusca.setEditable(false);
		txtDescricaoBusca.setBounds(291, 120, 133, 21);
		
		txtPrecoBusca = new Text(shell, SWT.BORDER);
		txtPrecoBusca.setEditable(false);
		txtPrecoBusca.setBounds(291, 148, 133, 21);

	}
}
