package kr.blogspot.smcity5.instruments;

import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.StatusLineManager;
import org.eclipse.jface.action.ToolBarManager;
import org.eclipse.jface.window.ApplicationWindow;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;

import swing2swt.layout.BoxLayout;
import swing2swt.layout.BorderLayout;

import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Group;

import swing2swt.layout.FlowLayout;

import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.FormText;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.jface.action.Action;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.ui.forms.widgets.ScrolledForm;

public class MainWindows extends ApplicationWindow {
	private Text txtCentFreq;
	private Text txtSpan;
	private Text txtVBW;
	private Text txtRBW;
	private Text txtAddress;
	private Text txtPort;
	private Text txtAtten;
	private Text txtRefLevel;
	private Text txtSweepTime;
	private Text txtAverage;
	public Display display = Display.getDefault();
	private final FormToolkit formToolkit = new FormToolkit(display);
	private Action action;
	public Table table;
	public Text txttpinfopath;
	
	private String tpinfopath;
	private int tpinfotablecolumncount;
	private int tpinfotableitemcount;
	private Button btnConnect;
	private Button btnClose;
	
	private String socketaddress;
	private String socketport;
	
	private String txtaddress;
	private String txtport;
	
	private InstruMain inmain;
	private Inspection inspection;
	private EditorWindow editorwindow;
	private String[] mtableitem;
	
	/**
	 * Create the application window.
	 */
	public MainWindows() {
		super(null);
		createActions();
		addToolBar(SWT.FLAT | SWT.WRAP);
		addMenuBar();
		addStatusLine();
		
		inmain = new InstruMain(this);
		new Thread(inmain).start();
		
		editorwindow = new EditorWindow();
		
	}

