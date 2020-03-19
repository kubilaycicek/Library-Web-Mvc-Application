package com.kubilaycicek.mylib.service.impl;

import com.kubilaycicek.mylib.converter.PublisherConverter;
import com.kubilaycicek.mylib.dto.PublisherDto;
import com.kubilaycicek.mylib.entity.Publisher;
import com.kubilaycicek.mylib.service.PublisherService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import com.kubilaycicek.mylib.repository.PublisherRepository;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class PublisherServiceImpl implements PublisherService {

    private final PublisherConverter publisherConverter;
    private final PublisherRepository publisherRepository;

    @Override
    public PublisherDto addPublisher(PublisherDto publisherDto) {
        Publisher publisher = publisherRepository.save(publisherConverter.convertToPublisher(publisherDto));
        return publisherConverter.convertToPublisherDTO(publisher);
    }

    @Override
    public PublisherDto updatePublisher(PublisherDto publisherDto) {
        Publisher publisher = publisherRepository.findFirstById(publisherDto.getId());
        if (publisher != null) {
            publisher.setName(publisherDto.getName());
            publisher.setDescription(publisherDto.getDescription());
        } else {
            throw new IllegalArgumentException("Publisher does not exist !");
        }
        return publisherConverter.convertToPublisherDTO(publisherRepository.save(publisher));
    }

    @Override
    public List<Publisher> getAllPublisher() {
        ArrayList<Publisher> list = new ArrayList<Publisher>();
        publisherRepository.findAll().iterator().forEachRemaining(publisher -> list.add(publisher));
        return list;
    }

    @Override
    public PublisherDto getByPublisherID(long publisherID) {
        return publisherConverter.convertToPublisherDTO(publisherRepository.findFirstById(publisherID));
    }

    @Override
    public void removeByPublisherID(long publisherID) {

        try{
            publisherRepository.deleteById(publisherID);
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }

    }
}
