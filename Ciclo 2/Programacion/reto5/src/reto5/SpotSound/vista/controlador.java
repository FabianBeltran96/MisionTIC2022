package reto5.SpotSound.vista;

import java.sql.SQLException;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import reto5.SpotSound.dao.DAOException;
import reto5.SpotSound.dao.mysql.MySQLDaoManager;
import reto5.SpotSound.modelos.Artista;

public class controlador {

	@FXML
	private VBox panelIzq;

	@FXML
	private Label tituloSS;

	@FXML
	private TextField getNombre;

	@FXML
	private TextField getGenero;

	@FXML
	private TextField getPais;

	@FXML
	private Button btnInsertar;

	@FXML
	private HBox infoPrincipal;

	@FXML
	private TextField IdPrincipal;

	@FXML
	private TextField NombrePrincipal;

	@FXML
	private TextField GeneroPrincipal;

	@FXML
	private TextField PaisPrincipal;

	@FXML
	private Button btnArtistaAnterior;

	@FXML
	private Button btnArtistaSiguiente;

	@FXML
	private HBox panelBtn1;
		
	@FXML
	private HBox panelBtn2;

	@FXML
	private Button btnBuscar;

	@FXML
	private Button btnModificar;

	@FXML
	private Button btnBorrar;

	@FXML
	private Button btnObtTodos;

	@FXML
	public TableView<Artista> artistaTabla;
	@FXML
	public TableColumn<Artista, Long> idColumna;

	@FXML
	private TableColumn<Artista, String> nombreColumna;

	@FXML
	private TableColumn<Artista, String> generoColumna;

	@FXML
	private TableColumn<Artista, String> paisColumna;

	@FXML
	private void insertarArtista(ActionEvent event) throws DAOException, SQLException {
		String Nombre = getNombre.getText();
		String Genero = getGenero.getText();
		String Pais = getPais.getText();

		MySQLDaoManager man = new MySQLDaoManager("localhost", "fabianmint", "Admin123!", "SpotSound");
		man.getArtistaDAO().insertar(new Artista(Nombre, Genero, Pais));
		obtenerArtistas();
		getNombre.setText("");
		getGenero.setText("");
		getPais.setText("");
	}

	@FXML
	private void obtArtistaAnterior(ActionEvent event) throws DAOException, SQLException {
		Long ID = Long.parseLong(IdPrincipal.getText());
		try {
			obtenerUnArtista(ID - 1);
		} catch (Exception ex) {
			IdPrincipal.setText(ID - 1 + "");
			NombrePrincipal.setText("No encontrado");
			GeneroPrincipal.setText("No encontrado");
			PaisPrincipal.setText("No encontrado");
		}
	}

	@FXML
	private void obtArtistaSiguiente(ActionEvent event) throws DAOException, SQLException {
		Long ID = Long.parseLong(IdPrincipal.getText());
		try {
			obtenerUnArtista(ID + 1);
		} catch (Exception ex) {
			IdPrincipal.setText(ID + 1 + "");
			NombrePrincipal.setText("No encontrado");
			GeneroPrincipal.setText("No encontrado");
			PaisPrincipal.setText("No encontrado");
		}
	}

	@FXML
	private void buscarArtista(ActionEvent event) throws DAOException, SQLException {
//		System.out.println(IdPrincipal.getText());
		Long ID = Long.parseLong(IdPrincipal.getText());
		try {
			obtenerUnArtista(ID);
		} catch (Exception e) {
			noEncontrado(ID);
		}
	}

	@FXML
	private void modificarArtista(ActionEvent event) throws DAOException, SQLException {
		MySQLDaoManager man = new MySQLDaoManager("localhost", "fabianmint", "Admin123!", "SpotSound");
		Long ID = Long.parseLong(IdPrincipal.getText());
		try {
			Artista artista = man.getArtistaDAO().obtener(ID);
			artista.setArt_nombre(NombrePrincipal.getText());
			artista.setArt_genero(GeneroPrincipal.getText());
			artista.setArt_pais(PaisPrincipal.getText());
			artista.setArt_id(ID);
//			System.out.println(artista);
			man.getArtistaDAO().modificar(artista);
			obtenerArtistas();
		} catch (Exception e) {
			noEncontrado(ID);
		}
	}

	@FXML
	private void borrarArtista(ActionEvent event) throws DAOException, SQLException {
		MySQLDaoManager man = new MySQLDaoManager("localhost", "fabianmint", "Admin123!", "SpotSound");
		Long ID = Long.parseLong(IdPrincipal.getText());

		try {
			Artista artista = man.getArtistaDAO().obtener(ID);
			man.getArtistaDAO().eliminar(artista);
			obtenerArtistas();
			IdPrincipal.setText("");
			NombrePrincipal.setText("");
			GeneroPrincipal.setText("");
			PaisPrincipal.setText("");
		} catch (Exception e) {
			noEncontrado(ID);

		}
	}

	@FXML
	private void actualizarTabla(ActionEvent event) throws DAOException, SQLException {
		obtenerArtistas();
	}

	private void obtenerArtistas() throws DAOException, SQLException {
		MySQLDaoManager man = new MySQLDaoManager("localhost", "fabianmint", "Admin123!", "SpotSound");
		List<Artista> artistas = man.getArtistaDAO().obtenerTodos();
		cargarInfo(artistas);

	}

	private void cargarInfo(List<Artista> listado) {

		ObservableList<Artista> artistas = FXCollections.observableArrayList(listado);
		idColumna.setCellValueFactory(new PropertyValueFactory<Artista, Long>("art_id"));
		nombreColumna.setCellValueFactory(new PropertyValueFactory<Artista, String>("art_nombre"));
		generoColumna.setCellValueFactory(new PropertyValueFactory<Artista, String>("art_genero"));
		paisColumna.setCellValueFactory(new PropertyValueFactory<Artista, String>("art_pais"));

		artistaTabla.setItems(artistas);
	}

	private void obtenerUnArtista(Long ID) throws SQLException, DAOException {
		MySQLDaoManager man = new MySQLDaoManager("localhost", "fabianmint", "Admin123!", "SpotSound");
		Artista artista = man.getArtistaDAO().obtener(ID);
//		System.out.println(artista);
		NombrePrincipal.setText(artista.getArt_nombre());
		GeneroPrincipal.setText(artista.getArt_genero());
		PaisPrincipal.setText(artista.getArt_pais());
		IdPrincipal.setText(artista.getArt_id() + "");
	}

	private void noEncontrado(Long ID) {
		Alert alert4 = new Alert(AlertType.ERROR, "No se encontro artista con el ID: " + ID, ButtonType.CLOSE);
		alert4.show();

	}

}
