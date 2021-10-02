package com.liuwq.demo.listener;

import org.springframework.context.ApplicationEvent;

public class MyEvent extends ApplicationEvent {
    private Long id;
    private String name;

    /**
     * Create a new ApplicationEvent.
     *
     * @param source the object on which the event initially occurred (never {@code null})
     */
    public MyEvent(Object source) {
        super(source);
    }

    public MyEvent(Object source, Long id, String name) {
        super(source);
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "MyEvent{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", source=" + source +
                '}';
    }
}
