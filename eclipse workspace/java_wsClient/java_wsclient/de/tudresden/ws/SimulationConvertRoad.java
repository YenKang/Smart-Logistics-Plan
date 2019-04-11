
package de.tudresden.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Simulation_convertRoad complex type �� Java ���O.
 * 
 * <p>�U�C���n���q�|���w�����O���]�t���w�����e.
 * 
 * <pre>
 * &lt;complexType name="Simulation_convertRoad">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="x" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="y" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="isGeo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Simulation_convertRoad", propOrder = {
    "x",
    "y",
    "isGeo"
})
public class SimulationConvertRoad {

    protected double x;
    protected double y;
    protected String isGeo;

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

    /**
     * ���o isGeo �S�ʪ���.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIsGeo() {
        return isGeo;
    }

    /**
     * �]�w isGeo �S�ʪ���.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIsGeo(String value) {
        this.isGeo = value;
    }

}
