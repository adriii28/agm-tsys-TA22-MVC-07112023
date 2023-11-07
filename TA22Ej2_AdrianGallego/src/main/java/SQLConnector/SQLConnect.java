package SQLConnector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Models.Client;
import Models.Video;
import Models.VideoCliente;

public class SQLConnect {

	static Connection conexion = null;
	final static String db = "TA22Ej1";
	final static String table_cliente = "cliente";
	final static String table_videos = "videos";


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

	public static ArrayList<Client> getClientes() {
		Connection conexion = ConexionDB();
		ArrayList<Client> listaClientes = new ArrayList<Client>();

		try {

			String Querydb = "USE " + db + ";";
			Statement stdb = conexion.createStatement();
			stdb.executeUpdate(Querydb);

			String Query = "SELECT * FROM " + table_cliente;
			Statement st = conexion.createStatement();
			ResultSet resultSet;
			resultSet = st.executeQuery(Query);

			while (resultSet.next()) {
				listaClientes.add(new Client(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3),
						resultSet.getString(4), resultSet.getInt(5), resultSet.getString(6)));
			}

			closeConnection();
			return listaClientes;

		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("Error en la adquisicion de datos");
		}
		return null;

	}
	
	public static ArrayList<Video> getVideos() {
		Connection conexion = ConexionDB();
		ArrayList<Video> listaVideo = new ArrayList<Video>();

		try {

			String Querydb = "USE " + db + ";";
			Statement stdb = conexion.createStatement();
			stdb.executeUpdate(Querydb);

			String Query = "SELECT * FROM " + table_videos;
			Statement st = conexion.createStatement();
			ResultSet resultSet;
			resultSet = st.executeQuery(Query);

			while (resultSet.next()) {
				listaVideo.add(new Video(
						resultSet.getInt(1), 
						resultSet.getString(2), 
						resultSet.getString(3),
						resultSet.getInt(4)));
			}

			closeConnection();
			return listaVideo;

		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("Error en la adquisicion de datos");
		}
		return null;
	}
	
	public static ArrayList<VideoCliente> getVideosAsignados() {
		Connection conexion = ConexionDB();
		ArrayList<VideoCliente> listaVideoAsignado = new ArrayList<VideoCliente>();

		try {

			String Querydb = "USE " + db + ";";
			Statement stdb = conexion.createStatement();
			stdb.executeUpdate(Querydb);

			String Query = "SELECT c.id, c.nombre, v.id, v.title FROM cliente c JOIN videos v ON v.cli_id = c.id;";
			Statement st = conexion.createStatement();
			ResultSet resultSet;
			resultSet = st.executeQuery(Query);

			while (resultSet.next()) {
				listaVideoAsignado.add(new VideoCliente(
						resultSet.getInt(1), 
						resultSet.getString(2), 
						resultSet.getInt(3),
						resultSet.getString(4)));
			}

			closeConnection();
			return listaVideoAsignado;

		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("Error en la adquisicion de datos");
		}
		return null;
	}

	public static Client getClient(int id) {
		try {
			Connection conexion = ConexionDB();
			Client c = new Client();

			String Querydb = "USE " + db + ";";
			Statement stdb = conexion.createStatement();
			stdb.executeUpdate(Querydb);

			String Query = "SELECT * FROM " + table_cliente + " WHERE id = ?";
			PreparedStatement pst = conexion.prepareStatement(Query);
			pst.setInt(1, id);
			System.out.println(Query);

			try {

				ResultSet rs = pst.executeQuery();
				while (rs.next()) {
					c.setId(rs.getInt(1));
					c.setNombre(rs.getString(2));
					c.setApellidos(rs.getString(3));
					c.setDireccion(rs.getString(4));
					c.setDni(rs.getInt(5));
					c.setFecha(rs.getString(6));
				}

			} catch (Exception e) {
				System.out.println(e.getMessage());
				System.out.println("Error en la adquisicion de datos");
			}

			closeConnection();
			return c;

		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("Error en la adquisicion de datos");
		}
		return null;

	}

	public static boolean insertClient(Client c) {
		boolean state = false;
		try {
			Connection conexion = ConexionDB();

			String Querydb = "USE " + db + ";";
			Statement stdb = conexion.createStatement();
			stdb.executeUpdate(Querydb);
			System.out.println("Esta utilizando la base de datos: " + db);

			String Query = "INSERT INTO " + table_cliente + " (nombre, apellido, direccion, dni, fecha)" + " VALUES ('"
					+ c.getNombre() + "', '" + c.getApellidos() + "', '" + c.getDireccion() + "', '" + c.getDni()
					+ "', '" + c.getFecha() + "')";
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
	
	public static boolean insertVideo(Video v) {
		boolean state = false;
		try {
			Connection conexion = ConexionDB();

			String Querydb = "USE " + db + ";";
			Statement stdb = conexion.createStatement();
			stdb.executeUpdate(Querydb);
			System.out.println("Esta utilizando la base de datos: " + db);

			String Query = "INSERT INTO " + table_videos + " (title, director)" + " VALUES ('"+ v.getTitle() + "', '" + v.getDirector() +"')";
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

	public static boolean updateData(Client c) {
		boolean state = false;
		try {
			Connection conexion = ConexionDB();

			String Querydb = "USE " + db + ";";
			Statement stdb = conexion.createStatement();
			stdb.executeUpdate(Querydb);
			System.out.println("Esta utilizando la base de datos: " + db);

			String Query = "UPDATE " + table_cliente + " SET nombre = '" + c.getNombre() + "', apellido= '"
					+ c.getApellidos() + "', direccion = '" + c.getDireccion() + "', dni = '" + c.getDni()
					+ "', fecha = '" + c.getFecha() + "' WHERE id =" + c.getId();
			System.out.println(Query);
			Statement st = conexion.createStatement();
			st.execute(Query);
			state = true;
			System.out.println("Datos modificados correctamente");

			closeConnection();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("Error al modificar el usuario");
		}
		return state;
	}
	
	public static boolean updateClientVideo(int idVideo, int idCliente) {
		boolean state = false;
		try {
			Connection conexion = ConexionDB();

			String Querydb = "USE " + db + ";";
			Statement stdb = conexion.createStatement();
			stdb.executeUpdate(Querydb);
			System.out.println("Esta utilizando la base de datos: " + db);

			String Query = "UPDATE " + table_videos + " SET cli_id = " + idCliente + " WHERE id =" + idVideo;
			System.out.println(Query);
			Statement st = conexion.createStatement();
			st.execute(Query);
			state = true;
			System.out.println("Datos modificados correctamente");

			closeConnection();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("Error al asignar un video");
		}
		return state;
	}

	public static boolean deleteCliente(int id) {
		boolean state = false;
		try {
			Connection conexion = ConexionDB();

			String Querydb = "USE " + db + ";";
			Statement stdb = conexion.createStatement();
			stdb.executeUpdate(Querydb);
			System.out.println("Esta utilizando la base de datos: " + db);

			String Query = "DELETE FROM " + table_cliente + " WHERE id = " + id;
			System.out.println(Query);
			Statement st = conexion.createStatement();
			st.execute(Query);
			System.out.println("Cliente eliminado correctamente");
			
			state = true;
			closeConnection();

		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("Error al eliminar el usuario");
		}
		return state;
	}
	
	public static boolean deleteVideo(int id) {
		boolean state = false;
		try {
			Connection conexion = ConexionDB();

			String Querydb = "USE " + db + ";";
			Statement stdb = conexion.createStatement();
			stdb.executeUpdate(Querydb);
			System.out.println("Esta utilizando la base de datos: " + db);

			String Query = "DELETE FROM " + table_videos + " WHERE id = " + id;
			System.out.println(Query);
			Statement st = conexion.createStatement();
			st.execute(Query);
			System.out.println("Cliente eliminado correctamente");
			
			state = true;
			closeConnection();

		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("Error al eliminar el usuario");
		}
		return state;
	}

	public static void closeConnection() {
		try {
			conexion.close();
			System.out.println("Se ha finalizado la conexion");
		} catch (Exception e) {
			System.out.println(e.getMessage());

		}
	}
}
