import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.regex.Pattern;


public class RegistrationForm extends JFrame{
    private JLabel titleLable;

    private JLabel nameLabel;
    private JLabel emailLabel;
    private JLabel genderLabel;
    private JLabel birthdayLabel;
    private JLabel passwordLabel;

    private JTextField nameText;
    private JTextField signUpEmailText;
    private JRadioButton maleRadioButton;
    private JRadioButton femaleRadioButton;
    private ButtonGroup genderButtonGroup;
    private JComboBox<String> yearComboBox;
    private JComboBox<String> monthComboBox;
    private JComboBox<String> dayComboBox;
    private JPasswordField passwordFieldSignUp;
    private JCheckBox showPasswordCheckBoxSignUp;

    private Checkbox checkBox;

    private JButton signUpButton;
    private JTextField signInEmailText;
    private JPasswordField passwordFieldSignIn;
    private JCheckBox showPasswordCheckBoxSignIn;
    private JButton signInButton;


    RegistrationForm(){
        // Set the icon image for the JFrame
        ImageIcon icon = new ImageIcon("resources/img/icon.png");
        setIconImage(icon.getImage());

        setSize(450, 720);
        setLocationRelativeTo(null);
        setTitle("Registration Form");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        // Set Title Label as "Sign Up"
        titleLable = new JLabel("Sign Up");
        titleLable.setFont(new Font("", Font.BOLD, 22));
        titleLable.setForeground(Color.BLUE);
        titleLable.setSize(200,50);
        titleLable.setLocation(180,6);
        contentPane.add(titleLable);

        nameLabel = new JLabel("Name");
        nameLabel.setFont(new Font("", Font.BOLD, 18));
        nameLabel.setSize(200,50);
        nameLabel.setLocation(30,50);
        contentPane.add(nameLabel);

        emailLabel = new JLabel("Email");
        emailLabel.setFont(new Font("", Font.BOLD, 18));
        emailLabel.setSize(200,50);
        emailLabel.setLocation(30,100);
        contentPane.add(emailLabel);

        genderLabel = new JLabel("Gender");
        genderLabel.setFont(new Font("", Font.BOLD, 18));
        genderLabel.setSize(200,50);
        genderLabel.setLocation(30,150);
        contentPane.add(genderLabel);

        birthdayLabel = new JLabel("Birthday");
        birthdayLabel.setFont(new Font("", Font.BOLD, 18));
        birthdayLabel.setSize(200,50);
        birthdayLabel.setLocation(30,200);
        contentPane.add(birthdayLabel);

        passwordLabel = new JLabel("Password");
        passwordLabel.setFont(new Font("", Font.BOLD, 18));
        passwordLabel.setSize(200,50);
        passwordLabel.setLocation(30,250);
        contentPane.add(passwordLabel);

        // Set Sign Up Inputs Fields
        nameText = new JTextField();
        nameText.setFont(new Font("Arial", Font.PLAIN, 18));
        nameText.setBorder(new LineBorder(Color.BLACK));
        nameText.setSize(240,30);
        nameText.setLocation(160,60);
        contentPane.add(nameText);

        signUpEmailText = new JTextField();
        signUpEmailText.setFont(new Font("Arial", Font.PLAIN, 18));
        signUpEmailText.setBorder(new LineBorder(Color.BLACK));
        signUpEmailText.setSize(240,30);
        signUpEmailText.setLocation(160,110);
        contentPane.add(signUpEmailText);

        // Group the radio buttons
        maleRadioButton = new JRadioButton("Male");
        maleRadioButton.setFont(new Font("Arial", Font.PLAIN, 18));
        maleRadioButton.setSize(110,30);
        maleRadioButton.setLocation(160,160);

        femaleRadioButton = new JRadioButton("Female");
        femaleRadioButton.setFont(new Font("Arial", Font.PLAIN, 18));
        femaleRadioButton.setSize(160,30);
        femaleRadioButton.setLocation(270,160);

        genderButtonGroup = new ButtonGroup();
        genderButtonGroup.add(maleRadioButton);
        genderButtonGroup.add(femaleRadioButton);

        contentPane.add(maleRadioButton);
        contentPane.add(femaleRadioButton);

        // Add JComboBox for Birthday
        String[] daysArray = new String[31];
        for (int i = 1; i <= 31; i++) {
            daysArray[i - 1] = Integer.toString(i);
        }
        dayComboBox = new JComboBox<>(daysArray);
        dayComboBox.setFont(new Font("Arial", Font.PLAIN, 18));
        dayComboBox.setSize(50,30);
        dayComboBox.setLocation(160,210);
        contentPane.add(dayComboBox);

        String[] monthsArray = {"January", "February", "March", "April", "May", "June", "July",
                "August", "September", "October", "November", "December"};
        monthComboBox = new JComboBox<>(monthsArray);
        monthComboBox.setFont(new Font("Arial", Font.PLAIN, 18));
        monthComboBox.setSize(120,30);
        monthComboBox.setLocation(210,210);
        contentPane.add(monthComboBox);

        String[] yearsArray = new String[124];
        for (int i = 1900; i <= 2023; i++) {
            yearsArray[i - 1900] = Integer.toString(i);
        }
        yearComboBox = new JComboBox<>(yearsArray);
        yearComboBox.setFont(new Font("Arial", Font.PLAIN, 18));
        yearComboBox.setSize(70,30);
        yearComboBox.setLocation(330,210);
        contentPane.add(yearComboBox);

        // Add password field
        passwordFieldSignUp = new JPasswordField();
        passwordFieldSignUp.setFont(new Font("Arial", Font.PLAIN, 18));
        passwordFieldSignUp.setBorder(new LineBorder(Color.BLACK));
        passwordFieldSignUp.setSize(240,30);
        passwordFieldSignUp.setLocation(160,260);
        contentPane.add(passwordFieldSignUp);

        // Add checkbox for showing/hiding password
        showPasswordCheckBoxSignUp = new JCheckBox("Show Password");
        showPasswordCheckBoxSignUp.addActionListener(e -> toggleShowPasswordSignUp());
        showPasswordCheckBoxSignUp.setSize(200,20);
        showPasswordCheckBoxSignUp.setLocation(160,290);
        contentPane.add(showPasswordCheckBoxSignUp);

        // Add CheckBox
        checkBox = new Checkbox("  I am not a robot");
        checkBox.setFont(new Font("Arial", Font.PLAIN, 18));
        checkBox.setForeground(Color.BLACK);
        checkBox.setSize(200,30);
        checkBox.setLocation(30,320);
        contentPane.add(checkBox);

        // Create Sign Up Button
        signUpButton = new JButton("Sign Up");
        signUpButton.setBackground(Color.BLUE);
        signUpButton.setForeground(Color.WHITE);
        signUpButton.setFont(new Font("Arial", Font.BOLD, 18));
        signUpButton.setSize(370,30);
        signUpButton.setLocation(30,380);
        // Add ActionListener to the Sign-Up Button
        signUpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                signUpButtonAction();
            }
        });
        contentPane.add(signUpButton);

