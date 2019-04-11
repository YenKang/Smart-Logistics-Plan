
package de.tudresden.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>GUI_setBoundary complex type 的 Java 類別.
 * 
 * <p>下列綱要片段會指定此類別中包含的預期內容.
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
     * 取得 viewID 特性的值.
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
     * 設定 viewID 特性的值.
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
     * 取得 xmin 特性的值.
     * 
     */
    public double getXmin() {
        return xmin;
    }

    /**
     * 設定 xmin 特性的值.
     * 
     */
    public void setXmin(double value) {
        this.xmin = value;
    }

    /**
     * 取得 ymin 特性的值.
     * 
     */
    public double getYmin() {
        return ymin;
    }

    /**
     * 設定 ymin 特性的值.
     * 
     */
    public void setYmin(double value) {
        this.ymin = value;
    }

    /**
     * 取得 xmax 特性的值.
     * 
     */
    public double getXmax() {
        return xmax;
    }

    /**
     * 設定 xmax 特性的值.
     * 
     */
    public void setXmax(double value) {
        this.xmax = value;
    }

    /**
     * 取得 ymax 特性的值.
     * 
     */
    public double getYmax() {
        return ymax;
    }

    /**
     * 設定 ymax 特性的值.
     * 
     */
    public void setYmax(double value) {
        this.ymax = value;
    }

}
