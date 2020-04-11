package com.kubilaycicek.mylib.converter;

import com.kubilaycicek.mylib.dto.PublisherDto;
import com.kubilaycicek.mylib.entity.Publisher;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class PublisherConverterImpl implements PublisherConverter {
    private final ModelMapper modelMapper;

    @Override
    public PublisherDto convertToPublisherDTO(Publisher publisher) {
        if (publisher == null)
            return null;
        return modelMapper.map(publisher, PublisherDto.class);
    }

    @Override
    public Publisher convertToPublisher(PublisherDto publisherDto) {
        if (publisherDto == null)
            return null;
        return modelMapper.map(publisherDto, Publisher.class);
    }
}
