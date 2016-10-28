
package project3task1client;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the project3task1client package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _HighTemperature_QNAME = new QName("http://webserviceprovider/", "highTemperature");
    private final static QName _LowTemperatureResponse_QNAME = new QName("http://webserviceprovider/", "lowTemperatureResponse");
    private final static QName _GetLastTemperature_QNAME = new QName("http://webserviceprovider/", "getLastTemperature");
    private final static QName _GetTemperaturesResponse_QNAME = new QName("http://webserviceprovider/", "getTemperaturesResponse");
    private final static QName _GetLastTemperatureResponse_QNAME = new QName("http://webserviceprovider/", "getLastTemperatureResponse");
    private final static QName _NoSuchAlgorithmException_QNAME = new QName("http://webserviceprovider/", "NoSuchAlgorithmException");
    private final static QName _GetTemperatures_QNAME = new QName("http://webserviceprovider/", "getTemperatures");
    private final static QName _HighTemperatureResponse_QNAME = new QName("http://webserviceprovider/", "highTemperatureResponse");
    private final static QName _LowTemperature_QNAME = new QName("http://webserviceprovider/", "lowTemperature");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: project3task1client
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetLastTemperature }
     * 
     */
    public GetLastTemperature createGetLastTemperature() {
        return new GetLastTemperature();
    }

    /**
     * Create an instance of {@link GetTemperaturesResponse }
     * 
     */
    public GetTemperaturesResponse createGetTemperaturesResponse() {
        return new GetTemperaturesResponse();
    }

    /**
     * Create an instance of {@link HighTemperature }
     * 
     */
    public HighTemperature createHighTemperature() {
        return new HighTemperature();
    }

    /**
     * Create an instance of {@link LowTemperatureResponse }
     * 
     */
    public LowTemperatureResponse createLowTemperatureResponse() {
        return new LowTemperatureResponse();
    }

    /**
     * Create an instance of {@link GetLastTemperatureResponse }
     * 
     */
    public GetLastTemperatureResponse createGetLastTemperatureResponse() {
        return new GetLastTemperatureResponse();
    }

    /**
     * Create an instance of {@link NoSuchAlgorithmException }
     * 
     */
    public NoSuchAlgorithmException createNoSuchAlgorithmException() {
        return new NoSuchAlgorithmException();
    }

    /**
     * Create an instance of {@link GetTemperatures }
     * 
     */
    public GetTemperatures createGetTemperatures() {
        return new GetTemperatures();
    }

    /**
     * Create an instance of {@link HighTemperatureResponse }
     * 
     */
    public HighTemperatureResponse createHighTemperatureResponse() {
        return new HighTemperatureResponse();
    }

    /**
     * Create an instance of {@link LowTemperature }
     * 
     */
    public LowTemperature createLowTemperature() {
        return new LowTemperature();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link HighTemperature }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webserviceprovider/", name = "highTemperature")
    public JAXBElement<HighTemperature> createHighTemperature(HighTemperature value) {
        return new JAXBElement<HighTemperature>(_HighTemperature_QNAME, HighTemperature.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LowTemperatureResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webserviceprovider/", name = "lowTemperatureResponse")
    public JAXBElement<LowTemperatureResponse> createLowTemperatureResponse(LowTemperatureResponse value) {
        return new JAXBElement<LowTemperatureResponse>(_LowTemperatureResponse_QNAME, LowTemperatureResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetLastTemperature }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webserviceprovider/", name = "getLastTemperature")
    public JAXBElement<GetLastTemperature> createGetLastTemperature(GetLastTemperature value) {
        return new JAXBElement<GetLastTemperature>(_GetLastTemperature_QNAME, GetLastTemperature.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetTemperaturesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webserviceprovider/", name = "getTemperaturesResponse")
    public JAXBElement<GetTemperaturesResponse> createGetTemperaturesResponse(GetTemperaturesResponse value) {
        return new JAXBElement<GetTemperaturesResponse>(_GetTemperaturesResponse_QNAME, GetTemperaturesResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetLastTemperatureResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webserviceprovider/", name = "getLastTemperatureResponse")
    public JAXBElement<GetLastTemperatureResponse> createGetLastTemperatureResponse(GetLastTemperatureResponse value) {
        return new JAXBElement<GetLastTemperatureResponse>(_GetLastTemperatureResponse_QNAME, GetLastTemperatureResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link NoSuchAlgorithmException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webserviceprovider/", name = "NoSuchAlgorithmException")
    public JAXBElement<NoSuchAlgorithmException> createNoSuchAlgorithmException(NoSuchAlgorithmException value) {
        return new JAXBElement<NoSuchAlgorithmException>(_NoSuchAlgorithmException_QNAME, NoSuchAlgorithmException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetTemperatures }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webserviceprovider/", name = "getTemperatures")
    public JAXBElement<GetTemperatures> createGetTemperatures(GetTemperatures value) {
        return new JAXBElement<GetTemperatures>(_GetTemperatures_QNAME, GetTemperatures.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link HighTemperatureResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webserviceprovider/", name = "highTemperatureResponse")
    public JAXBElement<HighTemperatureResponse> createHighTemperatureResponse(HighTemperatureResponse value) {
        return new JAXBElement<HighTemperatureResponse>(_HighTemperatureResponse_QNAME, HighTemperatureResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LowTemperature }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webserviceprovider/", name = "lowTemperature")
    public JAXBElement<LowTemperature> createLowTemperature(LowTemperature value) {
        return new JAXBElement<LowTemperature>(_LowTemperature_QNAME, LowTemperature.class, null, value);
    }

}
