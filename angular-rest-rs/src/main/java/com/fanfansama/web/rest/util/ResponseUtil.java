package com.fanfansama.web.rest.util;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.module.jaxb.JaxbAnnotationIntrospector;


import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static com.fanfansama.web.rest.util.CallMatchHttpHeader.AUTHENTICATION_TOKEN;

/**
 * Created by francois on 05/03/15.
 */
public class ResponseUtil {

    public static void initResponseHttpHeaders(HttpServletResponse response, SecurityErrorCode errorCode, String errorMessage) throws IOException {
        if (response != null) {
            // Ajoute les entêtes communs à toutes les réponses
            Map<String, String> responseHeaders = buildReponseCommonHttpHeaders();
            for (Map.Entry<String, String> responseHeader : responseHeaders.entrySet()) {
                response.addHeader(responseHeader.getKey(), responseHeader.getValue());
            }

            // Force le content-type de la réponse (forcément une erreur donc le contenu de la réponse est en JSON + UTF-8)
            response.addHeader("Content-Type", "application/json; charset=UTF-8");

            // Code HTTP de la réponse
            if (errorCode != null) {
                WebStatusCode webStatusCode = errorCode.getWebStatusCode();
                response.setStatus(webStatusCode.getStatutCode());
            }

            // Message d'erreur en JSON
            String json = transformErrorMessageToJson(errorCode, errorMessage);
            response.getWriter().write(json);
        }
    }

    /**
     * Retourne l'ensemble des entêtes HTTP que doit renvoyer le serveur dans ses réponses Cela concerne des problèmatiques de cross domain (cf. http://www.w3.org/TR/cors/), des
     * problèmatiques de cache, ...
     */
    private static Map<String, String> buildReponseCommonHttpHeaders() {
        Map<String, String> mapHeaders = new HashMap<String, String>();

        // --- GESTION DU CROSS DOMAIN ---

        // "Access-Control-Allow-Origin" : indique avec qui la ressource peut être partagée

        mapHeaders.put("Access-Control-Allow-Origin", "*");

        // "Access-Control-Allow-Headers" : indique au client quelles parties de l'entête
        // de la requête HTTP retournée par le serveur il peut utiliser

        StringBuilder allowHeaders = new StringBuilder();
        allowHeaders.append("Content-Type").append(", ");
        allowHeaders.append("Accept-Language").append(", ");
        allowHeaders.append("Accept-Encoding").append(", ");
        allowHeaders.append(AUTHENTICATION_TOKEN.getValue());


        mapHeaders.put("Access-Control-Allow-Headers", allowHeaders.toString());

        // --- GESTION DU CACHE ---

        // désactivation du cache pour pallier à un problème d'iOS 6 qui par défaut
        // cache les réponses des services (sans prendre en compte les paramètres ...)

        mapHeaders.put("Cache-Control", "no-cache");

        return mapHeaders;
    }

    /**
     * Créer le message d'erreur avec le code d'erreur et le message d'erreur en Json.
     *
     * @param errorCode
     * @param errorMessage
     * @return
     */
    public static String transformErrorMessageToJson(SecurityErrorCode errorCode, String errorMessage) {

        ErrorMessage message = new ErrorMessage();
        message.setMessage(errorMessage);

        if (errorCode.getCode() != null && errorCode.getCode().trim().length() > 0) {
            message.setCode(errorCode.getCode());
        }

        try {
            ObjectMapper mapper = new ObjectMapper();
            return mapper.writeValueAsString(message);

        } catch (JsonGenerationException e) {
            return e.getMessage();
        } catch (JsonMappingException e) {
            return e.getMessage();
        } catch (IOException e) {
            return e.getMessage();
        }
    }
}
