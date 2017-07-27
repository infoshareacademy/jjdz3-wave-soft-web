package apiclient;

import com.ebay.services.client.ClientConfig;
import com.ebay.services.client.FindingServiceClientFactory;
import com.ebay.services.finding.*;

import javax.enterprise.inject.Default;
import java.util.List;

@Default
public class EbayClient {
    private static final String APP_ID = "PiotrGrn-WaveSoft-PRD-b8dfd86bc-143b122e";
    private static final String ENDPOINT = "https://svcs.ebay.com/services/search/FindingService/v1";

    private FindingServicePortType serviceClient;
    private List<SearchItem> resultList;

    public EbayClient() {

        try {
            ClientConfig config = new ClientConfig();
            config.setEndPointAddress(ENDPOINT);
            config.setApplicationId(APP_ID);

            this.serviceClient = FindingServiceClientFactory.getServiceClient(config);
        } catch (Exception e) {
            System.out.println("Can't create an eBay client.");
            e.printStackTrace();
        }
    }

    public List<SearchItem> searchOnEbay(String searchPhrase){
        final int ENTRIES_PER_PAGE = 10;

        try {
            FindItemsAdvancedRequest request = new FindItemsAdvancedRequest();
            request.setKeywords(searchPhrase);

            PaginationInput pi = new PaginationInput();
            pi.setEntriesPerPage(ENTRIES_PER_PAGE);
            request.setPaginationInput(pi);

            FindItemsAdvancedResponse result = this.serviceClient.findItemsAdvanced(request);
            this.resultList = result.getSearchResult().getItem();
        } catch (Exception e) {
            System.out.println("Can't call an eBay API.");
            e.printStackTrace();
        }
        return this.resultList;
    }

    public List<SearchItem> getResultList() {
        return resultList;
    }

    public static String getAppId() {
        return APP_ID;
    }

    public static String getEndPoint() {
        return ENDPOINT;
    }
}
