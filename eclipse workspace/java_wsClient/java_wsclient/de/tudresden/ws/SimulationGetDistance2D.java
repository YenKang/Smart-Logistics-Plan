
package de.tudresden.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Simulation_getDistance2D complex type 的 Java 類別.
 * 
 * <p>下列綱要片段會指定此類別中包含的預期內容.
 * 
 * <pre>
 * &lt;complexType name="Simulation_getDistance2D">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="x1" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="y1" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="x2" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="y2" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="isGeo" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="isDriving" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Simulation_getDistance2D", propOrder = {
    "x1",
    "y1",
    "x2",
    "y2",
    "isGeo",
    "isDriving"
})
public class SimulationGetDistance2D {

    protected double x1;
    protected double y1;
    protected double x2;
    protected double y2;
    protected boolean isGeo;
    protected boolean isDriving;

    /**
     * 取得 x1 特性的值.
     * 
     */
    public double getX1() {
        return x1;
    }

    /**
     * 設定 x1 特性的值.
     * 
     */
    public void setX1(double value) {
        this.x1 = value;
    }

    /**
     * 取得 y1 特性的值.
     * 
     */
    public double getY1() {
        return y1;
    }

    /**
     * 設定 y1 特性的值.
     * 
     */
    public void setY1(double value) {
        this.y1 = value;
    }

    /**
     * 取得 x2 特性的值.
     * 
     */
    public double getX2() {
        return x2;
    }

    /**
     * 設定 x2 特性的值.
     * 
     */
    public void setX2(double value) {
        this.x2 = value;
    }

    /**
     * 取得 y2 特性的值.
     * 
     */
    public double getY2() {
        return y2;
    }

    /**
     * 設定 y2 特性的值.
     * 
     */
    public void setY2(double value) {
        this.y2 = value;
    }

    /**
     * 取得 isGeo 特性的值.
     * 
     */
    public boolean isIsGeo() {
        return isGeo;
    }

    /**
     * 設定 isGeo 特性的值.
     * 
     */
    public void setIsGeo(boolean value) {
        this.isGeo = value;
    }

    /**
     * 取得 isDriving 特性的值.
     * 
     */
    public boolean isIsDriving() {
        return isDriving;
    }

    /**
     * 設定 isDriving 特性的值.
     * 
     */
    public void setIsDriving(boolean value) {
        this.isDriving = value;
    }

}
