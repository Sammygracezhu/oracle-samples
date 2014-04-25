/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package javaeetutorial.dukestutoring.util;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 *
 * @author ian
 */
public enum StatusType {
    IN,
    OUT,
    PARK;

    public String toString(Locale locale) {
        ResourceBundle res = ResourceBundle.getBundle("javaeetutorial.dukestutoring.util.StatusMessages", locale);
        return res.getString(name() + ".string");
    }
    
    @Override
    public String toString() {
        Locale locale = Locale.getDefault();
        ResourceBundle res = ResourceBundle.getBundle("javaeetutorial.dukestutoring.util.StatusMessages", locale);
        return res.getString(name() + ".string");
    }
}
