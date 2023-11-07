package Models;

public class VideoCliente {
	
	private int clienteId;
    private String clienteNombre;
    private int videoId;
    private String videoTitulo;
    
	public VideoCliente() {
	}

	public VideoCliente(int clienteId, String clienteNombre, int videoId, String videoTitulo) {
		this.clienteId = clienteId;
		this.clienteNombre = clienteNombre;
		this.videoId = videoId;
		this.videoTitulo = videoTitulo;
	}

	public int getClienteId() {
		return clienteId;
	}

	public void setClienteId(int clienteId) {
		this.clienteId = clienteId;
	}

	public String getClienteNombre() {
		return clienteNombre;
	}

	public void setClienteNombre(String clienteNombre) {
		this.clienteNombre = clienteNombre;
	}

	public int getVideoId() {
		return videoId;
	}

	public void setVideoId(int videoId) {
		this.videoId = videoId;
	}

	public String getVideoTitulo() {
		return videoTitulo;
	}

	public void setVideoTitulo(String videoTitulo) {
		this.videoTitulo = videoTitulo;
	}

	@Override
	public String toString() {
		return "ID Cliente: " + clienteId + " | Nombre Cliente: " + clienteNombre + " | ID Video asignado: " + videoId+ " | Titulo video: " + videoTitulo ;
	}
	
	

 
    
}
