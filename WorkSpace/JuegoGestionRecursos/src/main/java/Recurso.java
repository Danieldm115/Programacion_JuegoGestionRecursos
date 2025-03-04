
import java.util.*;

public class Recurso {
	   private TipoRecurso tipo;
	    private int cantidad;

	    public Recurso(TipoRecurso tipo, int cantidad) {
	        this.tipo = tipo;
	        this.cantidad = cantidad;
	    }

	    public void incrementarCantidad(int cantidad) {
	        this.cantidad += cantidad;
	    }

	    public void decrementarCantidad(int cantidad) {
	        this.cantidad -= cantidad;
	    }

	    
	    public String quedaRecurso(TipoRecurso tipo){
	        if(tipo == this.tipo && cantidad > 0){
	            return "Quedan recursos";
	        }else{
	            return "No quedan recursos";
	        }
	    }

	    public String quedariaRecurso(TipoRecurso tipo, int cantidad){
	        if(tipo == this.tipo && cantidad <= this.cantidad){
	            return "Quedarian recursos";
	        }else{
	            return "No quedarian recursos";
	        }
	    } 
	    
	    public TipoRecurso getTipo() {
	        return tipo;
	    }

	    public int getCantidad() {
	        return cantidad;
	    }
	    
	    public void setCantidad(int cantidad) {
	        this.cantidad = cantidad;
	    }

	}
