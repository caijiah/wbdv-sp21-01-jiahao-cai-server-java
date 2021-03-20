package com.example.wbdvsp2103jiahaocaiserverjava.services;

import com.example.wbdvsp2103jiahaocaiserverjava.models.Widget;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class WidgetService {
    private List<Widget> widgets = new ArrayList<Widget>();
    {
      Widget w1 = new Widget(123L, "ABC123", "HEADING", 1, "Welcome to Widgets.");
      Widget w2 = new Widget(234l, "ABC123", "PARAGRAPH", 1, "Lorem Ipsum");
      Widget w3 = new Widget(345L, "ABC234", "PARAGRAPH", 1, "This is a paragraph.");
      Widget w4 = new Widget(456L, "ABC234", "HEADING", 2, "Welcome to WebDev.");
      Widget w5 = new Widget(567L, "ABC234", "PARAGRAPH", 1, "Lorem ipsum.");
      widgets.add(w1);
      widgets.add(w2);
      widgets.add(w3);
      widgets.add(w4);
      widgets.add(w5);
    }

    // implement crud operations
    public Widget createWidgetForTopic(String topicId, Widget widget) {
      Long id = (new Date()).getTime();
      widget.setId(id);
      widget.setTopicId(topicId);
      widgets.add(widget);
      return widget;
    }

    public List<Widget> findAllWidgets() {
      return widgets;
    }

    public List<Widget> findAllWidgetsForTopic(String topicId) {
        List<Widget> ws = new ArrayList<Widget>();
        for (Widget w : widgets) {
            if (w.getTopicId().equals(topicId)) {
              ws.add(w);
            }
        }
      return ws;
    }

    public Widget findWidgetById(Long id) {
      for (Widget w : widgets) {
        if (w.getId().equals(id)) {
          return w;
        }
      }
      return null;
    }

    public Integer updateWidget(Long id, Widget widget) {
        for (int i=0; i < widgets.size(); i++) {
            if (widgets.get(i).getId().equals(id)) {
                widgets.set(i, widget);
                return 1;
            }
        }
        return -1;
    }

    public Integer deleteWidget(Long id) {
      int index = -1;
      for (int i=0; i < widgets.size(); i++) {
          if (widgets.get(i).getId().equals(id)) {
              index = i;
              widgets.remove(index);
              return -1;
          }
      }
      return 1;
    }

}

