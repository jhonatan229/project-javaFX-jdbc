package gui;

import java.net.URL;
import java.util.ResourceBundle;

import gui.util.Constraints;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.entities.Department;

public class DepartmentFormController implements Initializable{

	private Department entity;
	
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
	
	public void setDepartment(Department entity) {
		this.entity = entity;
	}

	@Override
	public void initialize(URL aurs, ResourceBundle rb) {
		initializeNode();
	}

	private void initializeNode() {
		Constraints.setTextFieldInteger(textFieldId);
		Constraints.setTextFieldMaxLength(textFieldName, 30);
		
	}

	public void updateFormData() {
		if (entity == null) {
			throw new IllegalStateException("entity was null");
		}
		textFieldId.setText(String.valueOf(entity.getId()));
		textFieldName.setText(entity.getName());
	}
}
