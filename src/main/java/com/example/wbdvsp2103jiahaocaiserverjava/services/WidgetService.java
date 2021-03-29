package com.example.wbdvsp2103jiahaocaiserverjava.services;

import com.example.wbdvsp2103jiahaocaiserverjava.models.Widget;
import com.example.wbdvsp2103jiahaocaiserverjava.repositories.WidgetRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WidgetService {

    @Autowired
    WidgetRepository repository;

    // implement crud operations
    public Widget createWidgetForTopic(Widget widget) {
        return repository.save(widget);
    }

    public List<Widget> findAllWidgets() {
        return repository.findAllWidgets();
    }

    public List<Widget> findAllWidgetsForTopic(String topicId) {
        return repository.findAllWidgetsForTopic(topicId);
    }

    public Widget findWidgetById(Long id) {
        return repository.findWidgetById(id);
    }

    public Integer updateWidget(Long id, Widget widget) {
        Widget originalWidget = repository.findWidgetById(id);
        // copy constructor!!!
        originalWidget.copyWidget(widget);
        repository.save(originalWidget);
        return 1;
    }

    public Integer deleteWidget(Long id) {
        repository.deleteById(id);
        return 1;
    }

}

