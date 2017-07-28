package apiclient;


import com.ebay.services.client.ClientConfig;
import com.ebay.services.client.FindingServiceClientFactory;
import com.ebay.services.finding.*;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet("/ebaysearch")
public class EbayClientServlet extends HttpServlet {

    private static final String APP_ID = "PiotrGrn-WaveSoft-PRD-b8dfd86bc-143b122e";
    private static final String ENDPOINT = "http://svcs.ebay.com/services/search/FindingService/v1";

    private FindingServicePortType serviceClient;

    public EbayClientServlet() {
        super();
    }

    public void init() {

        ServletContext context = getServletContext();
        String appId = context.getInitParameter(APP_ID);
        String endpointAddress = context.getInitParameter(ENDPOINT);

        ClientConfig clientConfig = new ClientConfig();
        clientConfig.setEndPointAddress(endpointAddress);
        clientConfig.setApplicationId(appId);

        serviceClient = FindingServiceClientFactory.getServiceClient(clientConfig);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final int ENTRIES_PER_PAGE = 10;

        String searchPhrase = req.getParameter("searchPhrase");

        FindItemsByKeywordsRequest findRequest = new FindItemsByKeywordsRequest();

        findRequest.setKeywords(searchPhrase);
        PaginationInput pi = new PaginationInput();
        pi.setEntriesPerPage(ENTRIES_PER_PAGE);
        findRequest.setPaginationInput(pi);

        FindItemsByKeywordsResponse findResponse = serviceClient.findItemsByKeywords(findRequest);

        if (findResponse != null && findResponse.getSearchResult()!= null) {
            List<SearchItem> items = findResponse.getSearchResult().getItem();
            req.setAttribute("SearchResult", items);
        }
        req.setAttribute("QueryKeyWord", searchPhrase);

        req.getRequestDispatcher("/finding.jsp").forward(req, resp);



        /*req.setAttribute("searchResultList", ebayClient.searchOnEbay(searchPhrase));
        req.getRequestDispatcher("partsearchresults.jsp").forward(req, resp);*/
    }
}
