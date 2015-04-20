package httpclient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;

public class TestBiz {
    public static void main(String[] args) throws ClientProtocolException, IOException {
        // Executor ex = Executors.newFixedThreadPool(10);

        while (true) {
            // ex.execute(new GetGroupView());
            new GetGroupView().run();
        }
    }
}

class GetGroupView implements Runnable {

    @Override
    public void run() {
        try {
            HttpClient client = HttpClientBuilder.create().build();
            HttpGet get = new HttpGet(
                    "http://localhost:8889/?service_type=event_service&service_action=group_view&member_id=1&start_time=20150303000000&end_time=20150330000000&group_id=1&page=1&tenant_id=1");
            HttpResponse response = client.execute(get);

            // Get the response
            BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));

            String line = "";
            while ((line = rd.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IllegalStateException | IOException e) {
            e.printStackTrace();
        }

    }

}
