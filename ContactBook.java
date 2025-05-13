import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class ContactBook extends Frame implements ActionListener {
    private TextField nameField, phoneField;
    private List contactList;
    private Button addButton, clearButton;
    private ArrayList<String> contacts;

    public ContactBook() {
        super("Contact Book");
        contacts = new ArrayList<>();

        setLayout(new BorderLayout());

        // Top panel for input
        Panel inputPanel = new Panel(new GridLayout(2, 2));
        inputPanel.add(new Label("Name:"));
        nameField = new TextField(20);
        inputPanel.add(nameField);
        inputPanel.add(new Label("Phone:"));
        phoneField = new TextField(20);
        inputPanel.add(phoneField);
        add(inputPanel, BorderLayout.NORTH);

        // Center panel for contact list
        contactList = new List();
        add(contactList, BorderLayout.CENTER);

        // Bottom panel for buttons
        Panel buttonPanel = new Panel();
        addButton = new Button("Add");
        clearButton = new Button("Clear");
        addButton.addActionListener(this);
        clearButton.addActionListener(this);
        buttonPanel.add(addButton);
        buttonPanel.add(clearButton);
        add(buttonPanel, BorderLayout.SOUTH);

        setSize(350, 300);
        setVisible(true);

        // Window close handler
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                dispose();
            }
        });
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addButton) {
            String name = nameField.getText().trim();
            String phone = phoneField.getText().trim();
            if (!name.isEmpty() && !phone.isEmpty()) {
                String contact = name + " - " + phone;
                contacts.add(contact);
                contactList.add(contact);
                nameField.setText("");
                phoneField.setText("");
            }
        } else if (e.getSource() == clearButton) {
            nameField.setText("");
            phoneField.setText("");
        }
    }

    public static void main(String[] args) {
        new ContactBook();
    }
}