package extending;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class MyFrame extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	Connection conn = null;
	PreparedStatement state = null;
	ResultSet result = null;
	MyModel model = null;
	int id = -1; //selected id
	
	JTable tableModel = new JTable();
	JTable tableBrand = new JTable();
	JTable tableOwner = new JTable();
	JTable tableFirstInquiry = new JTable();
	JTable tableSecondInquiry = new JTable();
	
	
	JScrollPane scrollerModel = new JScrollPane(tableModel);
	JScrollPane scrollerBrand = new JScrollPane(tableBrand);
	JScrollPane scrollerOwner = new JScrollPane(tableOwner);
	JScrollPane scrollerFirstInquiry = new JScrollPane(tableFirstInquiry);
	JScrollPane scrollerSecondInquiry = new JScrollPane(tableSecondInquiry);

	JPanel phones = new JPanel();
	JPanel brand = new JPanel();
	JPanel owner = new JPanel();
	JPanel firstInquiry = new JPanel();
	JPanel secondInquiry = new JPanel();
	
	//Model
	JPanel upPanelModel = new JPanel();
	JPanel midPanelModel = new JPanel();
	JPanel downPanelModel = new JPanel();
	//Brand
	JPanel upPanelBrand = new JPanel();
	JPanel midPanelBrand = new JPanel();
	JPanel downPanelBrand = new JPanel();
	//Owner
	JPanel upPanelOwner = new JPanel();
	JPanel midPanelOwner = new JPanel();
	JPanel downPanelOwner = new JPanel();
	//FirstInquiry
	JPanel upPanelFirstInquiry = new JPanel();
	JPanel midPanelFirstInquiry = new JPanel();
	JPanel downPanelFirstInquiry = new JPanel();
	//SecondInquiry
	JPanel upPanelSecondInquiry = new JPanel();
	JPanel midPanelSecondInquiry = new JPanel();
	JPanel downPanelSecondInquiry = new JPanel();
	
	//Model Buttons
	JButton insertButtonModel = new JButton("Insert");
	JButton delButtonModel = new JButton("Delete");
	JButton editButtonModel = new JButton("Edit");
	JButton searchButtonModel = new JButton("Search");
	JButton refreshButtonModel = new JButton("Refresh");
	//Brand Buttons
	JButton insertButtonBrand = new JButton("Insert");
	JButton delButtonBrand = new JButton("Delete");
	JButton editButtonBrand = new JButton("Edit");
	JButton searchButtonBrand = new JButton("Search");
	JButton refreshButtonBrand = new JButton("Refresh");
	
	//Owner Buttons
	JButton insertButtonOwner = new JButton("Insert");
	JButton delButtonOwner = new JButton("Delete");
	JButton editButtonOwner = new JButton("Edit");
	JButton searchButtonOwner = new JButton("Search");
	JButton refreshButtonOwner = new JButton("Refresh");
	
	//Model Labels
	JLabel modelNameLabel = new JLabel("Name:");
	JLabel displaySizeLabel = new JLabel("Display size:");
	JLabel processorLabel = new JLabel("Processor:");
	JLabel ramLabel = new JLabel("RAM:");
	//Brand Labels
	JLabel brandLabel = new JLabel("Brand");
	JLabel countryLabel = new JLabel("Country");
	//Owner Labels
	JLabel emailLabel = new JLabel("E-mail");
	JLabel firstNameLabel = new JLabel("First Name:");
	JLabel lastNameLabel = new JLabel("Last Name:");
	//Model TF
	JTextField modelNameTF = new JTextField();
	JTextField displaySizeTF = new JTextField();
	JTextField processorTF = new JTextField();
	JTextField ramTF = new JTextField();
	//Brand TF
	JTextField brandTF = new JTextField();
	JTextField countryTF = new JTextField();
	//Owner TF
	JTextField emailTF = new JTextField();
	JTextField firstNameTF = new JTextField();
	JTextField lastNameTF = new JTextField();
	
	JTabbedPane tabPane = new JTabbedPane();


	public MyFrame() {
		
		this.add(tabPane);
		this.setVisible(true);
		this.setSize(550, 450);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(650,300,650,500);
		
		
		tabPane.addTab("Phone", phones);
		phones.setLayout(new GridLayout(3, 1));
		phones.add(upPanelModel);
		phones.add(midPanelModel);
		phones.add(downPanelModel);
		
		tabPane.addTab("Brand", brand);
		brand.setLayout(new GridLayout(3, 1));
		brand.add(upPanelBrand);
		brand.add(midPanelBrand);
		brand.add(downPanelBrand);
		
		tabPane.addTab("Owner", owner);
		owner.setLayout(new GridLayout(3, 1));
		owner.add(upPanelOwner);
		owner.add(midPanelOwner);
		owner.add(downPanelOwner);
		
		//Model panel
		//upPanel
		upPanelModel.setLayout(new GridLayout(4,2));
		upPanelModel.add(modelNameLabel);
		upPanelModel.add(modelNameTF);
		upPanelModel.add(displaySizeLabel);
		upPanelModel.add(displaySizeTF);
		upPanelModel.add(processorLabel);
		upPanelModel.add(processorTF);
		upPanelModel.add(ramLabel);
		upPanelModel.add(ramTF);
		//midPanel
		midPanelModel.add(insertButtonModel);
		midPanelModel.add(delButtonModel);
		midPanelModel.add(editButtonModel);
		midPanelModel.add(searchButtonModel);
		midPanelModel.add(refreshButtonModel);
		insertButtonModel.addActionListener(new AddActionModel());
		delButtonModel.addActionListener(new DeleteActionModel());
		//TODO 
//		editButtonModel.addActionListener(new EditActionModel());
//		searchButtonModel.addActionListener(new SearchActionModel());
//		refreshButtonModel.addActionListener(new RefreshActionModel());
		//downPanel
		scrollerModel.setPreferredSize(new Dimension(300,100));
		downPanelModel.add(scrollerModel);
		refreshTable("phones");
		tableModel.addMouseListener(new MouseAction());
		
		
		//Brand panel
		//upPanel
		upPanelBrand.setLayout(new GridLayout(4,2));
		upPanelBrand.add(brandLabel);
		upPanelBrand.add(brandTF);
		upPanelBrand.add(countryLabel);
		upPanelBrand.add(countryTF);
	
		//midPanel
		midPanelBrand.add(insertButtonBrand);
		midPanelBrand.add(delButtonBrand);
		midPanelBrand.add(editButtonBrand);
		midPanelBrand.add(searchButtonBrand);
		midPanelBrand.add(refreshButtonBrand);
		insertButtonBrand.addActionListener(new AddActionBrand());
		delButtonBrand.addActionListener(new DeleteActionBrand());
		//TODO 
//		editButtonBrand.addActionListener(new EditActionBrand());
//		searchButtonBrand.addActionListener(new SearchActionBrand());
//		refreshButtonBrand.addActionListener(new RefreshActionBrand());
		//downPanel
		scrollerBrand.setPreferredSize(new Dimension(300,100));
		downPanelBrand.add(scrollerBrand);
		refreshTable("brand");
		tableBrand.addMouseListener(new MouseAction());
		
		//Owner panel
		//upPanel
		upPanelOwner.setLayout(new GridLayout(3,2));
		upPanelOwner.add(emailLabel);
		upPanelOwner.add(emailTF);
		upPanelOwner.add(firstNameLabel);
		upPanelOwner.add(firstNameTF);
		upPanelOwner.add(lastNameLabel);
		upPanelOwner.add(lastNameTF);
		//midPanel
		midPanelOwner.add(insertButtonOwner);
		midPanelOwner.add(delButtonOwner);
		midPanelOwner.add(editButtonOwner);
		midPanelOwner.add(searchButtonOwner);
		midPanelOwner.add(refreshButtonOwner);
		insertButtonOwner.addActionListener(new AddActionOwner());
		delButtonOwner.addActionListener(new DeleteActionOwner());
		//TODO 
//		editButtonOwner.addActionListener(new EditActionOwner());
//		searchButtonOwner.addActionListener(new SearchActionOwner());
//		refreshButtonOwner.addActionListener(new RefreshActionOwner());
		//downPanel
		scrollerOwner.setPreferredSize(new Dimension(300,100));
		downPanelOwner.add(scrollerOwner);
		refreshTable("owner");
		tableOwner.addMouseListener(new MouseAction());

			
		
	}//end constructor
		public void refreshTable(String tableName) {
		conn = DBConnector.getConnection();
		String sql = "select * from " + tableName;
		
		try {
			state = conn.prepareStatement(sql);
			result = state.executeQuery();
			model = new MyModel(result);
			tableModel.setModel(model);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	class DeleteActionModel implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			conn = DBConnector.getConnection();
			String sql = "delete from phones where id=?";
			try {
				state = conn.prepareStatement(sql);
				state.setInt(1, id);
				state.execute();
				refreshTable("phones");
				id = -1;
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
	}
	class DeleteActionBrand implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			conn = DBConnector.getConnection();
			String sql = "delete from brand where id=?";
			try {
				state = conn.prepareStatement(sql);
				state.setInt(1, id);
				state.execute();
				refreshTable("brand");
				id = -1;
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
	}
	
	class DeleteActionOwner implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			conn = DBConnector.getConnection();
			String sql = "delete from owner where id=?";
			try {
				state = conn.prepareStatement(sql);
				state.setInt(1, id);
				state.execute();
				refreshTable("owner");
				id = -1;
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
	}
	
	class MouseAction implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) {
			int row = tableModel.getSelectedRow();
			id = Integer.parseInt(tableModel.getValueAt(row, 0).toString());
			if(e.getClickCount() > 1) {
				modelNameLabel.setText(tableModel.getValueAt(row, 1).toString());
				displaySizeLabel.setText(tableModel.getValueAt(row, 2).toString());
				processorLabel.setText(tableModel.getValueAt(row, 3).toString());
				ramLabel.setText(tableModel.getValueAt(row, 4).toString());
			}
		}
		

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	
	
	class AddActionModel implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			String model = modelNameTF.getText();
			String displaySize = displaySizeTF.getText();
			String processor = processorTF.getText();
			int ram = Integer.parseInt(ramTF.getText());
		
			conn = DBConnector.getConnection();
			String query = "insert into phones values(null,?,?,?,?);";
			
			try {
				state = conn.prepareStatement(query);
				state.setString(1, model);
				state.setString(2, displaySize);
				state.setString(3, processor);
				state.setInt(4, ram);
				state.execute();
				refreshTable("phones");
				clearModelForm();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}//end method
		
	}//end AddActionModel
	
	class AddActionBrand implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			String brand = brandTF.getText();
			String country = countryTF.getText();
		
			conn = DBConnector.getConnection();
			String query = "insert into brand values(null,?,?);";
			
			try {
				state = conn.prepareStatement(query);
				state.setString(1, brand);
				state.setString(2, country);
				state.execute();
				refreshTable("brand");
				clearModelForm();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}//end method
		
	}//end AddActionBrand
	
	class AddActionOwner implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			String email = emailTF.getText();
			String fName = firstNameTF.getText();
			String lName = lastNameTF.getText();
			int ram = Integer.parseInt(ramTF.getText());
		
			conn = DBConnector.getConnection();
			String query = "insert into phones values(null,?,?,?);";
			
			try {
				state = conn.prepareStatement(query);
				state.setString(1, email);
				state.setString(2, fName);
				state.setString(3, lName);
				state.execute();
				refreshTable("owner");
				clearModelForm();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}//end method
		
	}//end AddActionOwner
	
	public void clearModelForm() {
		modelNameTF.setText("");
		displaySizeTF.setText("");
		processorTF.setText("");
		ramTF.setText("");
	}
	
	public void clearBrandForm() {
		brandTF.setText("");
		countryTF.setText("");
		
	}
	public void clearOwnerForm() {
		emailTF.setText("");
		firstNameTF.setText("");
		lastNameTF.setText("");
	}
}
