/* Project Milestone 4: Implementation
* Class: HomePage.java
* Author: Katherine Dumancela
* Due: October 25, 2022
* This class is used to create a functional homepage for each user group.
*/

import java.awt.Color;
import java.awt.Font;
import java.awt.Window;
import java.awt.event.*;
import javax.swing.*;

public class HomePage {
	
	public class ClientHome {
		private JFrame frame;
		private JPanel clientHome;
		private JLabel instructions, clientIcon, image2, description;
		private JButton submitJob, backButton;
		private JComboBox list;

		public ClientHome() {
			frame = new JFrame();
			frame.setSize(620, 400);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setTitle("Client Home Page");
			frame.setLocationRelativeTo(null);
			frame.setResizable(false);

			clientHome = new JPanel();
			frame.add(clientHome);
			clientHome.setLayout(null);
			instructions = new JLabel("<html>Client Homepage</html>", SwingConstants.CENTER);
			instructions.setBounds(160, 30, 320, 50);
			Font font = new Font("Calibri", Font.BOLD, 34);
			instructions.setFont(font);
			clientHome.add(instructions);

			image2 = new JLabel("");
			image2.setIcon(new ImageIcon("Images/home1.png"));
			image2.setBounds(418, 328, 25, 25);
			clientHome.add(image2);

			clientIcon = new JLabel("");
			clientIcon.setIcon(new ImageIcon("Images/clientHome.png"));
			clientIcon.setBounds(10, 0, 150, 150);
			clientHome.add(clientIcon);

			description = new JLabel("Click the button below to enter job details: ");
			description.setBounds(40, 135, 600, 35);
			description.setFont(new Font("Calibri", Font.ITALIC, 13));
			clientHome.add(description);

			submitJob = new JButton("Submit Job");
			ActionListener listener = new submitJobListener();
			submitJob.addActionListener(listener);
			submitJob.setBounds(210, 170, 100, 25);
			clientHome.add(submitJob);
			backButton = new JButton("Welcome Page");
			clientHome.add(backButton);
			ActionListener listener1 = new BackListener();
			backButton.addActionListener(listener1);
			clientHome.setBackground(new Color(148, 114, 242));
			backButton.setBounds(440, 330, 150, 25);

			frame.setVisible(true);
			
			
		}
		
		public JPanel getClientHome() {
		return clientHome;
	}



	public void setClientHome(JPanel clientHome) {
		this.clientHome = clientHome;
	}
		
		public class BackListener implements ActionListener {
			public void actionPerformed(ActionEvent event)
			{
				JComponent comp = (JComponent) event.getSource();
				Window win = SwingUtilities.getWindowAncestor(comp);
				win.dispose();
				new WelcomePage();
			}
		}
	}
	
	public class submitJobListener implements ActionListener {
		public void actionPerformed(ActionEvent event)
		{
			JComponent comp = (JComponent) event.getSource();
			Window win = SwingUtilities.getWindowAncestor(comp);
			win.dispose();
			new Job().new JobViewer();
		}
	}
	
	public class VehicleOwnerHome {
		private JFrame frame;
		private JPanel vehicleOwnerHome;
		private JLabel instructions, description, clientIcon, image2;
		private JButton vehicleRegistration, vehicleCheckIn, backButton;

		public VehicleOwnerHome() {
			frame = new JFrame();
			frame.setSize(620, 400);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setTitle("Vehicle Owner Home Page");
			frame.setLocationRelativeTo(null);
			frame.setResizable(false);

			clientIcon = new JLabel("");
			clientIcon.setIcon(new ImageIcon("Images/vehicle1.png"));
			clientIcon.setBounds(10, 0, 150, 150);
			frame.add(clientIcon);

			image2 = new JLabel("");
			image2.setIcon(new ImageIcon("Images/home1.png"));
			image2.setBounds(418, 328, 25, 25);
			frame.add(image2);

			vehicleOwnerHome = new JPanel();
			frame.add(vehicleOwnerHome);
			vehicleOwnerHome.setLayout(null);
			instructions = new JLabel("<html>Vehicle Owner Home</html>", SwingConstants.RIGHT);
			Font font = new Font("Calibri", Font.BOLD, 34);
			instructions.setFont(font);
			instructions.setBounds(120, 30, 400, 35);
			vehicleOwnerHome.add(instructions);

			description = new JLabel("Please select below if you are registering or checking-in a vehicle: ");
			description.setBounds(35, 120, 600, 35);
			description.setFont(new Font("Calibri", Font.ITALIC, 13));
			vehicleOwnerHome.add(description);

			vehicleRegistration = new JButton("Vehicle Registration");
			ActionListener listener = new vehicleRegisterListener();
			vehicleRegistration.addActionListener(listener);
			vehicleRegistration.setBounds(200, 170, 170, 25);
			vehicleOwnerHome.add(vehicleRegistration);

			backButton = new JButton("Welcome Page");
			vehicleOwnerHome.add(backButton);
			ActionListener listener1 = new BackListener();
			backButton.addActionListener(listener1);

			vehicleOwnerHome.setBackground(new Color(150, 127, 191));
			backButton.setBounds(440, 330, 150, 25);
			vehicleCheckIn = new JButton("Vehicle CheckIn");
			vehicleOwnerHome.add(vehicleCheckIn);
			ActionListener listener2 = new checkInListener();
			vehicleCheckIn.addActionListener(listener2);
			vehicleCheckIn.setBounds(200, 220, 150, 25);

			frame.setVisible(true);
		}
		
