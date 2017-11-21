package mx.tec.inscripciones.viewmodel;

public class LoginViewModel extends BaseViewModel {
    public String error;
    public boolean hasError;
    
    public LoginViewModel(String error) {
        super("Login");

        this.error = error;
        hasError = error != null;
    }
}
