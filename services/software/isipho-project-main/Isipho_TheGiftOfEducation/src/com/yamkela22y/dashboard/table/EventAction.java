package com.yamkela22y.dashboard.table;

import com.yamkela22y.dashboard.model.ModelStudent;

public interface EventAction {

    public void delete(ModelStudent student);

    public void update(ModelStudent student);
}