		public JPanel getVehicleOwnerHome() {
			return vehicleOwnerHome;
		}



		public void setVehicleOwnerHome(JPanel clientHome) {
			this.vehicleOwnerHome = vehicleOwnerHome;
		}
		
		
		public class checkInListener implements ActionListener {
			public void actionPerformed(ActionEvent event)
			{
				frame.dispose();
				new SystemJobs().new vehicleCheckIN();
			}
		}
		
		public class vehicleRegisterListener implements ActionListener {
			public void actionPerformed(ActionEvent event)
			{
				JComponent comp = (JComponent) event.getSource();
				Window win = SwingUtilities.getWindowAncestor(comp);
				win.dispose();
				new Vehicle().new vehiclePanel();
			}
		}
		
		public class BackListener implements ActionListener {
			public void actionPerformed(ActionEvent event)
			{
				JComponent comp = (JComponent) event.getSource();
				Window win = SwingUtilities.getWindowAncestor(comp);
				win.dispose();
				new WelcomePage();
			}
		}
	}
	
	public class CloudControllerHome {
		private JFrame frame;
		private JPanel ccHome;
		private JLabel instructions; 
		private JButton completionTime, welcomePagebutton;
		
		public CloudControllerHome() {
			frame = new JFrame(); 
			frame.setSize(500, 400);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setLocationRelativeTo(null);
			frame.setTitle("Cloud Controller Home Page");
			frame.setLocationRelativeTo(null);
			frame.setResizable(false);
			
			ccHome = new JPanel();  
			frame.add(ccHome);
			ccHome.setLayout(null);
			instructions = new JLabel("<html>Cloud Controller Home</html>", SwingConstants.RIGHT);
			Font font = new Font("Times New Roman", Font.BOLD, 16);
			instructions.setFont(font);
			instructions.setBounds(10, 10, 320, 35);
			ccHome.add(instructions); 
			completionTime = new JButton("Completion Time");
			ActionListener listener = new completionTimeListener(); 
			completionTime.addActionListener(listener);
			completionTime.setBounds(170, 150, 170, 25);
			ccHome.add(completionTime);
			ccHome.setBackground(new Color(128,111,176));
			welcomePagebutton = new JButton("Welcome Page");
			ccHome.add(welcomePagebutton);
			ActionListener listener1 = new BackListener();
			welcomePagebutton.addActionListener(listener1);
			welcomePagebutton.setBounds(325, 320, 150, 25);
			
			frame.setVisible(true);
		}
		
		public JPanel getCcHome() {
			return ccHome;
		}
		public void setCcHome(JPanel ccHome) {
			this.ccHome = ccHome;
		}
		
		public class completionTimeListener implements ActionListener {
			public void actionPerformed(ActionEvent event)
			{
				JComponent comp = (JComponent) event.getSource();
				Window win = SwingUtilities.getWindowAncestor(comp);
				win.dispose();
				new FIFOTest().new completeTime();
			}
		}
		
		public class BackListener implements ActionListener {
			public void actionPerformed(ActionEvent event)
			{
				JComponent comp = (JComponent) event.getSource();
				Window win = SwingUtilities.getWindowAncestor(comp);
				win.dispose();
				new WelcomePage();
			}
		}
	}
	
	public static void main(String[] args) {
		//ClientHome viewer = new HomePage().new ClientHome(); 
		VehicleOwnerHome homepage = new HomePage(). new VehicleOwnerHome();
		//CloudControllerHome cloudHome = new HomePage(). new CloudControllerHome();
	}
}
