
package Server;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Base64;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.BufferedHttpEntity;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.json.JSONTokener;


public class QuickChart {
    
    private Integer width = 500;
	private Integer height = 300;
	private Double devicePixelRatio = 1.0;
	private String backgroundColor = "transparent";
	private String key;
	private String config;

	private String scheme;
	private String host;
	private Integer port;
        
        
        
        public QuickChart() {
		this("https", "quickchart.io", 443);
	}
        
        
        
        public QuickChart(String scheme, String host, Integer port) {
		this.scheme = scheme;
		this.host = host;
		this.port = port;
	}
        
        /***
         * get the width of of the chart
         * @return width 
         */
        public int getWidth() {
		return width;
	}
        
        /***
         * set width to the chart
         * @param width in pixel 
         */
        public void setWidth(int width) {
		this.width = width;
	}
        
        /***
         * get height to the form 
         * @return height
         */
        public int getHeight() {
		return height;
	}
        
        /***
         * set with to the chart in pixel
         * @param height in pixel
         */
        public void setHeight(int height) {
		this.height = height;
	}
        /***
         * get the device pixel ratio on chart
         * width and height multiply by this value
         * @return  device to pixel ratio
         */
        public double getDevicePixelRatio() {
		return devicePixelRatio;
	}
        
        /***
         * set device pixel ratio to chart
         * width and height multiply by this value
         * @param devicePixelRatio device to pixel ratio
         */
        public void setDevicePixelRatio(double devicePixelRatio) {
		this.devicePixelRatio = devicePixelRatio;
	}
        
        /***
         * get background color for chart
         * @return background color
         */
        public String getBackgroundColor() {
		return backgroundColor;
	}
        
        /***
         * set background color for chat
         * @param backgroundColor background color
         */
        public void setBackgroundColor(String backgroundColor) {
		this.backgroundColor = backgroundColor;
	}
        
        /***
         * get quick chart API key 
         * @return API key
         */
        public String getKey() {
		return key;
	}
        
        /***
         * set quick chart API key
         * @param key API key
         */
        public void setKey(String key) {
		this.key = key;
	}
        
        /***
         * get chart.js configuration
         * @return js configuration
         */
        public String getConfig() {
		return config;
	}
        
        /***
         * set chart.js configuration to render 
         * @param config chart.js. should be valid JSON or JavaScript
         */
        public void setConfig(String config) {
		this.config = config;
	}
        
        
        /***
         * generate URL for create chart
         * give port number to generate the chart
         * @return the URL of that will displaying chart
         * <https://github.com/typpo/quickchart-java/blob/main/src/main/java/io/quickchart/QuickChart.java>
         */
        public String getUrl() {
		URIBuilder builder = new URIBuilder();
		builder.setScheme(this.scheme);
		builder.setHost(this.host);
		if (port != 80 && port != 443) {
			builder.setPort(this.port);
		}
		builder.setPath("/chart");
		builder.addParameter("w", this.width.toString());
		builder.addParameter("h", this.height.toString());
		builder.addParameter("devicePixelRatio", this.devicePixelRatio.toString());
		if (!this.backgroundColor.equals("transparent")) {
			builder.addParameter("bkg", this.backgroundColor);
		}
		builder.addParameter("c", this.config);
		if (this.key != null && !this.key.isEmpty()) {
			builder.addParameter("key", this.key);
		}
		return builder.toString();
	}
        
        
        private String getPostJson() {
		JSONObject jsonBuilder = new JSONObject();
		jsonBuilder.put("width", this.width.toString());
		jsonBuilder.put("height", this.height.toString());
		jsonBuilder.put("devicePixelRatio", this.devicePixelRatio.toString());
		if (!this.backgroundColor.equals("transparent")) {
			jsonBuilder.put("backgroundColor", this.backgroundColor);
		}
		jsonBuilder.put("chart", this.config);
		if (this.key != null && !this.key.isEmpty()) {
			jsonBuilder.put("key", this.key);
		}
		return jsonBuilder.toString();
	}
        
        
        private HttpEntity executePost(String path) throws IOException {
		URIBuilder uriBuilder = new URIBuilder();
		uriBuilder.setScheme(this.scheme);
		uriBuilder.setHost(this.host);
		if (port != 80 && port != 443) {
			uriBuilder.setPort(this.port);
		}
		uriBuilder.setPath(path);

		CloseableHttpClient client = HttpClients.createDefault();
		HttpPost httpPost = new HttpPost(uriBuilder.toString());

		StringEntity entity = new StringEntity(this.getPostJson());
		httpPost.setEntity(entity);
		httpPost.setHeader("Accept", "application/json");
		httpPost.setHeader("Content-type", "application/json");

		HttpResponse response = client.execute(httpPost);
		if (response.getStatusLine().getStatusCode() != 200) {
			throw new RuntimeException("Received invalid status code from API endpoint");
		}
		HttpEntity ret = response.getEntity();
		return ret;
	}
        
        
        /***
         * Generate shortURL for display chart.
         * The charts rendered the URL visited
         * This URL is not permanate.
         * @return the short url that chart will generate 
         */
        
        public String getShortUrl() {
		try {
			HttpEntity entity = executePost("/chart/create");
			String rawResponse = EntityUtils.toString(entity);

			JSONTokener tokener = new JSONTokener(rawResponse);
			JSONObject jsonResponse = new JSONObject(tokener);
			return jsonResponse.getString("url");
		} catch (Exception ex) {
			return null;
		}
	}
        
        /***
         * Bytes that represent a PNG chart
         * @return chart bytes.if it's null the chart not will generated.
         */
        public byte[] toByteArray() {
		try {
			HttpEntity entity = executePost("/chart");
			return EntityUtils.toByteArray(entity);
		} catch (IOException ex) {
			return null;
		}
	}
        
        
        public String toDataUrl() {
		try {
			HttpEntity entity = executePost("/chart");
			return "data:image/png;base64," + Base64.getEncoder().encode(EntityUtils.toByteArray(entity));
		} catch (IOException ex) {
			return null;
		}
	}
        
        
        public void toFile(String filePath) throws IOException {
		HttpEntity entity = executePost("/chart");
		BufferedHttpEntity entityBuffer = new BufferedHttpEntity(entity);

		FileOutputStream os = new FileOutputStream(new File(filePath));
		entityBuffer.writeTo(os);
	}
    
    
}
