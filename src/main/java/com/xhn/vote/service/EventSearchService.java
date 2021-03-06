package com.xhn.vote.service;

import com.xhn.vote.entity.Event;
import com.xhn.vote.search.Repository.EventRepository;
import org.elasticsearch.index.query.QueryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.mapping.IndexCoordinates;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import static org.elasticsearch.index.query.QueryBuilders.rangeQuery;

@Service
public class EventSearchService {
    @Autowired
    ElasticsearchRestTemplate restTemplate;
    @Autowired
    EventRepository eventRepository;
    public List<Event> findCommingEvent(){
        NativeSearchQuery searchQuery = new NativeSearchQueryBuilder()
                .withQuery(rangeQuery("date")
                        .gt(LocalDate.now().toString()))
                .build();
        SearchHits<Event> eventSearchHits = restTemplate.search(searchQuery,Event.class, IndexCoordinates.of("events"));
        return eventSearchHits.getSearchHits().stream().map(x->x.getContent()).collect(Collectors.toList());
    }
    public List<Event> findEventByName(String name){
        return eventRepository.findByName(name);
    }
}
