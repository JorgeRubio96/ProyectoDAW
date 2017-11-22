package mx.tec.inscripciones.viewmodel;

import java.util.ArrayList;
import java.util.List;

public class BaseViewModel {
    public String pageTitle;
    public String urlBase;
    public List<String> cssUriList = new ArrayList<>();
    public List<String> jsUriList = new ArrayList<>();

    public BaseViewModel(String pageTitile) {
        this.pageTitle = pageTitile + " - Sistema Inscripciones";
    }
}
