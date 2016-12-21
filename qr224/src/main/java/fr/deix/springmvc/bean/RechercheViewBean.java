package fr.deix.springmvc.bean;

/**
 * Created by Amo on 27/06/2015.
 */
import javax.validation.constraints.Size;

public class RechercheViewBean {

    @Size(min=7, max=7, message="{view.recherche.code.invalid}")
    private String code;

    private String autre;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getAutre() {
        return autre;
    }

    public void setAutre(String autre) {
        this.autre = autre;
    }
}
