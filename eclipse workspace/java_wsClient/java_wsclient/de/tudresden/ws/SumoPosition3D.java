
package de.tudresden.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>sumoPosition3D complex type 的 Java 類別.
 * 
 * <p>下列綱要片段會指定此類別中包含的預期內容.
 * 
 * <pre>
 * &lt;complexType name="sumoPosition3D">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="x" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="y" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="z" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "sumoPosition3D", propOrder = {
    "x",
    "y",
    "z"
})
public class SumoPosition3D {

    protected double x;
    protected double y;
    protected double z;

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

    /**
     * 取得 z 特性的值.
     * 
     */
    public double getZ() {
        return z;
    }

    /**
     * 設定 z 特性的值.
     * 
     */
    public void setZ(double value) {
        this.z = value;
    }

}
