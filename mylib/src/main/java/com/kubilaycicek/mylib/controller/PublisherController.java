package com.kubilaycicek.mylib.controller;

import com.kubilaycicek.mylib.constant.Mappings;
import com.kubilaycicek.mylib.dto.PublisherDto;
import com.kubilaycicek.mylib.service.PublisherService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping(Mappings.WEB_CONTROLLER_URL + Mappings.PUBLISHER_URL)
public class PublisherController {

    private final PublisherService publisherService;

    @RequestMapping(value = "list")
    public String list(Model model) {
        model.addAttribute("publishers", publisherService.getAllPublisher());
        return "publisher/publisher-list";
    }

    @RequestMapping(value = "new", method = RequestMethod.GET)
    public String showAddForm(@ModelAttribute(name = "publisherDto") PublisherDto publisherDto) {
        return "publisher/publisher-create";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String add(@ModelAttribute(name = "publisherDto") PublisherDto publisherDTO) {
        publisherService.addPublisher(publisherDTO);
        return "redirect:/web/publisher/list";
    }

    @GetMapping(value = "edit/{id}")
    public String showEditForm(@PathVariable("id") long id, Model model) {
        PublisherDto publisherDto = publisherService.getByPublisherID(id);
        if (publisherDto != null)
            model.addAttribute("publisherDto", publisherDto);
        else
            return "404";
        return "publisher/publisher-edit";
    }

    @PostMapping(value = "/update")
    public String update(@ModelAttribute(name = "publisherDto") PublisherDto publisherDto) {
        publisherService.updatePublisher(publisherDto);
        return "redirect:/web/publisher/list";
    }

    @GetMapping(value = "/delete/{id}")
    public String delete(@PathVariable("id") long id) {
        publisherService.removeByPublisherID(id);
        return "redirect:/web/publisher/list";
    }
}