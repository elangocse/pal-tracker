package io.pivotal.pal.tracker;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryTimeEntryRepository implements TimeEntryRepository{

    private long currentId = 1l;
    private Map<Long, TimeEntry> timeEntries = new HashMap<>();

    public TimeEntry create(TimeEntry timeEntryToCreate) {

        TimeEntry timeEntry = new TimeEntry(
                currentId,
                timeEntryToCreate.getProjectId(),
                timeEntryToCreate.getUserId(),
                timeEntryToCreate.getDate(),
                timeEntryToCreate.getHours()
        );

        timeEntries.put(currentId, timeEntry);

        currentId +=1;

        return timeEntry;
    }


@Override
    public TimeEntry find(long id) {

        return timeEntries.get(id);
    }

    @Override
    public List<TimeEntry> list() {
        return new ArrayList(timeEntries.values());
    }


    public void delete(Object id) {

        timeEntries.remove(id);

    }



    @Override
    public TimeEntry update(long eq, TimeEntry timeEntryToUpdate) {
        TimeEntry timeEntry = new TimeEntry(
                eq,
                timeEntryToUpdate.getProjectId(),
                timeEntryToUpdate.getUserId(),
                timeEntryToUpdate.getDate(),
                timeEntryToUpdate.getHours()
        );

        timeEntries.put(eq, timeEntry);


        return timeEntry;
    }

    @Override
    public void delete(Long l) {
        timeEntries.remove(l);
    }


}
