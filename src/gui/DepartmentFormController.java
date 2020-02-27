package gui;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import db.DbException;
import gui.listeners.DataChangeListener;
import gui.util.Alerts;
import gui.util.Constraints;
import gui.util.Utils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.entities.Department;
import model.service.DepartmentService;

public class DepartmentFormController implements Initializable {

	private Department entity;

	private DepartmentService service;
	
	private List <DataChangeListener> listener = new ArrayList<>();

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
	public void onBtSaveAction(ActionEvent event) {
		if (entity == null) {
			throw new IllegalStateException("entity was null");
		}
		if (service == null) {
			throw new IllegalStateException("service was null");
		}
		try {
			entity = getFormDate();
			service.updateOrSave(entity);
			notifyDataChangeListeners();
			Utils.currentStage(event).close();
		} catch (DbException e) {
			Alerts.showAlert("Error saving object", null, e.getMessage(), AlertType.ERROR);
		}

	}

	@FXML
	public void onBtCancelAction(ActionEvent event) {
		Utils.currentStage(event).close();
	}

	private void notifyDataChangeListeners() {
		for (DataChangeListener list :listener) {
			list.onDataChanged();
		}
		
	}
	public void setDepartment(Department entity) {
		this.entity = entity;
	}

	public void setDepartmentService(DepartmentService service) {
		this.service = service;
	}
	
	public void subscribleDataChangeListener(DataChangeListener listener) {
		this.listener.add(listener);
	}

	private Department getFormDate() {
		Department obj = new Department();
		obj.setId(Utils.tryParseToInt(textFieldId.getText()));
		obj.setName(textFieldName.getText());
		return obj;
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
