
package de.tudresden.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>sumoBoundingBox complex type �� Java ���O.
 * 
 * <p>�U�C���n���q�|���w�����O���]�t���w�����e.
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
     * ���o xMin �S�ʪ���.
     * 
     */
    public double getXMin() {
        return xMin;
    }

    /**
     * �]�w xMin �S�ʪ���.
     * 
     */
    public void setXMin(double value) {
        this.xMin = value;
    }

    /**
     * ���o yMin �S�ʪ���.
     * 
     */
    public double getYMin() {
        return yMin;
    }

    /**
     * �]�w yMin �S�ʪ���.
     * 
     */
    public void setYMin(double value) {
        this.yMin = value;
    }

    /**
     * ���o xMax �S�ʪ���.
     * 
     */
    public double getXMax() {
        return xMax;
    }

    /**
     * �]�w xMax �S�ʪ���.
     * 
     */
    public void setXMax(double value) {
        this.xMax = value;
    }

    /**
     * ���o yMax �S�ʪ���.
     * 
     */
    public double getYMax() {
        return yMax;
    }

    /**
     * �]�w yMax �S�ʪ���.
     * 
     */
    public void setYMax(double value) {
        this.yMax = value;
    }

}
