
package de.tudresden.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>GUI_setOffset complex type 的 Java 類別.
 * 
 * <p>下列綱要片段會指定此類別中包含的預期內容.
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
     * 取得 x 特性的值.
     * 
     */
    public double getX() {
        return x;
    }

    /**
     * 設定 x 特性的值.
     * 
     */
    public void setX(double value) {
        this.x = value;
    }

    /**
     * 取得 y 特性的值.
     * 
     */
    public double getY() {
        return y;
    }

    /**
     * 設定 y 特性的值.
     * 
     */
    public void setY(double value) {
        this.y = value;
    }

}
