package exception;

@SuppressWarnings("serial")
public class SalarioInvalidoException extends Exception {
	
	private String msg;

	public SalarioInvalidoException() {
		
		this.msg = ("*** Salario não pode ser negativo. ***");

	}

	public String getMsg() {
		return msg;
	}
	
}
