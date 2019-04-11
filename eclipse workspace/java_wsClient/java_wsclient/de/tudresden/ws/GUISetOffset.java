
package de.tudresden.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>GUI_setOffset complex type �� Java ���O.
 * 
 * <p>�U�C���n���q�|���w�����O���]�t���w�����e.
 * 
 * <pre>
 * &lt;complexType name="GUI_setOffset">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="viewID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="x" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="y" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GUI_setOffset", propOrder = {
    "viewID",
    "x",
    "y"
})
public class GUISetOffset {

    protected String viewID;
    protected double x;
    protected double y;

    /**
     * ���o viewID �S�ʪ���.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getViewID() {
        return viewID;
    }

    /**
     * �]�w viewID �S�ʪ���.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setViewID(String value) {
        this.viewID = value;
    }

    /**
     * ���o x �S�ʪ���.
     * 
     */
    public double getX() {
        return x;
    }

    /**
     * �]�w x �S�ʪ���.
     * 
     */
    public void setX(double value) {
        this.x = value;
    }

    /**
     * ���o y �S�ʪ���.
     * 
     */
    public double getY() {
        return y;
    }

    /**
     * �]�w y �S�ʪ���.
     * 
     */
    public void setY(double value) {
        this.y = value;
    }

}
