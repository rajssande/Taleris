package com.accenture.ge.aviation.component.listener;

import java.io.Serializable;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import org.apache.log4j.Logger;
import org.icefaces.ace.event.CloseEvent;
import org.icefaces.ace.event.ToggleEvent;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalServiceUtil;


public class PanelListener implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final static Logger LOGGER = Logger
			.getLogger(PanelListener.class);
	private String statusMessage;
	/**
	 * 
	 */
	public PanelListener() {
       
    }
    
   
    public String getStatusMessage() { return statusMessage; }
    
    public void setStatusMessage(String statusMessage) { this.statusMessage = statusMessage; }
    
    public void close(CloseEvent event) {
       
    }
    
    public void toggle(ToggleEvent event) throws NumberFormatException, PortalException, SystemException {
         FacesContext ctx=FacesContext.getCurrentInstance();
         ExternalContext ectx=ctx.getExternalContext();
         String userId=ectx.getRemoteUser();
         
         User user=UserLocalServiceUtil.getUserById(Long.parseLong(userId));
         statusMessage=user.getFullName();
        
    
    }

}
