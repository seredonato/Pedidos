package Restaurante;

public class UsuarioExceptionPasswordIncorrecta extends Exception{
	public UsuarioExceptionPasswordIncorrecta() {
		super("La contraseņa debe cumplir con los requisitos: contener al menos 8 caracteres, el primer caracter sea un digito");
	}

}
