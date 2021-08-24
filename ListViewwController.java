package listt;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;
import java.util.ResourceBundle;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;

public class ListViewwController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ListView<String> lstItems;

    @FXML
    private TextField txtItm;

    @FXML
    private Label lblItem;

    @FXML
    private Label lblIndex;

    @FXML
    void doClear(ActionEvent event) {
    	lstItems.getItems().clear();
    }

    @FXML
    void doDelete(ActionEvent event) 
    {
    		ObservableList<String> ary=lstItems.getSelectionModel().getSelectedItems();
    		lstItems.getItems().removeAll(ary);
    }

    @FXML
    void doShow(ActionEvent event) {
    	ObservableList<String> itms=	lstItems.getSelectionModel().getSelectedItems();
    	ObservableList<Integer> inds=lstItems.getSelectionModel().getSelectedIndices();
    	String indxs="";
    	String items="";
    	for (Integer integer : inds) 
    	{
			indxs+=integer+",";
		}
    	lblIndex.setText(indxs);
    	
    	for (String str : itms) 
    	{
			items+=str+",";
		}
    	lblIndex.setText(indxs);
    	lblItem.setText(items);
    	//lblItem.setText(itms.toString());
    }
    
    String getItemFromUser()
    {
    	TextInputDialog dialog = new TextInputDialog("");
		dialog.setTitle("Input Data...");
		dialog.setContentText("Please enter Marks:");

		// Traditional way to get the response value.
		Optional<String> result = dialog.showAndWait();
		
		//doAlert(result.get());
		
			return result.get();	
			
		 
    }
    @FXML
    void doAddNew(ActionEvent event) {
    	String item=getItemFromUser();
    	int ind=lstItems.getItems().indexOf(item);
    	
    	if(ind==-1)
    		lstItems.getItems().add(item);
    }

    @FXML
    void initialize() {
       ArrayList<String> ary=new ArrayList<String>(Arrays.asList("Mouse","laptop","mobile","books","Car"));
       lstItems.getItems().addAll(ary);
       lstItems.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
       
    }
}
