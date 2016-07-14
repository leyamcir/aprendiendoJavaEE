package es.curso.mvc.models;


	 public class RaizException extends Exception {
	 
	 	/**
		 * Custom Exception for EcuacionGrado2
		 */
		private static final long serialVersionUID = 1L;
		private String msg;
		 
		
		public RaizException(){
			msg = "No hay soluci�n, ra�z no v�lida";
		}
		
		
		public String getMessage(){ return msg; }
	} 