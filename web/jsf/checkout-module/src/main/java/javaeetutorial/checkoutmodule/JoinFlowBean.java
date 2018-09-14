/**
 * Copyright (c) 2013 Oracle and/or its affiliates. All rights reserved.
 *
 * You may not modify, use, reproduce, or distribute this software except in
 * compliance with the terms of the License at:
 * http://java.net/projects/javaeetutorial/pages/BerkeleyLicense
 */
package javaeetutorial.checkoutmodule;

import java.io.Serializable;
import javax.inject.Named;
import javax.faces.flow.FlowScoped;
import javax.faces.model.SelectItem;

/**
 * Backing bean for JoinFlow.
 */
@Named
@FlowScoped("joinFlow")
public class JoinFlowBean implements Serializable {

    private static final long serialVersionUID = 1L;
    private boolean fanClub;
    private String[] newsletters;
    public static boolean joinTag;
    private static final SelectItem[] newsletterItems = {
        new SelectItem("Duke's Quarterly"),
        new SelectItem("Innovator's Almanac"),
        new SelectItem("Duke's Diet and Exercise Journal"),
        new SelectItem("Random Ramblings")
    };

    public JoinFlowBean() {
        this.newsletters = new String[0];
        joinFlowTag = true;
    }

    public String getReturnValue() {
        joinTag=false;
        if(CheckoutFlowBean.checkoutTag == true){
          CheckoutFlowBean.checkoutTag =false;
          
                 return "checkoutFlow";
        }
        return "/exithome";
    }

    public boolean isFanClub() {
        return fanClub;
    }

    public void setFanClub(boolean fanClub) {
        this.fanClub = fanClub;
    }

    public String[] getNewsletters() {
        return newsletters;
    }

    public void setNewsletters(String[] newsletters) {
        this.newsletters = newsletters;
    }

    public SelectItem[] getNewsletterItems() {
        return newsletterItems;
    }

}