//        JSeparator separator=new JSeparator();
//        separator.setSize(370,1);
//        separator.setLocation(30,430);
//        contentPane.add(separator);

        // Set Title Label as "Sign In"
        titleLable = new JLabel("Sign In");
        titleLable.setFont(new Font("", Font.BOLD, 22));
        titleLable.setForeground(Color.BLUE);
        titleLable.setSize(200,50);
        titleLable.setLocation(180,425);
        contentPane.add(titleLable);

        // Set Sign In Labels
        emailLabel = new JLabel("Email");
        emailLabel.setFont(new Font("", Font.BOLD, 18));
        emailLabel.setSize(200,50);
        emailLabel.setLocation(30,470);
        contentPane.add(emailLabel);

        passwordLabel = new JLabel("Password");
        passwordLabel.setFont(new Font("", Font.BOLD, 18));
        passwordLabel.setSize(200,50);
        passwordLabel.setLocation(30,520);
        contentPane.add(passwordLabel);

        // Set Inputs Fields For Sign In
        signInEmailText = new JTextField();
        signInEmailText.setFont(new Font("Arial", Font.PLAIN, 18));
        signInEmailText.setBorder(new LineBorder(Color.BLACK));
        signInEmailText.setSize(240,30);
        signInEmailText.setLocation(160,480);
        contentPane.add(signInEmailText);

        // Add  s+Sign In Password Field
        passwordFieldSignIn = new JPasswordField();
        passwordFieldSignIn.setFont(new Font("Arial", Font.PLAIN, 18));
        passwordFieldSignIn.setBorder(new LineBorder(Color.BLACK));
        passwordFieldSignIn.setSize(240,30);
        passwordFieldSignIn.setLocation(160,530);
        contentPane.add(passwordFieldSignIn);

        // Add checkbox for showing/hiding password
        showPasswordCheckBoxSignIn = new JCheckBox("Show Password");
        showPasswordCheckBoxSignIn.addActionListener(e -> toggleShowPasswordSignIn());
        showPasswordCheckBoxSignIn.setSize(200,20);
        showPasswordCheckBoxSignIn.setLocation(160,560);
        contentPane.add(showPasswordCheckBoxSignIn);

        // Create Sign In Button
        signInButton = new JButton("Sign In");
        signInButton.setBackground(Color.BLUE);
        signInButton.setForeground(Color.WHITE);
        signInButton.setFont(new Font("Arial", Font.BOLD, 18));
        signInButton.setSize(370,30);
        signInButton.setLocation(30,610);
        contentPane.add(signInButton);

        // Add ActionListener to the Sign-In Button
        signInButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                signInButtonAction();
            }
        });
        contentPane.add(signInButton);

    }

    // Sign Up Button password showing/hiding password method
    private void toggleShowPasswordSignUp() {
        if (showPasswordCheckBoxSignUp.isSelected()) {
            passwordFieldSignUp.setEchoChar((char) 0); // Show the password
        } else {
            passwordFieldSignUp.setEchoChar('\u2022'); // Hide the password with bullet character
        }
    }
    // Sign In Button password showing/hiding password method
    private void toggleShowPasswordSignIn() {
        if (showPasswordCheckBoxSignIn.isSelected()) {
            passwordFieldSignIn.setEchoChar((char) 0);
        } else {
            passwordFieldSignIn.setEchoChar('\u2022');
        }
    }

    // Method to handle Sign Up Button click
    private void signUpButtonAction() {
        // Retrieve input values
        String name = nameText.getText();
        if (!isValidName(name)) {
            JOptionPane.showMessageDialog(this,
                    "Invalid name. Please enter a valid name.",
                    "Error", JOptionPane.ERROR_MESSAGE);
            validateName(name);
            return;
        }else{
            validateName(name);
        }

        String signUpEmail = signUpEmailText.getText();
        if (!isValidEmail(signUpEmail)) {
            JOptionPane.showMessageDialog(this,
                    "Invalid email. Please enter a valid email address.",
                    "Error", JOptionPane.ERROR_MESSAGE);
            validateSignUpEmail(signUpEmail);
            return;
        } else {
            validateSignUpEmail(signUpEmail);
        }

        if (isEmailAlreadyUsed(signUpEmail)) {
            JOptionPane.showMessageDialog(this,
                    "Email is already in use. Please use a different email address.",
                    "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Retrieve gender
        String gender = "";
        if (maleRadioButton.isSelected()) {
            gender = "Male";
        } else if (femaleRadioButton.isSelected()) {
            gender = "Female";
        }else {
            JOptionPane.showMessageDialog(this,
                    "Please select your gender.",
                    "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Retrieve birthday
        String day = (String) dayComboBox.getSelectedItem();
        String month = (String) monthComboBox.getSelectedItem();
        String year = (String) yearComboBox.getSelectedItem();
        String birthday = day + "-" + month + "-" + year;

        // Retrieve password
        String signUpPassword = new String(passwordFieldSignUp.getPassword());
        if (!isValidPassword(signUpPassword)) {
            JOptionPane.showMessageDialog(this,
                    "Invalid password. Password must have a minimum of 8 characters.",
                    "Error", JOptionPane.ERROR_MESSAGE);
            validatePassword(signUpPassword);
            return;
        } else {
            validatePassword(signUpPassword);
        }

        // Check if "I am not a robot" checkbox is selected
        boolean notARobot = checkBox.getState();

        // Check "I am not a robot" verification
        if (!notARobot) {
            JOptionPane.showMessageDialog(this,
                    "Please confirm you are not a robot.",
                    "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String sql = "INSERT INTO register_details (name, email, gender, birthday, password) VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement pstm = DBConnection.getInstance().getConnection().prepareStatement(sql)) {

            pstm.setString(1, name);
            pstm.setString(2, signUpEmail);
            pstm.setString(3, gender);
            pstm.setString(4, birthday);
            pstm.setString(5, signUpPassword);

            int rowsAffected = pstm.executeUpdate();

            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(this,
                        "Sign up successful!",
                        "Success", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this,
                        "Sign up failed. Please try again.",
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        clearFields();

    }

    // Sign In Button Action Event
    private void signInButtonAction(){
        String signInEmail = signInEmailText.getText();
        if (!isValidEmail(signInEmail)) {
            JOptionPane.showMessageDialog(this,
                    "Invalid email. Please enter a valid email address.",
                    "Error", JOptionPane.ERROR_MESSAGE);
            validateSignInEmail(signInEmail);
            return;
        } else {
            validateSignInEmail(signInEmail);
        }

        if (!isEmailAlreadyUsed(signInEmail)) {
            signInEmailText.setBorder(new LineBorder(Color.RED));
            JOptionPane.showMessageDialog(this,
                    "This Email Invalid !",
                    "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }else{
            signInEmailText.setBorder(new LineBorder(Color.BLACK));
        }

        String signInPassword = new String(passwordFieldSignIn.getPassword());
        if (!isValidSignInPassword(signInEmail,signInPassword)) {
            passwordFieldSignIn.setBorder(new LineBorder(Color.RED));
            JOptionPane.showMessageDialog(this,
                    "Invalid password. Please enter a valid password.",
                    "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }else {
            passwordFieldSignIn.setBorder(new LineBorder(Color.BLACK));
            JOptionPane.showMessageDialog(this,
                    "Sign In Successful!",
                    "Success", JOptionPane.INFORMATION_MESSAGE);
        }
        clearFields();
    }
    private void validateSignInEmail(String signInEmail) {
        if (isValidEmail(signInEmail)) {
            signInEmailText.setBorder(new LineBorder(Color.BLACK));
        } else {
            signInEmailText.setBorder(new LineBorder(Color.RED));
        }
    }

    // Name Validation Methods
    private void validateName(String name) {
        if (isValidName(name)) {
            nameText.setBorder(new LineBorder(Color.BLACK));
        } else {
            nameText.setBorder(new LineBorder(Color.RED));
        }
    }
    private boolean isValidName(String name) {
        return name.matches("[a-zA-Z ]+");
    }

    // Email Validation Methods
    private void validateSignUpEmail(String signUpEmail) {
        if (isValidEmail(signUpEmail)) {
            signUpEmailText.setBorder(new LineBorder(Color.BLACK));
        } else {
            signUpEmailText.setBorder(new LineBorder(Color.RED));
        }
    }

    // Check email validation
    private boolean isValidEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        return Pattern.matches(emailRegex, email);
    }

    // Password Validation Methods
    private void validatePassword(String password) {
        if (isValidPassword(password)) {
            passwordFieldSignUp.setBorder(new LineBorder(Color.BLACK));
        } else {
            passwordFieldSignUp.setBorder(new LineBorder(Color.RED));
        }
    }

    // Check password validation
    private boolean isValidPassword(String password) {
        return password.length() >= 8;
    }

    // Method to clear input fields
    private void clearFields() {
        nameText.setText("");
        signUpEmailText.setText("");
        genderButtonGroup.clearSelection();
        dayComboBox.setSelectedIndex(0);
        monthComboBox.setSelectedIndex(0);
        yearComboBox.setSelectedIndex(0);
        passwordFieldSignUp.setText("");
        checkBox.setState(false);
        signInEmailText.setText("");
        passwordFieldSignIn.setText("");
    }

    // Verify if the email already exists in the database
    private boolean isEmailAlreadyUsed(String email) {
        try (Connection connection = DBConnection.getInstance().getConnection();
             PreparedStatement pstm = connection
                     .prepareStatement("SELECT * FROM register_details WHERE email = ?");
        ) {
            pstm.setString(1, email);
            try (ResultSet resultSet = pstm.executeQuery()) {
                return resultSet.next();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Check Sign In email and password
    private boolean isValidSignInPassword(String email, String enteredPassword) {
        try (Connection connection = DBConnection.getInstance().getConnection();
             PreparedStatement preparedStatement = connection
                     .prepareStatement("SELECT password FROM register_details WHERE email = ?");
        ) {
            preparedStatement.setString(1, email);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    String storedPassword = resultSet.getString("password");
                    // Compare enteredPassword with storedPassword
                    boolean passwordMatch = enteredPassword.equals(storedPassword);

                    return passwordMatch;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }




}
