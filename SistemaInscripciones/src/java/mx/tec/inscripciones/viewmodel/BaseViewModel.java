package mx.tec.inscripciones.viewmodel;

public class BaseViewModel {
    public String pageTitle;
    public String cssUri;
    public String jsUri;

    public BaseViewModel(String pageTitile) {
        this.pageTitle = pageTitile + " - Sistema Inscripciones";
    }
}
