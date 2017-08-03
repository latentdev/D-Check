package com.latentdev.d_check;

import java.util.Date;

/**
 * Created by Laten on 7/26/2017.
 */

public class FastPass {


    private Date start;
    private Date end;
    private boolean available;

    public Date getStart()
    {
        return this.start;
    }

    public void setStart(Date start)
    {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}
