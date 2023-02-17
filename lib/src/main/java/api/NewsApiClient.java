package api;

import model.*;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;

public class NewsApiClient {
	
	    private String mApiKey;
	    private Map<String, String> query;
	    private APIService mAPIService;

	    public NewsApiClient(String apiKey){
	        mApiKey = apiKey;
	        mAPIService = APIClient.getAPIService();
	        query = new HashMap<>();
	        query.put("apiKey", apiKey);
	    }

	    //Callbacks
	    public interface SourcesCallback{
	        void onSuccess(SourcesResponse response);
	        void onFailure(Throwable throwable);
	    }

	    public interface ArticlesResponseCallback{
	        void onSuccess(ArticleResponse response);
	        void onFailure(Throwable throwable);
	    }


	    private Throwable errMsg(String str) {
	        Throwable throwable = null;
	        try {
	            JSONObject obj = new JSONObject(str);
	            throwable = new Throwable(obj.getString("message"));
	        } catch (JSONException e) {
	            e.printStackTrace();
	        }

	        if (throwable == null){
	            throwable = new Throwable("An error occured");
	        }


	        return throwable;
	    }

	    private Map<String, String> createQuery(){
	        query = new HashMap<>();
	        query.put("apiKey", mApiKey);
	        return query;
	    }


	    //Get Sources
	    public void getSources(RequestSource requestSource, final SourcesCallback callback){
	        query = createQuery();
	        query.put("category", requestSource.getCategory());
	        query.put("language", requestSource.getLanguage());
	        query.put("country", requestSource.getCountry());

	        query.values().removeAll(Collections.singleton(null));


	        mAPIService.getSources(query)
	                .enqueue(new Callback<SourcesResponse>() {
	                    @Override
	                    public void onResponse(Call<SourcesResponse> call, retrofit2.Response<SourcesResponse> response) {
	                        if (response.code() == HttpURLConnection.HTTP_OK){
	                            callback.onSuccess(response.body());
	                        }

	                        else{
	                            try {
	                                callback.onFailure(errMsg(response.errorBody().string()));
	                            } catch (IOException e) {
	                                e.printStackTrace();
	                            }
	                        }
	                    }

	                    @Override
	                    public void onFailure(Call<SourcesResponse> call, Throwable throwable) {
	                        callback.onFailure(throwable);
	                    }
	                });
	    }


	    public void getTopHeadlines(RequestTopHeadlines RequesttopHeadlines, final ArticlesResponseCallback callback){


	        query = createQuery();
	        query.put("country", RequesttopHeadlines.getCountry());
	        query.put("language", RequesttopHeadlines.getLanguage());
	        query.put("category", RequesttopHeadlines.getCategory());
	        query.put("sources", RequesttopHeadlines.getSources());
	        query.put("q", RequesttopHeadlines.getQ());
	        query.put("pageSize", RequesttopHeadlines.getPageSize());
	        query.put("page", RequesttopHeadlines.getPage());

	        query.values().removeAll(Collections.singleton(null));
	        query.values().removeAll(Collections.singleton("null"));


	        mAPIService.getTopHeadlines(query)
	                .enqueue(new Callback<ArticleResponse>() {
	                    @Override
	                    public void onResponse(Call<ArticleResponse> call, retrofit2.Response<ArticleResponse> response) {
	                        if (response.code() == HttpURLConnection.HTTP_OK){
	                            callback.onSuccess(response.body());
	                        }

	                        else{
	                            try {
	                                callback.onFailure(errMsg(response.errorBody().string()));
	                            } catch (IOException e) {
	                                e.printStackTrace();
	                            }
	                        }
	                    }

	                    @Override
	                    public void onFailure(Call<ArticleResponse> call, Throwable throwable) {
	                        callback.onFailure(throwable);
	                    }
	                });
	    }


	    public void getEverything(RequestEverything requestEverything, final ArticlesResponseCallback callback){
	        query = createQuery();
	        query.put("q", requestEverything.getQ());
	        query.put("sources", requestEverything.getSources());
	        query.put("domains", requestEverything.getDomains());
	        query.put("from", requestEverything.getFrom());
	        query.put("to", requestEverything.getTo());
	        query.put("language", requestEverything.getLanguage());
	        query.put("sortBy", requestEverything.getSortBy());
	        query.put("pageSize", requestEverything.getPageSize());
	        query.put("page", requestEverything.getPage());

	        query.values().removeAll(Collections.singleton(null));
	        query.values().removeAll(Collections.singleton("null"));

	        mAPIService.getEverything(query)
	                .enqueue(new Callback<ArticleResponse>() {
	                    @Override
	                    public void onResponse(Call<ArticleResponse> call, retrofit2.Response<ArticleResponse> response) {
	                        if (response.code() == HttpURLConnection.HTTP_OK){
	                            callback.onSuccess(response.body());
	                        }

	                        else{
	                            try {
	                                callback.onFailure(errMsg(response.errorBody().string()));
	                            } catch (IOException e) {
	                                e.printStackTrace();
	                            }
	                        }
	                    }

	                    @Override
	                    public void onFailure(Call<ArticleResponse> call, Throwable throwable) {
	                        callback.onFailure(throwable);
	                    }
	                });
	    }
	}