	/**
	 * Create contents of the application window.
	 * @param parent
	 */
	protected Control createContents(Composite parent) {
		Composite container = new Composite(parent, SWT.NONE);
		container.setLayout(new BorderLayout(0, 0));
		
		CTabFolder tabFolder = new CTabFolder(container, SWT.BORDER);
		tabFolder.setLayoutData(BorderLayout.CENTER);
		tabFolder.setSelectionBackground(Display.getCurrent().getSystemColor(SWT.COLOR_TITLE_INACTIVE_BACKGROUND_GRADIENT));
		
		CTabItem tbtmN9344CAgilent = new CTabItem(tabFolder, SWT.NONE);
		tbtmN9344CAgilent.setText("N9344C - Agilent");
		
		Composite composite = new Composite(tabFolder, SWT.NONE);
		tbtmN9344CAgilent.setControl(composite);
		composite.setLayout(new BorderLayout(0, 0));
		
		Composite composite_4 = new Composite(composite, SWT.NONE);
		composite_4.setLayoutData(BorderLayout.WEST);
		composite_4.setLayout(new GridLayout(2, false));
		
		Label lblNewLabel_2 = new Label(composite_4, SWT.NONE);
		GridData gd_lblNewLabel_2 = new GridData(SWT.CENTER, SWT.CENTER, false, false, 2, 1);
		gd_lblNewLabel_2.heightHint = 15;
		lblNewLabel_2.setLayoutData(gd_lblNewLabel_2);
		formToolkit.adapt(lblNewLabel_2, true, true);
		lblNewLabel_2.setText("o CNR and Power Measurement - N9344C Agilent");
		
		Group group = new Group(composite_4, SWT.NONE);
		group.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		group.setLayout(new GridLayout(2, false));
		
		Label lblNewLabel = new Label(group, SWT.NONE);
		lblNewLabel.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblNewLabel.setText("Cent. Freq(MHz)");
		
		txtCentFreq = new Text(group, SWT.BORDER);
		txtCentFreq.setText("997");
		txtCentFreq.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Label lblNewLabel_1 = new Label(group, SWT.NONE);
		lblNewLabel_1.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblNewLabel_1.setText("Span(MHz)");
		
		txtSpan = new Text(group, SWT.BORDER);
		txtSpan.setText("60");
		txtSpan.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Group group_1 = new Group(composite_4, SWT.NONE);
		group_1.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		group_1.setLayout(new GridLayout(2, false));
		
		Label lblVbwkhz = new Label(group_1, SWT.NONE);
		lblVbwkhz.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblVbwkhz.setText("VBW(KHz)");
		
		txtVBW = new Text(group_1, SWT.BORDER);
		txtVBW.setText("3000");
		txtVBW.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Label lblRbwkhz = new Label(group_1, SWT.NONE);
		lblRbwkhz.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblRbwkhz.setText("RBW(KHz)");
		
		txtRBW = new Text(group_1, SWT.BORDER);
		txtRBW.setText("3000");
		txtRBW.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Group group_3 = new Group(composite_4, SWT.NONE);
		group_3.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		group_3.setLayout(new GridLayout(2, false));
		
		Label lblAttenuatordb = new Label(group_3, SWT.NONE);
		lblAttenuatordb.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblAttenuatordb.setText("Attenuator(dB)  ");
		
		txtAtten = new Text(group_3, SWT.BORDER);
		txtAtten.setText("10");
		txtAtten.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Label lblRefLeveldb = new Label(group_3, SWT.NONE);
		lblRefLeveldb.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblRefLeveldb.setText("Ref. Level(dB)");
		
		txtRefLevel = new Text(group_3, SWT.BORDER);
		txtRefLevel.setText("-20");
		txtRefLevel.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Group group_4 = new Group(composite_4, SWT.NONE);
		group_4.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		group_4.setLayout(new GridLayout(2, false));
		
		Label lblSweepTimems = new Label(group_4, SWT.NONE);
		lblSweepTimems.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblSweepTimems.setText("Sweep Time(ms)");
		
		txtSweepTime = new Text(group_4, SWT.BORDER);
		txtSweepTime.setText("50");
		txtSweepTime.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Label lblAverage = new Label(group_4, SWT.NONE);
		lblAverage.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblAverage.setText("Average");
		
		txtAverage = new Text(group_4, SWT.BORDER);
		txtAverage.setText("10");
		txtAverage.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		new Label(composite_4, SWT.NONE);
		new Label(composite_4, SWT.NONE);
		new Label(composite_4, SWT.NONE);
		
		/***********
		this.txtCentFreq
		this.txtSpan
		this.txtVBW
		this.txtRBW
		this.txtAtten
		this.txtRefLevel
		this.txtSweepTime
		this.txtAverage
		/***********/
		new Label(composite_4, SWT.NONE);
		new Label(composite_4, SWT.NONE);
		new Label(composite_4, SWT.NONE);
		new Label(composite_4, SWT.NONE);
		new Label(composite_4, SWT.NONE);
		
		Group group_2 = new Group(composite_4, SWT.NONE);
		group_2.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		group_2.setLayout(new GridLayout(2, false));
		
		Label lblAddress = new Label(group_2, SWT.NONE);
		lblAddress.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblAddress.setText("Address    ");
		
		txtAddress = new Text(group_2, SWT.BORDER);
		txtAddress.setText("192.168.0.12");
		txtAddress.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Label lblPort = new Label(group_2, SWT.NONE);
		lblPort.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblPort.setText("Port      ");
		
		txtPort = new Text(group_2, SWT.BORDER);
		txtPort.setText("5025");
		txtPort.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Group group_5 = new Group(composite_4, SWT.NONE);
		group_5.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		group_5.setLayout(new GridLayout(1, false));
		
		btnConnect = new Button(group_5, SWT.NONE);
		btnClose = new Button(group_5, SWT.NONE);
		btnClose.setEnabled(false);
		
		btnConnect.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				
				
				Thread thr = new Thread( new Runnable() { public void run(){
				

						try{
						getSocketAddressPort();
						
						Inspection inspection = new Inspection(socketaddress,socketport);
						//inspection.init(txtCentFreq.getText(), txtSpan.getText(), txtVBW.getText(), txtRBW.getText(), txtAtten.getText(), txtRefLevel.getText(), txtSweepTime.getText(), txtAverage.getText());
						//new Thread(inspection).start();
						getTableItem();
						/*************/
						//while(true)
						//{
							
							//TableColumn[] column = table.getColumns();
							//TableItem[] item = mtable.getItems();
							for( int i =0 ; i < mtableitem.length ; i++)
							{
								
								inspection.inspect( mtableitem[i].toString(), 
													mtableitem[i].toString(),
										 			mtableitem[i].toString(),
										 			mtableitem[i].toString(),
										 			mtableitem[i].toString(),
										 			mtableitem[i].toString());
								
								try {
									Thread.sleep(100);
								} catch (InterruptedException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
								
								
								//System.out.println(  item[i].getText(2).toString()  );
								
							}
							
						//}//while(true)
						/*************/
						}
						catch(Exception e)
						{
							e.printStackTrace();
						}
						
						btnClose.setEnabled(true);
						btnConnect.setEnabled(false);						
						
				}});////new Thread( new Runnable() { public void run(){
				
				
				
				thr.start();
				/********
				try{
					inspection.closeAll();
				}catch(Exception ex){
					ex.printStackTrace();
				}
				/********/
			}//
			
		});
		GridData gd_btnConnect = new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1);
		gd_btnConnect.heightHint = 20;
		gd_btnConnect.widthHint = 152;
		btnConnect.setLayoutData(gd_btnConnect);
		formToolkit.adapt(btnConnect, true, true);
		btnConnect.setText("Connect");
		
		
		btnClose.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				
				inspection.closeAll();
				
				btnConnect.setEnabled(true);
				btnClose.setEnabled(false);
				
			}
		});
		GridData gd_btnClose = new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1);
		gd_btnClose.heightHint = 19;
		btnClose.setLayoutData(gd_btnClose);
		formToolkit.adapt(btnClose, true, true);
		btnClose.setText("Close");
		
		Composite composite_5 = new Composite(composite, SWT.NONE);
		composite_5.setLayoutData(BorderLayout.SOUTH);
		composite_5.setLayout(new BorderLayout(0, 0));
		
		ScrolledComposite scrolledComposite = new ScrolledComposite(composite_5, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
		formToolkit.adapt(scrolledComposite);
		formToolkit.paintBordersFor(scrolledComposite);
		scrolledComposite.setExpandHorizontal(true);
		scrolledComposite.setExpandVertical(true);
		scrolledComposite.setMinSize(new Point(73, 100));
		
		Composite composite_7 = new Composite(composite, SWT.NONE);
		composite_7.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		composite_7.setLayoutData(BorderLayout.CENTER);
		composite_7.setLayout(new GridLayout(1, false));
		
		txttpinfopath = new Text(composite_7, SWT.BORDER);
		txttpinfopath.setEnabled(false);
		txttpinfopath.setEditable(false);
		txttpinfopath.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		formToolkit.adapt(txttpinfopath, true, true);
		
		table = formToolkit.createTable(composite_7, SWT.NONE);
		GridData gd_table = new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1);
		gd_table.heightHint = 256;
		gd_table.widthHint = 338;
		table.setLayoutData(gd_table);
		formToolkit.paintBordersFor(table);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		
		Composite composite_6 = new Composite(composite_7, SWT.BORDER);
		composite_6.setLayout(new GridLayout(11, false));
		GridData gd_composite_6 = new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1);
		gd_composite_6.widthHint = 423;
		gd_composite_6.heightHint = 34;
		composite_6.setLayoutData(gd_composite_6);
		formToolkit.adapt(composite_6);
		formToolkit.paintBordersFor(composite_6);
		
		Button btnTableEdit = new Button(composite_6, SWT.NONE);
		btnTableEdit.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				
				//editorwindow.
				
			}
		});
		btnTableEdit.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		formToolkit.adapt(btnTableEdit, true, true);
		btnTableEdit.setText("Tabel Edit");
		new Label(composite_6, SWT.NONE);
		new Label(composite_6, SWT.NONE);
		new Label(composite_6, SWT.NONE);
		new Label(composite_6, SWT.NONE);
		new Label(composite_6, SWT.NONE);
		new Label(composite_6, SWT.NONE);
		new Label(composite_6, SWT.NONE);
		new Label(composite_6, SWT.NONE);
		new Label(composite_6, SWT.NONE);
		
		Button btnTableReload = new Button(composite_6, SWT.NONE);
		btnTableReload.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				
				table.removeAll();
				//String[] imsi = new String[1];
				//setTableHeader(imsi);
				
			}
		});
		formToolkit.adapt(btnTableReload, true, true);
		btnTableReload.setText("Table Reload");
		
		CTabItem tbtmDMT = new CTabItem(tabFolder, SWT.NONE);
		tbtmDMT.setText("DMT - RS232C");
		
		Composite composite_1 = new Composite(tabFolder, SWT.NONE);
		tbtmDMT.setControl(composite_1);
		
		CTabItem tbtmRodehMER = new CTabItem(tabFolder, SWT.NONE);
		tbtmRodehMER.setText("Rodeh - MER");
		
		Composite composite_3 = new Composite(tabFolder, SWT.NONE);
		tbtmRodehMER.setControl(composite_3);
		
		CTabItem tbtmRodehLNB = new CTabItem(tabFolder, SWT.NONE);
		tbtmRodehLNB.setText("Rodeh - LNB");
		
		Composite composite_2 = new Composite(tabFolder, SWT.NONE);
		tbtmRodehLNB.setControl(composite_2);

		return container;
	}

	/**
	 * Create the actions.
	 */
	private void createActions() {
		// Create the actions
		{
			action = new Action("AC") {
			};
		}
	}

	/**
	 * Create the status line manager.
	 * @return the status line manager
	 */
	protected StatusLineManager createStatusLineManager() {
		StatusLineManager statusLineManager = new StatusLineManager();
		return statusLineManager;
	}

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String args[]) {
		try {
			MainWindows window = new MainWindows();
			window.setBlockOnOpen(true);
			window.open();
			
			Display.getCurrent().dispose();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Configure the shell.
	 * @param newShell
	 */
	protected void configureShell(Shell newShell) {
		newShell.setSize(new Point(800, 600));
		super.configureShell(newShell);
		newShell.setText("Instruments Controller V1.0 - http://smcity5.blogspot.kr");
		newShell.setActive();
	}

	/**
	 * Return the initial size of the window.
	 */
	protected Point getInitialSize() {
		return new Point(802, 552);
	}
	
	public void setTxtBoxTpInfo(final String path){
		
		display.syncExec(new Runnable(){
			public void run(){
				txttpinfopath.setText(path);
			}
		});
		
	}
	
	public void getTxtBoxTpInfo(){
		
		display.syncExec(new Runnable(){
			public void run(){
				tpinfopath = ( txttpinfopath.getText() );
			}
		});
		
	}
	
	public void getTxtBoxAddress(){
		
		display.syncExec(new Runnable(){
			public void run(){
				txtaddress = ( txtAddress.getText() );
			}
		});
		
	}
	
	public void getTxtBoxPort(){
		
		display.syncExec(new Runnable(){
			public void run(){
				txtport = ( txtPort.getText() );
			}
		});
		
	}
	
	public String getTpInfoPath(){
		
		return this.tpinfopath;
	}
	
	public void getTpInfoTableCount(){
		
		display.syncExec(new Runnable(){
			public void run(){
				tpinfotablecolumncount = ( table.getColumnCount() );
				tpinfotableitemcount = ( table.getItemCount() );
			}
		});
		
	}
	
	public int getTpInfoTableColumnCount(){
		
		return this.tpinfotablecolumncount;
	}
	
	public int getTpInfoTableItemCount(){
		
		return this.tpinfotableitemcount;
	}
	
	public void setTableHeader(final String[] header)
	{
		display.syncExec(new Runnable(){
			public void run(){

				
				for( int i=0;i<header.length;i++)
				{
					TableColumn tc = new TableColumn(table,SWT.CENTER);
					tc.setText(header[i]);
					tc.setWidth(60);
					//System.out.println(header[i]);
				}
			}
		});
	}
	
	public void setTableItemn(final String[] item)
	{
		display.syncExec(new Runnable(){
			public void run(){

				TableItem it = new TableItem(table, SWT.NONE);
				it.setText(item);
				//System.out.println(item[1]);
				
			}
		});
	}
	
	public void getTableItem()
	{
		display.syncExec(new Runnable(){
			public void run(){

				//mtableitem = table.getItems();
				mtableitem = new String[table.getItems().length];
				for( int i=0 ; i<table.getItems().length ; i++ )
				{
					mtableitem[i] = table.getItems()[i].toString();
				}
				//System.out.println(item[1]);
				
			}
		});		
	}
	
	public void getSocketAddressPort()
	{
		display.syncExec(new Runnable(){
			public void run(){

				socketaddress = txtAddress.getText();
				socketport = txtPort.getText();
				
			}
		});		
	}
	
	public String getSocketAddress()
	{
		return this.socketaddress;
	}
	
	public String getSocketPort()
	{
		return this.socketport;
				
	}
	
	
}//class
