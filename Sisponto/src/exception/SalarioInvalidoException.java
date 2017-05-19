package exception;

@SuppressWarnings("serial")
public class SalarioInvalidoException extends Exception {
	
	private String msg;

	public SalarioInvalidoException() {
		
		this.msg = ("*** Salario n�o pode ser negativo. ***");

	}

	public String getMsg() {
		return msg;
	}
	
}
