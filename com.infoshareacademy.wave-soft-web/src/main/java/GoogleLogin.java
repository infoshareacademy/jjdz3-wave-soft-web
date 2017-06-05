import com.github.scribejava.apis.GoogleApi20;
import com.github.scribejava.core.builder.ServiceBuilder;
import com.github.scribejava.core.model.*;
import com.github.scribejava.core.oauth.OAuth20Service;
import validator.MyConstants;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;


@WebServlet(urlPatterns = "/googlelogin")
public class GoogleLogin extends HttpServlet {
    @Inject
    SessionData sessionData;


    private static final String PROTECTED_RESOURCE_URL = "https://www.googleapis.com/oauth2/v2/userinfo";

    public static final String AUTHORIZATION_URL = "https://accounts.google.com/o/oauth2/auth?access_type=" +
            "offline&prompt=consent&response_type=code&client_id=617676105500-tfrcgit4oemcii4jbctllgr77b1mu0t6.apps.googleusercontent.c" +
            "om&redirect_uri=http%3A%2F%2Flocalhost%3A8080%2Fautoparts%2Fwelcome.jsp&scope=email&state=secret385568";


    String apiKey = MyConstants.GOOGLE_CLIENT_ID;
    String apiSecret = MyConstants.GOOGLE_CLIENT_SECRET;
    String callbackUrl = MyConstants.GOOGLE_REDIRECT_URL;


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");


        OAuth20Service service = new ServiceBuilder()
                .apiKey(apiKey)
                .apiSecret(apiSecret)
                .scope("profile")
                .scope("email")
                .callback(callbackUrl)
                .build(GoogleApi20.instance());


        resp.sendRedirect(AUTHORIZATION_URL);


        if (null != req.getParameter("error")) {
            req.setAttribute("error", req.getParameter("error"));
            return;
        }

//refresh_token or redirect
        final String code = req.getParameter("code");
        if (null != code) {
            OAuth2AccessToken accessToken = null;

            try {
                accessToken = service.getAccessToken(code);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }

            OAuthRequest request = new OAuthRequest(Verb.GET, PROTECTED_RESOURCE_URL);
            service.signRequest(accessToken, request);

            Response response = null;
            try {
                response = service.execute(request);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }

        }
        Map<String, String> sessionUser = new HashMap<>();
        req.setAttribute("oauth", sessionUser);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/welcome.jsp");
        dispatcher.forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

/*        OAuth20Service service = new ServiceBuilder()
                .apiKey(apiKey)
                .apiSecret(apiSecret)
                .scope("profile")
                .scope("email")
                .callback(callbackUrl)
                .build(GoogleApi20.instance());

        if (req.getParameter("login").equals("1")) {
            final Map<String, String> additionalParams = new HashMap<>();
            additionalParams.put("access_type", "offline");
            additionalParams.put("prompt", "consent");
            resp.sendRedirect(service.getAuthorizationUrl(additionalParams));
            req.setAttribute("oauth", "wysyłam żądanie do google...");
            RequestDispatcher dispatcher = req.getRequestDispatcher("/welcome.jsp");
            dispatcher.forward(req, resp);
        }*/
    }
}

