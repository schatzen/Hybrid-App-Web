package com.tj.booking;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.api.client.util.DateTime;
import com.google.api.services.calendar.Calendar;
import com.google.api.services.calendar.model.Event;
import com.google.api.services.calendar.model.EventDateTime;
import com.google.api.services.calendar.model.Events;

import dto.CalendarDto;
import service.GoogleCalendarService;
 
@Controller
public class CalendarAjaxController {
    
    private Logger logger = LoggerFactory.getLogger(CalendarAjaxController.class);
    
    // 老沥 单捞磐 贸府
    @RequestMapping(value="/calendarEventList.do", method=RequestMethod.POST)
    @ResponseBody
    public List<Event> calendarEventList(CalendarDto calDto) {
        logger.info("calendarEventList "+calDto.toString());
        
        List<Event> items = new ArrayList<Event>();
        try {
            com.google.api.services.calendar.Calendar service = GoogleCalendarService.getCalendarService();
            Events events = service.events().list(calDto.getCalendarId()).setOrderBy("startTime").setSingleEvents(true).execute();
            items = events.getItems();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return items;
    }
    
    // 老沥 历厘 贸府
    @RequestMapping(value="/calendarEventAdd.do", method=RequestMethod.POST)
    @ResponseBody
    public Map<String, Boolean> calendarEventAdd(CalendarDto calDto) {
        logger.info("calendarEventAdd "+calDto.toString());
        
        boolean isc = false;
        try {
            Calendar service = GoogleCalendarService.getCalendarService();
            Event event = new Event().setSummary(calDto.getSummary()).setDescription(calDto.getDescription());
            //矫累老
            DateTime startDateTime = new DateTime(calDto.getStartDateTime());
            EventDateTime start = new EventDateTime().setDateTime(startDateTime).setTimeZone("Asia/Seoul");
            event.setStart(start);
            //辆丰老
            DateTime endDateTime = new DateTime(calDto.getEndDateTime());
            EventDateTime end = new EventDateTime().setDateTime(endDateTime).setTimeZone("Asia/Seoul");
            event.setEnd(end);
            event = service.events().insert(calDto.getCalendarId(), event).execute();
            //event = service.events().insert("ycm6666@gmail.com", event).execute();
            isc = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        Map<String, Boolean> map = new HashMap<String, Boolean>();
        map.put("isc", isc);
        return map;
    }    
    
    // 老沥 昏力
    @RequestMapping(value="/calendarEventRemoveOne.do", method=RequestMethod.POST)
    @ResponseBody
    public Map<String, Boolean> calendarEventRemoveOne(CalendarDto calDto) {
        logger.info("calendarEventRemoveOne "+calDto.toString());
        
        boolean isc = false;
        try {
            Calendar service = GoogleCalendarService.getCalendarService();
            service.events().delete(calDto.getCalendarId(), calDto.getEventId()).execute();
            isc = true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        Map<String, Boolean> map = new HashMap<String, Boolean>();
        map.put("isc", isc);
        return map;
    }
    
    // 老沥 荐沥
    @RequestMapping(value="/calendarEventModify.do", method=RequestMethod.POST)
    @ResponseBody
    public Map<String, Boolean> calendarEventModify(CalendarDto calDto) {
        logger.info("calendarEventModify "+calDto.toString());
        
        boolean isc = false;
        try {
            Calendar service = GoogleCalendarService.getCalendarService();
            Event event = service.events().get(calDto.getCalendarId(), calDto.getEventId()).execute();
            event.setSummary(calDto.getSummary()).setDescription(calDto.getDescription());
            service.events().update(calDto.getCalendarId(), event.getId(), event).execute();
            isc = true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        Map<String, Boolean> map = new HashMap<String, Boolean>();
        map.put("isc", isc);
        return map;
    }
}


