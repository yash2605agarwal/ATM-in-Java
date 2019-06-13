import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.text.*;
public class BankAccount extends JFrame
{
    Color black = new Color(0, 0, 0);
    Color white = new Color(255, 255, 255);
    Color cyan = new Color (0, 255, 255);
    Color lightGray = new Color (192, 192, 192);
    JLabel amountJLabel;
    JFrame welcomeFrame;
	JFrame mainFrame;
	JTextField pinField;
    JTextField amountJTextField;
    JLabel statusJLabel;
    JTextField statusJTextField;
    JLabel balanceJLabel;
    JTextField balanceJTextField;
    JButton depositJButton;
    JButton withdrawJButton;
    JButton clearJButton;
    JButton clearAllJButton;
    JButton closeJButton;
    double amount;
    double balance;
    String status;
    DecimalFormat decimalFormat;
    Account account;
    public BankAccount()
    {
        createUserInterface();
    }
    public void createUserInterface()
    {
        Container contentPane = getContentPane();
        contentPane.setBackground(Color.yellow);
        contentPane.setLayout(null);
        amountJLabel = new JLabel();
        amountJLabel.setBounds(50, 50, 120, 20);
        amountJLabel.setFont(new Font("Default", Font.BOLD, 12));
        amountJLabel.setText("Enter the amount:");
        amountJLabel.setForeground(black);
        amountJLabel.setHorizontalAlignment(JLabel.RIGHT);
        contentPane.add(amountJLabel);
        mainFrame = new JFrame("ATM");
		welcomeFrame = new JFrame("Welcome to the ATM");
		welcomeFrame.setLocation(200,200);
		mainFrame.setLocation(200,200);

		JPanel welcomePanel = new JPanel();
		welcomePanel.setLayout(new FlowLayout(FlowLayout.CENTER,200,20));
		welcomePanel.setPreferredSize(new Dimension(400,200));
		
		JLabel pinLabel = new JLabel("Enter pin and Press Enter");
		pinField = new JTextField(10);
		
		welcomePanel.add(pinLabel);
		welcomePanel.add(pinField);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		welcomeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        amountJTextField = new JTextField();
        amountJTextField.setBounds(200, 50, 80, 20);
        amountJTextField.setFont(new Font("Default", Font.BOLD, 12));
        amountJTextField.setHorizontalAlignment(JTextField.CENTER);
        amountJTextField.setForeground(black);
        amountJTextField.setBackground(white);
        amountJTextField.setEditable(true);
        contentPane.add(amountJTextField);
        statusJLabel = new JLabel();
        statusJLabel.setBounds(50, 150, 120, 20);
        statusJLabel.setFont(new Font("Default", Font.BOLD, 12));
        statusJLabel.setText("Account status:");
        statusJLabel.setForeground(black);
        statusJLabel.setHorizontalAlignment(JLabel.RIGHT);
        contentPane.add(statusJLabel);
        statusJTextField = new JTextField();
        statusJTextField.setBounds(200, 150, 80, 20);
        statusJTextField.setFont(new Font("Default", Font.BOLD, 12));
        statusJTextField.setHorizontalAlignment(JTextField.CENTER);
        statusJTextField.setForeground(black);
        statusJTextField.setBackground(white);
        statusJTextField.setEditable(false);
        contentPane.add(statusJTextField);
        balanceJLabel = new JLabel();
        balanceJLabel.setBounds(50, 180, 120, 20);
        balanceJLabel.setFont(new Font("Default", Font.BOLD, 12));
        balanceJLabel.setText("Current balance:");
        balanceJLabel.setForeground(black);
        balanceJLabel.setHorizontalAlignment(JLabel.RIGHT);
        contentPane.add(balanceJLabel);
        balanceJTextField = new JTextField();
        balanceJTextField.setBounds(200, 180, 80, 20);
        balanceJTextField.setFont(new Font("Default", Font.BOLD, 12));
        balanceJTextField.setHorizontalAlignment(JTextField.CENTER);
        balanceJTextField.setForeground(black);
        balanceJTextField.setBackground(white);
        balanceJTextField.setEditable(false);
        contentPane.add(balanceJTextField);
        clearJButton = new JButton();
        clearJButton.setBounds(20, 300, 100, 20);
        clearJButton.setFont(new Font("Default", Font.BOLD, 12));
        clearJButton.setText("Clear");
        clearJButton.setForeground(black);
        clearJButton.setBackground(white);
        contentPane.add(clearJButton);
        clearJButton.addActionListener(
                new ActionListener()
                {
                    public void actionPerformed(ActionEvent event)
                    {
                        clearJButtonActionPerformed(event);
                    }
                }
        );
        clearAllJButton = new JButton();
        clearAllJButton.setBounds(150, 300, 100, 20);
        clearAllJButton.setFont(new Font("Default", Font.BOLD, 12));
        clearAllJButton.setText("Clear All");
        clearAllJButton.setForeground(black);
        clearAllJButton.setBackground(white);
        contentPane.add(clearAllJButton);
        clearAllJButton.addActionListener(
                new ActionListener()
                {
                    public void actionPerformed(ActionEvent event)
                    {
                        clearAllJButtonActionPerformed(event);
                    }
                }
        );
        closeJButton = new JButton();
        closeJButton.setBounds(280, 300, 100, 20);
        closeJButton.setFont(new Font("Default", Font.BOLD, 12));
        closeJButton.setText("Close");
        closeJButton.setForeground(black);
        closeJButton.setBackground(white);
        contentPane.add(closeJButton);
        closeJButton.addActionListener(
                new ActionListener()
                {
                    public void actionPerformed(ActionEvent event)
                    {
                        closeJButtonActionPerformed(event);
                    }
                }
        );
        depositJButton = new JButton();
        depositJButton.setBounds(80, 95, 90, 20);
        depositJButton.setFont(new Font("Default", Font.BOLD, 12));
        depositJButton.setText("Deposit");
        depositJButton.setForeground(white);
        depositJButton.setBackground(black);
        contentPane.add(depositJButton);
        depositJButton.addActionListener(
               new ActionListener()
                {
                    public void actionPerformed(ActionEvent event)
                    {
                        depositJButtonActionPerformed(event);
                    }
                }
        );
        withdrawJButton = new JButton();
        withdrawJButton.setBounds(190, 95, 90, 20);
        withdrawJButton.setFont(new Font("Default", Font.BOLD, 12));
        withdrawJButton.setText("Withdraw");
        withdrawJButton.setForeground(white);
        withdrawJButton.setBackground(black);
        contentPane.add(withdrawJButton);
       withdrawJButton.addActionListener(
                new ActionListener()
                {
                    public void actionPerformed(ActionEvent event)
                    {
                        withdrawJButtonActionPerformed(event);
                    }
                }
        );
        account = new Account();
        setTitle("BankAccount");
        setSize(400, 400);
        setVisible(true);

    }
    public static void main(String[] args)
    {
        BankAccount application = new BankAccount();
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void depositJButtonActionPerformed(ActionEvent event)
    {
        getAmount();
        depositAmount();
    }
    public void withdrawJButtonActionPerformed(ActionEvent event)
    {
        getAmount();
        withdrawAmount();
    }
    public void getAmount()
    {
        try
        {
            amount = Double.parseDouble(amountJTextField.getText());
        }
        catch(NumberFormatException exception)
        {
            JOptionPane.showMessageDialog(this, "Please enter the amount!", "Number Format Error", JOptionPane.ERROR_MESSAGE);
            amountJTextField.setText("");
            amountJTextField.requestFocusInWindow();
        }
    }
    public void depositAmount()
    {
        account.getCurrentBalance(balance);
        account.deposit(amount);
        account.setCurrentBalance();
        balance = account.setCurrentBalance();
        displayResults();
    }
    public void withdrawAmount()
    {
        account.getCurrentBalance(balance);
        account.withdraw(amount);
        account.setCurrentBalance();
        balance = account.setCurrentBalance();
        displayResults();
    }
    public void displayResults()
    {
        decimalFormat = new DecimalFormat("$0.00");
        determineStatus();
        statusJTextField.setText(status);
        balanceJTextField.setText("" + decimalFormat.format(balance));
        amountJTextField.setText("");
        amountJTextField.requestFocusInWindow();
    }
    public void determineStatus()
    {
        if(balance < 0)
        {
            status = "overdrawn";
        }
        else
        {
            status = "OK";
        }
    }
    public void clearJButtonActionPerformed(ActionEvent event)
    {
        amountJTextField.setText("");
        statusJTextField.setText("");
        amountJTextField.requestFocusInWindow();
    }
    public void clearAllJButtonActionPerformed(ActionEvent event)
    {
        amountJTextField.setText("");
        statusJTextField.setText("");
        balanceJTextField.setText("");
        amountJTextField.requestFocusInWindow();
    }
    public void closeJButtonActionPerformed(ActionEvent event)
    {
        BankAccount.this.dispose();
    }
}
class Account
{
    double currentBalance;
    double amountNumber;
    String status;
    BankAccount bankAccount;
    public void getCurrentBalance(double balanceValue)
    {
        currentBalance = balanceValue;
    }
    public void deposit(double amountValue)
    {
        amountNumber = amountValue;
        currentBalance = currentBalance + amountNumber;
        setCurrentBalance();
    }
    public void withdraw(double amountValue)
    {
       amountNumber = amountValue;
       currentBalance = currentBalance - amountNumber;
       setCurrentBalance();
   }
   public double setCurrentBalance()
   {
       return currentBalance;
   }
}

