package nl.brianvermeer;

import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.util.stream.Collectors;

public class SiteInfo {

    private CloseableHttpClient httpclient = HttpClients.createDefault();
    private String USER_AGENT = "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/87.0.4280.88 Safari/537.36";

    public String getSiteInfo(String url) {
        try {
            var uri = new URI(url);
            var httpGet = new HttpGet(uri);
            httpGet.setHeader("User-Agent", USER_AGENT);
            var response = httpclient.execute(httpGet);
            var entity = response.getEntity();

            InputStream ios = entity.getContent();
            String result = new BufferedReader(new InputStreamReader(ios, StandardCharsets.UTF_8)).lines()
                    .collect(Collectors.joining("\n"));

            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return "Sorry Something went wrong. Please check the logs!";
        }
    }
}
