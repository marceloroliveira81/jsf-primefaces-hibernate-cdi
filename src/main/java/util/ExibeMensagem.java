package util;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class ExibeMensagem {

	public static final void setMensagemInfo(String mensagem) {
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, mensagem, null));
	}
	
	public static final void setMensagemErro(String mensagem) {
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, mensagem, null));
	}
	
}