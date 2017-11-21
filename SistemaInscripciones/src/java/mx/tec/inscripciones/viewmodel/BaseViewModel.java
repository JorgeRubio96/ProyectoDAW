package mx.tec.inscripciones.viewmodel;

public class BaseViewModel {
    public String pageTitle;
    
    public BaseViewModel(String pageTitile) {
        this.pageTitle = "Sistema Inscripciones - " + pageTitile;
    }
}
