package edu.eci.cvds.FacesProject;

import java.util.*;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;



@ManagedBean(name = "calculadoraBean")
@SessionScoped
public class backingBean {
	private ArrayList<Float> datos;
	private float respuesta;
	private float promedio;
	private float desviacionEstandar;
	private float varianza;
	private float moda;
	
	/**
	 * metodo principal de la clase backingBean
	 */
	public backingBean() {
		datos= new ArrayList<Float>();
		promedio = 0;
		desviacionEstandar=0;		
		varianza=0;
		moda=0;
	}
	
	/**
	 * Debe recibir como parámetro el listado de valores y retornar el promedio de los números en ella.
	 * @param datos
	 * @return respuesta
	 */
	public float calculateMean(ArrayList<Float> datos) {
		respuesta=0;
		for (Float i : datos) respuesta += i ;respuesta = respuesta / datos.size();
	    return respuesta;
	    }
		 
	/**
	 * Debe recibir como parámetro el listado de valores y retornar el la desviación estandar de los números en ella.
	 * @param datos
	 * @return respuesta
	 */
	public Float calculateStandardDeviation(ArrayList<Float> datos) {
		desviacionEstandar = 0;
		desviacionEstandar =(float) Math.pow(calculateVariance(datos), 0.5);
		return desviacionEstandar;
		}
		 
	/**
	 * Debe recibir como parámetro el listado de valores y retornar la varianza de los números en ella.
	 * @param datos
	 * @return respuesta
	 */
	public Float calculateVariance(ArrayList<Float> datos) {
		respuesta = 0; promedio = 0; varianza = 0;
		for (Float i : datos) promedio += i;
		promedio = promedio / datos.size();
		for (Float i : datos) varianza+= Math.pow(i-promedio,2);
		respuesta = varianza / datos.size();
		return respuesta;
		}
	
	 /**
	  * Debe recibir como parámetro el listado de valores y retornar la moda de los números en ella.
	  * @param datos
	  * @return 
	  */
	  public Float calculateMode(ArrayList<Float> datos) {
		  	moda=0; int maxRep=0; int rep = 0;

	        for (int i=0;i<datos.size(); i++) {
	        	for (int j = 0; j < datos.size(); j++) {
	                if (datos.get(i) == datos.get(j))rep++;
	                if (rep>maxRep) { 
	                		moda= datos.get(i);
	                		maxRep=rep;
	                		}
	                }
	        }
	        return moda;
	  }
	/**
	 * Debe volver a iniciar la aplicación (Borrar el campo de texto para que el usuario agregue los datos).
	 */
	  public void restart(){
		  this.promedio=0;
		  this.desviacionEstandar=0;
		  this.varianza=0;
		  this.moda=0;
		  this.respuesta=0;
		  this.datos = null;
		  
	  }
	  
	  	// metodos GET
	  	public ArrayList<Float> getDatos() {
			return datos;
		}
		public float getPromedio() {
			return promedio;
		}
		public float getDesviacionEstandar() {
			return desviacionEstandar;
		}
		public float getvarianza() {
			return varianza;
		}
		public float getmoda() {
			return moda;
		}
		
		// metodos SET
		public void setDatos(ArrayList <Float> datos){
			this.datos = datos;
		}
		 public void setPromedio(float promedio) {
		        this.promedio = promedio;
		}
		 public void setDesviacionEstandar(float DesviacionEstandar) {
		        this.desviacionEstandar = DesviacionEstandar;
		}
		 public void setVarianza(float varianza) {
		        this.varianza = varianza;
		}
		 public void setModa(float moda) {
		        this.moda = moda;
		}
}
