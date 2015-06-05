package jsf.beans;

import java.io.IOException;
import java.io.OutputStream;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ByteServlet")
public class ByteServlet extends HttpServlet {

    private final String image = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>\n"
            + "<!-- Created with Inkscape (http://www.inkscape.org/) -->\n"
            + "\n"
            + "<svg\n"
            + "   xmlns:dc=\"http://purl.org/dc/elements/1.1/\"\n"
            + "   xmlns:cc=\"http://creativecommons.org/ns#\"\n"
            + "   xmlns:rdf=\"http://www.w3.org/1999/02/22-rdf-syntax-ns#\"\n"
            + "   xmlns:svg=\"http://www.w3.org/2000/svg\"\n"
            + "   xmlns=\"http://www.w3.org/2000/svg\"\n"
            + "   xmlns:sodipodi=\"http://sodipodi.sourceforge.net/DTD/sodipodi-0.dtd\"\n"
            + "   xmlns:inkscape=\"http://www.inkscape.org/namespaces/inkscape\"\n"
            + "   width=\"237.49495\"\n"
            + "   height=\"273.35168\"\n"
            + "   id=\"svg2\"\n"
            + "   version=\"1.1\"\n"
            + "   inkscape:version=\"0.48.1 r9760\"\n"
            + "   sodipodi:docname=\"pin.svg\">\n"
            + "  <defs\n"
            + "     id=\"defs4\">\n"
            + "    <filter\n"
            + "       inkscape:collect=\"always\"\n"
            + "       id=\"filter3776\"\n"
            + "       x=\"-0.24358727\"\n"
            + "       width=\"1.4871745\"\n"
            + "       y=\"-0.0796092\"\n"
            + "       height=\"1.1592184\"\n"
            + "       color-interpolation-filters=\"sRGB\">\n"
            + "      <feGaussianBlur\n"
            + "         inkscape:collect=\"always\"\n"
            + "         stdDeviation=\"9.8671875\"\n"
            + "         id=\"feGaussianBlur3778\" />\n"
            + "    </filter>\n"
            + "  </defs>\n"
            + "  <sodipodi:namedview\n"
            + "     id=\"base\"\n"
            + "     pagecolor=\"#ffffff\"\n"
            + "     bordercolor=\"#666666\"\n"
            + "     borderopacity=\"1.0\"\n"
            + "     inkscape:pageopacity=\"0.0\"\n"
            + "     inkscape:pageshadow=\"2\"\n"
            + "     inkscape:zoom=\"0.62652209\"\n"
            + "     inkscape:cx=\"-93.531486\"\n"
            + "     inkscape:cy=\"-11.506359\"\n"
            + "     inkscape:document-units=\"px\"\n"
            + "     inkscape:current-layer=\"layer1\"\n"
            + "     showgrid=\"false\"\n"
            + "     fit-margin-top=\"0\"\n"
            + "     fit-margin-left=\"0\"\n"
            + "     fit-margin-right=\"0\"\n"
            + "     fit-margin-bottom=\"0\"\n"
            + "     inkscape:window-width=\"1230\"\n"
            + "     inkscape:window-height=\"776\"\n"
            + "     inkscape:window-x=\"50\"\n"
            + "     inkscape:window-y=\"24\"\n"
            + "     inkscape:window-maximized=\"1\" />\n"
            + "  <metadata\n"
            + "     id=\"metadata7\">\n"
            + "    <rdf:RDF>\n"
            + "      <cc:Work\n"
            + "         rdf:about=\"\">\n"
            + "        <dc:format>image/svg+xml</dc:format>\n"
            + "        <dc:type\n"
            + "           rdf:resource=\"http://purl.org/dc/dcmitype/StillImage\" />\n"
            + "        <dc:title />\n"
            + "      </cc:Work>\n"
            + "    </rdf:RDF>\n"
            + "  </metadata>\n"
            + "  <g\n"
            + "     inkscape:label=\"Layer 1\"\n"
            + "     inkscape:groupmode=\"layer\"\n"
            + "     id=\"layer1\"\n"
            + "     transform=\"translate(-55.63136,-27.279061)\">\n"
            + "    <path\n"
            + "       id=\"path3774\"\n"
            + "       d=\"m 155.14916,88.276524 0,9.90625 56.8125,0 0,-9.90625 -56.8125,0 z m 51.21875,13.031246 -47.125,0.5 -20.1875,98.8125 89,0 -21.6875,-99.3125 z m -71.4375,102.46875 0,9.90625 97.21875,0 0,-9.90625 -97.21875,0 z m 34.1875,13.03125 c -0.1832,28.15585 8.5336,112.30368 14.21875,168.9375 0,0 16.0667,-141.85637 14.5625,-168.9375 l -28.78125,0 z\"\n"
            + "       style=\"opacity:0.79166667;fill:#000000;fill-opacity:1;stroke:none;filter:url(#filter3776)\"\n"
            + "       inkscape:connector-curvature=\"0\"\n"
            + "       transform=\"matrix(0.69459623,0.60218532,-0.58517857,0.71478292,175.78617,-107.37204)\" />\n"
            + "    <path\n"
            + "       style=\"opacity:0.98999999;fill:#000000;fill-opacity:1;stroke:none\"\n"
            + "       d=\"m 231.89466,49.155055 -5.79692,7.080819 39.46175,34.211653 5.79692,-7.080818 -39.46175,-34.211654 z m 27.95075,40.157695 -33.02544,-28.020592 -71.84512,58.472872 61.81907,53.59449 43.05149,-84.04677 z m -109.58274,30.2243 -5.79692,7.08082 67.52777,58.5437 5.79693,-7.08082 -67.52778,-58.5437 z m 16.1209,29.90172 c -16.60345,20.015 -59.7903,85.41156 -88.982313,129.31597 0,0 94.171173,-91.72138 108.973663,-111.98432 l -19.99135,-17.33165 z\"\n"
            + "       id=\"rect2987\"\n"
            + "       inkscape:connector-curvature=\"0\" />\n"
            + "  </g>\n"
            + "</svg>".trim();

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("image/svg+xml");

        OutputStream out = response.getOutputStream();
        out.write(image.getBytes());
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
