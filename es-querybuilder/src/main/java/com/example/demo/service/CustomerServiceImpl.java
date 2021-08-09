package com.example.demo.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.apache.http.HttpHost;

import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.aggregations.bucket.terms.Terms;
import org.elasticsearch.search.aggregations.bucket.terms.TermsAggregationBuilder;
import org.elasticsearch.search.aggregations.metrics.Avg;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.model.Customer;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private ObjectMapper objectMapper;
	
	RestHighLevelClient client = new RestHighLevelClient(
			RestClient.builder(new HttpHost("localhost", 9200,"http")));
	
	@Override
	public List<Customer> findAllCustomerDetailsFromElastic()
	{
		SearchRequest searchRequest = new SearchRequest();
		searchRequest.indices("my-person");
		SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
		searchSourceBuilder.query(QueryBuilders.matchAllQuery()); 
		searchRequest.source(searchSourceBuilder);
		
		List<Customer> customerList = new ArrayList<>();
		SearchResponse searchResponse = null;
		try {
			searchResponse = client.search(searchRequest, RequestOptions.DEFAULT);		
			if(searchResponse.getHits().getTotalHits().value>0) {
				SearchHit[] searchHit = searchResponse.getHits().getHits();
				for(SearchHit hit : searchHit) {
					Map<String, Object> map = hit.getSourceAsMap();
					customerList.add(objectMapper.convertValue(map, Customer.class));
			}
		}
		} catch (IOException e) {
				e.printStackTrace();
		}
		return customerList;
	}

	@Override
	public List<Customer> findAllCustomerDataFromElastic(String firstName)
	{
		SearchRequest searchRequest = new SearchRequest();
		searchRequest.indices("my-person");
		SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
		searchSourceBuilder.query(QueryBuilders.termQuery("firstname", firstName));
		searchRequest.source(searchSourceBuilder);
		
		List<Customer> customerList = new ArrayList<>();
		SearchResponse searchResponse = null;
		try {
			searchResponse = client.search(searchRequest, RequestOptions.DEFAULT);		
			if(searchResponse.getHits().getTotalHits().value>0) {
				SearchHit[] searchHit = searchResponse.getHits().getHits();
				for(SearchHit hit : searchHit) {
					Map<String, Object> map = hit.getSourceAsMap();
					customerList.add(objectMapper.convertValue(map, Customer.class));
			}
		}
		} catch (IOException e) {
				e.printStackTrace();
		}
		return customerList;
	}

	@Override
	public List<Customer> findAllCustomerDataByNameAndAge(String firstName, int age)
	{
		SearchRequest searchRequest = new SearchRequest();
		searchRequest.indices("my-person");
		SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
		searchSourceBuilder.query(
				QueryBuilders.boolQuery()
				.must(QueryBuilders.termQuery("firstname.keyword", firstName))
				.must(QueryBuilders.matchQuery("age", age)));
		searchRequest.source(searchSourceBuilder);
		
		List<Customer> customerList = new ArrayList<>();
		SearchResponse searchResponse = null;
		try {
			searchResponse = client.search(searchRequest, RequestOptions.DEFAULT);		
			if(searchResponse.getHits().getTotalHits().value>0) {
				SearchHit[] searchHit = searchResponse.getHits().getHits();
				for(SearchHit hit : searchHit) {
					Map<String, Object> map = hit.getSourceAsMap();
					customerList.add(objectMapper.convertValue(map, Customer.class));
			}
		}
		} catch (IOException e) {
				e.printStackTrace();
		}
		return customerList;
	}

	@Override
	public ArrayList<HashMap> findAllCustomerDataByAggs() 
	{
		SearchRequest searchRequest = new SearchRequest();
		searchRequest.indices("my-person");
		SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
		TermsAggregationBuilder aggregation = AggregationBuilders.terms("aggs")
		        .field("firstname.keyword");
		aggregation.subAggregation(AggregationBuilders.avg("average_age")
		        .field("age"));
		searchSourceBuilder.aggregation(aggregation);
		searchRequest.source(searchSourceBuilder);		
		
		ArrayList<HashMap> list = new ArrayList();		
		SearchResponse searchResponse = null;
		try {
			searchResponse = client.search(searchRequest, RequestOptions.DEFAULT);		
			Terms agg = searchResponse.getAggregations().get("aggs");			
			for(Terms.Bucket entry : agg.getBuckets()) {
				String key = entry.getKeyAsString();            
			    long docCount = entry.getDocCount();
			    Avg avg = entry.getAggregations().get("average_age");	
			    double res = avg.getValue();
			    HashMap obj = new HashMap();
			    obj.put("Name",key);    
			    obj.put("count",docCount);
			    obj.put("Average", res);			    
			    list.add(obj);			    	   
			    System.out.print(obj); 	
			}
		    
		} catch (IOException e) {
				e.printStackTrace();
		}
		return list;
	}

}	

