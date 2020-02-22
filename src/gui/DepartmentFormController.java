package gui;

import java.net.URL;
import java.util.ResourceBundle;

import gui.util.Constraints;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class DepartmentFormController implements Initializable{

	@FXML
	private Button btSave;
	
	@FXML
	private Button btCancel;
	
	@FXML
	private TextField textFieldName;
	
	@FXML
	private TextField textFieldId;
	
	@FXML
	private Label labelError;
	
	@FXML
	public void onBtSaveAction() {
		System.out.println("save");
	}
	
	@FXML
	public void onBtCancelAction() {
		System.out.println("cancel");
	}

	@Override
	public void initialize(URL aurs, ResourceBundle rb) {
		initializeNode();
	}

	private void initializeNode() {
		Constraints.setTextFieldInteger(textFieldId);
		Constraints.setTextFieldMaxLength(textFieldName, 30);
		
	}

	
}
