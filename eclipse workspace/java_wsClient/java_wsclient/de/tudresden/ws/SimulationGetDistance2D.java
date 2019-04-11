
package de.tudresden.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Simulation_getDistance2D complex type �� Java ���O.
 * 
 * <p>�U�C���n���q�|���w�����O���]�t���w�����e.
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
     * ���o x1 �S�ʪ���.
     * 
     */
    public double getX1() {
        return x1;
    }

    /**
     * �]�w x1 �S�ʪ���.
     * 
     */
    public void setX1(double value) {
        this.x1 = value;
    }

    /**
     * ���o y1 �S�ʪ���.
     * 
     */
    public double getY1() {
        return y1;
    }

    /**
     * �]�w y1 �S�ʪ���.
     * 
     */
    public void setY1(double value) {
        this.y1 = value;
    }

    /**
     * ���o x2 �S�ʪ���.
     * 
     */
    public double getX2() {
        return x2;
    }

    /**
     * �]�w x2 �S�ʪ���.
     * 
     */
    public void setX2(double value) {
        this.x2 = value;
    }

    /**
     * ���o y2 �S�ʪ���.
     * 
     */
    public double getY2() {
        return y2;
    }

    /**
     * �]�w y2 �S�ʪ���.
     * 
     */
    public void setY2(double value) {
        this.y2 = value;
    }

    /**
     * ���o isGeo �S�ʪ���.
     * 
     */
    public boolean isIsGeo() {
        return isGeo;
    }

    /**
     * �]�w isGeo �S�ʪ���.
     * 
     */
    public void setIsGeo(boolean value) {
        this.isGeo = value;
    }

    /**
     * ���o isDriving �S�ʪ���.
     * 
     */
    public boolean isIsDriving() {
        return isDriving;
    }

    /**
     * �]�w isDriving �S�ʪ���.
     * 
     */
    public void setIsDriving(boolean value) {
        this.isDriving = value;
    }

}
