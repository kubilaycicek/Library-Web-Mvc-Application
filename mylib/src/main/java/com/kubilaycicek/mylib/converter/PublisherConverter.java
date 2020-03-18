package com.kubilaycicek.mylib.converter;

import com.kubilaycicek.mylib.dto.PublisherDto;
import com.kubilaycicek.mylib.entity.Publisher;

public interface PublisherConverter {
    PublisherDto convertToPublisherDTO(Publisher publisher);
    Publisher convertToPublisher(PublisherDto publisherDto);
}
