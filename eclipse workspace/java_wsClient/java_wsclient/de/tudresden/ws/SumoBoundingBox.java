
package de.tudresden.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>sumoBoundingBox complex type 的 Java 類別.
 * 
 * <p>下列綱要片段會指定此類別中包含的預期內容.
 * 
 * <pre>
 * &lt;complexType name="sumoBoundingBox">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="x_min" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="y_min" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="x_max" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="y_max" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "sumoBoundingBox", propOrder = {
    "xMin",
    "yMin",
    "xMax",
    "yMax"
})
public class SumoBoundingBox {

    @XmlElement(name = "x_min")
    protected double xMin;
    @XmlElement(name = "y_min")
    protected double yMin;
    @XmlElement(name = "x_max")
    protected double xMax;
    @XmlElement(name = "y_max")
    protected double yMax;

    /**
     * 取得 xMin 特性的值.
     * 
     */
    public double getXMin() {
        return xMin;
    }

    /**
     * 設定 xMin 特性的值.
     * 
     */
    public void setXMin(double value) {
        this.xMin = value;
    }

    /**
     * 取得 yMin 特性的值.
     * 
     */
    public double getYMin() {
        return yMin;
    }

    /**
     * 設定 yMin 特性的值.
     * 
     */
    public void setYMin(double value) {
        this.yMin = value;
    }

    /**
     * 取得 xMax 特性的值.
     * 
     */
    public double getXMax() {
        return xMax;
    }

    /**
     * 設定 xMax 特性的值.
     * 
     */
    public void setXMax(double value) {
        this.xMax = value;
    }

    /**
     * 取得 yMax 特性的值.
     * 
     */
    public double getYMax() {
        return yMax;
    }

    /**
     * 設定 yMax 特性的值.
     * 
     */
    public void setYMax(double value) {
        this.yMax = value;
    }

}
