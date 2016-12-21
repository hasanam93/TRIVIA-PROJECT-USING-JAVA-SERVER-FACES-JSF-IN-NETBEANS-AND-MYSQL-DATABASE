/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.session;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Student
 */
@SessionScoped
@Named("commonbean")
public class commonbean implements Serializable{
    private String css;

    public String getCss() {
        return css;
    }

    public void setCss(String css) {
        this.css = css;
    }
    public void setsess(String var,String data)
    {
        FacesContext fc=FacesContext.getCurrentInstance();
        HttpSession session= (HttpSession) fc.getExternalContext().getSession(true);
        if (var.equals("sessioncss"))
        {
            session.setAttribute("sessioncss", data);
            
        }
    }
    public String getsess(String var)
    {
        FacesContext fc=    FacesContext.getCurrentInstance();
        HttpSession session=(HttpSession) fc.getExternalContext().getSession(true);
    if (var.equals("sessioncss"))
        
            if((session.getAttribute("sessioncss")!= null))
            {
            return session.getAttribute("sessioncss").toString();
            
        }
            return "nil";
    
}
}