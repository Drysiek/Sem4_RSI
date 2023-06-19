
package org.example.jaxws.server_topdown;

import javax.xml.namespace.QName;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlElementDecl;
import jakarta.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.example.jaxws.server_topdown package. 
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

    private final static QName _MovieExistsEx_QNAME = new QName("http://example.org/", "MovieExistsEx");
    private final static QName _MovieNotFoundEx_QNAME = new QName("http://example.org/", "MovieNotFoundEx");
    private final static QName _AddMovie_QNAME = new QName("http://example.org/", "addMovie");
    private final static QName _AddMovieResponse_QNAME = new QName("http://example.org/", "addMovieResponse");
    private final static QName _CountMovie_QNAME = new QName("http://example.org/", "countMovie");
    private final static QName _CountMovieResponse_QNAME = new QName("http://example.org/", "countMovieResponse");
    private final static QName _DeleteMovie_QNAME = new QName("http://example.org/", "deleteMovie");
    private final static QName _DeleteMovieResponse_QNAME = new QName("http://example.org/", "deleteMovieResponse");
    private final static QName _GetAllMovies_QNAME = new QName("http://example.org/", "getAllMovies");
    private final static QName _GetAllMoviesResponse_QNAME = new QName("http://example.org/", "getAllMoviesResponse");
    private final static QName _GetMovie_QNAME = new QName("http://example.org/", "getMovie");
    private final static QName _GetMovieResponse_QNAME = new QName("http://example.org/", "getMovieResponse");
    private final static QName _UpdateMovie_QNAME = new QName("http://example.org/", "updateMovie");
    private final static QName _UpdateMovieResponse_QNAME = new QName("http://example.org/", "updateMovieResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.example.jaxws.server_topdown
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link MovieExistsEx }
     * 
     */
    public MovieExistsEx createMovieExistsEx() {
        return new MovieExistsEx();
    }

    /**
     * Create an instance of {@link MovieNotFoundEx }
     * 
     */
    public MovieNotFoundEx createMovieNotFoundEx() {
        return new MovieNotFoundEx();
    }

    /**
     * Create an instance of {@link AddMovie }
     * 
     */
    public AddMovie createAddMovie() {
        return new AddMovie();
    }

    /**
     * Create an instance of {@link AddMovieResponse }
     * 
     */
    public AddMovieResponse createAddMovieResponse() {
        return new AddMovieResponse();
    }

    /**
     * Create an instance of {@link CountMovie }
     * 
     */
    public CountMovie createCountMovie() {
        return new CountMovie();
    }

    /**
     * Create an instance of {@link CountMovieResponse }
     * 
     */
    public CountMovieResponse createCountMovieResponse() {
        return new CountMovieResponse();
    }

    /**
     * Create an instance of {@link DeleteMovie }
     * 
     */
    public DeleteMovie createDeleteMovie() {
        return new DeleteMovie();
    }

    /**
     * Create an instance of {@link DeleteMovieResponse }
     * 
     */
    public DeleteMovieResponse createDeleteMovieResponse() {
        return new DeleteMovieResponse();
    }

    /**
     * Create an instance of {@link GetAllMovies }
     * 
     */
    public GetAllMovies createGetAllMovies() {
        return new GetAllMovies();
    }

    /**
     * Create an instance of {@link GetAllMoviesResponse }
     * 
     */
    public GetAllMoviesResponse createGetAllMoviesResponse() {
        return new GetAllMoviesResponse();
    }

    /**
     * Create an instance of {@link GetMovie }
     * 
     */
    public GetMovie createGetMovie() {
        return new GetMovie();
    }

    /**
     * Create an instance of {@link GetMovieResponse }
     * 
     */
    public GetMovieResponse createGetMovieResponse() {
        return new GetMovieResponse();
    }

    /**
     * Create an instance of {@link UpdateMovie }
     * 
     */
    public UpdateMovie createUpdateMovie() {
        return new UpdateMovie();
    }

    /**
     * Create an instance of {@link UpdateMovieResponse }
     * 
     */
    public UpdateMovieResponse createUpdateMovieResponse() {
        return new UpdateMovieResponse();
    }

    /**
     * Create an instance of {@link Movie }
     * 
     */
    public Movie createMovie() {
        return new Movie();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MovieExistsEx }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link MovieExistsEx }{@code >}
     */
    @XmlElementDecl(namespace = "http://example.org/", name = "MovieExistsEx")
    public JAXBElement<MovieExistsEx> createMovieExistsEx(MovieExistsEx value) {
        return new JAXBElement<MovieExistsEx>(_MovieExistsEx_QNAME, MovieExistsEx.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MovieNotFoundEx }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link MovieNotFoundEx }{@code >}
     */
    @XmlElementDecl(namespace = "http://example.org/", name = "MovieNotFoundEx")
    public JAXBElement<MovieNotFoundEx> createMovieNotFoundEx(MovieNotFoundEx value) {
        return new JAXBElement<MovieNotFoundEx>(_MovieNotFoundEx_QNAME, MovieNotFoundEx.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddMovie }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AddMovie }{@code >}
     */
    @XmlElementDecl(namespace = "http://example.org/", name = "addMovie")
    public JAXBElement<AddMovie> createAddMovie(AddMovie value) {
        return new JAXBElement<AddMovie>(_AddMovie_QNAME, AddMovie.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddMovieResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AddMovieResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://example.org/", name = "addMovieResponse")
    public JAXBElement<AddMovieResponse> createAddMovieResponse(AddMovieResponse value) {
        return new JAXBElement<AddMovieResponse>(_AddMovieResponse_QNAME, AddMovieResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CountMovie }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CountMovie }{@code >}
     */
    @XmlElementDecl(namespace = "http://example.org/", name = "countMovie")
    public JAXBElement<CountMovie> createCountMovie(CountMovie value) {
        return new JAXBElement<CountMovie>(_CountMovie_QNAME, CountMovie.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CountMovieResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CountMovieResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://example.org/", name = "countMovieResponse")
    public JAXBElement<CountMovieResponse> createCountMovieResponse(CountMovieResponse value) {
        return new JAXBElement<CountMovieResponse>(_CountMovieResponse_QNAME, CountMovieResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteMovie }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DeleteMovie }{@code >}
     */
    @XmlElementDecl(namespace = "http://example.org/", name = "deleteMovie")
    public JAXBElement<DeleteMovie> createDeleteMovie(DeleteMovie value) {
        return new JAXBElement<DeleteMovie>(_DeleteMovie_QNAME, DeleteMovie.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteMovieResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DeleteMovieResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://example.org/", name = "deleteMovieResponse")
    public JAXBElement<DeleteMovieResponse> createDeleteMovieResponse(DeleteMovieResponse value) {
        return new JAXBElement<DeleteMovieResponse>(_DeleteMovieResponse_QNAME, DeleteMovieResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllMovies }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetAllMovies }{@code >}
     */
    @XmlElementDecl(namespace = "http://example.org/", name = "getAllMovies")
    public JAXBElement<GetAllMovies> createGetAllMovies(GetAllMovies value) {
        return new JAXBElement<GetAllMovies>(_GetAllMovies_QNAME, GetAllMovies.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllMoviesResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetAllMoviesResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://example.org/", name = "getAllMoviesResponse")
    public JAXBElement<GetAllMoviesResponse> createGetAllMoviesResponse(GetAllMoviesResponse value) {
        return new JAXBElement<GetAllMoviesResponse>(_GetAllMoviesResponse_QNAME, GetAllMoviesResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetMovie }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetMovie }{@code >}
     */
    @XmlElementDecl(namespace = "http://example.org/", name = "getMovie")
    public JAXBElement<GetMovie> createGetMovie(GetMovie value) {
        return new JAXBElement<GetMovie>(_GetMovie_QNAME, GetMovie.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetMovieResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetMovieResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://example.org/", name = "getMovieResponse")
    public JAXBElement<GetMovieResponse> createGetMovieResponse(GetMovieResponse value) {
        return new JAXBElement<GetMovieResponse>(_GetMovieResponse_QNAME, GetMovieResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateMovie }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link UpdateMovie }{@code >}
     */
    @XmlElementDecl(namespace = "http://example.org/", name = "updateMovie")
    public JAXBElement<UpdateMovie> createUpdateMovie(UpdateMovie value) {
        return new JAXBElement<UpdateMovie>(_UpdateMovie_QNAME, UpdateMovie.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateMovieResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link UpdateMovieResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://example.org/", name = "updateMovieResponse")
    public JAXBElement<UpdateMovieResponse> createUpdateMovieResponse(UpdateMovieResponse value) {
        return new JAXBElement<UpdateMovieResponse>(_UpdateMovieResponse_QNAME, UpdateMovieResponse.class, null, value);
    }

}
