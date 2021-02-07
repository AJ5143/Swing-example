package swing_example;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class UserRegistration extends JFrame {
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField Name;
    private JTextField Gender;
    private JTextField email;
    private JTextField username;
    private JTextField mob;
    private JTextField address;
    private JButton btnNewButton;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    UserRegistration frame = new UserRegistration();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */

    public UserRegistration() {
        setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\User\\Desktop\\STDM.jpg"));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(450, 190, 1014, 597);
        setResizable(false);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewUserRegister = new JLabel("Contact Update Form");
        lblNewUserRegister.setFont(new Font("Times New Roman", Font.PLAIN, 36));
        lblNewUserRegister.setBounds(362, 52, 325, 50);
        contentPane.add(lblNewUserRegister);

        JLabel lblName = new JLabel("Name");
        lblName.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblName.setBounds(58, 152, 99, 43);
        contentPane.add(lblName);

        JLabel lblNewLabel = new JLabel("Gender");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblNewLabel.setBounds(58, 243, 110, 29);
        contentPane.add(lblNewLabel);

        JLabel lblEmailAddress = new JLabel("Email\r\n address");
        lblEmailAddress.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblEmailAddress.setBounds(58, 324, 124, 36);
        contentPane.add(lblEmailAddress);

        Name = new JTextField();
        Name.setFont(new Font("Tahoma", Font.PLAIN, 32));
        Name.setBounds(214, 151, 228, 50);
        contentPane.add(Name);
        Name.setColumns(10);

        Gender = new JTextField();
        Gender.setFont(new Font("Tahoma", Font.PLAIN, 32));
        Gender.setBounds(214, 235, 228, 50);
        contentPane.add(Gender);
        Gender.setColumns(10);

        email = new JTextField();

        email.setFont(new Font("Tahoma", Font.PLAIN, 32));
        email.setBounds(214, 320, 228, 50);
        contentPane.add(email);
        email.setColumns(10);

        username = new JTextField();
        username.setFont(new Font("Tahoma", Font.PLAIN, 32));
        username.setBounds(707, 151, 228, 50);
        contentPane.add(username);
        username.setColumns(10);

        JLabel lblUsername = new JLabel("UserID");
        lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblUsername.setBounds(542, 159, 99, 29);
        contentPane.add(lblUsername);

        JLabel lblAdd = new JLabel("Address");
        lblAdd.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblAdd.setBounds(542, 245, 99, 24);
        contentPane.add(lblAdd);

        JLabel lblMobileNumber = new JLabel("Mobile number");
        lblMobileNumber.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblMobileNumber.setBounds(542, 329, 139, 26);
        contentPane.add(lblMobileNumber);

        mob = new JTextField();
        mob.setFont(new Font("Tahoma", Font.PLAIN, 32));
        mob.setBounds(707, 320, 228, 50);
        contentPane.add(mob);
        mob.setColumns(10);

        address= new JTextField();
        address.setFont(new Font("Tahoma", Font.PLAIN, 32));
        address.setBounds(707, 235, 228, 50);
        contentPane.add(address);
        address.setColumns(10);

        btnNewButton = new JButton("Update");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                String name = Name.getText();
                String gender = Gender.getText();
                String emailId = email.getText();
                String userID = username.getText();
                String mobileNumber = mob.getText();
                int len = mobileNumber.length();
                String addresss = address.getText();

                String msg = "" + name;
                msg += " \n";
                if (len != 10) {
                    JOptionPane.showMessageDialog(btnNewButton, "Enter a valid mobile number");
                }

                try {
                    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/nishtha practical", "root", "");
                    String query = " insert into contacts (ContactName,ContactGender,ContactEmail,ContactUserID,ContactMobile,ContactAddress)"
                            + " values (?, ?, ?, ?, ?, ?)";
           //         String query = "INSERT INTO contacts('" + name + "','" + gender + "','" + userID + "','" +
           //             password + "','" + emailId + "','" + mobileNumber + "') values('" + name + "','" + gender + "','" + userID + "','" + password + "','" + emailId + "','" + mobileNumber + "');

           //         Statement sta = connection.createStatement();
           //         int x = sta.executeUpdate(query);
                    PreparedStatement preparedStmt = connection.prepareStatement(query);
                    preparedStmt.setString(1, name);
                    preparedStmt.setString(2, gender);
                    preparedStmt.setString(3, emailId);
                    preparedStmt.setString(4, userID);
                    preparedStmt.setString(5, mobileNumber);
                    preparedStmt.setString(6, addresss);
                    // execute the preparedstatement
                    preparedStmt.execute();
                    
                        JOptionPane.showMessageDialog(btnNewButton,
                            "Welcome, " + msg + "Your account is sucessfully created");
                   
                    connection.close();
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        });
        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
        btnNewButton.setBounds(399, 500, 200, 50);
        contentPane.add(btnNewButton);
    }
}