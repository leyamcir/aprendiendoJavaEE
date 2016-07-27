
package curso;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the curso package. 
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

    private final static QName _Esprimo_QNAME = new QName("http://curso/", "esprimo");
    private final static QName _Exception_QNAME = new QName("http://curso/", "Exception");
    private final static QName _Info_QNAME = new QName("http://curso/", "info");
    private final static QName _Hola_QNAME = new QName("http://curso/", "hola");
    private final static QName _EsprimoResponse_QNAME = new QName("http://curso/", "esprimoResponse");
    private final static QName _InfoResponse_QNAME = new QName("http://curso/", "infoResponse");
    private final static QName _HolaResponse_QNAME = new QName("http://curso/", "holaResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: curso
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link HolaResponse }
     * 
     */
    public HolaResponse createHolaResponse() {
        return new HolaResponse();
    }

    /**
     * Create an instance of {@link Esprimo }
     * 
     */
    public Esprimo createEsprimo() {
        return new Esprimo();
    }

    /**
     * Create an instance of {@link Hola }
     * 
     */
    public Hola createHola() {
        return new Hola();
    }

    /**
     * Create an instance of {@link EsprimoResponse }
     * 
     */
    public EsprimoResponse createEsprimoResponse() {
        return new EsprimoResponse();
    }

    /**
     * Create an instance of {@link InfoResponse }
     * 
     */
    public InfoResponse createInfoResponse() {
        return new InfoResponse();
    }

    /**
     * Create an instance of {@link Exception }
     * 
     */
    public Exception createException() {
        return new Exception();
    }

    /**
     * Create an instance of {@link Info }
     * 
     */
    public Info createInfo() {
        return new Info();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Esprimo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://curso/", name = "esprimo")
    public JAXBElement<Esprimo> createEsprimo(Esprimo value) {
        return new JAXBElement<Esprimo>(_Esprimo_QNAME, Esprimo.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Exception }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://curso/", name = "Exception")
    public JAXBElement<Exception> createException(Exception value) {
        return new JAXBElement<Exception>(_Exception_QNAME, Exception.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Info }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://curso/", name = "info")
    public JAXBElement<Info> createInfo(Info value) {
        return new JAXBElement<Info>(_Info_QNAME, Info.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Hola }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://curso/", name = "hola")
    public JAXBElement<Hola> createHola(Hola value) {
        return new JAXBElement<Hola>(_Hola_QNAME, Hola.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EsprimoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://curso/", name = "esprimoResponse")
    public JAXBElement<EsprimoResponse> createEsprimoResponse(EsprimoResponse value) {
        return new JAXBElement<EsprimoResponse>(_EsprimoResponse_QNAME, EsprimoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InfoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://curso/", name = "infoResponse")
    public JAXBElement<InfoResponse> createInfoResponse(InfoResponse value) {
        return new JAXBElement<InfoResponse>(_InfoResponse_QNAME, InfoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link HolaResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://curso/", name = "holaResponse")
    public JAXBElement<HolaResponse> createHolaResponse(HolaResponse value) {
        return new JAXBElement<HolaResponse>(_HolaResponse_QNAME, HolaResponse.class, null, value);
    }

}
