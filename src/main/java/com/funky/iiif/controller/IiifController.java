package com.funky.iiif.controller;

import com.funky.iiif.IIIF;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * The publicly exposed URL endpoints of this IIIF image server implementation.
 *
 * <p>
 *     This controller exposes the URL endpoints as defined in the
 *     <a href="http://iiif.io/">IIIF specifications</a>.
 * </p>
 */
@Controller
public class IiifController {

    /**
     * A convenience endpoint for retrieving the original image.
     *
     * <p>
     *     This is not part of the IIIF specifications, but for ease-of-use, a client can specify ONLY the image's ID
     *     and get the original image back. No transformations will be made to the image.
     * </p>
     *
     * @param request GET request
     * @param id the ID of the image to retrieve
     * @return the original image with no transformations applied
     */
    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    @ResponseBody
    public String getQuickImage(HttpServletRequest request, @PathVariable("id") String id) {
        return getImage(request, id, IIIF.Region.FULL, IIIF.Size.FULL, "0", IIIF.Quality.NATIVE);
    }
    /**
     * Get metadata for an image in JSON-LD format.
     *
     * <p>
     *     The IIIF specifications define a URL endpoint for retrieving image metadata that includes the image id,
     *     dimensions, possible tiling information, available formats, available qualities, and compliance profile.
     *     This information is returned in a JSON-LD formatted string.
     * </p>
     *
     * @param request GET request that specifies the image ID
     * @param id retrieve information about the image specified by this ID
     * @return JSON-LD formatted string
     */
    @RequestMapping(value = "{id}/info.json", method = RequestMethod.GET)
    @ResponseBody
    public String getMetadataForImageById(HttpServletRequest request, @PathVariable("id") String id) {

        // TODO implement!

        return null;
    }

    /**
     * Get an image from the image server with specified properties.
     *
     * <p>
     *     This URL follows the&nbsp;
     *     <a href="http://iiif.io/api/image/1.1/#url-syntax-image-request">image request URL syntax</a>
     *     &nbsp;defined in the IIIF specifications:&nbsp;
     *     <code>{identifier}/{region}/{size}/{rotation}/{quality}{.format}</code>. Here, the format is optional.
     *     If the format is not included in the URL, the client's preferred return type will by inferred from the
     *     requests ACCEPT header. If this information is not present, then the server will return its default format.
     * </p>
     * <p>
     *     With four potential transforms to perform on the original image, each with possible loss of quality, they
     *     are applied in the same order to ensure consistent image quality of returned images. This order is:
     *     <ol>
     *         <li>region</li>
     *         <li>size</li>
     *         <li>rotation</li>
     *         <li>quality</li>
     *     </ol>
     * </p>
     *
     * @param request GET request containing all necessary information, as specified in the IIIF specifications.
     * @param id ID of the image to retrieve
     * @param region requested region of the image to return.
     * @param size requested size of the image to return.
     * @param rotation requested rotation of the image to return.
     * @return an image with the specified properties
     */
    @RequestMapping(value = "{id}/{region}/{size}/{rotation}/{qualityAndFormat}", method = RequestMethod.GET)
    @ResponseBody
    public String getImage(HttpServletRequest request,
                           @PathVariable("id") String id, @PathVariable("region") String region,
                           @PathVariable("size") String size,  @PathVariable("rotation") String rotation,
                           @PathVariable("qualityAndFormat") String qualmat) {

        // TODO implement!

        return null;
    }

}
