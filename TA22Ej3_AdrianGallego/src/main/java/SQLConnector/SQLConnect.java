package SQLConnector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import Model.Cientifico;
import Model.Proyecto;
import Model.ProyectoAsignado;

public class SQLConnect {

	static Connection conexion = null;
	final static String db = "TA22Ej3";
	final static String table_cientifico = "cientificos";
	final static String table_proyect = "proyecto";
	final static String table_asignado = "asignado_a";



	public static Connection ConexionDB() {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conexion = DriverManager.getConnection("jdbc:mysql://localhost:33060", "root", "admin1234");
			System.out.println("Server Connected");

		} catch (SQLException | ClassNotFoundException e) {
			System.out.println("No se ha podido conectar con la base de datos");
			System.out.println(e);
		}

		return conexion;
	}
	
	public static void closeConnection() {
		try {
			conexion.close();
			System.out.println("Se ha finalizado la conexion");
		} catch (Exception e) {
			System.out.println(e.getMessage());

		}
	}
	
	public static boolean insertCientifico(Cientifico c) {
		boolean state = false;
		try {
			Connection conexion = ConexionDB();

			String Querydb = "USE " + db + ";";
			Statement stdb = conexion.createStatement();
			stdb.executeUpdate(Querydb);
			System.out.println("Esta utilizando la base de datos: " + db);

			String Query = "INSERT INTO " + table_cientifico + " (dni, nomApels)" + " VALUES ('"+ c.getDni() + "', '" + c.getNomApels() + "')";
			Statement st = conexion.createStatement();
			st.execute(Query);
			state = true;
			System.out.println("Datos almacenados correctamente");

			closeConnection();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			System.out.println("Error en el almacenamiento");
		}
		return state;

	}
	
	public static ArrayList<Cientifico> getCientificos() {
		Connection conexion = ConexionDB();
		ArrayList<Cientifico> listaCientificos = new ArrayList<Cientifico>();

		try {

			String Querydb = "USE " + db + ";";
			Statement stdb = conexion.createStatement();
			stdb.executeUpdate(Querydb);

			String Query = "SELECT * FROM " + table_cientifico;
			Statement st = conexion.createStatement();
			ResultSet resultSet;
			resultSet = st.executeQuery(Query);

			while (resultSet.next()) {
				listaCientificos.add(new Cientifico(resultSet.getString(1), resultSet.getString(2)));
			}

			closeConnection();
			return listaCientificos;

		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("Error en la adquisicion de datos");
		}
		return null;

	}
	
	public static ArrayList<String> getListDNI() {
		Connection conexion = ConexionDB();
		ArrayList<String> listDNI = new ArrayList<String>();

		try {

			String Querydb = "USE " + db + ";";
			Statement stdb = conexion.createStatement();
			stdb.executeUpdate(Querydb);

			String Query = "SELECT dni FROM " + table_cientifico;
			Statement st = conexion.createStatement();
			ResultSet resultSet;
			resultSet = st.executeQuery(Query);

			while (resultSet.next()) {
				listDNI.add(resultSet.getString(1));
			}

			closeConnection();
			return listDNI;

		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("Error en la adquisicion de datos");
		}
		return null;

	}
	
	public static boolean insertProyecto(Proyecto p) {
		boolean state = false;
		try {
			Connection conexion = ConexionDB();

			String Querydb = "USE " + db + ";";
			Statement stdb = conexion.createStatement();
			stdb.executeUpdate(Querydb);
			System.out.println("Esta utilizando la base de datos: " + db);

			String Query = "INSERT INTO " + table_proyect + " (id, nombre, horas)" + " VALUES ('"+ p.getId() + "', '" + p.getNombre() + "', '" +p.getHoras() + "')";
			Statement st = conexion.createStatement();
			st.execute(Query);
			state = true;
			System.out.println("Datos almacenados correctamente");

			closeConnection();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			System.out.println("Error en el almacenamiento");
		}
		return state;

	}

	public static ArrayList<Proyecto> getProyectos() {
		Connection conexion = ConexionDB();
		ArrayList<Proyecto> listaProyectos = new ArrayList<Proyecto>();

		try {

			String Querydb = "USE " + db + ";";
			Statement stdb = conexion.createStatement();
			stdb.executeUpdate(Querydb);

			String Query = "SELECT * FROM " + table_proyect;
			Statement st = conexion.createStatement();
			ResultSet resultSet;
			resultSet = st.executeQuery(Query);

			while (resultSet.next()) {
				listaProyectos.add(new Proyecto(resultSet.getString(1), resultSet.getString(2), resultSet.getInt(3)));
			}

			closeConnection();
			return listaProyectos;

		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("Error en la adquisicion de datos");
		}
		return null;

	}
	
	public static ArrayList<String> getProyectoID() {
		Connection conexion = ConexionDB();
		ArrayList<String> listaIDs = new ArrayList<String>();

		try {

			String Querydb = "USE " + db + ";";
			Statement stdb = conexion.createStatement();
			stdb.executeUpdate(Querydb);

			String Query = "SELECT id FROM " + table_proyect;
			Statement st = conexion.createStatement();
			ResultSet resultSet;
			resultSet = st.executeQuery(Query);

			while (resultSet.next()) {
				listaIDs.add(resultSet.getString(1));
			}

			closeConnection();
			return listaIDs;

		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("Error en la adquisicion de datos");
		}
		return null;

	}
	
	public static boolean insertAsignadoA(String dni, String proyectID) {
		boolean state = false;
		try {
			Connection conexion = ConexionDB();

			String Querydb = "USE " + db + ";";
			Statement stdb = conexion.createStatement();
			stdb.executeUpdate(Querydb);
			System.out.println("Esta utilizando la base de datos: " + db);

			String Query = "INSERT INTO " + table_asignado + " (cientifico, proyecto)" + " VALUES ('" + dni + "', '" + proyectID + "')";
			Statement st = conexion.createStatement();
			st.execute(Query);
			state = true;
			System.out.println("Datos almacenados correctamente");

			closeConnection();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			System.out.println("Error en el almacenamiento");
		}
		return state;

	}
	
	public static ArrayList<ProyectoAsignado> getProyectosAsignados() {
		Connection conexion = ConexionDB();
		ArrayList<ProyectoAsignado> listaProyectosAsignados = new ArrayList<ProyectoAsignado>();

		try {

			String Querydb = "USE " + db + ";";
			Statement stdb = conexion.createStatement();
			stdb.executeUpdate(Querydb);

			String Query = "SELECT c.nomApels , c.dni , p.nombre FROM cientificos c JOIN asignado_a a ON c.dni = a.cientifico JOIN proyecto p ON a.proyecto = p.id;";
			Statement st = conexion.createStatement();
			ResultSet resultSet;
			resultSet = st.executeQuery(Query);

			while (resultSet.next()) {
				listaProyectosAsignados.add(new ProyectoAsignado(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3),resultSet.getString(3)));
			}

			closeConnection();
			return listaProyectosAsignados;

		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("Error en la adquisicion de datos");
		}
		return null;

	}

	
}
