package es.curso.mvc.models;


	 public class RaizException extends Exception {
	 
	 	/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private String msg;
		 
		
		public RaizException(){
			msg = "No hay solución, raíz no válida";
		}
		
		
		public String getMessage(){ return msg; }
	} 