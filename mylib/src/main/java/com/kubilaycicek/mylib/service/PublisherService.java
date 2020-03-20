package com.kubilaycicek.mylib.service;

import java.util.List;

import com.kubilaycicek.mylib.dto.PublisherDto;
import com.kubilaycicek.mylib.entity.Publisher;

public interface PublisherService {
	PublisherDto addPublisher(PublisherDto publisherDto);
	PublisherDto updatePublisher(PublisherDto publisherDto);
	List<Publisher> getAllPublisher();
	PublisherDto getByPublisherID(long publisherID);
	void removeByPublisherID(long publisherID);
}
