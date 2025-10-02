package co.edu.uniquindio.fx10.controlador;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class MenuPrincipalController {

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private Pane panePrincipal;

    @FXML
    private Button btnInfo;

    @FXML
    private Button btnCrearProducto;

    @FXML
    private Label lblMenu;

    @FXML
    public void onInfo(ActionEvent event) throws IOException {
        FXMLLoader loader = new  FXMLLoader(getClass().getResource("Dashboard.fxml"));
        Parent root = loader.load();

        DashboardController dashboardController = (DashboardController) loader.getController();
        dashboardController.initialize();
        dashboardController.cargarProductos();

        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void onCrearProducto(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("FormularioProducto.fxml"));
        Parent root = loader.load();

        FormularioProductoController formularioProductoController = loader.getController();
        formularioProductoController.setMenuprincipalController(this);

        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public Pane getPanePrincipal() {
        return panePrincipal;
    }
}
