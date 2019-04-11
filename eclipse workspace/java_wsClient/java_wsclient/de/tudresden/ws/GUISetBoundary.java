
package de.tudresden.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>GUI_setBoundary complex type �� Java ���O.
 * 
 * <p>�U�C���n���q�|���w�����O���]�t���w�����e.
 * 
 * <pre>
 * &lt;complexType name="GUI_setBoundary">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="viewID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="xmin" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="ymin" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="xmax" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="ymax" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GUI_setBoundary", propOrder = {
    "viewID",
    "xmin",
    "ymin",
    "xmax",
    "ymax"
})
public class GUISetBoundary {

    protected String viewID;
    protected double xmin;
    protected double ymin;
    protected double xmax;
    protected double ymax;

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
     * ���o xmin �S�ʪ���.
     * 
     */
    public double getXmin() {
        return xmin;
    }

    /**
     * �]�w xmin �S�ʪ���.
     * 
     */
    public void setXmin(double value) {
        this.xmin = value;
    }

    /**
     * ���o ymin �S�ʪ���.
     * 
     */
    public double getYmin() {
        return ymin;
    }

    /**
     * �]�w ymin �S�ʪ���.
     * 
     */
    public void setYmin(double value) {
        this.ymin = value;
    }

    /**
     * ���o xmax �S�ʪ���.
     * 
     */
    public double getXmax() {
        return xmax;
    }

    /**
     * �]�w xmax �S�ʪ���.
     * 
     */
    public void setXmax(double value) {
        this.xmax = value;
    }

    /**
     * ���o ymax �S�ʪ���.
     * 
     */
    public double getYmax() {
        return ymax;
    }

    /**
     * �]�w ymax �S�ʪ���.
     * 
     */
    public void setYmax(double value) {
        this.ymax = value;
    }

}
